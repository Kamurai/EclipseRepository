package math3323_assignment9_kemerait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import stringGraph.ConnectivityInspector;
import stringGraph.DistanceMatrix;
import stringGraph.Edge;
import stringGraph.Graph;
import stringGraph.GraphIO;




public class ComputeDegreeSequences 
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
		
		//DistanceMatrix dm = new DistanceMatrix(g);
				
		//create a list of connected sets from the connectivity inspector 
		List<Set<String>> connectedsets = gadget.connectedSets();
		
		
		//create an array of trackers to mind which sets are the 5 largest connected sets
		List<Integer> trackers = new ArrayList<Integer>();
		
		//add the first connected set to list
		trackers.add( 0 );
		
		//walk through list of sets
		for(int x = 0; x < connectedsets.size(); x++)
		{
			//if current set is larger than one item
			if( connectedsets.get(x).size() > 1 )
			{
				//walk through list of largest connected sets
				for(int y = 0; y < trackers.size(); y++)
				{
					//if current connected set is larger than one being tracked
					if( connectedsets.get(x).size() > connectedsets.get( trackers.get(y) ).size() )
					{
						//add current connected set to tracker list
						trackers.add(y, x );
						
						//if tracker list has become larger than 5 items
						while( trackers.size() > 5 )
						{
							//reduce list to 5 items
							trackers.remove( trackers.size()-1 );
						}
												
						//escape y for loop
						y = trackers.size();
					}
				
				}
			}
		}
		
		//store 5 largest sets as its own list of lists
		List<Set<String>> largestsets = new ArrayList<Set<String>>();
		
		//store list of sets of words as a list of lists of words
		List<List<String>> stringsets = new ArrayList<List<String>>();
		
		//create 5 empty lists which to add strings
		for(int x = 0; x < 5; x++)
		{
			stringsets.add(new ArrayList<String>());
		}
		
		//store the degrees of the words in the lists of the list in a list of lists of integers
		List<List<Integer>> degreesets = new ArrayList<List<Integer>>();
		
		//create 5 empty lists which to add integers
		for(int x = 0; x < 5; x++)
		{
			degreesets.add(new ArrayList<Integer>());
		}
		
		//create an iterator to travel through sets
		Iterator<String> iterator;
		
		
		//add tracked sets (5 largest) into a separate list
		for(int x = 0; x < trackers.size(); x++)
		{
			//add largest sets to a list of sets of strings
			largestsets.add( connectedsets.get( trackers.get(x) ) );
			
			//reset iterator for current largestset
			iterator = largestsets.get(x).iterator();
			
			//for all strings in largest set
			while( iterator.hasNext() )
			{
				//copy string from set to list
				stringsets.get(x).add( iterator.next() );
				
				//input degree of last copied string to list
				degreesets.get(x).add( g.degreeOf( stringsets.get(x).get( stringsets.get(x).size()-1 ) ) );
			}
			
			
		}
		
		
		//display some output for largest sets
			//display set sizes
		for(int x = 0; x < largestsets.size(); x++)
		{
			System.out.println("The #" + (x+1) +" largest connected set is of size " + largestsets.get(x).size() + ".");
			
		}
		
		//display header for actual sets
		System.out.println("\nThose sets are as follows:");
				
		//display sets
		for(int x = 0; x < largestsets.size(); x++)
		{
			System.out.println( largestsets.get(x) );			
		}
		
		//spacing
		System.out.println("\n");
		
		//Iterator<String> iterator = largestsets.get(0).iterator();
		
		//sort the degreesets from largest to smallest
		for(int x = 0; x < degreesets.size(); x++)
		{
			sortitout1(degreesets.get(x));
		}
		
		
		//walk through the 5 largest sets
		for(int x = 0; x < largestsets.size(); x++)
		{
			
			//reset iterator for current largestset
			//iterator = largestsets.get(x).iterator();
			
			//walk through each set (displays first 100 degrees in sequence in order to allow print to be seen)
			for(int y = 0; y < 100; y++)//largestsets.get(x).size() - 1; y++)
			//while( iterator.hasNext() )
			{
				//display degree sequences for each set
				//System.out.print( g.degreeOf( iterator.next() ) + " " );
				System.out.print( degreesets.get(x).get(y) + " " );
			}
			//display last value of degree sequence
			//System.out.println( g.degreeOf( largestsets.get(x).get(largestsets.get(x).size()-1) ) + ".");
			
			
			System.out.println();
		}
			
		
		
	}
	
	//sorts a list of integers from greatest to least
	public static void sortitout1( List<Integer> input)
	{
		int counter = 0;
		
		//break when counter exceeds number of items in list
		while( counter < input.size() )
		{
			//if counter is between 1 and input.size()-1
			if(counter > 1 && counter < input.size()-1)
			{
				//if current is less than next
				if( input.get(counter) < input.get(counter + 1) )
				{
					//move current after next
					input.add( counter + 2, input.get(counter) );
					
					//remove current (duplicate removal)
					input.remove(counter);
					
					//backtrack counter
					counter -= 3;
				}
			}
			//else if counter is <= 1
			else if( counter <= 1)
			{
				//if current is less than next
				if( input.get(counter) < input.get(counter + 1) )
				{
					//move current after next
					input.add( counter + 2, input.get(counter) );
					
					//remove current (duplicate removal)
					input.remove(counter);
					
					//backtrack counter
					counter = -1;
				}
			}
			//else if counter is >= input.size-1
			else if( counter >= input.size()-1 )
			{
				//if current is more than prior
				if( input.get(counter) > input.get(counter - 1) )
				{
					//move current after next
					input.add( counter - 1, input.get(counter) );
					
					//remove current (duplicate removal)
					input.remove(counter);
					
					//backtrack counter
					counter -= 3;
				}
			}

			//increment counter
			counter++;
		}
	}
	
	
	
	//sorts a list of integers from greatest to least
	public static void sortitout2( List<Integer> input)
	{
		//walk through list for each item (last item will be sorted by 2nd to last item's comparison)
		for(int x = 0; x < input.size()-1; x++)
		{
			//walk through list for each item (last item will be sorted by 2nd to last item's comparison)
			for(int y = 0; y < input.size()-1; y++)
			{
				//if current y is more than next y
				if( input.get(y) < input.get(y+1) )
				{
					//if current item is 2nd to last item
					if( y == input.size()-2 )
					{
						//add to end of list
						input.add( input.get(y) );
					}
					else
					{
						//move current y after next y
						input.add(y+2, input.get(y));
					}
					//remove current y (duplicate)
					input.remove(y);
				}
				
			}
		}
		
	}

}
