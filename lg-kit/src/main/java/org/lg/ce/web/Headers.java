package org.lg.ce.web;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.guard.Guarded;

/**
 * Simple header data structure, default scope to let other class inherit.
 * @author lang
 *
 */
@Guarded
public class Headers implements Serializable{

	@NotNull
	private final transient ConcurrentMap<String,String> data = new ConcurrentHashMap<>();
	
	public Headers(){}
	/**
	 * Set header key = value
	 * @param key
	 * @param value
	 */
	public void put(@NotNull @NotEmpty @NotBlank final String key, final String value){
		this.data.put(key, value);
	}
	/**
	 * Get value by key
	 * @param key
	 * @return
	 */
	public String get(@NotNull @NotEmpty @NotBlank final String key){
		return this.data.get(key);
	}
}
