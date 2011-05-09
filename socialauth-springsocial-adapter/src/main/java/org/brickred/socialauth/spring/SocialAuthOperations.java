package org.brickred.socialauth.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class SocialAuthOperations implements OAuth2Operations {

	private SocialAuthApi provider;
	
	public SocialAuthOperations(SocialAuthApi provider) {
		this.provider = provider;
	}
	
	@Override
	public String buildAuthorizeUrl(String redirectUri, String scope,
			String state) {
		System.out.println("Building Authorize URL for : " + redirectUri);
		return provider.getLoginRedirectUrl(redirectUri);
	}

	@Override
	public String buildAuthenticateUrl(String redirectUri, String state) {
		return null;
	}

	@Override
	public AccessGrant exchangeForAccess(String authorizationGrant,
			String redirectUri,
			MultiValueMap<String, String> additionalParameters) {
		RequestAttributes attr = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) attr).getRequest();
		return provider.verifyResponse(request);
	}

	@Override
	public AccessGrant refreshAccess(String refreshToken, String scope,
			MultiValueMap<String, String> additionalParameters) {
		return null;
	}

}
