package a7_ReadingGraphs;

import java.util.*;
import java.io.*;
import stringGraph.*;
import util.ListsOfSets; //have to use this import to use the ListOfSet sorter methods

public class FindConnectedComponents 
{
	public static void main (String[] args) throws IOException
	{
		//create a graph using the wordGraph.txt file given
		Graph gTester = GraphIO.loadGraph("data/wordGraph.txt");
		
		ConnectivityInspector ci = new ConnectivityInspector(gTester);
		List<Set<String>> components = ci.connectedSets();
		//sort so that largest size is the first set
		util.ListsOfSets.sortBySizeDecreasing(components); //why do I have to type out the util.ListOfSets...if I imported it??
		
		Set<String> largest = components.get(0);
		int maxSizeChecker = largest.size(); //I compared maxSizeChecker to connectedMaxSize and they are both equal
						
		int connectedMaxSize = connectivitySizeChecker(components);
		System.out.println("The size of the largest connected set is: [" + connectedMaxSize + "]\n");
		
		System.out.println("After sorting our list of connected components, I wanted to test out to make sure the largest set " +
				"was equal to the method return I created below, in conclusion: " + maxSizeChecker +" = " + connectedMaxSize + "\n");
		
		String randomlyChosen = util.Sets.choose(largest);
		System.out.println("One component chosen out of this set using the util.Set.choose method is: [" + randomlyChosen + "]\n");	
	}
	
	//created a method to check for size and return largest
	public static int connectivitySizeChecker(List<Set<String>> components)
	{
		//create a sizeChecker variable that will be changed to equal the greatest size of connectivity
		int sizeChecker = 0;
		
		for(Set<String> ss : components)
		{					
			//checks to see if the components being checked is larger and then sets it to the new larger one
			if(ss.size() > sizeChecker)
				sizeChecker = ss.size();			
		}		
		
		return sizeChecker;
	}

}
