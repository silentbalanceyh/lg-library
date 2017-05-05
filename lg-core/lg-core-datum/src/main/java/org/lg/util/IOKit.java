package org.lg.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.lg.ce.json.JsonArray;
import org.lg.ce.json.JsonObject;
import org.lg.cv.Defaults;
import org.lg.cv.Encodings;
import org.lg.cv.Symbols;
import org.lg.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.guard.Guarded;

/** **/
@Guarded
public final class IOKit {
	private static final Logger LOGGER = LoggerFactory.getLogger(IOKit.class);
	/** **/
	public static JsonArray getJArray(@NotNull @NotEmpty @NotBlank final String filename){
		return new JsonArray(getString(filename));
	}
	/** **/
	public static JsonObject getJObject(@NotNull @NotEmpty @NotBlank final String filename){
		return new JsonObject(getString(filename));
	}
	/** **/
	public static String getString(@NotNull @NotEmpty @NotBlank final String filename) {
		final InputStream in = getFile(filename, null);
		final StringBuilder ret = new StringBuilder(Defaults.BUFFER_SIZE);
		BufferedReader reader = null;
		String content = null;
		try {
			if (null != in) {
				reader = new BufferedReader(new InputStreamReader(in, Encodings.UTF_8));
				String line = null;
				while (null != (line = reader.readLine())) {
					ret.append(line).append(Symbols.NEWLINE);
				}
				content = ret.toString();
				reader.close();
			}
		} catch (UnsupportedEncodingException ex) {
			Log.jvmError(LOGGER, ex);
		} catch (IOException ex) {
			Log.jvmError(LOGGER, ex);
		} finally {
			try {
				if (null != in) {
					in.close();
				}
				if (null != reader){
					reader.close();
				}
			} catch (IOException ex) {
				Log.jvmError(LOGGER, ex);
			}
		}
		return content;
	}

	/** **/
	public static URL getUrl(@NotNull @NotEmpty @NotBlank final String filename) {
		final ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = null;
		if (null != loader) {
			url = loader.getResource(filename);
			if (null == url) {
				url = IOKit.class.getResource(filename);
			}
		}
		return url;
	}
	/** **/
	public static InputStream getFile(@NotNull @NotEmpty @NotBlank final String filename){
		return getFile(filename, null);
	}
	/** **/
	public static InputStream getFile(@NotNull @NotEmpty @NotBlank final String filename, final Class<?> clazz) {
		// 1.assign reference to searchCls
		Class<?> searchCls = (null == clazz) ? IOKit.class : clazz;
		// 2.Build file object with new File()
		InputStream ret = readStream(new File(filename));
		// 3.Get reference from current environment
		if (null == ret)
			ret = readStream(filename);
		// 4.Get reference from input clazz
		if (null == ret)
			ret = readStream(filename, searchCls);
		return ret;
	}

	private static InputStream readStream(final String filename, final Class<?> clazz) {
		if (null == clazz) {
			return readStream(filename);
		} else {
			return clazz.getResourceAsStream(filename);
		}
	}

	private static InputStream readStream(final String filename) {
		final ClassLoader loader = Thread.currentThread().getContextClassLoader();
		return loader.getResourceAsStream(filename);
	}

	private static InputStream readStream(final File file) {
		InputStream in = null;
		if (null != file && file.exists() && file.isFile()) {
			try {
				in = new FileInputStream(file);
			} catch (FileNotFoundException ex) {
				Log.jvmError(LOGGER, ex);
			}
		}
		return in;
	}
}
