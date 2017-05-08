package org.lg.connector;

import org.junit.Test;
import org.lg.ce.model.ParamsMap;
import org.lg.junc.Connector;
import org.lg.junc.impl.ConnectorManager;

public class ConnectorTest {

	@Test
	public void testConnector() {
		final Connector babelway = ConnectorManager.getConnector("Babelway");
		if (null != babelway) {
			babelway.connect(new ParamsMap());
		}
		final Connector ubl20 = ConnectorManager.getConnector("Ubl20");
		if (null != ubl20) {
			ubl20.connect(new ParamsMap());
		}
	}
}
