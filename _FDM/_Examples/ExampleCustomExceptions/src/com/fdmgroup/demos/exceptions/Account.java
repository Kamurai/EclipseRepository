package com.fdmgroup.demos.exceptions;

import java.math.BigDecimal;

public class Account {

	private int accountNumber;
	private BigDecimal balance;

	public Account(){
		balance = BigDecimal.ZERO;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(BigDecimal balance) {
			
		this.balance = balance;
	}
	
}
