package org.lg.cv;
/** **/
public interface Files {
	/** **/
	interface Ext {
		/** .class **/
		String DOT_CLASS = ".class";
		/** .java **/
		String DOT_JAVA = ".java";
		/** .properties **/
		String DOT_PROP = ".properties";
	}

	interface Prop{
		/** **/
		String ERROR = "errors" + Ext.DOT_PROP;
		/** **/
		String CONNECTOR = "connector" + Ext.DOT_PROP;
	}
	
	interface Folder{
		/** **/
		String RULES = "rules";
	}
}
