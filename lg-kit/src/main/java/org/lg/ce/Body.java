package org.lg.ce;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;

/** **/
interface Body<T> {
	/** **/
	HttpEntity<T> body();
	/** **/
	T data();
	/** **/
	MediaType bodyType();
}
