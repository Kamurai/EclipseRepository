//Kemerait, Christopher
//CS 3401
//Homework 3

package homework5;

import tester.Tester;


public class AccountsTester 
{
	public static void main(String[] args) 
	{
		Tester.run(new AccountsTester());
	}

	// /////////////////////////////////////////////////////////////////
	// Create test methods here
	// /////////////////////////////////////////////////////////////////
	public void testBook(Tester t) 
	{
		try 
		{
			// Constructor
			Accounts Bob = new Accounts();
			
			// Constructor Negative Test
				//none needed for this class
			
			// Getter Negative Tests (if any)
			//test 1
			try 
			{
				Bob.get(7);
				t.fail("get did not throw InvalidAccountException");
			}
			catch (InvalidAccountException e) 
			{
				// get method correctly threw exception
				t.success();
			}
			
			//open method Positive test
			Bob.open(new Account("Bill", 123, 50.00));
			
			//open method Negative test
				//open an account that already has the key 
					//for the accounttreemap
			Bob.open(new Account("Bill", 123, 50.00));
			
				//ensure that Bob only has the one "123" account
					//create a new Accounts and add the one account
						//Bob should have to Bill
			Accounts Harry = new Accounts();
			Harry.open(new Account("Bill", 123, 50.00));
			
			//test 2
			t.checkExpect(Bob, Harry);
			
			
			//getter Positive Tests
				//test 3
				t.checkExpect(Bob.get(123), new Account("Bill", 123, 50.00));
						
			// Getter Negative Tests (if any)
				//test 4
				try 
				{
					Bob.get(7);
					t.fail("get did not throw InvalidAccountException");
				}
				catch (InvalidAccountException e) 
				{
					// get method correctly threw exception
					t.success();
				}
				
			
			// Setter methods Positive tests
				//none needed for this class
			
			// Setter methods Negative Tests (if any)
				//none needed for this class
			
			//All other method testing
			
			//close method Positive Test
				Bob.close(123);
				
				
			//close method Negative Test
				//test 5
				try 
				{
					Bob.close(123);
					t.fail("get did not throw InvalidAccountException");
				}
				catch (InvalidAccountException e) 
				{
					// get method correctly threw exception
					t.success();
				}
				
				//total method Positive Test
					//create accounts to total $150 for Bob
				Bob.open(new Account("Ted", 123, 50.00));
				Bob.open(new Account("Tom", 345, 50.00));
				Bob.open(new Account("Fido", 567, 50.00));
				
					//create a control account with $150
				Harry.get(123).deposit(100.00);
				
				//test 6
				t.checkExpect(Bob.total(), Harry.total());
				
				//total method Negative Test
					//none needed for this class
		}
		// Come here for any unexpected Exceptions
		catch (Exception e) 
		{
			e.printStackTrace();
			t.fail();
		}
	}
}
