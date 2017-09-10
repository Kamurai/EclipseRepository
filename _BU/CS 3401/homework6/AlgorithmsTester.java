//Kemerait, Christopher
//CS 3401
//Homework 6

package homework6;

import tester.Tester;


public class AlgorithmsTester 
{
	public static void main(String[] args) 
	{
		Tester.run(new AlgorithmsTester());
	}

	// /////////////////////////////////////////////////////////////////
	// Create test methods here
	// /////////////////////////////////////////////////////////////////
	public void testBook(Tester t) 
	{
		try 
		{
			//string for testing
			String Control = "abcnfeghijk";
			//string to search for in control
			String Target = "ijk";
			//string to find sorted in control
			String Sorted = "eghijk";
			//string that won't appear in control
				//won't return a sorted result more than 1 character
			String Fail = "onml";
			
			
			// Constructor
				//none needed for this class
			
			// Constructor Negative Test
				//none needed for this class
			
			// Getter Negative Tests (if any)
				//none needed for this class
			
			// Setter methods Positive tests
				//none needed for this class
			
			// Setter methods Negative Tests (if any)
				//none needed for this class
			
			//All other method testing
			
			//maxSortedSubString method Positive Test
				//test 1: find a know substring in Control
			t.checkExpect(Algorithms.maxSortedSubString(Control), Sorted);
				//test 2: find a single character substring in Control
			t.checkExpect(Algorithms.maxSortedSubString(Fail), "o");
								
			//maxSortedSubString method Negative Test
				//test 3: find a string of no length in a string of no length
			t.checkExpect(Algorithms.maxSortedSubString(""), "");
			
			
			//indexOf method Positive Test
				//test 4: find the known index of a known substring in Control
			t.checkExpect(Algorithms.indexOf(Control, Target), 8);
							
			//indexOf method Negative Test
				//test 5: search for the index of a substring with no length in control
					//should throw IllegalArgumentException
			try 
			{
				Algorithms.indexOf(Control, "");
				t.fail("get did not throw IllegalArgumentException");
			}
			catch (IllegalArgumentException e) 
			{
				// get method correctly threw exception
				t.success();
			}
				
			//indexOf method Negative Test
				//test 6: search for a substring in control that does not exist
			t.checkExpect(Algorithms.indexOf(Control, Fail), -1);

					
			}
		// Come here for any unexpected Exceptions
		catch (Exception e) 
		{
			e.printStackTrace();
			t.fail();
		}
	}
}
