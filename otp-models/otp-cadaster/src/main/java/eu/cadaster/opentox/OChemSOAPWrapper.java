package eu.cadaster.opentox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;

import net.idea.restnet.c.ChemicalMediaType;

import org.apache.axis2.AxisFault;
import org.opentox.dsl.task.ClientResourceWrapper;
import org.opentox.dsl.task.FibonacciSequence;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import qspr.services.ModelServiceStub;
import qspr.services.ModelServiceStub.ApplyModelSingleSDF;
import qspr.services.ModelServiceStub.ApplyModelSingleSDFWithUnits;
import qspr.services.ModelServiceStub.ApplyModelSingleSDFWithUnitsResponse;
import qspr.services.ModelServiceStub.ModelResponse;

import com.hp.hpl.jena.ontology.OntModel;

public class OChemSOAPWrapper {
	public enum TaskStatus {
		success,
		pending
	}
	public OChemSOAPWrapper() {
		
	}
	public Long applyModel(Long modelID, InputStream in) throws Exception {
		return applyModel(modelID, readSDF(in));
	}
	public Long applyModel(CadasterModel model, URL url) throws Exception {
		String sdf = readSDF(url);
		return applyModel(model.getModelID(),sdf);
	}

	public Long applyModel(Long modelID, String sdf) throws Exception {
		try {
			ModelServiceStub client = new ModelServiceStub();
			ApplyModelSingleSDFWithUnits arg = new ApplyModelSingleSDFWithUnits();
			arg.setModelId(modelID);
			arg.setSdf(sdf);
			ApplyModelSingleSDFWithUnitsResponse response = client.applyModelSingleSDFWithUnits(arg);
			
			return response.getTaskId();
		} catch (AxisFault e) {
			throw e;
		} catch (RemoteException e) {
			throw e;
		}
	}
	public OntModel poll(Long taskID, long pollTimeout,URL compound, CadasterModel model) throws Exception {
		ModelResponse response = null;
		FibonacciSequence sequence = new FibonacciSequence();

		long now = System.currentTimeMillis();
		long pollInterval = 5000;
		while ((response==null) || OChemSOAPWrapper.TaskStatus.pending.toString().equals(response.getStatus())) {
			response = queryTask(taskID);	
			long l = sequence.sleepInterval(pollInterval,true,1000 * 60 * 5);
			Thread.sleep(l); 				
			Thread.yield();
			if ((System.currentTimeMillis()-now) > pollTimeout)  
				throw new Exception("Timeout");
		}
		if (response!=null) {
			if (OChemSOAPWrapper.TaskStatus.success.toString().equals(response.getStatus())) {
				RDFReporter reporter = new RDFReporter();
				return reporter.process(compound.toString(),model.getUri(), response);
			} else return null;
		}
		return null;
	}	
	
	public ModelResponse queryTask(Long taskID) throws Exception {
		try {
			ModelServicePortType stub  = getService();
			return stub.fetchModel(taskID);

		} catch (AxisFault e) {
			throw e;
		} catch (RemoteException e) {
			throw e;
		}		
	}
	
	
	public String readSDF(InputStream in) throws Exception {
		StringBuilder content = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(in));
			String line = null; 
			while ((line = br.readLine()) != null) {
				content.append(line);
				content.append("\n");
			}
		} finally {
			try {br.close();} catch (Exception x) {}
		}
		return content.toString();

	}
	
	
	private ModelServicePortType getService() throws ServiceException
	{

		ModelServiceLocator locator = new ModelServiceLocator();
		ModelServicePortType service = locator.getModelServiceHttpSoap11Endpoint();
		return service;
	}
	
	public long[] getAllModels() throws Exception {
		return getService().getModelIDs("", ""); 	
	}
	
	 public String readSDF(URL uri) throws Exception {
			HttpURLConnection uc= null;
			InputStream in= null;
			int code = 0;
			try {
				uc = ClientResourceWrapper.getHttpURLConnection(uri.toString(), "GET", ChemicalMediaType.CHEMICAL_MDLSDF.toString());
				
				code = uc.getResponseCode();
				if (HttpURLConnection.HTTP_OK == code) {
					in = uc.getInputStream();		
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					String line = null;
					StringBuilder b = new StringBuilder();
					while ((line = reader.readLine())!=null) {
						b.append(line);
						b.append("\n");
					}
					return b.toString();
				}
				return null;
			} catch (IOException x) {
				if (code > 0) throw new ResourceException(new Status(code),x);
				else throw x;
			} catch (Exception x) {
				throw x;
			} finally {
				try { if (in !=null) in.close();} catch (Exception x) {}
				try { if (uc != null) uc.disconnect();} catch (Exception x) {}
			}
		}
	
}
