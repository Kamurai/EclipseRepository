package com.fdmgroup.patterns.observer1;

public class Newspaper implements Observer {

	public void update(float interest) {
		System.out.println("Newspaper: New interest rate of "
				+ interest);
	}

}
