//Kemerait, Christopher
//CS 3401
//Homework 3

package homework3;

import java.util.*;



public class Accounts extends Object
{
	//Class that uses a Generic ArrayList
		//to maintain a list of Account objects
	ArrayList<Account> accountlist = new ArrayList<Account>();

	public Accounts()
	{
		//Empty Constructor
	}
	
	public void open(Account acct)
	{
		//add submitted Account to accountlist
		accountlist.add(acct);
			
	}

	public Account get(int id) throws InvalidAccountException
	{
		int tracker = -1;
		//return an Account based on the submitted ID number
		
		//find the Account with matching ID number in accountlist
		//	if accountlist is empty
		if( accountlist.size() == 0)
		{
			//throw new InvalidAccountException;
			throw new InvalidAccountException("There is no account with ID: " + id);
		}
		else
		{
		//walk through arraylist
			for(int x = 0; x < accountlist.size(); x++)
			{
				//if match is found
				if( accountlist.get(x).getId() == id)
				{
					//track
					tracker = x;
					//end search
					x = accountlist.size();
				}
			}
		}
			//if no such Account exists (or is not found)
			if(tracker == -1)
			{
				//throw new InvalidAccountException;
					throw new InvalidAccountException("There is no account with ID: " + id);
			}
			
		return accountlist.get(tracker);
	}

	public void close(int id) throws InvalidAccountException
	{
		int tracker = 0;
		//remove an Account from accountlist)
		
		//find Account with matching ID number in accountlist
		//if accountlist is empty
		if( accountlist.size() == 0)
		{
//			throw new InvalidAccountException;
			throw new InvalidAccountException("There is no account with ID: " + id);
		}
		else
		{
		//walk through arraylist
			for(int x = 0; x < accountlist.size()  ; x++)
			{
				//if match is found
				if( accountlist.get(x).getId() == id)
				{
					//track
					tracker = x;
					//end search
					x = accountlist.size();
				}
			}
		}
			//if no such Account exists (or is not found)
			if(tracker == -1)
			{
				//throw new InvalidAccountException;
					throw new InvalidAccountException("There is no account with ID: " + id);
			}
			
			//remove account
			accountlist.remove(tracker);
	}

	 

	
		
	
}
