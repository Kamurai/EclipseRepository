//Kemerait, Christopher
//CS 3401
//Homework 4

package homework4;
import java.util.*;

/*
 * Create a generic SimpleStructures class according to
 *  the attached specification. Do NOT use the addAll,
 *   retainAll, or reverse methods from the Java libraries.
 *    Write a test program that thoroughly tests the class.
 *     Be sure to include all of the necessary positive & 
 *     negative tests. After exchanging test programs with
 *      another student, follow the instructions for 
 *      submitting an Eclipse program.

 */

public class SimpleStructures<T> extends Object
{
	//no variables (if empty constructor, then abstract class)
	
	public SimpleStructures()
	{
		//empty Constructor (abstract class)
	}
	
	//union
	public Set<T> union(Set<T> firstSet, Set<T> otherSet)
	{
		//Create the union of two Sets 
	
		//declare variables
			Set<T> unionSet = new HashSet<T>();
		
		//add firstSet to otherSet = unionSet
		//create pointer for firstSet	
		Iterator<T> iterator = firstSet.iterator();
		
		//walk through firstSet
		while(iterator.hasNext())
		{
			//add each element of firstSet to unionSet
			unionSet.add(iterator.next());
		}
		
		//move pointer to otherSet
		iterator = otherSet.iterator();
		
		//walk through otherSet
		while(iterator.hasNext())
		{
			//add each element of otherSet to unionSet
			unionSet.add(iterator.next());
		}
		
		
		//if both sets are empty, unionSet will be empty
	 
	//Returns a new Set that contains elements that are in
		//either input Set
		
		return unionSet;
	}
	
	//intersection
	public Set<T> intersection(Set<T> firstSet, Set<T> otherSet)
	{
		//Create the intersection of two Sets
		
		//declare variables
			Set<T> intersectionSet = new HashSet<T>();
		//convert sets to ArrayLists to walk through the Lists during comparison
			List<T> firstordered = new ArrayList<T>(firstSet);
			List<T> otherordered = new ArrayList<T>(otherSet);
			

		//check if firstSet's element is in otherSet
			for(int x = 0; x < firstordered.size(); x++)//(pointer.hasNext())
			{
				for(int y = 0; y < otherordered.size(); y++)
				{
					if(firstordered.get(x) == otherordered.get(y))//if(firstpointer == otherpointer);					
					{
						intersectionSet.add(firstordered.get(x));
					}
				}
			}
					
			
		//if no matches are found, intersectionSet will be empty


	//Returns a new Set that contains elements that are in
		//both input Sets
		
		return intersectionSet;
	}

	//reverse (order)
	public List<T> reverse(List<T> theList)
	{
		//Reverses (the order of) a List  
		
		
		//walk through List
		for(int x = theList.size()-1; x >= 0 ; x--)
		{
			//add the last element first, then repeat with next lowest index
				//"chases" the original List to "death"
			theList.add(theList.get(x));
			theList.remove(x);
		}
		
	//Returns a new list that is in reverse order from
		//the original
		return theList;
	}
	
	
	
}



//swap 0+n with theList.size() - n

//if 0+n == theList.size() - n
	//then stop
//if 0+n+ 1 ==  theList.size() - n
	//then stop 
//if 0+n ==  theList.size() - n -1
	//then stop