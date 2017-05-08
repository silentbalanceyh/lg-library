package org.lg.util.component;

import org.lg.ce.json.JsonArray;
import org.lg.ce.json.JsonObject;
import org.lg.fun.robject.FnObject;
import org.lg.hors.AbstractException;
import org.lg.util.fun.FunJson;

public class FunVerifier {

	public static AbstractException verify(final JsonObject definition, final String rule, final FnObject fun) {
		AbstractException error = null;
		if (definition.containsKey(rule)) {
			final Object ruleObj = definition.getValue(rule);
			if (null != ruleObj) {
				if (JsonObject.class.isInstance(ruleObj)) {
					final JsonObject args = (JsonObject) ruleObj;
					error = FunJson.exec(args, fun, AbstractException.class);
				} else if (JsonArray.class.isInstance(ruleObj)) {
					final JsonArray args = (JsonArray) ruleObj;
					error = FunJson.exec(args, fun, AbstractException.class);
				}
			}
		}
		return error;
	}
}
