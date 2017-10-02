package com.fdmgroup;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileWriteCommandTest 
{
	private static final String FILE_LOCATION = "testFileReadWriteCommand.txt";

	String username = "default_username";
	String password = "default_password";
	String role = "default_role";
	
	String username2 = "second_username";
	String password2 = "second_password";
	String role2 = "second_role";
	
	User user;
	User secondUser;
	
	List<User> userList;
	
	FileWriteCommand writer = new FileWriteCommand(FILE_LOCATION);
	
	@Before
	public void setUp() throws Exception {
		new File(FILE_LOCATION).delete();
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * 	Success: 	has user been written to a file
                	Has the right data been written
                	Doesn’t overwrite previous data 
                	(not validation)
		Fail:       Replaces data
                	Passes wrong data
                	Doesn’t write anything

	 */
	
	@Test
	public void test_WriteUserWritesSomeUserDataToAFile() 
	{
		user = new User(username, password, role);
		
		userList = new ArrayList();
		
		userList.add(user);
		
		
		if(	!writer.writeUsers(userList) )
		{
			fail("User unable to be written");
		}
		//Manually verify data was written
	}
	
	@Test
	public void test_WriteTwoUsersDoesNotOverwrite() 
	{
		user = new User(username, password, role);
		secondUser = new User(username2,password2,role2);
		
		userList = new ArrayList();
		
		userList.add(user);
		userList.add(secondUser);
				
		if( !writer.writeUsers(userList) )
		{
			fail("User unable to be written");
		}
		//Manually verify data was written
	}
}
