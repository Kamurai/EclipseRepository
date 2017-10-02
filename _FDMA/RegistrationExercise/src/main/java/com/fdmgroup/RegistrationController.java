package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Users holds the following fields:
 * FileReadCommand fileReadCommand: This is the file reading object,
 * FileWriteCommand fileWriteCommand: This is the file writing object,
 * UserFactory userFactory: This is the object responsible for creating users,
 * List<User> userList: This is a list of Users
 * @author Christopher Kemerait
 */
public class RegistrationController 
{
	private FileReadCommand fileReadCommand;
	private FileWriteCommand fileWriteCommand;
	private UserFactory userFactory;
	private List<User> userList;
		
	/**
	 * The constructor receives and sets the following fields:
	 * FileReadCommand fileReadCommand: This is the file reading object,
	 * FileWriteCommand fileWriteCommand: This is the file writing object,
	 * UserFactory userFactory: This is the object responsible for creating users
	 * List<User> userList: This is a list of Users: it is initialized to an empyt list.
	 * @author Christopher Kemerait
	 */
	public RegistrationController(FileReadCommand fileReadCommand, FileWriteCommand fileWriteCommand, UserFactory userFactory) 
	{
		this.fileReadCommand = fileReadCommand;
		this.fileWriteCommand = fileWriteCommand;
		this.userFactory = userFactory;
		userList = new ArrayList<User>();
	}

	/**
	 * registerNewUser(username, password, role) creates a new user in the user list
	 *@author Christopher Kemerait
	 */
	public void registerNewUser(String username, String password, String role) 
	{
		boolean skip = false;
		
		for(int x = 0; x < userList.size(); x++)
		{
			if(userList.get(x).getUsername().equals(username))
			{
				skip = true;
			}
		}
		
		if(!skip)
			userList.add( userFactory.createUser(username, password, role) );
		
	}

	/**
	 * add(user) adds a user to the user list
	 *@author Christopher Kemerait
	 */
	public void add(User user) 
	{
		userList.add(user);		
	}

	/**
	 * getUsers() returns the user list
	 *@author Christopher Kemerait
	 */
	public List<User> getUsers() 
	{
		return userList;
	}

	/**
	 * getUsers() returns the size of the user list
	 *@author Christopher Kemerait
	 */
	public int getUsersSize() 
	{
		return userList.size();
	}

	/**
	 * printUsers() prints the user list
	 *@author Christopher Kemerait
	 */
	public void printUsers() 
	{
		if(getUsersSize() == 0)
		{
			System.out.println("No Users");
			System.out.println("");
		}
		else
		{
			for(int x = 0; x < getUsersSize(); x++)
			{
				userList.get(x).print();
			}
		}
		
	}

	/**
	 * BackUpUsersToFile() tells the file writing object to write the user list to the file
	 *@author Christopher Kemerait
	 */
	public void BackUpUsersToFile() 
	{
		fileWriteCommand.writeUsers(userList);
		
	}

	/**
	 * BackUpUsersToFile() tells the file reading object to read the user list from the file
	 *@author Christopher Kemerait
	 */
	public void ReadUsersBackUpFromFile() 
	{
		userList = fileReadCommand.readUsers();
		
	}

	/**
	 * printUsers(user) prints the given user
	 *@author Christopher Kemerait
	 */
	public void printUser(String string) 
	{
		for(int x = 0; x < userList.size(); x++)
		{
			if( userList.get(x).getUsername().equals(string) )
			{
				userList.get(x).print();
				break;
			}
		}		
	}

	/**
	 * writeUser(string) tells the file writing object to write the user to the file
	 *@author Christopher Kemerait
	 */
	public void writeUser(String username) 
	{
		for(int x = 0; x < userList.size(); x++)
		{
			if( userList.get(x).getUsername().equals(username) )
			{
				fileWriteCommand.writeUser(userList.get(x));
				break;
			}
		}
		
	}

	/**
	 * readUser(string) tells the file reading object to read the user from the file
	 *@author Christopher Kemerait
	 */
	public void readUser(String username) 
	{
		userList.add( fileReadCommand.readUser(username) );
	}

	public void setWriteCommand(FileWriteCommand fileWriteCommand) 
	{
		this.fileWriteCommand = fileWriteCommand;
		
	}

}
