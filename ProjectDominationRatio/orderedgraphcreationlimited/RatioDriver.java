package orderedgraphcreationlimited;

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
				//limit of 6 vertices
		long n = 6;
		//number of possible edges (based on vertices)
		long e = choose(n, 2);
		//number of possible graphs
		long limit = power(2, e);
		
		
		
		//counts graphs placed with current number of edges
		long graphcounter = 0;
		//counts edges placed in graph
		int edgecounter = 0;
		//how many edges the current graph will have
		long edges = 0;
		
		long edgelimit = choose(e, edges);
		//lock variables
		int locknumber = 0;
		
		//continue flag
		boolean flag = true;
		
		
		//build new graph with no edges
			//walk through edges
		for(int y = 0; y < e; y++)
		{
			//add adjacency list
			graph.add(false);
		}
	
		//int x = 0;
		//edit graph
			//walk through number of possible graphs
		for(int x = 0; x < limit; x++)
		//while(flag == true)
		{
			//mark flag as true to break loop if not interrupted
			flag = false;
			
			
			
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
					flag = true;
				}
				
			}
			System.out.println("\n");
			
			//mark graph creation
			graphcounter++;
			
			
			edgelimit = choose(e, edges);
			//if all graphs are made for current edges
			if( graphcounter == edgelimit )
			{
				edges++;
				//locknumber = edges;
				
				//edge bounds checking
				if( edges > e )
				{
					break;
				}
				
				//build initial edges
				for(int y = 0; y < edges; y++)
				{
					//construct edge
					graph.set(y, true);
				}
				//clear non-intial edges
				for(long y = edges; y < graph.size(); y++)
				{
					graph.set((int)y, false);
				}
			
				//reset the counter for how many graphs have been made for current number of edges
				graphcounter = 0;
				
				
				
				
				
			}
			else
			{
				//shift edge on graph
				graph = shift(graph, edges);
				graph = clean(graph, edges);
			
			}
			
			//x++;
		}
		
		
		
			
			
			
	}
	
	private static ArrayList<Boolean> shift(ArrayList<Boolean> temp, long number)
	{
		//if number is zero
		if( number == 0 )
		{
			return temp;
		}
		
		//move the numberth edge forward one space
			//focuse on the numberth 1
		long numberth = getindexof(temp, number, 1);
		
		//bounds check
			//if next is in bounds AND next (if existing) is 0
		if( (numberth + 1) < temp.size() && (temp.get((int) (numberth + 1)) == false))
		{
			//set next to 1
			temp.set((int) (numberth+1), true);
			//set numberth to 0
			temp.set((int) numberth, false);
		}
		//if next is out of bounds OR next is a 1 OR number is greater than 0
		else if( ((numberth + 1) == temp.size() || (temp.get((int) (numberth + 1)) == true)) && number > 0 )
		{
			//shift the previous edge
			temp = shift(temp, number-1);
			
			//focus on the number-1th 1
			numberth = getindexof(temp, number-1, 1);
			
			//if next would be in bounds
			if( numberth+1 < temp.size() )
			{
				//set the next of the graph
				temp.set((int) (numberth+1), true);
			}
			
		}
		
		
		//return modified graph
		return temp;
	}
	
	private static ArrayList<Boolean> clean(ArrayList<Boolean> temp, long number)
	{
		if( number == 0 )
		{
			return temp;
		}
		//move the numberth edge forward one space
			//focuse on the numberth 1
		long numberth = getindexof(temp, number, 1);
		
		if( numberth + 1 < temp.size() )
		{
			//walk from numberth+1 to end of arraylist
			for(long x = (numberth+1); x < temp.size(); x++)
			{
				temp.set((int) x, false);
			}
		}
		
		//return modified graph
		return temp;
	}
	
	private static long choose(long n, long k)
	{
		/*
		 * Formula format:
		 * n choose k = n! / (k! * (n-k)!)
		 */
		
		long numerator = factorial(n);
		long denominator = (factorial(k) * factorial(n-k));
		
		return (numerator / denominator);
	}
	
	private static long factorial(long number)
	{
		//zero check
		if( number < 1 )
		{
			number = 1;
		}
		//walk from number to 1
		for(long x = (number-1); x > 1; x--)
		{
			number = number * x;
		}
		
		return number;
	}
	
	private static long power(long base, long exponent)
	{
		if(exponent == 0)
		{
			return 1;
		}
		
		if(exponent == 1)
		{
			return base;
		}
		
		long result = base;
		
		for(int x = 0; x < (exponent-1); x++)
		{
			result = result * base;
		}
		
		return result;
	}
	
	private static long getindexof(ArrayList<Boolean> templist, long rank, int target)
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
