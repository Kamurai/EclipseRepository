//Masom Hamadeh
//C3401 Homework 3 - Generics

package homework3;

import java.util.*;

//class that uses a Generic ArrayList to maintain a list of Account objects
public class AccountsH extends Object{ 
	
	 //We need class that uses a GENERIC arraylist of account objects to maintain 
	ArrayList<Account> aList= new ArrayList<Account>(); 
	
	public AccountsH(){ //this is an empty constructor
	}
	
	public void open (Account acct){
		aList.add(acct); //opens a new Account and adds it to the list of Accounts
	}
	
	//this method will obtain an Account based on its ID number given in parameter
	public Account get(int id) throws InvalidAccountException{ 
		
		//Create a type of safeguard to compare and see if an account even exists - variable
		int checker=-1;
		 		
		if (aList.size()==0){
			throw new InvalidAccountException("Account ID: "+ id +", does NOT exist!"); //throws exception based on if the account exists
		}
		else{
			
			for(int y=0;  y < aList.size(); y++){ //this will start the search through the array
				
				//if a match if sound during search, move through if statement
				if(aList.get(y).getId() == id){ 
					checker=y;
					y=aList.size(); //end the search
				}
			}
		}
		
		//if NO account exists based on ID number then the safeguard will be the same
		if(checker==-1){				 
			throw new InvalidAccountException("Account ID: "+ id +", does NOT exist!"); //just as above
		}
		
		return aList.get(checker); //returns account based on given ID - IF it exists
		}
	
	//this method will close a particular account based on its id - if it exists!
	public void close(int id) throws InvalidAccountException{
		
		//Create a type of safeguard to compare and see if an account even exists 
		int checker=-1;
		
		//same as above code, looking for an account with a matching ID number in aList
		//BUT if the account is empty, a exception will be thrown (same as open method)
		if(aList.size() == 0){
			throw new InvalidAccountException("Account ID: "+ id +", does NOT exist!"); //just as above)
		}
		else{
			for(int y=0; y < aList.size(); y++){ //start the search again through the aList
				
				//same comments as above
				if(aList.get(y).getId() == id){
					checker=y;
					y=aList.size();
				}
			}
		}
		
		if(checker == -1){
			throw new InvalidAccountException("Account ID: "+ id +", does NOT exist!");
		}
		
		aList.remove(checker); //finally if account exists and is found, it will be closed/removed
		}
	}
