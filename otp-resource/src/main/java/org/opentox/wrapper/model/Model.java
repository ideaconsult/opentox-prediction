package org.opentox.wrapper.model;

import org.opentox.wrapper.OTResource;
import org.opentox.wrapper.algorithm.Algorithm;

public class Model  extends OTResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8613828652999405200L;
	protected String creator;
	protected String id;
	protected String endpoint;
	
	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return String.format("model/%s",getId());
	}
	protected Algorithm algorithm;
	
	public Algorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

}
