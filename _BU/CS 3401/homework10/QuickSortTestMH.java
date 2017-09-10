//Masom Hamadeh
//CS3401 HW#10

package homework10;
import tester.*;

public class QuickSortTestMH{
	
	public static void main (String[] args){
		Tester.run (new QuickSortTestMH());
	}
	
	//IF needed, we can create other test methods here
	
	public void testQuickSort (Tester t){
		
		try{
			//create some arrays of strings to test - for comparable
			String[] a = {"A", "B", "C", "D", "E", "X", "Y", "Z"};
			String[] d = {"Z", "Y", "X", "E", "D", "C", "B", "A"};
			String[] ran = {"A", "Z", "B", "Y", "C", "X", "D", "E"};
			
			QuickSort.quickSort(d); //sort array and compare to already sorted array 
			t.checkExpect(a,d);
			
			QuickSort.quickSort(ran); //same as above for random
			t.checkExpect(a, ran);
			
			t.checkExpect(d,ran); //now test the two sorted arrays 
			
			QuickSort.quickSort(a);
			t.checkExpect(ran,a);
			t.checkExpect(d,a);
			//ABOVE - Test #5
			
			//create another array of strings to test
			String[] a2 = {"Ashley", "Becky", "Carl", "Laila", "Masom", "Randa", "Samir"}; //ascending
			String[] d2 = {"Samir", "Randa", "Masom", "Laila", "Carl", "Becky", "Ashley"}; //descending
						
			//without sorting the above areas, testing the two ordered methods
			t.checkExpect(QuickSort.ordered(a2), true);
			t.checkExpect(QuickSort.ordered(d2), false);
						
			t.checkExpect(QuickSort.ordered(a2,true), true); 
			t.checkExpect(QuickSort.ordered(d2,false), true); 
			
			QuickSort.quickSort(d2);
			t.checkExpect(a2, d2);
			t.checkExpect(QuickSort.ordered(d2,true), true);
			//ABOVE: Test #11
		}
		
		catch (Exception e){ //come here for all other exceptions
			e.printStackTrace();
			t.fail();			
		}
	}
}

