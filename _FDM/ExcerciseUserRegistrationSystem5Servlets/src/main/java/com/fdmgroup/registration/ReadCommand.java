package com.fdmgroup.registration;

public interface ReadCommand {
	
	public User readUser(String username) throws UserNotReadException;

}
