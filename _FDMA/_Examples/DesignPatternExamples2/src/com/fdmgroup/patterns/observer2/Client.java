package com.fdmgroup.patterns.observer2;

public class Client {

	public static void main(String[] args) {
		
		// Demonstration using classes from the Java API
		// instead of custom interfaces.
		
		Loan loan = new Loan();
		loan.setType("Personal Loan");
		loan.setInterest(17);
		loan.setBank("Lloyds");

		Newspaper newspaper = new Newspaper();
		Radio radio = new Radio();
		
		loan.addObserver(newspaper);
		loan.addObserver(radio);

		loan.setInterest(15);
	}
}
