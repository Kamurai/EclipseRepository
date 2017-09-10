//Kemerait, Christopher
//CS 3401
//Homework 3

package homework3;

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
				//none needed for this class
						
			//getter Positive Tests
				//test 2
				t.checkExpect(Bob.get(123), new Account("Bill", 123, 50.00));
						
			// Getter Negative Tests (if any)
				//test 3
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
				//test 4
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
		}
		// Come here for any unexpected Exceptions
		catch (Exception e) 
		{
			e.printStackTrace();
			t.fail();
		}
	}
}
