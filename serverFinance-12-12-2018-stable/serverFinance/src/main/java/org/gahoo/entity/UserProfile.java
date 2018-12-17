package org.gahoo.entity;

public class UserProfile {

	private User user;
	private Profile profile;
	public UserProfile(User user, Profile profile) {
		super();
		this.user = user;
		this.profile = profile;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
	
}
