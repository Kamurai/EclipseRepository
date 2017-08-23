package usanIDE.Managers;

import java.util.ArrayList;

public class Digit_PromptsManager 
{
	ManagerHelper Sandslash;
	
	public Digit_PromptsManager()
	{
		Sandslash = new ManagerHelper();
	}
	
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
		String SectionTitle = "[DIGIT_PROMPTS ";
		String NextSectionTitle = "[GENERAL]";
		int tracker = 0;
		int errorType = 0;
		String dataType = "";
		
		String potentialWord = "";
		char testChar = '0';
		String CurrentSection = "";
		
		boolean initialCommentLine = true;
		boolean customPrompt = true;
		
		ArrayList<ArrayList<String>> PromptSectionsList = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> PromptSectionsDuplicateList = new ArrayList<ArrayList<String>>();
		boolean BuildingDuplicatePromptSection = false;
		int startofSectionIndex = 0;

		PromptSectionsList = Sandslash.GetPromptSectionsList(SectionTitle, NextSectionTitle, content);
		
		//if the sections aren't found
		if(PromptSectionsList.size() == 0)
		{
			//then don't check for errors
			return output;
		}
		else
		{
			//separate the duplicate sections
			for(int x = 0; x < PromptSectionsList.size(); x++)
			{
				for(int y = 0; y < PromptSectionsList.size(); y++)
				{
					//if the first matches the beginning of the second
					if(PromptSectionsList.get(x).get(0).compareTo(PromptSectionsList.get(y).get(0).substring(0,PromptSectionsList.get(x).get(0).length())) == 0)
					{
						if(PromptSectionsList.get(y).get(0).length() > PromptSectionsList.get(x).get(0).length())
						{
							PromptSectionsDuplicateList.add(PromptSectionsList.get(y));
							PromptSectionsList.remove(y);
						}
					}
				}
			}
			
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
			//find "[DIGIT_PROMPTS "
				//if not too far in the string
			if( tracker < content.length()-SectionTitle.length() )
			{
				//if "[DIGIT_PROMPTS " is found
				if(content.substring(tracker,(tracker+SectionTitle.length())).compareTo(SectionTitle) == 0)
				{
					tracker = tracker + SectionTitle.length();
					testChar = content.charAt(tracker);
					startofSectionIndex = tracker;
					tracker = Sandslash.findEndOfWordUntilRBracket(tracker,content);
					CurrentSection = content.substring(startofSectionIndex,tracker);
					if((CurrentSection.length() == 0) || content.charAt(tracker) != ']')
					{
						//Error 13: "Sub Section is not declared correctly."
						errorFound = true;
						errorType = 13;
						
					}
					
					//determine if new sub section is a dependent section
					for(int x = 0; x < PromptSectionsDuplicateList.size(); x++)
					{
						if(CurrentSection.compareTo(PromptSectionsDuplicateList.get(x).get(0)) == 0)
						{
							BuildingDuplicatePromptSection = true;
							break;
						}
						else
						{
							BuildingDuplicatePromptSection = false;
						}
					
					}
					
					sectionFound = true;
					//tracker += SectionTitle.length();
					tracker = Sandslash.findEndOfLine(tracker, content);
					testChar = content.charAt(tracker);
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
				//find "[GENERAL] "
					//if not too far in the string
				if( tracker < content.length()-NextSectionTitle.length() )
				{
					//if "[GENERAL] " is found
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
							if(content.charAt(tracker) == '\n')
							{
								line++;
								if(tracker < (content.length()-1))
								{
									lineIndex = (tracker +1);
								}
							}
							continue;
						}
						else
						{
							//if line does not start with a new section
							if((content.charAt(tracker) != '['))
							{
								//if digit prompt is a valid declaration (assumed)
								
								startIndex = tracker;
								startofVariableIndex = tracker;
								
								tracker = Sandslash.findEndOfWord(tracker, content);
								testChar = content.charAt(tracker);
								
								
								endIndex = tracker;
								endofVariableIndex = tracker;
								
								potentialWord = content.substring(startIndex,endIndex);
								
								if((potentialWord.length() > 32) || (potentialWord.length() < 1))
								{
									errorFound = true;
									errorType = 11; //"Variable does not meet size requirements."
									//break;
								}
								//is a Duplicate in the Same section
								else if(Sandslash.DigitPromptVariableIsDuplicate(potentialWord, CurrentSection, startofVariableIndex, endofVariableIndex, content))
								{
									errorFound = true;
									errorType = 12; //"Variable is declared elsewhere in this section."
									tracker = Sandslash.findEndOfLine(tracker, content);
									//break;													
								}
								//is in a dependent subsection e.g. "ENGLISH 1"
								else if(BuildingDuplicatePromptSection)
								{
									//Does not have a duplicate in the base subsection
									if(!Sandslash.DigitPromptVariableIsDuplicate(potentialWord, Sandslash.FindBaseSection(CurrentSection, PromptSectionsList), startofVariableIndex, endofVariableIndex, content))
									{
										errorFound = true;
										errorType = 15; //"Prompt does not appear in base language sub section."
										tracker = Sandslash.findEndOfLine(tracker, content);
										//break;													
									}
								}
								//does not have a Duplicate in all other prompt sub sections
								else if(!Sandslash.DigitPromptVariableHasAlternate(potentialWord, PromptSectionsList, CurrentSection, startofVariableIndex, endofVariableIndex, content))
								{
									errorFound = true;
									errorType = 14; //"Prompt does not appear in another sub section."
									tracker = Sandslash.findEndOfLine(tracker, content);
									//break;													
								}
								//does not exist in code
								/*
								else if(!Sandslash.DigitPromptVariableInCode(potentialWord,content))
								{
									errorFound = true;
									errorType = 16; //"Prompt does not appear in the code."
									tracker = Sandslash.findEndOfLine(tracker, content);
									//break;													
								}
								*/
								
									
								
								if(!errorFound)
								{
									//dataType will always be "Prompt"
									promptloop:
									//scan text until equal sign, comment, space, return or end of file
									for(; tracker < content.length(); tracker++)
									{
										testChar = content.charAt(tracker);
										//if space
										if( (content.charAt(tracker) == ' ') )
										{
											continue; //skip space
										}
										else if(content.charAt(tracker) == ';')
										{
											tracker = Sandslash.findEndOfLine(tracker, content);
											testChar = content.charAt(tracker);
											
											//Error 7: There is no assignment for this variable.
											errorType = 7;
											errorFound = true;
											break promptloop; //this should stop scanning on this line altogether
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
												
												//this should cause an error "misplaced comment block start"
												break promptloop; //this should stop scanning on this line altogether
											}
										}
										//if '='
										else if((content.charAt(tracker) == '='))
										{
											//found equals
											tracker++; //skip equals
											testChar = content.charAt(tracker);
											
											if((content.charAt(tracker) == '\n') || (content.charAt(tracker) == ' ') || (content.charAt(tracker) == ';')) //pivot? ' ' should maybe loop until a not ' ' is found
											{
												tracker = Sandslash.findEndOfLine(tracker, content);
												testChar = content.charAt(tracker);
												
												/*
												if(content.charAt(tracker) == '\n') //pivot?: should this update the line where the error are entered in the output
												{
													line++;
													if(tracker < (content.length()-1))
													{
														lineIndex = (tracker +1);
													}
												}
												*/
												
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
												//pivot: needs to compensate for { to } prompts
											
												if((content.charAt(tracker) == '{') || (content.charAt(tracker) == 'M') || (content.charAt(tracker) == 'P'))
												{
													if((content.charAt(tracker) == '{'))
													{
														customPrompt = true;
													}
													else if((content.charAt(tracker) == 'M') || (content.charAt(tracker) == 'P'))
													{
														customPrompt = false;
													}
													
													startIndex = tracker;
													tracker++;
													testChar = content.charAt(tracker);
													
													//scan assignment value
													for(; tracker < content.length(); tracker++)
													{
														testChar = content.charAt(tracker);
														//if return, or comment
														
														if(customPrompt)
														{
															//if '}'
															if((content.charAt(tracker) == '}'))
															{
																tracker++;
																potentialWord = content.substring(startIndex, tracker);
																	//validate custom prompt
																if(!Sandslash.isValidCustomPrompt(potentialWord, content))
																{
																	errorFound = true;
																	tracker = Sandslash.findEndOfLine(tracker, content);
																	testChar = content.charAt(tracker);
																	
																	
																	break;
																}
																else
																{
																	//startIndex = tracker;
																	//tracker--;
																	customPrompt = false;
																	errorFound = false;
																	
																	
																	tracker = Sandslash.findEndOfLine(tracker, content);
																	break;
																}
															}
															//if "special" character
															else if((content.charAt(tracker) == '^') || (content.charAt(tracker) == '&') || (content.charAt(tracker) == '*'))
															{
																startIndex = tracker;
																endIndex = tracker+1;
																
																errorFound = true;
																break;
															}
															//else
															else if((content.charAt(tracker) == ' '))
															{
																continue;
															}
															else
															{
																if((content.charAt(tracker) == '\n') || (content.charAt(tracker) == ';')) //pivot: finding space in a custom prompt should not go to end of line
																{
																	tracker = Sandslash.findEndOfLine(tracker, content);
																	testChar = content.charAt(tracker);
																	
																	/*
																	if(content.charAt(tracker) == '\n')
																	{
																		line++;
																		if(tracker < (content.length()-1))
																		{
																			lineIndex = (tracker +1);
																		}
																	}
																	*/
																	
																	//Error 7: There is no assignment for this variable.
																	errorType = 7;
																	errorFound = true;
																	break;
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
																		break;
																	}
																}
																else
																{
																	continue;
																}
															}
														}
														else
														{
															/*
															if((content.charAt(tracker) == '{'))
															{
																startIndex = tracker;
																customPrompt = true;
															}
															else if((content.charAt(tracker) == 'M') || (content.charAt(tracker) == 'P'))
															{
																potentialWord = content.substring(startIndex, tracker);  //pivot
																
																if(!Sandslash.isValidPrompt(potentialWord, content))
																{
																	errorFound = true;
																	break;
																}
																else
																{
																	errorFound = false;
																}
																startIndex = tracker;
																
															}
															*/
															
															if((content.charAt(tracker) == '{') || (content.charAt(tracker) == 'M') || (content.charAt(tracker) == 'P'))
															{
																potentialWord = content.substring(startIndex, tracker);
																
																if(!Sandslash.isValidPrompt(potentialWord, content))
																{
																	errorFound = true;
																	tracker = Sandslash.findEndOfLine(tracker, content);
																	break;
																}
																else
																{
																	errorFound = false;
																}
																
																startIndex = tracker;
																if((content.charAt(tracker) == '{'))
																{
																	customPrompt = true;
																}
															}
															else
															{
																if((content.charAt(tracker) == '\n') || (content.charAt(tracker) == ' ') || (content.charAt(tracker) == ';')) //pivot this cause an error at the end of the properly declared prompt
																{
																	potentialWord = content.substring(startIndex, tracker);
																	
																	if(!Sandslash.isValidPrompt(potentialWord, content))
																	{
																		//Error 4: "Variable does not meet data type criteria"
																		errorType = 4;
																		errorFound = true;
																		break;
																	}
																	else
																	{
																		errorFound = false;
																	}
																	
																	//if a space
																	if((content.charAt(tracker) == ' '))
																	{
																		for(; tracker < content.length(); tracker++)
																		{
																			if((content.charAt(tracker) == ' '))
																			{
																				continue;
																			}
																			else
																			{
																				//if a space with no "words" following it, minus comments
																				if((content.charAt(tracker) == '\n') || (content.charAt(tracker) == ';')) //pivot this cause an error at the end of the properly declared prompt
																				{
																					break;
																				}
																				else 	//if a space eventually followed by a "word"
																				{
																					//Error 4: "Variable does not meet data type criteria"
																					errorType = 4;
																					errorFound = true;
																					break;
																				}
																			}
																		}
																	}
																	
																	
																	
																	startIndex = tracker-1;
																	
																	tracker = Sandslash.findEndOfLine(tracker, content);
																	testChar = content.charAt(tracker);
																	break; //pivot?
																}
																else if((content.charAt(tracker) == '/') && tracker < content.length()-1 )
																{
																	if((content.charAt(tracker) == '*'))
																	{
																		potentialWord = content.substring(startIndex, tracker);
																		
																		if(!Sandslash.isValidPrompt(potentialWord, content))
																		{
																			//Error 7: There is no assignment for this variable.
																			errorType = 7;
																			errorFound = true;
																			
																		}
																		else
																		{
																			startIndex = tracker;
																			
																			//Error 9: There is an inappropriate start of comment block.
																			errorType = 9;
																			errorFound = true;
																			errorFound = false;
																		}
																		
																		tracker = Sandslash.findEndOfLine(tracker, content);
																		testChar = content.charAt(tracker);
																		break;
																	}
																}
																else
																{
																	continue;
																}
																
															}
														}
														
														
													}
												}
												else
												{
													startIndex = tracker; //target the data value for errors	
													//tracker = findEndOfLine(tracker, content);
													tracker = Sandslash.findEndOfWord(tracker, content);
													testChar = content.charAt(tracker);
													
													//Error 4: Variable does not meet data type criteria
													errorType = 4;
													errorFound = true;
												}
											}
											
											if(errorFound == true)
											{
												if(!(errorType == 7) || (errorType == 9))
												{
													//Ensure variable is a valid based on data type 
													//Error 4: Variable does not meet data type criteria
																										
													errorType = 4;
												}
												break promptloop;
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
														/*
														if(content.charAt(tracker) == '\n')
														{
															line++;
															if(tracker < (content.length()-1))
															{
																lineIndex = (tracker +1);
															}
														}
														*/
														errorFound = false;
														break promptloop;
													}
													else if((content.charAt(tracker) == ';'))
													{
														tracker = Sandslash.findEndOfLine(tracker, content);
														break promptloop;
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
															break promptloop;
															
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
							else if((content.charAt(tracker) == '['))
							{
								if( tracker < content.length()-SectionTitle.length() )
								{
									//if new "[DIGIT_PROMPTS " is found
									if(content.substring(tracker,(tracker+SectionTitle.length())).compareTo(SectionTitle) == 0)
									{
										tracker = tracker + SectionTitle.length();
										testChar = content.charAt(tracker);
										startofSectionIndex = tracker;
										tracker = Sandslash.findEndOfWordUntilRBracket(tracker,content);
										testChar = content.charAt(tracker);
										CurrentSection = content.substring(startofSectionIndex,tracker);
										if((CurrentSection.length() == 0) || content.charAt(tracker) != ']')
										{
											//Error 13: "Sub Section is not declared correctly."
											errorFound = true;
											errorType = 13;
											
										}
										
										//determine if new sub section is a dependent section
										for(int x = 0; x < PromptSectionsDuplicateList.size(); x++)
										{
											if(CurrentSection.compareTo(PromptSectionsDuplicateList.get(x).get(0)) == 0)
											{
												BuildingDuplicatePromptSection = true;
												break;
											}
											else
											{
												BuildingDuplicatePromptSection = false;
											}
										
										}
										tracker = Sandslash.findEndOfLine(tracker, content);
										testChar = content.charAt(tracker);
									}
								}
							}							
							else
							{
								//Error 1: Line does not contain a prompt variable
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
									description = "Line does not contain an prompt.";
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
									priority = 3;
									description = "Variable is declared elsewhere in this section.";
								}
								else if(errorType == 13)
								{
									priority = 2;
									description = "Sub Section is not declared correctly.";
								}
								else if(errorType == 14)
								{
									priority = 3;
									description = "Prompt does not appear in another sub section.";
								}
								else if(errorType == 15)
								{
									priority = 3;
									description = "Prompt does not appear in base language sub section.";
								}
								else if(errorType == 16)
								{
									priority = 3;
									description = "Prompt does not appear in the code.";
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
}