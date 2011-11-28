package qspr.services.examples;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import qspr.services.ModelServiceLocator;
import qspr.services.ModelServicePortType;
import qspr.services.xsd.ModelResponse;
import qspr.services.xsd.Prediction;
import qspr.services.xsd.PropertyPrediction;

public class WebServiceExample 
{
	public static void main(String[] args) throws ServiceException, RemoteException 
	{
		ModelServiceLocator locator = new ModelServiceLocator();
		ModelServicePortType service = locator.getModelServiceHttpSoap11Endpoint();
		
		// Invoke the prediction service
		ModelResponse response = service.applyModelSingleSDF(1L, "CCCCC"); // Here we use a SMILES, but any SDF file will work
		
		// Print the results
		System.out.println("Status: " + response.getStatus());
		if ("success".equals(response.getStatus()))
		{
			for (Prediction prediction : response.getPredictions()) 
			{
				for (PropertyPrediction propertyPrediction : prediction.getPredictions()) {
					System.out.println("Prediction for " + propertyPrediction.getProperty() + " is " + propertyPrediction.getValue());
				}
			}
		}
	}
}
