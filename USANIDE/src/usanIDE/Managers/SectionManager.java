package usanIDE.Managers;

import java.util.ArrayList;

public class SectionManager 
{
	ManagerHelper Sandslash;
	
	public SectionManager()
	{
		Sandslash = new ManagerHelper();
	}
	
	/*
	List of Sections:
		[HISTORY]
		[APPLICATION]
		[CALL_VARIABLES]
		[APPLICATION_VARIABLES]
		CODE SECTION
		[PROMPTS
		[DIGIT_PROMPTS
		[GENERAL]
		[REFERENCED_APPLICATIONS]
		[EXTENSION_DB]
		[DNIS_OUTDIAL_DB]
		[SPEECH_VOCABULARY]
		[ANI_OUTDIAL_DB]
		[DNIS_ANI_OUTDIAL_DB]
		[HOST_CONFIGURATION]
		[ANI_MESSAGE_DB]
		[DNIS_MESSAGE_DB]
		[DNIS_ANI_MESSAGE_DB]
		[END]
	*/
	
	//Action: Determine each section exists
	public ArrayList<ArrayList<String>> CheckIt(String content)
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		ArrayList<String> DefaultSectionList = new ArrayList<String>();
		ArrayList<String> BuiltSectionList = new ArrayList<String>();
		
		//Structure:
		//Start Position found
		int startIndex = 0;
		//int startofVariableIndex = 0;
		//End Position
		int endIndex = 1;
		//int endofVariableIndex = 1;
		//Line
		int line = 1;
		int lineIndex = 0;
		//Description of Error
		String description = "none";
		//Priority
		int priority = 0;
			//1:	OMG NO!
			//2:	Fix this
			//3:	Hey, what're you doing?
	
	//int mode = 0;
	//boolean seeking = true;
	//boolean sectionFound = false;
	boolean errorFound = false;
	//String SectionTitle = "[DIGIT_PROMPTS ";
	//String NextSectionTitle = "[GENERAL]";
	int tracker = 0;
	int errorType = 0;
	//String dataType = "";
	
	String potentialWord = "";
	char testChar = '0';
	String CurrentSection = "";
	
	//boolean initialCommentLine = true;
	//boolean customPrompt = true;
	
	//int startofSectionIndex = 0;
	int SectionTracker = 0;
	
	boolean AddToBuildList = true;

		
		//Build Default Section List
		DefaultSectionList.add("[HISTORY]");
		DefaultSectionList.add("[APPLICATION]");
		DefaultSectionList.add("[CALL_VARIABLES]");
		DefaultSectionList.add("[APPLICATION_VARIABLES]");
		
		potentialWord = Sandslash.FindStartCellName(content);
		potentialWord = Sandslash.FindStartCell(potentialWord,content); //CODE SECTION: Start Cell or (-1)
		
		if(potentialWord.compareTo("(-1)") == 0)
		{
			DefaultSectionList.add("Starting Cell");
		}
		else
		{
			DefaultSectionList.add(potentialWord);
		}
		DefaultSectionList.add("[PROMPTS");
		DefaultSectionList.add("[DIGIT_PROMPTS");
		DefaultSectionList.add("[GENERAL]");
		DefaultSectionList.add("[REFERENCED_APPLICATIONS]");
		DefaultSectionList.add("[EXTENSION_DB]");
		DefaultSectionList.add("[DNIS_OUTDIAL_DB]");
		DefaultSectionList.add("[SPEECH_VOCABULARY]");
		DefaultSectionList.add("[ANI_OUTDIAL_DB]");
		DefaultSectionList.add("[DNIS_ANI_OUTDIAL_DB]");
		DefaultSectionList.add("[HOST_CONFIGURATION]");
		DefaultSectionList.add("[ANI_MESSAGE_DB]");
		DefaultSectionList.add("[DNIS_MESSAGE_DB]");
		DefaultSectionList.add("[DNIS_ANI_MESSAGE_DB]");
		DefaultSectionList.add("[END]");
		
		
		//seek content from start to finish for sections:
		for(; tracker < content.length(); tracker++)
		{
			testChar = content.charAt(tracker);
			SectionTracker = Sandslash.findEndOfLine(tracker, content);
			potentialWord = content.substring(tracker, SectionTracker);
			
			if(content.charAt(tracker) == '\n')
			{
				line++;
				if(tracker < (content.length()-1))
				{
					lineIndex = (tracker +1);
				}
				continue;
			}
			
			if((content.charAt(tracker) == '['))
			{
				startIndex = tracker;
				
				sectionloop:
				for(int x = 0; x < DefaultSectionList.size(); x++)
				{
					if( tracker < (content.length()-DefaultSectionList.get(x).length()) )
					{
						potentialWord = content.substring(tracker,(tracker+DefaultSectionList.get(x).length()));
						
						//if an expected section
						if(DefaultSectionList.get(x).compareTo(potentialWord) == 0)
						{
							builtloop:
							//check previously built list
							for(int y = 0; y < BuiltSectionList.size(); y++)
							{
								//if section already exists
								if(BuiltSectionList.get(y).compareTo(potentialWord) == 0)
								{
									//if found section is not a "[PROMPTS" or "[DIGIT_PROMPTS" section
									if( !( (potentialWord.compareTo("[PROMPTS") == 0) || (potentialWord.compareTo("[DIGIT_PROMPTS") == 0) ) )
									{
										tracker = tracker + potentialWord.length();
										
										//report error
										//Error 2: This section may be a duplicate section.
										errorType = 2;
										errorFound = true;
										
										break builtloop;
									}
								}
							}
							
							if(!errorFound)
							{
								AddToBuildList = true;
								//if [PROMPTS or [DIGIT_PROMPTS
								if( ( (potentialWord.compareTo("[PROMPTS") == 0) || (potentialWord.compareTo("[DIGIT_PROMPTS") == 0) ) )
								{
									//then check previously built list
									builtloop:
										//check previously built list
										for(int y = 0; y < BuiltSectionList.size(); y++)
										{
											//if section already exists
											if(BuiltSectionList.get(y).compareTo(potentialWord) == 0)
											{
												AddToBuildList = false;
												break builtloop;
											}
										}
								}
								
								if(AddToBuildList)
								{
									//add the found section to the list
									BuiltSectionList.add(potentialWord);
								}
								
								AddToBuildList = true;
								
								//if the found section is not in the right order (indices do not match)
								if(x != BuiltSectionList.size()-1)
								{
									if((Sandslash.findEndOfWordUntilRBracket(tracker, content) + 1) < content.length())
									{
										tracker = Sandslash.findEndOfWordUntilRBracket(tracker, content) + 1; //potentialWord.length();
										
									}
									else
									{
										tracker = Sandslash.findEndOfWordUntilRBracket(tracker, content) + potentialWord.length();
									}
										
									//report error
									//Error 1: This section may not be in the right order.
									errorType = 1;
									errorFound = true;
									
								}
								
								break sectionloop;
							}
						}
					}
				}
			
			
				if(errorFound)
				{
					endIndex = tracker;
					
					if(errorType == 1)
					{
						priority = 2;
						description = "This section may not be in the right order.";
					}
					else if(errorType == 2)
					{
						priority = 2;
						description = "This section may be a duplicate section.";
					}
					
					output.add(new ArrayList<String>());
					output.get(output.size()-1).add(Integer.toString(startIndex));
					output.get(output.size()-1).add(Integer.toString(endIndex));
					output.get(output.size()-1).add(Integer.toString(line));
					output.get(output.size()-1).add(description);
					output.get(output.size()-1).add(Integer.toString(priority));
					output.get(output.size()-1).add(Integer.toString(lineIndex));
					
					errorFound = false; //reset to find new error
					errorType = 0;
					
				}
				
				
				//mode = 0; //reset mode
				//seeking = true; //turn seeking back on
				tracker = Sandslash.findEndOfLine(tracker, content);
				
				if(tracker < content.length())
				{
					if(content.charAt(tracker) == '\n')
					{
						line++;
						if(tracker < (content.length()-1))
						{
							lineIndex = (tracker +1);
						}
					}
				}
			
			}
			else
			{
				tracker = Sandslash.findEndOfLine(tracker, content);
				if(tracker < content.length())
				{
					if(content.charAt(tracker) == '\n')
					{
						line++;
						if(tracker < (content.length()-1))
						{
							lineIndex = (tracker +1);
						}
					}
				}
				continue;
			}
		}
		
		//After all sections have been found, review the built list 
		for(int x = 0; x < DefaultSectionList.size(); x++)
		{
			errorFound = true;
			CurrentSection = DefaultSectionList.get(x);
			
			checkloop:
			for(int y = 0; y < BuiltSectionList.size(); y++)
			{
				potentialWord = BuiltSectionList.get(y);
				
				//if the expected section is found somewhere in the existing sections 
				if(DefaultSectionList.get(x).compareTo(BuiltSectionList.get(y)) == 0)
				{
					errorFound = false;
					break checkloop;
				}
				else
				{
					continue;
				}
			}	
			
			if(errorFound)
			{
				output.add(new ArrayList<String>());
				output.get(output.size()-1).add(Integer.toString(0)); //start index
				output.get(output.size()-1).add(Integer.toString(0)); //end index
				output.get(output.size()-1).add(Integer.toString(0)); //line
				output.get(output.size()-1).add("No " + DefaultSectionList.get(x) + " was found.");
				output.get(output.size()-1).add(Integer.toString(2)); //description
				output.get(output.size()-1).add(Integer.toString(0)); //line index
			}
				
			
		}
		
		
		
		
		
		return output;
	}
	
	
}
