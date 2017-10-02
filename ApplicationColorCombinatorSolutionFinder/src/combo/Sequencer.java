package combo;

import java.util.ArrayList;
import java.util.Collections;

public class Sequencer 
{
	static int RowLimit = 9;
	static int ColumnLimit = 30;
	int NumberLimit = 2;
	static int Numbers = 5;
	static int Colors = 6;
	static int Choices = 3;
	static int RowDuplicates = 2;
	static int ColumnDuplicates = 2;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//System.out.println("Sequence has begun");
		
		//System.out.println("Finding Color Combos");
		//Find an matrix that represents possible combinations of a number of choices of a number of colors 
		ArrayList<ArrayList<Integer>> Combos= SetColorMatrix(Choices, Colors, RowDuplicates, RowLimit);
		System.out.println("Color Combos Found" + "\n");
		
		//System.out.println("Finding Solution");
		//Find a matrix comprised of combinations of the elements of the Combos matrix
		ArrayList<ArrayList<Integer>> Solution = SetSolutionMatrix(Combos, ColumnDuplicates, ColumnLimit);
		System.out.println("Solution Found" + "\n");
		
		//Print Solution
		PrintArray(Solution);
		System.out.println("Sequence has completed" + "\n");		
	}
	
	static ArrayList<ArrayList<Integer>> SetColorMatrix(int Choices, int Colors, int RowDuplicates, int RowLimit)
	{
		//Choices: Number of non-zero digits in the combination: e.g. 3, 102030 
		//Colors: Number of digits in the combination: e.g. 123456
		//RowDuplicates: Number of duplicates for any digit
		//RowLimit: Ideal sum of the row
		int Tracker = 0;
		int Limit = 1;
		int Target = 1;
		
		ArrayList<ArrayList<Integer>> Result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> Sub = new ArrayList<Integer>();
		
		for(int x = 0; x < Colors; x++)
		{
			Sub.add(0);
		}
		
		while( Tracker < Sub.size() )
		{
			Sub.set(Tracker, Sub.get(Tracker)+1);
			
			while(Sub.get(Tracker) > 5)
			{
				Sub.set(Tracker, 0);
				Tracker++;
				if(Tracker < Sub.size())
				{
					Sub.set(Tracker, Sub.get(Tracker)+1);
				}
				
				
			}
			
			if(Tracker == Limit)
			{
				Tracker = 0;
				Limit = 1;
			}
			else if(Tracker > Limit)
			{
				Tracker = 0;
				Limit = 1;
				Target++;
			}
			
			
			if( Collections.frequency(Sub,5) == 6)
			{
				System.out.print("Bingo" + "\n");
				break;
			}
			
		
			
			//Evaluate
			//if sum of row is equal to RowLimit
			if( SumSingleRow(Sub) == RowLimit )
			{
				//if number of zeros is correct
				if( Collections.frequency(Sub,0) == (Colors-Choices))
				{
					//if number of duplicates is correct
					for(int x = 1; x <= 5; x++)
					{
						if( Collections.frequency(Sub,x) > RowDuplicates)
						{
							break;
						}
						
						if( x == Sub.size()-1)
						{
							Result.add(new ArrayList<Integer>(Sub));
						}
					}
					
				}
			}			
		}
		
		return Result;
	}
	
	static ArrayList<ArrayList<Integer>> SetSolutionMatrix(ArrayList<ArrayList<Integer>> Combos, int ColumnDuplicates, int ColumnLimit)
	{
		ArrayList<Integer> Sub = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> Result = new ArrayList<ArrayList<Integer>>();
		int SolutionTracker = 0;
		int ComboTracker = 1;
		int Limit = 1;
		int Target = 1;
		
		/*
		 * The goal is to produce a matrix of 20 (arbitrary) rows comprised of the given combo set.
		 * 
		 * The sub matrix will contain only the indices of the combo matrix, but will be used to
		 * built the solution matrix itself.
		*/
		//Initialize the sub matrix
		for(int x = 0; x < 20; x++)  //There are 20 permutations where each number (1-5) appears in a column
		{
			Sub.add(0);
		}
		
		//while we have not walked through all possible solutions
		while( SolutionTracker < Sub.size() )
		{
			Result.clear();
			//build a solution
			for(int x = 0; x < Sub.size(); x++)
			{
				Result.add(new ArrayList<Integer>(Combos.get(Sub.get(x))));
			}
			
			//Evaluate the built solution
			//walk through columns
			for(int x = 0; x < Result.get(0).size(); x++)
			{
				//check each column for total
				if(SumColumn(Result, x) == 30)
				{
					for(int y = 1; y <= 5; y++)
					{
						//check each column for duplicates
						if(CheckColumnDuplicates(Result,x,y) > ColumnLimit)
						{
							break; //stop checking
						}
					}
				}
				else
				{
					break; //stop checking
				}
			}
			
			/*
			 * if(x == targetx && y == targety)
			{
				limitx = 0; //1;
				limity = 0;
			}
			else if(((x > targetx && y == targety) || ( x == 0 && y > targety) ) )
			{
				limitx = 0; //1;
				limity = 0;
				
				targetx++;
				if(targetx == result.get(y).size())
				{
					targetx = 0;
					targety++;
				}
			}
			
			if(x == limitx && y == limity)
			{
				x = 0;
				y = 0;
				
				limitx = 0; //1;
				limity = 0;
				
			}
			else if((x > limitx && y >= limity) || ( x == 0 && y > limity) )
			{
				x = 0;
				y = 0;
				
				limitx++;
				if(limitx == result.get(y).size())
				{
					limitx = 0;
					limity++;
				}
			}
			 */
			
			//if limit reaches target
			if(Limit == Target)
			{
				Limit = 0;
			}
			else if(SolutionTracker > Target)
			{
				Limit = 0;
				
				Target++;
				if(Target > Sub.size())
				{
					System.out.print("Bingo" + "\n");
					return Result;
				}
			}
			
			//if tracker meets the current limit
			if(SolutionTracker == Limit)
			{
				//reset the limit to 1
				SolutionTracker = 0;
				Limit = 1;
			}
			//if the tracker exceeds the 
			else if(SolutionTracker > Limit)
			{
				SolutionTracker = 0;
				//ComboTracker = 1;
				//Limit = 1;
				//Target++;
				Limit++;
			}		
			
			//proceed to next combo for the solution
			Sub.set(SolutionTracker, Sub.get(SolutionTracker)+1);
			//if we have tried the last combo
			while(Sub.get(SolutionTracker) >= Combos.size())
			{
				//then reset combos
				Sub.set(SolutionTracker, 0);
				//move to the next row of the solution
				SolutionTracker++;
				//proceed to next combo for the solution
				Sub.set(SolutionTracker, Sub.get(SolutionTracker)+1);
			}

			if( SolutionTracker > Sub.size() )
			{
				System.out.print("Bingo" + "\n");
				return Result;
			}
		}
		return Result;
	}
	
	
	static ArrayList<ArrayList<Integer>> ColorCombos(int Colors, int Choices, int Permutations)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		
		int z = 0;
		
		for(int y = 0; y < Permutations; y++)
		{
			for(int x = 0; x < Choices; x++)
			{
				if(y == 0)
				{
					result.get(y).set(x, z);
					z++;
				}
				else
				{
					result.get(y).set(x, result.get(y-1).get(x));
					
					if(x == Choices-1)
					{
						result.get(y).set(x, result.get(y).get(x)+1);
						//if(y < Permutations-1)
						{
							if(result.get(y).get(x) >= Colors)
							{
								result.get(y).set(x-1, result.get(y-1).get(x-1) + 1);
								if(result.get(y).get(x-1) == result.get(y).get(x)-1)
								{
									result.get(y).set(x-2, result.get(y).get(x-2) + 1);
									result.get(y).set(x-1, result.get(y).get(x-2) + 1);
									result.get(y).set(x, result.get(y).get(x-1) + 1);
								}
								else
								{
									result.get(y).set(x, result.get(y).get(x-1) + 1);
								}
							}
						}
					}
					
					
				}
			}
		}
		
		
		return result;
	}
	
	static ArrayList<ArrayList<Integer>> MonkeyForce(ArrayList<ArrayList<Integer>> input, ArrayList<ArrayList<Integer>> Combos, int Colors)
	{
		ArrayList<ArrayList<Integer>> result = input;
		
		boolean Searching = true;
		int permutations = 0;
		
		int targetx = 1;
		int targety = 0;
		
		int limitx = 1;
		int limity = 0;
		
		int x = 0;
		int y = 0;
		
		while(Searching)
		{
			result.get(y).set(x, result.get(y).get(x)+1);
			while( result.get(y).get(x) == Colors)
			{
				result.get(y).set(x, 0);
				x++;
				if( x == result.get(y).size())
				{
					x = 0;
					y++;
				}
				result.get(y).set(x, result.get(y).get(x)+1);
			}	
			
			
			if(x == targetx && y == targety)
			{
				limitx = 0; //1;
				limity = 0;
			}
			else if(((x > targetx && y == targety) || ( x == 0 && y > targety) ) )
			{
				limitx = 0; //1;
				limity = 0;
				
				targetx++;
				if(targetx == result.get(y).size())
				{
					targetx = 0;
					targety++;
				}
			}
			
			if(x == limitx && y == limity)
			{
				x = 0;
				y = 0;
				
				limitx = 0; //1;
				limity = 0;
				
			}
			else if((x > limitx && y >= limity) || ( x == 0 && y > limity) )
			{
				x = 0;
				y = 0;
				
				limitx++;
				if(limitx == result.get(y).size())
				{
					limitx = 0;
					limity++;
				}
			}
			
			permutations++;
			if(result.get(0).get(0) == 5 && result.get(0).get(1) == 5 && result.get(0).get(2) == 5 && result.get(0).get(3) == 5 && result.get(0).get(4) == 5 && result.get(0).get(5) == 5 && result.get(1).get(0) == 5) //result[1][0] != 0 && (result[0][0] == 0 && result[0][1] == 0 && result[0][2] == 0 && result[0][3] == 0 && result[0][4] == 0 && result[0][5] == 0) )//(result[0][3] == 5 && result[0][4] == 5 && result[0][5] == 5) || (result[1][3] == 5 && result[1][4] == 5 && result[1][5] == 5) )
			{
				System.out.print(Integer.toString(permutations));
				System.out.print("\n");
			}
			System.out.println("Number of Permutation: " + Integer.toString(permutations));
			PrintArray(result);
			if(BruteCheck(result,Combos))
			{
				Searching = false;
				break;
			}
		}
		
		/*
		for(int y = 0; y < result.size(); y++)
		{
			for(int x = 0; x < result[y].size(); x++)
			{
				result[y][x]++;
				if(result.get(y).get(x) == Colors)
				{
					
				}
	
			}
		}
		*/
		
		return result;
	}
	
	static ArrayList<ArrayList<Integer>> Monkey(ArrayList<ArrayList<Integer>> input, ArrayList<ArrayList<Integer>> colortargets, ArrayList<ArrayList<Integer>> combos)
	{
		ArrayList<ArrayList<Integer>> result = input;
		int z = 0;
		int w = 0;
		
		for(int y = 0; y < colortargets.size(); y++)
		{
			for(int x = 0; x < colortargets.get(y).size(); x++)
			{
				result.get(y).set(colortargets.get(y).get(x), combos.get(z).get(w));
				w++;
				if(w >= combos.get(z).size())
				{
					w = 0;
				}
			}
			
			PrintArray(input);
			z++;
				if(z == 10)
				{
					z = 0;
				}
				
			if(Check(input, combos))
			{
				
			}
			else
			{
				//y--;
				w++;
				if(w >= combos.get(z).size())
				{
					w = 0;
					//y = 0;
				}
			}
		}
		
		
		
		/*
		//walk through permutations
		for(int x = 0; x < input.size(); x++)
		{
			//walk through colors
			for(int y = 0; y < input[x].size(); y++)
			{
				//determine number
				for(int z = 1; z <= Numbers; z++)
				{
					input[x][y] = z; //[Permutations][Colors]
					
					
					
					
					if(Check(input))
						break;
					else
						input[x][y] = 0;
				}
			}
		}
		*/
		
		
		return result;
	}
	
	static boolean BruteCheck(ArrayList<ArrayList<Integer>> input, ArrayList<ArrayList<Integer>> combos)
	{
		boolean result = true;
		int SumRow = 0;
		int SumColumn = 0;
		
		for(int x = 0; x < input.size(); x++)
		{
			SumRow = SumRow(input,x);
			if(SumRow != 9)
				return false;
			
			if(!CheckRowCombo(input,x,combos))
				return false;
		}
		
		for(int y = 0; y < input.get(0).size(); y++)
		{
			SumColumn = SumColumn(input,y);
			if(SumColumn != 30)
				return false;
			
			if(!CheckColumnCombo(input,y))
				return false;
		}
		
		
		
		return result;		
	}
	
	static boolean Check(ArrayList<ArrayList<Integer>> input, ArrayList<ArrayList<Integer>> combos)
	{
		boolean result = true;
		int SumRow = 0;
		int SumColumn = 0;
		
		for(int x = 0; x < input.size(); x++)
		{
			SumRow = SumRow(input,x);
			if(SumRow > RowLimit)
				return false;
			
			if(!CheckRowCombo(input,x,combos))
				return false;
		}
		
		for(int y = 0; y < input.get(0).size(); y++)
		{
			SumColumn = SumColumn(input,y);
			if(SumColumn > ColumnLimit)
				return false;
			
			if(!CheckColumnCombo(input,y))
				return false;
		}
		
		
		
		return result;		
	}
	static boolean CheckRowCombo(ArrayList<ArrayList<Integer>> input, int row, ArrayList<ArrayList<Integer>>combos)
	{
		boolean result = false;
		
		for(int x = 0; x < input.get(row).size(); x++)
		{
			if(input.get(row).get(x) != 0)
			{
				for(int y = 0; y < combos.size(); y++)
				{
					if(input.get(row).get(x) == combos.get(y).get(0))
					{
						for(int z = x; z < input.get(row).size(); z++)
						{
							if(input.get(row).get(z) != 0)
							{
								if(input.get(row).get(z) == combos.get(y).get(1))
								{
									for(int w = z; w < input.get(row).size(); w++)
									{
										if(input.get(row).get(w) != 0)
										{
											if(input.get(row).get(w) == combos.get(y).get(2))
											{
												return true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	static boolean CheckColumnCombo(ArrayList<ArrayList<Integer>> input, int Column)
	{
		boolean result = true;
		
		int[] tracker = new int[Numbers];
		
		int temp = 0;
		
		for(int y = 0; y < input.size(); y++)
		{
			temp = input.get(y).get(Column);
			if(temp != 0)
			{
				tracker[temp-1]++; //[Permutations][Colors]
				if(tracker[temp-1] > 2)
					return false;
			}
		}
		
		return result;
	}
	
	static int Permute(int Colors, int Choices)
	{
		int result = 0;
		int a = 0;
		int b = 0;
		
		int n = 0;
		int k = 0;
		int diff = 0;
		
		if( Colors < Choices)
		{
			a = Choices;
			b = Colors;
		}
		else
		{
			a = Colors;
			b = Choices;
		}
		
		n = Factorial(a);
		k = Factorial(b);
		diff = Factorial(a-b);
		
		result = n / (k * diff);
		
		return result;
	}
	
	static int Factorial(int input)
	{
		int result = 0;
		
		if( input < 0)
			return 0;
		else
		{
			result = input;
			for(int x = (input-1); x > 0; x--)
			{
				result = result * x;
			}
		}
		
		return result;
	}
	
	
	static int SumRow(ArrayList<ArrayList<Integer>> solution, int RowNum)
	{
		int result = 0;
		int columns = solution.get(0).size();
		
		result = solution.get(RowNum).get(0);
		
		for( int x = 1; x < columns; x++)
		{
			result += solution.get(RowNum).get(x); //[Permutations][Colors]
		}
	
		return result;
	}
	
	static int SumSingleRow(ArrayList<Integer> solution)
	{
		int result = 0;
		int columns = solution.size();
		
		result = solution.get(0);
		
		for( int x = 1; x < columns; x++)
		{
			result += solution.get(x); //[Permutations][Colors]
		}
	
		return result;
	}
	
	static int SumColumn(ArrayList<ArrayList<Integer>> solution, int ColNum)
	{
		int result = 0;
		int rows = solution.size();
		
		result = solution.get(0).get(ColNum);
		
		for( int x = 1; x < rows; x++)
		{
			result += solution.get(x).get(ColNum); //[Permutations][Colors]
		}

		return result;
	}
	
	static int CheckColumnDuplicates(ArrayList<ArrayList<Integer>> solution, int ColNum, int Target)
	{
		int result = 0;
		int rows = solution.size();
		
		result = solution.get(0).get(ColNum);
		
		for( int x = 1; x < rows; x++)
		{
			if(solution.get(x).get(ColNum) == Target)
			{
				result++;
			}
		}

		return result;
	}
	
	static int SumSingleColumn(ArrayList<Integer> solution, int ColNum)
	{
		int result = 0;
		int rows = solution.size();
		
		result = solution.get(ColNum);
		
		for( int x = 1; x < rows; x++)
		{
			result += solution.get(ColNum); //[Permutations][Colors]
		}

		return result;
	}
	
	static void PrintArray(ArrayList<ArrayList<Integer>> solution)
	{
		int temp = 0;
		
		for(int x = 0; x < solution.size(); x++)
		{
		
			for(int y = 0; y < solution.get(x).size(); y++)
			{
			
				System.out.print("  " + solution.get(x).get(y)); //[Permutations][Colors]
			}
			System.out.print("    ");
			System.out.println(Integer.toString(SumRow(solution,x)));
			
		}
		System.out.println();
		
		for(int y = 0; y < solution.get(0).size(); y++)
		{
			temp = SumColumn(solution,y);
			if(temp > 9)
			{
				System.out.print(" " + Integer.toString(temp));
			}
			else
			{
				System.out.print("  " + Integer.toString(temp));
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
	}
	
	
	
	
	

}
