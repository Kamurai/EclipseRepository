package com.fdmgroup.registration;

public class UserFactory 
{

	public User createUser(String username, String firstname, String lastname, String email, String password) 
	{
		LoggingObject.log("info: created user: " + username + " from factory.", 2);
		return new User(username, firstname, lastname, email, password);
	}

}
