package com.fdmgroup.demos.threads;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	
	public static void main(String[] args) throws InterruptedException {
		
		int numberOfThreads = 6; // Increase this to see race condition

		MyRunnable myRunnable = new MyRunnable(new Counter());
		List<Thread> allThreads = new ArrayList<Thread>();

		for (int i = 0; i < numberOfThreads; i++) 
			allThreads.add(new Thread(myRunnable, "Thread" + i));
		
		for (Thread t : allThreads) 
			t.start();

		for (Thread t : allThreads) 
			t.join();

		System.out.println("Number of times counter was incremented: "
				+ myRunnable.counter.getCount());
		System.out.println("Sum of all counters: " + myRunnable.total);
		System.out.println("Math result: " + myRunnable.math);
	}
}
