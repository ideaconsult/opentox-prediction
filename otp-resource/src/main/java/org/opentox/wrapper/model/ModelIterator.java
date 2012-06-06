package org.opentox.wrapper.model;

import java.util.Properties;

import org.opentox.wrapper.PropertiesIterator;
import org.opentox.wrapper.algorithm.Algorithm;

public class ModelIterator extends PropertiesIterator<Model>{
	protected Properties propNames;
	public ModelIterator(String prefix,Properties props,Object query,Properties propNames) {
		super(prefix,props,query);
		this.propNames = propNames;
	}

	@Override
	public Model getItem(String key, String value) throws Exception{
		try {
			Class clazz = Class.forName(value.trim());
			Object object = clazz.newInstance();
			if (object instanceof Model) {
				Model model = (Model) object;
				String title = propNames.getProperty(key);
				model.setId(key);
				model.setTitle(title==null?key:title);
				model.setUri(String.format("%s%s/%s",getPrefix(),ModelResource.resource,key));

				return model;
			}
			else throw new Exception(String.format("Expected class %s, found %s",Model.class.getName(),clazz));
		} catch (Exception x) {
			System.out.println(key);
			throw x;
		}
	}

}
