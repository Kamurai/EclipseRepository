package homework9;

import tester.Tester;

public class BinaryTreeTester
{
	public static void main(String[] args) 
	{
		Tester.run(new BinaryTreeTester());
	}

	// /////////////////////////////////////////////////////////////////
	// Create test methods here
	// /////////////////////////////////////////////////////////////////
	public void testBook(Tester t) 
	{
		try 
		{
			Integer[] Tim = {50, 61, 38, 42, 59, 45, 44, 57, 58, 66};
		
			
			// Constructor
				//Construct an Empty BinaryTree
				BinaryTreeK<Integer> Iz = new BinaryTreeK<Integer>();

				//Construct an BinaryTree based on an array
				BinaryTree<Integer> Bob = new BinaryTree<Integer>(Tim);
				
			// Constructor Negative Test (if any)
				//none needed for this class
			
			// Getter Positive Tests (if any)
				//getSize
					//test 1
				t.checkExpect(Bob.getSize(), 10);
				//getRoot
					//test 2
				t.checkExpect(Bob.getRoot().element, 50);
				
			// Getter Negative Tests (if any)
				//none needed for this class
				
			// Setter methods Positive tests (if any)
				//none needed for this class
				
			// Setter methods Negative Tests (if any)
				//none needed for this class


			//All other method testing
			
			//search method Positive Test
				//test 3
				t.checkExpect(Bob.search(57), true);
				//test 4
				t.checkExpect(Bob.search(-5), false);
				
			//insert method Positive Test
				//test 5
				t.checkExpect(Bob.insert(27), true);
				//test 6
				t.checkExpect(Bob.insert(27), false);
				
			//delete method Positive Test
				//test 7
				t.checkExpect(Bob.delete(27), true);
				//test 8
				t.checkExpect(Bob.delete(27), false);
				//test 9
				t.checkExpect(Bob.search(27), false);
				
			//breadthFirst method
				//test 10
				t.checkExpect(Bob.breadthFirst(), "50,38,61,42,59,66,45,57,44,58");
			//countLeaves method				
				//test 11
				t.checkExpect(Bob.countLeaves(), 3);
				
				
			//clear method Positive Test
				Bob.clear();
				//test 12
				t.checkExpect(Bob, Iz);
				
				BinaryTree<Integer> Bum = new BinaryTree<Integer>(Tim);
				
				Bum.insert(27);
			//breadthFirst method
				//test 13
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,45,57,44,58");
			//countLeaves method				
				//test 14
				t.checkExpect(Bum.countLeaves(), 4);

				Bum.insert(10);
			//breadthFirst method
				//test 15
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,45,57,44,58");
			//countLeaves method				
				//test 16
				t.checkExpect(Bum.countLeaves(), 4);

				Bum.insert(29);
			//breadthFirst method
				//test 17
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,44,58");
			//countLeaves method				
				//test 18
				t.checkExpect(Bum.countLeaves(), 5);
				
				Bum.insert(46);
			//breadthFirst method
				//test 19
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,44,46,58");
			//countLeaves method				
				//test 20
				t.checkExpect(Bum.countLeaves(), 6);

				Bum.insert(56);
			//breadthFirst method
				//test 21
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,44,46,56,58");
			//countLeaves method				
				//test 22
				t.checkExpect(Bum.countLeaves(), 7);

				Bum.insert(63);
			//breadthFirst method
				//test 23
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,63,44,46,56,58");
			//countLeaves method				
				//test 24
				t.checkExpect(Bum.countLeaves(), 7);

				Bum.insert(68);
			//breadthFirst method
				//test 25
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,63,68,44,46,56,58");
			//countLeaves method				
				//test 26
				t.checkExpect(Bum.countLeaves(), 8);

				Bum.insert(9);
			//breadthFirst method
				//test 27
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,63,68,9,44,46,56,58");
			//countLeaves method				
				//test 28
				t.checkExpect(Bum.countLeaves(), 8);

				Bum.insert(11);
			//breadthFirst method
				//test 29
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,63,68,9,11,44,46,56,58");
			//countLeaves method				
				//test 30
				t.checkExpect(Bum.countLeaves(), 9);

				Bum.insert(28);
			//breadthFirst method
				//test 31
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,63,68,9,11,28,44,46,56,58");
			//countLeaves method				
				//test 32
				t.checkExpect(Bum.countLeaves(), 9);

				Bum.insert(64);
			//breadthFirst method
				//test 33
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,63,68,9,11,28,44,46,56,58,64");
			//countLeaves method				
				//test 34
				t.checkExpect(Bum.countLeaves(), 9);

				Bum.insert(62);
			//breadthFirst method
				//test 35
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,63,68,9,11,28,44,46,56,58,62,64");
			//countLeaves method				
				//test 36
				t.checkExpect(Bum.countLeaves(), 10);

				Bum.insert(69);
			//breadthFirst method
				//test 37
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,63,68,9,11,28,44,46,56,58,62,64,69");
			//countLeaves method				
				//test 38
				t.checkExpect(Bum.countLeaves(), 10);

				Bum.insert(67);
			//breadthFirst method
				//test 39
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,63,68,9,11,28,44,46,56,58,62,64,67,69");
			//countLeaves method				
				//test 40
				t.checkExpect(Bum.countLeaves(), 11);

				Bum.insert(30);
			//breadthFirst method
				//test 41
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,63,68,9,11,28,30,44,46,56,58,62,64,67,69");
			//countLeaves method				
				//test 42
				t.checkExpect(Bum.countLeaves(), 12);
				
				
			//breadthFirst method
				//test 43
				t.checkExpect(Bum.breadthFirst(), "50,38,61,27,42,59,66,10,29,45,57,63,68,9,11,28,30,44,46,56,58,62,64,67,69");
			//countLeaves method				
				//test 44
				t.checkExpect(Bum.countLeaves(), 12);
			
			//empty BinaryTree breadthFirst method
				//test 45
				t.checkExpect(Bob.breadthFirst(), "");
			
			//empty BinaryTree countLeaves method
				//test 46
				t.checkExpect(Bob.countLeaves(), 0);
			
				
					
			}
		// Come here for any unexpected Exceptions
		catch (Exception e) 
		{
			e.printStackTrace();
			t.fail();
		}
		
			
	}
	
}
