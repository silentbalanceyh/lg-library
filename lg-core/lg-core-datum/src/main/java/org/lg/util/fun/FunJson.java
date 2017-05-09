package org.lg.util.fun;

import org.lg.ce.json.JsonArray;
import org.lg.ce.json.JsonObject;
import org.lg.ce.model.Pair;
import org.lg.cv.Defaults;
import org.lg.fun.robject.FnObject;

@SuppressWarnings("unchecked")
public final class FunJson {

	public static <I, O> O exec(final JsonArray array, final FnObject<I, O> fun) {
		O reference = null;
		final int size = array.size();
		for (int idx = Defaults.INDEX; idx < size; idx++) {
			final Object value = array.getValue(idx);
			if (null != value) {
				final I args = (I) value;
				reference = fun.execute(args);
				// Capture the first result of iteration
				if(null != reference) break;
			}
		}
		return reference;
	}

	public static <I, O> O exec(final JsonObject object, final FnObject<Pair, O> fun) {
		O reference = null;
		for (final String field : object.fieldNames()) {
			final Object value = object.getValue(field);
			if (null != value) {
				// Pair for each JsonObject field = value
				final I args = (I) value;
				final Pair pair = new Pair(field, args);
				reference = fun.execute(pair);
				// Capture the first result of iteration
				if(null != reference) break;
			}
		}
		return reference;
	}
}
