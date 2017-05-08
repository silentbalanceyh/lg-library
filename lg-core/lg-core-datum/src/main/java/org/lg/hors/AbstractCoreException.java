package org.lg.hors;

import org.lg.em.ErrorType;

/**
 * Core exception
 */
public abstract class AbstractCoreException extends AbstractException {
	public AbstractCoreException(final int code, final Object... params) {
		super(code, params);
	}

	public ErrorType getErrorType() {
		return ErrorType.CORE;
	}
}
