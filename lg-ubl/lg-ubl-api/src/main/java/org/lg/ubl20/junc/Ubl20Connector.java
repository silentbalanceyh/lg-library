package org.lg.ubl20.junc;

import org.lg.ce.model.Envelop;
import org.lg.ce.model.ParamsMap;
import org.lg.junc.Connector;

public class Ubl20Connector implements Connector {
	@Override
	public Envelop connect(ParamsMap params) {
		System.out.println("Ubl20 Call: " + params.getRaw().encodePrettily());
		return null;
	}
}
