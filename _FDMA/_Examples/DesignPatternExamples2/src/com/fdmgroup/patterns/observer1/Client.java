package com.fdmgroup.patterns.observer1;

public class Client {

	public static void main(String[] args) {
		
		// Demonstration using custom Observer and 
		// Observable interfaces.
		
		Loan loan = new Loan();
		loan.setType("Personal Loan");
		loan.setInterest(17);
		loan.setBank("Lloyds");

		Newspaper newspaper = new Newspaper();
		Radio radio = new Radio();
		
		loan.attach(newspaper);
		loan.attach(radio);

		loan.setInterest(15);
	}
}
