package org.brickred.socialauth.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.brickred.socialauth.AuthProvider;
import org.brickred.socialauth.AuthProviderFactory;
import org.brickred.socialauth.Contact;
import org.brickred.socialauth.Profile;
import org.springframework.social.oauth2.AccessGrant;

public class SocialAuthTemplate implements SocialAuthApi {

	private AuthProvider provider;
	private Profile profile;
	
	public SocialAuthTemplate(String providerId){
		try {
			this.provider = AuthProviderFactory.getInstance(providerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getLoginRedirectUrl(String redirectUrl) {
		try {
			return provider.getLoginRedirectURL(redirectUrl);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public AccessGrant verifyResponse(HttpServletRequest request) {
		try {
			profile = provider.verifyResponse(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AccessGrant("accessToken", "scope", "refreshToken", 100000);
	}

	@Override
	public Profile getUserProfile() {
		return profile;
	}
	
	public List<Contact> getContacts(){
		try{
			return provider.getContactList();
		}catch(Exception e){
			return null;
		}
	}

}
