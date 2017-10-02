package dominationwithlists;

import java.util.ArrayList;


public class CopyOfRatioDriver 
{

	
	
	
	
	
	
	public static void main(String[] args) 
	{
		//declare necessary lists
			//represents a single graph
		ArrayList<ArrayList<String>> graph = new ArrayList<ArrayList<String>>();
		//represents the domination number of graphs
		ArrayList<Integer> domination = new ArrayList<Integer>();
		//represents the total domination number of graphs
		ArrayList<Integer> totaldomination = new ArrayList<Integer>();
		//represents the ratio of the domination to total domination numbers
		ArrayList<Double> dominationratio = new ArrayList<Double>();
		
		//declare tool variables
			//number of vertices
		int n = 3;
		//number of possible edges (based on vertices)
		int e = choose(n, 2);
		//number of possible graphs
		int limit = power(2, n);
		
		//counts graphs placed with current number of edges
		int graphcounter = 0;
		//counts edges placed in graph
		int edgecounter = 0;
		//tracks from which vertex the edge is being drawn
		int vertexcounter = 0;
		//tracks to which vertex the edge is being drawn
		int vertextarget = 0;
		//how many edges the current graph will have
		int edges = 0;
		boolean play = true;
		
		//create graphs
			//walk from 0 to maxium number of edges
		for(int x = 0; x < limit; x ++)
		{
			
			//determine the number of edges in current graph
			if( graphcounter == choose(n, edges) )
			{
				edges++;
				//reset edge counter
				graphcounter = 0;
				//reset vertex counter
				vertexcounter = 0;
				//reset vertex target
				//vertextarget = 0;
				
			}
			
			//empty graph
			graph.clear();
			//reset edges placed in graph
			edgecounter = 0;
			
			//build new graph
				//walk through vertices
			for(int y = 0; y < n; y++)
			{
				//add adjacency list
				graph.add(new ArrayList<String>());
				//add current vertex to first slot of current adjacency list
				graph.get(y).add((Integer.toString( (y+1) )));
			}
			
			
			//walk through edge placement
				//walk through each vertex
			for(int y = 0; y < n; y++)
			{
				//place ends of edges at each appropriate vertex
				for(int z = 0; z < n; z++)
				{
					//if current y vertex and current z vertex are part of an edge
						//current y vertex must match vertexcounter
							//vertexcounter and vertextarget must not match
								//must be edge left to construct
					if( y == vertexcounter && z == vertextarget && (vertexcounter != vertextarget) && edgecounter < edges )
					{
						//construct edge
						graph.get(y).add((Integer.toString((z+1))));
						graph.get(z).add((Integer.toString((y+1))));
						//increment edges placed in graph
						edgecounter++;
						
						//increment vertextarget after constructing an edge
						vertextarget++;
						//loop checking
						/*if( vertextarget == vertexcounter )
						{
							vertextarget++;
						}*/
						//boundary checking
						if( vertextarget >= n )
						{
							vertextarget = 0;
						}
						
						
						//if edgecounter equals edges
						if( edgecounter == edges )
						{
							//escape
							y = n;
							z = n;
						}
					}
					
					//if edges placed is less than edges in graph
					if( vertexcounter == vertextarget && edgecounter < edges )
					{
						//determine next vertextarget
						vertextarget++;
						
						//boundary checking
						if( vertextarget >= n )
						{
							vertextarget = 0;
						}
					}
					
				}
				
				//if edges placed is less than edges in graph
				if( edgecounter < edges )
				{
					//determine next vertexcounter
					vertexcounter++;
					
					//loop checking
					/*if( vertextarget == vertexcounter )
					{
						vertexcounter++;
					}*/
					//boundary checking
					if( vertexcounter >= n )
					{
						vertexcounter = 0;
					}
				}
				
				
			}
			
			
			System.out.println("Graph: " + (x+1));
			System.out.println("Edges in graph: " + edges);
			//display graph
			for(int y = 0; y < graph.size(); y++)
			{
				System.out.print(graph.get(y).get(0) + ": ");
				for(int z = 1; z < graph.get(y).size(); z++)
				{
					System.out.print(graph.get(y).get(z) + ", ");
				}
				System.out.println();
			}
			System.out.println("\n");
			
			//vertexcounter++;
			//mark edge placement
			graphcounter++;
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
