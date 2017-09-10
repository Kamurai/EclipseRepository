package sortMess;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Processor 
{
	String output;
	int[][] mess;
	int[][] sorted;

	Processor() 
	{
		// output result
		output = "";
	}

	public String SortIt(int[][]input)
	{
		mess = input;
		sorted = new int[input.length][input[0].length];
		
		sorted = FixIt(mess);
		
		output = printOutput(sorted);

		// output result
		return output;
	}
	
	private int[][] FixIt(int[][]input)
	{
		int[][] output = new int[input.length][input[0].length];
		
		int promooffercount = input[0].length;
		int Last = 0;
		int Index = 0;
		int Reserve = 0;
		
		int LastSorted = 0;
		int Current = 0;
		int Target = 0;
		
		for(int y = 0; y < promooffercount; y++) //y is tracking how many promos have been offered
		{
			Index = 0;
			for(int x = 0; x < promooffercount; x++) //x is tracking how many comparisons have been made
			{
				if(y == 0)
				{
					LastSorted = 0;
				}
				else
				{
					LastSorted = input[0][Last];
				}
				
				Current = input[0][x];
				
				if( (Current >= LastSorted) )
				{
					if(x != Last && x != Index)
					{
						Target = input[0][Index];
						
						if(Current == LastSorted)
						{
							Reserve = x;
							if(Reserve > Last)
							{
								Index = x;
								x = promooffercount;
							}
						}
						else if(Current < Target)
						{
							Index = x;
							Reserve = x;
						}
						else if((Target < Current) && (LastSorted >= Target))
						{
							Index = x;
							Reserve = x;
						}
					}
				}
			}
			
						
			output[0][y] = input[0][Index];
			output[1][y] = input[1][Index];

			Last = Index;
			
		}
		
		
		return output;
	}
	

	private String printOutput(int[][]input) 
	{
		String result = "";

		for (int row = 0; row < input.length; row++) {
			for (int col = 0; col < input[row].length; col++) {
				result += input[row][col];

				if (col != (input[row].length - 1)) 
				{
					result += " | ";
				}
			}
			result += "\n";
		}

		return result;
	}

	public String getOutput() {
		return output;
	}
}
