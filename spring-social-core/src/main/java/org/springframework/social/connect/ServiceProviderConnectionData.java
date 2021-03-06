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
package org.springframework.social.connect;

public class ServiceProviderConnectionData {
	
	private String providerId;
	
	private String providerUserId;
	
	private String profileName;
	
	private String profileUrl;
	
	private String profilePictureUrl;
	
	private String accessToken;
	
	private String secret;
	
	private String refreshToken;
	
	private Long expireTime;

	public ServiceProviderConnectionData(String providerId, String providerUserId, String profileName, String profileUrl, String profilePictureUrl, String accessToken, String secret, String refreshToken, Long expireTime) {
		this.providerId = providerId;
		this.providerUserId = providerUserId;
		this.profileName = profileName;
		this.profileUrl = profileUrl;
		this.profilePictureUrl = profilePictureUrl;
		this.accessToken = accessToken;
		this.secret = secret;
		this.refreshToken = refreshToken;
		this.expireTime = expireTime;
	}

	public String getProviderId() {
		return providerId;
	}

	public String getProviderUserId() {
		return providerUserId;
	}

	public String getProfileName() {
		return profileName;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getSecret() {
		return secret;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public Long getExpireTime() {
		return expireTime;
	}
		
}