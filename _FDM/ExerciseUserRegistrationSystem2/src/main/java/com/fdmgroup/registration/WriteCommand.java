package com.fdmgroup.registration;

public interface WriteCommand {
	void writeUser(User user) throws UserNotWrittenException;

	void removeUser(String username) throws UserNotRemovedException;


}
