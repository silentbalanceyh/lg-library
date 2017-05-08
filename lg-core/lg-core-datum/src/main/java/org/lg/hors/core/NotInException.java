package org.lg.hors.core;

import org.lg.ce.json.JsonArray;
import org.lg.hors.AbstractCoreException;

public class NotInException extends AbstractCoreException {
	public NotInException(final String field, final String actual, final JsonArray expected) {
		super(-10002, field, actual, expected.encode());
	}
}
