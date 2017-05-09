package org.lg.verifier;

import java.util.Date;

import org.lg.ce.json.JsonObject;
import org.lg.ce.model.Pair;
import org.lg.ce.model.ParamsMap;
import org.lg.facade.Verifier;
import org.lg.hors.AbstractException;
import org.lg.hors.core.PatternWrongException;
import org.lg.log.Log;
import org.lg.util.DatetimeKit;
import org.lg.util.component.FunVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeVerifier implements Verifier {

	private static final Logger LOGGER = LoggerFactory.getLogger(InVerifier.class);

	@Override
	public AbstractException verify(final ParamsMap input, final JsonObject definition) {

		AbstractException error = FunVerifier.<Pair>verify(definition, Names.TIME, (item) -> {
			return FunVerifier.<String, String>verify(item, input, (field, actual, expected) -> {
				AbstractException inner = null;
				final Date ret = DatetimeKit.toDate(actual, expected);
				if (null == ret) {
					inner = new PatternWrongException(field, actual, expected);
					Log.tsError(LOGGER, inner);
				}
				return inner;
			});
		});

		return error;
	}

}
