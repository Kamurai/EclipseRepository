package com.fdmgroup.patterns.observer2;

import java.util.Observable;
import java.util.Observer;

public class Newspaper implements Observer {


	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("Newspaper: New interest rate of "
				+ arg);
	}

}
