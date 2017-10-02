//Chinny Vixathrep
package homework10;
import tester.*;

public class Test {

	public static void main(String[] args){
		Tester.run(new Test());
	}
	
	public void testQuickSort(Tester t) {
		try {
		
			String[] list1 = {"0", "10", "20", "30", "20", "10", "0"};
			String[] list2 = {"0", "0", "10", "10", "20", "20", "30"};
			String[] list3 = {"5", "4", "3", "2", "1", "0"};
			
			//Test 1: quickSort, positive
			QuickSort.quickSort(list1);
			t.checkExpect(list1, list2);
			
			//Test 2-3: ordered(param), positive
			t.checkExpect(QuickSort.ordered(list2), true);
			t.checkExpect(QuickSort.ordered(list3), false);
			
			//Test 4-7: ordered(param1, param2), positive
			t.checkExpect(QuickSort.ordered(list2, true), true);		//ascending list, ascending parameter
			t.checkExpect(QuickSort.ordered(list2, false), false);		//ascending list, descending parameter
			t.checkExpect(QuickSort.ordered(list3, true), false);		//descending list, ascending parameter
			t.checkExpect(QuickSort.ordered(list3, false), true);		//descending list, descending parameter
			
			//no negative tests
			
	//Come here for any unexpected Exceptions
		}
		catch (Exception e) {
			e.printStackTrace();
			t.fail();
		}
	}
}
