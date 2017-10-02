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
		String SearchString = "xxx"; //parameter
		String EndString = "MasterIndex = "; //parameter
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
		int LowerLimit = 116; //parameter
		int PostingInteger = LowerLimit;
		int UpperLimit = 3000; //parameter
		boolean IncrementPostingInteger = false;
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
		for(int x = 0; ((x+SearchLength < FileText.length()) && (x+EndLength < FileText.length())); x++)
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
			
			
			
			//debugging
			if(line == 4000)
			{
				column = 0;
			}
			startposition = x;
			endposition = startposition + EndLength;
			TestString = FileText.substring(startposition, endposition);
			//if End String is found
			if(TestString.compareTo(EndString) == 0)
			{
				IncrementPostingInteger = true;
			}			
			startposition = x;
			endposition = startposition + SearchLength;
			TestString = FileText.substring(startposition, endposition);
			//if search string is found
			if(TestString.compareTo(SearchString) == 0)
			{
				//parse First
				FirstString = FileText.substring(0, x);
				x=endposition;
				
				TestChar = FileText.charAt(x);
				if(TestChar == '\n')
				{
					line+= FirstString.length();
					column = 0;
				}
				else
				{
					if(x != 0)
					{
						column++;
					}
				}
				
				//replace
				MidString = Integer.toString(PostingInteger);
				//parse Last
				LastString = FileText.substring(x,FileText.length());
				//Concatenate back to FileText
				FileText = FirstString + MidString + LastString;
				
				//delete parses
				FirstString = "";
				MidString = "";
				LastString = "";
				
				if(IncrementPostingInteger)
				{
					PostingInteger += IncrementInteger;
					IncrementPostingInteger = false;
				}
			}
		}
		//save to file
		Snuffit.SaveToFile(FileText);
	}

}
