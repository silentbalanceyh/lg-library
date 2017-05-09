package org.lg.babelway;

import org.lg.babelway.cv.BabelwayConfig;
import org.lg.babelway.hors.NormalizerException;
import org.lg.ce.json.JsonObject;
import org.lg.ce.model.ParamsMap;
import org.lg.facade.Normalizer;
import org.lg.facade.Verifier;
import org.lg.hors.AbstractException;
import org.lg.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractNormalizer implements Normalizer {
	// Get Action Name
	protected abstract String getAction();

	@Override
	public ParamsMap normalize(final ParamsMap params) throws AbstractException {
		// 1.Read definition from 'normalization' folder
		final JsonObject definition = this.getDefinition();
		// 2.Execute normalize
		this.execVerify(params, definition);
		// 3.Build final normalize
		return null;
	}

	private void execVerify(ParamsMap params, final JsonObject definition) throws AbstractException {
		// Each rule, same workflow
		for (final String key : definition.fieldNames()) {
			final Verifier verifier = VerifierTool.select(key);
			AbstractException error = verifier.verify(params, definition);
			if (null != error) {
				// Error replacement
				final String message = error.getErrorMessage();
				error = new NormalizerException(this.getAction(), message);
				// Logger
				Log.tsError(getLogger(), error);
				throw error;
			}
		}
	}

	private Logger getLogger() {
		return LoggerFactory.getLogger(getClass());
	}

	private JsonObject getDefinition() {
		final String action = this.getAction();
		return BabelwayConfig.loadNormalization(action);
	}
}
