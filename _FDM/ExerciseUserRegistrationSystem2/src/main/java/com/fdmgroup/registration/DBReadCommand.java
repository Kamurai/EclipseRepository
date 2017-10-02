package com.fdmgroup.registration;

public class DBReadCommand implements ReadCommand 
{
	UsersDAO usersDAO = new UsersDAO();
	
	@Override
	public User readUser(String username) throws UserNotReadException 
	{
		return usersDAO.getUser(username);
	}

}
