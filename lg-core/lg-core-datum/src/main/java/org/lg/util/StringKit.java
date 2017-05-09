package org.lg.util;

import org.lg.cv.Defaults;
import org.lg.cv.Symbols;

public final class StringKit {
	// Public Api
	public static boolean notNull(final String strValue) {
		boolean ret = false;
		if (isNotBlank(strValue) && isNotEmpty(strValue)) {
			ret = true;
		}
		return ret;
	}

	public static boolean isNull(final String strValue) {
		boolean ret = false;
		if (isBlank(strValue) || isEmpty(strValue.trim())) {
			ret = true;
		}
		return ret;
	}

	private static boolean isNotEmpty(final CharSequence string) {
		return string != null && string.length() > 0;
	}

	private static boolean isBlank(final CharSequence string) {
		return ((string == null) || containsOnlyWhitespaces(string));
	}

	private static boolean isNotBlank(final String string) {
		return ((string != null) && !containsOnlyWhitespaces(string));
	}

	private static boolean isEmpty(final CharSequence string) {
		return ((string == null) || (string.length() == 0));
	}

	private static boolean containsOnlyWhitespaces(CharSequence string) {
		int size = string.length();
		for (int i = 0; i < size; i++) {
			char c = string.charAt(i);
			if (false == (c <= Symbols.SPACE.charAt(Defaults.INDEX))) {
				return false;
			}
		}
		return true;
	}

	private StringKit() {
	}
}
