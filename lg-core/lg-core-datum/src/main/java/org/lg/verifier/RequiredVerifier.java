package org.lg.verifier;

import java.util.Set;

import org.lg.ce.json.JsonArray;
import org.lg.ce.json.JsonObject;
import org.lg.ce.model.ParamsMap;
import org.lg.cv.Defaults;
import org.lg.facade.Verifier;
import org.lg.hors.AbstractException;
import org.lg.hors.core.ParamsMissingException;
import org.lg.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequiredVerifier implements Verifier {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequiredVerifier.class);

	@Override
	public AbstractException verify(final ParamsMap input, final JsonObject definition) {
		// 1.Extract required rule from definition
		AbstractException error = null;
		if (definition.containsKey(Names.REQUIRED)) {
			// 2.Extract JsonArray
			final JsonArray fields = definition.getJsonArray(Names.REQUIRED);
			if (null != fields) {
				// 3.Iterator to fields
				final Set<String> inputes = input.keys();
				final int size = fields.size();
				for (int idx = Defaults.INDEX; idx < size; idx++) {
					final String field = fields.getString(idx);
					if (!inputes.contains(field)) {
						error = new ParamsMissingException(field);
						// Logger
						Log.tsError(LOGGER, error, field);
						break;
					}
				}
			}
		}
		return error;
	}
}
