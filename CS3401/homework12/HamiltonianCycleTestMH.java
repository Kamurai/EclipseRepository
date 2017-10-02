package homework12;

import tester.Tester;

public class HamiltonianCycleTestMH {
	public static void main (String[] args){
		Tester.run(new HamiltonianCycleTestMH());
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
			
			//Test #1: check to see if there is a ham cycle from center location of wheelgraph;
			t.checkExpect(wheelGraph.isHamiltonianCycle(0), false); 
			t.checkExpect(cycleGraph.isHamiltonianCycle(0), false);
		}
		//come here for any unexpected Exceptions
		catch (Exception e){
			e.printStackTrace();
			t.fail("An Unexpected error has occured - Error #123456ABCDEF!");
		}
	}
}