package homework11;

import java.util.*;

import tester.Tester;

public class AbstractGraphTester
{
	public static void main(String[] args) 
	{
		Tester.run(new AbstractGraphTester());
	}

	// /////////////////////////////////////////////////////////////////
	// Create test methods here
	// /////////////////////////////////////////////////////////////////
	public void testBook(Tester t) 
	{
		try 
		{
			
		    	    String[] vnames = {"Chris", "Jessica", "Kayla", "Mike", "Jonathan",
		    	    					"Faith", "Sydney", "Achilles", "Karson", "Brooklyn"};
		    	    
		    	    String[] vempty = {};
		    	    String[] vone = {"Chris"};
		    	    String[] vtwo = {"Chris", "Jessica"};
		    	    String[] vthree = {"Chris", "Jessica", "Kayla"};
			    	    
		    	    int[] vnumbers = {0,1,2,3,4,5,6,7,8,9};
		    	    
		    	    List<Integer> Adam = new LinkedList<Integer>();
		    	    
		    	    for(int x = 0; x < vnumbers.length; x++)
		    	    {
		    	    	Adam.add(vnumbers[x]);
		    	    }
		    		  
		    	    int[][] elinear = { 
		    	    		{0,1}, 
		    	    		{1,0}, {1,2}, 
		    	    		{2,1}, {2,3}, 
		    	    		{3,2}, {3,4}, 
		    	    		{4,3}, {4,5}, 
		    	    		{5,4}, {5,6}, 
		    	    		{6,5}, {6,7}, 
		    	    		{7,6}, {7,8}, 
		    	    		{8,7}, {8,9}, 
				    	    {9,8}
				    	    };
		    	    
		    	    int[][] ecycle = { 
		    	    		{0,9}, {0,1}, 
		    	    		{1,0}, {1,2}, 
		    	    		{2,1}, {2,3}, 
		    	    		{3,2}, {3,4}, 
		    	    		{4,3}, {4,5}, 
		    	    		{5,4}, {5,6}, 
		    	    		{6,5}, {6,7}, 
		    	    		{7,6}, {7,8}, 
		    	    		{8,7}, {8,9}, 
				    	    {9,8}, {9,0}
				    	    };
				    	    
		    	    int[][] etest = { 
		    	    		{0,1}, 
		    	    		{1,0}, {1,2}, 
		    	    		{2,1}, {2,3},
		    	    		{3,2},   
		    	    		{5,6}, 
		    	    		{6,5}, 
		    	    		{7,8}, {7,9},
		    	    		{8,7}, {8,9},
				    	    {9,7}, {9,8}
				    	    };
//  4    5-6 	    
//	      	    
// 0-1-2-3	    	
//		    	    
//	      8
//        ^
//		 7-9  	    
		    	    
		    	    int[][] epyramid = { 
		    	    		//{0,6}, {0,9},
		    	    		{0,1}, {0,2},  
		    	    		{1,0}, {1,2}, {1,3}, {1,4}, 
		    	    		{2,0}, {2,1}, {2,4}, {2,5},
		    	    		{3,1}, {3,4}, {3,6}, {3,7},  
		    	    		{4,1}, {4,2}, {4,3}, {4,5}, {4,7}, {4,8}, 
		    	    		{5,2}, {5,4}, {5,8}, {5,9},
		    	    		{6,3}, {6,7},// {6,0},
		    	    		{7,4}, {7,3}, {7,6}, {7,8},
		    	    		{8,5}, {8,4}, {8,7}, {8,9},
		    	    		{9,5}, {9,8}//, {9,0}
		    	    		};
//		   6  	    
//		3< |  	    
//	 1< |  7    
// 0<|	4< |    	    
//	 2< |  8
//		5< |	    
//	       9    
		    	    
		    	    int[][] etriangle = { 
		    	    		{0,1}, {0,2}, 
		    	    		{1,0}, {1,3}, {1,4}, 
		    	    		{2,0}, {2,4}, {2,5},
		    	    		{3,1}, {3,6}, {3,7},  
		    	    		{4,1}, {4,7}, {4,8}, 
		    	    		{5,2}, {5,8}, {5,9},
		    	    		{6,3},
		    	    		{7,3}, {7,4},
		    	    		{8,4}, {8,5},
		    	    		{9,5}
		    	    		
		    	    		};
//		   6  	    
//		3<   	    
//	 1<    7    
// 0<	4<     	    
//	 2<    8
//		5< 	    
//	       9    

		    	    int[][] etree = { 
		    	    		{0,1}, {0,2}, 
		    	    		{1,0}, {1,3}, {1,4},
		    	    		{2,0}, {2,6}, {2,5},
		    	    		{3,1}, {3,7},  
		    	    		{4,1}, {4,8}, 
		    	    		{5,2}, {5,9}, 
		    	    		{6,2},  
		    	    		{7,3}, 
		    	    		{8,4},
				    	    {9,5}
				    	    };
//		3-7   	    
//	 1<    
//	 |	4-8  	    
// 0<   
//	 |	5-9    	        	    
//	 2<   
//		6	    

		    	    int[][] esparse = {};
		    	    int[][] etwo = {
		    	    		{0,1}, 
		    	    		{1,0}
		    	    		};
		    	    int[][] ethree = {
		    	    		{0,1}, 
		    	    		{1,0}, {2,1},
		    	    		{1,2}
		    	    		};
		    	    
		    	    
		    	    //Professor's graphs
		    	 // Single node with no edges
		    	    String[] vertex1 = {"Atlanta"};
		    	    int[][] edge0 = {};

		    	    Graph singular = new UnweightedGraph(edge0, vertex1);
		    	    
		    	    t.checkExpect(singular.isCycle(), false);
		    	    
		    	    // Cycle for one node
		    	    int[][] edge0c = {{0,0}};

		    	    Graph singularcycle = new UnweightedGraph(edge0c, vertex1);
		    	    
		    	    t.checkExpect(singularcycle.isCycle(), true);
		    	    
		    	    // 2 nodes with cycle
		    	    String[] vertex2 = {"Atlanta", "Miami"};
		    	    int[][] edge2 = {{0,1}, {1,0}};

		    	    Graph binary = new UnweightedGraph(edge2, vertex2);
		    	    
		    	    t.checkExpect(binary.isCycle(), false);

		    	    String[] vertices = { "Seattle", "San Francisco", "Los Angeles",
		    	    "Denver", "Kansas City", "Chicago", "Boston", "New York",
		    	    "Atlanta", "Miami", "Dallas", "Houston" };

		    	    // Edge array for graph in Figure 27.1
		    	    int[][] edges1 = {
		    	    		{ 0, 1 }, { 0, 3 }, { 0, 5 },
		    	    		{ 1, 0 }, { 1, 2 }, { 1, 3 }, 
		    	    		{ 2, 1 }, { 2, 3 }, { 2, 4 }, { 2, 10 },
		    	    		{ 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 3, 5 },
		    	    		{ 4, 2 }, { 4, 3 }, { 4, 5 }, { 4, 7 }, { 4, 8 }, { 4, 10 },
		    	    		{ 5, 0 }, { 5, 3 }, { 5, 4 }, { 5, 6 }, { 5, 7 }, 
		    	    		{ 6, 5 }, { 6, 7 },
		    	    		{ 7, 4 }, { 7, 5 }, { 7, 6 }, { 7, 8 },
		    	    		{ 8, 4 }, { 8, 7 }, { 8, 9 }, { 8, 10 }, { 8, 11 },
		    	    		{ 9, 8 }, { 9, 11 },
		    	    		{ 10, 2 },{ 10, 4 }, { 10, 8 }, { 10, 11 },
		    	    		{ 11, 8 }, { 11, 9 },{ 11, 10 } };

//	   10-----\    	    
//	   | \ \   \    	    
//   1-2-4  \   \
//	 |\|/| \ |   \	    
// 0<--3 | |\|   |
//   \  \| 7-8--11
//	  ---5<|   V    
//         6   9
		    	    // Seattle, San Francisco, Los Angeles are isolated
		    	    int[][] edges2 = { 
		    	    		{ 0, 1 },
		    	    		{ 1, 0 }, { 1, 2 },
		    	    		{ 2, 1 }, 
		    	    		{ 3, 4 }, { 3, 5 },
		    	    		{ 4, 3 }, { 4, 5 }, { 4, 7 }, { 4, 8 }, { 4, 10 },
		    	    		{ 5, 3 }, { 5, 4 }, { 5, 6 }, { 5, 7 },
		    	    		{ 6, 5 }, { 6, 7 },
		    	    		{ 7, 4 }, { 7, 5 }, { 7, 6 }, { 7, 8 },
		    	    		{ 8, 4 }, { 8, 7 }, { 8, 9 }, { 8, 10 }, { 8, 11 },
		    	    		{ 9, 8 }, { 9, 11 }, 
		    	    		{ 10, 4 }, { 10, 8 }, { 10, 11 },
		    	    		{ 11, 8 }, { 11, 9 }, { 11, 10 }
		    	    };

//		    		   10-----\    	    
//		    		     \ \   \    	    
//		    	     1-2 4  \   \
//		    		 |  /| \ |   \	    
//		    	   0/  3 | |\|   |
// 		    	        \| 7-8--11
//		    		     5<|   V    
//		    	           6   9

		    	    

		    	    
		    	    Graph cities1 = new UnweightedGraph(edges1, vertices);
		    	    
		    	    t.checkExpect(cities1.isCycle(), true);
		    	    
		    	    Graph cities2 = new UnweightedGraph(edges2, vertices);
		    	    
		    	    t.checkExpect(cities2.isCycle(), true);
		    	    
		    	    
		    	    //Build control List of Lists
		    	    List<List<Integer>> Bob = new LinkedList<List<Integer>>(); 
		    	    
		    	    //Build empty graph
		    	    AbstractGraph empty = new UnweightedGraph(esparse, vempty);
		    	    
		    	    //Build testing graph
		    	    AbstractGraph test = new UnweightedGraph(etest, vnames);
		    	    
		    	    //Build cycle graph
		    	    AbstractGraph cycle = new UnweightedGraph(ecycle, vnames);
		    	    
		    	    //Build linear graph
		    	    AbstractGraph linear = new UnweightedGraph(elinear, vnames);
		    	    
		    	    //Build pyramid graph
		    	    AbstractGraph pyramid = new UnweightedGraph(epyramid, vnames);
		    	    
		    	    //Build triangle graph
		    	    AbstractGraph triangle = new UnweightedGraph(etriangle, vnames);
		    	    
		    	    //Build tree graph
		    	    AbstractGraph tree = new UnweightedGraph(etree, vnames);
		    	    
		    	    //Build graph with 10 independent vertices
		    	    AbstractGraph sparse = new UnweightedGraph(esparse, vnames);
		    	    
		    	    //Build a graph with 1 independent vertex
		    	    AbstractGraph one = new UnweightedGraph(esparse, vone);
		    	    
		    	    //Build a graph with 2 connected vertices
		    	    AbstractGraph two = new UnweightedGraph(etwo, vtwo);
		    	    
		    	    //Build a graph with 3 connected vertices
		    	    AbstractGraph three = new UnweightedGraph(ethree, vthree);
		    	    
		    	 //test 1
		    	    //test getConnectedComponents on empty graph
		    	    t.checkExpect(empty.getConnectedComponents(), Bob);
		    	    
		    	  //add the complete list to the control list of lists
		    	    Bob.add(Adam);
		    	    
		    	 //test 2   
		    	    //test getConnectedComponents on linear graph 
		    	    t.checkExpect(linear.getConnectedComponents(), Bob);
		    	    
		    	    //reverse the first list in the control list of lists
		    	    for(int x = vnumbers.length-1; x > 0 ; x--)
		    	    {
		    	    	Adam.remove(vnumbers[x]);
		    	    	Adam.add(vnumbers[x]);
		    	    }
		    	    
		    	    Bob.set(0, Adam);
		    	    
		    	 //test 3
		    	    //test getConnectedComponents on cycle graph
		    	    t.checkExpect(cycle.getConnectedComponents(), Bob);
		    	    
		    	    //clear and adjust control list of lists
		    	    Bob.clear();
		    	    
		    	    //adjust building lists and add to the list of lists
		    	    
		    	    Adam = new LinkedList<Integer>();
		    	    Adam.add(0);
		    	    Adam.add(1);
		    	    Adam.add(2);
		    	    Adam.add(3);
		    	    Bob.add(Adam);
		    	    Adam = new LinkedList<Integer>();
		    	    Adam.add(4);
		    	    Bob.add(Adam);
		    	    Adam = new LinkedList<Integer>();
		    	    Adam.add(5);
		    	    Adam.add(6);
		    	    Bob.add(Adam);
		    	    Adam = new LinkedList<Integer>();
		    	    Adam.add(7);
		    	    Adam.add(8);
		    	    Adam.add(9);
		    	    Bob.add(Adam);
		    	    
		    	 //test 4
		    	    //test getConnectedComponents on test graph
		    	    t.checkExpect(test.getConnectedComponents(), Bob);
		    	    
		    	    Bob.clear();
		    	    Adam = new LinkedList<Integer>();
		    	    Adam.add(0);
		    	    Adam.add(1);
		    	    Adam.add(2);
		    	    Adam.add(4);
		    	    Adam.add(3);
		    	    Adam.add(6);
		    	    Adam.add(7);
		    	    Adam.add(8);
		    	    Adam.add(5);
		    	    Adam.add(9);
		    	    Bob.add(Adam);
		    	    
		    	 //test 5
		    	    //test getConnectedComponents on pyramid graph
		    	    t.checkExpect(pyramid.getConnectedComponents(), Bob);
		    	    
		    	    Bob.clear();
		    	    Adam = new LinkedList<Integer>();
		    	    Adam.add(0);
		    	    Adam.add(1);
		    	    Adam.add(3);
		    	    Adam.add(6);
		    	    Adam.add(7);
		    	    Adam.add(4);
		    	    Adam.add(8);
		    	    Adam.add(5);
		    	    Adam.add(2);
		    	    Adam.add(9);
		    	    Bob.add(Adam);
		    	    
		    	 //test 6
		    	    //test getConnectedComponents on triangle graph
		    	    t.checkExpect(triangle.getConnectedComponents(), Bob);
		    	    
		    	    Bob.clear();
		    	    Adam = new LinkedList<Integer>();
		    	    Adam.add(0);
		    	    Adam.add(1);
		    	    Adam.add(3);
		    	    Adam.add(7);
		    	    Adam.add(4);
		    	    Adam.add(8);
		    	    Adam.add(2);
		    	    Adam.add(6);
		    	    Adam.add(5);
		    	    Adam.add(9);
		    	    Bob.add(Adam);
		    	    
		    	 
		    	 //test 7
		    	    //test getConnectedComponents on tree graph
		    	    t.checkExpect(tree.getConnectedComponents(), Bob);
		    	 
		    	    Bob.clear();
		    	    for(int x = 0; x < vnumbers.length; x++)
		    	    {
		    	    	Adam = new LinkedList<Integer>();
		    	    	Adam.add(x);
		    	    	Bob.add(Adam);
		    	    }
		    	    		    	    
		    	 //test 8
		    	    //test getConnectedComponents on sparse graph
		    	    t.checkExpect(sparse.getConnectedComponents(), Bob);
		    	    
		    	    Bob.clear();
		    	    Adam = new LinkedList<Integer>();
		    	    Adam.add(0);
		    	    Bob.add(Adam);
		    	    
		    	  //test 9
		    	    //test getConnectedComponents on sparse graph
		    	    t.checkExpect(one.getConnectedComponents(), Bob);
		    	 
		    	    Bob.clear();
		    	    Adam = new LinkedList<Integer>();
		    	    Adam.add(0);
		    	    Adam.add(1);
		    	    Bob.add(Adam);
		    	    
		    	  //test 10
		    	    //test getConnectedComponents on sparse graph
		    	    t.checkExpect(two.getConnectedComponents(), Bob);
		    	 
		    	    Bob.clear();
		    	    Adam = new LinkedList<Integer>();
		    	    Adam.add(0);
		    	    Adam.add(1);
		    	    Adam.add(2);
		    	    Bob.add(Adam);
		    	    
		    	  //test 11
		    	    //test getConnectedComponents on sparse graph
		    	    t.checkExpect(three.getConnectedComponents(), Bob);
		    	 
		    	    
		   //isCycle testing 	    
		    	    
		    	 //test 12
		    	    //test isCycle on empty graph
		    	    t.checkExpect(empty.isCycle(), false);
		    	    
		    	 //test 13
		    	    //test isCycle on linear graph
		    	    t.checkExpect(linear.isCycle(), false);
		    	 
		    	 //test 14
		    	    //test isCycle on test graph
		    	    t.checkExpect(test.isCycle(), true);
		    	    
		    	  //test 15
		    	    //test isCycle on cycle graph
		    	    t.checkExpect(cycle.isCycle(), true);
		    	    
		    	 //test 16
		    	    //test isCycle on pyramid graph
		    	    t.checkExpect(pyramid.isCycle(), true);
		    	    
		    	 //test 17
		    	    //test isCycle on triangle graph
		    	    t.checkExpect(triangle.isCycle(), false);
			
		    	//test 18
		    	    //test isCycle on tree graph
		    	    t.checkExpect(tree.isCycle(), false);
		    	    
		    	//test 19
		    	    //test isCycle on sparse graph
		    	    t.checkExpect(sparse.isCycle(), false);
		    	
		    	//test 20
		    	    //test isCycle on graph of one independent vertex
		    	    t.checkExpect(one.isCycle(), false);
		    	
			    //test 21
		    	    //test isCycle on graph of one independent vertex
		    	    t.checkExpect(two.isCycle(), false);

		    	//test 22
		    	    //test isCycle on graph of one independent vertex
		    	    t.checkExpect(three.isCycle(), false);

					
			}
		// Come here for any unexpected Exceptions
		catch (Exception e) 
		{
			e.printStackTrace();
			t.fail();
		}
		
			
	}
	
}
