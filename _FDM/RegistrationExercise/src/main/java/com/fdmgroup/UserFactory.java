package com.fdmgroup;

/**
 * Creates Users for the parent class
 * @author Christopher Kemerait
 */
public class UserFactory 
{
	public UserFactory()
	{
		
	}
	
	/**
	 * Creates and returns a User
	 * @author Christopher Kemerait
	 */
	public User createUser(String username, String password, String role) 
	{
		User user = new User(username, password, role);
		
		return user;
	}

}
