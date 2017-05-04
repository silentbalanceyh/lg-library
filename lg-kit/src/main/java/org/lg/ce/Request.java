package org.lg.ce;

import java.net.URI;

import org.springframework.http.HttpMethod;

/**
 * Http Request
 * @author lang
 *
 */
public interface Request<T> extends Header, Body<T>, Failure {
	/** **/
	HttpMethod method();
	/** **/
	URI path();
}
