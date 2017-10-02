package com.fdmgroup.demos.defensive;

public class DefensiveCode {

	public static void downcastToString(Object object) {

		if (!(object instanceof String))
			return;

		String string = (String) object;
		System.out.println(string);
	}

	public static void divide(int op1, int op2) {

		if (op2 <= 0)
			return;

		System.out.println(op1 + "/" + op2 + " = " + op1 / op2);
	}

	public static void callToString(Object object) {

		if (object == null)
			return;

		System.out.println(object.toString());
	}

}
