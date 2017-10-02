package com.fdmgroup.demos.exceptions;

public class InsufficientFundsException extends Exception {

	private static final long serialVersionUID = 1L;

	// This Exception stores relevant details about the situation:
	
	private final double availableFunds;
    private final double requiredFunds;

    public InsufficientFundsException(double available, double required) {
        
    	super("Insufficient funds: Available $"+available+" but required $"+required);
       
    	this.availableFunds = available;
        this.requiredFunds = required;
    } 

    public double getAvailable() {
        return availableFunds;
    }

    public double getRequired() {
        return requiredFunds;
    }

    public double getDifference() {
        return requiredFunds - availableFunds;
    }
}