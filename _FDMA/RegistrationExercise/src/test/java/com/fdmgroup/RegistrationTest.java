package com.fdmgroup;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistrationTest 
{
	
	FileReadCommand mockReader;
	FileWriteCommand mockWriter;
	UserFactory mockUserFactory;
	
	FileReadCommand fileReadCommand;
	FileWriteCommand fileWriteCommand;
	UserFactory userFactory;
	
	RegistrationController registrationController;
	
	String username;
	String password;
	String role;
	
	User user1;
	User user2;
	User user3;
	
	@Before
	public void setUp() throws Exception 
	{
	
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}
	/*
	 * 	Success: 	Uses writer to write a user
                	Uses UserFactory properly
		Fail:       doesn’t work for some reason
                	Can’t write to source properly
                	Uniqueness of username
                	Username validation
                	Password validation
                	Role validation
                	Null data
                	Empty data
                	Doesn’t user UserFactory properly

	 */
	
	@Test
	public void testRegistrationControllerIsNotNull()
	{
		registrationController = new RegistrationController(mockReader, mockWriter, mockUserFactory);
		
		assertNotNull(registrationController);
	}
	

	@Test
	public void test_RegistrationNewUser_callsCreateUser_InUserFactory() 
	{
		mockReader = mock(FileReadCommand.class);
		mockWriter = mock(FileWriteCommand.class);
		mockUserFactory = mock(UserFactory.class);
		
		registrationController = new RegistrationController(mockReader, mockWriter, mockUserFactory);
		
		username = "default_username";
		password = "default_password";
		role = "default_role";
		
		registrationController.registerNewUser(username, password, role);
		
		verify( mockUserFactory ).createUser(anyString(), anyString(), anyString());
		
	}
	
	@Test
	public void test_DoesRegistrationControllerAddUsers()
	{
		setupRegistrationController();
		
		username = "Steve Rogers";
		password = "Peggy";
		role = "Captain America";
		registrationController.registerNewUser( username, password, role );
		
		username = "Tony Stark";
		password = "Pepper";
		role = "Iron Man";
		registrationController.registerNewUser( username, password, role );
		
		username = "Peter Parker";
		password = "Felicia";
		role = "Spiderman";
		registrationController.registerNewUser( username, password, role );
		
		assertEquals(registrationController.getUsers().size(), 3);
		
		registrationController.printUsers();
	}
	
	@Test
	public void test_RegisterNewUser_callsWriteUser_InWriteCommand()
	{
		FileWriteCommand writeCommand = mock(FileWriteCommand.class);
		registrationController.setWriteCommand(writeCommand);
		
		registrationController.registerNewUser(username, password, role);
		
		verify(writeCommand).writeUser(any(User.class));
	}
	
	@Test(expected = UserRegistrationException.class)
	public void test_RegisterNewUser_throwsUserRegistrationException_WhenAttemptingToWriteUserWithDuplicateName()
	{
		registrationController.registerNewUser("someUsername", "somePassword", "someRole");
		registrationController.registerNewUser("someUsername", "somePassword", "someRole");
	}
	
	@Test
	public void test_DoesRegistrationControllerWriteUsersToFile()
	{
		setupRegistrationController();
		
		username = "Steve Rogers";
		password = "Peggy";
		role = "Captain America";
		registrationController.registerNewUser( username, password, role );
		
		username = "Tony Stark";
		password = "Pepper";
		role = "Iron Man";
		registrationController.registerNewUser( username, password, role );
		
		username = "Peter Parker";
		password = "Felicia";
		role = "Spiderman";
		registrationController.registerNewUser( username, password, role );
		
		registrationController.printUsers();
		
		registrationController.BackUpUsersToFile();
		//Manually confirm
	}
	
	@Test
	public void test_DoesRegistrationControllerReadUsersFromFile()
	{
		setupRegistrationController();
		
		registrationController.printUsers();
		
		registrationController.ReadUsersBackUpFromFile();
		
		assertEquals(registrationController.getUsers().size(), 3);
		
		registrationController.printUsers();
	}
	
	@Test
	public void test_CanRegistrationBackUpSingleUser()
	{
		setupRegistrationControllerSingle();
		
		username = "Matt Murdock";
		password = "Electra";
		role = "Daredevil";
		registrationController.registerNewUser( username, password, role );
		
		registrationController.printUser("Matt Murdock");
		registrationController.writeUser("Matt Murdock");
		//Manually verify
	}
	
	@Test
	public void test_CanRegistrationReadSingleUserBackUp()
	{
		setupRegistrationControllerSingle();
		
		registrationController.printUsers();
		
		registrationController.readUser("Matt Murdock");
		
		assertEquals(registrationController.getUsers().size(), 1);
		
		registrationController.printUsers();
		
	}
	
	@Test
	public void test_DoesRegistrationControllerWriteUsersToFileIndividually()
	{
		setupRegistrationController();
		
		username = "Steve Rogers";
		password = "Peggy";
		role = "Captain America";
		registrationController.registerNewUser( username, password, role );
		
		username = "Tony Stark";
		password = "Pepper";
		role = "Iron Man";
		registrationController.registerNewUser( username, password, role );

		username = "Peter Parker";
		password = "Felicia";
		role = "Spiderman";
		registrationController.registerNewUser( username, password, role );
		
		registrationController.printUsers();
		registrationController.BackUpUsersToFile();
		//Manually confirm
	}
	
	@Test
	public void test_DoesRegistrationControllerReadUsersFromFileIndividually()
	{
		setupRegistrationController();
		
		registrationController.printUsers();
		
		registrationController.readUser("Peter Parker");
		
		assertEquals(registrationController.getUsers().size(), 1);
		
		System.out.println("1");
		
		registrationController.printUsers();
		
		registrationController.readUser("Steve Rogers");
		
		assertEquals(registrationController.getUsers().size(), 2);
		
		System.out.println("2");
		
		registrationController.printUsers();
		
		registrationController.readUser("Tony Stark");
		
		assertEquals(registrationController.getUsers().size(), 3);
		
		System.out.println("3");
		
		registrationController.printUsers();		
	}
	
	
	@Test
	public void test_DoesRegistrationControllerCheckUniquenessOfUsernameWhenCreatingAUser()
	{
		setupRegistrationController();
		
		username = "Steve Rogers";
		password = "Peggy";
		role = "Captain America";
		registrationController.registerNewUser( username, password, role );
		registrationController.registerNewUser( username, password, role );
		
		assertEquals(registrationController.getUsersSize(),1);
	}
	
	
	
	
	
	
	public void setupRegistrationController()
	{
		fileReadCommand = new FileReadCommand("testFileRegistrationBackup.txt");
		fileWriteCommand = new FileWriteCommand("testFileRegistrationBackup.txt");
		userFactory = new UserFactory();
		registrationController = new RegistrationController(fileReadCommand, fileWriteCommand, userFactory);
		
	}
	
	public void setupRegistrationControllerSingle()
	{
		fileReadCommand = new FileReadCommand("testFileSingleBackup.txt");
		fileWriteCommand = new FileWriteCommand("testFileSingleBackup.txt");
		userFactory = new UserFactory();
		registrationController = new RegistrationController(fileReadCommand, fileWriteCommand, userFactory);
		
	}
	
}
