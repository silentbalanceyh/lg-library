package org.lg.hors;

import org.lg.em.ErrorType;

/**
 * Babelway exception
 */
public abstract class AbstractBabelwayException extends AbstractException {
	public AbstractBabelwayException(final int code, final Object... params) {
		super(code, params);
	}

	public ErrorType getErrorType() {
		return ErrorType.BABELWAY;
	}
}
