package com.fdmgroup.patterns.command.demo2;

import java.util.LinkedList;
import java.util.Queue;

public class Agent {

	private String dayOfWeek = "Sunday";

	private Queue<Order> orders = new LinkedList<Order>();

	public void placeOrder(Order o) {

		if (dayOfWeek.equals("Sunday"))
			orders.add(o);
		else
			o.execute();
	}

}
