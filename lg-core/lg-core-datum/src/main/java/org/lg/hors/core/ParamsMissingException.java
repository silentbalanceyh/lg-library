package org.lg.hors.core;

import org.lg.hors.AbstractCoreException;
// -10001: Parameter missing
public class ParamsMissingException extends AbstractCoreException {
	public ParamsMissingException(String name) {
		super(-10001, name);
	}
}
