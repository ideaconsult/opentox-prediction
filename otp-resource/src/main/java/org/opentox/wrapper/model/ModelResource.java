package org.opentox.wrapper.model;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import net.idea.modbcum.i.exceptions.AmbitException;
import net.idea.modbcum.i.processors.IProcessor;
import net.idea.modbcum.i.reporter.Reporter;
import net.idea.restnet.c.StringConvertor;
import net.idea.restnet.c.html.HTMLBeauty;
import net.idea.restnet.c.resource.CatalogResource;
import net.idea.restnet.c.task.FactoryTaskConvertor;
import net.idea.restnet.i.task.ICallableTask;
import net.idea.restnet.i.task.ITaskStorage;
import net.idea.restnet.rdf.FactoryTaskConvertorRDF;

import org.opentox.wrapper.OTHTMLBeauty;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Form;
import org.restlet.data.Method;
import org.restlet.data.Reference;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;

public class ModelResource extends CatalogResource<Model>{	
	public static final String resource = "/model";
	public static final String resourceKey = "key";
	public Object key = null;
	
	
	@Override
	protected Iterator<Model> createQuery(Context context, Request request,
			Response response) throws ResourceException {
		InputStream in = null;
		try {
			key = request.getAttributes().get(resourceKey);
			Properties models = new Properties();
			in = this.getClass().getClassLoader().getResourceAsStream("model.properties");
			models.load(in);
			
			return new ModelIterator(getRequest().getRootRef().toString(),models,key);
		} catch (Exception x) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST,x);
		} finally {
			try {in.close();} catch (Exception x) {}
		}
	}
	
	@Override
	public IProcessor<Iterator<Model>, Representation> createRDFConvertor(
			Variant variant, String filenamePrefix) throws AmbitException,
			ResourceException {

		return
		 new StringConvertor(
					new ModelRDFReporter(getRequest(),variant.getMediaType(),getDocumentation())
					,variant.getMediaType());				
	}

	
	@Override
	protected ICallableTask createCallable(Method method, Form form, Model item)
			throws ResourceException {
		try {
			if (Method.POST.equals(method)) return item.post(getToken(),form);
			else throw new ResourceException(Status.SERVER_ERROR_NOT_IMPLEMENTED);
		} catch (ResourceException x) {
			throw x;
		} catch (Exception x) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST,x);
		}
	}
	
	@Override
	protected Reference getSourceReference(Form form, Model model)
			throws ResourceException {
		try {
		return new Reference(form.getFirstValue("dataset_uri").toString());
		} catch (Exception x) {return null;}
	}
	
	@Override
	protected FactoryTaskConvertor getFactoryTaskConvertor(ITaskStorage storage)
			throws ResourceException {
		return new FactoryTaskConvertorRDF(storage);
	}

	@Override
	protected Reporter createHTMLReporter(boolean headles) {
		return new ModelHTMLReporter(getRequest(),getDocumentation(),getHTMLBeauty(),headless,key==null);
	}
	@Override
	protected HTMLBeauty getHTMLBeauty() {
		return new OTHTMLBeauty();
	}
}
