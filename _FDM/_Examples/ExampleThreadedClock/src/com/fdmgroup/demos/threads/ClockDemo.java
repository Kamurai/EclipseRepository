package com.fdmgroup.demos.threads;

public class ClockDemo {
	public static void main(String[] args) throws InterruptedException {

		Counter seconds = new Counter(0, 10);
		Counter minutes = new Counter(0, 10);
		Counter hours = new Counter(0, 2);
		
		minutes.setChildCounter(seconds);
		hours.setChildCounter(minutes);
		
		Thread sT = new Thread(seconds);
		Thread mT = new Thread(minutes);
		Thread hT = new Thread(hours);
		
		hT.start();
		mT.start();
		sT.start();

		while (true) {
			synchronized (seconds) {
				seconds.wait();
				System.out.println(hours + ":" + minutes + ":" + seconds);
			}
		}
	}
}
