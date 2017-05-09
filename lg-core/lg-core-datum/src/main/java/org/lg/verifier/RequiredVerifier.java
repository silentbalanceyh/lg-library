package org.lg.verifier;

import java.util.Set;

import org.lg.ce.json.JsonObject;
import org.lg.ce.model.ParamsMap;
import org.lg.facade.Verifier;
import org.lg.hors.AbstractException;
import org.lg.hors.core.ParamsMissingException;
import org.lg.log.Log;
import org.lg.util.component.FunVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequiredVerifier implements Verifier {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequiredVerifier.class);

	@Override
	public AbstractException verify(final ParamsMap input, final JsonObject definition) {
		// 1.Extract keys
		final Set<String> inputes = input.keys();
		// 2.Extract required rule from definition
		final AbstractException error = FunVerifier.<String>verify(definition, Names.REQUIRED, (item) -> {
			// item -> field name from ["field1","field2"]
			final String field = item;
			AbstractException inner = null;
			// 3.Checked condition
			if (!inputes.contains(field)) {
				inner = new ParamsMissingException(field);
				Log.tsError(LOGGER, inner);
			}
			return inner;
		});
		return error;
	}
}
