package org.opentox.wrapper;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

public abstract class PropertiesIterator<E> implements Iterator<E> {
	protected Properties props;
	protected Enumeration keys;
	protected Object key = null;
	protected Object query = null;
	String prefix;
	
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public PropertiesIterator(String prefix,Properties props, Object query) {
		super();
		this.prefix = prefix;
		this.props = props;
		if (query==null) keys = props.keys();
		this.query = query;
	}
	
	@Override
	public boolean hasNext() {
		if (query!=null) {
			key = props.getProperty(query.toString())==null?null:query;
			query = null;
		} else {
			if ((keys!=null) && keys.hasMoreElements())
				key = keys.nextElement();
			else 
				key = null;
		}
		return key != null;
	}

	@Override
	public E next() {
		if (key!=null) {
			String value = props.getProperty(key.toString());
			try {
				return getItem(key.toString(),value);
			} catch (Exception x) {return null;}
		} else return null;
	}

	@Override
	public void remove() {
	}

	public abstract E getItem(String key,String value) throws Exception;
}
