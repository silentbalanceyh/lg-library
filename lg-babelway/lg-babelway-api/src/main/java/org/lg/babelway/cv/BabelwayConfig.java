package org.lg.babelway.cv;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.lg.ce.json.JsonObject;
import org.lg.config.impl.DatumLoader;
import org.lg.cv.Files;
import org.lg.cv.Symbols;
import org.lg.util.IOKit;

/**
 * Restful definition
 * 
 * @author lang
 *
 */
public final class BabelwayConfig {
	private static final Properties CONFIG = DatumLoader.get(BabelwayInfo.FILE_NAME);
	private static final ConcurrentMap<String, JsonObject> NORMALIZATIONS = new ConcurrentHashMap<>();

	static {
		final List<String> files = IOKit.listFiles(BabelwayInfo.Folder.NORMALIZATION);
		// Load once
		for (final String file : files) {
			// Calculate key
			final String key = file.replaceAll(Files.Ext.DOT_JSON, Symbols.EMPTY);
			// Load normalization rule
			final String path = BabelwayInfo.Folder.NORMALIZATION + Symbols.SLASH + file;
			final JsonObject normalization = IOKit.getJObject(path);
			NORMALIZATIONS.put(key, normalization);
		}
	}

	public static JsonObject loadNormalization(final String action) {
		JsonObject ret = new JsonObject();
		if (NORMALIZATIONS.containsKey(action)) {
			ret = NORMALIZATIONS.get(action);
		}
		return ret;
	}

	interface Config {
		/** Endpoint **/
		String ENDPOINT = "https://www.babelway.net/SelfService3/rest/v2/hub-{0}/";
		/** **/
		String USERNAME = CONFIG.getProperty(BabelwayInfo.KEY_USERNAME);
		/** **/
		String PASSWORD = CONFIG.getProperty(BabelwayInfo.KEY_PASSWORD);
		/** **/
		String HUB_ID = CONFIG.getProperty(BabelwayInfo.KEY_HUB_ID);
	}

	/** Actions **/
	interface Actions {
		/** **/
		String TICKETS = "tickets";
		/** **/
		String TICKET = "ticket";
		/** **/
		String DELETE_TICKET = "deleteTicket";
		/** **/
		String MESSAGES = "messages";
		/** **/
		String CHANNELS = "channels";
		/** **/
		String GATEWAYS = "gateways";
		/** **/
		String MESSAGE_DEFINITIONS = "messageDefinitions";
		/** **/
		String TRANSFORMATIONS = "transformations";
		/** **/
		String CATALOGUE = "catalogue";
	}

	interface Format {
		/** **/
		String XML = "xml";
		/** **/
		String JSON = "json";
	}
}
