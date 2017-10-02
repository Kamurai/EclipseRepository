package com.fdmgroup.patterns.observer2;

import java.util.Observable;
import java.util.Observer;

public class Radio implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Radio: New interest rate of " + arg);
	}
}
