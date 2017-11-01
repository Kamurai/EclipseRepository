package Entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Department;
import com.fdmgroup.Entity.Role;
import com.fdmgroup.Entity.User;




public class TestUser 
{
	
	int userId;
	Department dept;
	List<Department> deptList;
	String username;
	String password;
	String email;
	Role role;
	List<Role> roleList;
	User user;
	
	@Before
	public void SetUp()
	{
		userId = 0;
		dept = new Department(0, "Zoo");
		deptList = new ArrayList<Department>();
		deptList.add(dept);
		username = "Monkey";
		password = "peanuts";
		String email = "Monkey@monkey.com";
		role = new Role(0, "Management");
		roleList = new ArrayList<Role>();
		roleList.add(role);
		user = new User(userId, deptList, username, password, email, roleList);
	}
	
	@After
	public void TearDown()
	{
	}
	
	@Test
	public void test_getUserIdReturnsNotNull()
	{
		assertNotNull(user.getUserId());
	}
	
	@Test
	public void test_UserIdIsSetCorrectly()
	{
		assertEquals(userId, user.getUserId());
	}
	
	@Test
	public void test_UserIdIsSetGreaterThanNegative2()
	{
		userId = -2;
		dept = new Department(0, "Zoo");
		deptList = new ArrayList<Department>();
		deptList.add(dept);
		username = "Monkey";
		password = "peanuts";
		String email = "Monkey@monkey.com";
		role = new Role(0, "Management");
		roleList = new ArrayList<Role>();
		roleList.add(role);
		user = new User(userId, deptList, username, password, email, roleList);
		
		assertTrue(user.getUserId() > -2);
	}
	
	@Test
	public void test_UserIdIsSetFourDigitsOrLess()
	{
		//restricted by database
	}
	
	@Test
	public void test_getDeptReturnsNotNull()
	{
		assertNotNull(user.getDeptList());
	}
	
	@Test
	public void test_DeptNameIsSetCorrectly()
	{
		assertEquals(deptList, user.getDeptList());
	}
		
	@Test
	public void test_getUsernameReturnsNotNull()
	{
		assertNotNull(user.getUsername());
	}
	
	@Test
	public void test_UsernameIsSetCorrectly()
	{
		assertEquals(username, user.getUsername());
	}
	
	@Test
	public void test_DeptIdIsThirtyCharactersOrLess()
	{
		userId = -1;
		dept = new Department(0, "Zoo");
		deptList = new ArrayList<Department>();
		deptList.add(dept);
		username = "ManagementIsTheBestIKnowRightYaYa";
		password = "peanuts";
		String email = "Monkey@monkey.com";
		role = new Role(0, "Management");
		roleList = new ArrayList<Role>();
		roleList.add(role);
		user = new User(userId, deptList, username, password, email, roleList);
		
		assertTrue(dept.getDeptName().length() < 31);
	}

	
	@Test
	public void test_getPasswordReturnsNotNull()
	{
		assertNotNull(user.getPassword());
	}
	
	@Test
	public void test_PasswordIsSetCorrectly()
	{
		assertEquals(username, user.getUsername());
	}
	
	@Test
	public void test_PasswordIsThirtyCharactersOrLess()
	{
		userId = -1;
		dept = new Department(0, "Zoo");
		deptList = new ArrayList<Department>();
		deptList.add(dept);
		username = "Monkey";
		password = "ManagementIsTheBestIKnowRightYaYa";
		String email = "Monkey@monkey.com";
		role = new Role(0, "Management");
		roleList = new ArrayList<Role>();
		roleList.add(role);
		user = new User(userId, deptList, username, password, email, roleList);
		
		assertTrue(dept.getDeptName().length() < 31);
	}
	
	@Test
	public void test_getEmailReturnsNotNull()
	{
		assertNotNull(user.getEmail());
	}
	
	@Test
	public void test_EmailIsSetCorrectly()
	{
		assertEquals(username, user.getUsername());
	}
	
	@Test
	public void test_EmailIsThirtyCharactersOrLess()
	{
		userId = -1;
		dept = new Department(0, "Zoo");
		deptList = new ArrayList<Department>();
		deptList.add(dept);
		username = "Monkey";
		password = "peanuts";
		String email = "ManagementIsTheBestIKnowRightYaYa@ManagementIsTheBestIKnowRightYaYa.com";
		role = new Role(0, "Management");
		roleList = new ArrayList<Role>();
		roleList.add(role);
		user = new User(userId, deptList, username, password, email, roleList);
		
		assertTrue(dept.getDeptName().length() < 31);
	}
	
	@Test
	public void test_getRoleListReturnsNotNull()
	{
		assertNotNull(user.getRoleList());
	}
	
	@Test
	public void test_RoleListIsSetCorrectly()
	{
		assertEquals(roleList, user.getRoleList());
	}
	
}
