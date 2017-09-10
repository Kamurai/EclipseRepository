package homework1;

import tester.*;


//This Test.java file is from Chinney Vixathep

public class Test {
	public static void main(String[] args) {
		Tester.run(new Test());
	}

	public void testAccount(Tester t) {
		try {
// Constructor & Getter Positive Tests
			Account a1 = new Account("Chipper Jones", 10, 50.00);
			//test 1
			t.checkExpect(a1.getBalance(), 50.00);			//test 1
			//test 2
			t.checkExpect(a1.getId(), 10);					//test 2
			//test 3
			t.checkExpect(a1.getOwner(), "Chipper Jones");	//test 3

// Constructor Negative Test
			//***TEST 4***
			try {
				Account a2 = new Account("Chipper Jones", 10, -1);
				t.fail("Constructor did not throw exception");
			}
			catch (IllegalArgumentException e) {
				// Constructor correctly threw exception
				t.success();								
			}
			
// Getter Negative Tests (none)
// Setter methods Positive tests
			
			//***TEST 5***
			a1.setOwner("conan o'brien");
			t.checkExpect(a1, new Account("conan o'brien", 10, 50.00));
			
//Setter methods Negative Tests (none)
//withdraw POSITIVE
			
			Account a3 = new Account("Conan O'brien", 10, 500.00);
			
			//***TEST 6***
			try{
				a3.withdraw(200);
				t.checkExpect(a3.getBalance(), 300.0);			
			}
			catch(Exception e){
				//exceptions are not expected for this test
				t.fail("withdraw method: exception was caught for a positive test");
			}
			
//withdraw NEGATIVE
			
			//***TEST 7 ***
			try{
				a3.withdraw(700);	//bad argument
				t.fail("withdraw method: a bad argument was processed");
			}
			catch (InsufficientFundsException e){
				//the exception was handled properly
				t.success();
			}
			
			//***TEST 8***
			try{
				a3.withdraw(-45);	//bad argument
				t.fail("withdraw method: a bad argument was processed");
			}
			catch (IllegalArgumentException e){
				//the exception was handled properly
				t.success();
			}
			
//deposit POSITIVE
			//***TEST 9***
			try{
				a3.deposit(500.00);
				t.checkExpect(a3.getBalance(), 800.0);
			}
			catch (IllegalArgumentException e){
				//exceptions are not expected
				t.fail("deposit method: exception caught for a positive test");
			}
//deposit NEGATIVE
			//***TEST 10***
			try{
				a3.deposit(-1000);
				t.fail("deposit method: a bad argument was processed");
			}
			catch (IllegalArgumentException e){
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
