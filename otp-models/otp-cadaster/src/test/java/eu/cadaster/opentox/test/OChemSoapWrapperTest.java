package eu.cadaster.opentox.test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import org.junit.Test;
import org.opentox.dsl.OTDatasets;
import org.opentox.dsl.task.FibonacciSequence;
import org.opentox.dsl.task.RemoteTask;
import org.opentox.rdf.OT;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Reference;
import org.restlet.representation.StringRepresentation;

import qspr.services.ModelServiceStub;
import qspr.services.ModelServiceStub.GetModelName;
import qspr.services.ModelServiceStub.ModelResponse;
import qspr.services.ModelServiceStub.Prediction;
import qspr.services.ModelServiceStub.PropertyPrediction;

import com.hp.hpl.jena.ontology.OntModel;

import eu.cadaster.opentox.CadasterModel;
import eu.cadaster.opentox.OChemSOAPWrapper;

public class OChemSoapWrapperTest {
	
	@Test
	public void testMulti() throws Exception {
		int n = 50;
		long[] runs = new long[n];
		Exception[] x = new Exception[n];
		long sum = 0;
		int err = 0;
		for(int i=0; i < n; i++) {
			try {
				runs[i] = run();
			} catch (Exception xx) {
				x[i] = xx;
				err++;
			}
			sum +=runs[i];
		}
		System.out.println("Runs\n");
		for (double run:runs)
			System.out.println(run);
		System.out.println("Err\t" + err);
		System.out.println("Avg\t"+(double)sum/(double)n);		

	}
	
	
	@Test
	public void getAll() throws Exception {
		OChemSOAPWrapper wrapper = new OChemSOAPWrapper();
		ModelServiceStub client = new ModelServiceStub();
		long[] models = wrapper.getAllModels(client);
		Arrays.sort(models);
		for (long model:models) {
			System.out.println(String.format("cadaster%d=eu.cadaster.opentox.CadasterModel",model));
			GetModelName getModelNameArg = new GetModelName();
			getModelNameArg.setPublicModelID(model);
			String name = client.getModelName(getModelNameArg).get_return();
			System.out.println("#" + model+" - "+name);
		}
	}
	@Test
	public void test() throws Exception {
		String search = "benzene";//"hydrazine";
		OTDatasets d = OTDatasets.datasets(String.format("%s/url/names?search=%s&max=1",
				//"http://apps.ideaconsult.net:8080/ambit2/query/compound/search"
				"http://nina.ideaconsult.net:8080/ambit2/query/compound/search"
				,search));
		d.read();
		OChemSOAPWrapper wrapper = new OChemSOAPWrapper();
		ModelServiceStub client= new ModelServiceStub();
		CadasterModel model = new CadasterModel(24);
		Long taskID = wrapper.applyModel(model,new URL(d.getItem(0).getUri().toString()));
		if (taskID>0) {
			OntModel jenamodel = wrapper.poll(client,taskID, 100000,new URL(d.getItem(0).getUri().toString()),model);
			client.cleanup();
			ByteArrayOutputStream o = new ByteArrayOutputStream();
			OT.write(jenamodel, o, MediaType.APPLICATION_RDF_XML, true);
			System.out.println(o);
			
			RemoteTask task = new RemoteTask(
					new Reference("http://nina.ideaconsult.net:8080/ambit2/dataset"),
					MediaType.TEXT_URI_LIST,
					new StringRepresentation(o.toString(),MediaType.APPLICATION_RDF_XML),
					Method.POST
				);
			while (!task.isDone())
				task.poll();
			System.out.println(task);
			
		}
		
	}
	public long run() throws Exception {
		InputStream in = getClass().getClassLoader().getResourceAsStream("tmp.sdf");
		OChemSOAPWrapper wrapper = new OChemSOAPWrapper();
		Long taskID = wrapper.applyModel(24L,in);
		in.close();
		
		ModelResponse response = null;
		FibonacciSequence sequence = new FibonacciSequence();
		ModelServiceStub client = new ModelServiceStub();
		long now = System.currentTimeMillis();
		long pollInterval = 5000;
		long pollTimeout = 100000;
		while ((response==null) || OChemSOAPWrapper.TaskStatus.pending.toString().equals(response.getStatus())) {
			//if (response!=null) wrapper.printResult(response,true);
			response = wrapper.queryTask(client,taskID);	
			
			long l = sequence.sleepInterval(pollInterval,true,1000 * 60 * 5);
			Thread.sleep(l); 				
			Thread.yield();
			if ((System.currentTimeMillis()-now) > pollTimeout)  
				throw new Exception("Timeout");
		}
		client.cleanup();
		if (response!=null) {
			if (OChemSOAPWrapper.TaskStatus.success.toString().equals(response.getStatus())) {
				Prediction preds[] = response.getPredictions();
				if (null != response.getPredictions()) {
					for (Prediction pred : preds) {
						System.out.println(pred.getError());
						PropertyPrediction[] proppreds = pred.getPredictions();
						for (PropertyPrediction propred : proppreds) {
							System.out.println(propred.getError());
							System.out.println(propred.getProperty());
							System.out.println(propred.getUnit());
							System.out.println(propred.getAccuracy());
							System.out.println(propred.getRealValue());
							System.out.println(propred.getMoleculeId());
						}
					}
				}
			}
			//wrapper.printResult(response,true);
			
		}
		return System.currentTimeMillis()-now;
	}
}
