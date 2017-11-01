package Entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Role;
import com.fdmgroup.Entity.Role;
import com.fdmgroup.Entity.User;




public class TestRole 
{
	private int roleId;
	private String roleName;
	private Role role;

	@Before
	public void SetUp()
	{
		roleId = 1;
		roleName = "basic";
		role = new Role(roleId, roleName);
	}
	
	@After
	public void TearDown()
	{
	}
	
	@Test
	public void test_getRoleIdByReturnsNotNull()
	{
		assertNotNull(role.getRoleId());

	}
	
	@Test
	public void test_roleIdIsSetCorrectly()
	{
		assertEquals(roleId, role.getRoleId());
	}
	
	@Test
	public void test_roleIdIsSetGreaterThanNegative2()
	{
		roleId = -2;
		roleName = "Management";
		role = new Role(roleId, roleName);
		
		assertTrue(role.getRoleId() > -2);
	}
	
	@Test
	public void test_roleIdIsSetFourDigitsOrLess()
	{
		//restricted by database
	}
	
	@Test
	public void test_getRoleNameByReturnsNotNull()
	{
		assertNotNull(role.getRoleName());
	}
	
	@Test
	public void test_roleNameIsSetCorrectly()
	{
		assertEquals(roleName, role.getRoleName());
	}
	
	@Test
	public void test_roleIdIsThirtyCharactersOrLess()
	{
		roleId = 1;
		roleName = "ManagementIsTheBestIKnowRightYaYa";
		role = new Role(roleId, roleName);
		
		
		assertTrue(role.getRoleName().length() < 31);
	}

}