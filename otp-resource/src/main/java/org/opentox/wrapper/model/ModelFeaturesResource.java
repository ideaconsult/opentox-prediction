package org.opentox.wrapper.model;

import java.util.Iterator;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.resource.ResourceException;

import net.idea.restnet.c.resource.CatalogResource;

public class ModelFeaturesResource extends CatalogResource<Feature> {

	@Override
	protected Iterator<Feature> createQuery(Context context, Request request,
			Response response) throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
