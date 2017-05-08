package org.lg.cache;

import java.util.Set;

/** Replacement map structure **/
public interface Cachette {
	
	<V> V get(String key);
	
	<V> void put(String key, V value);
	
	<V> boolean remove(String key);
	
	int size();
	
	boolean clean();
	
	Set<String> keys();
}
