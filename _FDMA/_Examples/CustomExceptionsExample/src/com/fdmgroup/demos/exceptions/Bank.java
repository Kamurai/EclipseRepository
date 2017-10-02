package com.fdmgroup.demos.exceptions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {

	private List<Account> accounts;
	
	public Bank(){
		accounts = new ArrayList<Account>();
	}
	
	public Account registerNewAccount(){
		Account account = new Account();
		accounts.add(account);
		return account;
	}
	
	// These methods do not return a value that represents success/failure.
	// Instead, withdraw() throws an Exception when it fails.
	
	public void withdraw(Account account, BigDecimal amount) throws InsufficientFundsException{
		
		BigDecimal balance = account.getBalance();
		
		if(balance.compareTo(amount) < 0)
			throw new InsufficientFundsException(balance.doubleValue(), amount.doubleValue());
		
		account.setBalance(balance.subtract(amount));
	}
	
	
	public void deposit(Account account, BigDecimal amount){
		
		account.setBalance(account.getBalance().add(amount));
		
	}
}
