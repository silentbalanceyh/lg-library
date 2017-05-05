package org.lg.hors;

import org.lg.em.ErrorType;

/**
 * Ubl exception
 */
public abstract class AbstractUblException extends AbstractException {
	public AbstractUblException(String message) {
		super(message);
	}
	
	public ErrorType getErrorType(){
		return ErrorType.UBL;
	}
}
