package org.lg.junc;

import org.lg.ce.model.Envelop;
import org.lg.ce.model.ParamsMap;

public interface Connector {
	
	Envelop connect(ParamsMap params);
}
