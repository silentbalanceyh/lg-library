package org.lg.cache.impl;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.lg.cache.Cachette;

/** **/
@SuppressWarnings({ "unchecked" })
public class HashCachette implements Cachette {
	private transient ConcurrentMap<String, Object> CACHE = new ConcurrentHashMap<>();

	@Override
	public <V> V get(String key) {
		final Object reference = CACHE.get(key);
		V ret = null;
		if (null != reference) {
			ret = (V) reference;
		}
		return ret;
	}

	@Override
	public <V> void put(String key, V value) {
		CACHE.put(key, value);
	}

	@Override
	public <V> boolean remove(String key) {
		if (CACHE.containsKey(key)) {
			CACHE.remove(key);
		}
		return true;
	}

	@Override
	public int size() {
		return CACHE.size();
	}

	@Override
	public boolean clean() {
		CACHE.clear();
		return true;
	}

	@Override
	public Set<String> keys() {
		return CACHE.keySet();
	}

}
