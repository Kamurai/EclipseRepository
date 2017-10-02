package com.fdmgroup.patterns.observer1;


public class Radio implements Observer {

	public void update(float interest) {
		System.out.println("Radio: New interest rate of " + interest);
	}
}
