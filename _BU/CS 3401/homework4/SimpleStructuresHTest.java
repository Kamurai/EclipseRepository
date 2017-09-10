//Masom Hamadeh
//CS3401
//Homework #4

package homework4;
import tester.*;
import java.util.*;

public class SimpleStructuresHTest{
	
	public static void main(String[] args){
			
		Tester.run(new SimpleStructuresHTest());
	}
	/*********************************************************************
	 * Create test methods here
	 ********************************************************************/
	
	public void testSimpleStructures(Tester t){
		
		try{
				//using constructor
				SimpleStructuresH<Integer> Laila = new SimpleStructuresH<Integer>();
				
				//NOTE: we do NOT need to test any of the following: constuctor negative, getter positive, getter negative, setter positive, setter negative
				//All other method testing will begin below
				
				//create firstSet and then add some random integer numbers
				Set<Integer> Masom = new HashSet<Integer>();
				Masom.add(10); 
				Masom.add(20);
				Masom.add(30);
				
				//create otherSet and then add some random integer numbers to play around with
				//Note: we need to make sure that there is at least one integer that is in Masom!
				Set<Integer> Looloo = new HashSet<Integer>();
				Looloo.add(30);
				Looloo.add(40);
				Looloo.add(100);
				
				//create a checkerSet to make sure the union method is working, a desired set if you will
				Set<Integer> CheckerUnion = new HashSet<Integer>();
				CheckerUnion.add(10); 
				CheckerUnion.add(20); 
				CheckerUnion.add(30);
				CheckerUnion.add(40);
				CheckerUnion.add(100);
				
				//Test#1: union method POSITIVE Test (NOTE: no need for a union method NEGATIVE test)
				t.checkExpect(Laila.union(Masom, Looloo), CheckerUnion);
				
				//Now we are going to create another checkerSet to make sure intersection works
				Set<Integer> CheckerIntersection = new HashSet<Integer>();
				CheckerIntersection.add(30);
				
				//Test#2: intersection method NEGATIVE Test (NOTE: no need to check the intersection NEGATIVE test)
				t.checkExpect(Laila.intersection(Masom, Looloo), CheckerIntersection);
				
				//Let's create a random list for our reverse method test
				List<Integer> Shaykh = new ArrayList<Integer>();
				Shaykh.add(2); 
				Shaykh.add(4);
				Shaykh.add(6);
				Shaykh.add(8);
				Shaykh.add(10);
				Shaykh.add(20);
				
				//Now we'll create a checker list that is the above list reversed, desired list is what we want
				List<Integer> Hkyahs = new ArrayList<Integer>();
				Hkyahs.add(20);
				Hkyahs.add(10);
				Hkyahs.add(8);
				Hkyahs.add(6);
				Hkyahs.add(4);
				Hkyahs.add(2);
				
				//Test#3: reverse method POSITIVE Test (NOTE: again we do not need to check for NEGATIVE test)
				t.checkExpect(Laila.reverse(Shaykh), Hkyahs);
			}
	
		//For any other exceptions...
		catch (Exception e){
			
			e.printStackTrace();
			t.fail();
		}
	}
}
