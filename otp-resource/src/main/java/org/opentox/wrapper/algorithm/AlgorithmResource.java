package org.opentox.wrapper.algorithm;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.idea.restnet.c.resource.CatalogResource;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

public class AlgorithmResource  extends CatalogResource<Algorithm> {
	public static final String resource = "/algorithm";
	public static final String resourceKey = "key";
	protected List<Algorithm> algorithms;
	
	@Override
	protected Iterator<Algorithm> createQuery(Context context, Request request,
			Response response) throws ResourceException {
		InputStream in = null;
		try {
			Object key = request.getAttributes().get(resourceKey);
			Properties algorithms = new Properties();
			in = this.getClass().getClassLoader().getResourceAsStream("algorithm.properties");
			algorithms.load(in);
			
			return new AlgorithmsIterator(getRequest().getRootRef().toString(),algorithms,key);
		} catch (Exception x) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST,x);
		} finally {
			try {in.close();} catch (Exception x) {}
		}
	}


}
