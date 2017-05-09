package org.lg.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.lg.cv.Defaults;
import org.lg.cv.Patterns;
import org.lg.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DatetimeKit {
	private static final Logger LOGGER = LoggerFactory.getLogger(DatetimeKit.class);

	public static Date toDate(final String input) {
		Date ret = toDate(input, null);
		if (null == ret) {
			// Default conversation failure
			final int length = Patterns.FORMAT_SUPPORTED.length;
			for (int idx = Defaults.INDEX; idx < length; idx++) {
				final String pattern = Patterns.FORMAT_SUPPORTED[idx];
				ret = toDate(input, pattern);
				if(null != ret){
					break;
				}
			}
		}
		return ret;
	}

	public static Date toDate(final String input, final String pattern) {
		Date ret = null;
		try {
			DateTime date = null;
			if (null == pattern) {
				date = new DateTime(input);
			} else {
				final DateTimeFormatter format = DateTimeFormat.forPattern(pattern);
				date = format.parseDateTime(input);
			}
			ret = date.toDate();
		} catch (IllegalArgumentException ex) {
			Log.jvmError(LOGGER, ex);
		}
		return ret;
	}

	private DatetimeKit() {
	}
}
