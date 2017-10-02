//Kemerait, Christopher
//CS 3401
//Homework 3

package homework5;

import java.util.*;



public class Accounts extends Object
{
	//Class that uses a Generic ArrayList
		//to maintain a list of Account objects
	TreeMap<Integer, Account> accounttreemap = new TreeMap<Integer, Account>();

	public Accounts()
	{
		//Empty Constructor
	}
	
	public void open(Account acct)
	{
		//add submitted Account to accountlist
		accounttreemap.put(acct.getId(), acct);
	}

	public Account get(int id) throws InvalidAccountException
	{
		//return an Account based on the submitted ID number
		
		//find the Account with matching ID number in accountlist
		// if accountlist is empty
		// or if no such Account exists (or is not found)
		if( accounttreemap.size() == 0 || accounttreemap.containsKey(id) == false)
		{
			//throw new InvalidAccountException;
			throw new InvalidAccountException("There is no account with ID: " + id);
		}
					
		return accounttreemap.get(id);
	}

	public void close(int id) throws InvalidAccountException
	{
		//remove an Account from accountlist)
		
		//find Account with matching ID number in accountlist
		// if accountlist is empty
		// or if no such Account exists (or is not found)
		if( accounttreemap.size() == 0 || accounttreemap.containsKey(id) == false)
		{
			//throw new InvalidAccountException;
			throw new InvalidAccountException("There is no account with ID: " + id);
		}
			
		//remove account
		accounttreemap.remove(id);
	}
	
	
	public double total()
	{
		double total = 0.00;
	//Calculate the total of the balances in all Accounts 

		//place accounttreemap keys into a set
		Set<Integer> accountkeyset = accounttreemap.keySet();
		
		//for each account of accountreemap
		for( Integer x : accountkeyset)
		{
			//add balance to total
			total += accounttreemap.get(x).getBalance();
		}
		
	//Returns	the total of all Accounts
		return total;
	}
	 

	
		
	
}
