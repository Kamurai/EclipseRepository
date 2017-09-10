//Kemerait, Christopher
//CS 3401
//Homework 4

package homework4;
import tester.*;
import java.util.*;


public class SimpleStructuresTester 
{
	public static void main(String[] args) 
	{
		Tester.run(new SimpleStructuresTester());
	}

	// /////////////////////////////////////////////////////////////////
	// Create test methods here
	// /////////////////////////////////////////////////////////////////
	public void testBook(Tester t) 
	{
		try 
		{
			// Constructor
			SimpleStructures<Integer> Todd = new SimpleStructures<Integer>();
			
			// Constructor Negative Test
				//none needed for this class
			
			//getter Positive Tests
				//none needed for this class
			
			// Getter Negative Tests (if any)
				//none needed for this class
			
			// Setter methods Positive tests
				//none needed for this class
			
			// Setter methods Negative Tests (if any)
				//none needed for this class
			
			//All other method testing
				
			//create a Set for the firstSet parameter
				Set<Integer> Bob = new HashSet<Integer>();
				
				//add some arbitrarated integers
				Bob.add(1);
				Bob.add(2);
				Bob.add(3);
				
				//create a Set for the otherSet parameter
				Set<Integer> Jim = new HashSet<Integer>();
				
				//add some arbitrarated integers
					//ensure that at least one integer is in Bob
				Jim.add(3);
				Jim.add(4);
				Jim.add(5);
				
				//create a control Set to match the desired results from .union()
				Set<Integer> Nick = new HashSet<Integer>();
				
				Nick.add(1);
				Nick.add(2);
				Nick.add(3);
				Nick.add(4);
				Nick.add(5);
				
				//union method Positive Test
					//test 1
					t.checkExpect(Todd.union(Bob, Jim), Nick);
					
					
				//union method Negative Test
					//none needed for this class
					
				//clear Nick and set as a control Set for intersection
				Nick.clear();
				Nick.add(3);
					
				//intersection method Positive Test
					//test 2
					t.checkExpect(Todd.intersection(Bob, Jim), Nick);
					
				//intersection method Negative Test
					//none needed for this class
				
				//create a List for the reverse method
					List<Integer> Jill = new ArrayList<Integer>();
					
					Jill.add(1);
					Jill.add(2);
					Jill.add(3);
					Jill.add(4);
					Jill.add(5);
					Jill.add(6);
					Jill.add(7);
					Jill.add(8);
					
				//create a control List for the reverse method
					List<Integer> Mary = new ArrayList<Integer>();
					
					Mary.add(8);
					Mary.add(7);
					Mary.add(6);
					Mary.add(5);
					Mary.add(4);
					Mary.add(3);
					Mary.add(2);
					Mary.add(1);
					
				//reverse method Positive Test
					t.checkExpect(Todd.reverse(Jill), Mary);
					
				//reverse method Negative Test
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
