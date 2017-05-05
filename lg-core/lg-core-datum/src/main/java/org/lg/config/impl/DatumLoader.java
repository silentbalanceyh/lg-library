package org.lg.config.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.lg.cv.Symbols;
import org.lg.log.Log;
import org.lg.util.IOKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.guard.Guarded;

/** **/
@Guarded
public class DatumLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(DatumLoader.class);
	/** **/
	private static final ConcurrentMap<String, Properties> FILES = new ConcurrentHashMap<>();

	/** **/
	public static Properties get(@NotNull @NotEmpty @NotBlank final String filename) {
		Properties ret = null;
		if (FILES.containsKey(filename)) {
			ret = FILES.get(filename);
		} else {
			ret = new Properties();
			final String path = filename.startsWith(Symbols.SLASH) ? filename : Symbols.SLASH + filename;
			final InputStream in = IOKit.getFile(path);
			if (null != in) {
				try {
					ret.load(in);
				} catch (IOException ex) {
					Log.jvmError(LOGGER, ex);
				}
				FILES.put(filename, ret);
			}
		}
		return ret;
	}
}
