package org.lg.babelway.normalize;

import org.junit.Test;
import org.lg.babelway.hors.NormalizerException;
import org.lg.ce.json.JsonObject;
import org.lg.ce.model.ParamsMap;
import org.lg.facade.Normalizer;
import org.lg.hors.AbstractException;
import org.lg.util.IOKit;
import org.lg.util.Instance;

public class NormalizerTest {

	@Test(expected = NormalizerException.class)
	public void testTicket() throws AbstractException {
		final Normalizer normalizer = Instance.singleton(TicketNormalizer.class);
		final JsonObject input = IOKit.getJObject("test-normalization/ticket-data.json");
		final ParamsMap params = new ParamsMap(input);
		normalizer.normalize(params);
	}
}
