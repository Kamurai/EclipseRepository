//Masom Hamadeh
//MATH3323
//Assignment #9

package a9_ComputingDegreeSequences;

import java.util.*;
import java.io.*;
import stringGraph.*;
import util.ListsOfSets;
import util.Sets;

public class ComputeDegreeSequences 
{	
	public static void main(String[] args) throws IOException
	{	
		//create graph and then create the connectivity inspector to find the connected components
		Graph g = GraphIO.loadGraph("data/wordGraph.txt");
		ConnectivityInspector ci = new ConnectivityInspector(g);
		
		//create a list of sets of strings and then sort them by size decreasing
		List<Set<String>> connected = ci.connectedSets();
		util.ListsOfSets.sortBySizeDecreasing(connected);
		
		List<Set<String>> largestFive = new LinkedList<Set<String>>();
		
		for(int i = 0; i < 5; i++)
		{
			largestFive.add(connected.get(i));
		}
		
		//for testing purposes ONLY
		System.out.println("We have successfully taken the 5 largest connected components and added them into a new\n"+
				"list of sets called: largestFive.  And just to make sure, the size of this new list is: [" + largestFive.size() + "]\n");
		
		//NOTE:
		//The degree sequence of a graph is simply the integer sequence formed from the degrees of each of the vertices of the graph. 
		//Usually, this is sorted into non-increasing order. 
		
		List<List<Integer>> parentDegreeList = new ArrayList<List<Integer>>();
		
				
		for (Set<String> ss : largestFive) //checks each set in largestFive and for each of them...
		{
			List<Integer> childDegreeList = new ArrayList<Integer>();
						
			for (String s : ss) //checks each string in the parent set<String>...
			{			
				
				childDegreeList.add(g.degreeOf(s));
				
			}	
			
			Collections.sort(childDegreeList);
			Collections.reverse(childDegreeList);
			//used for testing purposes to make sure code is sound
			System.out.println("[FOR testing purposes ONLY - Child list size(s)]: " + childDegreeList.size()); 
			parentDegreeList.add(childDegreeList); //add the childList to the parentList
						
		}
		
		System.out.println("\nNow we can list the 5 sets in sorted degree sequence:\n");
		
			
		for (List<Integer> list : parentDegreeList)
		{
			System.out.println("Size of this list: [" + list.size() + "] --> " + list + "\n");
		}
		
		System.out.println("In conlcusion, we know that the parent list of lists contains the correct sizes with sorted degree sequences!");
		
		
	}
}
