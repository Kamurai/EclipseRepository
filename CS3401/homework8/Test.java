
package homework8;
import tester.*;

public class Test {

	public static void main(String[] args){
		Tester.run(new Test());
	}
	
	public void testMyLinkedList(Tester t){
		try{
			
			Integer[] num = {1, 2, 3, 4};
	//########### TESTS##########
	//Constructor (no tests)
			MyLinkedList<String> list = new MyLinkedList<String>();
			MyLinkedList<Integer> numbers = new MyLinkedList<Integer>(num);
			
	//add & get & remove
			//1- NEGATIVE, test negative boundary
			try{
				list.add(-10, "Chinny");
				t.fail("MyLinkedList.add did not throw an exception for a non-existing index");
			}
			catch(IndexOutOfBoundsException e){
				t.success();	//exception handled
			}
		
			try{
			//2- POSITIVE, test first element
				numbers.add(0, 0);
				t.checkExpect(numbers.get(0), 0);
			//3- POSITIVE, test last element
				numbers.add(numbers.size(), 5);
				t.checkExpect(numbers.get(5), 5);
			//4- POSITIVE, test a middle index
				numbers.add(2,100);		//places number after index 2 thereby becoming index 3
				t.checkExpect(numbers.get(3), 100);
				numbers.remove(2);						//t5, removing at this juncture to maintain continuity in testing numbers
				t.checkExpect(numbers.get(3), 3);
			}
			catch(Exception e){		//gets ALL exceptions
				t.fail("An error occured during a positive test.");	
			}
			
		
	//getFirst & getLast on null list
			//6,7- POSITIVE, test emtpy lists
			t.checkExpect(list.getFirst(), null);		//t6
			t.checkExpect(list.getLast(), null);		//t7
			
	//addFirst & getFirst & get & removeFirst
		
			try{
				list.addFirst("a");			
				t.checkExpect(list.getFirst(), "a");				//t8
				list.clear();
				list.removeFirst();
				t.checkExpect(list.removeFirst(), null);				//t9, removeFirst for empty list
			
				numbers.addFirst(999);
				t.checkExpect(numbers.getFirst(), 999);				//t10
				t.checkExpect(numbers.getFirst(), numbers.get(0));	//t11, getFirst and get(0) works in conjuction*/
				t.checkExpect(numbers.removeFirst(), 999);			//t12, removeLast for a nonempty list
			}
			catch(Exception e){
				t.fail("An error occured during a positive test.");
			}			
			
	//addLast & getLast & get & removeLast
			try{
				//- POSITIVE, test empty list
				list.clear();
				list.addLast("a");
				t.checkExpect(list.getLast(), "a");					//t13
				t.checkExpect(list.get(list.size-1), "a");			//t14, get(size-1) and getLast works in conjunction
			
				//- POSITIVE, test another list
				numbers.addLast(6);
				t.checkExpect(numbers.getLast(), 6);				//t15
				t.checkExpect(numbers.removeLast(), 6);				//t16
			}
			catch(Exception e){
				t.fail("An error occured during a positive test.");
			}
			
	//get NEGATIVE bounday testing
			try{
				//negative index
				list.get(-10);
				t.fail("A negative index was processed.");
			}
			catch(IndexOutOfBoundsException e){
				t.success(); //exception handled					//t17
			}
			
			try{
				//index greater than size
				list.get(list.size);
				t.fail("An index beyond the size of list was processed.");
			}
			catch(IndexOutOfBoundsException e){
				t.success(); //exception handled					//t18
			}
	
	//contains
		//- POSITIVE, test any list for true
			t.checkExpect(numbers.contains(1), true);				//t19
		//- POSITIVE, test any list for false
			t.checkExpect(numbers.contains(1110), false);			//t20
			
	//indexOf
		//- POSITIVE, test any list for present
			t.checkExpect(numbers.indexOf(0), 0);					//t21
		//- POSITIVE, test any list for absent
			t.checkExpect(numbers.indexOf(50), -1);					//t22
			
	//lastIndexOf
		//- POSITIVE, test any list for present
			t.checkExpect(numbers.lastIndexOf(2), 2);				//t23
		//- POSITIVE, test any list for absent
			t.checkExpect(numbers.lastIndexOf(10000), -1);			//t24
			
	//remove
		//- NEGATIVE, test negative boundary
			try{
				numbers.remove(-8);
				t.fail("index is out of bounds.");
			}
			catch(IndexOutOfBoundsException e){
				t.success(); //exception handled					//t25
			}
		//- NEGATIVE, test index >= size boundary
			try{
				numbers.remove(100);
				t.fail("index is out of bounds.");
			}
			catch(IndexOutOfBoundsException e){	
				t.success();	//exception handled					//t26
			}
		//- POSITIVE, test index =0
			t.checkExpect(numbers.remove(0), 0);					//t27
			numbers.add(0, 0);			//put back in list for sake of continuity
		//- POSITIVE, test index = size -1
			t.checkExpect(numbers.remove(numbers.size()-1), 5);		//t28
		//- POSITIVE, test a middle index
			t.checkExpect(numbers.remove(2), 2);					//t29
			numbers.add(1, 2);			//put back in for sake of continuity, method verified in test 4

	//removeLast
		//- test empty list
			list.clear();
			t.checkExpect(list.removeLast(), null);					//t30
		//- test list with 1 element
			list.add("a");
			t.checkExpect(list.removeLast(), "a");					//t31
		//- test another list
			t.checkExpect(numbers.removeLast(), 4);					//t32
	//set
		//- NEGATIVE, test negative boundary
			try{
				list.set(-5,"a");
				t.fail("index is out of bounds. test should have failed.");		
			}
			catch(IndexOutOfBoundsException e){
				t.success();		//exception handled				//t33
			}
		//- NEGATIVE, test index >=size boundary
			try{
				list.set(list.size(), "1");
				t.fail("index is out of bounds, test should have failed.");
			}
			catch(IndexOutOfBoundsException e){
				t.success();		//exception handled				//t34
			}
		//- POSITIVE, test any list
			t.checkExpect(numbers.set(0, 100), numbers.getFirst());	//t35
			
	//toString
			//- POSITIVE, test any list
			list.clear();
			list.add("my");
			list.add("linked");
			list.add("list");
			t.checkExpect(list.toString(), "[my, linked, list]");	//t36
			
	//clear - POSITIVE, test any list
			numbers.clear();
			t.checkExpect(numbers, new MyLinkedList<Integer>());	//t37
			
//Come here for any unexpected Exceptions
		}
		catch (Exception e) {
			e.printStackTrace();
			t.fail();
		}
	}
}
