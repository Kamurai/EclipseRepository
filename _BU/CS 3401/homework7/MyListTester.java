package homework7;


import tester.Tester;

public class MyListTester 
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
			String[] Tim = {"Mary", "Jenny", "Beth", "Jessie", "Nikki"};
			
			
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
					//test 3
				t.checkExpect(Bob.get(1), "Jenny");
				
				//get first index of an element
					//test 4
				t.checkExpect(Bob.indexOf("Beth"), 2);
				
				//get last index of an element
					//test 5
				t.checkExpect(Bob.lastIndexOf("Jessie"), 3);
			
			// Getter Negative Tests (if any)
				//look for an non-existent index
					//test 6
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
				
				//get first index of an element that doesn't exist
					//test 7
				t.checkExpect(Bob.indexOf("Sheila"), -1);
				
				//get last index of an element that doesn't exist
					//test 8
				t.checkExpect(Bob.lastIndexOf("Evain"), -1);
				
				//get first element in an empty MyLinkedList
					//test 9
				t.checkExpect(Iz.getFirst(), null);
				
				//get last element in an empty MyLinkedList
					//test 10
				t.checkExpect(Iz.getLast(), null);
			
			// Setter methods Positive tests
				Bob.set(2, "Elaine");
				//test 11
				t.checkExpect(Bob.get(2), "Elaine");
			
			// Setter methods Negative Tests (if any)
				//test 12
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

			//All other method testing
			
			//addFirst method Positive Test
				Bob.addFirst("Fanny");
				//test 13
				t.checkExpect(Bob.getFirst(), "Fanny");
				
			//addLast method Positive Test
				Bob.addLast("Lonnie");
				//test 14
				t.checkExpect(Bob.getLast(), "Lonnie");
				
			//add method Positive Test
				Bob.add(3, "Mannie");
				//test 15
				t.checkExpect(Bob.get(4), "Mannie");
				
			//add method Negative Test
				//test 16
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
			//removeFirst method Positive Test
				Bob.removeFirst();
				//test 17
				t.checkExpect(Bob.getFirst(), "Mary");
				
			//removeFirst method Negative Test
				//remove first element of an empty MyLinkedList
					//test 18
				t.checkExpect(Iz.removeFirst(), null);
				
			//removeLast method Positive Test
				Bob.removeLast();
				//test 19
				t.checkExpect(Bob.getLast(), "Nikki");
				
			//removeLast method Negative Test
				//remove last element of an empty MyLinkedList
					//test 20
				t.checkExpect(Iz.removeLast(), null);
				
			//remove method Positive Test
				Bob.remove(2);
				//test 21
				t.checkExpect(Bob.get(2), "Elaine");
				
			//remove method Negative Test
				//test 22
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

			//contains Positive Test - true
				//test 23
				t.checkExpect(Bob.contains("Jenny"), true);
			//contains Positive Test - false
				//test 24
				t.checkExpect(Bob.contains("Tabitha"), false);
			
			//clear Positive Test	
				Bob.clear();
				//test 25
				t.checkExpect(Bob, Iz);
				/*try 
				{
					Bob.getFirst();
					t.fail("get did not throw NullPointerException");
				}
				catch (NullPointerException e) 
				{
					// get method correctly threw exception
					t.success();
				}*/
				
			//toString Positive Test
				MyList<Integer> Adam = new MyLinkedList<Integer>();
				Adam.add(911911911);
				Adam.add(123123123);
				
				//test 26
				t.checkExpect(Adam.toString(), "[911911911, 123123123]");

					
			}
		// Come here for any unexpected Exceptions
		catch (Exception e) 
		{
			e.printStackTrace();
			t.fail();
		}
	}

}
