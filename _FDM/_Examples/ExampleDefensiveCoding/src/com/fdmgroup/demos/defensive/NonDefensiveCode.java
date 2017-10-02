package com.fdmgroup.demos.defensive;

public class NonDefensiveCode {

	public static void downcast(Object object) {

		String string = (String) object;
		System.out.println(string);
	}

	public static void divide(int op1, int op2) {

		System.out.println(op1 + "/" + op2 + " = " + op1 / op2);
	}

	public static void callToString(Object object) {

		System.out.println(object.toString());
	}


}
