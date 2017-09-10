//The following was written by Chinny Vixathep

package homework3;

import tester.Tester;

public class Test {
	public static void main(String[] args) {
		Tester.run(new Test());
	}

	public void testAccounts(Tester t) {
		try {
//TESTS
//Constructor/Getter POSITIVE	(N/A)
//Constructor NEGATIVE	(N/A)
//Getter NEGATIVE	(N/A)
//Setter POSTIVE  (N/A)
//Setter NEGATIVE 	(N/A)
			
			
//################### tests starts here ########################
			Accounts accounts = new Accounts();	//new Accounts list object

			//accounts to be manipulated
			Account a1 = new Account("Tom", 1,500.00);
			Account a2 = new Account("Joe", 2, 85.50);
			Account a99 = new Account("Steve", 99, 10.05);
			Account a75 = new Account("Rachel", 75, 99.99);
			
//open/get POSITIVE		
			//*****TEST 1-4******
			try{
				accounts.open(a1);
				accounts.open(a2);
				accounts.open(a99);
				accounts.open(a75);
				t.checkExpect(accounts.get(1), new Account("Tom", 1,500.00));
				t.checkExpect(accounts.get(2), new Account("Joe", 2, 85.50));
				t.checkExpect(accounts.get(99), a99);
				t.checkExpect(accounts.get(75), a75);
			}
			
			catch (Exception e){
				//exception is not expected for positive test
				t.fail("Accounts.open: exception caught for a positive test");
			}
			
//open NEGATIVE	(N/A)	
//close POSITIVE
			//******TEST 5********
			try{
				accounts.close(1);
				accounts.close(2);
				accounts.close(75);
				accounts.close(99);		
				t.success(); //all accounts closed successfully
			}
			catch(Exception e){
				//all accounts are expected to pass
				t.fail("Accounts.close: exception caught for a positive test");
			}
//close NEGATIVE
			//*******TEST 6********
			try{
				accounts.close(12);
				t.fail("Accounts.close: an incorrect argument was processed");	
			}
			catch(InvalidAccountException e){
				//exception handled properly
				t.success();
			}
//get method POSITIVE (redundant)
//get method NEGATIVE test
			//********TEST 7******
			try{
				accounts.get(12);
				t.fail("Accounts.get: an incorrect argument was processed");
			}
			catch(InvalidAccountException e){
				//exception handled properly
				t.success();
			}
		}
		
//Come here for any unexpected Exceptions
		catch (Exception e) {
			e.printStackTrace();
			t.fail();
		}
	}
}
