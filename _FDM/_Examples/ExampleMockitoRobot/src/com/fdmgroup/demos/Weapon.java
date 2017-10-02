package com.fdmgroup.demos;


public class Weapon {
	
	public void fire(int power){
		
		power = power *10;
		for (int i = 0; i<power; i++)	
			System.out.println("Boom");
	}
}
