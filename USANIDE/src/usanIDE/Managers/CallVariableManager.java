package usanIDE.Managers;

import java.util.ArrayList;

public class CallVariableManager 
{
	ManagerHelper Sandslash;
	
	public CallVariableManager()
	{
		Sandslash = new ManagerHelper();	
	}
	//Action: Ensure each line is a comment 
		//or starts with "u_" or "c_" (Warning), or is "empty"
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
		String SectionTitle = "[CALL_VARIABLES]";
		String NextSectionTitle = "[APPLICATION_VARIABLES]";
		int tracker = 0;
		int errorType = 0;
		String dataType = "";
		
		char testChar = '0';
		
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
								//line begins with "c_" or "u_"
							if((content.charAt(tracker) == 'c') || (content.charAt(tracker) == 'u') )
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
											//"c_" or "u_" var is followed by ','
											if((content.charAt(tracker) == ','))
											{
												//found comma
												endofVariableIndex = tracker;
												
												tracker++; //skip comma
												testChar = content.charAt(tracker);
												
												startIndex = tracker; //target the data type for errors
												
												tracker = findEndOfWord(startIndex, content);
												testChar = content.charAt(tracker);
												
												dataType = content.substring(startIndex,tracker);
												
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
															//skip space
														}
														//if '='
														else if((content.charAt(tracker) == '='))
														{
															//found equals
															tracker++; //skip equals
															testChar = content.charAt(tracker);
															
															if((content.charAt(tracker) == '\n') || (content.charAt(tracker) == ' '))
															{
																errorType = 7;
																errorFound = true;
															}
															else
															{
															
																startIndex = tracker; //target the data type for errors	
																//tracker = findEndOfLine(tracker, content);
																tracker = findEndOfWord(tracker, content);
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
																else if(errorType != 7)
																{
																	//Ensure variable is a valid based on data type 
																	//Error 4: Variable does not meet data type criteria
																														
																	errorType = 4;
																}
																
																break commaloop;
															}
															else
															{
																for(; tracker < content.length(); tracker++)
																{
																	testChar = content.charAt(tracker);
																	
																	if((content.charAt(tracker) == '\n'))
																	{
																		/*
																		line++;
																		if(tracker < (content.length()-1))
																		{
																			lineIndex = (tracker +1);
																		}
																		*/
																		break commaloop;
																	}
																	else if((content.charAt(tracker) == ';'))
																	{
																		tracker = findEndOfLine(tracker, content);
																		break commaloop; //pivot: this should stop scanning on this line altogether
																	}
																	else if((content.charAt(tracker) == ' '))
																	{
																		continue;//skip
																	}
																	else if(content.charAt(tracker) == '/' && (tracker != content.length()-1))
																	{
																		if(content.charAt(tracker+1) == '*')
																		{
																			//scan until end of comment or end of line
																			for(; tracker < content.length(); tracker++)
																			{
																				if((content.charAt(tracker) == '\n'))
																				{
																					break commaloop;  //pivot: this should stop scanning on this line altogether
																				}
																				if(content.charAt(tracker) == '*' && (tracker != content.length()-1))
																				{
																					if(content.charAt(tracker+1) == '/')
																					{
																						break; //pivot: this should resume scanning as normal
																					}
																				}
																			}
																		}
																		if((content.charAt(tracker) == '\n'))
																		{
																			break commaloop;
																		}
																	}
																	
																	errorFound = true;
																	errorType = 6;
																	break;
																	
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
															//Error 2: No comma following call or user variable
															errorFound = true;
															errorType = 2;
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
								tracker = findEndOfLine(tracker, content);
								testChar = content.charAt(tracker);
								
							}
							
								
							
							if(errorFound)
							{
								endIndex = tracker;
								
								if(errorType == 1)
								{
									priority = 2;
									description = "Line does not contain a call or user variable.";
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
										tracker = findEndOfLine(tracker, content);
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
								
								output.add(new ArrayList<String>());
								output.get(output.size()-1).add(Integer.toString(startIndex));
								output.get(output.size()-1).add(Integer.toString(endIndex));
								output.get(output.size()-1).add(Integer.toString(line));
								output.get(output.size()-1).add(description);
								output.get(output.size()-1).add(Integer.toString(priority));
								output.get(output.size()-1).add(Integer.toString(lineIndex));
								
								errorFound = false; //reset to find new error
								
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
	
	private int findEndOfWord(int tracker, String content)
	{
		int output = 0;
		
		char testchar = '0';
		
		for(; tracker < content.length(); tracker++)
		{
			testchar = content.charAt(tracker);
			
			if((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length()-1) || (content.charAt(tracker) == ';')) //pivot: comma?
			{
				output = tracker;
				break;
			}
			else if(tracker < content.length()-1) //not on last character in file
			{
				if((content.charAt(tracker) == '/'))
				{
					if((content.charAt(tracker+1) == '*'))
					{
						output = tracker;
						break;
					}
				}
			}
		}
		
		return output;		
	}
	
	private int findEndOfLine(int tracker, String content)
	{
		int output = 0;
		
		for(; tracker < content.length(); tracker++)
		{
			if((content.charAt(tracker) == '\n') ||(tracker == content.length()-1) || (content.charAt(tracker) == ';'))
			{
				output = tracker;
				break;
			}
			else if(tracker < content.length()-1) //not on last character in file
			{
				if((content.charAt(tracker) == '/'))
				{
					if((content.charAt(tracker+1) == '*'))
					{
						output = tracker;
						break;
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
		
		if((DataType.charAt(0) == 'b'))
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
	
	private boolean determineValidDataType(int tracker, String content)
	{
		boolean result = false;
		
		if((content.charAt(tracker) == 'b'))
		{
			//bigNumber
			if( tracker < content.length()-9 )
			{	
				if(content.substring(tracker,tracker+9).compareTo("bignumber") == 0)
				{
					//Ensure number is comprised of numbers
				}
				//boolean  	("Invalid boolean value (must be yes/no, 1/0, or true false)")
				else if(content.substring(tracker,tracker+7).compareTo("boolean") == 0)
				{
					//Ensure boolean is assign as "yes","no","y","no","1","0","true" or "false" (Case Insensitive)
				}
				else
				{
					//Error 3: Variable is not a valid data type
					result = true;
				}
			}
			else
			{
				//Error 3: Variable is not a valid data type
				result = true;
			}
		}
		else if((content.charAt(tracker) == 'c'))
		{
			//cell
			if( tracker < content.length()-4 )
			{	
				if(content.substring(tracker,tracker+4).compareTo("cell") == 0)
				{
					//Ensure that assigned cell actually exists
				}
				else
				{
					//Error 3: Variable is not a valid data type
					result = true;
				}
			}
			else
			{
				//Error 3: Variable is not a valid data type
				result = true;
			}
		}
		else if((content.charAt(tracker) == 'd'))
		{
			//dynaPrompt
			if( tracker < content.length()-10 )
			{	
				if(content.substring(tracker,tracker+10).compareTo("dynaprompt") == 0)
				{
					//dynaPrompt should be assigned nothing or a viable prompt
					//Mxxx, Pxxxx, {}, or a prompt variable
				}
				else
				{
					//Error 3: Variable is not a valid data type
					result = true;
				}
			}
			else
			{
				//Error 3: Variable is not a valid data type
				result = true;
			}
  					
		}
		else if((content.charAt(tracker) == 'n'))
		{	
			if( tracker < content.length()-6 )
			{	
				//number		("Value specified must be a positive number")
				if(content.substring(tracker,tracker+6).compareTo("number") == 0)
				{
					//Ensure that assigned number is actually a number
				}
				//name			pivot!!!
				else if(content.substring(tracker,tracker+4).compareTo("name") == 0)
				{
					//Name should be a smaller string up to a certain byte limitation
				}
				else
				{
					//Error 3: Variable is not a valid data type
					result = true;
				}
			}
			else
			{
				//Error 3: Variable is not a valid data type
				result = true;
			}
		}
		else if((content.charAt(tracker) == 'p'))
		{
			
			if( tracker < content.length()-8 )
			{
				//portList
				if(content.substring(tracker,tracker+8).compareTo("portlist") == 0)
				{
					//need criteria pivot!!!
				}
				//pegList
				if(content.substring(tracker,tracker+7).compareTo("peglist") == 0)
				{
					//need criteria pivot!!!
				}
				//prompt		
				else if(content.substring(tracker,tracker+6).compareTo("prompt") == 0)
				{	
					//need criteria pivot!!!
				}
				//phone
				else if(content.substring(tracker,tracker+5).compareTo("phone") == 0)
				{	
					//need criteria pivot!!!
				}
				//port
				else if(content.substring(tracker,tracker+4).compareTo("port") == 0)
				{	
					//need criteria pivot!!!
				}
				//peg
				else if(content.substring(tracker,tracker+3).compareTo("peg") == 0)
				{
					//need criteria pivot!!!
				}
				else
				{
					//Error 3: Variable is not a valid data type
					result = true;
				}
			}
			else
			{
				//Error 3: Variable is not a valid data type
				result = true;
			}
		}
		else if((content.charAt(tracker) == 's'))
		{
			if( tracker < content.length()-6 )
			{
				//string		
				if(content.substring(tracker,tracker+6).compareTo("string") == 0)
				{	
					//String should be able to store any characters
				}
				else
				{
					//Error 3: Variable is not a valid data type
					result = true;
				}
			}
			else
			{
				//Error 3: Variable is not a valid data type
				result = true;
			}
		}
		else if((content.charAt(tracker) == 't'))
		{
			if( tracker < content.length()-8 )
			{
				//todGroup		
				if(content.substring(tracker,tracker+8).compareTo("todgroup") == 0)
				{	
					//need criteria pivot!!!
				}
				else
				{
					//Error 3: Variable is not a valid data type
					result = true;
				}
			}
			else
			{
				//Error 3: Variable is not a valid data type
				result = true;
			}
		}
		else
		{
			//Error 3: Variable is not a valid data type
			result = true;
		}
		
		
		return result;
		
	}

	private boolean determineDataValue(String input, String dataValue, String content)
	{
		boolean result = false;
		String dataType = input.toLowerCase();
		
		if(dataType.compareTo("boolean") == 0)
		{
			result = isValidBoolean(dataValue);
		}
		else if(dataType.compareTo("cell") == 0)
		{
			result = isValidCell(dataValue, content);
		}
		else if(dataType.compareTo("number") == 0)
		{
			result = isValidNumber(dataValue);
		}
		else if(dataType.compareTo("string") == 0)
		{
			result = isValidString(dataValue);
		}
		else if(dataType.compareTo("dynaprompt") == 0)
		{
			result = isValidDynaPrompt(dataValue);
		}
		else if(dataType.compareTo("name") == 0)
		{
			result = isValidName(dataValue);
		}
		else if(dataType.compareTo("bignumber") == 0)
		{
			result = isValidBigNumber(dataValue);
		}
		else if(dataType.compareTo("prompt") == 0)
		{
			result = isValidPrompt(dataValue, content);
		}
		else if(dataType.compareTo("phone") == 0)
		{
			result = isValidPhone(dataValue);
		}
		else if(dataType.compareTo("port") == 0)
		{
			result = isValidPort(dataValue);
		}
		else if(dataType.compareTo("portlist") == 0)
		{
			result = isValidPortList(dataValue);
		}
		else if(dataType.compareTo("todgroup") == 0)
		{
			result = isValidTodGroup(dataValue);
		}
		else if(dataType.compareTo("peg") == 0)
		{
			result = isValidPeg(dataValue);
		}
		else if(dataType.compareTo("peglist") == 0)
		{
			result = isValidPegList(dataValue);
		}
		else if(dataType.compareTo("enum") == 0)
		{
			result = isValidEnum(dataValue);
		}
		
		return result;
	}
	
	private boolean isValidBoolean(String input)
	{
		//the variable contains yes/no 
		boolean result = false;
		String dataValue = input.toLowerCase();
		
		if(dataValue.compareTo("yes") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("no") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("y") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("n") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("1") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("0") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("true") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("false") == 0)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	private boolean isValidBigNumber(String dataValue)
	{
		/*
		 * the variable contains a number in range -2,147,483,647 
		 * to +2,147,483,647. The restriction is that bignumber 
		 * variables can not be assigned to anything else other 
		 * than other bigNumber variables, they are mainly used by 
		 * host and other custom functions to store big numbers. Big 
		 * numbers can be compared to each other, assigned to each other, etc.
		 */
		boolean result = false;
		int temp = 0;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		if( isInteger(dataValue))
		{
			temp = Integer.parseInt(dataValue);
			
			if( (temp >= -2147483647) && (temp <= 2147483647) )
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
			
			
		return result;
	}
	
	private boolean isValidNumber(String dataValue)
	{
		//the variable contains a number in the range 0 to 32767 
		boolean result = false;
		int temp = 0;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		if( isInteger(dataValue))
		{
			temp = Integer.parseInt(dataValue);
			
			if( (temp >= 0) && (temp <=32767) )
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
			
			
		return result;
	}
	
	private boolean isValidString(String dataValue)
	{
		//the variable contains a string of text up to 248 characters 
		boolean result = false;
		
		if(dataValue.length() <= 248)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	private boolean isValidName(String dataValue)
	{
		//the variable contains a short string of up to 32 characters 
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		if(dataValue.length() <= 32)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	
	
	private boolean isValidPrompt(String dataValue, String Content)
	{
		//the variable contains the name of a prompt defined in the prompts section
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		else
		{
			result = Sandslash.VariableExists(dataValue, "[PROMPTS", Content);
			
		}
		
		return result;
	}
	
	private boolean isValidDynaPrompt(String dataValue)
	{
		/*
		 * the variable contains the dynamic prompts 
		 * which are the actual message string sent 
		 * to the ARU and can be modified at run-time 
		 * by the script. These may be call/user variables 
		 * which are maintained on a per call basis, or 
		 * application/param variables which are kept 
		 * on a per application basis. Note that assignment 
		 * of a normal prompt to dynaPrompt copies the 
		 * message string to the dynaPrompt. Assignment 
		 * of dynaPrompts to normal prompts is not allowed.
		 */
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		return result;
	}
	
	
	
	
	private boolean isValidPhone(String dataValue)
	{
		/*
		 * the variable contains a destination phone number which 
		 * is in the format: phoneNumber,callType,transferType or: 
		 * destinationName,callType,transferType the system ensures 
		 * that the phone# is numeric and the call/transfer types 
		 * are correct, andany referenced destination section is defined
		 */
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		return result;
	}
	
	
	
	
	private boolean isValidCell(String dataValue, String content)
	{
		//the variable contains the name of a cell defined in this application
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		else
		{
			result = Sandslash.isCellValid(dataValue,content);
		}
		
		return result;
	}
	
	private boolean isValidPort(String input)
	{
		//the variable contains a port (in,aru,out or out2) 
		boolean result = false;
		String dataValue = input.toLowerCase();
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		if(dataValue.compareTo("in") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("aru") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("out") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("out2") == 0)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	private boolean isValidPortList(String dataValue)
	{
		//the variable contains a list of ports (in,aru,out,out2) 
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		return result;
	}
	
	private boolean isValidTodGroup(String dataValue)
	{
		//the variable contains the name of a timeOfDayGroup defined in this application script.
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		return result;
	}
	
	private boolean isValidPeg(String dataValue)
	{
		//the variable contains a pegId or peg name
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		return result;
	}
	
	private boolean isValidPegList(String dataValue)
	{
		//the variable contains a list of pegs 
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		return result;
	}
	
	
	
	private boolean isValidEnum(String dataValue)
	{
		/*
		 * the variable contains one of a list of enumerated 
		 * string values. The list of valid values is initially 
		 * specified in the call variables sections. On assignment, 
		 * the variable can be assigned one of the values in 
		 * the list. Internally the values are kept as numbers 
		 * corresponding to their order on the list with the 
		 * first value being assigned number zero. assigning 
		 * "none" to any enumeration is the same as assigning 
		 * it its first value on the list. Multiple enum variables 
		 * which have the exact same enumeration list are considered 
		 * equal types and may be assigned to each other. Call 
		 * and Parameter variables are predefined and their 
		 * enumeration list is also known before hand. therefore 
		 * they can be given in the variables sections with their 
		 * initial value. User and Application variables are defined 
		 * by the script. Therefore their enumaration list must be 
		 * specified in the variables section and they will always 
		 * have the first enum value as their initial value. 
		 */
		
		/*
		 * List is comma delimited restricting to 207 characters for a single element.
		 * List is limited to 207 for its total length
		 * 	This is long enough for 8 25 character strings deliminated by comma.
		 */
		
		boolean result = false;
		int tracker = 0;
		String target = "";
		int startIndex = 0;
		int endIndex = 1;
		boolean scanning = true;
		
		
		if(dataValue.compareTo("none") == 0)
		{
			result = false;
		}
		else if(dataValue.length() <= 207)
		{
			result = true;
		}
		
		return result;
		/*
		for(tracker=0; tracker < dataValue.length(); tracker++)
		{
			if(scanning == false)
			{
				scanning = true;
				startIndex = tracker;
			}
			
			if(dataValue.charAt(tracker) == (','))
			{
				endIndex = tracker;
				target = dataValue.substring(startIndex, endIndex);
				scanning = false;				
			}
			
		}
		*/
		
		
	}
	
	
	
	
	
	private boolean isInteger(String number)
	{
		boolean result = true;
		
		for(int x = 0; x < number.length(); x++)
		{
			if(!((number.charAt(x) == '0') || (number.charAt(x) == '1') || (number.charAt(x) == '2') || (number.charAt(x) == '3') || (number.charAt(x) == '4') || (number.charAt(x) == '5') || (number.charAt(x) == '6') || (number.charAt(x) == '7') || (number.charAt(x) == '8') || (number.charAt(x) == '9'))) 
			{
				return false;
			}
		}
		
		return result;		
	}
	
	
}

