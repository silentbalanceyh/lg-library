package org.lg.hors.core;

import org.lg.hors.AbstractCoreException;

// -10004: Pattern wrong
public class PatternWrongException extends AbstractCoreException {
	public PatternWrongException(final String field, final String actual, final String pattern) {
		super(-10004, field, actual, pattern);
	}
}
