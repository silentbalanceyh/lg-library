package org.lg.fun.rerror;

import org.lg.hors.AbstractException;

@FunctionalInterface
public interface FnVerify<A,E> {
	
	AbstractException execute(String field, A actual, E expected);
}
