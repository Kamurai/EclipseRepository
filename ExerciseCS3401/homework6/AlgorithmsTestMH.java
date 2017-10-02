//Masom Hamadeh
//CS 3401 - HW#6

package homework6;
import tester.*;

public class AlgorithmsTestMH{
	
	public static void main (String[] args){
		
		Tester.run(new AlgorithmsTestMH());
	}
	
	/************************************************************************************
	 * Create test methods here
	 ***********************************************************************************/
	public void testAlgorithm (Tester t){
		
		try{
			
			//main string to test
			String main = "lailamasomhamadeh";
			//string to search within main
			String t2= "masom";
			//string to find sorted within main
			String t3 = "adeh";
			//string that will not even appear - only result by one character
			String t4 = "zyx";
			
			//NOTE: we are not going to use any constructor, getter, and/or setter tests
			//Let's test all other methods
			
			//maxSortedSubString method POSITIVE testing
			//TEST #1: find a a substring that is known to be in main
			t.checkExpect (AlgorithmsMH.maxSortedSubString(main), t3);
			
			//TEST #2: find a single character substring in tester
			t.checkExpect (AlgorithmsMH.maxSortedSubString(t4), "z"); 
			
			//maxSortedSubString method NEGATIVE testing
			//TEST #3: find a string with no length within another string with no length
			t.checkExpect (AlgorithmsMH.maxSortedSubString(""), "");
			
			//indexOf method POSITIVE testing
			//TEST #4: we need to find the index of a substring in the tester
			t.checkExpect (AlgorithmsMH.indexOf(main, t2), 5);
			
			//indexOf method NEGATIVE testing - tests 5 and 6
			//TEST #5: search for the index of a substring that has ZERO length in checker string
			//Must throw exception!
			try{
				AlgorithmsMH.indexOf (main, "");
				t.fail ("Algorithms.indexOf method did NOT correctly throw exception");
			}
			catch (IllegalArgumentException e){
				t.success(); //correctly threw the exception
			}
			
			//Test #6: search for a string that doesn't even exist
			t.checkExpect (AlgorithmsMH.indexOf(main, t4), -1);
		}
		
		//all other exceptions/problems
		catch (Exception e){
			e.printStackTrace();
			t.fail();
		}
	}
}
