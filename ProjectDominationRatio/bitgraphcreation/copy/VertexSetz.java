/**
 * 
 */
package bitgraphcreation.copy;

/**
 * @author SGR
 *
 */
public class VertexSetz {
	
	//temporarily use master list:
	private int masterVertexSet [][];
	
	private int maximumNumber = 0;
	
	/*
	private int [][] fourVertexSet = {
			// {empty set}
			{1},
			{2}, 
			{3}, 
			{4},
			{1,2}, 
			{1,3}, 
			{1,4}, 
			{2,3}, 
			{2,4}, 
			{3,4},
			{1,2,3}, 
			{1,2,4}, 
			{1,3,4}, 
			{2,3,4},
			{1,2,3,4}
	};
	
	private int [][] fiveVertexSet = {
			// {empty set}
			{1}, {2}, {3}, {4}, {5},
			{1,2}, {1,3}, {1,4}, {1,5}, {2,3}, {2,4}, {2,5}, {3,4}, {3,5}, {4,5},
			{1,2,3}, {1,2,4}, {1,2,5}, {1,3,4}, {1,3,5}, {1,4,5}, {2,3,4}, {2,3,5}, {2,4,5}, {3,4,5},
			{1,2,3,4}, {1,2,3,5}, {1,2,4,5}, {1,3,4,5}, {2,3,4,5},
			{1,2,3,4,5}
			
	};
	
	private int [][] sixVertexSet = {
			// {empty set}
			{1}, {2}, {3}, {4}, {5}, {6},
			{1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {2, 3}, {2, 4}, {2, 5}, {2, 6}, {3, 4}, {3, 5}, {3, 6}, {4, 5}, {4, 6}, {5, 6},
			{1, 2, 3}, {1, 2, 4}, {1, 2, 5}, {1, 2, 6}, {1, 3, 4}, {1, 3, 5}, {1, 3, 6}, {1, 4, 5}, {1, 4, 6}, {1, 5, 6}, {2, 3, 4}, {2, 3, 5}, {2, 3, 6}, {2, 4, 5}, {2, 4, 6}, {2, 5, 6}, {3, 4, 5}, {3, 4, 6}, {3, 5, 6}, {4, 5, 6},
			{1, 2, 3, 4}, {1, 2, 3, 5}, {1, 2, 3, 6}, {1, 2, 4, 5}, {1, 2, 4, 6}, {1, 2, 5, 6}, {1, 3, 4, 5}, {1, 3, 4, 6}, {1, 3, 5, 6}, {1, 4, 5, 6}, {2, 3, 4, 5}, {2, 3, 4, 6}, {2, 3, 5, 6}, {2, 4, 5, 6}, {3, 4, 5, 6},
			{1, 2, 3, 4, 5}, {1, 2, 3, 4, 6}, {1, 2, 3, 5, 6}, {1, 2, 4, 5, 6}, {1, 3, 4, 5, 6}, {2, 3, 4, 5, 6},
			{1, 2, 3, 4, 5, 6}

	};
	
	private int [][] sevenVertexSet = {
			// {empty set}
			{1}, {2}, {3}, {4}, {5}, {6}, {7},
			{1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}, {2, 3}, {2, 4}, {2, 5}, {2, 6}, {2, 7}, {3, 4}, {3, 5}, {3, 6}, {3, 7}, {4, 5}, {4, 6}, {4, 7}, {5, 6}, {5, 7}, {6, 7},
			{1, 2, 3}, {1, 2, 4}, {1, 2, 5}, {1, 2, 6}, {1, 2, 7}, {1, 3, 4}, {1, 3, 5}, {1, 3, 6}, {1, 3, 7}, {1, 4, 5}, {1, 4, 6}, {1, 4, 7}, {1, 5, 6}, {1, 5, 7}, {1, 6, 7}, {2, 3, 4}, {2, 3, 5}, {2, 3, 6}, {2, 3, 7}, {2, 4, 5}, {2, 4, 6}, {2, 4, 7}, {2, 5, 6}, {2, 5, 7}, {2, 6, 7}, {3, 4, 5}, {3, 4, 6}, {3, 4, 7}, {3, 5, 6}, {3, 5, 7}, {3, 6, 7}, {4, 5, 6}, {4, 5, 7}, {4, 6, 7}, {5, 6, 7}, {1, 2, 3, 4}, {1, 2, 3, 5}, {1, 2, 3, 6}, {1, 2, 3, 7},
			{1, 2, 4, 5}, {1, 2, 4, 6}, {1, 2, 4, 7}, {1, 2, 5, 6}, {1, 2, 5, 7}, {1, 2, 6, 7}, {1, 3, 4, 5}, {1, 3, 4, 6}, {1, 3, 4, 7}, {1, 3, 5, 6}, {1, 3, 5, 7}, {1, 3, 6, 7}, {1, 4, 5, 6}, {1, 4, 5, 7}, {1, 4, 6, 7}, {1, 5, 6, 7}, {2, 3, 4, 5}, {2, 3, 4, 6}, {2, 3, 4, 7}, {2, 3, 5, 6}, {2, 3, 5, 7}, {2, 3, 6, 7}, {2, 4, 5, 6}, {2, 4, 5, 7}, {2, 4, 6, 7}, {2, 5, 6, 7}, {3, 4, 5, 6}, {3, 4, 5, 7}, {3, 4, 6, 7}, {3, 5, 6, 7}, {4, 5, 6, 7},
			{1, 2, 3, 4, 5}, {1, 2, 3, 4, 6}, {1, 2, 3, 4, 7}, {1, 2, 3, 5, 6}, {1, 2, 3, 5, 7}, {1, 2, 3, 6, 7}, {1, 2, 4, 5, 6}, {1, 2, 4, 5, 7}, {1, 2, 4, 6, 7}, {1, 2, 5, 6, 7}, {1, 3, 4, 5, 6}, {1, 3, 4, 5, 7}, {1, 3, 4, 6, 7}, {1, 3, 5, 6, 7}, {1, 4, 5, 6, 7}, {2, 3, 4, 5, 6}, {2, 3, 4, 5, 7}, {2, 3, 4, 6, 7}, {2, 3, 5, 6, 7}, {2, 4, 5, 6, 7}, {3, 4, 5, 6, 7},
			{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 7}, {1, 2, 3, 4, 6, 7}, {1, 2, 3, 5, 6, 7}, {1, 2, 4, 5, 6, 7}, {1, 3, 4, 5, 6, 7}, {2, 3, 4, 5, 6, 7},
			{1, 2, 3, 4, 5, 6, 7}

	};
*/

			
	
	public VertexSetz (int numVertices)
	{	
		//maximum number of possible dominating sets - the empty set
		maximumNumber = (int) Math.pow(2, numVertices) - 1;
		
		//number of possible dominating graphs for current cycle
		int limit = 0;
		//counter for first rank of masterVertexSet
		int counter = 0;
		//value holder
		int hold = 1;
		
		masterVertexSet  = new int[maximumNumber][];
		
		//masterVertexSet[1] = new int[1];
		
		//masterVertexSet[counter] = new int[limit];
		
		//masterVertexSet[5] = new int[2];
		
		//masterVertexSet = new int[maximumNumber][numVertices];
		
		//rotate through number of vertices in possible dominating sets
		for(int x = 1; x <= numVertices; x++)
		{
			limit = (int) Combinatorics.choose(numVertices, x);
			
			//set hold to 1 for each cycle
			hold = 1;
			
			
			//loop only enough times to complete current cycle (singles, doubles, triples, fourths, ...etc)
			for(int y = 0; y < limit; y++)
			{
				masterVertexSet[counter] = new int[x];
				//set 1st values for current cycle
					//if first set of cycle
				if( y == 0)
				{
					for(int rank = 0; rank < x; rank++)
					{
						//the current rank is set to the held value
						masterVertexSet[counter][rank] = hold;
						hold++;
					}
					
				}
				else
				{
					//shift last set
						masterVertexSet[counter] = shift(masterVertexSet[counter-1], numVertices);
				}
				
				//move to the next set
				counter++;	
				
				
				/*
				for(int rank = 1; rank <= x; rank++)
				{
					//set 1st values for current cycle
					if( y == 1)
					{
						//the current rank is set to the held value
						masterVertexSet[counter][rank] = hold;
						hold++;
					}
					else
					{
						
						//check mVS[c][r] against nV
							//if equal to number of vertices
						if( masterVertexSet[counter-1][rank] == numVertices )
						{
							//shift 
							
							//the previous rank is set to one plus the previous value 
							//masterVertexSet[counter][rank] = masterVertexSet[counter-1][rank]++;
							
						}
						else
						{
							//copy last counter's rank
							masterVertexSet[counter][rank] = masterVertexSet[counter-1][rank];
							
						}
					}
					
					 
				}
				*/
			}
			
			
			
		}
		
		
	}
	
	private int[] shift(int[] input, int number)
	{
		int[] output = new int[input.length];
		
		//copy only the values form the input array
			//could NOT remember how to avoid walkthrough the array
		for(int x = 0; x < output.length; x++)
		{
			output[x] = input[x];
		}
		
		//if last element is less than number
		if( output[output.length-1] < number )
		{
			//increase last element by 1
			output[output.length-1]++;
		}
		//if equal to number
		//walkthrough array to find next available incrmentation
		else
		{
			//walkthrough 
			for(int x = output.length-1; x >= 1; x--)
			{
				//if current and previous have a difference greater than 1
				if( output[x] - output[x-1] > 1 )
				{
					//increment previous
					output[x-1]++;
					
					
					//adjust all elements after previous
						//walkthrough rest of array
					for(int y = x; y <= output.length-1; y++)
					{
						
						output[y] = output[y-1] + 1;
					}
					
					
					//escape
					x = -1;
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		return output;
	}


	public int[][] getMasterVertexSet() {
		
		return masterVertexSet;
	}
	

}
