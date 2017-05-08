package org.lg.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.lg.cache.Cachette;
import org.lg.cache.impl.HashCachette;
import org.lg.cv.Defaults;
import org.lg.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** **/
@SuppressWarnings("unchecked")
public final class Instance {
	private static final Logger LOGGER = LoggerFactory.getLogger(Instance.class);
	// Cache references for singleton
	private static final Cachette CACHE = new HashCachette();

	public static <T> T instance(final String className, final Object... params) {
		final Class<?> clazz = Metadata.clazz(className);
		T ret = null;
		try {
			if (null != clazz) {
				ret = construct(clazz, params);
			}
		} catch (SecurityException ex) {
			Log.jvmError(LOGGER, ex);
		} catch (Exception ex) {
			Log.jvmError(LOGGER, ex);
		}
		return ret;
	}

	// Singleton method and put cache here.
	public static <T> T singleton(final String className, final Object... params) {
		T ret = CACHE.get(className);
		if (null == ret) {
			ret = instance(className, params);
			if (null != ret) {
				CACHE.put(className, ret);
			}
		}
		return ret;
	}

	private static <T> T construct(final Class<?> clazz, final Object... params) {
		T ret = null;
		final Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (final Constructor<?> constructor : constructors) {
			// Length is not match, skip
			if (params.length != constructor.getParameterTypes().length) {
				continue;
			}
			ret = construct(constructor, params);
			if (null != ret) {
				break;
			}
		}
		return ret;
	}

	private static <T> T construct(final Constructor<?> constructor, final Object... params) {
		if (!constructor.isAccessible()) {
			constructor.setAccessible(true);
		}
		T ret = null;
		try {
			ret = (T) (constructor.newInstance(params));
		} catch (InvocationTargetException ex) {
			Log.jvmError(LOGGER, ex);
		} catch (IllegalArgumentException ex) {
			Log.jvmError(LOGGER, ex);
		} catch (InstantiationException | IllegalAccessException ex) {
			Log.jvmError(LOGGER, ex);
		}
		return ret;
	}

	/** Extraction class to get metadata **/
	public static final class Metadata {
		/** Get class by name **/
		public static Class<?> clazz(final String className) {
			Class<?> ret = null;
			try {
				ret = Class.forName(className);
			} catch (ClassNotFoundException ex) {
				Log.jvmError(LOGGER, ex);
			}
			return ret;
		}

		/** Get generic T **/
		public static Class<?> genericT(final Class<?> clazz) {
			return genericT(clazz, Defaults.INDEX);
		}

		public static Class<?> genericT(final Class<?> clazz, final int idx) {
			Class<?> ret = null;
			final Type type = clazz.getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				final Type[] params = ((ParameterizedType) type).getActualTypeArguments();
				if (idx < params.length) {
					ret = (Class<?>) params[idx];
				}
			}
			return ret;
		}
	}

	private Instance() {
	}
}
