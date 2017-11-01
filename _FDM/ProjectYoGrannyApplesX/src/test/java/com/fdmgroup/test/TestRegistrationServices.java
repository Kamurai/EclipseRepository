package com.fdmgroup.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.DAO.DBSetup;
import com.fdmgroup.DAO.UserDAO;
import com.fdmgroup.Entity.User;
import com.fdmgroup.Services.RegistrationServices;

public class TestRegistrationServices {
	private DBSetup dbSetup;
	private RegistrationServices registrationServices;
	private UserDAO userDAO;
	private String username1;
	private String password1;
	private String confirmPW1;
	private String email1;
	private int deptid1;
	private String username2;
	private String username3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
//		dbSetup = new DBSetup();
//		dbSetup.setupDB();
//		dbSetup.stubDB();
		userDAO = new UserDAO();
		registrationServices = new RegistrationServices(userDAO);
		username1 = "Victory";
		password1 = "dogsRule";
		confirmPW1  = "dogsRule";
		email1 = "email1@emial.com";
		deptid1 = 0;
		username2 = "victoria";
		username3 = "Tori";




		
	}

	@After
	public void tearDown() throws Exception {
//		dbSetup.tearDownDB();
	}

	@Test
	public void test_thatIfthePasswordsDoNotMatchItReturnsFalse() 
	{
		
//		Boolean testResult = registrationServices.register(new User("Victoria", "catsRule", "dogsRule", "email@emial.com"), 0);
//		Boolean expectedResult = false;
//		
//		
//		assertEquals(expectedResult, testResult);
	}
//	@Test
//	public void test_thatIftheRegisterMethodWritesTheUserToTheDatabaseAndReturnsTrue() {
//		Boolean testResult = registrationServices.register(username1, password1, confirmPW1, email1, deptid1);
//		Boolean expectedResult = true;
//
//		
//		assertEquals(expectedResult, testResult);
//	}
//	
//	@Test
//	public void test_thatIftheRegisterMethodWritesTheUserToTheDatabaseAndANonNullUserisReturnedWith() {
//		Boolean testResult = registrationServices.register(username2, password1, confirmPW1, email1, deptid1);
//		User returningUser = userDAO.getUserByUsername(username2);
//				
//		assertNotNull(returningUser);
//	}

}
