package com.fdmgroup.demos;


public class Robot {
	
	private Weapon weapon;
	
	public Robot(Weapon w){
		weapon = w;
	}
	
	public void destroy(int force){
		
		System.out.println(
				"You will be terminated.");
		
		weapon.fire(force);
	}
}
