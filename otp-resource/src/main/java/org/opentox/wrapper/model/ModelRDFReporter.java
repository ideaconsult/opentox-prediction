package org.opentox.wrapper.model;

import java.io.Writer;
import java.util.Iterator;

import net.idea.restnet.c.ResourceDoc;
import net.idea.restnet.c.reporters.CatalogURIReporter;
import net.idea.restnet.rdf.ns.OT;
import net.idea.restnet.rdf.reporter.CatalogRDFReporter;

import org.opentox.wrapper.algorithm.Algorithm;
import org.restlet.Request;
import org.restlet.data.MediaType;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.vocabulary.DC;

/**
 * RDF output for {@link Algorithm}
 * @author nina
 *
 */
public class ModelRDFReporter extends CatalogRDFReporter<Model> {
	protected CatalogURIReporter<Model> reporter;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2332767360556001891L;
	public ModelRDFReporter(Request request,MediaType mediaType,ResourceDoc doc) {
		super(request,mediaType,doc);
		reporter =  new  CatalogURIReporter<Model>(request,doc);
	}
	@Override
	public void processItem(Model item, Writer output) {

		Individual model = getJenaModel().createIndividual(reporter.getURI(item).trim(),
				OT.OTClass.Model.getOntClass(getJenaModel()));
		
		model.addProperty(DC.title, item.getTitle());

		//
		//model.addProperty(DC.date,"N/A");
		//model.addProperty(DC.format,"N/A");
		
		model.addProperty(DC.creator,item.getCreator());
		
		if (item.getAlgorithm()!=null) {
			Individual algorithm ;
			if (item.getAlgorithm().getUri()==null) {
				algorithm = getJenaModel().createIndividual(OT.OTClass.Algorithm.getOntClass(getJenaModel()));
			} else 
				algorithm = getJenaModel().createIndividual(item.getAlgorithm().getUri(),
					OT.OTClass.Algorithm.getOntClass(getJenaModel()));
			model.addProperty(OT.OTProperty.algorithm.createProperty(getJenaModel()), algorithm);
		}
		
		/*
		if (item.getTrainingInstances()!=null) {
			Individual dataset = getJenaModel().createIndividual(item.getTrainingInstances(),
					OT.OTClass.Dataset.getOntClass(getJenaModel()));
			model.addProperty(OT.OTProperty.trainingDataset.createProperty(getJenaModel()), dataset);
		}
		
		readProperties(new Reference(String.format("%s/independent",uriReporter.getURI(item))), 
					OT.OTProperty.independentVariables.createProperty(getJenaModel()), model);
		readProperties(new Reference(String.format("%s/dependent",uriReporter.getURI(item))), 
					OT.OTProperty.dependentVariables.createProperty(getJenaModel()), model);
		readProperties(new Reference(String.format("%s/predicted",uriReporter.getURI(item))), 
					OT.OTProperty.predictedVariables.createProperty(getJenaModel()), model,OT.OTClass.ModelPredictionFeature);
		*/
	}
	
	@Override
	public void header(Writer output, Iterator<Model> query) {
		super.header(output, query);
		try {
			getJenaModel().setNsPrefix("bo","http://www.blueobelisk.org/ontologies/chemoinformatics-algorithms/#");
			getJenaModel().setNsPrefix("bo1","http://ambit.sourceforge.net/descriptors.owl#");
		} catch (Exception x) {
			x.printStackTrace();
		}
		OT.OTClass.Model.createOntClass(getJenaModel());
		OT.OTClass.Algorithm.createOntClass(getJenaModel());
		OT.OTClass.Feature.createOntClass(getJenaModel());
		OT.OTClass.Parameter.createOntClass(getJenaModel());
		OT.OTClass.Dataset.createOntClass(getJenaModel());
		
		getJenaModel().createAnnotationProperty(DC.title.getURI());
		getJenaModel().createAnnotationProperty(DC.description.getURI());
		getJenaModel().createAnnotationProperty(DC.type.getURI());
		getJenaModel().createAnnotationProperty(DC.creator.getURI());
		getJenaModel().createAnnotationProperty(DC.format.getURI());
		getJenaModel().createAnnotationProperty(DC.date.getURI());

	}


	

}
