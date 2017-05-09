package org.lg.cv;

public interface Patterns {
	/** Default **/
	String FORMAT_DFT = "yyyy-MM-dd HH:mm:ss";
	/** **/
	String FORMAT_DATE_ONLY = "yyyy-MM-dd";
	/** **/
	String FORMAT_TIME_ONLY = "HH:mm:ss";
	/** **/
	String FORMAT_TP = "yyyy-MM-dd'T'HH:mm:ssZ";
	// All supported
	String[] FORMAT_SUPPORTED = new String[]{
		FORMAT_DFT, FORMAT_DATE_ONLY,
		FORMAT_TIME_ONLY, FORMAT_TP
	};
}
