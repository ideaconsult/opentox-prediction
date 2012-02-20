package org.opentox.wrapper;

import net.idea.restnet.c.resource.TaskResource;
import net.idea.restnet.c.task.FactoryTaskConvertor;
import net.idea.restnet.i.task.ITaskStorage;
import net.idea.restnet.rdf.FactoryTaskConvertorRDF;

import org.restlet.resource.ResourceException;

public class OTTaskResource extends TaskResource<String> {

	
	@Override
	protected FactoryTaskConvertor getFactoryTaskConvertor(ITaskStorage storage)
			throws ResourceException {
		return new FactoryTaskConvertorRDF(storage);
	}

}
