package org.lg.ce;

import org.lg.em.ResponseType;
import org.springframework.http.HttpStatus;

/** **/
public interface Response<T> extends Header, Body<T>, Failure{
	/** **/
	HttpStatus status();
	/** **/
	ResponseType type();
}
