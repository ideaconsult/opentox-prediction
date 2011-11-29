package org.opentox.wrapper.model;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import net.idea.restnet.c.resource.CatalogResource;
import net.idea.restnet.i.task.ICallableTask;

import org.opentox.rdf.OpenTox;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Form;
import org.restlet.data.Method;
import org.restlet.data.Reference;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

public class ModelResource extends CatalogResource<Model>{	
	public static final String resource = "/model";
	public static final String resourceKey = "key";
	
	
	@Override
	protected Iterator<Model> createQuery(Context context, Request request,
			Response response) throws ResourceException {
		InputStream in = null;
		try {
			Object key = request.getAttributes().get(resourceKey);
			Properties models = new Properties();
			in = this.getClass().getClassLoader().getResourceAsStream("model.properties");
			models.load(in);
			
			return new ModelIterator(models,key);
		} catch (Exception x) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST,x);
		} finally {
			try {in.close();} catch (Exception x) {}
		}
	}
	
	@Override
	protected Iterator<Model> createPOSTQuery(Context context, Request request,
			Response response) throws ResourceException {
		return super.createPOSTQuery(context, request, response);
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
		return new Reference(OpenTox.params.dataset_uri.getFirstValue(form).toString());
		} catch (Exception x) {return null;}
	}
}
