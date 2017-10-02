//Masom Hamadeh
//CS3401 HW#11

package homework11;
import tester.*;

public class AbstractGraphTestMH2 {
	public static void main (String[] args){
		Tester.run(new AbstractGraphTestMH2());
	}
	
	//CREATE TEST METHODS HERE - if any
	
	public void testGraphs (Tester t){
		try{
			//array of my favorite airport codes
			String[] airports = {"ATL","BEY","LAX","YWG","ATH"};
			
			//P5 graph (path graph - linear)
			int[][]pGraph = {{0,1},{1,0},{1,2},{2,1},{2,3},{3,2},{3,4},{4,3}};
			
			//C5 graph (cycle graph - just like linear but with one more edge connected tail and head)
			int[][] cGraph = {{0,4},{0,1},{1,0},{1,2},{2,1},{2,3},{3,2},{3,4},{4,3},{4,0}};
			
			//random graph, this time using the W5 (wheel graph)
			int[][] wGraph = {{0,1},{0,2},{0,3}, {0,4}, //center location at vertex 0
							  {1,0},{1,2},{1,4},
							  {2,0},{2,1},{2,3}, 
							  {3,0},{3,2},{3,4},
							  {4,1},{4,0},{4,3}};
			
			//one more random graph, this time using the S5 (star graph)
			int [][] sGraph = {{0,1},{0,2},{0,3},{0,4},{1,0},{2,0},{3,0},{4,0}};
						
			//create graphs to be used
			AbstractGraph pathGraph = new UnweightedGraph(pGraph, airports);
			AbstractGraph cycleGraph = new UnweightedGraph(cGraph, airports);
			AbstractGraph wheelGraph = new UnweightedGraph(wGraph, airports);
			AbstractGraph starGraph = new UnweightedGraph(sGraph, airports);
			
			/*******************************************
			 * TESTING beyond this point: BEWARE!
			 ******************************************/
			
			//test getConnectedComponents() on different types of graphs
			//TESTS #1 thru #4
			t.checkExpect(pathGraph.getConnectedComponents().size(), 1);
			t.checkExpect(cycleGraph.getConnectedComponents().size(), 1);
			t.checkExpect(wheelGraph.getConnectedComponents().size(), 1);
			t.checkExpect(starGraph.getConnectedComponents().size(), 1);
			
			//test isCycle() method here on different types of graphs
			//TESTS #5 thru #8
			t.checkExpect(pathGraph.isCycle(), false);
			t.checkExpect(cycleGraph.isCycle(), true);
			t.checkExpect(wheelGraph.isCycle(), true);
			t.checkExpect(starGraph.isCycle(), true);
			
			//Now, we will create disconnected graphs (sub-graphs of a main graph)
			Integer[] vertices = {0,1,2,3,4,5,6};
			
			int[][] twoSubgraphs = //first subgraph
								   {{0,1},{1,0}, 
							       //second subgraph
								   {2,3},{2,4},{2,5},
								   {3,2},{3,5},
								   {4,2},{4,5},
								   {5,2},{5,3},{5,4},{5,6},
								   {6,5}};
			
			int[][] threeSubgraphs = //first subgraph
									{{0,1},{1,0},
									//second subgraph
									{2,3},{3,2},
									//third subgraph
									{4,5},
									{5,4},{5,6},
									{6,5}};
			
			
			
			//testing on disconnected graph with TWO and THREE subgraphs
			AbstractGraph testGraph1 = new UnweightedGraph(twoSubgraphs, vertices);
			AbstractGraph testGraph2 = new UnweightedGraph(threeSubgraphs, vertices);
			
			//TEST #9 thru #12
			t.checkExpect(testGraph1.getConnectedComponents().size(), 2);
			t.checkExpect(testGraph1.isCycle(), false);
			t.checkExpect(testGraph2.getConnectedComponents().size(), 3);
			t.checkExpect(testGraph2.isCycle(), false);
			
			
			
			}
		//come here for any unexpected Exceptions
		catch (Exception e){
			e.printStackTrace();
			t.fail("An Unexpected error has occured - Error #123456ABCDEF!");
		}
	}
}
