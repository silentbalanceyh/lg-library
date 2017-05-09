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
		// 1.Extract in rule from definition
		AbstractException error = FunVerifier.verify(definition, Names.MIN, (item) -> {
			// 2.item -> Pair extracted from JsonObject one key = value
			final Pair pair = (Pair) item;
			final String field = pair.getKey();
			final Integer actual = input.get(field);
			final Object expected = pair.getValue();
			// 3.Check the limitation
			AbstractException inner = null;
			if (null != actual && Integer.valueOf(expected.toString()) > actual) {
				inner = new RangeException(field, actual, expected.toString(), "Unlimited");
				Log.tsError(LOGGER, inner);
			}
			return inner;
		});
		return error;
	}
}
