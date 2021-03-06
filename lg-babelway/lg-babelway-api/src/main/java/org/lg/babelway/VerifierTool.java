package org.lg.babelway;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.lg.facade.Verifier;
import org.lg.util.Instance;
import org.lg.verifier.InVerifier;
import org.lg.verifier.MinVerifier;
import org.lg.verifier.RequiredVerifier;
import org.lg.verifier.TimeVerifier;

// Default package and could only be used here.
class VerifierTool {

	private static final ConcurrentMap<String, Verifier> VERIFIERS = new ConcurrentHashMap<>();

	static {
		// Verifier Mapping
		VERIFIERS.put(Verifier.Names.REQUIRED, Instance.singleton(RequiredVerifier.class));
		VERIFIERS.put(Verifier.Names.IN, Instance.singleton(InVerifier.class));
		VERIFIERS.put(Verifier.Names.MIN, Instance.singleton(MinVerifier.class));
		VERIFIERS.put(Verifier.Names.TIME, Instance.singleton(TimeVerifier.class));
	}

	public static Verifier select(final String name) {
		return VERIFIERS.get(name);
	}
}
