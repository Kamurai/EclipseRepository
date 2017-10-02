package com.fdmgroup.registration;

public class DBWriteCommand implements WriteCommand
{
	UsersDAO usersDAO = new UsersDAO();
	
	@Override
	public void writeUser(User user) throws UserNotWrittenException 
	{
		usersDAO.addUser(user);		
	}

	public void removeUser(String username) throws UserNotRemovedException
	{
		usersDAO.removeUser(username);	
	}

}
