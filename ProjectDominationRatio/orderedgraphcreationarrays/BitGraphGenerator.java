package orderedgraphcreationarrays;

import java.util.ArrayList;
import orderedgraphcreationarrays.BitGraph;


public class BitGraphGenerator 
{

	/*
	 * Notes:
	 * 
	 * 0 vertices:
	 * 
	 * 1 vertices:
	 * 
	 * 2 vertices:
	 * 1-2,
	 * 
	 * 3 vertices:
	 * 1-2, 1-3, 2-3 OLD
	 * 1-2, 1-3, 2-3 NEW
	 * 
	 * 4 vertices:
	 * 1-2, 1-3, 1-4, 2-3, 2-4, 3-4 OLD
	 * 1-2, 1-3, 2-3, 1-4, 2-4, 3-4 NEW
	 * 
	 * 5 vertices:
	 * 1-2, 1-3, 1-4, 1-5, 2-3, 2-4, 2-5, 3-4, 3-5, 4-5 OLD
	 * 1-2, 1-3, 2-3, 1-4, 2-4, 3-4, 1-5, 2-5, 3-5, 4-5 NEW
	 * 
	 */
	
	
	
	
	
	public static void main(String[] args) 
	{
		//this driver must be able to represent all bitgraphs representing 0 through 36,028,797,018,963,968 (=2^55) 
			//actual long capabilities place it at (2^63 =) 9,223,372,036,854,775,807
				//this generator is capped at 11 vertices with 55 possible edges
		
		//long output = (long) Math.pow(2, 55);
			//this is the number to alter for testing purposes
				//number of edges 
		double range = 6;
		long input = 0;
		BitGraph bob;
		
		for( input = 0; input < Math.pow(2, range)+1; input++ )
		{
			//set input
			//input = 17;
		
			//generate bitgraph based on a given long
			bob = new BitGraph(input, (int) range);
		
			//display test-bitgraph
			bob.displayedgeset();
			bob.displaymatrix();
		}
		
		
		
	}
	
	
	
	
	
}
