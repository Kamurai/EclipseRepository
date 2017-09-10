package math3323_assignment11_kemerait;

import intGraph.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class PruferExcercise {

	public static void main(String[] args) 
	{
		//create a list to store the prufer sequences
		List<List<Integer>> prufers = new ArrayList<List<Integer>>();
		List<List<Integer>> answers = new ArrayList<List<Integer>>();
		List<Graph> graphs = new ArrayList<Graph>();
		
		//get sequences from ExampleTrees
			//add trees to list of graphs
		graphs.add( intGraph.ExampleTrees.TREE_1 );
		graphs.add( intGraph.ExampleTrees.TREE_2 );
		graphs.add( intGraph.ExampleTrees.TREE_3 );
		graphs.add( intGraph.ExampleTrees.TREE_4 );
		
		//add answers to list
		answers.add( intGraph.ExampleTrees.PRUFER_1 );
		answers.add( intGraph.ExampleTrees.PRUFER_2 );
		answers.add( intGraph.ExampleTrees.PRUFER_3 );
		answers.add( intGraph.ExampleTrees.PRUFER_4 );
		
		
		//show sequences
		for(int x = 0; x < graphs.size(); x++)
		{
			//print header for tree
			System.out.println("Tree " + (x+1) );
		
		//print tree
		System.out.println( graphs.get(x) );
		
		//compute and add prufer sequence to list
		prufers.add( getPrufer( graphs.get(x) ) );
		
		//print sequence
		System.out.println( prufers.get(x) );
		System.out.println( answers.get(x) );
		
		//spacing
		System.out.println("\n");
		
		}
		
		
		//display output results
		for(int x = 0; x < graphs.size(); x++)
		{
			//if getPrufer is correct for the current tree
			if( prufers.get(x).equals( answers.get(x) ) )
			{
				System.out.println( "getPrufers is correct for graph " + (x+1) );
			}
			//else
			else
			{
				System.out.println( "getPrufers is incorrect for graph " + (x+1) );
			}
		}
		
	}
	
	//1) Remember that g is the graph we're working on 
	public static List<Integer> getPrufer(Graph g)
	{
		/*
		  	1) Remember that g is the graph we're working on 
			2) Create a list pruf to hold the result 
			3) Let verts be the set of vertices of the tree 
			
			4) While verts has more than 2 elements, do the following repeatedly 
				a) Find the vertex of degree 1 with the smallest value. You can just compare vertices using < or the like since they act like int's. Call this vertex min 
				b) Get the neighbor vertex of min, call it ov. There is a method in intGraph.Graph to get a neighbor vertex. 
				c) Add ov to list pruf 
				d) Remove min from graph g 
				e) Reassign verts as the set of vertices for g 
			5) Return pruf 
		 */
		
		//2) Create a list pruf to hold the result 
		List<Integer> pruf = new ArrayList<Integer>();
		
		//3) Let verts be the set of vertices of the tree 
		Set<Integer> verts = g.vertexSet();
		
		/*
		   	4) While verts has more than 2 elements, do the following repeatedly 
				a) Find the vertex of degree 1 with the smallest value. You can just compare vertices using < or the like since they act like int's. Call this vertex min 
				b) Get the neighbor vertex of min, call it ov. There is a method in intGraph.Graph to get a neighbor vertex. 
				c) Add ov to list pruf 
				d) Remove min from graph g 
				e) Reassign verts as the set of vertices for g 
		 */
		
		//tool variables
		int ov = 0;
		int min = 0;
		
		int tool = 0;
		
		Iterator<Integer> iterator;
		
		//4) While verts has more than 2 elements, do the following repeatedly 
		while( verts.size() > 2)
		{
			//loop variables
			//min = verts.size();
			iterator = verts.iterator();
			
			//find max
			min = iterator.next();
			//loop through rest of set
			while( iterator.hasNext() )
			{
				//store current iterator for checking
				tool = iterator.next();
				
				//if next item is greater
				if( tool > min )
				{
					min = tool;
				}
			}
			
			//a) Find the vertex of degree 1 with the smallest value. You can just compare 
				//vertices using < or the like since they act like int's. Call this vertex min 
					//walkthrough vertices
			
			iterator = verts.iterator();
			
			while( iterator.hasNext() )
			{
				//store current iterator for checking
				tool = iterator.next();
				
				//if current vertex has a degree of 1 AND is small than the current min
				if( g.degreeOf(tool) == 1 && tool < min )
				{
					//store new minimum
					min = tool;
				}
			}
			
			//b) Get the neighbor vertex of min, call it ov. There is a method in intGraph.Graph
				//to get a neighbor vertex.

			ov = g.getNeighbor(min);
			
			//c) Add ov to list pruf
			pruf.add(ov);
			
			//d) Remove min from graph g
//causing issue
			g.removeVertex(min);
			//verts.remove(min);
			
			//e) Reassign verts as the set of vertices for g
			verts = g.vertexSet();
			
		}
		
		
		
		//5) Return pruf
		return pruf;
	}

}
