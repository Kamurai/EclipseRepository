package orderedgraphcreation;

import java.util.ArrayList;

public class BitGraph 
{
	ArrayList<Boolean> edgeset = new ArrayList<Boolean>();
	long number = 0;
	
	public BitGraph(long input)
	{
		number = input;
		edgeset = generate(input);
	}
	
	public ArrayList<Boolean> generate(long input)
	{
		//power result variable
		long carrier = 0;
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
						edgeset.add(true);
					}
					else
					{
						edgeset.add(false);
					}
			}
			
		}
		
		return edgeset;
	}
	
	public void display()
	{
		//output the number being represented
		System.out.println( "Number represented: " + number );
		//output the number of edges in currently displayed graph
		System.out.println( "Edges in graph: " + edgeset.size() );
		
		//display graph
			//walk through possible edges
		for(int y = 0; y < edgeset.size(); y++)
		{
			if(edgeset.get(y))
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
