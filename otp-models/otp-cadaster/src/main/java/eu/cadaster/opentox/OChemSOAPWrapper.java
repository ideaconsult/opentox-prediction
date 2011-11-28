package eu.cadaster.opentox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import net.idea.restnet.c.ChemicalMediaType;

import org.apache.axis.AxisFault;
import org.opentox.dsl.task.ClientResourceWrapper;
import org.opentox.dsl.task.FibonacciSequence;
import org.restlet.data.Reference;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import qspr.services.ModelServiceLocator;
import qspr.services.ModelServicePortType;
import qspr.services.xsd.ModelResponse;
import qspr.services.xsd.Prediction;
import qspr.services.xsd.PropertyPrediction;

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
	public Long applyModel(Long modelID, Reference url) throws Exception {
		String sdf = readSDF(url.toString());
		return applyModel(24L,sdf);
	}

	public Long applyModel(Long modelID, String sdf) throws Exception {
		try {
			ModelServicePortType stub  = getService();

			ModelResponse modelResponse = stub.postModelSingleSDF(modelID, sdf);
			return modelResponse.getTaskId();
		} catch (AxisFault e) {
			throw e;
		} catch (RemoteException e) {
			throw e;
		}
	}
	public OntModel poll(Long taskID, long pollTimeout,Reference compound) throws Exception {
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
				return reporter.process(compound.toString(),response);
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
	public void printResult(ModelResponse modelResponse, boolean fetch) {

		if (fetch) System.out.println("Fetching task ...");
		else System.out.println("Posting request ...");
		System.out.println();
		System.out.println("STATUS:                " + modelResponse.getStatus());
		if (fetch) {
			if (modelResponse.getStatus().equals("success")) {
				System.out.println("MODEL-URL:             " + modelResponse.getModelDescriptionUrl());
				if (null != modelResponse.getPredictions()) {
					System.out.println();
					System.out.println("MODEL RESPONSE:");
					//
					Prediction preds[] = modelResponse.getPredictions();
					System.out.println("| Property                     | Predicted value              | Unit                         | Accuracy                     |");
					for (int i = 0; i < preds.length; i++) {
						PropertyPrediction proppred[] = preds[i].getPredictions();
						if (null == preds[i].getError() && null != proppred) {
							for (int j = 0; j < proppred.length; j++) {
								String property = addWhiteSpace(proppred[j].getProperty());
								String value = addWhiteSpace(proppred[j].getValue() + "");
								String unit = addWhiteSpace(proppred[j].getUnit());
								String accuracy = addWhiteSpace(proppred[j].getAccuracy() + "");
								System.out.println("|" + property + "|" + value + "|" + unit + "|" + accuracy + "|");
							}
						}
						else if (null != preds[i].getError()) {
							System.out.println("\t" + preds[i].getError());
						}
						else {
							System.out.println("*** UNEXPECTED ERROR ***");
						}
					}
				}
			}
		}
		else
			System.out.println("TASK-ID:               " + modelResponse.getTaskId());
	}
	
	public static String addWhiteSpace(String str) {
		str = str + " ";
		while (str.length() < 30)
			str = " " + str;
		return str;
	}	
	private ModelServicePortType getService() throws ServiceException
	{

		ModelServiceLocator locator = new ModelServiceLocator();
		ModelServicePortType service = locator.getModelServiceHttpSoap11Endpoint();
		return service;
	}
	
	 public String readSDF(String uri) throws Exception {
			HttpURLConnection uc= null;
			InputStream in= null;
			int code = 0;
			try {
				uc = ClientResourceWrapper.getHttpURLConnection(uri, "GET", ChemicalMediaType.CHEMICAL_MDLSDF.toString());
				
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
