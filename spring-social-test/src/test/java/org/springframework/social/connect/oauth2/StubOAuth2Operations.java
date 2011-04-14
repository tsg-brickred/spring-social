/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.connect.oauth2;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.util.MultiValueMap;

class StubOAuth2Operations implements OAuth2Operations {

	public String buildAuthorizeUrl(String redirectUri, String scope, String state, GrantType grantType, MultiValueMap<String, String> additionalParameters) {
		return "http://springsource.org/oauth/authorize?scope=" + scope;
	}
	
	public String buildAuthenticateUrl(String redirectUri, String state, GrantType grantType, MultiValueMap<String, String> additionalParameters) {
		return buildAuthorizeUrl(redirectUri, null, state, grantType, additionalParameters);
	}

	public AccessGrant exchangeForAccess(String authorizationGrant, String redirectUri, MultiValueMap<String, String> additionalParameters) {
		return new AccessGrant("12345", null, "23456", 3600);
	}
	
	public AccessGrant refreshAccess(String refreshToken, String scope, MultiValueMap<String, String> additionalParameters) {
		return new AccessGrant("12345", null,  "23456", 3600);
	}
}