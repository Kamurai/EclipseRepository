package com.fdmgroup.registration;

import java.util.List;

public class DBReadCommand implements ReadCommand 
{
	UsersDAO usersDAO = new UsersDAO();
	LoggingObject loggingObject = new LoggingObject();
	
	public User readUser(String username) throws UserNotReadException 
	{
		User returnUser = null;
		
		returnUser = usersDAO.read(username);
		
		if(returnUser != null)
		{
			LoggingObject.log("info: read user: " + username + " from database.", 2);
		}
		else
		{
			LoggingObject.log("info: [DID NOT] read user: " + username + " from database: user not found.", 2);
		}
		//return usersDAO.getUser(username);
		return returnUser;
		
	}

	public List<User> readUsers(String username) throws UserNotReadException 
	{
		LoggingObject.log("info: read all users: " + username + " from database.", 2);
		//return usersDAO.listUsers();
		return usersDAO.readAll();
		
	}

}
