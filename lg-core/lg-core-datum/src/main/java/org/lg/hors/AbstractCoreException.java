package org.lg.hors;

import org.lg.em.ErrorType;

/**
 * Core exception
 */
public abstract class AbstractCoreException extends AbstractException{
	public AbstractCoreException(String message) {
		super(message);
	}
	
	public ErrorType getErrorType(){
		return ErrorType.CORE;
	}
}
