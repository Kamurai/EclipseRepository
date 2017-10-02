package com.fdmgroup.registration;

public class UserFactory 
{

	public User createUser(String username, String password, String role) 
	{
		LoggingObject.log("info: created user: " + username + " from factory.", 2);
		return new User(username, password, role);
	}

}
