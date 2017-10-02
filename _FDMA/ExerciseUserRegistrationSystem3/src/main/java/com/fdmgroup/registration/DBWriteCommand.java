package com.fdmgroup.registration;

public class DBWriteCommand implements WriteCommand
{
	UsersDAO usersDAO = new UsersDAO();
	LoggingObject loggingObject = new LoggingObject();
	
	@Override
	public void writeUser(User user) throws UserNotWrittenException 
	{
		//usersDAO.addUser(user);	
		usersDAO.create(user);
		LoggingObject.log("info: write user: " + user.getUsername() + " from database.", 2);
	}

	public void removeUser(String username) throws UserNotRemovedException
	{
		//usersDAO.removeUser(username);
		usersDAO.delete(username);
		LoggingObject.log("info: removed user: " + username + " from database.", 2);
	}
	
	public void updateUser(User user) throws UserNotRemovedException
	{
		usersDAO.update(user);
		LoggingObject.log("info: updated user: " + user.getUsername() + " from database.", 2);
	}


}

