package com.fdmgroup.demos.threads;

public class Demo {
	
	public static void main(String[] args) {

		new MyBasicThread("London").start();
		new MyBasicThread("New York").start();

		for (int i = 0; i < 10; i++)
			System.out.println(i + " main() code");

		System.out.println("... end of main()");

	}
}
