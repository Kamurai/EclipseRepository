package com.fdmgroup.demos;

public class TwoTypeDemo<T, X> {

	T	one;
	X	two;

	TwoTypeDemo(T one, X two) {

		this.one = one;
		this.two = two;
	}

	T getFirst() {

		return one;
	}

	X getSecond() {

		return two;
	}

	public static void main(String[] args) {
		
		TwoTypeDemo<Integer,String> myContainer = 
				new TwoTypeDemo<Integer,String>(8,"hello");
		
		int one = myContainer.getFirst();
		String two = myContainer.getSecond();
	}
}


