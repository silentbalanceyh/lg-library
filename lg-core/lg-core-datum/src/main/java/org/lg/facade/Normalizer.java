package org.lg.facade;

import org.lg.ce.model.ParamsMap;
import org.lg.hors.AbstractException;

/** Uniform interface to normalize input **/
public interface Normalizer {

	ParamsMap normalize(ParamsMap params) throws AbstractException;
}
