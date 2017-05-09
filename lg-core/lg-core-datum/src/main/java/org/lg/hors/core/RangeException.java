package org.lg.hors.core;

import org.lg.hors.AbstractCoreException;

public class RangeException extends AbstractCoreException {

	public RangeException(final String field, final int actual, final String min, final String max) {
		super(-10003, field, actual, min, max);
	}
}
