//Masom Hamadeh
//CS3401
//Homework #4

package homework4;
import java.util.*;

public class SimpleStructuresH<T> extends Object {
	
	public SimpleStructuresH(){ //empty contructor
		}
	
	/***********************************************************************
	 UNION method: will create/return the union of two sets 
	Returns: a new set that contains elements that are in either input set*/
	public Set<T> union (Set<T> firstSet, Set<T> otherSet){
		
		//We know that if we add the firstSet to otherSet we get the unionSet
		Set<T> unionSet = new HashSet<T>(); //declaration
		
		Iterator<T> iterator = firstSet.iterator(); //created a variable that points to firstSet
		
		//we need to go through the first set and add as long as there is more data in set, it will add it to the unionSet
		while(iterator.hasNext())
		{			
			unionSet.add(iterator.next());
		}
		
		iterator = otherSet.iterator(); //now we change the variable that points to otherSet
		
		//rinse and repeat as shown above - this time we'll be adding the data in otherSet to unionSet
		while(iterator.hasNext())
		{			
			unionSet.add(iterator.next());
		}
		
		//If both of the sets are empty then of course the unionSet will also be empty, thus returning an empty set
		return unionSet;
	}
	
	/***********************************************************************
	INTERSECTION method: will create/return the intersection of the two sets
	Returns: a new set that contains elemetns that are in BOTH input sets*/
	public Set <T> intersection (Set<T> firstSet, Set<T> otherSet){
		
		//We know that the intersection of the two sets contain data items that are located in BOTH sets
		Set<T> intersectionSet = new HashSet<T>(); //declaration
		
		//Converts the parameter sets into ArrayList so we can walkthrough the list as we compare them
		List<T> firstList = new ArrayList<T>(firstSet);
		List<T> otherList = new ArrayList<T>(otherSet);
		
		//Now we can use a for loop to check and see if the firstSet's element(s) is also in otherSet
		for (int x=0; x < firstList.size(); x++)
		{ 
			for (int y=0; y < otherList.size(); y++)
			{
				if (firstList.get(x) == otherList.get(y))
				{
					intersectionSet.add(firstList.get(x));
				}
			}
		}
		
		//if there aren't any matches then the returned intersectionSet will be empty
		return intersectionSet;
	}
	
	/***********************************************************************
	REVERSE method: will take an input set and reverse the order of data
	Returns: a new list that is in reverse order of original */
	public List<T> reverse(List<T> theList){
		
		//we need to go through list from the last element and increment it down, adding them as we go
		for (int x = theList.size()-1; x>=0; x--)
		{
			//reverse for loop that gets the element in the last spot adds it to the first spot and then removes that element from the last spot
			theList.add(theList.get(x));
			theList.remove(x);
		}
		
		//returns the new list that is now in reverse order
		return theList;
	}

}
