package org.lg.hors;

import org.lg.em.ErrorType;

/**
 * Babelway exception
 */
public abstract class AbstractBabelwayException extends AbstractException {
	public AbstractBabelwayException(String message) {
		super(message);
	}
	
	public ErrorType getErrorType(){
		return ErrorType.BABELWAY;
	}
}
