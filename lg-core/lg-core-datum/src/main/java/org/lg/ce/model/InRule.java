package org.lg.ce.model;

import java.io.Serializable;

import org.lg.ce.json.JsonObject;
import org.lg.cv.Rules;
import org.lg.hors.AbstractException;

public class InRule implements Serializable {

	private transient final JsonObject source = new JsonObject();
	private transient AbstractException error;
	private transient ParamsMap params = new ParamsMap();

	public InRule(final JsonObject meta) {
		if (null != meta && meta.containsKey(Rules.SOURCE)) {
			this.source.mergeIn(meta.getJsonObject(Rules.SOURCE));
		}
	}

	// Public api
	public boolean isValid() {
		return null == this.error;
	}

	public AbstractException getError() {
		return this.error;
	}

	public ParamsMap getParams() {
		return this.params;
	}

	public JsonObject getSource() {
		return this.source;
	}
}
