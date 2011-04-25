package org.brickred.socialauth.spring;

import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

public class SocialAuthServiceProvider implements
		OAuth2ServiceProvider<SocialAuthApi> {
	
	private SocialAuthApi provider;
	
	public SocialAuthServiceProvider(String providerId) {
		this.provider = new SocialAuthTemplate(providerId);
	}

	@Override
	public OAuth2Operations getOAuthOperations() {
		return new SocialAuthOperations(provider);
	}

	@Override
	public SocialAuthApi getServiceApi(String accessToken) {
		return this.provider;
	}

}
