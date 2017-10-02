package homework1;
//import Account.InsufficientFundsException;
import tester.*;






public class AccountTester 
{
	public static void main(String[] args) 
	{
		Tester.run(new AccountTester());
	}

	// /////////////////////////////////////////////////////////////////
	// Create test methods here
	// /////////////////////////////////////////////////////////////////
	public void testBook(Tester t) 
	{
		try 
		{
			// Constructor & getter Positive Tests
			
			Account Bob = new Account("Bob", 123, 50);
			//test 1
			t.checkExpect(Bob.getOwner(), "Bob");
			//test 2
			t.checkExpect(Bob.getId(), 123);
			//test 3
			t.checkExpect(Bob.getBalance(), 50.00);
						

			// Constructor Negative Test
			// Should throw exception for pages=0
			//test 4
			try
			{
				Account Joe = new Account("Joe", 125, (-50.00));
				t.fail("Constructor did not throw exception");
			}
			catch (IllegalArgumentException e) 
			{
				// Constructor correctly threw exception
				t.success();
			}
							
			// Getter Negative Tests (if any)
				//getters should not take parameters
			
			// Setter methods Positive tests
			Bob.setOwner("Chris");
			//test 5
			t.checkExpect(Bob, new Account("Chris", 123, 50));
			
			// Setter methods Negative Tests (if any)
				//setOwner can be any input by contract
			
			//All other method testing
						
			// deposit method Positive test
			Bob.deposit(50);
			//test 6
			t.checkExpect(Bob, new Account("Chris", 123, 100));
			//test 7
			// deposit method negative test
			try 
			{
				Bob.deposit(-50);
				t.fail("deposit did not throw IllegalArgumentException");
			}
			catch (IllegalArgumentException e) 
			{
				// deposit method correctly threw exception
				t.success();
			}
			
			// withdraw method Positive test
			Bob.withdraw(50);
			//test 8
			t.checkExpect(Bob, new Account("Chris", 123, 50));
			//test 9
			// withdraw method negative test for negative amount withdrawn
			try 
			{
				Bob.withdraw(-50);
				t.fail("deposit did not throw InsufficientFundsException");
			}
			catch (IllegalArgumentException e) 
			{
				// withdraw method correctly threw exception
				t.success();
			}
			//test 10
			// withdraw method negative test for insufficient funds
			try 
			{
				Bob.withdraw(100);
				t.fail("deposit did not throw InsufficientFundsException");
			}
			catch (InsufficientFundsException b) 
			{
				// withdraw method correctly threw exception
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


