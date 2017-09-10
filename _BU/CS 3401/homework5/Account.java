//Kemerait, Christopher
//CS 3401
//Homework 1

package homework5;


//import InsufficientFundsException;





public class Account
{
	//declare variables
	//Account id
	private int id;
	//Account owner
	private String owner;
	//Account balance
	private double balance;
	
	
	public Account(String owner, int id, double balance) throws IllegalArgumentException
	{
		//if balance is negative
		if(balance < 0)
		{
			//throw IllegalArgumentException
			throw new IllegalArgumentException ("The amount requested was negative.");

		}
		else
		{
			//Owner of this Account
			this.owner = owner;
			//ID Number on the Account
			this.id = id;
			//Initial Balance for the account
			this.balance = balance;
		}
		
	}

	public String getOwner()
	{
		//returns owner
		return owner;
	}

	public void setOwner(String owner)
	{
		//sets owner to new name
		this.owner = owner;
	}
	
	public int getId()
	{
		//returns id
		return id;
	}

	public double getBalance()
	{
		//returns balance
		return balance;
	}
	
	public void deposit(double amount) throws IllegalArgumentException
	{
		if(amount < 0)
		{
			throw new IllegalArgumentException ("The amount requested was negative.");

		}
		else
		{
			this.balance += amount;
		}
	}
	
	public void withdraw(double amount) throws InsufficientFundsException, IllegalArgumentException
	{
			if(amount > balance)
			{
				throw new InsufficientFundsException ("There are Insufficient Funds to process the transaction.");
			}
			else if(amount < 0)
			{
				throw new IllegalArgumentException ("The amount requested was negative.");

			}
			else
			{
				this.balance -= amount;
			}
	
	}
	
	
	
	
}