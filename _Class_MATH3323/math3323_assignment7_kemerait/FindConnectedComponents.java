package math3323_assignment7_kemerait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import stringGraph.ConnectivityInspector;
import stringGraph.DistanceMatrix;
import stringGraph.Edge;
import stringGraph.Graph;
import stringGraph.GraphIO;



import multinomials.PermutationGeneratorCoveyouSullivan;

public class FindConnectedComponents 
{

	public static void main(String[] args) throws IOException 
	{
		// We can create a graph from data in a properly formatted file
		Graph g = GraphIO.loadGraph("data/wordGraph.txt");
		
		// get the set of vertices, each vertex is actually a string
		Set<String> vertices = g.vertexSet();
		System.out.println("The graph has " + vertices.size() + " vertices");
		
		// get the set of edges.  Each edge is in the class Edge
		Set<Edge> edges = g.edgeSet();
		System.out.println("The graph has " + edges.size() + " edges");
		
		//spacing
		System.out.println("\n");
		
		//create a connectivity inspector for graph g
		ConnectivityInspector gadget = new ConnectivityInspector(g);
		
		//create a list of connected sets from the connectivity inspector 
		List<Set<String>> connectedsets = gadget.connectedSets();
		
		//create a tracker to mind which set is the largest connected set
		int tracker = 0;
		
		//walk through list of sets
		for(int x = 0; x < connectedsets.size(); x++)
		{
			//if current set is larger than one item
			if( connectedsets.get(x).size() > 1 )
			{
				//output connected set
				//System.out.println( connectedsets.get(x) );
				
				//if current connected set is larger than the one being tracked
				if( connectedsets.get(x).size() > connectedsets.get(tracker).size() )
				{
					//replace the tracker with current x
					tracker = x;
				}
				
			}
		}
		
		//store largest set as its own set
		Set<String> largestset = connectedsets.get(tracker);
		
		util.ListsOfSets.sortBySizeDecreasing(connectedsets);
		
		/*
		//create an array from the set
		String[] temp = largestset.toArray(new String[largestset.size()]);
		
		//create list to ordered the data
		List<String> ordered = new ArrayList<String>();
		
		//add first value
		ordered.add(ordered.size(), temp[0]);
		
		//walk through array
		for(int x = 1; x < temp.length; x++)
		{
			//walk through current list
			for(int y = 0; y < ordered.size(); y++)
			{
				//if addin is less than current string
				if( temp[x].compareTo( ordered.get(y) ) == -1 )
				{
					//if y is not 0
					if( y != 0 )
					{
						//add addin before current item
						ordered.add(y-1, temp[x]);
						//escape loop
						y = ordered.size();
					}
					else
					{
						//add addin to beginning of list
						ordered.add(0, temp[x]);
						//escape loop
						y = ordered.size();
					}
				}
				//else if equal
				else if( temp[x].compareTo( ordered.get(y) ) == 0 )
				{
					//add addin before current item
					ordered.add(y, temp[x]);
					//escape loop
					y = ordered.size();
				}
				//else if greater than
				else
				{
					//if y is not last element
					if( y == ordered.size()-1 )
					{
						//add addin to end of list
						ordered.add(ordered.size(), temp[x]);
						//escape loop
						y = ordered.size();
					}
				}
			}
		}
		*/
		
		//display some output for largest method
		System.out.println("The largest connected set is of size " + largestset.size() + ".");
		System.out.println("That set is as follows:");
		System.out.println( largestset );
		//System.out.println( connectedsets );
		
		//System.out.println( util.Sets.choose( largestset ) );  
		
		
	}

}
