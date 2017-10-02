package DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.DepartmentDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Department;
import com.fdmgroup.Entity.User;




public class TestDepartmentDAO 
{
	DBSetup dBSetup;
	DepartmentDAO departmentDAO;
	Department department;
	
	@Before
	public void SetUp()
	{
		dBSetup = new DBSetup();
//		dBSetup.setupDB();
//		dBSetup.stubDBwithHeroes();
		departmentDAO = new DepartmentDAO();
	}
	
	@After
	public void TearDown()
	{
//		dBSetup.tearDownDB();
	}
	
	@Test
	public void test_GetDepartmentById()
	{
		int suppliedId = 0;
		department = departmentDAO.getDepartmentById(suppliedId);
		
		assertEquals(department.getDeptId(), suppliedId);
	}
	
	@Test
	public void test_GetDepartemnts()
	{
		int suppliedCount = 2; //get manually
		
		assertEquals(suppliedCount, departmentDAO.getDepartments().size());
	}
	
	@Test
	public void test_AddDepartment()
	{
		department = new Department("villians");
		
		int departmentCount = departmentDAO.getDepartments().size();
		
		departmentDAO.addDepartment(department);
		
		assertEquals(departmentCount+1, departmentDAO.getDepartments().size());
	}
	
	@Test
	public void test_RemoveDepartment()
	{
		int departmentCount = departmentDAO.getDepartments().size();
		
		departmentDAO.removeDepartment(departmentDAO.getDepartments().size()-1);
		
		assertEquals(departmentCount-1, departmentDAO.getDepartments().size());
	}
	
	@Test
	public void test_UpdateDepartment()
	{
		int suppliedId = departmentDAO.getDepartments().size()-1; //get last user
		String suppliedUsername = "cosmic heroes";
		
		Department savedDepartment = departmentDAO.getDepartmentById(suppliedId);
		
		department = new Department(suppliedId, suppliedUsername);
		
		departmentDAO.updateDepartment(department);
		
		String fetchedUsername = departmentDAO.getDepartmentById(suppliedId).getDeptName();
		
		departmentDAO.updateDepartment(savedDepartment);
		
		assertEquals(suppliedUsername, fetchedUsername);
		
		
	}
}
