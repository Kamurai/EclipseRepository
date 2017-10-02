//Masom Hamadeh
//Math 3323
//Assignment #8

package a8_GraphDiameter;

import java.util.*;
import java.io.*;
import stringGraph.*;
import util.ListsOfSets;


public class FindDiameter
{	
	public static void main(String[] args) throws IOException
	{
		Graph gDiameter = GraphIO.loadGraph("data/wordComponent1532.txt");
		DistanceMatrix dm = new DistanceMatrix(gDiameter);
		//I dunno why after I create these two distance matrices it outputs a line of all the vertices
		System.out.println("\n");
				
		int numVertices = dm.getNumberOfVertices(); //used as a test to make sure we have the right number vertices
				
		System.out.println("The number of vertices in main graph is: " + numVertices);
				
		//create the variables to represent the different components in the graph and the items we are going to work with
		int diameter = 0;
		int diamI = 0;
		int diamJ = 0;
				
		for(int i = 0; i < dm.getNumberOfVertices(); i++)
		{
			for(int j = 0; j < dm.getNumberOfVertices(); j++)
			{
				int distance = dm.getDistance(j,i);
				
				if (diameter < distance)
				{
					diameter = distance;
					diamI = i;
					diamJ = j;
				}				
			}
		}
		
		System.out.println("\nThe max diameter for main graph is: " + diameter);
		
		/*The next step is to make a list of the vertices that make up this longest path.

		   1. Initialize a variable k to equal diamI.
		   2. Initialize a variable d to equal diamater
		   3. Print the vertex at index k
		   4. Do the following as long as k != diamJ
		         1. Decrement d by 1
		         2. Find r such that the distance from vertex k to vertex r is 1 and the distance from vertex r to vertex diamJ is d.
		         3. Let k = r
		         4. Print out the word at vertex k*/
		
		int k = diamI;
		int d = diameter;
		
		//For testing purpsoses only
		List<String> longPathVerticies = new LinkedList<String>();
		
		
		
		System.out.println("\nThe vertex at index k is: " + dm.getVertexAt(k) + "\n");
		System.out.println("The list of verticies that make up this longest path are as follows:");
				
		while (k != diamJ)
		{
			d--;
			int r = 0;
			for (r = 0; r < dm.getNumberOfVertices(); r++)
			{
				if (dm.getDistance(r, k) == 1 && dm.getDistance(r, diamJ) == d)
				{
					break;
				}				
			}
			
			k = r;
			System.out.print(dm.getVertexAt(k) + ", ");
			longPathVerticies.add(dm.getVertexAt(k));
		}
		
		System.out.println("\n\nThe size of our longest path list is: [" + longPathVerticies.size() + "] and the max diameter is: ["
				+ diameter + "].\nSince they are equal we know we did this right!");
		
		
	}
}
