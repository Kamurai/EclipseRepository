package DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Department;
import com.fdmgroup.Entity.Role;
import com.fdmgroup.Entity.User;
import com.fdmgroup.Entity.User;

public class TestUserDAO 
{
	DBSetup dBSetup;
	UserDAO userDAO;
	User user;
	
	@Before
	public void SetUp()
	{
		dBSetup = new DBSetup();
//		dBSetup.setupDB();
//		dBSetup.stubDBwithHeroes();
		userDAO = new UserDAO();
	}
	
	@After
	public void TearDown()
	{
//		dBSetup.tearDownDB();
	}
	
	@Test
	public void test_GetUserById()
	{
		int suppliedId = 8;
		user = userDAO.getUserById(suppliedId);
		
		assertEquals(user.getUserId(), suppliedId);
	}
	
	@Test
	public void test_GetUserByUsername()
	{
		String suppliedUsername = "Steve.Rogers";
		user = userDAO.getUserByUsername(suppliedUsername);
		
		assertEquals(user.getUsername(), suppliedUsername);
	}
	
	@Test
	public void test_GetUsers()
	{
		int suppliedCount = 5; //get manually
		
		assertEquals(suppliedCount, userDAO.getUsers().size());
	}
	
	@Test
	public void test_AddUser()
	{
		List<Department> departmentList = new ArrayList<Department>();
		Department dept = new Department(0, "heroes");
		departmentList.add(dept);
		List<Role> roleList = new ArrayList<Role>();
		Role role = new Role(0, "basic");
		roleList.add(role);
		
		user = new User(departmentList, "Carol.Danvers", "steve", "Carol.Danvers@marvel.com");
		
		int userCount = userDAO.getUsers().size();
		
		userDAO.addUser(user);
		
		assertEquals(userCount+1, userDAO.getUsers().size());
	}
	
	@Test
	public void test_RemoveUser()
	{
		int userCount = userDAO.getUsers().size();
		
		userDAO.removeUser(userDAO.getUsers().size()-1);
		
		assertEquals(userCount-1, userDAO.getUsers().size());
	}
	
	@Test
	public void test_UpdateUser()
	{
		List<Department> departmentList = new ArrayList<Department>();
		Department dept = new Department(0, "heroes");
		departmentList.add(dept);
		List<Role> roleList = new ArrayList<Role>();
		Role role = new Role(0, "basic");
		roleList.add(role);
		
		user = new User(departmentList, "Carol.Danvers", "steve", "Carol.Danvers@marvel.com");
		
		
		int suppliedId = userDAO.getUsers().size()-1; //get last user
		String suppliedUsername = "Peter.Parker";
		
		User savedUser = userDAO.getUserById(suppliedId);
		
		user = new User(suppliedId, departmentList, suppliedUsername, "steve", "Carol.Danvers@marvel.com", roleList);
		
		userDAO.updateUser(user);
		
		String fetchedUsername = userDAO.getUserById(suppliedId).getUsername();
		
		userDAO.updateUser(savedUser);
		
		assertEquals(suppliedUsername, fetchedUsername);
	}
}
