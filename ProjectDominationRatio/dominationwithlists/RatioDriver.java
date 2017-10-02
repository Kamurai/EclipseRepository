package dominationwithlists;

import java.util.ArrayList;


public class RatioDriver 
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
		int n = 4;
		//number of possible edges (based on vertices)
		int e = choose(n, 2);
		//number of possible graphs
		int limit = power(2, e);
		
		//counts graphs placed with current number of edges
		int graphcounter = 0;
		//counts edges placed in graph
		int edgecounter = 0;
		//tracks from which vertex the edge is being drawn
		int vertexcounter = 0;
		//tracks to which vertex the edge is being drawn
		int vertextarget = 1;
		//how many edges the current graph will have
		int edges = 0;
		
		//lock variables
		int locklimit = 0;
		int locknumber = 0;
		int locktracker = 0;
		int lockmodifier = 1;
		ArrayList<Integer> locklist = new ArrayList<Integer>();
		
		boolean play = true;
		
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
			for(int y = 0; y < n; y++)
			{
				//add adjacency list
				graph.add(new ArrayList<String>());
				//add current vertex to first slot of current adjacency list
				graph.get(y).add((Integer.toString( (y+1) )));
			}
			
			//build edges
				//walk through number of edges
			for(int y = 0; y < edges; y++)
			{
				//if locklist needs to be used
					//y is less than half the size of locklist AND there is at least one locked edge
				if( y < (locklist.size()/2) && locklist.size() > 0)
				{
					//if normal progression wouldn't cause an error out of bounds exception
					if( locklist.get((y*2)+1) < n )
					{
						//construct edge
						graph.get(locklist.get(y*2)).add((Integer.toString((locklist.get((y*2)+1)+1))));
						graph.get(locklist.get((y*2)+1)).add((Integer.toString((locklist.get(y*2)+1))));
					}
					
					
					//increment edges placed in graph
					edgecounter++;
					
					//vertexcounter = locklist.get(y*2);
					//vertextarget = (locklist.get(y*2)+1) + 1;
					
				}
				//else if no loop would be created AND there is room for another edge
				else if( (vertexcounter != vertextarget) && edgecounter < edges )
				{
					//construct edge
					graph.get(vertexcounter).add((Integer.toString((vertextarget+1))));
					graph.get(vertextarget).add((Integer.toString((vertexcounter+1))));
					//increment edges placed in graph
					edgecounter++;
					
					//if locks apply
					if( edges > 1 )
					{
						//if lock is secured on appropriate edges
						if( (locklist.size()/2) == locknumber )
						{
							//increment tracker for edges made with current lock
							locktracker++;
						}
					
						//if locktracker has reached locklimit
						if( locktracker == locklimit && locklist.size() > 0 )
						{
							
							//does not account for resetting multiple locks
							
							
							//if vertextarget would be in bounds if incrememented
							if( locklist.get(locklist.size()-1) + 1 < n )
							{
								//set vertextarget to last locked element of locklist
								vertextarget = locklist.get(locklist.size()-1) + 1;
								locklist.remove(locklist.size()-1);
								//set vertexcounter to last locked element of locklist
								vertexcounter = locklist.get(locklist.size()-1);
								locklist.remove(locklist.size()-1);
								
								
							}
							//vertextarget would be out of bounds if incremented
								//locks need to be reduced for reset later
							else
							{
								//for(int z = 0; z < locknumber; z++)
								//{
									//ditch locked vertextarget
									locklist.remove(locklist.size()-1);
									//set vertexcounter to last locked element of locklist incremented
									vertexcounter = locklist.get(locklist.size()-1) + 1;
									locklist.remove(locklist.size()-1);
									//adjust vertexcounter accordingly
									vertextarget = vertexcounter + 1;
								//}
							}
							
							
							//if locklimit is not zero
							if( locklimit > 0 )
							{
								//restart locktracker
								locktracker = 0;
							}
							else
							{
								//increase locklimit based on lockmodifer
								locklimit = (e-locknumber) - lockmodifier;
								lockmodifier++;
							}
							
							//reduce locklimit
							locklimit--;
							
						}
					
			//currently locks the next edge to be constructed
						
						//if there is room to lock a new edge
						if( (locklist.size()/2) < (locknumber) )
						{
							locklist.add(vertexcounter);
							locklist.add(vertextarget);
						}
					}
					
					//increment vertextarget after constructing an edge
					vertextarget++;
					
				}
				
				
				//loop checker
				if( vertexcounter == vertextarget )
				{
					vertextarget++;
				}
				
				//boundary checking
				if( vertextarget >= n )
				{
					//vertextarget = 0;
					vertexcounter++;
					if( vertexcounter >= n )
					{
						vertexcounter = 0;
						vertextarget = 1;
					}
					vertextarget = vertexcounter + 1;
					
					//boundary checking
					if( vertextarget >= n )
					{
						vertextarget = 0;
					}
				}
			}
			
			
			
			System.out.println("Graph: " + (x+1));
			System.out.println("Edges in graph: " + edges);
			//display graph
				//walk through vertices
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
			
			
			//mark graph creation
			graphcounter++;
			
			//if all graphs are made for current edges
			if( graphcounter == choose(e, edges) )
			{
				edges++;
				
				//if there will be more than 1 edge in graph
				if( edges > 1 )
				{
					//declare number of edges to lock
					locknumber = edges - 1;
					//restart lockmodifier
					lockmodifier = 0;
					
					//if edges is in the lower half of edge sets
					if( edges <= (e/2) )
					{
						locklimit = e-(edges-1);
					}
					//otherwise is in the upper half of the edge sets
					else
					{
						locklimit = e-(edges-1);
					}
					//clear the locklist
					locklist.clear();
				}
				
				
				
				//reset the counter for how many graphs have been made for current number of edges
				graphcounter = 0;
				
				vertexcounter = 0;
				vertextarget = 1;
				
			}
			//vertexcounter++;
			
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
