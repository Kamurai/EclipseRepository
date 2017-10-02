package com.fdmgroup.registration;

public class UserFactory {

	public User createUser(String username, String password, String role) {
		return new User(username, password, role);
	}

}
