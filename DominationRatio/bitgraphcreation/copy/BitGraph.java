package bitgraphcreation.copy;

import java.util.ArrayList;

public class BitGraph 
{
	//ArrayList<Boolean> edgeset = new ArrayList<Boolean>();
	boolean[] edgeset;// = new boolean[55];
	long number = 0;
	//long vertices =0;
	
	boolean[][] matrix;
	
	public BitGraph(long input, int range)
	{
		number = input;
		edgeset = new boolean[getlimit(input, range)];
		edgeset = generate(input);
		matrix = convert(edgeset);
	}
	
	private static int getvertices(boolean[] input)
	{
		int hit = 0;
		
		int a = 0;
		int b = 1;
		
		//walkthrough edgeset
		for(int x = 0; x < input.length; x++)
		{
			if( input[x] )
			{
				hit = b;
			}
			
			
			if( (b-a) == 1 )
			{
				a = 0;
				b++;
			}
			else
			{
				a++;
			}
		}
		
		
		
		
		
		
		return (hit+1);
	}
	
	//will convert edge based bitgraph to a vertex based 2d array
	public boolean[][] convert( boolean[] input)
	{
		int a = 0;
		int b = 1;
		
		int vertices = getvertices(input);
		
		boolean[][] output = new boolean[vertices][vertices];
		
		/*
		 * 5 vertices:
		 * 1-2, 1-3, 1-4, 1-5, 2-3, 2-4, 2-5, 3-4, 3-5, 4-5 OLD
		 * 1-2, 1-3, 2-3, 1-4, 2-4, 3-4, 1-5, 2-5, 3-5, 4-5 NEW
		 */
		
		//walkthrough edgeset
		for(int x = 0; x < input.length; x++)
		{
			if( input[x] )
			{
				output[a][b] = true;
				output[b][a] = true;
			}
			
			
			if( (b-a) == 1 )
			{
				a = 0;
				b++;
			}
			else
			{
				a++;
			}
		}
		
		return output;
	}
	
	public int getlimit(long input, int range)
	{
		int num = 0;
		
		//walkthrough 0 to 55
		for(int x = 0; x < 56; x++)
		{
			//if power of 2 is less than given number
			if( Math.pow(2, x) <= input )
			{
				//increase counter
					//this will be the realistic number of edges REQUIRED
				num++;
			}
			else
			{
				//escape
				x = 56;
			}
		}
		
		//determine how many edges should be represented (at minimum)
			//should match an x choose 2
		
		//if approximation is greater than range
		if( approximate(num) > range )
		{
			//use approximation
				//primary choice as all possible results should be an x choose 2
			return approximate(num);
		}
		//if approximation is smaller than desired range
			//check counter against range
		//if edges countered is less than the desired range
		else if( num < range )
		{
			//use desired range
			return approximate(range);
		}
		//if range is smaller than counted edges
		
		
		//use edges counted (edges REQUIRED to represent the number in binary)
		return num;
	}
	
	private static int approximate(int number)
	{
		int hit = 0;
		//determine nearest x choose 2 approximation
		
		// 1 choose 2 =  0		+ 0
		// 2 choose 2 =  1		+ 1
		// 3 choose 2 =  3		+ 2
		// 4 choose 2 =  6		+ 3
		// 5 choose 2 = 10		+ 4
		// 6 choose 2 = 15		+ 5
		// 7 choose 2 = 21		+ 6
		// 8 choose 2 = 28		+ 7
		// 9 choose 2 = 36		+ 8
		//10 choose 2 = 45		+ 9
		//11 choose 2 = 55		+10
		//a(x) = a(x-1) + (x-1)
		
		for(int x = 1; x < 12; x++)
		{
			//determine current x choose 2
			hit = (int) choose(x, 2);
			
			//if current x choose 2 is greater than number
			if( hit >= number )
			{
				//return the first hit greater than input number
				return hit;
			}
			
			
			
		}
		
		
		//base case
		/*if( number == 1)
		{
			return 0;
		}
		else
		{
			hit = approximate(number-1) + (number-1);
		}*/
		
		
		return hit;
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
		
		
		
		
		
		//return (factorial(n) / (factorial(k) * factorial(n-k)));
		
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
	
	private boolean[] generate(long input)//ArrayList<Boolean> generate(long input)
	{
		//power result variable
		//long carrier = 0;
		boolean trip = false;
		
		//walk through possible powers of 2
		for(int x = 55; x >= 0; x--)
		{
			//determine if generation should begin
				//if input is greater than or equal to 2^x AND trip is false
			if( input >= Math.pow(2, x) && !trip)
			{
				//then begin to extract numbers for binary equivalency
					//set trip to true
				trip = true;
			}
			
			//if trip is true
			if( trip )
			{
					//if input is greater than or equal 2^x
					if( input >= Math.pow(2, x) )
					{
						//then extract 2^x from input
						input -= Math.pow(2, x);
						//edgeset.add(true);
						edgeset[x] = true;
					}
					else
					{
						//edgeset.add(false);
					}
			}
			
		}
		
		return edgeset;
	}
	
	public void displayedgeset()
	{
		//output the number being represented
		System.out.println( "Number represented: " + number );
		//output the number of edges in currently displayed graph
		System.out.println( "Edges in graph: " + edgeset.length );
		
		//display graph
			//walk through possible edges
		for(int y = 0; y < edgeset.length; y++)
		{
			if(edgeset[y])
			{
				System.out.print("1, ");
			}
			else
			{
				System.out.print("0, ");
		
			}
			
		}
		System.out.println("\n");
		
	}
	
	public void displaymatrix()
	{
		//output the number being represented
		System.out.println( "Number represented: " + number );
		//output the number of edges in currently displayed graph
		System.out.println( "Vertices in graph: " + matrix.length );
		
		//display graph
			//walk through possible edges
		
		for(int x = 0; x < matrix.length; x++)
		{
			for(int y = 0; y < matrix.length; y++)
			{
				if(matrix[x][y])
				{
					System.out.print("1, ");
				}
				else
				{
					System.out.print("0, ");
		
				}
			
			}
			System.out.println("\n");
		}
		
	}
}
