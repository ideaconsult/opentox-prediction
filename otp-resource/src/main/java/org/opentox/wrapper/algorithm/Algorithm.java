package org.opentox.wrapper.algorithm;

import org.opentox.wrapper.OTResource;

public class Algorithm extends OTResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5421053242856548079L;

	@Override
	public String toString() {
		return String.format("algorithm/%s",getTitle());
	}
}
