package org.opentox.wrapper.model;

import org.opentox.wrapper.OTResource;

public class Model  extends OTResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8613828652999405200L;

	@Override
	public String toString() {
		return String.format("model/%s",getTitle());
	}
}
