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
	RegistrationController register;
	String username, password, role;
	
	ReadCommand dbReader;
	WriteCommand dbWriter;
	RegistrationController dbRegister;
	

	@Before
	public void setUp() throws Exception 
	{
		reader = new FileReadCommand(FILE_LOCATION);
		writer = new FileWriteCommand(FILE_LOCATION);
		factory = new UserFactory();
		register = new RegistrationController(reader, writer, factory);
		username = "default_username";
		password = "default_password";
		role = "default_role";
		
		dbReader = new DBReadCommand();
		dbWriter = new DBWriteCommand();
		dbRegister = new RegistrationController(dbReader, dbWriter, factory);
		//dbRegister.setUpDB();
		
	}

	@After
	public void tearDown() throws Exception {
		dbRegister.tearDownDB();
	}

	@Test
	public void test_registrationControllerUsesUserFactory() {
		//arrange
		new File(FILE_LOCATION).delete();
		factory = mock(UserFactory.class);
		register = new RegistrationController(reader, writer, factory);
		
		//act
		try {
			register.registerNewUser(username, password, role);
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
		register = new RegistrationController(reader, writer, factory);
		
		//act
		try {
			register.registerNewUser(username, password, role);
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
		register = new RegistrationController(reader, writer, factory);
		username = "default_username";
		
		//act
		//add a user just in case (earlier test deletes file; need to repopulate)
		try {
			register.registerNewUser(username, password, role);
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
			register.registerNewUser(username, password, role);
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
		try
		{
			register.registerNewUser(username, password, role);
		}
		catch( UserNotReadException e )
		{
			e.printStackTrace();
		}
		catch( UsernameIsTakenException e )
		{
			e.printStackTrace();
		} 
		catch (UserNotWrittenException e) {
			e.printStackTrace();
		}
		
		//assert
	}
	
	@Test
	public void test_getUser_UserIsReturned()
	{
		assertNotNull( dbRegister.getUser("Peter.Parker") );
	}
	
	@Test
	public void test_getUser_CorrectUserIsReturned()
	{
		assertEquals( "Peter.Parker", dbRegister.getUser("Peter.Parker").getUsername() );
	}
	
	
	@Test
	public void test_registerNewUser_UserIsAddedWhenRegistered()
	{
		//requires "Cassie.Lang" not be in database
		assertNull( dbRegister.getUser("Cassie.Lang") );
		
		try{
			dbRegister.registerNewUser("Cassie.Lang", "Scott", "Antgirl");
		}
		catch( UserNotReadException e )
		{
			e.printStackTrace();
		}
		catch( UsernameIsTakenException e )
		{
			e.printStackTrace();
		} 
		catch (UserNotWrittenException e) {
			e.printStackTrace();
		}
		
		
		assertNotNull( dbRegister.getUser("Cassie.Lang") );
		
	}
	
	@Test
	public void test_removeUser_UserIsRemovedWhenRemoved()
	{
		//requires "Cassie.Lang" be in database
		assertNotNull( dbRegister.getUser("Cassie.Lang") );
		
		dbRegister.removeUser("Cassie.Lang");
		
		assertNull( dbRegister.getUser("Cassie.Lang") );
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
