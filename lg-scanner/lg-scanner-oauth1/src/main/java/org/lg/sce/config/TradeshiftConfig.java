package org.lg.sce.config;

import java.util.Properties;

import org.lg.config.impl.DatumLoader;

public final class TradeshiftConfig {
	private static final Properties CONFIG = DatumLoader.get(TradeshiftInfo.FILE_NAME);
	
	static{
		System.out.println(CONFIG);
	}
	private TradeshiftConfig(){}
	
	public static String endpoint(){
		return CONFIG.getProperty(TradeshiftInfo.OAuth1.ENDPOINT);
	}
	
	public static String consumerKey(){
		return CONFIG.getProperty(TradeshiftInfo.OAuth1.CONSUMER_KEY);
	}
	
	public static String consumerSecret(){
		return CONFIG.getProperty(TradeshiftInfo.OAuth1.CONSUMER_SECRET);
	}
	
	public static String token(){
		return CONFIG.getProperty(TradeshiftInfo.OAuth1.TOKEN);
	}
	
	public static String tokenSecret(){
		return CONFIG.getProperty(TradeshiftInfo.OAuth1.TOKEN_SECRET);
	}
	
	public static String encription(){
		return CONFIG.getProperty(TradeshiftInfo.OAuth1.ENCRIPTION);
	}
	
	public static String tenantId(){
		return CONFIG.getProperty(TradeshiftInfo.OAuth1.TENANT_ID);
	}
}
