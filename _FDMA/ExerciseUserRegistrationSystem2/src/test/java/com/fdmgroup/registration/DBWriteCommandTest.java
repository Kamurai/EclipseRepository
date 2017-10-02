package com.fdmgroup.registration;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBWriteCommandTest 
{
	DBWriteCommand writer;
	DBReadCommand reader;
	
	@Before
	public void setUp() throws Exception 
	{
		writer = new DBWriteCommand();
		reader = new DBReadCommand();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test_writeUserCallsCorrectGettersOnUser() {
		//arrange
		
		//act
		
		//assert
	}

	@Test
	public void test_writeUserWritesSomeUserDataToDB() {
		//arrange
		String username = "Cassie.Lang";
		String password = "Scott";
		String role = "Antgirl";
		User user = new User(username, password, role);
		
		//act and assert
		try {
			writer.writeUser(user);
		} catch (UserNotWrittenException e) {
			fail("UserNotWrittenException, user");
		}
		
		try{
			user = reader.readUser(username);
		} catch (UserNotReadException e) {
			fail("UserNotReadException, user");
		}
		
		assertEquals(username, user.getUsername());
	}

	@Test
	public void test_removeUserRemovesSomeUserFromDB() {
		//arrange
		String username = "Cassie.Lang";
		
		//act and assert
		try {
			writer.removeUser(username);
		} catch (UserNotRemovedException e) {
			fail("UserNotRemovedException, user");
		}
	}

	@Test
	public void test_writeTwoUsersDoesNotOverwrite() {
		//arrange
		String username = "Cassie.Lang";
		String password = "Scott";
		String role = "Antgirl";
		User user = new User(username, password, role);
		
		//act and assert
		try {
			writer.writeUser(user);
		} catch (UserNotWrittenException e) {
			fail("UserNotWrittenException, user");
		}
		username = "Wanda.Maximoff";
		password = "Eric";
		role = "Scarlet Witch";
		User secondUser = new User(username, password, role);
		try {
			writer.writeUser(secondUser);
		} catch (UserNotWrittenException e) {
			fail("UserNotWrittenException, secondUser");
		}
	}
	
	@Test
	public void test_removeTwoUsersFromOtherTestAreRemovedWhenRemoved() {
		//arrange
		String username = "Cassie.Lang";
		
		//act and assert
		try {
			writer.removeUser(username);
		} catch (UserNotRemovedException e) {
			fail("UserNotRemovedException, user");
		}
		
		username = "Wanda.Maximoff";
		try {
			writer.removeUser(username);
		} catch (UserNotRemovedException e) {
			fail("UserNotRemovedException, user");
		}
	}
	
	
	
	
//	@Test
//	public void test_() {
//		//arrange
//		
//		//act
//		
//		//assert
//	}
	
//	@Test
//	public void test_() {
//		//arrange
//		
//		//act
//		
//		//assert
//	}
	
}
