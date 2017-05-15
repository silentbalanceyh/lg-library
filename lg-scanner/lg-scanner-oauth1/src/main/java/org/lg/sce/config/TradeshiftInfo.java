package org.lg.sce.config;

import org.lg.cv.Files;

public interface TradeshiftInfo {
	
	String FILE_NAME = "tradeshift" + Files.Ext.DOT_PROP;
	
	interface OAuth1{
		
		String ENDPOINT = "ts.endpoint";
		
		String CONSUMER_KEY = "ts.consumer.key";
		
		String CONSUMER_SECRET = "ts.consumer.secret";
		
		String TOKEN = "ts.token";
		
		String TOKEN_SECRET = "ts.token.secret";
		
		String TENANT_ID = "ts.tenant.id";
		
		String ENCRIPTION = "ts.encription";
	}
	
	interface Header{
		
		String KEY_TENANT_ID = "X-Tradeshift-TenantId";
		
		String KEY_USER_AGENT = "User-Agent";
		
		String VALUE_AGENT = "TradeshiftJerseyTest/0.1";
	}
}
