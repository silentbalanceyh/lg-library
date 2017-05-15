package org.lg.sce.util;

import java.text.MessageFormat;

import org.lg.sce.config.TradeshiftConfig;
import org.lg.sce.config.TradeshiftInfo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.oauth.client.OAuthClientFilter;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthSecrets;

public class ApiLocator {

	public boolean test() {
		try {
			final Client client = Client.create();
			final OAuthParameters params = new OAuthParameters().signatureMethod(TradeshiftConfig.encription())
					.consumerKey(TradeshiftConfig.consumerKey()).token(TradeshiftConfig.token()).version();
			final OAuthSecrets secrets = new OAuthSecrets().consumerSecret(TradeshiftConfig.consumerSecret())
					.tokenSecret(TradeshiftConfig.tokenSecret());
			final OAuthClientFilter filter = new OAuthClientFilter(client.getProviders(), params, secrets);
			final String uri = MessageFormat.format(TradeshiftConfig.endpoint(), "external/network/connections");
			final WebResource res = client.resource(uri);
			res.addFilter(filter);
			final String networkResult = res.header(TradeshiftInfo.Header.KEY_TENANT_ID, TradeshiftConfig.tenantId())
					.header("Accept", "application/json").get(String.class);
			System.out.println(networkResult);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}
}
