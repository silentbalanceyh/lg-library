package org.lg.hors;
/**
 * Top exception
 */
public abstract class AbstractException extends Exception{
	
	public int getErrorCode(){
		return -1;
	}
	
	public String getErrorMessage(){
		return null;
	}
}
