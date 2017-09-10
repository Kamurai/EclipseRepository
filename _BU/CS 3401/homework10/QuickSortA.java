package homework10;




public class QuickSortA {
	/**
	 * Use quicksort to sort an array
	 * @param <E> Type of the data being sorted
	 * @param list Array of data items which are Comparable
	 */
	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length - 1);
	}

	private static <E extends Comparable<E>> void quickSort(E[] list,
			int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	/** Partition the array list[first..last] */
	private static <E extends Comparable<E>> int partition(E[] list, int first,
			int last) {
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
		if (pivot.compareTo(list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}
	/**
	 * Determine if the items in an array are in ascending order
	 * @param <E> Type of data items in the array
	 * @param list array of data items that are Comparable
	 * @return True if the items are properly ordered; false otherwise
	 */
	public static <E extends Comparable<E>>boolean ordered(E[] list) {
		return ordered(list,true);
	}
	/**
	 * Determine if the items in an array are properly ordered
	 * @param <E> Type of data items in the array
	 * @param list array of data items that are Comparable
	 * @param ascending true if the array should be in ascending order; 
	 * false if the array should be in descending order
	 * @return True if the items are properly ordered; false otherwise
	 */
	public static <E extends Comparable<E>>boolean ordered(E[] list, boolean ascending) {
		int factor = ascending ? 1 : -1;
		for (int i=1; i< list.length; i++) {
			if ((list[i].compareTo(list[i-1]))*factor<0)
				return false;
		}
		return true;
	}

}
