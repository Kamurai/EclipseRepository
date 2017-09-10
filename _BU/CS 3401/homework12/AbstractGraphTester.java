package homework12;

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
		    	    
		    	    List<Integer> Adam = new ArrayList<Integer>();
		    	    
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
		    	    
		    	    //Build control List of Lists
		    	    List<List<Integer>> Bob = new ArrayList<List<Integer>>(); 
		    	    
		    	    //Build empty graph
		    	    Graph empty = new UnweightedGraph(esparse, vempty);
		    	    
		    	    //Build testing graph
		    	    Graph test = new UnweightedGraph(etest, vnames);
		    	    
		    	    //Build cycle graph
		    	    Graph cycle = new UnweightedGraph(ecycle, vnames);
		    	    
		    	    //Build linear graph
		    	    Graph linear = new UnweightedGraph(elinear, vnames);
		    	    
		    	    //Build pyramid graph
		    	    Graph pyramid = new UnweightedGraph(epyramid, vnames);
		    	    
		    	    //Build triangle graph
		    	    Graph triangle = new UnweightedGraph(etriangle, vnames);
		    	    
		    	    //Build tree graph
		    	    Graph tree = new UnweightedGraph(etree, vnames);
		    	    
		    	    //Build graph with 10 independent vertices
		    	    Graph sparse = new UnweightedGraph(esparse, vnames);
		    	    
		    	    //Build a graph with 1 independent vertex
		    	    Graph one = new UnweightedGraph(esparse, vone);
		    	    
		    	    //Build a graph with 2 connected vertices
		    	    Graph two = new UnweightedGraph(etwo, vtwo);
		    	    
		    	    //Build a graph with 3 connected vertices
		    	    Graph three = new UnweightedGraph(ethree, vthree);
		    	 
		    	    //add the complete list to the control list of lists
		    	    Bob.add(Adam);
		    	 
		    	 //test 1
		    	    //test getConnectedComponents on empty graph
		    	    try
		    	    {
		    	    	t.checkExpect(empty.getHamiltonianPath(0), null);	
		    	    }
		    	    catch(IndexOutOfBoundsException e)
		    	    {
		    	    	t.success();
		    	    }
		    	    
		    	    
		    	 //test 2   
		    	    //test getConnectedComponents on linear graph 
		    	    t.checkExpect(linear.getHamiltonianPath(0), Adam);
		    	    
		    	    
		    	 //test 3
		    	    //test getConnectedComponents on cycle graph
		    	    t.checkExpect(cycle.getHamiltonianPath(0), Adam);
		    	    
		    	    //clear and adjust control list of lists
		    	    Bob.clear();
		    	    
		    	    //adjust building lists and add to the list of lists
		    	    
		    	    Adam = new ArrayList<Integer>();
		    	    Adam.add(0);
		    	    Adam.add(1);
		    	    Adam.add(2);
		    	    Adam.add(3);
		    	    Bob.add(Adam);
		    	    Adam = new ArrayList<Integer>();
		    	    Adam.add(4);
		    	    Bob.add(Adam);
		    	    Adam = new ArrayList<Integer>();
		    	    Adam.add(5);
		    	    Adam.add(6);
		    	    Bob.add(Adam);
		    	    Adam = new ArrayList<Integer>();
		    	    Adam.add(7);
		    	    Adam.add(8);
		    	    Adam.add(9);
		    	    Bob.add(Adam);
		    	    
		    	 //test 4
		    	    //test getConnectedComponents on test graph
		    	    t.checkExpect(test.getHamiltonianPath(0), null);
		    	    
		    	    Bob.clear();
		    	    Adam = new ArrayList<Integer>();
		    	    Adam.add(0);
		    	    Adam.add(2);
		    	    Adam.add(5);
		    	    Adam.add(9);
		    	    Adam.add(8);
		    	    Adam.add(7);
		    	    Adam.add(6);
		    	    Adam.add(3);
		    	    Adam.add(1);
		    	    Adam.add(4);
		    	    Bob.add(Adam);
		    	    
		    	 //test 5
		    	    //test getConnectedComponents on pyramid graph
		    	    t.checkExpect(pyramid.getHamiltonianPath(0), Adam);
		    	    
		    	 //test 6
		    	    //test getConnectedComponents on triangle graph
		    	    t.checkExpect(triangle.getHamiltonianPath(0), null);
		    	    
		    	    Bob.clear();
		    	    Adam = new ArrayList<Integer>();
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
		    	    t.checkExpect(tree.getHamiltonianPath(0), null);
		    	 
		    	    Bob.clear();
		    	    for(int x = 0; x < vnumbers.length; x++)
		    	    {
		    	    	Adam = new ArrayList<Integer>();
		    	    	Adam.add(x);
		    	    	Bob.add(Adam);
		    	    }
		    	    		    	    
		    	 //test 8
		    	    //test getConnectedComponents on sparse graph
		    	    t.checkExpect(sparse.getHamiltonianPath(0), null);
		    	    
		    	    Bob.clear();
		    	    Adam = new ArrayList<Integer>();
		    	    Adam.add(0);
		    	    Bob.add(Adam);
		    	    
		    	  //test 9
		    	    //test getConnectedComponents on sparse graph
		    	    t.checkExpect(one.getHamiltonianPath(0), Adam);
		    	 
		    	    Bob.clear();
		    	    Adam = new ArrayList<Integer>();
		    	    Adam.add(0);
		    	    Adam.add(1);
		    	    Bob.add(Adam);
		    	    
		    	  //test 10
		    	    //test getConnectedComponents on sparse graph
		    	    t.checkExpect(two.getHamiltonianPath(0), Adam);
		    	 
		    	    Bob.clear();
		    	    Adam = new ArrayList<Integer>();
		    	    Adam.add(0);
		    	    Adam.add(1);
		    	    Adam.add(2);
		    	    Bob.add(Adam);
		    	    
		    	  //test 11
		    	    //test getConnectedComponents on sparse graph
		    	    t.checkExpect(three.getHamiltonianPath(0), Adam);
		    	 
		    	    
		   //isHamiltonianCycle testing 	    
		    	    
		    	 //test 12
		    	   	try
		    	   	{
		    	   		t.checkExpect(empty.isHamiltonianCycle(0), false);
		    	   	}
		    	   	catch(IndexOutOfBoundsException e)
		    	   	{
		    	   		t.success();
		    	   	}
		    	   	
		    	 //test 13-22
		    	    //test isHamiltonianCycle on linear graph
		    	    t.checkExpect(linear.isHamiltonianCycle(0), false);
		    	    t.checkExpect(linear.isHamiltonianCycle(1), false);
		    	    t.checkExpect(linear.isHamiltonianCycle(2), false);
		    	    t.checkExpect(linear.isHamiltonianCycle(3), false);
		    	    t.checkExpect(linear.isHamiltonianCycle(4), false);
		    	    t.checkExpect(linear.isHamiltonianCycle(5), false);
		    	    t.checkExpect(linear.isHamiltonianCycle(6), false);
		    	    t.checkExpect(linear.isHamiltonianCycle(7), false);
		    	    t.checkExpect(linear.isHamiltonianCycle(8), false);
		    	    t.checkExpect(linear.isHamiltonianCycle(9), false);
			    	 
		    	    
		    	 //test 23-32
		    	    //test isHamiltonianCycle on cycle graph
		    	    t.checkExpect(cycle.isHamiltonianCycle(0), true);
		    	    t.checkExpect(cycle.isHamiltonianCycle(1), true);
		    	    t.checkExpect(cycle.isHamiltonianCycle(2), true);
		    	    t.checkExpect(cycle.isHamiltonianCycle(3), true);
		    	    t.checkExpect(cycle.isHamiltonianCycle(4), true);
		    	    t.checkExpect(cycle.isHamiltonianCycle(5), true);
		    	    t.checkExpect(cycle.isHamiltonianCycle(6), true);
		    	    t.checkExpect(cycle.isHamiltonianCycle(7), true);
		    	    t.checkExpect(cycle.isHamiltonianCycle(8), true);
		    	    t.checkExpect(cycle.isHamiltonianCycle(9), true);
		    	    		    	    
		    	  //test 33-42
		    	    //test isHamiltonianCycle on test graph
		    	    t.checkExpect(test.isHamiltonianCycle(0), false);
		    	    t.checkExpect(test.isHamiltonianCycle(1), false);
		    	    t.checkExpect(test.isHamiltonianCycle(2), false);
		    	    t.checkExpect(test.isHamiltonianCycle(3), false);
		    	    t.checkExpect(test.isHamiltonianCycle(4), false);
		    	    t.checkExpect(test.isHamiltonianCycle(5), false);
		    	    t.checkExpect(test.isHamiltonianCycle(6), false);
		    	    t.checkExpect(test.isHamiltonianCycle(7), false);
		    	    t.checkExpect(test.isHamiltonianCycle(8), false);
		    	    t.checkExpect(test.isHamiltonianCycle(9), false);
		    	    
		    	 //test 43-52
		    	    //test isHamiltonianCycle on pyramid graph
		    	    
		    	    t.checkExpect(pyramid.isHamiltonianCycle(0), false);//error
		    	    t.checkExpect(pyramid.isHamiltonianCycle(1), true);
		    	    t.checkExpect(pyramid.isHamiltonianCycle(2), true);
		    	    t.checkExpect(pyramid.isHamiltonianCycle(3), true);
		    	    t.checkExpect(pyramid.isHamiltonianCycle(4), true);
		    	    t.checkExpect(pyramid.isHamiltonianCycle(5), true);
		    	    t.checkExpect(pyramid.isHamiltonianCycle(6), false);//error
		    	    t.checkExpect(pyramid.isHamiltonianCycle(7), true);
		    	    t.checkExpect(pyramid.isHamiltonianCycle(8), true);
		    	    t.checkExpect(pyramid.isHamiltonianCycle(9), false);//error
		    	    
		    	 //test 53-62
		    	    //test isHamiltonianCycle on triangle graph
		    	    t.checkExpect(triangle.isHamiltonianCycle(0), false);
		    	    t.checkExpect(triangle.isHamiltonianCycle(1), false);
		    	    t.checkExpect(triangle.isHamiltonianCycle(2), false);
		    	    t.checkExpect(triangle.isHamiltonianCycle(3), false);
		    	    t.checkExpect(triangle.isHamiltonianCycle(4), false);
		    	    t.checkExpect(triangle.isHamiltonianCycle(5), false);
		    	    t.checkExpect(triangle.isHamiltonianCycle(6), false);
		    	    t.checkExpect(triangle.isHamiltonianCycle(7), false);
		    	    t.checkExpect(triangle.isHamiltonianCycle(8), false);
		    	    t.checkExpect(triangle.isHamiltonianCycle(9), false);
					
		    	//test 63-72
		    	    //test isHamiltonianCycle on tree graph
		    	    t.checkExpect(tree.isHamiltonianCycle(0), false);
		    	    t.checkExpect(tree.isHamiltonianCycle(1), false);
		    	    t.checkExpect(tree.isHamiltonianCycle(2), false);
		    	    t.checkExpect(tree.isHamiltonianCycle(3), false);
		    	    t.checkExpect(tree.isHamiltonianCycle(4), false);
		    	    t.checkExpect(tree.isHamiltonianCycle(5), false);
		    	    t.checkExpect(tree.isHamiltonianCycle(6), false);
		    	    t.checkExpect(tree.isHamiltonianCycle(7), false);
		    	    t.checkExpect(tree.isHamiltonianCycle(8), false);
		    	    t.checkExpect(tree.isHamiltonianCycle(9), false);
		    	    
		    	//test 73-82
		    	    //test isHamiltonianCycle on sparse graph
		    	    t.checkExpect(sparse.isHamiltonianCycle(0), false);
		    	    t.checkExpect(sparse.isHamiltonianCycle(1), false);
		    	    t.checkExpect(sparse.isHamiltonianCycle(2), false);
		    	    t.checkExpect(sparse.isHamiltonianCycle(3), false);
		    	    t.checkExpect(sparse.isHamiltonianCycle(4), false);
		    	    t.checkExpect(sparse.isHamiltonianCycle(5), false);
		    	    t.checkExpect(sparse.isHamiltonianCycle(6), false);
		    	    t.checkExpect(sparse.isHamiltonianCycle(7), false);
		    	    t.checkExpect(sparse.isHamiltonianCycle(8), false);
		    	    t.checkExpect(sparse.isHamiltonianCycle(9), false);
			    	
		    	//test 83
		    	    //test isHamiltonianCycle on graph of one independent vertex
		    	    t.checkExpect(one.isHamiltonianCycle(0), false);
		    	
			    //test 84 and 85
		    	    //test isHamiltonianCycle on graph of two vertices with one edge
		    	    t.checkExpect(two.isHamiltonianCycle(0), true);
		    	    t.checkExpect(two.isHamiltonianCycle(1), true);

		    	//test 86-88
		    	    //test isHamiltonianCycle on graph of three vertices with two edges
		    	    t.checkExpect(three.isHamiltonianCycle(0), false);
		    	    t.checkExpect(three.isHamiltonianCycle(1), false);
		    	    t.checkExpect(three.isHamiltonianCycle(2), false);

		    	    
		    	    //Professor's graphs
			    	 // Single node with no edges
			    	    String[] vertex1 = {"Atlanta"};
			    	    int[][] edge0 = {};

			    	    Graph singular = new UnweightedGraph(edge0, vertex1);
			    	    
			    	    //test 89
			    	    t.checkExpect(singular.isHamiltonianCycle(0), false);
			    	    
			    	    // Cycle for one node
			    	    int[][] edge0c = {{0,0}};

			    	    Graph singularcycle = new UnweightedGraph(edge0c, vertex1);
			    	    
			    	    //test 90
			    	    t.checkExpect(singularcycle.isHamiltonianCycle(0), true);
			    	    
			    	    // 2 nodes with cycle
			    	    String[] vertex2 = {"Atlanta", "Miami"};
			    	    int[][] edge2 = {{0,1}, {1,0}};

			    	    Graph binary = new UnweightedGraph(edge2, vertex2);
			    	    
			    	    //test 91 and 92
			    	    t.checkExpect(binary.isHamiltonianCycle(0), true);
			    	    t.checkExpect(binary.isHamiltonianCycle(1), true);
			    	    
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

//		   10-----\    	    
//		   | \ \   \    	    
	//   1-2-4  \   \
//		 |\|/| \ |   \	    
	// 0<--3 | |\|   |
	//   \  \| 7-8--11
//		  ---5<|   V    
//	         6   9
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

//			    		   10-----\    	    
//			    		     \ \   \    	    
//			    	     1-2 4  \   \
//			    		 |  /| \ |   \	    
//			    	   0/  3 | |\|   |
//	 		    	        \| 7-8--11
//			    		     5<|   V    
//			    	           6   9

			    	    

			    	    
			    	    Graph cities1 = new UnweightedGraph(edges1, vertices);
			    	    
			    	    //test 93 through 102
			    	    t.checkExpect(cities1.isHamiltonianCycle(0), false); //error
			    	    t.checkExpect(cities1.isHamiltonianCycle(1), false); //error
			    	    t.checkExpect(cities1.isHamiltonianCycle(2), true);
			    	    t.checkExpect(cities1.isHamiltonianCycle(3), true);
			    	    t.checkExpect(cities1.isHamiltonianCycle(4), true);
			    	    t.checkExpect(cities1.isHamiltonianCycle(5), true);
			    	    t.checkExpect(cities1.isHamiltonianCycle(6), false);//error
			    	    t.checkExpect(cities1.isHamiltonianCycle(7), false);//error
			    	    t.checkExpect(cities1.isHamiltonianCycle(8), false);//error
			    	    t.checkExpect(cities1.isHamiltonianCycle(9), false);//error
			    	    
			    	    
			    	    Graph cities2 = new UnweightedGraph(edges2, vertices);
			    	    
			    	    //test 103 through 112
			    	    t.checkExpect(cities2.isHamiltonianCycle(0), false);
			    	    t.checkExpect(cities2.isHamiltonianCycle(1), false);
			    	    t.checkExpect(cities2.isHamiltonianCycle(2), false);
			    	    t.checkExpect(cities2.isHamiltonianCycle(3), false);
			    	    t.checkExpect(cities2.isHamiltonianCycle(4), false);
			    	    t.checkExpect(cities2.isHamiltonianCycle(5), false);
			    	    t.checkExpect(cities2.isHamiltonianCycle(6), false);
			    	    t.checkExpect(cities2.isHamiltonianCycle(7), false);
			    	    t.checkExpect(cities2.isHamiltonianCycle(8), false);
			    	    t.checkExpect(cities2.isHamiltonianCycle(9), false);
			    	    
					
			}
		// Come here for any unexpected Exceptions
		catch (Exception e) 
		{
			e.printStackTrace();
			t.fail();
		}
		
			
	}
	
}
