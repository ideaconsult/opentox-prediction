package org.opentox.wrapper;

import java.io.Serializable;

import net.idea.restnet.i.task.ICallableTask;

import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

public class OTResource  implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6586267434387552274L;
	String uri;
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return title;
	}
	
	public ICallableTask post(String token,Form form) throws Exception {
		throw new ResourceException(Status.SERVER_ERROR_NOT_IMPLEMENTED);
	}
}
