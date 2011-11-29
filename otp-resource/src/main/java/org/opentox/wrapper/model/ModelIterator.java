package org.opentox.wrapper.model;

import java.util.Properties;

import org.opentox.wrapper.PropertiesIterator;

public class ModelIterator extends PropertiesIterator<Model>{
	
	public ModelIterator(String prefix,Properties props,Object query) {
		super(prefix,props,query);
	}

	@Override
	public Model getItem(String key, String value) throws Exception{
		try {
			Class clazz = Class.forName(value);
			Object alg = clazz.newInstance();
			if (alg instanceof Model) {
				((Model) alg).setTitle(key);
				((Model) alg).setUri(String.format("%s%s/%s",getPrefix(),ModelResource.resource,key));
				return (Model) alg;
			}
			else throw new Exception(String.format("Expected class %s, found %s",Model.class.getName(),clazz));
		} catch (Exception x) {
			throw x;
		}
	}

}
