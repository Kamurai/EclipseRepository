package com.fdmgroup;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDAO 
{
	UsersDAO usersDAO;
	UsersDAO mockUsersDAO;
	
	//User testUser;
	
	
	@Before
	public void setUp() throws Exception 
	{
		usersDAO = new UsersDAO();
		mockUsersDAO = mock(usersDAO.getClass());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_UsersDAOIsNotNull_WhenConstructed() 
	{
		assertNotNull(usersDAO);
	}
	
	@Test
	public void test_UsersDAOGetsAUser_WhenCallingGetUser() 
	{
		User testUser = usersDAO.getUser("Peter.Parker");
		assertNotNull(testUser);
	}

	@Test
	public void test_UsersDAOGetsUsers_WhenCallingListUsers() 
	{
		List<User> userList = usersDAO.listUsers();
		assertNotNull(userList);
	}

	@Test
	public void test_UsersDAOAddsAUser_WhenCallingAddUser() 
	{
		int initialSize = usersDAO.listUsers().size();
		User newUser = new User(7, "Cassie.Lang", "Scott", "Cassie", "Lang", "Cassie.Lang@superheroes.com", "Antgirl", "Reserves");
		usersDAO.addUser(newUser);
		int modifiedSize = usersDAO.listUsers().size();
		
		assertEquals(initialSize, modifiedSize-1);		
	}

	@Test
	public void test_UsersDAORemovesAUser_WhenCallingRemoveUser() 
	{
		int initialSize = usersDAO.listUsers().size();
		usersDAO.removeUser("Cassie.Lang");
		int modifiedSize = usersDAO.listUsers().size();
		
		assertEquals(initialSize, modifiedSize+1);
	}

	@Test
	public void test_UsersDAOUpdatesAUser_WhenCallingUpdateUser() 
	{
		User newUser = usersDAO.getUser("Cassie.Lang");
		
		boolean IsActive = newUser.getStatus().equals("Active");		
		
		if( IsActive )
		{
			newUser.setStatus("Reserves");
		}
		else
		{
			newUser.setStatus("Active");
		}
		
		usersDAO.updateUser(newUser);
		
		newUser = usersDAO.getUser("Cassie.Lang");
		
		if( IsActive )
		{
			assertEquals("Reserves", newUser.getStatus());
		}
		else
		{
			assertEquals("Active", newUser.getStatus());
		}
	}
}
