package org.lg.facade;

import org.lg.ce.model.ParamsMap;
import org.lg.hors.AbstractException;
/** Uniform Interface to ingest data from different data source **/
public interface Ingestor<T> {
	
	T ingest(ParamsMap params) throws AbstractException;
}
