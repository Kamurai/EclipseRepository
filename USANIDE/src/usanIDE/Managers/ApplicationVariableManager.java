package usanIDE.Managers;

import java.util.ArrayList;

public class ApplicationVariableManager 
{
	ManagerHelper Sandslash;
	
	public ApplicationVariableManager()
	{
		Sandslash = new ManagerHelper();
	}
	//Action: Ensure each line is a comment or starts with "a_" (Warning), or is "empty"
	//Action: Ensure assignment is allowable for declared file type (e.g. "Invalid boolean value (must be yes/no, 1/0, or true false)")
		//declarable file types:
			/*
			 * boolean  	("Invalid boolean value (must be yes/no, 1/0, or true false)")
			 * 		Ensure boolean is assign as "yes","no","y","no","1","0","true" or "false" (Case Insensitive)
			 * cell			
			 * 		Ensure that assigned cell actually exists
			 * number		("Value specified must be a positive number")
			 * 		Ensure that assigned number is actually a number
			 * string		
			 * 		String should be able to store any characters
			 * dynaPrompt
			 * 		dynaPrompt should be assigned nothing or a viable prompt
			 * 			Mxxx, Pxxxx, {}, or a prompt variable
			 * name			pivot!!!
			 * 		Name should be a smaller string up to a certain byte limitation
			 * bigNumber	
			 * prompt		
			 * phone		
			 * port
			 * portList
			 * todGroup
			 * peg
			 * pegList
			 */
	public ArrayList<ArrayList<String>> CheckIt(String content)
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		//Structure:
			//Start Position found
			int startIndex = 0;
			int startofVariableIndex = 0;
			//End Position
			int endIndex = 1;
			int endofVariableIndex = 1;
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
		boolean errorFound = false;
		String SectionTitle = "[APPLICATION_VARIABLES]";
		String NextSectionTitle = "";
		int tracker = 0;
		int errorType = 0;
		String dataType = "";
		
		String potentialWord = "";
		char testChar = '0';
		
		boolean initialCommentLine = true;
		
		//find start cell name
		
		//set SectionTitle as "starting cell name"
		NextSectionTitle = Sandslash.FindStartCellName(content);
		
		if( NextSectionTitle.compareTo("(-1)") != 0)
		{
			NextSectionTitle = Sandslash.FindStartCell(NextSectionTitle,content);
		}
		
		if( NextSectionTitle.compareTo("(-1)") == 0)
		{
			return output; //fail
		}
		
		
		
		//seek content from start to finish:
		for(; tracker < content.length(); tracker++)
		{
			testChar = content.charAt(tracker);
			if(content.charAt(tracker) == '\n')
			{
				line++;
				if(tracker < (content.length()-1))
				{
					lineIndex = (tracker +1);
				}
			}
			//find "[CALL_VARIABLES]"
				//if not too far in the string
			if( tracker < content.length()-SectionTitle.length() )
			{
				//if "[CALL_VARIABLES]" is found
				if(content.substring(tracker,(tracker+SectionTitle.length())).compareTo(SectionTitle) == 0)
				{
					sectionFound = true;
					tracker += SectionTitle.length();
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
				testChar = content.charAt(tracker);
				//find "[APPLICATION_VARIABLES]"
					//if not too far in the string
				if( tracker < content.length()-NextSectionTitle.length() )
				{
					//if "[APPLICATION_VARIABLES]" is found
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
					else //not a comment
					{
						//pivot
						startIndex = tracker;
						seeking = false; //turn off seeking
						mode = 3; //not a comment mode
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
									errorType = 10;
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
					else if(mode == 3) //not a comment mode
					{
						if((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') ||(tracker == content.length()-1))// && x != content.length())
						{
							//do nothing
						}
						else
						{
							//ensure non-comment fits section format
								//line begins with "a_"
							if((content.charAt(tracker) == 'a') )
							{
								if(tracker < content.length()-1) //not on last character in file
								{
									if((content.charAt(tracker+1) == '_'))
									{
										startofVariableIndex = tracker;
										tracker += 2; //skip to character after underscore
										testChar = content.charAt(tracker);
										
										commaloop:
										//scan text until comma, comment, space, return or end of file
										for(; tracker < content.length(); tracker++)
										{
											testChar = content.charAt(tracker);
											//"a_" var is followed by ','
											if((content.charAt(tracker) == ','))
											{
												//found comma
												endofVariableIndex = tracker;

												potentialWord = content.substring(startofVariableIndex,endofVariableIndex);
												
												if((potentialWord.length() > 32) || (potentialWord.length() < 1))
												{
													errorFound = true;
													errorType = 11;
													break;
												}
												else if(Sandslash.AppVariableIsDuplicate(potentialWord, startofVariableIndex,endofVariableIndex, content))
												{
													errorFound = true;
													errorType = 12;
													tracker = Sandslash.findEndOfLine(tracker, content);
													break;													
												}
												else
												{
													tracker++; //skip comma
													testChar = content.charAt(tracker);
													
													startIndex = tracker; //target the data type for errors
													
													tracker = Sandslash.findEndOfWord(startIndex, content);
													testChar = content.charAt(tracker);
													
													dataType = content.substring(startIndex,tracker);
												}
												//',' is followed by a valid data type 
												if(!determineValidDataType(dataType))
												{
													errorFound = true;
												}
												else
												{
													errorFound = false;
												}
												
												if(errorFound)
												{
													errorType = 3;
													break;
												}
												else
												{
													//scan text until equal sign, comment, space, return or end of file
													for(; tracker < content.length(); tracker++)
													{
														testChar = content.charAt(tracker);
														//if space
														if( (content.charAt(tracker) == ' ') )
														{
															continue; //skip space
														}
														//if '='
														else if((content.charAt(tracker) == '='))
														{
															//found equals
															tracker++; //skip equals
															testChar = content.charAt(tracker);
															
															if((content.charAt(tracker) == '\n') || (content.charAt(tracker) == ' ') || (content.charAt(tracker) == ';'))
															{
																tracker = Sandslash.findEndOfLine(tracker, content);
																testChar = content.charAt(tracker);
																
																//Error 7: There is no assignment for this variable.
																errorType = 7;
																errorFound = true;
															}
															else if((content.charAt(tracker) == '/') && tracker < content.length()-1 )
															{
																if((content.charAt(tracker) == '*'))
																{
																	startIndex = tracker;
																	
																	tracker = Sandslash.findEndOfLine(tracker, content);
																	testChar = content.charAt(tracker);
																	
																	//Error 9: There is an inappropriate start of comment block.
																	errorType = 9;
																	errorFound = true;
																}
															}
															else
															{
															
																startIndex = tracker; //target the data type for errors	
																//tracker = findEndOfLine(tracker, content);
																tracker = Sandslash.findEndOfWord(tracker, content);
																testChar = content.charAt(tracker);
															
															
																//errorFound = determineDataValue(dataType, content.substring(startIndex, tracker), content);
																if(!determineDataValue(dataType, content.substring(startIndex, tracker), content))
																{
																	errorFound = true;
																}
																else
																{
																	errorFound = false;
																}
															}
															
															if(errorFound == true)
															{
																if(dataType.compareTo("prompt") == 0)
																{
																	//Ensure variable is being used in the application 
																	//Error 5: Variable does not appear in application
															
																	errorType = 5;
																}
																else if(!(errorType == 7) || (errorType == 9))
																	{
																	//Ensure variable is a valid based on data type 
																	//Error 4: Variable does not meet data type criteria
																														
																	errorType = 4;
																}
																
																break commaloop;
															}
															else
															{
																//scanning after the assignment value
																for(; tracker < content.length(); tracker++)
																{
																	testChar = content.charAt(tracker);
																	
																	if((content.charAt(tracker) == ' '))
																	{
																		continue;
																	}
																	else if((content.charAt(tracker) == '\n'))
																	{
																		errorFound = false;
																		break commaloop;
																	}
																	else if((content.charAt(tracker) == ';'))
																	{
																		tracker = Sandslash.findEndOfLine(tracker, content);
																		break commaloop;
																	}
																	else if(content.charAt(tracker) == '/' && (tracker != content.length()-1))
																	{
																		if(content.charAt(tracker+1) == '*')
																		{
																			//Error 9: There is an inappropriate start of comment block.
																			errorType = 9;
																		}
																		else
																		{
																			//Error 6: Remove the excess information.
																			errorType = 6;
																		}
																			startIndex = tracker;
																			
																			tracker = Sandslash.findEndOfLine(tracker, content);
																			testChar = content.charAt(tracker);
																			
																			errorFound = true;
																			break commaloop;
																			
																	}
																	else
																	{
																		startIndex = tracker;
																		
																		tracker = Sandslash.findEndOfLine(tracker, content);
																		testChar = content.charAt(tracker);
																		
																		errorFound = true;
																		errorType = 6;
																		break;
																	}
																	
																}
																
																//break;
															}
														}
														else
														{
															errorFound = true;
															errorType = 7;
															break;
														}
													}
												}
												
												
											}
											else 
											{
												if((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') ||(tracker == content.length()-1) || (content.charAt(tracker) == ';'))
												{
													//Error 2: No comma following call or user variable
													errorFound = true;
													errorType = 2;
													startIndex = tracker;
													
													break;
												}
												else if(tracker < content.length()-1) //not on last character in file
												{
													if((content.charAt(tracker) == '/'))
													{
														if((content.charAt(tracker+1) == '*'))
														{
															//Error 9: There is an inappropriate start of comment block.
															errorFound = true;
															errorType = 9;
															startIndex = tracker;
															
															break;
														}
													}
												}
											}
										}
									}
								}
							}
							else
							{
								//Error 1: Line does not contain a call or user variable
								errorFound = true;
								errorType = 1;
								
								//scan text until comment, return or end of file (end of line)
								tracker = Sandslash.findEndOfLine(tracker, content);
								testChar = content.charAt(tracker);
								
							}
							
								
							
							if(errorFound)
							{
								endIndex = tracker;
								
								if(errorType == 1)
								{
									priority = 2;
									description = "Line does not contain an application variable.";
								}
								else if(errorType == 2)
								{
									priority = 2;
									description = "No comma following call or user variable.";
									endIndex++;
									//if not comment, return or end of file
									if((content.charAt(tracker) == ' '))
									{
										//scan text until comment, return or end of file (end of line)
										tracker = Sandslash.findEndOfLine(tracker, content);
										testChar = content.charAt(tracker);
										
									}
								}
								else if(errorType == 3)
								{
									priority = 2;
									description = "Variable is not a valid data type.";
								}
								else if(errorType == 4)
								{
									priority = 2;
									description = "Variable does not meet data type criteria";
								}
								else if(errorType == 5)
								{
									priority = 2;
									description = "Invalid prompt: please ensure that all prompt sections define this prompt.";
								}
								else if(errorType == 6)
								{
									priority = 2;
									description = "Remove the excess information.";
								}
								else if(errorType == 7)
								{
									priority = 3;
									description = "There is no assignment for this variable.";
									
									startIndex = startofVariableIndex;
									endIndex = endofVariableIndex;
								}
								else if(errorType == 8)
								{
									priority = 3;
									description = "Variable does not appear in application.";
								}
								else if(errorType == 9)
								{
									priority = 2;
									description = "There is an inappropriate start of comment block.";
								}
								else if(errorType == 10)
								{
									priority = 2;
									description = "There is a nested comment block.";
								}
								else if(errorType == 11)
								{
									priority = 2;
									description = "Variable does not meet size requiremnts.";
								}
								else if(errorType == 12)
								{
									priority = 2;
									description = "Variable is declared elsewhere in this section.";
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
							mode = 0; //reset mode
							seeking = true; //turn seeking back on
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
		}
					
			
			
		
		return output;
	}
	
	private boolean determineValidDataType(String input)
	{
		boolean result = false;
		String DataType = input.toLowerCase();
		
		if((DataType.length() == 0))
		{
			result = false;
		}		
		else if((DataType.charAt(0) == 'b'))
		{
			//bigNumber
			if(  DataType.length() >= 9 )
			{	
				if(DataType.compareTo("bignumber") == 0)
				{
					result = true;
				}
			}
			else if(  DataType.length() >= 7 )
			{
				//boolean
				if(DataType.compareTo("boolean") == 0)
				{
					result = true;
				}
				else
				{
					result = false;
					
				}
			}
			else
			{
				result = false;
			}
		}
		else if((DataType.charAt(0) == 'c'))
		{
			//cell
			if( DataType.length() >= 4 )
			{	
				if(DataType.compareTo("cell") == 0)
				{
					result = true;
				}
				else
				{
					result = false;
				}
			}
			else
			{
				result = false;
			}
		}
		else if((DataType.charAt(0) == 'd'))
		{
			//dynaPrompt
			if( DataType.length() >= 10 )
			{	
				if(DataType.compareTo("dynaprompt") == 0)
				{
					result = true;
				}
				else
				{
					result = false;
				}
			}
			else
			{
				result = false;
			}
  					
		}
		else if((DataType.charAt(0) == 'e'))
		{
			//dynaPrompt
			if( DataType.length() >= 4 )
			{	
				if(DataType.compareTo("enum") == 0)
				{
					result = true;
				}
				else
				{
					result = false;
				}
			}
			else
			{
				result = false;
			}
  					
		}
		else if((DataType.charAt(0) == 'n'))
		{	
			if( DataType.length()>=6 )
			{	
				//number		("Value specified must be a positive number")
				if(DataType.compareTo("number") == 0)
				{
					result = true;
				}
			}
			else if( DataType.length()>=4 )
			{
				//name			pivot!!!
				if(DataType.compareTo("name") == 0)
				{
					result = true;
				}
				else
				{
					result = false;
				}
			}
			else
			{
				result = false;
			}
		}
		else if((DataType.charAt(0) == 'p'))
		{
			
			if( DataType.length()>=8 )
			{
				//portList
				if(DataType.compareTo("portlist") == 0)
				{
					result = true;
				}
			}
			else if( DataType.length()>=7 )
			{
				//pegList
				if(DataType.compareTo("peglist") == 0)
				{
					result = true;
				}
			}
			else if( DataType.length()>=6 )
			{
				//prompt		
				if(DataType.compareTo("prompt") == 0)
				{	
					result = true;
				}
			}
			else if( DataType.length()>=5 )
			{
				//phone
				if(DataType.compareTo("phone") == 0)
				{	
					result = true;
				}
			}
			else if( DataType.length()>=4 )
			{
				//port
				if(DataType.compareTo("port") == 0)
				{	
					result = true;
				}
			}
			else if( DataType.length()>=3 )
			{
				//peg
				if(DataType.compareTo("peg") == 0)
				{
					result = true;
				}
				else
				{
					result = false;
				}
			}
			else
			{
				result = false;
			}
		}
		else if((DataType.charAt(0) == 's'))
		{
			if( DataType.length() >= 6 )
			{
				//string		
				if(DataType.compareTo("string") == 0)
				{	
					result = true;
				}
				else
				{
					result = false;
				}
			}
			else
			{
				result = false;
			}
		}
		else if((DataType.charAt(0) == 't'))
		{
			if( DataType.length()>=8 )
			{
				//todGroup		
				if(DataType.compareTo("todgroup") == 0)
				{	
					result = true;
				}
				else
				{
					result = false;
				}
			}
			else
			{
				result = false;
			}
		}
		else
		{
			result = false;
		}
		
		
		return result;
		
	}
	
	private boolean determineDataValue(String input, String dataValue, String content)
	{
		boolean result = false;
		String dataType = input.toLowerCase();
		
		if(dataType.compareTo("boolean") == 0)
		{
			result = Sandslash.isValidBoolean(dataValue);
		}
		else if(dataType.compareTo("cell") == 0)
		{
			result = Sandslash.isValidCell(dataValue, content);
		}
		else if(dataType.compareTo("number") == 0)
		{
			result = Sandslash.isValidNumber(dataValue);
		}
		else if(dataType.compareTo("string") == 0)
		{
			result = Sandslash.isValidString(dataValue);
		}
		else if(dataType.compareTo("dynaprompt") == 0)
		{
			result = Sandslash.isValidDynaPrompt(dataValue);
		}
		else if(dataType.compareTo("name") == 0)
		{
			result = Sandslash.isValidName(dataValue);
		}
		else if(dataType.compareTo("bignumber") == 0)
		{
			result = Sandslash.isValidBigNumber(dataValue);
		}
		else if(dataType.compareTo("prompt") == 0)
		{
			result = Sandslash.isPromptValid(dataValue, content);
		}
		else if(dataType.compareTo("phone") == 0)
		{
			result = Sandslash.isValidPhone(dataValue);
		}
		else if(dataType.compareTo("port") == 0)
		{
			result = Sandslash.isValidPort(dataValue);
		}
		else if(dataType.compareTo("portlist") == 0)
		{
			result = Sandslash.isValidPortList(dataValue);
		}
		else if(dataType.compareTo("todgroup") == 0)
		{
			result = Sandslash.isValidTodGroup(dataValue);
		}
		else if(dataType.compareTo("peg") == 0)
		{
			result = Sandslash.isValidPeg(dataValue);
		}
		else if(dataType.compareTo("peglist") == 0)
		{
			result = Sandslash.isValidPegList(dataValue);
		}
		else if(dataType.compareTo("enum") == 0)
		{
			result = Sandslash.isValidEnum(dataValue);
		}
		
		return result;
	}
}
