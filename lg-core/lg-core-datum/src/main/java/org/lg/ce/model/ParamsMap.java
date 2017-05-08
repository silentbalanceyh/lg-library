package org.lg.ce.model;

import org.lg.ce.json.JsonObject;

// Simple parameter maps
@SuppressWarnings("unchecked")
public class ParamsMap {

	private transient final JsonObject parameters = new JsonObject();

	public ParamsMap(final JsonObject params) {
		this.parameters.mergeIn(params);
	}

	public ParamsMap() {

	}

	public void put(final String key, final Object value) {
		this.parameters.put(key, value);
	}

	public <T> T get(final String key) {
		final Object reference = this.parameters.getValue(key);
		T ret = null;
		if (null != reference) {
			ret = (T) reference;
		}
		return ret;
	}

	public JsonObject getRaw() {
		return this.parameters;
	}
}
