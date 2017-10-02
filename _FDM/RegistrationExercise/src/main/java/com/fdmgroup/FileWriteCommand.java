package com.fdmgroup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * FileWriteCommand holds the following fields:
 * filename String: This should be the file to which this object writes
 * @author Christopher Kemerait
 */
public class FileWriteCommand implements WriteCommand 
{
	private String filename;

	/**
	 * The constructor receives and sets the following fields:
	 * filename String: This should be the file to which this object writes
	 * @author Christopher Kemerait
	 */
	public FileWriteCommand(String filename)
	{
		this.filename = filename;
	}

	/**
	 * writeUser(User user) receives a user and attempts to write it to a file:
	 * The method reads the file, and retrieves the stored UserList
	 * The given user is added to the end of the list,
	 * and the entire list is written back to file
	 *@author Christopher Kemerait
	 */
	public boolean writeUser(User user)
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
			userList = new ArrayList<User>();
		}
		catch(ClassNotFoundException e)
		{
			userList = new ArrayList<User>();
		}
		
		userList.add(user);
		
		//try with resources
		try
		(
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos)
				
		){
			oos.writeObject(userList);
		}
		catch(IOException e)
		{
			//Handle exception
			return false;
		}
		
		return true;
	}

	/**
	 * writeUsers(List<User> userList) receives a user list and attempts to write it to a file:
	 * The method writes the entire list to file
	 *@author Christopher Kemerait
	 */
	@Override
	public boolean writeUsers(List<User> userList) 
	{
		//try with resources
		try
		(
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos)
		)
		{
			oos.writeObject(userList);
			oos.close();
		}
		catch(IOException e)
		{
			//Handle exception
			return false;
		}
		
		return true;
	}

}
