package com.fdmgroup.demos;

import java.util.HashSet;
import java.util.Set;


public class LogInManager {

	private Set<String> loggedInUsers = new HashSet<String>();
	
	public boolean logIn(User user){
		
		if(user.isLoggedIn())
			return false;
		
		user.setLoggedIn(true);
		
		return loggedInUsers.add(user.getUsername());

	}
	
	public boolean logOut(User user){
		
		if(!user.isLoggedIn())
			return false;
		
		user.setLoggedIn(false);
		
		return loggedInUsers.remove(user.getUsername());
	}
}
