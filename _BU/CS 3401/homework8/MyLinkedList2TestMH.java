//Masom Hamadeh
//CS3401 HW#8

package homework8;
import tester.*;

public class MyLinkedList2TestMH {
	
	public static void main (String[] args){
		Tester.run (new MyLinkedList2TestMH());
	}
		/*******************************************************************
		 * Create test methods here
		 *****************************************************************/
		public void testLinkList (Tester t){
			/**I worked on hw7 for along time so I took my work and adapted all
			 * the testing into here.  However, with homework 8 I tweaked the 
			 * private locate method in MyLinkedList.java and I ran a couple
			 * more tests.
			 */
			try{
				//create a test string of arrays
				//for me to see:  {   0   |    1    |  2  |    3   |    4     |   5    |   6   |    7    |   8    |    9   }
				String[] family = {"Laila", "Masom", "Eia", "Samir", "Delilah", "Laila", "Raffi", "Thame", "Rania", "Nazih"};
							
				//construct two lists to test (including an empty one below)
				MyLinkedList<String> Empty = new MyLinkedList<String>();
				MyLinkedList<String> Test1 = new MyLinkedList<String>(family);
							
			//NOTE: no need for a constructor negative test here
			
			//Getter POSITIVE testing
				//Test #1: getting the first element using getFirst()
				t.checkExpect(Test1.getFirst(), "Laila");
				
				//Test #2: getting the last element using getLast()
				t.checkExpect(Test1.getLast(), "Nazih");
				
				//Test #3: getting an element at a specific index using get()
					//Test 3A: testing below the midpoint
					t.checkExpect(Test1.get(1), "Masom");
					//Test 3B: testing above the midpoint
					t.checkExpect(Test1.get(7), "Thame");
				
				//Test #4: getting the first index of an element u sing indexOf()
				t.checkExpect(Test1.indexOf("Samir"), 3);
				
				//Test #5: getting the last index of a certain element
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
				t.checkExpect(Test1.lastIndexOf("Ashley"), -1);
				
				//Now to test the empty MyLinkedList
				//Test #10: try to get the first element in an empty list
				t.checkExpect(Empty.getFirst(), null);
				
				//Test #11: same as test #10 but for the last element
				t.checkExpect(Empty.getLast(), null);

			//Setter POSITIVE testing
			//Test #12: POSITIVE test
					//Test 12A: set test LOWER than midpoint
					Test1.set(3, "Maya"); 
					t.checkExpect(Test1.get(3), "Maya");
					//Test 12B: set test HIGHER than midpoint
					Test1.set(6, "Jasmyn"); 
					t.checkExpect(Test1.get(6), "Jasmyn");
					
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
					//Test 17A: add test HIGHER than midpoint
					Test1.add(6, "David");
					t.checkExpect(Test1.get(7), "David");
					//Test 17B: add test LOWER than midpoint
					Test1.add(2, "Kayla");
					t.checkExpect(Test1.get(3), "Kayla");
				
				//Test #18: NEGATIVE add() test - LOWER boundary test
				try{
					Test1.add(-1, "Error");
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
					//Test 24A: remove test LOWER than midpoint
					Test1.remove(1);
					t.checkExpect(Test1.get(2), "Eia");
					//Test 24B: remove test HIGHER than midpoint
					Test1.remove(6);
					t.checkExpect(Test1.get(7), "Thame");
				
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
				MyLinkedList<Double> Test2 = new MyLinkedList<Double>();
				Test2.add(100.12);
				Test2.add(200.23);
				Test2.add(300.34);
				Test2.add(23.23);
				t.checkExpect(Test2.toString(), "[100.12, 200.23, 300.34, 23.23]");
			}
			//Come here for all other unexpected/expected Exceptions
			catch (Exception e){
				e.printStackTrace();
				t.fail();
			}
		}
	}
