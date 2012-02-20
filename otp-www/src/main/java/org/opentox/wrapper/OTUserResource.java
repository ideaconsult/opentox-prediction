package org.opentox.wrapper;

import net.idea.restnet.aa.opensso.users.OpenSSOUserResource;
import net.idea.restnet.c.html.HTMLBeauty;

public class OTUserResource extends OpenSSOUserResource {

	@Override
	protected HTMLBeauty getHTMLBeauty() {
		return new OTHTMLBeauty();
	}
}
