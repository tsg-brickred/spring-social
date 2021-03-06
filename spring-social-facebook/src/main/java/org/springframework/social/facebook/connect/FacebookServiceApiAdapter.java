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
package org.springframework.social.facebook.connect;

import org.springframework.social.BadCredentialsException;
import org.springframework.social.connect.ServiceProviderUser;
import org.springframework.social.connect.spi.ServiceApiAdapter;
import org.springframework.social.facebook.FacebookApi;
import org.springframework.social.facebook.types.FacebookProfile;

public class FacebookServiceApiAdapter implements ServiceApiAdapter<FacebookApi> {

	public boolean test(FacebookApi serviceApi) {
		try {
			serviceApi.userOperations().getUserProfile();
			return true;
		} catch (BadCredentialsException e) {
			return false;
		}
	}

	public ServiceProviderUser getUser(FacebookApi serviceApi) {
		FacebookProfile profile = serviceApi.userOperations().getUserProfile();		
		String profileUrl = "http://www.facebook.com/#!/profile.php?id=" + profile.getId();
		String profileImageUrl = "http://graph.facebook.com/" + profile.getId() + "/picture?type=large";
		return new ServiceProviderUser(profile.getId(), profile.getUsername(), profileUrl, profileImageUrl);
	}

	public void updateStatus(FacebookApi serviceApi, String message) {
		serviceApi.feedOperations().updateStatus(message);
	}

}
