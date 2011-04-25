package org.brickred.socialauth.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.brickred.socialauth.Contact;
import org.brickred.socialauth.Profile;
import org.springframework.social.oauth2.AccessGrant;

public interface SocialAuthApi {

	public String getLoginRedirectUrl(String redirectUrl);
	
	public AccessGrant verifyResponse(HttpServletRequest request);
	
	public Profile getUserProfile();
	
	public List<Contact> getContacts();
}
