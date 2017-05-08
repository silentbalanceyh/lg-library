package org.lg.junc.impl;

import java.util.Properties;

import org.lg.ce.model.Envelop;
import org.lg.ce.model.ParamsMap;
import org.lg.config.impl.DatumLoader;
import org.lg.cv.Files;
import org.lg.junc.Connector;
import org.lg.util.Instance;

public class DataConnector implements Connector {
	private static Properties CONNECTORS = DatumLoader.get(Files.Prop.CONNECTOR);

	private transient final Connector connector;

	public DataConnector(final String name) {
		if (CONNECTORS.containsKey(name)) {
			final String className = CONNECTORS.getProperty(name);
			connector = Instance.singleton(className);
		} else {
			connector = null;
		}
	}

	@Override
	public Envelop connect(final ParamsMap params) {
		Envelop envelop = null;
		if (null != this.connector) {
			envelop = this.connector.connect(params);
		}
		return envelop;
	}
}
