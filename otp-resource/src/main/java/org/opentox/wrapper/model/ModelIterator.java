package org.opentox.wrapper.model;

import java.util.Properties;

import org.opentox.wrapper.PropertiesIterator;

public class ModelIterator extends PropertiesIterator<Model>{
	protected Properties propNames;
	public ModelIterator(String prefix,Properties props,Object query,Properties propNames) {
		super(prefix,props,query);
		this.propNames = propNames;
	}

	@Override
	public Model getItem(String key, String value) throws Exception{
		try {
			Class clazz = Class.forName(value);
			Object alg = clazz.newInstance();
			if (alg instanceof Model) {
				String title = propNames.getProperty(key);
				((Model) alg).setTitle(title==null?key:title);
				((Model) alg).setUri(String.format("%s%s/%s",getPrefix(),ModelResource.resource,key));
				return (Model) alg;
			}
			else throw new Exception(String.format("Expected class %s, found %s",Model.class.getName(),clazz));
		} catch (Exception x) {
			throw x;
		}
	}

}
