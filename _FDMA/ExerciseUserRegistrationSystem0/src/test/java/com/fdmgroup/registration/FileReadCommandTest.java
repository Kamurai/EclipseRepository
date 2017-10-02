package com.fdmgroup.registration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileReadCommandTest {
	private static final String FILE_LOCATION = "testFileWriteCommand.txt";
		FileReadCommand reader;
		String username;
		User user = null;

	@Before
	public void setUp() throws Exception {
		reader = new FileReadCommand(FILE_LOCATION);
		username = "default_username";
		user = null;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_readUserReadsCorrectUserDataFromAFile() {
		//arrange
		
		//act and assert
		try {
			user = reader.readUser(username);
		} catch (UserNotReadException e) {
			fail("UserNotReadException, user");
		}
		assertEquals(username, user.getUsername());
	}
	
	@Test
	public void test_readUserReadsUsersInSuccession() {
		//arrange
		
		//act and assert
		try {
			user = reader.readUser(username);
		} catch (UserNotReadException e) {
			fail("UserNotReadException, user");
		}
		assertEquals(username, user.getUsername());
		
		username = "default_username";
		try {
			user = reader.readUser(username);
		} catch (UserNotReadException e) {
			fail("UserNotReadException, user");
		}
		assertEquals(username, user.getUsername());
		
		username = "second_username";
		try {
			user = reader.readUser(username);
		} catch (UserNotReadException e) {
			fail("UserNotReadException, user");
		}
		assertEquals(username, user.getUsername());
	}
	
	@Test
	public void test_readUser_returnsNull_whenCalledWithNonExistentUsername() {
		//arrange
		username = "nonExistent_username";
		
		//act
		try{
			user = reader.readUser(username);
		} catch (UserNotReadException e) {
			fail("UserNotReadException, user");
		}
		
		//assert
		assertNull(user);
	}
	
//	@Test
//	public void test_() {
//		//arrange
//		
//		//act
//		
//		//assert
//	}

}
