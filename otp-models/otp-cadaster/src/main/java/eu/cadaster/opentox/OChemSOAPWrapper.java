package eu.cadaster.opentox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.idea.restnet.c.ChemicalMediaType;

import org.opentox.dsl.task.ClientResourceWrapper;
import org.opentox.dsl.task.FibonacciSequence;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import qspr.services.ModelServiceStub;
import qspr.services.ModelServiceStub.FetchModel;
import qspr.services.ModelServiceStub.GetModelIDs;
import qspr.services.ModelServiceStub.ModelResponse;
import qspr.services.ModelServiceStub.PostModel;

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
		if (sdf==null) throw new Exception("Error reading sdf from "+url);
		return applyModel(model.getModelID(),sdf);
	}

	public Long applyModel(Long modelID, String sdf) throws Exception {
		ModelServiceStub client = null;
		try {
			client = new ModelServiceStub();
			PostModel postModelArg = new PostModel();
			String[] sdfs = new String[] {sdf}; 
			//We should ensure single molecule per array item
			postModelArg.setModelId(modelID);
			postModelArg.setSdfs(sdfs);
			ModelResponse postModelResp = client.postModel(postModelArg).get_return();
			return postModelResp.getTaskId();
		} catch (Exception e) {
			throw e;
		} finally {
			try { client.cleanup(); } catch (Exception x) {}
		}
	}
	public OntModel poll(ModelServiceStub client,Long taskID, long pollTimeout,URL compound, CadasterModel model) throws Exception {
		ModelResponse response = null;
		FibonacciSequence sequence = new FibonacciSequence();

		long now = System.currentTimeMillis();
		long pollInterval = 5000;
		while ((response==null) || OChemSOAPWrapper.TaskStatus.pending.toString().equals(response.getStatus())) {
			response = queryTask(client,taskID);	
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
	
	public ModelResponse queryTask(ModelServiceStub client,Long taskID) throws Exception {
		try {
			FetchModel fetchModelArg = new FetchModel();
			fetchModelArg.setTaskId(taskID);
			return client.fetchModel(fetchModelArg).get_return(); 
		} catch (Exception e) {
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
	
	
	
	public long[] getAllModels(ModelServiceStub client) throws Exception {
		GetModelIDs getModelIdsArg = new GetModelIDs();
		getModelIdsArg.setSessionId(""); //Optional
		getModelIdsArg.setQueryOnName(""); //Optional
		return client.getModelIDs(getModelIdsArg).get_return();
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
				} else throw new ResourceException(new Status(code),uc.getResponseMessage());
			} catch (IOException x) {
				if (code > 0) throw new ResourceException(new Status(code));
				else throw x;
			} catch (Exception x) {
				throw x;
			} finally {
				try { if (in !=null) in.close();} catch (Exception x) {}
				try { if (uc != null) uc.disconnect();} catch (Exception x) {}
			}
		}
	
}
