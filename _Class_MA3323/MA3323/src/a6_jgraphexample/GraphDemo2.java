package a6_jgraphexample;

import java.io.IOException;
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
public class GraphDemo2 {

	public static void main(String[] args) throws IOException {
		// We can create a graph from data in a properly formatted file
		Graph g = GraphIO.loadGraph("data/wordComponent364.txt");
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
		// pick a couple of vertices, by number, arbitrarily
		int v1 = 213;
		int v2 = 355;
		String vert1 = dm.getVertexAt(v1);
		String vert2 = dm.getVertexAt(v2);
		System.out.println("The vertex at index " + v1 + " in the distance matrix "
				+ "object is " + vert1);
		System.out.println("The vertex at index " + v2 + " in the distance matrix "
				+ "object is " + vert2);
		System.out.println("They are " + dm.getDistance(v1, v2) + " steps apart ");
		/**
		 * The first vertex on the shortest path from vert1 to vert2 must have 
		 * a distance 1 from vert1 and a distance d-1 from vert2 where d is 
		 * the total distance from vert1 to vert2.
		 */
		int d = dm.getDistance(v1, v2);
		// startlooking at vertex 0
		int i = 0;
		while(dm.getDistance(i, v1) != 1 || dm.getDistance(i, v2) != d-1 )
			i++;
		System.out.println("The first vertex in a shortest path from " + vert1 
				+ " to " + vert2 + " is " + dm.getVertexAt(i));
	}

}
