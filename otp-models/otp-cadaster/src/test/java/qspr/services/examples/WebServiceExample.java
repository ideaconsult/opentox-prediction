package qspr.services.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import qspr.services.ModelServiceStub;
import qspr.services.ModelServiceStub.ApplyModelSingleSDF;
import qspr.services.ModelServiceStub.ApplyModelSingleSDFResponse;
import qspr.services.ModelServiceStub.ModelResponse;
import qspr.services.ModelServiceStub.Prediction;
import qspr.services.ModelServiceStub.PropertyPrediction;

public class WebServiceExample 
{
	public static void main(String[] args) throws Exception {
		ModelServiceStub client = new ModelServiceStub();
		ApplyModelSingleSDF arg = new ApplyModelSingleSDF();
		String sdf = readSdfFromFile("tmp.sdf");
		arg.setModelId(47L);
		arg.setSdf(sdf);
		ApplyModelSingleSDFResponse response = client.applyModelSingleSDF(arg);

		ModelResponse mr = response.get_return();
		if (!mr.getStatus().equals("success"))
			throw new IOException(mr.getStatus());
		
		for (Prediction prediction : mr.getPredictions())  {
			if (prediction.getError() != null) 	{
				System.out.println(prediction.getError());
			}
			else {
				PropertyPrediction[] properties = prediction.getPredictions();
				for (PropertyPrediction propertyPrediction :properties) {
					System.out.println("Prediction for " + propertyPrediction.getProperty() + 
							" is " + propertyPrediction.getValue() + " " 
							+ propertyPrediction.getUnit()  + " Accuracy:" +
							propertyPrediction.getAccuracy()  + " In domain:" +
							propertyPrediction.getInAd()  
							);
				}
			}
		}
		
	}
	
	private static String readSdfFromFile(String path) throws Exception {
		InputStream in = null;
		try {
			in = WebServiceExample.class.getClassLoader().getResourceAsStream(path);
			StringBuffer sdf = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null)
				sdf.append(line+"\n");
			br.close();
			return sdf.toString();
		} catch (Exception x) {
			throw x;
		} finally {
			if (in !=null) in.close();
		}
	}
}
