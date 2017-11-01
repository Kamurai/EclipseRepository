package Entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Department;
import com.fdmgroup.Entity.User;




public class TestDepartment {
	private int deptId;
	private String deptName;
	private Department dept;

	@Before
	public void SetUp()
	{
		deptId = 1;
		deptName = "Management";
		dept = new Department(deptId, deptName);
	}
	
	@After
	public void TearDown()
	{
	}
	
	
	@Test
	public void test_getDeptIdReturnsNotNull()
	{
		assertNotNull(dept.getDeptId());
	}
	
	@Test
	public void test_DeptIdIsSetCorrectly()
	{
		assertEquals(deptId, dept.getDeptId());
	}
	
	@Test
	public void test_DeptIdIsSetGreaterThanNegative2()
	{
		deptId = -2;
		deptName = "Management";
		dept = new Department(deptId, deptName);
		
		assertTrue(dept.getDeptId() > -2);
	}
	
	@Test
	public void test_DeptIdIsSetFourDigitsOrLess()
	{
		//restricted by database
	}
	
	
	@Test
	public void test_getDeptNameReturnsNotNull()
	{
		assertNotNull(dept.getDeptName());

	}
	
	@Test
	public void test_DeptNameIsSetCorrectly()
	{
		assertEquals(deptName, dept.getDeptName());
	}
	
	@Test
	public void test_DeptIdIsThirtyCharactersOrLess()
	{
		deptId = 1;
		deptName = "ManagementIsTheBestIKnowRightYaYa";
		dept = new Department(deptId, deptName);
		
		
		assertTrue(dept.getDeptName().length() < 31);
	}


}
