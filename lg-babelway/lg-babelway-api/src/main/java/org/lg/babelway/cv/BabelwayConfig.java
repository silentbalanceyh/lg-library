package org.lg.babelway.cv;

import java.util.Properties;

import org.lg.config.impl.DatumLoader;

/**
 * Restful definition
 * 
 * @author lang
 *
 */
public final class BabelwayConfig {
	private static Properties CONFIG = DatumLoader.get(BabelwayInfo.FILE_NAME);

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
