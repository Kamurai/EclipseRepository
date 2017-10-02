package com.fdmgroup;

import java.io.Serializable;

/**
 * Users holds the following fields:
 * String username: This should be a unique identifier for the user,
 * String password: This is a security password that the user will use to log into the system,
 * String role: This is the role that will be displayed on the user's profile,
 * long serialVersionUID: Unique ID for serialization
 * @author Christopher Kemerait
 */
public class User implements Serializable 
{
	private static long serialVersionUID = 4578456564354354399L;

	private String username;
	private String password;
	private String role;

	/**
	 * The constructor receives and sets the following fields:
	 * username String: This should be a unique identifier for the user,
	 * password String: This is a security password that the user will use to log into the system,
	 * role String: This is the role that will be displayed on the user's profile
	 * @author Christopher Kemerait
	 */
	public User(String username, String password, String role) 
	{
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/**
	 * The constructor receives a User and sets the following fields:
	 * username String: This should be a unique identifier for the user,
	 * password String: This is a security password that the user will use to log into the system,
	 * role String: This is the role that will be displayed on the user's profile
	 * @author Christopher Kemerait
	 */
	public User(User user)
	{
		this.username = user.username;
		this.password = user.password;
		this.role = user.role;
	}

	/**
	 * print() sends the following User fields to the console:
	 * String username: This should be a unique identifier for the user,
	 * String password: This is a security password that the user will use to log into the system,
	 * String role: This is the role that will be displayed on the user's profile
	 *@author Christopher Kemerait
	 */
	public void print()
	{
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Role: " + role);
		System.out.println("");
	}

	/**
	 * getUsername() returns the User's username
	 *@author Christopher Kemerait
	 */
	public Object getUsername() 
	{
		return username;
	}

}
