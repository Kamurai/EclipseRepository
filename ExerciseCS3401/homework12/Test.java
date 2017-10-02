package homework12;
import java.util.*;
import tester.*;

public class Test {

	public static void main(String[] args){
		Tester.run(new Test());
	}
	public void testGraphs(Tester t) {
		try {
			
			String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
				      "Denver", "Kansas City", "Chicago", "Boston", "New York",
				      "Atlanta", "Miami", "Dallas", "Houston"};
			
				    // Edge array for graph in Figure 27.1
				    int[][] edges = {
				      {0, 1}, {0, 3}, {0, 5},
				      {1, 0}, {1, 2}, {1, 3},
				      {2, 1}, {2, 3}, {2, 4}, {2, 10},
				      {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
				      {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
				      {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
				      {6, 5}, {6, 7},
				      {7, 4}, {7, 5}, {7, 6}, {7, 8},
				      {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
				      {9, 8}, {9, 11},
				      {10, 2}, {10, 4}, {10, 8}, {10, 11},
				      {11, 8}, {11, 9}, {11, 10}
				    };
				    
				    String[] vertices2 = {"Mexico", "Cuba"};
				    
				    int[][] edges2 = {
						      {0, 1},
						      {1, 0}
						    };					
				    
				    Graph graph1 = new UnweightedGraph(edges, vertices);
				    Graph graph2 = new UnweightedGraph(edges2, vertices2);
				    
				    				    
		    //positive tests
				    t.checkExpect(graph1.isHamiltonianCycle(0), false);	//1
				    t.checkExpect(graph1.isHamiltonianCycle(1), false);	//2
				    t.checkExpect(graph1.isHamiltonianCycle(2), true);	//3
				    t.checkExpect(graph1.isHamiltonianCycle(3), true);	//4
				    t.checkExpect(graph1.isHamiltonianCycle(4), true);	//5
				    t.checkExpect(graph1.isHamiltonianCycle(5), true);	//6
				    t.checkExpect(graph1.isHamiltonianCycle(6), false);	//7
				    t.checkExpect(graph1.isHamiltonianCycle(7), false);	//8
				    t.checkExpect(graph1.isHamiltonianCycle(8), false);	//9
				    t.checkExpect(graph1.isHamiltonianCycle(9), false);	//10
				    t.checkExpect(graph1.isHamiltonianCycle(10), true);	//11
				    t.checkExpect(graph1.isHamiltonianCycle(11), false);	//12
				    
				    t.checkExpect(graph2.isHamiltonianCycle(0), true);	
				    t.checkExpect(graph2.isHamiltonianCycle(1), true);
			//no negative tests
			
	//Come here for any unexpected Exceptions
		}
		catch (Exception e) {
			e.printStackTrace();
			t.fail();
		}
	}
}
