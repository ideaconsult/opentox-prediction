package org.opentox.wrapper.algorithm;

import java.util.Properties;

import org.opentox.wrapper.PropertiesIterator;

public class AlgorithmsIterator extends PropertiesIterator<Algorithm>{

	public AlgorithmsIterator(Properties props,Object query) {
		super(props,query);
	}

	@Override
	public Algorithm getItem(String key, String value) throws Exception{
		try {
			Class clazz = Class.forName(value);
			Object alg = clazz.newInstance();
			if (alg instanceof Algorithm) {
				((Algorithm) alg).setTitle(key);
				return (Algorithm) alg;
			}
			else throw new Exception(String.format("Expected class %s, found %s",Algorithm.class.getName(),clazz));
		} catch (Exception x) {
			throw x;
		}
	}

}
