package org.lg.facade;

import org.lg.ce.json.JsonObject;
import org.lg.ce.model.ParamsMap;
import org.lg.hors.AbstractException;
// Verifier to verify different field
@FunctionalInterface
public interface Verifier {
	// Verify input based on definition
	AbstractException verify(ParamsMap input, JsonObject definition);
	
	interface Names {
		// Required
		String REQUIRED = "REQUIRED";
		// In
		String IN = "IN";
		// Range
		String MIN = "MIN";
		// Time
		String TIME = "TIME";
	}
}
