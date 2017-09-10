//Masom Hamadeh
//CS3401 HW#7

package homework7;
import tester.*;

public class MyLinkedListTestMH {
	
	public static void main (String[] args){
		Tester.run (new MyLinkedListTestMH());
	}
	
	/*******************************************************************
	 * Create test methods here
	 *****************************************************************/
	public void testLinkList (Tester t){
		try{
			//create a test string of arrays
			String[] generic = {"Laila", "Masom", "Eia", "Samir", "Delilah", "Laila"};
			
			//construct two lists to test (including an empty one below)
			MyLinkedListI<String> Empty = new MyLinkedListI<String>();
			MyLinkedListI<String> Test1 = new MyLinkedListI<String>(generic);
			
		//NOTE: no need for a constructor negative test here
		//Getter POSITIVE testing
			//Test #1: getting the first element using getFirst()
			t.checkExpect(Test1.getFirst(), "Laila");
			
			//Test #2: getting the last element using getLast()
			t.checkExpect(Test1.getLast(), "Laila");
			
			//Test #3: getting an element at a specific index using get()
//you forgot that these lists begin at 0, so "Masom" is at index 1 not 2 
			t.checkExpect(Test1.get(1), "Masom");
			
			//Test #4: getting the first index of an element u sing indexOf()
//you forgot that these lists begin at 0, so "Eia" is at index 2 not 3
			t.checkExpect(Test1.indexOf("Eia"), 2);
			
			//Test #5: getting the last index of a certain element
//you forgot that these lists begin at 0, so the second "Laila" is at index 5 not 6
			t.checkExpect(Test1.lastIndexOf("Laila"), 5);
			
		//Getter NEGATIVE testing
			//Test #6: finding a NON existing element - lowest boundary
			try{
				Test1.get(-100);
				t.fail("Getter method did NOT throw proper lower bound IndexOutOfBoundsException!");
			}
			catch (IndexOutOfBoundsException e){
				t.success(); //getter method threw the proper exception
			}
			
			//Test #7: same test as above but for the highest boundary
			try{
				Test1.get(1000);
				t.fail("Getter method did NOT throw proper lower bound IndexOutOfBoundsException!");
			}
			catch (IndexOutOfBoundsException e){
				t.success(); //getter method threw the proper exception				
			}
			
			//Test #8: try to get the first index of an element that doesn't even exist
			t.checkExpect(Test1.indexOf("Mike"), -1);
			
			//Test #9: same as test #8 but this is for the last index of a non existing element
//this tests indexOf instead of lastIndexOf
			t.checkExpect(Test1.lastIndexOf("Ashley"), -1);
			
			//Now to test the empty MyLinkedList
			//Test #10: try to get the first element in an empty list
			t.checkExpect(Empty.getFirst(), null);
			
			//Test #11: same as test #10 but for the last element
			t.checkExpect(Empty.getLast(), null);

			
//This is the test halting your entire tester when it throws the unhandled OutOfBoundsException
		//Setter POSITIVE testing
//You can only set an existing index, so either Ashley needs to be set to 5 or lower, let's use 4 
			Test1.set(4, "Ashley"); //now lets set index 7 with Ashley to see if set method works
			//Test #12: POSITIVE test
			t.checkExpect(Test1.get(4), "Ashley");
			
		//Setter NEGATIVE testing
			//Test #13: lets start out with the lower boundary test
			try{
				Test1.set(-100, "Lowest");
				t.fail("Setter method did NOT throw proper low bound IndexOutOfBoundsException!");
			}
			catch (IndexOutOfBoundsException e){
				t.success(); //setter method threw the proper exception
			}
			
			//Test #14: now the highest boundary test
			try{
				Test1.set(1000, "Highest");
				t.fail("Setter method did NOT throw proper high bound IndexOutOfBoundsException!");
			}
			catch (IndexOutOfBoundsException e){
				t.success(); //setter method threw the proper exception
			}
		//ALL other method testing
			//Test #15: POSTIVE addFirst() test
			Test1.addFirst("Hadia");
			t.checkExpect(Test1.getFirst(), "Hadia");
			
			//Test #16: POSITIVE addLast() test
			Test1.addLast("Nadime");
			t.checkExpect(Test1.getLast(), "Nadime");
			
			//Test #17: POSITIVE add() test
			Test1.add(5, "David");
			t.checkExpect(Test1.get(6), "David");
			
			//Test #18: NEGATIVE add() test - LOWER boundary test
			try{
				Test1.add(-100, "Error");
				t.fail("Add method did NOT throw proper lower bound IndexOutOfBoundsException!");
			}
			catch (IndexOutOfBoundsException e){
				t.success(); //add method threw the proper exception
			}
			
			//Test #19: POSITIVE add() test - HIGHER boundary test
			Test1.add(1000, "Randa");
			t.checkExpect(Test1.getLast(), "Randa");
			
			//Test #20: POSITIVE removeFirst() test
			Test1.removeFirst();
			t.checkExpect(Test1.getFirst(), "Laila");
			
			//Test #21: NEGATIVE removeFirst() test (using the empty list)
			t.checkExpect(Empty.removeFirst(), null);
			
			//Test #22: POSITIVE removeLast() test
			Test1.removeLast();
			t.checkExpect(Test1.getLast(), "Nadime");
			
			//Test #23: NEGATIVE removeLast() test (Using the empty list)
			t.checkExpect(Empty.removeLast(), null);
			
			//Test #24: POSITIVE remove() test
			Test1.remove(3);
//you forgot that these lists begin at 0, so "Eia" is at index 2 not 3
			t.checkExpect(Test1.get(2), "Eia");
			
			//Test #25: NEGATIVE remove() test - LOWER boundary test
			try{
				Test1.remove(-100);
				t.fail("Remove method did NOT throw the proper lower bound IndexOutOfBoundsException!");
			}
			catch (IndexOutOfBoundsException e){
				t.success(); //remove method threw proper exception
			}
			
			//Test #26: NEGATIVE remove() test - HIGHER boundary test
			try{
				Test1.remove(1000);
				t.fail("Remove method did NOT throw the proper higher bound IndexOutOfBoundsException!");
			}
			catch (IndexOutOfBoundsException e){
				t.success(); //remove method threw the proper exception
			}
			
			//Test #27: POSITIVE contains() test (TRUE outcome)
			t.checkExpect(Test1.contains("Laila"), true);
			
			//Test #28: POSITIVE contains() test (FALSE outcome)
			t.checkExpect(Test1.contains("Eddie"), false);
			
			//Test #29: POSITIVE clear() test
			Test1.clear();
			t.checkExpect(Test1.size(), 0);
			
			//Test #30: POSITIVE toString() testing
			//NOTE: creating a new test list to check out toString()
			MyLinkedListI<Double> Test2 = new MyLinkedListI<Double>();
//there's a strange occurrence here
	//where the double is truncated to only one empty decimal point
	//simply adjust it to .0 or .12 on both inputs
			Test2.add(100.0);
			t.checkExpect(Test2.toString(), "[100.0]");
		}
		//Come here for all other unexpected/expected Exceptions
		catch (Exception e){
			e.printStackTrace();
			t.fail();
		}
	}
}
