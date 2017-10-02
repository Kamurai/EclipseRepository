//Chinny Vixathrep

package homework4;

import java.util.*;
import tester.*;

public class Test {

	public static void main(String[] args){
		Tester.run(new Test());
	}
	
		/*####### TESTS ########
		 * 		CONSTRUCTOR, GET/SET METHOD TESTING , 
		 * 		AND NEGATIVE METHOD TESTING (NO FORESEEABLE EXCEPTIONS)
		 * 		ARE N/A FOR THIS CLASS
		#######################*/
	
	public void testSimpleStructures(Tester t){
		try{

			SimpleStructures<String> str = new SimpleStructures<String>();
			
			Set<String> s1 = new HashSet<String>();
			s1.add("monday");
			s1.add("tuesday");
			s1.add("wednesday");
			
			Set<String> s2 = new HashSet<String>();
			s2.add("monday");
			s2.add("thursday");
			s2.add("friday");
			s2.add("saturday");
			
			//expected union set, no regard to order
			Set<String> union = new HashSet<String>();
			union.add("monday");
			union.add("tuesday");
			union.add("wednesday");
			union.add("thursday");
			union.add("friday");
			union.add("saturday");
			
			//expected intersection set
			Set<String> intersection = new HashSet<String>();
			intersection.add("monday");
			
			List<String> s4 = new ArrayList<String>();
			s4.add("Blue");
			s4.add("Green");
			s4.add("Red");
			s4.add("Yellow");
			
			//expected List for reverse method
			ArrayList<String> reverse = new ArrayList<String>();
			reverse.add("Yellow");
			reverse.add("Red");
			reverse.add("Green");
			reverse.add("Blue");
			
			t.checkExpect(str.union(s1, s2), union);				//TEST 1 - UNION POSITIVE
			t.checkExpect(str.intersection(s1,s2), intersection);	//TEST 2 - INTERSECTION POSITIVE
			t.checkExpect(str.reverse(s4), reverse);				//TEST 3 - REVERSE POSITIVE
						
		}
		catch(Exception e){
			//all other exceptions caught here
			e.printStackTrace();
			t.fail();
		}
	}
}
