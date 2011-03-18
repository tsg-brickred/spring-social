package org.springframework.social.twitter;

import java.util.List;

public interface FriendsApi {

	/**
	 * Retrieves a list of users that the given user follows.
	 * @param userId The user's Twitter ID
	 * @return a list of TwitterProfiles
	 */
	List<TwitterProfile> getFriends(long userId);

	/**
	 * Retrieves a list of users that the given user follows.
	 * @param screenName The user's Twitter screen name
	 * @return a list of TwitterProfiles
	 */
	List<TwitterProfile> getFriends(String screenName);

	/**
	 * Retrieves a list of IDs for the Twitter users that the given user follows.
	 * @param userId the user's Twitter ID
	 * @return a list of user IDs
	 */
	List<Long> getFriendIds(long userId);

	/**
	 * Retrieves a list of IDs for the Twitter users that the given user follows.
	 * @param screenName the user's Twitter screen name
	 * @return a list of user IDs
	 */
	List<Long> getFriendIds(String screenName);

	/**
	 * Retrieves a list of users that the given user is being followed by
	 * @param userId The user's Twitter ID
	 * @return a list of TwitterProfiles
	 */
	List<TwitterProfile> getFollowers(long userId);
	
	/**
	 * Retrieves a list of users that the given user is being followed by
	 * @param screenName The user's Twitter screen name
	 * @return a list of TwitterProfiles
	 */
	List<TwitterProfile> getFollowers(String screenName);
	
	/**
	 * Retrieves a list of IDs for the Twitter users that follow the given user.
	 * @param userId the user's Twitter ID
	 * @return a list of user IDs
	 */
	List<Long> getFollowerIds(long userId);

	/**
	 * Retrieves a list of IDs for the Twitter users that follow the given user.
	 * @param screenName the user's Twitter screen name
	 * @return a list of user IDs
	 */
	List<Long> getFollowerIds(String screenName);

	/**
	 * Allows the authenticated user to follow (create a friendship) with another user.
	 * @param userId The Twitter ID of the user to follow
	 * @return the name of the followed user if successful
	 */
	String follow(long userId);
	
	/**
	 * Allows the authenticated user to follow (create a friendship) with another user.
	 * @param screenName The screen name of the user to follow
	 * @return the name of the followed user if successful
	 */
	String follow(String screenName);

	/**
	 * Allows the authenticated use to unfollow (destroy a friendship) with another user
	 * @param userId the Twitter ID of the user to unfollow 
	 * @return the name of the unfolloed user if successful 
	 */
	String unfollow(long userId);
	
	/**
	 * Allows the authenticated use to unfollow (destroy a friendship) with another user
	 * @param screenName the screen name of the user to unfollow 
	 * @return the name of the unfolloed user if successful 
	 */
	String unfollow(String screenName);
	
	/**
	 * Checks for a friendship between two users. Returns true if userA follows userB.
	 * @param userA the screen name of userA
	 * @param userB the screen name of userB
	 */
	boolean friendshipExists(String userA, String userB);

	/**
	 * Returns an array of numeric IDs for every user who has a pending request to follow the authenticating user.
	 */
	List<Long> getIncomingFriendships();

	/**
	 * Returns an array of numeric IDs for every protected user for whom the authenticating user has a pending follow request.
	 */
	List<Long> getOutgoingFriendships();
}