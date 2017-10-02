package combo;

public class Sequencer 
{
	static int RowLimit = 9;
	static int ColumnLimit = 30;
	int NumberLimit = 2;
	static int Numbers = 5;
	static int Colors = 6;
	static int Choices = 3;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[][] combos;
		int[][] colorpairs;
		
		
		System.out.println("Sequence start");
		
		combos = new int[10][3];
		
		combos[0][0] = 1;
		combos[0][1] = 3;
		combos[0][2] = 5;
		
		combos[1][0] = 1;
		combos[1][1] = 4;
		combos[1][2] = 4;
		
		combos[2][0] = 2;
		combos[2][1] = 2;
		combos[2][2] = 5;
		
		combos[3][0] = 2;
		combos[3][1] = 3;
		combos[3][2] = 4;
		
		combos[4][0] = 3;
		combos[4][1] = 2;
		combos[4][2] = 4;
		
		combos[5][0] = 3;
		combos[5][1] = 1;
		combos[5][2] = 5;
		
		combos[6][0] = 4;
		combos[6][1] = 2;
		combos[6][2] = 3;
		
		combos[7][0] = 4;
		combos[7][1] = 1;
		combos[7][2] = 4;
		
		combos[8][0] = 5;
		combos[8][1] = 2;
		combos[8][2] = 2;
		
		combos[9][0] = 5;
		combos[9][1] = 1;
		combos[9][2] = 3;
		
		int Permutations = Permute(Colors,Choices);
		
		System.out.println("Number of permutations: " + Integer.toString(Permutations));
		int[][] Sample = new int[Permutations][Colors];
		
		colorpairs = ColorCombos(Colors,Choices,Permutations);
		
		PrintArray(Sample);
		System.out.println("Sequence initialiazed");
		System.out.println("Permutation initialiazed");
		
		//int[][] corny = combos;
		Sample = MonkeyForce(Sample,combos,Colors);
		PrintArray(Sample);
		
		System.out.println("Sequence complete");
		
	}
	
	static int[][] ColorCombos(int Colors, int Choices, int Permutations)
	{
		int[][] result = new int[Permutations][Choices];
		int z = 0;
		
		for(int y = 0; y < Permutations; y++)
		{
			for(int x = 0; x < Choices; x++)
			{
				if(y == 0)
				{
					result[y][x] = z;
					z++;
				}
				else
				{
					result[y][x] = result[y-1][x];
					
					if(x == Choices-1)
					{
						result[y][x]++;
						//if(y < Permutations-1)
						{
							if(result[y][x] >= Colors)
							{
								result[y][x-1] = result[y-1][x-1] + 1;
								if(result[y][x-1] == result[y][x]-1)
								{
									result[y][x-2]++;
									result[y][x-1] = result[y][x-2] + 1;
									result[y][x] = result[y][x-1] +1;
								}
								else
								{
									result[y][x] = result[y][x-1] + 1;
									
								}
							}
						}
					}
					
					
				}
			}
		}
		
		
		return result;
	}
	
	static int[][] MonkeyForce(int[][] input, int[][] Combos, int Colors)
	{
		int[][] result = input;
		
		boolean Searching = true;
		int permutations = 0;
		
		int targetx = 1;
		int targety = 0;
		
		int limitx = 1;
		int limity = 0;
		
		int x = 0;
		int y = 0;
		
		/*
		result[0][0] = 5;
		result[0][1] = 5;
		result[0][2] = 5;
		result[0][3] = 5;
		result[0][4] = 5;
		result[0][5] = 5;
		result[1][0] = 5;
		result[1][1] = 5;
		*/
		
		while(Searching)
		{
			result[y][x]++;
			while( result[y][x] == Colors)
			{
				result[y][x] = 0;
				x++;
				if( x == result[y].length)
				{
					x = 0;
					y++;
				}
				result[y][x]++;
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
				if(targetx == result[y].length)
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
				if(limitx == result[y].length)
				{
					limitx = 0;
					limity++;
				}
			}
			
			permutations++;
			if(result[0][0] == 5 && result[0][1] == 5 && result[0][2] == 5 && result[0][3] == 5 && result[0][4] == 5 && result[0][5] == 5 && result[1][0] == 5) //result[1][0] != 0 && (result[0][0] == 0 && result[0][1] == 0 && result[0][2] == 0 && result[0][3] == 0 && result[0][4] == 0 && result[0][5] == 0) )//(result[0][3] == 5 && result[0][4] == 5 && result[0][5] == 5) || (result[1][3] == 5 && result[1][4] == 5 && result[1][5] == 5) )
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
		for(int y = 0; y < result.length; y++)
		{
			for(int x = 0; x < result[y].length; x++)
			{
				result[y][x]++;
				if(result[y][x] == Colors)
				{
					
				}
	
			}
		}
		*/
		
		return result;
	}
	
	static int[][] Monkey(int[][] input, int[][] colortargets, int[][] combos)
	{
		int[][] result = input;
		int z = 0;
		int w = 0;
		
		for(int y = 0; y < colortargets.length; y++)
		{
			for(int x = 0; x < colortargets[y].length; x++)
			{
				result[y][colortargets[y][x]] = combos[z][w];
				w++;
				if(w >= combos[z].length)
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
				if(w >= combos[z].length)
				{
					w = 0;
					//y = 0;
				}
			}
		}
		
		
		
		/*
		//walk through permutations
		for(int x = 0; x < input.length; x++)
		{
			//walk through colors
			for(int y = 0; y < input[x].length; y++)
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
	
	static boolean BruteCheck(int[][] input, int[][] combos)
	{
		boolean result = true;
		int SumRow = 0;
		int SumColumn = 0;
		
		for(int x = 0; x < input.length; x++)
		{
			SumRow = SumRow(input,x);
			if(SumRow != 9)
				return false;
			
			if(!CheckRowCombo(input,x,combos))
				return false;
		}
		
		for(int y = 0; y < input[0].length; y++)
		{
			SumColumn = SumColumn(input,y);
			if(SumColumn != 30)
				return false;
			
			if(!CheckColumnCombo(input,y))
				return false;
		}
		
		
		
		return result;		
	}
	
	static boolean Check(int[][] input, int[][] combos)
	{
		boolean result = true;
		int SumRow = 0;
		int SumColumn = 0;
		
		for(int x = 0; x < input.length; x++)
		{
			SumRow = SumRow(input,x);
			if(SumRow > RowLimit)
				return false;
			
			if(!CheckRowCombo(input,x,combos))
				return false;
		}
		
		for(int y = 0; y < input[0].length; y++)
		{
			SumColumn = SumColumn(input,y);
			if(SumColumn > ColumnLimit)
				return false;
			
			if(!CheckColumnCombo(input,y))
				return false;
		}
		
		
		
		return result;		
	}
	static boolean CheckRowCombo(int[][] input, int row, int[][]combos)
	{
		boolean result = false;
		
		for(int x = 0; x < input[row].length; x++)
		{
			if(input[row][x] != 0)
			{
				for(int y = 0; y < combos.length; y++)
				{
					if(input[row][x] == combos[y][0])
					{
						for(int z = x; z < input[row].length; z++)
						{
							if(input[row][z] != 0)
							{
								if(input[row][z] == combos[y][1])
								{
									for(int w = z; w < input[row].length; w++)
									{
										if(input[row][w] != 0)
										{
											if(input[row][w] == combos[y][2])
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
	
	static boolean CheckColumnCombo(int[][] input, int Column)
	{
		boolean result = true;
		
		int[] tracker = new int[Numbers];
		
		int temp = 0;
		
		for(int y = 0; y < input.length; y++)
		{
			temp = input[y][Column];
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
	
	
	static int SumRow(int[][] input, int RowNum)
	{
		int result = 0;
		int columns = input[0].length;
		
		result = input[RowNum][0];
		
		for( int x = 1; x < columns; x++)
		{
			result += input[RowNum][x]; //[Permutations][Colors]
		}
	
		return result;
	}
	
	static int SumColumn(int[][] input, int ColNum)
	{
		int result = 0;
		int rows = input.length;
		
		result = input[0][ColNum];
		
		for( int x = 1; x < rows; x++)
		{
			result += input[x][ColNum]; //[Permutations][Colors]
		}

		return result;
	}
	
	static void PrintArray(int[][] input)
	{
		int temp = 0;
		
		for(int x = 0; x < input.length; x++)
		{
		
			for(int y = 0; y < input[x].length; y++)
			{
			
				System.out.print("  " + input[x][y]); //[Permutations][Colors]
			}
			System.out.print("    ");
			System.out.println(Integer.toString(SumRow(input,x)));
			
		}
		System.out.println();
		
		for(int y = 0; y < input[0].length; y++)
		{
			temp = SumColumn(input,y);
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
