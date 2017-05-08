package org.lg.junc.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.lg.junc.Connector;

/** **/
public class ConnectorManager {
	// Cache for connectors by name, each named connector keep singleton.
	private static final ConcurrentMap<String, Connector> CONNECTORS = new ConcurrentHashMap<>();

	public static Connector getConnector(final String name) {
		Connector connector = CONNECTORS.get(name);
		if (null == connector) {
			connector = new DataConnector(name);
			CONNECTORS.put(name, connector);
		}
		return connector;
	}

	private ConnectorManager() {
	}
}
