package org.opentox.wrapper;

import java.io.Writer;
import java.util.Iterator;
import java.util.UUID;

import net.idea.modbcum.i.exceptions.AmbitException;
import net.idea.modbcum.i.reporter.Reporter;
import net.idea.restnet.c.ResourceDoc;
import net.idea.restnet.c.html.HTMLBeauty;
import net.idea.restnet.c.resource.TaskResource;
import net.idea.restnet.c.task.FactoryTaskConvertor;
import net.idea.restnet.i.task.ITaskStorage;
import net.idea.restnet.rdf.reporter.TaskRDFReporter;

import org.restlet.Request;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;

public class OTTaskResource extends TaskResource<String> {

	
	@Override
	protected FactoryTaskConvertor getFactoryTaskConvertor(ITaskStorage storage)
			throws ResourceException {
		return new FactoryTaskConvertor(storage,getHTMLBeauty()) {
			@Override
			public synchronized Reporter<Iterator<UUID>,Writer> createTaskReporterRDF(
					Variant variant, Request request,ResourceDoc doc) throws AmbitException, ResourceException {
				return new TaskRDFReporter(storage,request,variant.getMediaType(),doc);
		   }	
		};
		
	}

	@Override
	protected HTMLBeauty getHTMLBeauty() {
		return new OTHTMLBeauty();
	}
}
