package org.lg.babelway.normalize;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.junit.BeforeClass;
import org.junit.Test;
import org.lg.babelway.hors.NormalizerException;
import org.lg.babelway.test.UnitNormalizer;
import org.lg.babelway.test.cv.TestConstant;
import org.lg.cv.Defaults;
import org.lg.cv.Symbols;
import org.lg.hors.AbstractException;
import org.lg.log.Log;
import org.lg.util.IOKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicketNormalizerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketNormalizerTest.class);
	private static ConcurrentMap<String, Class<?>> NORMALIZER = new ConcurrentHashMap<>();

	@BeforeClass
	public static void setUp() {
		NORMALIZER.put("ticket", TicketNormalizer.class);
		NORMALIZER.put("tickets", TicketsNormalizer.class);
		NORMALIZER.put("deleteTicket", DeleteTicketNormalizer.class);
	}

	private Class<?> getNormalizer(final String filename) {
		final String key = filename.split(Symbols.DASH)[Defaults.INDEX];
		return NORMALIZER.get(key);
	}

	private int countByFlag(final String flag) {
		final List<String> files = IOKit.listFiles(TestConstant.Folder.DATA_NORMALIZE);
		int counter = Defaults.ZERO;
		for (final String file : files) {
			if (Defaults.ZERO <= file.indexOf(flag)) {
				counter++;
			}
		}
		return counter;
	}

	private void debugOutput(final String flag, final String file, final boolean isCommon) {
		if (isCommon) {
			if ("success".equals(flag)) {
				Log.info(LOGGER, "Expected Success: " + file);
			} else {
				Log.warn(LOGGER, "Expected Success: " + file);
			}
		} else {
			if ("success".equals(flag)) {
				Log.warn(LOGGER, "Expected Failure: " + file);
			} else {
				Log.info(LOGGER, "Expected Failure: " + file);
			}
		}		
		Log.info(LOGGER, "-------------------------End: " + file + "------------------");
	}

	private List<NormalizerException> execute(final String flag) throws AbstractException {
		final List<String> files = IOKit.listFiles(TestConstant.Folder.DATA_NORMALIZE);
		List<NormalizerException> errors = new ArrayList<>();
		for (final String file : files) {
			if (Defaults.ZERO <= file.indexOf(flag)) {
				final Class<?> normalizerCls = this.getNormalizer(file);
				if (null != normalizerCls) {
					try {
						UnitNormalizer.testNormalizer(normalizerCls, file);
						// Common Debug
						this.debugOutput(flag, file, true);
					} catch (AbstractException ex) {
						if (ex instanceof NormalizerException) {
							// Error Debug
							this.debugOutput(flag, file, false);
							errors.add((NormalizerException) ex);
						}
					}
				}
			}
		}
		return errors;
	}

	@Test
	public void testFailure() throws AbstractException {
		final List<NormalizerException> errors = this.execute("failure");
		final int errorCount = this.countByFlag("failure");
		assertEquals(errorCount, errors.size());
	}

	@Test
	public void testSuccess() throws AbstractException {
		final List<NormalizerException> errors = this.execute("success");
		assertEquals(Defaults.ZERO, errors.size());
	}
}
