package com.fdmgroup.registration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBReadCommandTest 
{
	DBSetupCommand dbSetup;
	DBReadCommand reader;
	String username;
	User user = null;

	@Before
	public void setUp() throws Exception {
		reader = new DBReadCommand();
		username = "Peter.Parker";
		user = null;
		dbSetup = new DBSetupCommand();
	}

	@After
	public void tearDown() throws Exception {
		dbSetup.tearDownDB();
	}

	@Test
	public void test_readUserReadsCorrectUserDataFromDB() {
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
		
		username = "Steve.Rogers";
		try {
			user = reader.readUser(username);
		} catch (UserNotReadException e) {
			fail("UserNotReadException, user");
		}
		assertEquals(username, user.getUsername());
		
		username = "Tony.Stark";
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
