package dominationwithbits;

import java.util.ArrayList;


public class RatioDriver 
{

	
	
	
	
	
	
	public static void main(String[] args) 
	{
		//declare necessary lists
			//represents a single graph
		ArrayList<Boolean> graph = new ArrayList<Boolean>();
		//represents the domination number of graphs
		ArrayList<Integer> domination = new ArrayList<Integer>();
		//represents the total domination number of graphs
		ArrayList<Integer> totaldomination = new ArrayList<Integer>();
		//represents the ratio of the domination to total domination numbers
		ArrayList<Double> dominationratio = new ArrayList<Double>();
		
		//declare tool variables
			//number of vertices
		int n = 4;
		//number of possible edges (based on vertices)
		int e = choose(n, 2);
		//number of possible graphs
		int limit = power(2, e);
		
		//counts graphs placed with current number of edges
		int graphcounter = 0;
		//counts edges placed in graph
		int edgecounter = 0;
		//tracks which edge is being created
		int edgetracker = 0;
		//how many edges the current graph will have
		int edges = 0;
		
		//lock variables
		ArrayList<Integer> locklist = new ArrayList<Integer>();
		int locknumber = 0;
		
		//create graphs
			//walk through number of possible graphs
		for(int x = 0; x < limit; x++)
		{
			
			
			//empty graph
			graph.clear();
			//reset edges placed in graph
			edgecounter = 0;
			
			//build new graph with no edges
				//walk through vertices
			for(int y = 0; y < e; y++)
			{
				//add adjacency list
				graph.add(false);
			}
			
			//build edges
				//walk through locklist
			for(int y = 0; y < locklist.size(); y++)
			{
				//construct edge
				graph.set(locklist.get(y), true);
				//increment edges placed in graph
				edgecounter++;
			}
			
			if( edgecounter < edges )
			{
				//construct remaining edge
					//construct edge
				graph.set(edgetracker, true);
				//increment edges placed in graph
				edgecounter++;
				//increment edgetracker for next edge placement
				edgetracker++;
					
				//if edgetracker is out of bounds
				if( edgetracker >= e )
				{
					locklist.set(locklist.size()-1, locklist.get(locklist.size()-1)+1);
					//walk through locklist
					for( int z = 0; z < locklist.size(); z++ )
					{
						//if locknumber is out of bounds
						if( locklist.get(locklist.size()-(z+1)) >= e )
						{
							locknumber = 0;
						}
					}
						
					edgetracker = locklist.get(locklist.size()-1) + 1;
					if( edgetracker >= e )
					{
						edgetracker = 0;
					}
						
				
				}
			
			}
			
			
			System.out.println("Graph: " + (x+1));
			System.out.println("Edges in graph: " + edges);
			//display graph
				//walk through possible edges
			for(int y = 0; y < graph.size(); y++)
			{
				if(graph.get(y))
				{
					System.out.print("1, ");
				}
				else
				{
					System.out.print("0, ");
				}
				
			}
			System.out.println("\n");
			
			
			//mark graph creation
			graphcounter++;
			
			//if all graphs are made for current edges
			if( graphcounter == choose(e, edges) )
			{
				edges++;
				
				//reset the counter for how many graphs have been made for current number of edges
				graphcounter = 0;
				
				if( edges == 1)
				{
					edgetracker = 0;
				}
				else
				{
					//declare edge to lock
					locknumber = edges-1;
					
					locklist.clear();
					
					for( int z = 0; z < locknumber; z++ )
					{
						locklist.add(0);
					}
					
					edgetracker = 1;
				}
				
				
				
			}
			
			
			
		}
		
		
		
			
			
			
	}
	
	private static int choose(int n, int k)
	{
		/*
		 * Formula format:
		 * n choose k = n! / (k! * (n-k)!)
		 */
		
		int numerator = factorial(n);
		int denominator = (factorial(k) * factorial(n-k));
		
		return (numerator / denominator);
	}
	
	private static int factorial(int number)
	{
		//zero check
		if( number < 1 )
		{
			number = 1;
		}
		//walk from number to 1
		for(int x = (number-1); x > 1; x--)
		{
			number = number * x;
		}
		
		return number;
	}
	
	private static int power(int base, int exponent)
	{
		if(exponent == 0)
		{
			return 1;
		}
		
		if(exponent == 1)
		{
			return base;
		}
		
		int result = base;
		
		for(int x = 0; x < (exponent-1); x++)
		{
			result = result * base;
		}
		
		return result;
	}
}
