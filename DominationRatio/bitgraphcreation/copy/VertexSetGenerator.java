package bitgraphcreation.copy;

import java.util.ArrayList;
import orderedgraphcreationarrays.BitGraph;


public class VertexSetGenerator 
{

	
	
	
	
	
	
	public static void main(String[] args) 
	{
		int testnumber = 7;
		//declare VertexSets
		VertexSetz bob = new VertexSetz(testnumber);
		
		int[][] master = bob.getMasterVertexSet();
		
		for( int x = 0; x < master.length; x++ )
		{
			for( int y = 0; y < master[x].length; y++ )
			{
				System.out.print( master[x][y] + ",");
			}
			
			System.out.println();
			
			
		}
		
		
		
	}
	
	
	
	
	
}
