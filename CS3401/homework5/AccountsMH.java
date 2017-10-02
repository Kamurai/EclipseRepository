//Masom Hamadeh
//C3401 Homework 5

package homework5;

import java.util.*;

//class that is used to maintain a list of Account objects
public class AccountsMH extends Object{
	
	//Need to maintain a list of account objects
	TreeMap<Integer, Account> accountCollection = new TreeMap <Integer, Account>();
	
	public AccountsMH(){
		//empty constructor
	}
	
	//OPEN method: Opens a new Account (Adds it to the list of Accounts)
	//NOTE: there is no need to throw an exception here, at least it was stated in the contract design as such
	 public void open (Account acct){
		 
		 int acctId = acct.getId(); //get the correct account ID of the parameter acct
		 accountCollection.put (acctId, acct); //add this acct and its id to treemap
	 }
	 
	 //GET method: Obtains an account based on its ID number
	 //Returns: Account object
	 public Account get (int id) throws InvalidAccountException{
		 
		 //we need to throw an exception if accountCollection is empty or if no such Account exists
		 if (accountCollection.size() == 0){
			 throw new InvalidAccountException ("The account collection is empty!");
		 }
		 else if (accountCollection.containsKey(id) == false){
			 throw new InvalidAccountException ("The account #"+ id + " does NOT exist!");
		 }
		 else{
			//finally, if previous to conditions are met, returns account based on ID
			 return accountCollection.get(id);
		}
	 }

	 //CLOSE method: Closes an Account (removes it from the list of Accounts)
	 public void close (int id) throws InvalidAccountException{
		 
		 //we need to throw an exception if accountCollection is empty or if no such Account exists
		 if (accountCollection.size() == 0){
			 throw new InvalidAccountException ("The account collection is empty!");
		 }
		 else if (accountCollection.containsKey(id) == false){
			 throw new InvalidAccountException ("The account #"+ id + " does NOT exist!");
		 }
		 else{
			//finally, if previous to conditions are met, returns account based on ID
			 accountCollection.remove(id);
		}
		 
	 }
	 
	 //TOTAL method: Calculates the total of the balances in all Accounts
	 //Returns: total of all Accounts as a double
	 public double total(){
		 
		 double accountTotal = 0.0; 
		 
		 //we need to now calculate what the total of the balances of all account(s) in Accounts (I think of it as a BANK)
		 //First, we must take all the accountCollection keys into a set..
		 Set<Integer> accountKeys = accountCollection.keySet();
		 
		 //and then for each account of the collection
		 for (Integer x : accountKeys){
			 //add the balance of each account to the dynamically changing total
			 accountTotal += accountCollection.get(x).getBalance();
		 }
		 
		 //finally, if the preconditions are met, returns the accountTotal balance
		 return accountTotal;
	 }
}
