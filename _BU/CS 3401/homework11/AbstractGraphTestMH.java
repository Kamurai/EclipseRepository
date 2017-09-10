//Masom Hamadeh
//CS3401 HW#11

package homework11;
import tester.*;

public class AbstractGraphTestMH {
	public static void main (String[] args){
		Tester.run(new AbstractGraphTestMH());
	}
	//CREATE TEST METHODS HERE - if any
	
	public void testGraphs (Tester t){
		try{
			//array of my favorite airports
			String[] airport = {"ATL","BEY","LAX","YWG","ATH"};
			
			//P5 graph (path graph - linear)
			int[][]pGraph = {{0,1},{1,0},{1,2},{2,1},{2,3},{3,2},{3,4},{4,3}};
			
			//C5 graph (cycle graph - just like linear but with one more edge connected tail and head)
			int[][] cGraph = {{0,4},{0,1},{1,0},{1,2},{2,1},{2,3},{3,2},{3,4},{4,3},{4,0}};
			
			//random graph with some basic flight routes
			int[][] rGraph = {{0,1},{1,0},{1,2},{1,4},{2,1},{2,4},{2,3},{3,2},{3,4},{4,1},{4,2},{4,3}};
			
			//random graph again, this time using the W5 (wheel graph)
			int[][] wGraph = {{0,1},{0,2},{0,3},
							  {1,0},{1,2},{1,4},
							  {2,0},{2,1},{2,3},{2,4}, //center location
							  {3,0},{3,2},{3,4},
							  {4,1},{4,2},{4,3}};
			
			//one more random graph, this time using the S5 (star graph - no cycles b/c outer nodes are pendants)
			int [][] sGraph = {{0,1},{0,2},{0,3},{0,4},{1,0},{2,0},{3,0},{4,0}};
						
			//create graphs to be used
			AbstractGraph pathGraph = new UnweightedGraph(pGraph, airport);
			AbstractGraph cycleGraph = new UnweightedGraph(cGraph, airport);
			AbstractGraph randomGraph = new UnweightedGraph(rGraph, airport);
			AbstractGraph wheelGraph = new UnweightedGraph(wGraph, airport);
			AbstractGraph starGraph = new UnweightedGraph(sGraph, airport);
			
			/*******************************************
			 * TESTING beyond this point: BEWARE!
			 ******************************************/
			
			//test getConnectedComponents() on different types of graphs
			t.checkExpect(pathGraph.getConnectedComponents().size(), 1);
///cycyleGraph should have only 1 component, not 2
			t.checkExpect(cycleGraph.getConnectedComponents().size(), 1);
			t.checkExpect(randomGraph.getConnectedComponents().size(), 4);
			t.checkExpect(wheelGraph.getConnectedComponents().size(), 10);
			t.checkExpect(starGraph.getConnectedComponents().size(), 0);
			
			//test isCycle() method here on different types of graphs
			t.checkExpect(pathGraph.isCycle(), false);
			t.checkExpect(cycleGraph.isCycle(), true);
			t.checkExpect(randomGraph.isCycle(), false); 
			t.checkExpect(wheelGraph.isCycle(), true);
			t.checkExpect(starGraph.isCycle(), false);
			}
		
		//come here for any unexpected Exceptions
		catch (Exception e){
			e.printStackTrace();
			t.fail("An Unexpected error has occured - Error <Insert crazy number here>!");
		}
	}
}
