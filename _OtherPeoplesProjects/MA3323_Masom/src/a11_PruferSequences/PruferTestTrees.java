//Masom Hamadeh
//MATH 3323 
//Assignment #10

package a11_PruferSequences;

import java.util.*;
import intGraph.*;


//Trees: v=e+1, acyclic, and connected (criteria needed to be a tree)
//for PRUFER sequences, its always # of Vertices - 2 for the prufer sequence (going backwards)

public class PruferTestTrees 
{
	public static void main (String[] args)
	{
		Graph tree1 = ExampleTrees.TREE_1;
		Graph tree2 = ExampleTrees.TREE_2;
		Graph tree3 = ExampleTrees.TREE_3;
		Graph tree4 = ExampleTrees.TREE_4;
		
		List<Integer> prufer1 = getPrufer(tree1);
		List<Integer> prufer2 = getPrufer(tree2);
		List<Integer> prufer3 = getPrufer(tree3);
		List<Integer> prufer4 = getPrufer(tree4);
		
		System.out.println("MY prufer sequence for Tree_1 is:\t" + prufer1);
		System.out.println("GIVEN prufer sequence for Tree_1 is:\t" + ExampleTrees.PRUFER_1 + "\n");
		System.out.println("MY prufer sequence for Tree_2 is:\t" + prufer2);
		System.out.println("GIVEN prufer sequence for Tree_2 is:\t" + ExampleTrees.PRUFER_2 + "\n");
		System.out.println("MY prufer sequence for Tree_3 is:\t" + prufer3);
		System.out.println("GIVEN prufer sequence for Tree_3 is:\t" + ExampleTrees.PRUFER_3 + "\n");
		System.out.println("MY prufer sequence for Tree_4 is:\t" + prufer4);
		System.out.println("GIVEN prufer sequence for Tree_4 is:\t" + ExampleTrees.PRUFER_4 + "\n");		
	}
	
	//method requirement for assignment
	public static List<Integer> getPrufer(Graph g) 
	{
		//create the dynamically changing list
		List<Integer> pruf = new ArrayList<Integer>();
		
		//get the set of ALL verticies in the tree
		Set<Integer> verts = g.vertexSet();
				
		while (verts.size() > 2)
		{
			int min = Integer.MAX_VALUE;
						
			for (int i : verts)
			{				
				if (min > i && g.degreeOf(i) == 1)
					min = i;					
			}
			
			int ov = g.getNeighbor(min);
			pruf.add(ov);
			g.removeVertex(min);
			verts = g.vertexSet();				
		}		
		
		return pruf;
	}
	
	/*
	1.  Remember that g is the graph we're working on
	2. Create a list pruf to hold the result
	3. Let verts be the set of vertices of the tree
	4. While verts has more than 2 elements, do the following repeatedly
	      1. Find the vertex of degree 1 with the smallest value. You can just compare vertices using < or the like since they act like int's. 
	      	 Call this vertex min
	      2. Get the neighbor vertex of min, call it ov. There is a method in intGraph.Graph to get a neighbor vertex.
	      3. Add ov to list pruf
	      4. Remove min from graph g
	      5. Reassign verts as the set of vertices for g
	5. Return pruf
	*/


}
