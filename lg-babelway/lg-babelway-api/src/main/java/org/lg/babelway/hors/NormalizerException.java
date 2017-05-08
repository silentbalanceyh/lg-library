package org.lg.babelway.hors;

import org.lg.hors.AbstractBabelwayException;
// 20001: Normalization issue
public class NormalizerException extends AbstractBabelwayException {
	public NormalizerException(String action, String message) {
		super(-20001, action, message);
	}
}
