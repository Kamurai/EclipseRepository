package dominationwithcontinuousbits;

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
		//how many edges the current graph will have
		int edges = 0;
		
		//lock variables
		int locknumber = 0;
		
		
		//build new graph with no edges
			//walk through edges
		for(int y = 0; y < e; y++)
		{
			//add adjacency list
			graph.add(false);
		}
	
		//edit graph
			//walk through number of possible graphs
		for(int x = 0; x < limit; x++)
		{
			//output which graph is being displayed
			System.out.println("Graph: " + (x+1));
			//output the number of edges in currently displayed graph
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
			
			//walk through possible edges
			for(int y = 0; y < e; y++)
			{
				//if 1
				if(graph.get(y) == true)
				{
					
					//increment counter
					edgecounter++;
					
					//if target to move is located 
					if(edgecounter == locknumber)
					{
						//if y + 1 is in bounds
							//if move would put last 1 in bounds
						if( y+1 < e )
						{
							//move 1 forward
							graph.set(y+1, true);
							graph.set(y, false);

							//escape
							y = e;
							
						}
						//if y+1 is out of bounds
							//if move would put last one out of bounds
						else
						{
							//if prior 1 is followed by a zero
							if( (getindexof(graph, locknumber--, 1)+1) == 0 )
							{
								//move a prior 1 one forward one bit
								graph.set(getindexof(graph, locknumber--, 1)+1, true);
								graph.set(getindexof(graph, locknumber--, 1), false);

							}
							//else prior 1 is followed by a one
							else
							{
								//move prior prior 1 forward one bit
							}
							
							//shift all the 1s past the last shifted to just after the last shifted
						}
						//reset edgecounter
							edgecounter = 0;
					}
				}
			}
			
			
			
			
			
			
			//mark graph creation
			graphcounter++;
			
			//if all graphs are made for current edges
			if( graphcounter == choose(e, edges) )
			{
				edges++;
				locknumber = edges;
				
				//build initial edges
				for(int y = 0; y < edges; y++)
				{
					//construct edge
					graph.set(y, true);
				}
				//clear non-intial edges
				for(int y = edges; y < graph.size(); y++)
				{
					graph.set(y, false);
				}
			
				//reset the counter for how many graphs have been made for current number of edges
				graphcounter = 0;
				
				
				
				
				
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
	
	private static int getindexof(ArrayList<Boolean> templist, int rank, int target)
	{
		int counter = 0;
		
		for(int x = 0; x < templist.size(); x++)
		{
			if(translateboolean(templist.get(x)) == target)
			{
				counter++;
			}
			
			if(rank == counter)
			{
				return x;
			}
		}
		
		return -1;
	}
	
	public static int translateboolean(boolean flag)
	{
		if(flag)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
}
