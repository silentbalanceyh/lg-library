package org.lg.suit.cv;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.lg.ce.json.JsonObject;
import org.lg.cv.Files;
import org.lg.cv.Symbols;
import org.lg.util.IOKit;
// Rule loader and static to load rule once.
public class RuleConfig {

	private static final ConcurrentMap<String, JsonObject> RULES = new ConcurrentHashMap<>();

	static {
		final List<String> files = IOKit.listFiles(Files.Folder.RULES);
		// Load once
		for (final String file : files) {
			// Calculate key
			final String key = file.replaceAll(Files.Ext.DOT_JSON, Symbols.EMPTY);
			// Load rule data
			final String path = Files.Folder.RULES + Symbols.SLASH + file;
			final JsonObject rule = IOKit.getJObject(path);
			RULES.put(key, rule);
		}
	}

	public static JsonObject loadRule(final String filename) {
		JsonObject ret = new JsonObject();
		if (RULES.containsKey(filename)) {
			ret = RULES.get(filename);
		}
		return ret;
	}
}
