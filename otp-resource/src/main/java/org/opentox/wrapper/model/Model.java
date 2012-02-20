package org.opentox.wrapper.model;

import org.opentox.wrapper.OTResource;
import org.opentox.wrapper.algorithm.Algorithm;

public class Model  extends OTResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8613828652999405200L;
	protected String creator;
	
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return String.format("model/%s",getTitle());
	}
	protected Algorithm algorithm;
	
	public Algorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

}
