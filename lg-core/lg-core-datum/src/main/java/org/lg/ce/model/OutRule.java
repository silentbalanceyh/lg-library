package org.lg.ce.model;

import java.io.Serializable;

import org.lg.ce.json.JsonObject;
import org.lg.cv.Rules;
import org.lg.hors.AbstractException;

public class OutRule implements Serializable {
	private transient final JsonObject target = new JsonObject();
	private transient final JsonObject mapping = new JsonObject();
	private transient AbstractException error;

	public OutRule(final JsonObject meta, final Envelop envelop) {
		if (null != meta) {
			if (meta.containsKey(Rules.TARGET)) {
				this.target.mergeIn(meta.getJsonObject(Rules.TARGET));
			}
			if (meta.containsKey(Rules.MAPPING)) {
				this.target.mergeIn(meta.getJsonObject(Rules.MAPPING));
			}
		}
	}

	// Public api
	public boolean isValid() {
		return null != this.error;
	}

	public AbstractException getError() {
		return this.error;
	}

	public JsonObject getTarget() {
		return this.target;
	}

	public JsonObject getMapping() {
		return this.mapping;
	}
}
