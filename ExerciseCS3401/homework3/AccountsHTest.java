//Masom Hamadeh
//C3401 Homework 3 - Generics

package homework3;
import tester.*;

public class AccountsHTest {
	
	public static void main(String[] args){
		Tester.run(new AccountsHTest());
	}
	/**************************************************/
	//Create test methods here
	/**************************************************/
	public void testAccount(Tester t){
		
		try{
			AccountsH Laila= new AccountsH(); //constructor initiation
			//NOTE: There are NO constructor negative test for this class
			
			//Test#1: getter NEGATIVE test (if any present)
			try{ 
				Laila.get(10);
				t.fail("get method did NOT throw InvalidAccountException");
			}
			
			catch (InvalidAccountException e){
				t.success(); //get method correctly threw exception
			}
			
			Laila.open(new Account("Masom", 100, 50.00)); //open method POSITIVE test - creating for testing
			//NOTE: There is NO need for a for an open method negative test
			
			//Test#2: getter POSITIVE test
			t.checkExpect(Laila.get(100), new Account("Masom", 100, 50.00)); 
			
			//Test#3: getter NEGATIVE test
			try{
				Laila.get(10);
				t.fail("get method did NOT throw InvalidAccountException");
			}
			
			catch (InvalidAccountException e){
				t.success(); //get method did throw the correct exception			
			}
			
			//NOTE: there is no need to have a setter method POSITIVE/NEGATIVE test, skipping
			/*********************************************/
			//All other methods will be tested now
			
			
			Laila.close(100);
			
			//Test#4: close method POSITIVE test
			try{
				Laila.close(100);
				t.fail("close method did NOT throw InvalidAccountException");
			}
			
			catch (InvalidAccountException e){
				t.success(); //close method did indeed throw the correct exception
			}
		}
		
		//Here is where we'll show any other unexpected Exceptions
		catch (Exception e){
			e.printStackTrace();
			t.fail();
		}
	
	}
}
	
