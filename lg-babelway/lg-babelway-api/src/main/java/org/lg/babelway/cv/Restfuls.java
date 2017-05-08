package org.lg.babelway.cv;
/**
 * Restful definition
 * @author lang
 *
 */
public interface Restfuls {
	/** Endpoint **/
	String ENDPOINT = "https://www.babelway.net/SelfService3/rest/v2/hub-{0}/";
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
