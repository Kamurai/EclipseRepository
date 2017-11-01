package DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.DepartmentDAO;
import com.fdmgroup.DAO.StatusDAO;
import com.fdmgroup.DAO.StatusDAO;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.Department;
import com.fdmgroup.Entity.Status;
import com.fdmgroup.Entity.Status;
import com.fdmgroup.Entity.User;

public class TestStatusDAO 
{
	DBSetup dBSetup;
	StatusDAO statusDAO;
	Status status;
	
	@Before
	public void SetUp()
	{
//		dBSetup = new DBSetup();
//		dBSetup.setupDB();
//		dBSetup.stubDBwithHeroes();
		statusDAO = new StatusDAO();
	}
	
	@After
	public void TearDown()
	{
//		dBSetup.tearDownDB();
	}
	
	
	@Test
	public void test_GetStatusById()
	{
		int suppliedId = 0;
		status = statusDAO.getStatusById(suppliedId);
		
		assertEquals(status.getStatusId(), suppliedId);
	}
	
	@Test
	public void test_GetStatuss()
	{
		int suppliedCount = 5; //get manually
		
		assertEquals(suppliedCount, statusDAO.getStatuss().size());
	}
	
	@Test
	public void test_AddStatus()
	{
		status = new Status("Lovely");
		
		int departmentCount = statusDAO.getStatuss().size();
		
		statusDAO.addStatus(status);
		
		assertEquals(departmentCount+1, statusDAO.getStatuss().size());
	}
	
	@Test
	public void test_RemoveStatus()
	{
		int departmentCount = statusDAO.getStatuss().size();
		
		statusDAO.removeStatus(statusDAO.getStatuss().size()-1);
		
		assertEquals(departmentCount-1, statusDAO.getStatuss().size());
	}
	
	@Test
	public void test_UpdateStatus()
	{
		int suppliedId = statusDAO.getStatuss().size()-1; //get last user
		String suppliedUsername = "Super";
		
		Status savedStatus = statusDAO.getStatusById(suppliedId);
		
		status = new Status(suppliedId, suppliedUsername);
		
		statusDAO.updateStatus(status);
		
		String fetchedUsername = statusDAO.getStatusById(suppliedId).getStatusName();
		
		statusDAO.updateStatus(savedStatus);
		
		assertEquals(suppliedUsername, fetchedUsername);
	}

}
