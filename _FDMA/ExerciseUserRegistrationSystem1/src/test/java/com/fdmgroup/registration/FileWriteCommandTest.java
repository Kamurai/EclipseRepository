package com.fdmgroup.registration;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileWriteCommandTest {
	private static final String FILE_LOCATION = "testFileWriteCommand.txt";

	@Before
	public void setUp() throws Exception {
		new File(FILE_LOCATION).delete();
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
	public void test_writeUserWritesSomeUserDataToAFile() {
		//arrange
		FileWriteCommand writer = new FileWriteCommand(FILE_LOCATION);
		String username = "default_username";
		String password = "default_password";
		String role = "default_role";
		User user = new User(username, password, role);
		
		//act and assert
		try {
			writer.writeUser(user);
		} catch (UserNotWrittenException e) {
			fail("UserNotWrittenException, user");
		}
	}

	@Test
	public void test_writeTwoUsersDoesNotOverwrite() {
		//arrange
		FileWriteCommand writer = new FileWriteCommand(FILE_LOCATION);
		String username = "default_username";
		String password = "default_password";
		String role = "default_role";
		User user = new User(username, password, role);
		
		//act and assert
		try {
			writer.writeUser(user);
		} catch (UserNotWrittenException e) {
			fail("UserNotWrittenException, user");
		}
		username = "second_username";
		password = "second_password";
		role = "second_role";
		User secondUser = new User(username, password, role);
		try {
			writer.writeUser(secondUser);
		} catch (UserNotWrittenException e) {
			fail("UserNotWrittenException, secondUser");
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
