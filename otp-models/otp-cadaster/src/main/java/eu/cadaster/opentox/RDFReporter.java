package eu.cadaster.opentox;

import org.opentox.rdf.OT;
import org.opentox.rdf.OT.DataProperty;
import org.opentox.rdf.OT.OTClass;
import org.opentox.rdf.OT.OTProperty;

import qspr.services.ModelServiceStub.ModelResponse;
import qspr.services.ModelServiceStub.Prediction;
import qspr.services.ModelServiceStub.PropertyPrediction;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.vocabulary.DC;
import com.hp.hpl.jena.vocabulary.OWL;

public class RDFReporter {

	public RDFReporter() {
		
	}
	public OntModel process(String compoundURI,CadasterModel cmodel, ModelResponse response) throws Exception {
		String modelURI = cmodel.getUri();
		OntModel model = OT.createModel();
		Individual m = model.createIndividual(modelURI==null?null:modelURI.toString().trim(),OTClass.Model.createOntClass(model));
		model.add(m,DC.title,response.getModelDescriptionUrl());
		Individual d = model.createIndividual(OTClass.Dataset.createOntClass(model));
		
		Individual de = model.createIndividual(OTClass.DataEntry.createOntClass(model));
		model.add(d,OTProperty.dataEntry.createProperty(model),de);
		Individual c = model.createIndividual(compoundURI,OTClass.Compound.createOntClass(model));
		model.add(de,OTProperty.compound.createProperty(model),c);
		Prediction preds[] = response.getPredictions();
		if (null != response.getPredictions()) {
			for (Prediction pred : preds) {
				//System.out.println(pred.getError());
				PropertyPrediction[] proppreds = pred.getPredictions();
				//handle error
				for (PropertyPrediction propred : proppreds) {
					//value

					//TODO units & app domain
					Individual fv = getFeature(
							model, m, 
							null,
							propred.getProperty(), propred.getUnit(), propred.getValue(), cmodel.getEndpoint());
					model.add(de,OTProperty.values.createProperty(model),fv);
					fv = getFeature(model, m,
							null,
							String.format("%s_ACCURACY",propred.getProperty()), null, propred.getAccuracy(),null);
					model.add(de,OTProperty.values.createProperty(model),fv);
					fv = getFeature(model, m,
							null,
							String.format("%s_INAPPDOMAIN",propred.getProperty()), null, propred.getInAd()?"YES":"NO");
					model.add(de,OTProperty.values.createProperty(model),fv);
				}
			}
		}
		return model;
	}
	
	protected Individual getFeature(OntModel model,  Individual m, String uri, String property, String units, double value,String endpoint) throws Exception {
		Individual fv = model.createIndividual(OTClass.FeatureValue.createOntClass(model));
		Individual f = model.createIndividual(uri,OTClass.Feature.createOntClass(model));
		model.add(f,DC.title,property);
		model.add(f,OTProperty.hasSource.createProperty(model),m);
		if (units!=null) model.add(f,DataProperty.units.createProperty(model),units);
		model.add(fv,OTProperty.feature.createProperty(model),f);
		model.add(fv,DataProperty.value.createProperty(model),model.createTypedLiteral(value));
		
		if (endpoint!=null) {
			model.add(fv,OWL.sameAs,model.createTypedLiteral(value));
		}
	   
		return fv;
	}
	
	protected Individual getFeature(OntModel model,  Individual m, String uri, String property, String units, String value) throws Exception {
		Individual fv = model.createIndividual(OTClass.FeatureValue.createOntClass(model));
		Individual f = model.createIndividual(uri,OTClass.Feature.createOntClass(model));
		model.add(f,DC.title,property);
		model.add(f,OTProperty.hasSource.createProperty(model),m);
		if (units!=null) model.add(f,DataProperty.units.createProperty(model),units);
		model.add(fv,OTProperty.feature.createProperty(model),f);
		model.add(fv,DataProperty.value.createProperty(model),model.createTypedLiteral(value));
		return fv;
	}

}
