package org.lg.verifier;

import org.lg.ce.json.JsonArray;
import org.lg.ce.json.JsonObject;
import org.lg.ce.model.Pair;
import org.lg.ce.model.ParamsMap;
import org.lg.facade.Verifier;
import org.lg.hors.AbstractException;
import org.lg.hors.core.NotInException;
import org.lg.log.Log;
import org.lg.util.component.FunVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InVerifier implements Verifier {

	private static final Logger LOGGER = LoggerFactory.getLogger(InVerifier.class);

	@Override
	public AbstractException verify(final ParamsMap input, final JsonObject definition) {

		AbstractException error = FunVerifier.<Pair>verify(definition, Names.IN, (item) -> {
			return FunVerifier.<String, JsonArray>verify(item, input, (field, actual, expected) -> {
				AbstractException inner = null;
				if (!expected.contains(actual)) {
					inner = new NotInException(field, actual, expected);
					Log.tsError(LOGGER, inner);
				}
				return inner;
			});
		});
		return error;
	}
}
