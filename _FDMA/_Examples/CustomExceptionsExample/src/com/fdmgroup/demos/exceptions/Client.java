package com.fdmgroup.demos.exceptions;

import java.math.BigDecimal;

public class Client {

	public static void main(String[] args) {
		
		Bank bank = new Bank();
		
		Account account1 = bank.registerNewAccount();
		
		account1.setAccountNumber(1001);
		account1.setBalance(BigDecimal.valueOf(20));
		
		try {
			bank.withdraw(account1, BigDecimal.valueOf(40));

		} catch (InsufficientFundsException e) {
			System.out.println("Operation failed, please try again - "+ e.getMessage());
		}
		
	}
}
