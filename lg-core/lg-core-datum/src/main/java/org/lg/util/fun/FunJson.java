package org.lg.util.fun;

import org.lg.ce.json.JsonArray;
import org.lg.ce.json.JsonObject;
import org.lg.ce.model.Pair;
import org.lg.cv.Defaults;
import org.lg.fun.robject.FnObject;

@SuppressWarnings("unchecked")
public final class FunJson {
	
	public static <T> T exec(final JsonArray array, final FnObject fun, final Class<T> clazz) {
		T reference = null;
		final int size = array.size();
		for (int idx = Defaults.INDEX; idx < size; idx++) {
			final Object value = array.getValue(idx);
			if (null != value) {
				final Object ret = fun.execute(value);
				if (null != ret && clazz.isInstance(ret)) {
					reference = (T) ret;
					break;
				}
			}
		}
		return reference;
	}

	public static <T> T exec(final JsonObject object, final FnObject fun, final Class<T> clazz) {
		T reference = null;
		for (final String field : object.fieldNames()) {
			final Object value = object.getValue(field);
			if (null != value) {
				// Pair for each JsonObject field = value
				final Pair pair = new Pair(field, value);
				final Object ret = fun.execute(pair);
				if (null != ret && clazz.isInstance(ret)) {
					reference = (T) ret;
					break;
				}
			}
		}
		return reference;
	}
}
