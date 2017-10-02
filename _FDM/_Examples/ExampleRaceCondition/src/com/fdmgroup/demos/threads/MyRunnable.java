package com.fdmgroup.demos.threads;

public class MyRunnable implements Runnable {

	Counter counter;
	int total = 0;
	int math = 0;

	public MyRunnable(Counter count) {
		this.counter = count;
	}

	@Override
	public void run() {
		count();
	}

	public/* synchronized */void count() {
		for (int i = 0; i < 10; i++) {

			counter.increment();
			total = total + counter.getCount();
			math = total * counter.getCount();

			String message = "[" + Thread.currentThread().getName() + "] "
					+ "[Time] " + System.currentTimeMillis() + " [Count] "
					+ counter.getCount();

			System.out.println(message);

			
			// Sleeping for 20ms to highlight race condition

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
