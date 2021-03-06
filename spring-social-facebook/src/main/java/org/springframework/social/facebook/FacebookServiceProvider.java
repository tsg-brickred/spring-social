/*
 * Copyright 2010 the original author or authors.
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
package org.springframework.social.facebook;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * Facebook ServiceProvider implementation.
 * @author Keith Donald
 */
public class FacebookServiceProvider extends AbstractOAuth2ServiceProvider<FacebookApi> {

	public FacebookServiceProvider(String clientId, String clientSecret) {
		super(new FacebookOAuth2Template(clientId, clientSecret,
				"https://graph.facebook.com/oauth/authorize",
				"https://graph.facebook.com/oauth/access_token"));
	}

	public FacebookApi getServiceApi(String accessToken) {
		return new FacebookTemplate(accessToken);
	}
	
}