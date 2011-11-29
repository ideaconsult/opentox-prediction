package org.opentox.wrapper.algorithm;

import java.util.Properties;

import org.opentox.wrapper.PropertiesIterator;

public class AlgorithmsIterator extends PropertiesIterator<Algorithm>{

	public AlgorithmsIterator(String prefix,Properties props,Object query) {
		super(prefix,props,query);
	}

	@Override
	public Algorithm getItem(String key, String value) throws Exception{
		try {
			Class clazz = Class.forName(value);
			Object alg = clazz.newInstance();
			if (alg instanceof Algorithm) {
				((Algorithm) alg).setTitle(key);
				((Algorithm) alg).setUri(String.format("%s%s/%s",getPrefix(),AlgorithmResource.resource,key));
				return (Algorithm) alg;
			}
			else throw new Exception(String.format("Expected class %s, found %s",Algorithm.class.getName(),clazz));
		} catch (Exception x) {
			throw x;
		}
	}

}
