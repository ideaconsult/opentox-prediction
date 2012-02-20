package eu.cadaster.opentox;

import java.net.MalformedURLException;
import java.net.URL;

import net.idea.restnet.i.task.ICallableTask;

import org.opentox.rdf.OpenTox;
import org.opentox.wrapper.model.Model;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

public class CadasterModel extends Model {
	protected long modelID = -1;
	
	public CadasterModel() {
		this(-1);
	}

	public CadasterModel(long modelid) {
		setModelID(modelid);
	}
	
	public long getModelID() {
		return modelID;
	}
	
	

	public void setModelID(long modelID) {
		this.modelID = modelID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4124667104351369051L;

	@Override
	public void setTitle(String title) {
		super.setTitle(title);
		modelID = Integer.parseInt(title.substring(8));
	}
	
	@Override
	public ICallableTask post(String token,Form form) throws Exception {
		Object dataURL = OpenTox.params.dataset_uri.getFirstValue(form);
		Object dataServiceURL = OpenTox.params.dataset_service.getFirstValue(form);
		if (dataURL==null) throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST,OpenTox.params.dataset_uri.getDescription());
		try {
			return new CadasterModelTask(token, this, new URL(dataURL.toString()), dataServiceURL==null?null:new URL(dataServiceURL.toString()));
		} catch (MalformedURLException x) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST,dataURL.toString(),x);
		}
	}
}
