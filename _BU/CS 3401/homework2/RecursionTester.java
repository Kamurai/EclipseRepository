//Kemerait, Christopher
//CS 3401
//Homework 2

package homework2;
import tester.*;


public class RecursionTester 
{
	public static void main(String[] args) 
	{
		Tester.run(new RecursionTester());
	}

	// /////////////////////////////////////////////////////////////////
	// Create test methods here
	// /////////////////////////////////////////////////////////////////
	public void testBook(Tester t) 
	{
		try 
		{
			// Constructor
				//none needed for this abstract class
			//getter Positive Tests
				//none needed for this abstract class
			// Constructor Negative Test
				//none needed for this abstract class
			// Getter Negative Tests (if any)
				//none needed for this abstract class
			// Setter methods Positive tests
				//none needed for this abstract class
			// Setter methods Negative Tests (if any)
				//none needed for this abstract class
			
			//All other method testing
						
			// fractionalSeries method Positive test
			//test 1
			t.checkExpect(Recursion.fractionalSeries(5), ((1.00/5)+(1.00/4)+(1.00/3)+(1.00/2)+1.00));
			// fractionalSeries method negative test
			//test 2
			try 
			{
				Recursion.fractionalSeries(0);
				t.fail("deposit did not throw IllegalArgumentException");
			}
			catch (IllegalArgumentException e) 
			{
				// deposit method correctly threw exception
				t.success();
			}
			
			// gcd method Positive test
			// test 3 & 4
			t.checkExpect(Recursion.gcd(24, 16), 8);
			t.checkExpect(Recursion.gcd(255, 25), 5);
			
			// withdraw method negative test for negative amount withdrawn
			//test 5
			try 
			{
				Recursion.gcd(5, 0);
				t.fail("deposit did not throw ArithmeticException");
			}
			catch (ArithmeticException e) 
			{
				// withdraw method correctly threw exception
				t.success();
			}
			
			// largest method Positive test
			//test 6
			double[] list1 = {1, 2, 3, 4, 5};
			t.checkExpect(Recursion.largest(list1), 5.0);

			//test 7
			double[] list2 = {5, 4, 3, 2, 1};
			t.checkExpect(Recursion.largest(list2), 5.0);

			//test 8
			double[] list3 = {3, 1, 5, 2, 4};
			t.checkExpect(Recursion.largest(list3), 5.0);

			
			// largest method negative test
			//test 9
			double[] list4 = {};
			
			try 
			{
				Recursion.largest(list4);
				t.fail("deposit did not throw IllegalArgumentException");
			}
			catch (IllegalArgumentException e) 
			{
				// deposit method correctly threw exception
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


