package usanIDE.Managers;

import java.util.ArrayList;

public class HistoryManager 
{
	public HistoryManager()
	{
		
	}
	//Action: Ensure each line is only a comment
	public ArrayList<ArrayList<String>> CheckIt(String content)
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		//Structure:
			//Start Position found
			int startIndex = 0;
			//End Position
			int endIndex = 1;
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
		
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;
		String SectionTitle = "[HISTORY]";
		String NextSectionTitle = "[APPLICATION]";
		int tracker = 0;
		
		char testChar = '0';
		
		boolean initialCommentLine = true;
		
		//seek content from start to finish:
		for(; tracker < content.length(); tracker++)
		{
			if(content.charAt(tracker) == '\n')
			{
				line++;
				if(tracker < (content.length()-1))
				{
					lineIndex = (tracker +1);
				}
			}
			//find "[HISTORY]"
				//if not too far in the string
			if( tracker < content.length()-SectionTitle.length() )
			{
				//if "[HISTORY]" is found
				if(content.substring(tracker,(tracker+SectionTitle.length())).compareTo(SectionTitle) == 0)
				{
					sectionFound = true;
					tracker += SectionTitle.length();
					//line++;
					break;
				}
				
			}
			else
			{
				return output; //escape method
			}
		}
				
		if(sectionFound)
		{
			for(; tracker < content.length(); tracker++)
			{
				//find "[APPLICATION]"
					//if not too far in the string
				if( tracker < content.length()-NextSectionTitle.length() )
				{
					//if "[APPLICATION]" is found
					if(content.substring(tracker,(tracker+NextSectionTitle.length())).compareTo(NextSectionTitle) == 0)
					{
						return output; //escape method
					}
				}
				
				testChar = content.charAt(tracker);
				
				if(seeking)
				{
					if( content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n')
					{
						//do nothing, let for loop advance
						if(content.charAt(tracker) == '\n')
						{
							line++;
							if(tracker < (content.length()-1))
							{
								lineIndex = (tracker +1);
							}
						}
					}
					//identify comment indicators
					else if(content.charAt(tracker) == ';')
					{
						//turn off seeking unless appropriate end comment is found
						seeking = false; //turn off seeking
						mode = 1; //single line comment mode
					}
					//identify comment indicators
					else if(content.charAt(tracker) == '/' && (tracker != content.length()-1))
					{
						if(content.charAt(tracker+1) == '*')
						{
							//turn off seeking unless appropriate end comment is found
							seeking = false; //turn off seeking
							mode = 2; //multi-line comment mode
							tracker++; //we know what x+1 is, and don't care
							testChar = content.charAt(tracker);
							initialCommentLine = true;
						}
					}
					else //treat it as if we may have found an error
					{
						//pivot
						startIndex = tracker;
						seeking = false; //turn off seeking
						mode = 3; //error found mode
					}		
				}
				//else
				if(!seeking)
				{
					if(mode == 1) //single line comment mode
					{
						if(content.charAt(tracker) == '\n')// && x != content.length())
						{
							mode = 0; //reset mode
							seeking = true; //turn seeking back on
							line++;
							if(tracker < (content.length()-1))
							{
								lineIndex = (tracker +1);
							}
						}
						else if(tracker == content.length()-1)
						{
						}
					}
					else if(mode == 2) //multi-line comment mode
					{
						if(content.charAt(tracker) == '*' && (tracker != content.length()-1))
						{
							if(content.charAt(tracker+1) == '/')
							{
								if(initialCommentLine)
								{
									//errorType = 10;
									priority = 2;
									description = "There is a nested comment block.";
									startIndex = tracker;
									
									if(tracker < (content.length()-3))
									{
										endIndex = tracker + 2;
									}
									else
									{
										endIndex = (content.length()-1);
									}
																		
									output.add(new ArrayList<String>());
									output.get(output.size()-1).add(Integer.toString(startIndex));
									output.get(output.size()-1).add(Integer.toString(endIndex));
									output.get(output.size()-1).add(Integer.toString(line));
									output.get(output.size()-1).add(description);
									output.get(output.size()-1).add(Integer.toString(priority));
									output.get(output.size()-1).add(Integer.toString(lineIndex));
									
								}
								
								mode = 0; //reset mode
								seeking = true; //turn seeking back on
							}
						}
						else if(tracker == content.length()-1)
						{
						}
						
						if(content.charAt(tracker) == '\n')// && x != content.length())
						{
							line++;
							if(tracker < (content.length()-1))
							{
								lineIndex = (tracker +1);
							}
							initialCommentLine = false;
						}
					}
					else if(mode == 3) //find an error mode
					{
						if((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') ||(tracker == content.length()-1))// && x != content.length())
						{
							mode = 0; //reset mode
							seeking = true; //turn seeking back on
							/*
							if(content.charAt(tracker) == '\n')
							{
								line++;
							}
							*/
							endIndex = tracker;
							priority = 3;
							description = "Please don't put a non-comment in the History Section.";
							
							output.add(new ArrayList<String>());
							output.get(output.size()-1).add(Integer.toString(startIndex));
							output.get(output.size()-1).add(Integer.toString(endIndex));
							output.get(output.size()-1).add(Integer.toString(line));
							output.get(output.size()-1).add(description);
							output.get(output.size()-1).add(Integer.toString(priority));
							output.get(output.size()-1).add(Integer.toString(lineIndex));
						}
						
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
					
				}
			}
		}
					
			
			
		
		return output;
	}
}
