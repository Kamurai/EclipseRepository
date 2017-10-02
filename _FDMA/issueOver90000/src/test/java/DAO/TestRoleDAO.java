package DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.DepartmentDAO;
import com.fdmgroup.DAO.RoleDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Department;
import com.fdmgroup.Entity.Role;
import com.fdmgroup.Entity.User;

public class TestRoleDAO 
{
	DBSetup dBSetup;
	RoleDAO roleDAO;
	Role role;
	
	@Before
	public void SetUp()
	{
//		dBSetup = new DBSetup();
//		dBSetup.setupDB();
//		dBSetup.stubDBwithHeroes();
		roleDAO = new RoleDAO();
	}
	
	@After
	public void TearDown()
	{
//		dBSetup.tearDownDB();
	}
	
	
	@Test
	public void test_GetRoleById()
	{
		int suppliedId = 0;
		role = roleDAO.getRoleById(suppliedId);
		
		assertEquals(role.getRoleId(), suppliedId);
	}
	
	@Test
	public void test_GetRoles()
	{
		int suppliedCount = 3; //get manually
		
		assertEquals(suppliedCount, roleDAO.getRoles().size());
	}
	
	@Test
	public void test_AddRole()
	{
		role = new Role("Boss");
		
		int departmentCount = roleDAO.getRoles().size();
		
		roleDAO.addRole(role);
		
		assertEquals(departmentCount+1, roleDAO.getRoles().size());
	}
	
	@Test
	public void test_RemoveRole()
	{
		int departmentCount = roleDAO.getRoles().size();
		
		roleDAO.removeRole(roleDAO.getRoles().size()-1);
		
		assertEquals(departmentCount-1, roleDAO.getRoles().size());
	}
	
	@Test
	public void test_UpdateRole()
	{
		int suppliedId = roleDAO.getRoles().size()-1; //get last user
		String suppliedUsername = "Super Boss";
		
		Role savedRole = roleDAO.getRoleById(suppliedId);
		
		role = new Role(suppliedId, suppliedUsername);
		
		roleDAO.updateRole(role);
		
		String fetchedUsername = roleDAO.getRoleById(suppliedId).getRoleName();
		
		roleDAO.updateRole(savedRole);
		
		assertEquals(suppliedUsername, fetchedUsername);
	}

}
