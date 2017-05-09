package org.lg.util.component;

import org.lg.ce.json.JsonArray;
import org.lg.ce.json.JsonObject;
import org.lg.ce.model.Pair;
import org.lg.ce.model.ParamsMap;
import org.lg.fun.rerror.FnVerify;
import org.lg.fun.robject.FnObject;
import org.lg.hors.AbstractException;
import org.lg.util.fun.FunJson;

@SuppressWarnings("unchecked")
public class FunVerifier {
	// Outer container
	public static <I> AbstractException verify(final JsonObject definition, final String rule,
			final FnObject<I, AbstractException> fun) {
		AbstractException error = null;
		if (definition.containsKey(rule)) {
			final Object ruleObj = definition.getValue(rule);
			if (null != ruleObj) {
				if (JsonObject.class.isInstance(ruleObj)) {
					// JsonObject item
					final JsonObject args = (JsonObject) ruleObj;
					final FnObject<Pair, AbstractException> funRef = (FnObject<Pair, AbstractException>) fun;
					error = FunJson.<Pair, AbstractException>exec(args, funRef);
				} else if (JsonArray.class.isInstance(ruleObj)) {
					// JsonArray item
					final JsonArray args = (JsonArray) ruleObj;
					error = FunJson.<I, AbstractException>exec(args, fun);
				}
			}
		}
		return error;
	}

	// Inner container to verify item
	public static <A, E> AbstractException verify(final Pair pair, final ParamsMap input,
			final FnVerify<A, E> fun) {
		// 1. item -> Pair extracted from JsonObject key = value
		final String field = pair.getKey();
		final Object actual = input.get(field);
		final Object expected = pair.getValue();
		// 2. Check process is in the function
		AbstractException error = null;
		if (null != actual) {
			A actualRef = (A) actual;
			E expectedRef = (E) expected;
			error = fun.execute(field, actualRef, expectedRef);
		}
		return error;
	}
}
