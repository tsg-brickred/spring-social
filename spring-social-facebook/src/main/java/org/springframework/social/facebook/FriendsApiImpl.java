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
package org.springframework.social.facebook;

import java.util.List;
import java.util.Map;

import org.springframework.social.facebook.support.extractors.ProfileResponseExtractor;
import org.springframework.social.facebook.support.extractors.ReferenceResponseExtractor;
import org.springframework.social.facebook.types.FacebookProfile;
import org.springframework.social.facebook.types.Reference;
import org.springframework.web.client.RestTemplate;

public class FriendsApiImpl implements FriendsApi {
	
	private final GraphApi graphApi;
	private ReferenceResponseExtractor referenceExtractor;
	private final RestTemplate restTemplate;

	public FriendsApiImpl(GraphApi graphApi, RestTemplate restTemplate) {
		this.graphApi = graphApi;
		this.restTemplate = restTemplate;
		referenceExtractor = new ReferenceResponseExtractor();
		profileExtractor = new ProfileResponseExtractor();
	}
	
	public List<Reference> getFriendLists() {
		return getFriendLists("me");
	}

	public List<Reference> getFriendLists(String userId) {
		return graphApi.fetchConnections(userId, "friendlists", referenceExtractor);
	}
	
	public Reference getFriendList(String friendListId) {
		return graphApi.fetchObject(friendListId, referenceExtractor);
	}
	
	public List<Reference> getFriendListMembers(String friendListId) {
		return graphApi.fetchConnections(friendListId, "members", referenceExtractor);
	}

	public List<FacebookProfile> getFriendListMemberProfiles(String friendListId) {
		return graphApi.fetchConnections(friendListId, "members", profileExtractor, FULL_PROFILE_FIELDS);
	}

	public Reference createFriendList(String name) {
		return createFriendList("me", name);
	}
	
	public Reference createFriendList(String userId, String name) {
		@SuppressWarnings("unchecked")
		Map<String, Object> friendListMap = restTemplate.postForObject(GraphApi.CONNECTION_URL + "?name={name}", "", Map.class, userId, "friendlists", name);
		return referenceExtractor.extractObject(friendListMap);
	}
	
	public void deleteFriendList(String friendListId) {
		graphApi.delete(friendListId);
	}

	public void addToFriendList(String friendListId, String friendId) {
		restTemplate.postForObject(GraphApi.CONNECTION_URL + "/{friendId}", "", String.class, friendListId, "members", friendId);
	}
	
	public void removeFromFriendList(String friendListId, String friendId) {
		restTemplate.delete(GraphApi.CONNECTION_URL + "/{friendId}", friendListId, "members", friendId);
	}
	
	public List<Reference> getFriends() {
		return getFriends("me");
	}
	
	public List<FacebookProfile> getFriendProfiles() {
		return getFriendProfiles("me");
	}

	public List<Reference> getFriends(String userId) {
		return graphApi.fetchConnections(userId, "friends", referenceExtractor);
	}
	
	public List<FacebookProfile> getFriendProfiles(String userId) {
		return graphApi.fetchConnections(userId, "friends", profileExtractor, FULL_PROFILE_FIELDS);
	}

	private static final String[] FULL_PROFILE_FIELDS = {"id", "username", "name", "first_name", "last_name", "gender", "locale", "education", "work", "email", "third_party_id", "link", "timezone", "updated_time", "verified", "about", "bio", "birthday", "location", "hometown", "interested_in", "religion", "political", "quotes", "relationship_status", "significant_other", "website"};
	private ProfileResponseExtractor profileExtractor;
	
}