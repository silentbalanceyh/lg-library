package org.lg.babelway.junc;

import org.lg.ce.model.Envelop;
import org.lg.ce.model.ParamsMap;
import org.lg.junc.Connector;

public class BabelwayConnector implements Connector {
	@Override
	public Envelop connect(ParamsMap params) {
		System.out.println("Babelway Call: " + params.getRaw().encodePrettily());
		return null;
	}
}
