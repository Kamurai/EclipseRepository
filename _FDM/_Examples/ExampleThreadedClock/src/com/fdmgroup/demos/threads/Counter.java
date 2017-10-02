package com.fdmgroup.demos.threads;

public class Counter implements Runnable {

	private int lowerLimit;
	private int upperLimit;
	private int counter;
	
	private Counter childCounter;
	private boolean reachedLimit = false;

	public void setChildCounter(Counter childCounter) {
		this.childCounter = childCounter;
	}
	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}


	public Counter() {
	}

	public Counter(int lowerLimit, int upperLimit) {
		setLowerLimit(lowerLimit);
		setUpperLimit(upperLimit);
	}


	@Override
	public void run() {
		while (true) {
			if (childCounter == null)
				countSolo();
			else
				countInSyncWithChild();
		}
	}

	private void countSolo() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count();
		synchronized (this) {
			this.notifyAll();
		}
	}

	private void countInSyncWithChild() {
		synchronized (childCounter) {
			try {
				childCounter.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (childCounter.reachedLimit) {
				childCounter.reachedLimit = false;
				count();
			}
		}
	}

	private void count() {

		counter++;

		if (counter < upperLimit) {
			reachedLimit = false;
			return;
		}
		
		counter = lowerLimit;
		reachedLimit = true;

		synchronized (this) {
			this.notifyAll();
		}
	}

	public String toString() {
		return Integer.toString(counter);
	}

}
