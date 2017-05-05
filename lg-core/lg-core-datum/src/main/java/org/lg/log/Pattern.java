package org.lg.log;
/**
 * Message pattern, used inner current package
 */
interface Pattern {
	/** JVM Error **/
	String E_JVM = "[***JVM ERROR***][JVM] Exception: {0} = {1}";
	/** Tradeshift Error **/
	String E_TS = "[***TS ERROR***][{0}] Exception: {1} = {2}";
}
