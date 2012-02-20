package org.opentox.wrapper;

import net.idea.restnet.c.routers.MyRouter;

import org.restlet.Context;

public class OTTaskRouter extends MyRouter {
	public OTTaskRouter(Context context) {
		super(context);
		attachDefault(OTTaskResource.class);
		attach(OTTaskResource.resourceID, OTTaskResource.class);
	}
}
