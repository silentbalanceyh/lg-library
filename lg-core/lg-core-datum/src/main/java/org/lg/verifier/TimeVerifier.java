package org.lg.verifier;

import org.lg.ce.json.JsonObject;
import org.lg.ce.model.ParamsMap;
import org.lg.facade.Verifier;
import org.lg.hors.AbstractException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeVerifier implements Verifier{

	private static final Logger LOGGER = LoggerFactory.getLogger(InVerifier.class);
	
	@Override
	public AbstractException verify(final ParamsMap input, final JsonObject definition) {
		// 1.Extract in rule from definition
		AbstractException error = null;
		
		return error;
	}

}
