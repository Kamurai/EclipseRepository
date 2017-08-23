package usanIDE;

import java.util.ArrayList;

public class DataManager 
{

	public DataManager()
	{
	}
	
	public ArrayList<ArrayList<Integer>> addToMasterWhole(ArrayList<ArrayList<Integer>> input, ArrayList<ArrayList<Integer>> master)
	{
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>(master);
		
		boolean check = true;
		int index = 0;
		int lastIndex = 0;

		if(output.size() == 0)
		{
			output = new ArrayList<ArrayList<Integer>>(input);
			
			return output;
		}
		
		for(int x = 0; x < input.size(); x++)
		{
			check = true;
			//pre check: determine beginning, middle, or end placement
			if( input.get(x).get(0) < output.get(0).get(0) )
			{
				//add to beginning
				index = 0;
			}
			else if( input.get(x).get(0) > output.get(output.size()-1).get(0) )
			{
				//add to end
				index = output.size();
			}
			else
			{
				for( int y = lastIndex; y < output.size(); y++)
				{
					if( (input.get(x).get(0) < output.get(index).get(0)) && ((input.get(x).get(0) > output.get(index-1).get(0))))
					{
						//add in place of current index
						//output.add((index),new ArrayList<Integer>(input));
						break;
					}
					//duplicate entry
					else if(input.get(x).get(0) == output.get(index).get(0))
					{
						check = false;
						break;
					}
					else
					{
						break;
					}
				}
			}
			
			if(check)
			{
				//check: determine if addition is valid (is not overwriting a previous target)
				if(index != 0)
				{	if(input.get(x).get(0) >= output.get(index-1).get(0))
					{
						if(input.get(x).get(0) <= output.get(index-1).get(1))
						{
							break;
						}
					}
				}
				else if(input.get(x).get(0) >= output.get(index).get(0))
				{
					if(input.get(x).get(0) <= output.get(index).get(1))
					{
						break;
					}
				}
			}
			else
			{
				break;
			}
			
			output.add(index, input.get(x));
			lastIndex = index;
			
		}
		
		return output;
	}
	
	public ArrayList<ArrayList<Integer>> addToMasterBinary(ArrayList<Integer> input, ArrayList<ArrayList<Integer>> master)
	{
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>(master);
		
		boolean drive = true;
		int index = (master.size()/2);
		int range = (index/2);
		int lastIndex = index;

		if(output.size() == 0)
		{
			output.add(input);
			
			return output;
		}
		
		//pre check: determine beginning, middle, or end placement
		if( input.get(0) < output.get(0).get(0) )
		{
			//add to beginning
			index = 0;
		}
		else if( input.get(0) > output.get(output.size()-1).get(0) )
		{
			//add to end
			index = output.size();
		}
		else
		{
			while( drive == true && ((index != 0) && (index !=output.size())))
			{
				if( (input.get(0) < output.get(index).get(0)) && ((input.get(0) > output.get(index-1).get(0))))
				{
					//add in place of current index
					//output.add((index),new ArrayList<Integer>(input));
					drive = false;
					break;
				}
				else if( input.get(0) > output.get(index).get(0))
				{
					lastIndex = index;
					index = index+range;
					range = (range/2);
				}
				else if( input.get(0) < output.get(index-1).get(0))
				{
					lastIndex = index;
					index = index-range;
					range = (range/2);
					
				}
				//duplicate entry
				else if(input.get(0) == output.get(index).get(0))
				{
					return output;
				}
				else
				{
					break;
				}
				
				if(range == 0)
				{
					range = 1;
				}
				
					
			}	
		}
		
		//check: determine if addition is valid (is not overwriting a previous target)
		if(index != 0)
		{	if(input.get(0) >= output.get(index-1).get(0))
			{
				if(input.get(0) <= output.get(index-1).get(1))
				{
					return output;
				}
			}
		}
		else if(input.get(0) >= output.get(index).get(0))
		{
			if(input.get(0) <= output.get(index).get(1))
			{
				return output;
			}
		}

		output.add(index,input);
		return output;
	}
	
	
	//an addToMaster method should be created to prevent managing large data and minimize the size of the eventual large data
	public ArrayList<ArrayList<Integer>> addToMaster(ArrayList<Integer> input, ArrayList<ArrayList<Integer>> master)
	{
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>(master);
		
		boolean drive = true;
		int index = (master.size()/2);
		int range = (index/2);
		int lastIndex = index;

		int targetValue = input.get(0);
		int lowestValue = 0;
		int midValue = 0;
		int highestValue = 0;
		
		int highestDiff = 0;
		int midDiff =0;
		int lowestDiff = 0;

		if(output.size() == 0)
		{
			output.add(input);
			
			return output;
		}
		
		//pre check: determine beginning, middle, or end placement
		if( input.get(0) < output.get(0).get(0) )
		{
			//add to beginning
			index = 0;
		}
		else if( input.get(0) > output.get(output.size()-1).get(0) )
		{
			//add to end
			index = output.size();
		}
		else
		{
			lowestValue =output.get(0).get(0);
			midValue =output.get((output.size()/2)).get(0);
			highestValue =output.get(output.size()-1).get(0);
			
			highestDiff = Math.abs(highestValue-targetValue);
			midDiff = Math.abs(midValue-targetValue);
			lowestDiff = Math.abs(lowestValue-targetValue);
			
			if( highestDiff < midDiff)
			{
				index = output.size()-2;
			}
			else if( lowestDiff < midDiff)
			{
				index = 1;
			}
			
			
			while( drive == true && ((index != 0) && (index !=output.size())))
			{
				if( (input.get(0) < output.get(index).get(0)) && ((input.get(0) > output.get(index-1).get(0))))
				{
					//add in place of current index
					//output.add((index),new ArrayList<Integer>(input));
					drive = false;
					break;
				}
				else if( input.get(0) > output.get(index).get(0))
				{
					index++;	
				}
				else if( input.get(0) < output.get(index-1).get(0))
				{
					index--;
				}
				//duplicate entry
				else if(input.get(0) == output.get(index).get(0))
				{
					return output;
				}
				else
				{
					break;
				}
			}	
		}
		
		//check: determine if addition is valid (is not overwriting a previous target)
		if(index != 0)
		{	if(input.get(0) >= output.get(index-1).get(0))
			{
				if(input.get(0) <= output.get(index-1).get(1))
				{
					return output;
				}
			}
		}
		else if(input.get(0) >= output.get(index).get(0))
		{
			if(input.get(0) <= output.get(index).get(1))
			{
				return output;
			}
		}

		output.add(index,input);
		return output;
	}
	
	
	public ArrayList<ArrayList<Integer>> SortMasterLocations(ArrayList<ArrayList<Integer>> input)
	{
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		
		output.add(new ArrayList<Integer>(input.get(0)));
		
		for(int x = 1; x < input.size(); x++)
		{
			
			if( input.get(x).get(0) < output.get(0).get(0) )
			{
				//add to beginning
				output.add(0,new ArrayList<Integer>(input.get(x)));
			}
			else if( input.get(x).get(0) > output.get(output.size()-1).get(0) )
			{
				//add to beginning
				output.add(output.size(),new ArrayList<Integer>(input.get(x)));
			}
			else
			{
				for(int y = 0; y < output.size(); y++)
				{
					if( input.get(x).get(0) < output.get(y).get(0) )
					{
						//add in place of current index
						output.add((y),new ArrayList<Integer>(input.get(x)));
						break;
					}
				}
			}
		}
		
		return output;
	}
	
	public ArrayList<ArrayList<Integer>> RemoveMasterOverlaps(ArrayList<ArrayList<Integer>> input)
	{
		//!!! This requires that the input be sorted....
		//sort master by starting points
		
		ArrayList<ArrayList<Integer>> output = SortMasterLocations(input);
		//ArrayList<ArrayList<Integer>> temp = SortMasterLocations(input);  //pivot?
		
		//evaluate each starting point to see if it is in range of the previous' start and end
		//this does not include the first
		for( int x = 1; x < output.size(); x++)
		{
			//remove rows that include overlapping highlights
			if((output.get(x).get(0) >= output.get(x-1).get(0)) && (output.get(x).get(0) <= output.get(x-1).get(1)))
			{
				output.remove(x);
				x--;
			}
		}
		
		return output;
	}
}
