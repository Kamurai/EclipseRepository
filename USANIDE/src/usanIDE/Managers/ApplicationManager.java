package usanIDE.Managers;

import java.util.ArrayList;

public class ApplicationManager 
{
	ManagerHelper Sandslash;
	ArrayList<String> ValueList = new ArrayList<String>();
	String filename;
	
	public ApplicationManager()
	{
		this.filename = "default.htkb";
		Sandslash = new ManagerHelper();
		
		ValueList.add("name");
		ValueList.add("description");
		ValueList.add("filename");
		ValueList.add("id");
		ValueList.add("startingCell");
		ValueList.add("serviceId");
		ValueList.add("billingTask");
		ValueList.add("cdrFormat");
		ValueList.add("cdrEnabled");
		ValueList.add("noInitialAru");
	}
	
	public void setFilename(String input)
	{
		
		this.filename = input;
		
		
	}
	
	
	//Action: Ensure name is assigned (Warning)
	//Action: Ensure filename is assigned and matches actual filename ("Application filename does not match filename entry")
	//Action: Ensure starting cell is assigned ("Required starting cell name is missing")

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
		String SectionTitle = "[APPLICATION]";
		String NextSectionTitle = "[CALL_VARIABLES]";
		int tracker = 0;
		
		int errorType = 0;
		String dataType = "";
		
		String potentialWord = "";
		char testChar = '0';
		
		boolean initialCommentLine = true;
		
		
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
			//find "[APPLICATION]"
				//if not too far in the string
			if( tracker < content.length()-SectionTitle.length() )
			{
				//if "[APPLICATION]" is found
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
				//find "[CALL_VARIABLES]"
					//if not too far in the string
				if( tracker < content.length()-NextSectionTitle.length() )
				{
					//if "[CALL_VARIABLES]" is found
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
						
						if(content.charAt(tracker) == '\n')
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
							continue;
						}
						else
						{
							//ensure non-comment fits section format
							startIndex = tracker;
							startofVariableIndex = tracker;
							
							tracker = Sandslash.findEndOfWord(tracker, content);
							testChar = content.charAt(tracker);
							
							
							endIndex = tracker;
							potentialWord = content.substring(startIndex,endIndex);
							
							valuesloop:
							//must be one of the key variables allowed in this section
							for(int x = 0; x < ValueList.size(); x++)
							{
								if(potentialWord.compareTo(ValueList.get(x)) == 0)
								{
									endofVariableIndex = tracker;
									
									//scan text until equal sign, comment, space, return or end of file
									for(; tracker < content.length(); tracker++)
									{
										testChar = content.charAt(tracker);
										
										if(content.charAt(tracker) == ' ')
										{
											continue;
										}
										else if(content.charAt(tracker) == ';')
										{
											tracker = Sandslash.findEndOfLine(tracker, content);
											testChar = content.charAt(tracker);
											
											//Error 7: There is no assignment for this variable.
											errorType = 7;
											errorFound = true;
											break valuesloop; //pivot: this should stop scanning on this line altogether
										}
										else if(content.charAt(tracker) == '/' && (tracker != content.length()-1))
										{
											if(content.charAt(tracker+1) == '*')
											{
												startIndex = tracker;
												
												tracker = Sandslash.findEndOfLine(tracker, content);
												testChar = content.charAt(tracker);
												
												//Error 9: There is an inappropriate start of comment block.
												errorType = 9;
												errorFound = true;
												
												//pivot: this should cause an error "misplaced comment block start"
												break valuesloop; //this should stop scanning on this line altogether
											}
										}
										else if(content.charAt(tracker) == '=')
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
												if(!determineDataValue(ValueList.get(x), content.substring(startIndex, tracker), content))
												{
													errorFound = true;
													//Error 4: Variable does not meet data type criteria.
													errorType = 4;
													//break;

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
															break;
														}
														else if((content.charAt(tracker) == ';'))
														{
															tracker = Sandslash.findEndOfLine(tracker, content);
															break; //pivot: this should stop scanning on this line altogether
														}
														else if((content.charAt(tracker) == '/') && tracker < content.length()-1 )
														{
															if((content.charAt(tracker) == '*'))
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
															break;
														}
														else
														{
															startIndex = tracker;
															
															tracker = Sandslash.findEndOfLine(tracker, content);
															testChar = content.charAt(tracker);
															
															//Error 6: Remove the excess information.
															errorType = 6;
															errorFound = true;
															break;
														}
													}
												}
											}
											break valuesloop;
										}
									}
								}
								//after done comparing target word against the values list
								if(x == ValueList.size()-1)
								{
									//skip to end of line
									tracker = Sandslash.findEndOfLine(tracker, content);
									testChar = content.charAt(tracker);
								}
								
							}
							
							if(errorFound)
							{
								endIndex = tracker;
								
								if(errorType == 1)
								{
									//priority = 2;
									//description = "Line does not contain a call or user variable.";
								}
								else if(errorType == 2)
								{
									/*
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
									*/
								}
								else if(errorType == 3)
								{
									//priority = 2;
									//description = "Variable is not a valid data type.";
								}
								else if(errorType == 4)
								{
									priority = 2;
									description = "Variable does not meet data type criteria";
								}
								else if(errorType == 5)
								{
									//priority = 2;
									//description = "Invalid prompt: please ensure that all prompt sections define this prompt.";
								}
								else if(errorType == 6)
								{
									priority = 2;
									description = "Remove the excess information.";
								}
								else if(errorType == 7)
								{
									priority = 1;
									description = "There is no assignment for this variable.";
									
									startIndex = startofVariableIndex;
									endIndex = endofVariableIndex;
								}
								else if(errorType == 8)
								{
									//priority = 3;
									//description = "Variable does not appear in application.";
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
	
	private boolean determineDataValue(String input, String dataValue, String content)
	{
		boolean result = false;
		String dataType = input.toLowerCase();
		String lowCase = dataValue.toLowerCase();
		int dataLength = 0;
		
		if(dataType.compareTo("name") == 0)
		{
			//single word matching filename minus ".app" 
			//limited to 32 characters
			result = Sandslash.isValidName(lowCase);
		}
		else if(dataType.compareTo("description") == 0)
		{
			//multi word statement
			//limited to 207 characters
			dataLength = lowCase.length();
			if( dataLength > 207)
			{
				result = false;
			}
			else
			{
				result = Sandslash.isValidString(lowCase);
			}
		}
		else if(dataType.compareTo("filename") == 0)
		{
			//single word matching filename to include ".app"
			//limit of "8" characters per the twiki
			if( lowCase.length() > 32)
			{
				result = false;
			}
			else if(lowCase.length() < 3) //must include ".app"
			{
				result = false;
			}
			else if(filename == "default.htkb")
			{
				result = true;
			}
			else if(lowCase.substring(lowCase.length()-4,lowCase.length()).compareTo(".app") != 0)
			{
				result = false;
			}
			else
			{
				result = Sandslash.isValidName(lowCase);				
			}
			
			if(result)
			{
				if(lowCase.compareTo(filename) == 0)
				{
					result = true;
				}
				else
				{
					result = false;
				}
			}
		}
		else if(dataType.compareTo("id") == 0)
		{
			//limited to 4 characters
			if( dataType.length() > 4)
			{
				result = false;
			}
			else
			{
				result = Sandslash.isValidName(lowCase);
			}
		}
		else if(dataType.compareTo("version") == 0)
		{
			//numeric
			result = Sandslash.isValidNumber(lowCase);
		}
		else if(dataType.compareTo("startingcell") == 0)
		{
			//must be a valid cell in the code section
			result = Sandslash.isCellValid(dataValue,content);
		}
		else if(dataType.compareTo("serviceid") == 0)
		{
			/*
			 *  serviceId put in USAN CDR for this call, 
			 *  assigned by USAN. If the c_serviceId variable is set, 
			 *  it will be used instead. This allows the service Id to 
			 *  be changed during the call. 
			 */
			
			result = false;
		}
		else if(dataType.compareTo("billingtask") == 0)
		{
			/*
			 * billing task name which generates CDRs for this application, 
			 * assigned by USAN 
			 */
			result = false;
		}
		else if(dataType.compareTo("cdrformat") == 0)
		{
			/*
			 * format of CDRs generated for this application, 
			 * assigned by USAN 
			 */
			result = false;
		}
		else if(dataType.compareTo("cdrenabled") == 0)
		{
			//defaulted to yes
			/*
			 * whether CDRs are generated for this application
			 */
			result = Sandslash.isValidBoolean(lowCase);
		}
		else if(dataType.compareTo("noinitialaru") == 0)
		{
			/*
			 *  if set to yes, the application does not get an
             *  aru at the start of the call
			 */
			result = Sandslash.isValidBoolean(lowCase);
		}
		
		return result;
	}
	
}
