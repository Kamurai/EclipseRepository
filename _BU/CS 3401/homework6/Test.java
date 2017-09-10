//Chinny Vixathrep

package homework6;
import tester.*;

public class Test {
	public static void main(String[] args) {
		Tester.run(new Test());
	}

	public void testAlgorithms(Tester t) {
		try {
			/*####### TESTS ########
			 * 	no constructor tests
			 * 	no getter/setter methods
			#######################*/
			
			//test strings
			String s1 = "katie bear brendan chinny";					
			String s2 = "brendan chinny katie bear";			
			String s3 = " chinny bear";					
			
			String s4 = " chinny";			//target string				
			String s5 = "";					//empty string	
			
	//METHOD TESTING
			
		//maxSortedSubString positive
			//****test 1 (longest substring is at end of string)****
			t.checkExpect(Algorithms.maxSortedSubString(s1), s4);
				
			//****test 2 (longest substring is in the middle)****
			t.checkExpect(Algorithms.maxSortedSubString(s2), s4);
			
			//****test 3 (longest substring is the first substring)****
			t.checkExpect(Algorithms.maxSortedSubString(s3), s4);
			
			//****test 4 (longest substring is the entire string)****
			t.checkExpect(Algorithms.maxSortedSubString(s4), s4);
			
			//****test 5 (input is an empty string)****
			t.checkExpect(Algorithms.maxSortedSubString(s5), s5);
			
			
			
		//maxSortedSubString negative (none)
			
		//indexOf positive
			//*****test 6-9*****
			t.checkExpect(Algorithms.indexOf(s4, s4), 0);		//identical strings
			t.checkExpect(Algorithms.indexOf(s1, s4), 18);
			t.checkExpect(Algorithms.indexOf(s3, s4), 0);
			t.checkExpect(Algorithms.indexOf(s4, "jeff"), -1);	//substring not found 
			
		//indexOf negative
			//****test 10 (second string is longer than first string)****
			t.checkExpect(Algorithms.indexOf("jeff", s4), -1);
			//try{
				//Algorithms.indexOf("jeff", s4);
				//t.fail("Algorithms.indexOf: method did not throw correct exception");
			//}
			//catch (IllegalArgumentException e){
				//t.success();
			//}
			//****test 11 *****
			try{
				Algorithms.indexOf(s4, "");
				t.fail("Algorithms.indexOf: method did not throw correct exception");
			}
			catch (IllegalArgumentException e){
				t.success();
			}
//Come here for any unexpected Exceptions
		}
		catch (Exception e) {
			e.printStackTrace();
			t.fail();
		}
	}
}