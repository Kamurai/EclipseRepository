package math3323_assignment6_kemerait;

import java.util.List;
import java.util.Set;

import stringGraph.ConnectivityInspector;
import stringGraph.Graph;



/**
 * 	Demonstration of JGraphT by creating a graph programmatically.
 * 
 * @author Ben Setzer
 */
public class GraphDemo1 { 

	// data for the graph: pairs of elements represent edges.
	private static String[] graphData = {
		"AA", "AB", "AB", "AC", "AC", "AD", "AD", "AE",
		"BA", "BB", "BA", "BC", "BA", "BD", "BD", "BE",
		"CA", "CB", "CB", "CC", "CB", "CD", "CA", "CE"
	};
	
	public static void main(String[] args) {
		// create a very simple graph from the data above
		Graph sg = new Graph();
		for(String s : graphData)
			sg.addVertex(s);
		for(int i = 0; i < graphData.length; i += 2) 
			sg.addEdge(graphData[i], graphData[i+1]);
		// display the graph
		System.out.println(sg);
		
		// look at connectivity
		ConnectivityInspector ci = new ConnectivityInspector(sg);
		Set<String> conn1 = ci.connectedSetOf("AA");
		System.out.println("The following is the connected component containing vertex AA");
		System.out.println(conn1);
		
		System.out.println("The following is a list of all the connected components of this graph");
		List<Set<String>> connComp = ci.connectedSets();
		for(Set<String> ss : connComp) {
			System.out.println(ss);
		}
	}

}

