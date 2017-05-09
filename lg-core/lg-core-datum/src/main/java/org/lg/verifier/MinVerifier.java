package org.lg.verifier;

import org.lg.ce.json.JsonObject;
import org.lg.ce.model.Pair;
import org.lg.ce.model.ParamsMap;
import org.lg.facade.Verifier;
import org.lg.hors.AbstractException;
import org.lg.hors.core.RangeException;
import org.lg.log.Log;
import org.lg.util.component.FunVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinVerifier implements Verifier {

	private static final Logger LOGGER = LoggerFactory.getLogger(InVerifier.class);

	@Override
	public AbstractException verify(final ParamsMap input, final JsonObject definition) {

		AbstractException error = FunVerifier.<Pair>verify(definition, Names.MIN, (item) -> {
			return FunVerifier.<Integer, Integer>verify(item, input, (field, actual, expected) -> {
				AbstractException inner = null;
				if (expected > actual) {
					inner = new RangeException(field, actual, expected.toString(), "Unlimited");
					Log.tsError(LOGGER, inner);
				}
				return inner;
			});
		});
		return error;
	}
}
