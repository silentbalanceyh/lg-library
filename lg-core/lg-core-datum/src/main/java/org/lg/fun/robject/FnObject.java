package org.lg.fun.robject;

@FunctionalInterface
public interface FnObject<I, O> {
	// Function of object
	O execute(I item);
}
