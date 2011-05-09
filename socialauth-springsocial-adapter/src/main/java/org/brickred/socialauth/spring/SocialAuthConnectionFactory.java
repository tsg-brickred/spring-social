package org.brickred.socialauth.spring;

import org.springframework.social.connect.support.OAuth2ServiceProviderConnectionFactory;

public class SocialAuthConnectionFactory extends OAuth2ServiceProviderConnectionFactory<SocialAuthApi> {
	
	public SocialAuthConnectionFactory(String providerStr) {
		super(providerStr, new SocialAuthServiceProvider(providerStr), new SocialAuthServiceApiAdapter());
	}
	
	
}
