package org.lg.hors;

import org.lg.em.ErrorType;
import org.lg.log.Log;

/**
 * Top exception
 */
public abstract class AbstractException extends Exception {

	private transient String message;
	private transient int code;

	public AbstractException(final String message) {
		this.message = message;
	}

	public AbstractException(final int code, final Object... params) {
		this(Log.format(code, params));
		this.code = code;
	}

	public String getErrorMessage() {
		return this.message;
	}

	public int getErrorCode() {
		return this.code;
	}
	
	public abstract ErrorType getErrorType();
}
