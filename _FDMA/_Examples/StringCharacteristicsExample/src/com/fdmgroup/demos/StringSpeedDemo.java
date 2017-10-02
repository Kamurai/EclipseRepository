package com.fdmgroup.demos;

public class StringSpeedDemo {
	
	public void run() {

		StopWatch stopWatch = new StopWatch();

		// StringBuffer
		
		StringBuffer stringBuffer = new StringBuffer();
		
		stopWatch.start();	
		
		for (int i = 0; i < 100000; i++)
			stringBuffer.append("*");
		
		stopWatch.stop();
		
		System.out.println("StringBuffer concatenation (elapsed time in milliseconds): "
						+ stopWatch.getElapsedMillis());

		// StringBuilder
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stopWatch.start();
		
		for (int i = 0; i < 100000; i++)
			stringBuilder.append("*");
		
		stopWatch.stop();
		
		System.out.println("StringBuilder concatenation (elapsed time in milliseconds): "
						+ stopWatch.getElapsedMillis());

		// String
		
		String string = new String();
		
		stopWatch.start();
		
		for (int i = 0; i < 100000; i++)
			string += "*";
		
		stopWatch.stop();
		
		System.out.println("String concatenation (elapsed time in milliseconds): "
						+ stopWatch.getElapsedMillis());

	}	
}

class StopWatch {

	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;

	public void start() {
		this.startTime = System.currentTimeMillis();
		this.running = true;
	}

	public void stop() {
		this.stopTime = System.currentTimeMillis();
		this.running = false;
	}

	public long getElapsedMillis() {
		return running ? (System.currentTimeMillis() - startTime)
				: (stopTime - startTime);
	}

}
