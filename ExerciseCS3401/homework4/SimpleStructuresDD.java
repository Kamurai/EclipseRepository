package homework4;

import java.util.*;

public class SimpleStructuresDD<T> {
	/**
	 * creates the union of two Sets
	 * 
	 * @param firstSet
	 *            - first Set
	 * @param otherSet
	 *            - second Set
	 * @return a new Set that contains elements that are in either input Set
	 */
	public Set<T> union(Set<T> firstSet, Set<T> otherSet) {
		Set<T> newSet = new HashSet<T>(firstSet);
		for (T item : otherSet) {
			if (!firstSet.contains(item))
				newSet.add(item);
		}
		return newSet;

	}

	/**
	 * creates the intersection of two Sets
	 * 
	 * @param firstSet
	 *            - first Set
	 * @param otherSet
	 *            - second Set
	 * @return a new Set that contains elements that are in both input sets
	 */

	public Set<T> intersection(Set<T> firstSet, Set<T> otherSet) {
		Set<T> intersectSet = new HashSet<T>(firstSet);
		for (T item : otherSet) {
			if (firstSet.contains(item))
				intersectSet.add(item);
		}
		return intersectSet;

	}

	/**
	 * reverses a List
	 * 
	 * @param theList
	 *            - the List
	 * @return a new list that is in reverse order from the original
	 */
	/**public List<T> reverse(List<T> theList) {
		LinkedList<T> returnList = new LinkedList<T>(theList);
		for (T item : theList) {
		returnList.addFirst(removeFirst.theList());
		}
		return returnList;
		*/
    public List<T> reverse(List<T> theList) {
		  LinkedList<T> returnList = new LinkedList<T>(theList);
		  int listSize = theList.size();
		  int j = listSize; 
		  for (int i = listSize; i > 0; i--) { 
			  //theList(j-1) should be .get(j-1)
		  returnList.addFirst(theList.get(j-1));
		  
		  } return returnList;
		 
	}
}
