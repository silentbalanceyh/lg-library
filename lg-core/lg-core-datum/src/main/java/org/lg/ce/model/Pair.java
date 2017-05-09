package org.lg.ce.model;

import java.io.Serializable;
// Key = Value
public class Pair implements Serializable {

	private transient final String key;

	private transient final Object value;

	public Pair(final String key, final Object value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Pair [key=" + key + ", value=" + value + "]";
	}
}
