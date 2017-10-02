package com.fdmgroup.demos;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestLogInManager {

	static LogInManager manager;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		
		manager = new LogInManager();
	}

	@Test
	public void testLogInSuccess_correctGetterSetterMethodsCalledOnUser() {
		
		// Create the mock
		User mockUser = mock(User.class);
		
		// Stub
		when(mockUser.getUsername()).thenReturn("admin");
		when(mockUser.isLoggedIn()).thenReturn(false);
		
		// Run the code we are testing
		assertTrue(manager.logIn(mockUser));
		
		// Verify that correct interactions took place
		verify(mockUser).getUsername();
		verify(mockUser).setLoggedIn(true);
		verify(mockUser).isLoggedIn();
		verify(mockUser,never()).getPassword();
	}

}
