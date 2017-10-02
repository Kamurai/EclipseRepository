package com.fdmgroup.patterns.observer2;

import java.util.Observable;


public class Loan extends Observable {

	private String type;
	private float interest;
	private String bank;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
		setChanged();
		notifyObservers(interest);
		clearChanged();
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

}
