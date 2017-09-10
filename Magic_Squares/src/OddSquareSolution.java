import java.util.ArrayList;

public class OddSquareSolution 
{
	
	public static void main(String[] args) 
	{
		ArrayList<Integer> dataSet = new ArrayList<Integer>();
		
		ArrayList<Integer> solutionSet = new ArrayList<Integer>();
		
		int root = 4;
		
		int Limit = (int) Math.pow(root,2); //this must be an odd square number
		int matches = factorial(Limit);
		
		int tracker = 0;
		int tempSum = 0;
		int offSet = 0;
		boolean result = false;
		
		//assign square
		for(int x = 0; x < Limit; x++)
		{
			dataSet.add(x+1);
		}
		
		mainLoop:
		for(int z = 0; z < matches; z++)
		{
			solutionSet.clear();
			//if(trip)
			//{
				//trip = false;
			dataSet = bruteAdvance(dataSet, z);
			//}
			
			tempSum = 0;
			offSet = 0;
			//sum horizontally
			for(int y = 0; y < root; y++)
			{
				for(int x = 0; x < root; x++)
				{
					tempSum += dataSet.get(x+offSet);
				}
				solutionSet.add(new Integer(tempSum));
				tempSum = 0;
				offSet += root;
			}
	
			offSet = 0;
			//sum vertically
			for(int y = 0; y < root; y++)
			{
				for(int x = 0; x < root; x++)
				{
					tempSum += dataSet.get(y+offSet);
					offSet += root;
				}
				solutionSet.add(new Integer(tempSum));
				tempSum = 0;
				offSet = 0;
			}
			
			offSet += root+1;
			//sum diagonal, left to right
			for(int y = 0; y < Limit; y+=offSet)
			{
				tempSum += dataSet.get(y);
			}
			solutionSet.add(new Integer(tempSum));
			tempSum = 0;
			
			offSet = 0;
			offSet += root-1;
			//sum diagonal, right to left
			for(int y = 2; y < Limit-offSet; y+=offSet)
			{
				
				tempSum += dataSet.get(y);
				
			
			}
			solutionSet.add(new Integer(tempSum));
			tempSum = 0;
			
			tempSum = solutionSet.get(0);
			for(int x = 1; x < solutionSet.size(); x++)
			{
				if(solutionSet.get(x) != tempSum)
				{
					//trip = true;
					continue mainLoop;
				}
			}
			result = true;
			break mainLoop;
			
		}
		
		
		
		tempSum = 0;
		tracker = 0;
		offSet = 0;
		//output
		if( result)
		{
			for(int y = 0; y < root; y++)
			{
				//System.out.print("\t");
				for(int x = 0; x < root; x++)
				{
					System.out.print("\t");
					System.out.print(Integer.toString(dataSet.get(x+offSet)));
				}
				System.out.print("\t");
				System.out.print("=");
				System.out.print(Integer.toString(solutionSet.get(y)));
				System.out.print("\n");
				offSet += root;
			}
			
			System.out.print("=");
			System.out.print(Integer.toString(solutionSet.get(root*2+1)));
					
			for(tracker = root; tracker < solutionSet.size()-2; tracker++)
			{
				System.out.print("\t");
				System.out.print("=");
				System.out.print(Integer.toString(solutionSet.get(tracker)));
				
			}
			
			System.out.print("\t");
			System.out.print("=");
			System.out.print(Integer.toString(solutionSet.get(root*2)));
		}
		else
		{
			System.out.print("no available solution set found.");
		}
	}
	
	public static int factorial(int input)
	{
		int output = 1;
		
		for(int x = input; x > 0; x--)
		{
			output *= x;
		}
		
		return output;
	}
	
	public static ArrayList<Integer> bruteAdvance(ArrayList<Integer> input, int iteration)
	{
		//skip through the previous zth permutations, then advance once
		
		if(iteration == 0 || input.size() < 2)
		{
			return input;
		}
		
		ArrayList<Integer> output = new ArrayList<Integer>(input);
		int remainingPushes = iteration + 1;
		ArrayList<Integer> offSets = new ArrayList<Integer>();
		//ArrayList<Integer> pushTrackers = new ArrayList<Integer>();
		//ArrayList<Integer> pushLimits = new ArrayList<Integer>();
		int[] pushTrackers = new int[input.size()];
		int[] pushLimits = new int[input.size()];
		
		
		int offSet = 2;
		int target = input.size()-offSet;
		//int pushTracker = 0;
		
		
		for(int x = 0; x < input.size(); x++)
		{
			pushTrackers[x] = 0;
			pushLimits[x] = x+1;
		}
		
		//pivot: mod 10 check from 2 to N
			//if divisible by x (to N), then apply respective push
		
		for(int x = 0; x <= remainingPushes; x++)
		{
			if(x == remainingPushes)
			{
				output = pushElement(output, target);
			}
			pushTrackers[1]++;
			
			if(pushTrackers[1] == pushLimits[1])
			{
				pushTrackers[1] = 0;
				for(int y = 2; y < pushLimits.length; y++)
				{
					if(pushTrackers[y] == pushLimits[y])
					{
						pushTrackers[y] = 0; //restart counter
						continue;
					}
					else
					{
						if(x == remainingPushes)
						{
							output = pushElement(output, output.size()-y-1);
						}
						pushTrackers[y]++;
						if(pushTrackers[y] == pushLimits[y])
						{
							pushTrackers[y] = 0; //restart counter
							continue;
						}
						else
						{
							break;
						}
					}
				}
			}
		}
		
		
		return output;
	}
	
	public static ArrayList<Integer> sortAdvance(ArrayList<Integer> input, int iteration)
	{
		//walk through permutations until the zth one is found
		
		if(iteration == 0 || input.size() < 2)
		{
			return input;
		}
		
		ArrayList<Integer> output = new ArrayList<Integer>(sortListB(input));
		int remainingPushes = iteration;
		ArrayList<Integer> offSets = new ArrayList<Integer>();
		//ArrayList<Integer> pushTrackers = new ArrayList<Integer>();
		//ArrayList<Integer> pushLimits = new ArrayList<Integer>();
		int[] pushTrackers = new int[input.size()];
		int[] pushLimits = new int[input.size()];
		
		
		int offSet = 2;
		int target = input.size()-offSet;
		//int pushTracker = 0;
		
		
		for(int x = 0; x < input.size(); x++)
		{
			pushTrackers[x] = 0;
			pushLimits[x] = x+1;
		}
		
		
		for(int x = 0; x < remainingPushes; x++)
		{
			output = pushElement(output, target);
			pushTrackers[1]++;
			
			if(pushTrackers[1] == pushLimits[1])
			{
				pushTrackers[1] = 0;
				for(int y = 2; y < pushLimits.length; y++)
				{
					if(pushTrackers[y] == pushLimits[y])
					{
						pushTrackers[y] = 0; //restart counter
						continue;
					}
					else
					{
						output = pushElement(output, output.size()-y-1);
						pushTrackers[y]++;
						if(pushTrackers[y] == pushLimits[y])
						{
							pushTrackers[y] = 0; //restart counter
							continue;
						}
						else
						{
							break;
						}
					}
				}
			}
		}
		
		
		return output;
	}
	
	public static ArrayList<Integer> pushElement(ArrayList<Integer> input, int target)
	{
		ArrayList<Integer> output = new ArrayList<Integer>(input);
		
		output.add(output.get(target)); //add to end
		output.remove(target); //remove from index
		
		return output;
	}
	
	public static ArrayList<Integer> sortListB(ArrayList<Integer> input)
	{
		ArrayList<Integer> output = new ArrayList<Integer>();
		int tempHolder = input.get(0);
		int tempAdd = 0;
		
		output.add(input.get(0));
		
		mainloop:
		for(int y = 1; y < input.size(); y++)
		{
			tempHolder = input.get(y);
			
			for(int x = 0; x < output.size(); x++)
			{
				if(tempHolder < output.get(x))
				{
					output.add((x), tempHolder);
					continue mainloop;
				}
			}
			output.add(tempHolder);
		}
		
		return output;
	}
	
	public static ArrayList<Integer> sortList(ArrayList<Integer> input)
	{
		ArrayList<Integer> output = new ArrayList<Integer>();
		int tempHolder = input.get(0);
		int tempAdd = 0;
		
		for(int y = 0; y < input.size(); y++)
		{
			tempHolder = input.get(y);
			
			for(int x = y; x < input.size(); x++)
			{
				if(input.get(x) < tempHolder)
				{
					tempHolder = input.get(x);
					
					tempAdd = input.get(y);
					input.add(tempAdd);
					input.remove(y);
					y--;
					continue;
				}
			}
			output.add(tempHolder);
			
			
			
		}
		
		return output;
	}
	
	
	public static ArrayList<Integer> advance(ArrayList<Integer> input, int iteration)
	{
		if(iteration == 0)
		{
			return input;
		}
		
		ArrayList<Integer> output = new ArrayList<Integer>(input);
		int tempHolder = 0;
		
		//check contiguous order
		tempHolder = output.get(0);
		for(int x = 1; x < output.size(); x++)
		{
			if(tempHolder+1 == output.get(x))
			{
				if(x == output.size()-1) //if all are in order
				{
					//flip the last two
					output.add(output.get(x-1));
					output.remove(x-1);
					break;
				}
				continue;
			}
		}
		
		
		return output;
	}

}
