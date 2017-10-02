package com.fdmgroup;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * FileReadCommand holds the following fields:
 * filename String: This should be the file to which this object writes
 * @author Christopher Kemerait
 */
public class FileReadCommand implements ReadCommand
{
	private String filename;
	
	/**
	 * The constructor receives and sets the following fields:
	 * filename String: This should be the file to which this object writes
	 * @author Christopher Kemerait
	 */
	public FileReadCommand(String filename)
	{
		this.filename = filename;
	}
	
	/**
	 * readFirstUser() receives the first user from a file:
	 * The method pulls the first user object from the file
	 * @depreciated
	 *@author Christopher Kemerait
	 */
	@Override
	public User readFirstUser() 
	{
		User readUser = new User("", "", "");
		
		try
		(
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
		)
		{
			readUser = (User) ois.readObject();
		}
		catch(IOException e)
		{
			readUser = null;
		}
		catch(ClassNotFoundException e)
		{
			readUser = null;
		}
		
		return readUser;
	}

	/**
	 * readUser(String username) receives a username and attempts to find a user with that username:
	 * The method reads through the UserList
	 * and the method either returns the target user or null
	 *@author Christopher Kemerait
	 */
	public User readUser(String username)
	{
		User readUser = new User("", "", "");
		List<User> userList = new ArrayList<User>();
		
		try
		(
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
		)
		{
			userList = (List<User>) ois.readObject();
			ois.close();
		}
		catch(IOException e)
		{
			userList = null;
		}
		catch(ClassNotFoundException e)
		{
			userList = null;
		}
		
		for(int x = 0; x < userList.size(); x++)
		{
			if( userList.get(x).getUsername().equals(username) )
			{
				return userList.get(x);
			}
		}
		
		readUser = null;
		return readUser;
		
	}
	
	/**
	 * readUsers()  attempts to return the entire user list:
	 * The method reads the file and retrieves the UserList
	 * the method either returns the user list or a null list
	 *@author Christopher Kemerait
	 */
	@Override
	public List<User> readUsers() 
	{
		User readUser = new User("", "", "");
		List<User> userList = new ArrayList<User>();
				
		try
		(
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
		)
		{
			userList = (List<User>) ois.readObject();
			ois.close();			
		}
		catch(IOException e)
		{
			userList = null;
		}
		catch(ClassNotFoundException e)
		{
			userList = null;
		}
			
		return userList;
	}

}
