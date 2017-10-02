package com.fdmgroup.registration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistrationControllerTest {
	private static final String FILE_LOCATION = "testFileWriteCommand.txt";//"C:\\Users\\Levi.St.Thomas\\JavaEclipseWorkspace\\UserRegistrationSystem\\testFileWriteCommand.txt";
	ReadCommand reader;
	WriteCommand writer;
	UserFactory factory;
	RegistrationController registerer;
	String username, password, role;

	@Before
	public void setUp() throws Exception {
//		new File(FILE_LOCATION).delete();
		reader = new FileReadCommand(FILE_LOCATION);
		writer = new FileWriteCommand(FILE_LOCATION);
		factory = new UserFactory();
		registerer = new RegistrationController(reader, writer, factory);
		username = "default_username";
		password = "default_password";
		role = "default_role";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_registrationControllerUsesUserFactory() {
		//arrange
		new File(FILE_LOCATION).delete();
		factory = mock(UserFactory.class);
		registerer = new RegistrationController(reader, writer, factory);
		
		//act
		try {
			registerer.registerNewUser(username, password, role);
		} catch (UserNotWrittenException e) {
			fail("UserNotWrittenException");
		} catch (UserNotReadException e) {
			fail("UserNotReadException");
		} catch (UsernameIsTakenException e) {
			//this is fine (for now)
			//Tried to make user with non-unique username
			//handled elsewhere
		}
		
		//assert
		verify(factory).createUser(anyString(), anyString(), anyString());
	}
	
	@Test
	public void test_registerUser_WritesToSource_WhenCalled() {
		//arrange
		writer = new FileWriteCommand(FILE_LOCATION);
		factory = new UserFactory();
		registerer = new RegistrationController(reader, writer, factory);
		
		//act
		try {
			registerer.registerNewUser(username, password, role);
		} catch (UserNotWrittenException e) {
			fail("UserNotWrittenException");
		} catch (UserNotReadException e) {
			fail("UserNotReadException");
		} catch (UsernameIsTakenException e) {
			//this is fine (for now)
			//Tried to make user with non-unique username
			//handled elsewhere
		}
		
		//assert
		assertTrue(new File(FILE_LOCATION).length()>0);
	}
	
	@Test
	public void test_registerUser_EnsuresUniquenessOfUsernameAndDoesNotChangeUsersFile_WhenCalled() {
		//arrange
		reader = new FileReadCommand(FILE_LOCATION);
		writer = new FileWriteCommand(FILE_LOCATION);
		factory = new UserFactory();
		registerer = new RegistrationController(reader, writer, factory);
		username = "default_username";
		
		//act
		//add a user just in case (earlier test deletes file; need to repopulate)
		try {
			registerer.registerNewUser(username, password, role);
		} catch (UserNotWrittenException e) {
			fail("UserNotWrittenException");
		} catch (UserNotReadException e) {
			e.printStackTrace();
			fail("UserNotReadException");
		} catch (UsernameIsTakenException e) {
			//this is fine (for now)
			//Tried to make user with non-unique username
			//handled elsewhere
		}
		
		int originalFileLength = (int) new File(FILE_LOCATION).length();
		
		//add a duplicate user for test
		try {
			registerer.registerNewUser(username, password, role);
		} catch (UserNotWrittenException e) {
			fail("UserNotWrittenException");
		} catch (UserNotReadException e) {
			e.printStackTrace();
			fail("UserNotReadException");
		} catch (UsernameIsTakenException e) {
			//this is fine (for now)
			//Tried to make user with non-unique username
			//handled elsewhere
		}

		int finalFileLength = (int) new File(FILE_LOCATION).length();
		
		//assert
		assertEquals(originalFileLength, finalFileLength);
	}
	
	@Test
	public void test_registerNewUser_rejectsNullUserData_whenCalledWithNullUserData() {
		//arrange
		username = password = role = null;
		
		//act
		
		//assert
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
