package org.lg.babelway.test;

import org.lg.babelway.test.cv.TestConstant;
import org.lg.ce.json.JsonObject;
import org.lg.ce.model.ParamsMap;
import org.lg.cv.Symbols;
import org.lg.facade.Normalizer;
import org.lg.hors.AbstractException;
import org.lg.util.IOKit;
import org.lg.util.Instance;

public class UnitNormalizer {
	
	private static String getDataPath(final String filename){
		return TestConstant.Folder.DATA_NORMALIZE + Symbols.SLASH + filename;
	}
	/** Test Shared Tool for normalizer **/
	public static void testNormalizer(final Class<?> normalizerCls, final String filename) throws AbstractException {
		final Normalizer normalizer = Instance.singleton(normalizerCls);
		final JsonObject input = IOKit.getJObject(getDataPath(filename));
		final ParamsMap params = new ParamsMap(input);
		normalizer.normalize(params);
	}
}
