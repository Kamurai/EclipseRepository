package com.fdmgroup;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileReadCommandTest 
{
	private static final String FILE_LOCATION = "testFileReadWriteCommand.txt";

	String username = "";
	String password = "";
	String role = "";
	
	String username2 = "";
	String password2 = "";
	String role2 = "";
	
	User user;
	User secondUser;
	
	FileReadCommand reader = new FileReadCommand(FILE_LOCATION);
	
	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_ReadUserDataFromAFile() 
	{
		List<User> userList = reader.readUsers();
		
		if(userList == null)
		{
			fail("User was not received.");
		}
		else
		{
			userList.get(0).print();
		}
	}
	
	@Test
	public void test_ReadTwoUsersDataFromAFile() 
	{
		List<User> userList = reader.readUsers();
		
		if(userList.size() < 2)
		{
			fail("Users were not both received.");
		}
		else
		{
			user = userList.get(0);
			secondUser = userList.get(1);
			
			user.print();
			secondUser.print();
		}
		
		//Manually verify data was written
	}

}
