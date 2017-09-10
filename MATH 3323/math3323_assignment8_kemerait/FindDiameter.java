package math3323_assignment8_kemerait;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import stringGraph.DistanceMatrix;
import stringGraph.Edge;
import stringGraph.Graph;
import stringGraph.GraphIO;




/**
 * 	Demonstration of JGraphT
 * Create a graph from
 * 		a string of vertices (one character names)
 * 		a string of edges (pairs of characters, separated by spaces)
 * @author Ben Setzer
 */
public class FindDiameter 
{

	public static void main(String[] args) throws IOException 
	{
		// We can create a graph from data in a properly formatted file
		Graph g = GraphIO.loadGraph("data/wordComponent1532.txt");
		
		// get the set of vertices, each vertex is actually a string
		Set<String> vertices = g.vertexSet();
		System.out.println("The graph has " + vertices.size() + " vertices");
		
		// get the set of edges.  Each edge is in the class Edge
		Set<Edge> edges = g.edgeSet();
		System.out.println("The graph has " + edges.size() + " edges");
		
		// A distance matrix allows efficient access to the distances between
		//    vertices.
		DistanceMatrix dm = new DistanceMatrix(g);
		System.out.println();
		
		//initialize some variables to determine:
		//diameter
		int diameter = 0;
		//vertex at one extreme of the diameter
		int diamI = 0;
		//vertex at the other extreme of the diameter
		int diamJ = 0;
		
		//find the diameter, vertex I, and vertex J
		
		//walk through vertex set
		for(int x = 0; x < vertices.size(); x++)
		{
			//walk through vertex set for each vertex
			for(int y = 0; y < vertices.size(); y++)
			{
				//determine if the distance between the current vertices is greater than current diameter
				if( dm.getDistance(x,y) > diameter )
				{
					//record new diameter
					diameter = dm.getDistance(x, y);
					//record diamI
					diamI = x;
					//record diamJ
					diamJ = y;
				}
				
				
			}
		}
		
		//output
		System.out.println("The greatest distance is " + diameter + " edges between " + dm.getVertexAt(diamI) + " and " + dm.getVertexAt(diamJ) + ".\n");
		
		//initialize part 2 variables
		int k = diamI;
		int d = diameter - 1;
		
		//tracking list
		List<Integer> components = new ArrayList<Integer>();
		
		//add first vertex to list
		components.add(diamI);
		
		//print first vertex of connected compoents
		System.out.println( "The starting vertex of the connected components is " + dm.getVertexAt(k) + ". " + 1);
		
		//continually walk through the vertex set until all the vertices of the connected component are found
		while( k != diamJ )
		{
			
			//walk through vertices to determine the largest set of connected components
			for(int r = 0; r < vertices.size(); r++)
			{
				//distance from k to r equals 1 AND distance from r to diamJ equals d
				if( dm.getDistance(k, r) == 1 && dm.getDistance(r, diamJ) == d )
				{
					//move k forward to r
					k = r;
		
					//add next vertex to list
					components.add(diamI);
					
					//decrement d each time a vertex of the connected component is being found
					d--;
					
					//print the new vertex of the connected components
					System.out.println( "The next vertex of the connected components is " + dm.getVertexAt(k) + ". " + (diameter - d) );
					
				}
			}
		}
		
	}

}


