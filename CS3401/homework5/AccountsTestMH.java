//Masom Hamadeh
//C3401 Homework 5

package homework5;

import tester.*;

public class AccountsTestMH {
	
	public static void main(String[] args){
		Tester.run(new AccountsTestMH());
	}
	/***********************************************************
	//Create test methods here
	**********************************************************/
	public void testAccountsMH(Tester t){
		
		try{
			//constructor of test account - NEGATIVE test is NOT needed
			AccountsMH a1 = new AccountsMH();
			
			//TEST#1: getter NEGATIVE test
			try{
				a1.get(5);
				t.fail("Get method did NOT throw proper InvalidAccountException");
			}
			catch (InvalidAccountException e){
				t.success(); //get method did throw proper exception
			}
			
			//OPEN method POSITIVE
			a1.open(new Account("Laila", 369, 120.00));
			
			//OPEN method NEGATIVE test: open an account that already has the key
			a1.open(new Account("Laila", 369, 120.00));
			
			//make sure that Bob has #369 account so we'll create a new Accounts and add the previous account
			AccountsMH a2= new AccountsMH();
			a2.open(new Account("Laila", 369, 120.00));
			
			//TEST#2: compare a1 and a2
			t.checkExpect(a1, a2);
			
			//TEST#3: getter method POSITIVE test
			t.checkExpect(a1.get(369), new Account("Laila", 369, 120.00));
			
			//TEST#4: getter method NEGATIVE test
			try{
				a1.get(5);
				t.fail("Get method did NOT throw proper InvalidAccountException");
			}
			catch (InvalidAccountException e){
				t.success(); //get method did throw proper exception
			}
			
			/*NOTE: no setter method testing is needed 
			ALL other TESTING below*/
			
			//CLOSE method POSITIVE
			a1.close(369);
			
			//TEST#5: close method NEGATIVE test
			try{
				a1.close(369);
				t.fail("close method did NOT throw proper InvalidAccountException");
			}
			catch (InvalidAccountException e){
				t.success(); //close method did throw proper exception
			}
			
			//TOTAL method POSITIVE: we are going to create 4 accounts that have a total of $1000.00 
			a1.open(new Account("Laila", 369, 250.00));
			a1.open(new Account("Masom", 499, 250.00));
			a1.open(new Account("Eia", 123, 250.00));
			a1.open(new Account("Maya", 456, 250.00));
			
			//Create a seperate account to compare above acounts to, or checkerAccount
			//initializing account with 100.00 and then depositing another 900.00 to amount up to 1000.00 for comparison
			Accounts checkerAccount = new Accounts();
			checkerAccount.open(new Account("Test", 789, 100.00));
			checkerAccount.get(789).deposit(900.00);
		}
		//Any other exceptions...
		catch (Exception e){
			e.printStackTrace();
			t.fail();
		}
	}
}
