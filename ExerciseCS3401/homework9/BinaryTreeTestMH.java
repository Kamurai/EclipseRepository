package homework9;

//Masom Hamadeh
//CS3401 HW#9

import tester.Tester;

/*Both of my classmates have told me that I have way too many comments in my tester
 * and its really hard for them to see what I'm trying to do if it doesn't pass on their
 * computers.  So I'm trying to tone it down a bit.
 */

public class BinaryTreeTestMH{
	
	public static void main(String[] args){
		Tester.run(new BinaryTreeTestMH());
	}
	public void testBook(Tester t)	{
		try{
			Double[] generic = {10.0,20.0,15.0,30.0,25.0,40.0,35.0,50.0,45.00};
			
			//contruct two binarytrees, one empty and one using the array of doubles above
			BinaryTree<Double> empty = new BinaryTree<Double>();
			BinaryTree<Double> test1 = new BinaryTree<Double>(generic);
						
			//No needed negative contructor tests for this class
			
			//GETTER Positive tests - NO NEGATIVE tests needed
			t.checkExpect(test1.getSize(), 9);
			t.checkExpect(test1.getRoot().element, 10.00);
			
			//No positive or negative SETTER tests needed for this class
			
			//ALL other method testing - starting with search method
			t.checkExpect(test1.search(15.00), true);
			t.checkExpect(test1.search(80.00), false);
			t.checkExpect(test1.search(10.15), false);
			
			t.checkExpect(test1.insert(17.23), true);
			t.checkExpect(test1.insert(17.23), false);
			t.checkExpect(test1.insert(17.23), false); //insert method working, tried to insert twice..but already inserted
			
			t.checkExpect(test1.delete(17.23), true);
			t.checkExpect(test1.delete(17.23), false);
			t.checkExpect(test1.insert(17.23), true); //deleted 17.23 then tried to delete again...then inserted one more time for next test
						
			//breadthFirst() and countLeaves() preliminary testing
			t.checkExpect(test1.breadthFirst(), "10.0,20.0,15.0,30.0,17.23,25.0,40.0,35.0,50.0,45.0");
			test1.delete(17.23);
			t.checkExpect(test1.breadthFirst(), "10.0,20.0,15.0,30.0,25.0,40.0,35.0,50.0,45.0");
			t.checkExpect(test1.countLeaves(), 4);
			test1.insert(80.0);
			t.checkExpect(test1.countLeaves(), 5);
			test1.delete(80.0);
			
			//some other testing...
			t.checkExpect(empty.size, 0);
			test1.clear();
			t.checkExpect(test1, empty); //clear method works fine
			
			//New test2 binaryTree to test
			BinaryTree<Double> test2 = new BinaryTree<Double>(generic);
			
			test2.insert(33.3);
			t.checkExpect(test2.breadthFirst(), "10.0,20.0,15.0,30.0,25.0,40.0,35.0,50.0,33.3,45.0");
			t.checkExpect(test2.countLeaves(), 4);
			
			
			test2.insert(44.4);
			test2.insert(55.5);
			t.checkExpect(test2.breadthFirst(), "10.0,20.0,15.0,30.0,25.0,40.0,35.0,50.0,33.3,45.0,55.5,44.4");
			t.checkExpect(test2.countLeaves(), 5);
			
			//multiple method testing together
			test2.insert(111.1);
			test2.insert(222.2);
			test2.insert(0.11);
			t.checkExpect(test2.breadthFirst(), "10.0,0.11,20.0,15.0,30.0,25.0,40.0,35.0,50.0,33.3,45.0,55.5,44.4,111.1,222.2");
			t.checkExpect(test2.countLeaves(), 6);
			t.checkExpect(test2.getSize(), 15);
			t.checkExpect(test2.getRoot().element, 10.00);
			t.checkExpect(test2.search(10.15), false);
			t.checkExpect(test2.search(111.1), true);
						
			test2.delete(0.11);
			test2.delete(111.1);
			t.checkExpect(test2.search(111.1), false);
			t.checkExpect(test2.search(0.11), false);
			t.checkExpect(test2.search(55.5), true);
			t.checkExpect(test2.breadthFirst(), "10.0,20.0,15.0,30.0,25.0,40.0,35.0,50.0,33.3,45.0,55.5,44.4,222.2");
			t.checkExpect(test2.countLeaves(), 5);
			t.checkExpect(test2.getSize(), 13);
			t.checkExpect(test2.getRoot().element, 10.00);
			
			//now for some empty tree tests
			t.checkExpect(empty.breadthFirst(), "");
			t.checkExpect(test1.breadthFirst(), "");
			t.checkExpect(empty.countLeaves(), 0);
			t.checkExpect(test1.countLeaves(), 0);
			
			test2.clear();
			t.checkExpect(test2.breadthFirst(), "");
			t.checkExpect(test2.countLeaves(), 0);			
			}
		catch (Exception e){
			e.printStackTrace();
			t.fail();
		}
	}
}