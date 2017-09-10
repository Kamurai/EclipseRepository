package homework8;


import tester.Tester;

public class MyLinkedListTester 
{
	public static void main(String[] args) 
	{
		Tester.run(new MyLinkedListTester());
	}

	// /////////////////////////////////////////////////////////////////
	// Create test methods here
	// /////////////////////////////////////////////////////////////////
	public void testBook(Tester t) 
	{
		try 
		{
			String[] Tim = {"Mary", "Jenny", "Jessie", "Lauren", "Laurel", "Laurie", "Jessie", "Ashley", "Adrianne", "Nikki"};
			
			
			// Constructor
				//Construct an Empty MyLinkedList
				MyLinkedList<String> Iz = new MyLinkedList<String>();
				
				//Construct an MyLinkedList based on an array
				MyLinkedList<String> Bob = new MyLinkedList<String>(Tim);
				
			// Constructor Negative Test
				//none needed for this class
			
			// Getter Positive Tests (if any)
				//get first element
					//test 1
				t.checkExpect(Bob.getFirst(), "Mary");
				//get last element
					//test 2
				t.checkExpect(Bob.getLast(), "Nikki");
				//get element at an index
				//test below midpoint
					//test 3
				t.checkExpect(Bob.get(2), "Jessie");
				//get element at an index
				//test below midpoint
					//test 4
				t.checkExpect(Bob.get(7), "Ashley");
				//get first index of an element
					//test 5
				t.checkExpect(Bob.indexOf("Jessie"), 2);
				//get last index of an element
					//test 6
				t.checkExpect(Bob.lastIndexOf("Jessie"), 6);
			// Getter Negative Tests (if any)
				//look for an non-existent index, low bound
					//test 7
				try 
				{
					Bob.get(-1);
					t.fail("get did not throw IndexOutOfBoundsException");
				}
				catch (IndexOutOfBoundsException e) 
				{
					// get method correctly threw exception
					t.success();
				}
				
				//look for an non-existent index, high bound
					//test 8
				try 
				{
					Bob.get(100);
					t.fail("get did not throw IndexOutOfBoundsException");
				}
				catch (IndexOutOfBoundsException e) 
				{
					// get method correctly threw exception
					t.success();
				}
				
				
				//get first index of an element that doesn't exist
					//test 9
				t.checkExpect(Bob.indexOf("Sheila"), -1);
				
				//get last index of an element that doesn't exist
					//test 10
				t.checkExpect(Bob.lastIndexOf("Evain"), -1);
				
				//get first element in an empty MyLinkedList
					//test 11
				t.checkExpect(Iz.getFirst(), null);
				
				//get last element in an empty MyLinkedList
					//test 12
				t.checkExpect(Iz.getLast(), null);
				
			// Setter methods Positive tests
				Bob.set(3, "Elaine");
				//set low (below midpoint)
					//test 13
				t.checkExpect(Bob.get(3), "Elaine");
				
				Bob.set(8, "Tobi");
				//set high (above midpoint)
					//test 14
				t.checkExpect(Bob.get(8), "Tobi");
				
			// Setter methods Negative Tests (if any)
				//low bound
					//test 15
				try 
				{
					Bob.set(-1, "Tabitha");
					t.fail("get did not throw IndexOutOfBoundsException");
				}
				catch (IndexOutOfBoundsException e) 
				{
					// get method correctly threw exception
					t.success();
				}
				
				//high bound
					//test 16
				try 
				{
					Bob.set(100, "Tabitha");
					t.fail("get did not throw IndexOutOfBoundsException");
				}
				catch (IndexOutOfBoundsException e) 
				{
					// get method correctly threw exception
					t.success();
				}


			//All other method testing
			
			//addFirst method Positive Test
				Bob.addFirst("Fanny");
				//test 17
				t.checkExpect(Bob.getFirst(), "Fanny");
				
			//addLast method Positive Test
				Bob.addLast("Lonnie");
				//test 18
				t.checkExpect(Bob.getLast(), "Lonnie");
				
			//add method Positive Test
				Bob.add(3, "Mannie");
				//test below midpoint
				//test 19
				t.checkExpect(Bob.get(4), "Mannie");
				
				Bob.add(7, "Lorie");
				//test above midpoint
				//test 20
				t.checkExpect(Bob.get(8), "Lorie");
				
			//add method Negative Test low bound
				//test 21
				try 
				{
					Bob.add(-1, "Tabitha");
					t.fail("get did not throw IndexOutOfBoundsException");
				}
				catch (IndexOutOfBoundsException e) 
				{
					// get method correctly threw exception
					t.success();
				}
				
			//add method Positive Test, high bound
				Bob.add(100, "Claire");
				//test 22
				t.checkExpect(Bob.getLast(), "Claire");
				
			//removeFirst method Positive Test
				Bob.removeFirst();
				//test 23
				t.checkExpect(Bob.getFirst(), "Mary");
				
			//removeFirst method Negative Test
				//remove first element of an empty MyLinkedList
					//test 24
				t.checkExpect(Iz.removeFirst(), null);
				
			//removeLast method Positive Test
				Bob.removeLast();
				//test 25
				t.checkExpect(Bob.getLast(), "Lonnie");
				
			//removeLast method Negative Test
				//remove last element of an empty MyLinkedList
					//test 26
				t.checkExpect(Iz.removeLast(), null);
				
			//remove method Positive Test
				Bob.remove(1);
				//test below midpoint
					//test 27
				t.checkExpect(Bob.get(2), "Mannie");
				
				Bob.remove(4);
				//test above midpoint
					//test 28
				t.checkExpect(Bob.get(5), "Lorie");
				
			//remove method Negative Test low bound
				//test 29
				try 
				{
					Bob.remove(-1);
					t.fail("get did not throw IndexOutOfBoundsException");
				}
				catch (IndexOutOfBoundsException e) 
				{
					// get method correctly threw exception
					t.success();
				}

			//remove method Negative Test high bound
				//test 30
				try 
				{
					Bob.remove(100);
					t.fail("get did not throw IndexOutOfBoundsException");
				}
				catch (IndexOutOfBoundsException e) 
				{
					// get method correctly threw exception
					t.success();
				}

				
			//contains Positive Test - true
				//test 31
				t.checkExpect(Bob.contains("Jenny"), true);
			//contains Positive Test - false
				//test 32
				t.checkExpect(Bob.contains("Tabitha"), false);
			
				
				
			//clear Positive Test	
				Bob.clear();
				//test 33
				t.checkExpect(Bob, Iz);
				
			//toString Positive Test
				MyLinkedList<Integer> Adam = new MyLinkedList<Integer>();
				Adam.add(911911911);
				Adam.add(123123123);
				Adam.add(411411411);
				Adam.add(456456456);
				
				//test 34
				t.checkExpect(Adam.toString(), "[911911911, 123123123, 411411411, 456456456]");

				
				
					
			}
		// Come here for any unexpected Exceptions
		catch (Exception e) 
		{
			e.printStackTrace();
			t.fail();
		}
		
			
	}

	
	
}
