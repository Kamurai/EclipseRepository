package usanIDE.Managers;

import java.util.ArrayList;

public class CodeManager 
{
	ManagerHelper Sandslash;
	
	public CodeManager()
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
		int startofCell = 0;
		//End Position
		int endIndex = 1;
		int endofVariableIndex = 1;
		int endofCell = 1;
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
		String SectionTitle = "";
		String NextSectionTitle = "[PROMPTS";
		int tracker = 0;
		int errorType = 0;
		
		String dataType = "";
		
		String potentialWord = "";
		char testChar = '0';
		String CurrentSection = "";
		
		boolean initialCommentLine = true;
		
		boolean NewLine = true;
		
		Cell TestCell = new Cell();
		
		
		//find start cell name
		
		//set SectionTitle as "starting cell name"
		SectionTitle = Sandslash.FindStartCellName(content);
		
		if( SectionTitle.compareTo("(-1)") != 0)
		{
			SectionTitle = Sandslash.FindStartCell(SectionTitle,content);
		}
		
		if( SectionTitle.compareTo("(-1)") == 0)
		{
			return output; //fail
		}
		
		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			// find start cell
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if start cell is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					tracker += SectionTitle.length();
					tracker ++; //skip assumed space
					
					sectionFound = true;
					break;
					
				} 
				/*
				else 
				{
					return false; // fail
				}
				*/
			}
		}
	
		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if Prompts section is found
					potentialWord = content.substring(tracker,(tracker + NextSectionTitle.length()));
					if (potentialWord.compareTo(NextSectionTitle) == 0) 
					{
						return output; //reach end with no duplicates
					}

					potentialWord = content.substring(tracker,(tracker + SectionTitle.length()));
					// if new prompts section  is found
					if (potentialWord.compareTo(SectionTitle) == 0) 
					{
						return output; //reach end with no duplicates
					}
	
					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						 {
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
							tracker = Sandslash.findEndOfLine(tracker, content); //skip to end of line
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/'	&& (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								//tracker++; // we know what x+1 is, and don't care
								tracker = Sandslash.findEndOfLine(tracker, content); //skip to end of line
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					}
					
					if (mode == 1) // single line comment mode
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
					else if (mode == 2) // multi-line comment mode
					{
						if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
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
						else if (tracker == content.length() - 1) 
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
					else if (mode == 3) // not a comment mode
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
								NewLine = true;
							}
							continue;
						}
						else
						{
							//treat non-comment as a possible variable
							//if '[' is found: new cell
							if(content.charAt(tracker) == '[')
							{
								//wrap up old cell
								//is old cell valid
								if(true)
								{
									//assumed valid for moment
									
									startofVariableIndex = tracker;
									tracker = Sandslash.findEndOfWord(startIndex, content);
									endofVariableIndex = tracker;
									
									potentialWord = content.substring(startofVariableIndex,endofVariableIndex);
									
									//is the new cell type valid?
									if(Sandslash.IsApprovedCellType(potentialWord))
									{
										//yes:  track new cell
										TestCell = new Cell(potentialWord);
										
										//scan text until comment, or return or end of file
										for(; tracker < content.length(); tracker++)
										{
											if( (content.charAt(tracker) == ' ') )
											{
												continue; //skip space
											}
											else if( (content.charAt(tracker) == '\n') )
											{
												//report error: name of cell not declared
											}
											else if( (content.charAt(tracker) == ';') )
											{
												//report error: name of cell not declared
											}
											else if( !(tracker < content.length()-1) )
											{
												//report error: premature end of file
											}
											else if (content.charAt(tracker) == '/'	&& (tracker != content.length() - 1)) 
											{
												if (content.charAt(tracker + 1) == '*') 
												{
													//report error: premature start of comment block
													
												}
											}
											else
											{
												startofVariableIndex = tracker;
												tracker = Sandslash.findEndOfWord(startIndex, content);
												endofVariableIndex = tracker;
												
												potentialWord = content.substring(startofVariableIndex,endofVariableIndex);
												
												//is the new cell name valid?
												if(Sandslash.IsApprovedCellName(potentialWord))
												{
													//then set cell name
													TestCell.setName(potentialWord);
													
													//is the next character a ']'?
													if((content.charAt(tracker) == ']'))
													{
														//check until end of line
														tracker = Sandslash.findEndOfLineOrComment(tracker, content);
														//if block comment is found before return
														if((content.charAt(tracker) == '/') && (tracker < content.length()-1))
														{
															if((content.charAt(tracker+1) == '*'))
															{
																//report error
																break;
															}
														}
														
														
													}
												}
												else
												{
													//no: report error
														//invalid cell name (bad character)
												}
											}
										}
									}
									else
									{
										//no: report error
											//cell type not recognized
									}
								}
								else
								{
									//no: report error
								}
								//tracker++;
								
								
								
							}
							//is not a '['
							else
							{
								//treat non-comment as a possible variable
								startofVariableIndex = tracker;
								tracker = Sandslash.findEndOfWord(startIndex, content);
								endofVariableIndex = tracker;
								
								potentialWord = content.substring(startofVariableIndex,endofVariableIndex);
								
								//if variable is "externalFunction"
								if(potentialWord.compareTo("externalFunction") == 0)
								{
									//yes: skip spaces until equals is found
							
										//if return or comment is found first
											//report error
										//else: validate external function
											//no: report error
											//yes: ensure dependencies are available
								}
								//if variable is keyword for cell type
								else if(Sandslash.IsApprovedCellVariable(potentialWord))
								{
										//yes: skip space until equals is found
											//if return or comment is found first
												//report error
											//else: validate keyword assignment
								}
								//if variable is a declared call, user or application variable
								else if( (Sandslash.CallVariableInCode(potentialWord,content)) || (Sandslash.ApplicationVariableInCode(potentialWord,content)) || (Sandslash.IsApprovedCellVariable(potentialWord)) )
								{
										
										//if a call variable (c_) or a user variable (u_) or an application variable (a_)
										if((potentialWord.substring(0,2).compareTo("c_") == 0) || (potentialWord.substring(0,2).compareTo("u_") == 0) || (potentialWord.substring(0,2).compareTo("a_") == 0))
										{
											//if a call variable (c_)
											if(potentialWord.substring(0,2).compareTo("c_") == 0)
											{
												//validate against a list of c_vars
												if(!Sandslash.IsApprovedCellVariable(potentialWord))
												{
													//report error
												}
											}
											//if a user variable (u_)
											else if(potentialWord.substring(0,2).compareTo("u_") == 0)
											{
												//validate against declared u_vars
												if(!Sandslash.VariableExists(potentialWord, "[CALL_VARIABLES]", content))
												{
													//report error
												}
											}
											//if an application variable (a_)
											else if(potentialWord.substring(0,2).compareTo("a_") == 0)
											{
												//validate against declared a_vars
												if(!Sandslash.VariableExists(potentialWord, "[APPLICATION_VARIABLES]", content))
												{
													//report error
												}
											}
											
											//if no error is found
											if(!errorFound)
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
													else if(content.charAt(tracker) == ';')
													{
														tracker = Sandslash.findEndOfLine(tracker, content);
														testChar = content.charAt(tracker);
														
														//Error 7: There is no assignment for this variable.
														errorType = 7;
														errorFound = true;
														break; //this should stop scanning on this line altogether
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
															break; //this should stop scanning on this line altogether
														}
													}
													//if '='
													else if((content.charAt(tracker) == '='))
													{
														//found equals
														tracker++; //skip equals
														testChar = content.charAt(tracker);
														
														//if return or comment is found first
															//yes: report error
															//no: assignment found
																//if valid assignment
																	//yes:  check until end of line
																		//if block comment is found before return
																			//report error
													}
													else
													{
														//report error
													}
												}
											}
										}
										else
										{
												//no: report error
										}
								}
								else
								{
									//no: report error
								}
							}
							
							//treat non-comment as a possible variable
								//if variable is "externalFunction"
									//yes: skip spaces until equals is found
										//if return or comment is found first
											//report error
										//else: validate external function
											//no: report error
											//yes: ensure dependencies are available
								//if variable is keyword for cell type
										//yes: skip space until equals is found
											//if return or comment is found first
												//report error
											//else: validate keyword assignment
								//if variable is a declared call, user or application variable
										//yes: skip space until equals is found
											//if return or comment is found first
												//report error
											//else:
												//if a call variable (c_)
													//validate against a list of c_vars
												//if a user variable (u_)
													//validate against declared u_vars
												//if an application variable (a_)
													//validate against declared a_vars
														
														//yes: skip spaces until equals is found
															//if return or comment is found first
																//yes: report error
																//no: assignment found
																	//if valid assignment
																//yes:  check until end of line
																		//if block comment is found before return
																			//report error
																//no: report error
														//no: report error
							
									
														
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
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
