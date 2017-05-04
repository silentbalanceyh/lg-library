package org.lg.ce.media;

import org.lg.ce.Response;
import org.lg.ce.web.Headers;
import org.lg.em.ResponseType;
import org.lg.hors.AbstractException;
import org.lg.tp.vertx.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
/** **/
public class JsonResponse implements Response<JsonObject>{

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
	public HttpStatus status() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseType type() {
		// TODO Auto-generated method stub
		return null;
	}
}
