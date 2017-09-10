package homework10;

/*
Change the attached QuickSort program to sort Comparable data.
Also write the ordered methods described in the attached 
specification. Write a test program that thoroughly tests 
these 3 methods. Be sure to include all of the necessary 
positive & negative tests. After exchanging test programs 
with another student, follow the instructions for submitting 
an Eclipse program.

*/

public class QuickSort
{
  public static <E extends Comparable<E>> void quickSort(E[] list) {
    quickSort(list, 0, list.length - 1);
  }

  private static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }

  /** Partition the array list[first..last] */
  private static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
    E pivot = list[first]; // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search

    while (high > low) {
      // Search forward from left
      while (low <= high && list[low].compareTo(pivot) <= 0)
        low++;

      // Search backward from right
      while (low <= high && list[high].compareTo(pivot) > 0)
        high--;

      // Swap two elements in the list
      if (high > low) {
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high].compareTo(pivot) >= 0)
      high--;

    // Swap pivot with list[high]
    if (list[high].compareTo(pivot) < 0) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }


 
  
  //ordered
  public static <E extends Comparable<E>> boolean ordered(E[] list)
  {
	   
  /*
  Type Parameters:
  E - Type of data items in the array
  Parameters:
  list - array of data items that are Comparable 
  */
	
	  //Determine if the items in an array are in ascending order 
  
	  for(int x = 0; x < list.length; x++)
	  {
		  //if one is larger than the next, then the array is not in ascending order
		  if( x != list.length-1 && list[x].compareTo(list[x+1]) > 0 )
		  {
			  return false;
		  }
	  }
	  
  //Returns:
  //True if the items are properly ordered; false otherwise
	  return true;
  }
  
  //ordered
  public static <E extends Comparable<E>> boolean ordered(E[] list, boolean ascending)
  {
	  /*
		Type Parameters:
		E - Type of data items in the array
		Parameters:
		list - array of data items that are Comparable
		ascending - true if the array should be in ascending order; false if the array should be in descending order
	   */
	  
	  //Determine if the items in an array are properly ordered 
  
	  if(ascending == true)
	  {
		//Determine if the items in an array are in ascending order 
		  return ordered(list);
	  }
	  else
	  {
		//Determine if the items in an array are in descending order 
		for(int x = 0; x < list.length; x++)
		{
		  	//if one is less than the next, then the array is not in descending order
		  	if( x != list.length-1 && list[x].compareTo(list[x+1]) < 0 )
		  	{
			  	return false;
		  	}
	  	}
	  }
	  
  //Returns:
  //True if the items are properly ordered; false otherwise
	  return true;
  }
  
  
}
