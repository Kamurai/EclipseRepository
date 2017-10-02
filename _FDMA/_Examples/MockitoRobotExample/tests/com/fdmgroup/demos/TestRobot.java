package com.fdmgroup.demos;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

import org.junit.Test;


public class TestRobot {

	@Test
	public void testDestroySuccess_fireCalledOnWeapon() {
		
		// 1. Mock
		
		Weapon mockWeapon = mock(Weapon.class);
		Robot robot = new Robot(mockWeapon);

		// 2. Use the mock
		robot.destroy(3);
	
		
		// 3. Verify the correct behavior took place
		verify(mockWeapon).fire(3);
		
		// Note that when using a mock Weapon,
		// the println() calls in the Weapon class 
		// do not execute. Only code from the Robot
		// class is running.
		
	}

}
