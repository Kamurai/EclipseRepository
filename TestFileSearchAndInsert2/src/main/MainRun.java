package main;

public class MainRun 
{
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//set conditions
		String TargetFile = "Target_File.htkb";
		String ReferenceFile = "Target_File.htkb";
		FileManager Snuffit = new FileManager(ReferenceFile);
		String FileText = "";
		String FilePath = "C:\\House\\";
		
		//Match Variables
		String SearchString = "["; //parameter
		String EndString = "]"; //parameter
		int IncrementInteger = 1; //parameter
		String SearchNumber = "";
		int SearchInteger = 0;

		//Search Variables
		int tracker = 0;
		int startposition = 0;
		int SearchLength = SearchString.length();
		int endposition = startposition + SearchLength;
		int EndLength = EndString.length();
		
		//Parsing Variables
		int LowerLimit = 0; //parameter
		int UpperLimit = 2000; //parameter
		String FirstString = "";
		String MidString = "";
		String LastString = "";
		
		//read file to string
		FileText = Snuffit.PullFile2(FilePath + TargetFile);
		
		//maintenance
		int column = 0;
		int line = 1;
		char TestChar = '0';
		String TestString = "";
		
		//read through file string
		for(int x = 0; x+SearchLength < FileText.length(); x++)
		{
			TestChar = FileText.charAt(x);
			if(TestChar == '\n')
			{
				line++;
				column = 0;
			}
			else
			{
				if(x != 0)
				{
					column++;
				}
			}
			
			startposition = x;
			endposition = startposition + SearchLength;
			
			
			//debugging
			/*
			if(line == 7)
			{
				column = 0;
			}
			*/
			//if search string is found
			TestString = FileText.substring(startposition, endposition);
			if(TestString.compareTo(SearchString) == 0)
			{
				x = x + SearchLength;
				TestChar = FileText.charAt(x);
				if(TestChar == '\n')
				{
					line++;
					column = 0;
				}
				else
				{
					if(x != 0)
					{
						column++;
					}
				}
				//parse First
				FirstString = FileText.substring(0, x);
				//parse following number as Middle
				//search for end string
				for(int y = x; x < FileText.length(); y++)
				{
					startposition = y;
					endposition = startposition + EndLength;
					
					//if end string is found
					TestString = FileText.substring(startposition, endposition);
					if(TestString.compareTo(EndString) == 0)
					{
						SearchNumber = FileText.substring(x,y);
						x=y;
						break;
					}
				}	
				//convert SearchNumber string to integer
				SearchInteger = Integer.parseInt(SearchNumber);
				
				//if number is in bounds
				if((SearchInteger > LowerLimit) && (SearchInteger < UpperLimit))
				{
					//increment
					SearchInteger = SearchInteger + IncrementInteger;
					//replace
					MidString = Integer.toString(SearchInteger);
					//parse Last
					LastString = FileText.substring(x,FileText.length());
					//Concatenate back to FileText
					FileText = FirstString + MidString + LastString;
				}
				//delete parses
				FirstString = "";
				MidString = "";
				LastString = "";
			}
		}
		//save to file
		Snuffit.SaveToFile(FileText);
	}

}
