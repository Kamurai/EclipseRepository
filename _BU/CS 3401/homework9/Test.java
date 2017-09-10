package homework9;
import tester.*;

public class Test {

	public static void main(String[] args){
		Tester.run(new Test());
	}
	
	public void testMyTree(Tester t) {
		try {
			
			Integer[] num = {5, 6, 2, 3, 0, 13, 7};	 
			
			BinaryTree<String> strings = new BinaryTree<String>();
			BinaryTree<Integer> numbers = new BinaryTree<Integer>(num);
			//tree => parent (5), second generation (2,6), third generation (0, 3, 13), fourth generation (7)
			
			//test 1
			//t.checkExpect(strings.breadthFirst(), null);
			//test 2
			//t.checkExpect(strings.countLeaves(), 0);
			
			strings.insert("Chinny");
			//test 3
			t.checkExpect(strings.countLeaves(), 1);
			//test 4
			t.checkExpect(numbers.breadthFirst(), "5,2,6,0,3,13,7");
			//test 5
			t.checkExpect(numbers.countLeaves(), 3);
			
//Come here for any unexpected Exceptions
		}
		catch (Exception e) {
			e.printStackTrace();
			t.fail();
		}
	}
}
