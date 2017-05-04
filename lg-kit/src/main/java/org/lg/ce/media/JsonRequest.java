package org.lg.ce.media;

import java.net.URI;

import org.lg.ce.Request;
import org.lg.ce.web.Headers;
import org.lg.hors.AbstractException;
import org.lg.tp.vertx.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

/** **/
public class JsonRequest implements Request<JsonObject>{

	@Override
	public Headers getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHeader(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHeader(String key, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HttpEntity<JsonObject> body() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject data() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MediaType bodyType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractException error() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpMethod method() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI path() {
		// TODO Auto-generated method stub
		return null;
	}


}
