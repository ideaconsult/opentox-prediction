package org.opentox.wrapper.algorithm;

import net.idea.restnet.c.routers.MyRouter;

import org.restlet.Context;


public class AlgorithmsRouter extends MyRouter {
	public AlgorithmsRouter(Context context) {
		super(context);
		attachDefault(AlgorithmResource.class);
		attach(String.format("/{%s}",AlgorithmResource.resource, AlgorithmResource.resourceKey), AlgorithmResource.class);
	}
}
