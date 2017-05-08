package org.lg.log;

import java.text.MessageFormat;
import java.util.Properties;

import org.lg.config.impl.DatumLoader;
import org.lg.cv.Defaults;
import org.lg.cv.Files;
import org.lg.cv.Symbols;
import org.lg.hors.AbstractException;
import org.slf4j.Logger;

import net.sf.oval.constraint.Max;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.guard.Guarded;

/**
 * Logger for current library
 */
@Guarded
public final class Log {

	private static Properties ERRORS = DatumLoader.get(Files.Prop.ERROR);

	/** JVM Error spec **/
	public static void jvmError(@NotNull final Logger logger, @NotNull final Throwable ex) {
		error(logger, Pattern.E_JVM, ex.getClass().getName(), ex.getMessage());
	}

	/** Ts Error spec **/
	public static void tsError(@NotNull final Logger logger, @NotNull final AbstractException ex,
			final Object... params) {
		final String key = "E" + ex.getErrorCode();
		final String message = ex.getErrorMessage();
		error(logger, Pattern.E_TS, key, ex.getClass().getName(), message);
	}

	/** Error **/
	public static void error(@NotNull final Logger logger, final String message, final Object... params) {
		output(logger::isErrorEnabled, logger::error, message, params);
	}

	/** Warn **/
	public static void warn(@NotNull final Logger logger, final String message, final Object... params) {
		output(logger::isWarnEnabled, logger::warn, message, params);
	}

	/** Info **/
	public static void info(@NotNull final Logger logger, final String message, final Object... params) {
		output(logger::isInfoEnabled, logger::info, message, params);
	}

	/** Common **/
	private static void output(final FnEnable fnCheck, final FnLog fnOutput, final String message,
			final Object... params) {
		if (fnCheck.enabled()) {
			fnOutput.output(format(message, params));
		}
	}

	/** Error format **/
	public static String format(@Max(-10000) final int code, final Object... params) {
		final String key = "E" + Math.abs(code);
		final StringBuilder message = new StringBuilder(Defaults.BUFFER_SIZE);
		message.append(Symbols.LEFT_SQ_BRACKET).append(key).append(Symbols.RIGHT_SQ_BRACKET);
		final String pattern = ERRORS.getProperty(key);
		message.append(Symbols.SPACE).append(format(pattern, params));
		return message.toString();
	}

	/** Input format **/
	private static String format(final String pattern, final Object... params) {
		String message = pattern;
		if (Defaults.ZERO < params.length) {
			message = MessageFormat.format(pattern, params);
		}
		return message;
	}

	private Log() {
	}
}

@FunctionalInterface
interface FnLog {
	void output(String message);
}

@FunctionalInterface
interface FnEnable {
	boolean enabled();
}
