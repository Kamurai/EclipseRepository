//Test.java by Chinny Vixathep

package homework2;

import tester.*;

public class Test {
	public static void main(String[] args) {
		Tester.run(new Test());
	}

	public void testRercusion(Tester t) {
		try {
//Constructor & Getter Positive Test (none)
//Constructor Negative Test (none)
//Getter Negative Test (none)
//Setter Positive tests (none)			
//Setter Negative Tests (none)

//METHOD TESTING...
			
//Fractional Series POSITIVE
			
		//***Test 1***
			try{
				t.checkExpect(Recursion.fractionalSeries(5), 2.283);			
			}
			catch(Exception e){
				//exceptions are not expected for this test
				t.fail("Fractional Series Method: exception was caught for a positive test");
			}
			
//Fractional Series NEGATIVE
		//***Test 2***
			try{
				Recursion.fractionalSeries(-7);	//bad argument
				t.fail("Fractional Series Method: an incorrect argument was processed");
			}
			catch (IllegalArgumentException e){
				//the exception was handled properly
				t.success();
			}

//GCD POSITIVE
			//***TEST 3/4***
			try{
				t.checkExpect(Recursion.gcd(24,16), 8);
				t.checkExpect(Recursion.gcd(255,25), 5);
			}
			catch (Exception e){
				//exceptions are not expected
				t.fail("GCD Method: exception caught for a positive test");
			}
//GCD NEGATIVE
			//***TEST 5***
			try{
				Recursion.gcd(75,0);
				t.fail("GCD Method: an incorrect argument was processed");
			}
			catch (ArithmeticException e){
				//exception handled properly
				t.success();
			}
			/*
//Largest Value Method POSITIVE
			//***TEST 6-8***
			try{
				double x = Recursion.largest(new double[]{1.5, 1.1, 1.9, 1.2, 1.1});
				t.checkExpect(x, 1.9);
				
				double y = Recursion.largest(new double[]{2.2, 2.0, 2.8, 2.5});
				t.checkExpect(y, 2.8);
				
				//test for length = 1
				t.checkExpect(Recursion.largest(new double[]{50}), 50.0);
			}
			catch(Exception e){
				t.fail("Largest Method: exception caught for a positive test");
			}
//Largest Value Method NEGATIVE
			//***TEST 9***
			try{
				Recursion.largest(new double[]{});
				t.fail("Largest Method: an incorrect argument was processed");
			}
			catch(IllegalArgumentException e){
				t.success();
			}
			*/
		}
//All other exceptions
		catch (Exception e) {
			e.printStackTrace();
			t.fail();
		}
	}
}