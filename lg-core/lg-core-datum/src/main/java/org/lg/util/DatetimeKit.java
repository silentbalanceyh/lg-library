package org.lg.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.lg.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DatetimeKit {
	private static final Logger LOGGER = LoggerFactory.getLogger(DatetimeKit.class);

	public static Date toDate(final String input) {
		Date ret = null;
		try {
			final DateTime date = new DateTime(input);
			ret = date.toDate();
		} catch (IllegalArgumentException ex) {
			Log.jvmError(LOGGER, ex);
		}
		return ret;
	}

	private DatetimeKit() {
	}
}
