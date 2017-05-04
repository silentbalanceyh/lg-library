package org.lg.ce;

import org.lg.ce.web.Headers;

/** **/
interface Header {
	/** **/
	Headers getHeaders();
	/** **/
	String getHeader(String key);
	/** **/
	void setHeader(String key, String value);
}
