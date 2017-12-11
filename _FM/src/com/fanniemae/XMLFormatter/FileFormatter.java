package com.fanniemae.XMLFormatter;

public class FileFormatter 
{
	//Current features:
		//add eol (\n) where applicable
		//add indent (\t) where applicable
		//add mismo where applicable
	
	//Future features:
		//remove mismo when not used?	
		//remove spaces inside tags
		//form embedded pdf correctly
	
	//debug flags
	private boolean debug = true;
			
	//feature flags
	private boolean flagUseMismo = true;
	private boolean flagGSE = false;
	private boolean flagMISMOReferenceModelIdentifier = false;
	
	public FileFormatter()
	{
	}
	
	public FileFormatter(boolean debug)
	{
		this.debug = debug;
	}
	
	public String formatContent(String contentString)
	{
		StringBuilder result = new StringBuilder();
		boolean ignoreWhitespace = true;
		String status = "outside";
		int indentCount = 0;
		String previousCharacter = "";
		String currentCharacter = "";
		String nextCharacter = "";
		
		//traverse Content string 
		for(int x = 0; x < contentString.length(); x++)
		{
			if( x > 0)
			{
				previousCharacter = contentString.substring(x-1, x);
			}
			
			currentCharacter = contentString.substring(x, x+1);
			//System.out.println(character);
			
			
			if( x < contentString.length()-2 )
			{
				nextCharacter = contentString.substring(x+1, x+2);
			}
			
			//if ' ' or '\t' is found
			if( currentCharacter.equals(" ") || currentCharacter.equals("\t") )
			{
				//if ignoreWhitespace is true
				if(!ignoreWhitespace)
				{
					//if 4 space tab
					if( checkNamespace(contentString, x, "    ") )
					{
						//write \t
						//result += "\t";
						result.append("\t");
					}
					else
					{
						//write character
						//result += currentCharacter;
						result.append(currentCharacter);
					}
				}
			}
			//if < is found
			else if( currentCharacter.equals("<") )
			{
				//stop ignoring whitespace
				ignoreWhitespace = false;
				
				//if next character is '/', then current tag is ending tag
				if( nextCharacter.equals("/") )
				{
					//decrease indent count
					indentCount--;
					
					//if previous character is ' ', '\t', or '>'
					if( previousCharacter.equals(" ") || previousCharacter.equals("\t") || previousCharacter.equals(">"))
					{
						//insert tabs based on indentCount
						for(int y = 0; y < indentCount; y++)
						{
							//result += "\t";
							result.append("\t");
						}
					}
					
					//write '/'
					//result += currentCharacter + "/";
					result.append(currentCharacter + "/");
					x++;
					
					//check for Namespaces
					if( !checkNamespaces(contentString, x+1) )
					{
						//if using mismo
						if(flagUseMismo)
						{
							//check for mismo
							if( !checkNamespace(contentString, x+1, "mismo:") )
							{
								//result += "mismo:";
								result.append("mismo:");
							}
						}
						//if not using mismo
						else
						{
							//check for mismo
							if( checkNamespace(contentString, x+1, "mismo:") )
							{
								//skip "mismo:"
								x += 6;
							}
						}
					}
					
				}
				//else if ?, then start of metadata tag
				else if( nextCharacter.equals("?") )
				{
					//insert tabs based on indent count
					for(int y = 0; y < indentCount; y++)
					{
						//result += "\t";
						result.append("\t");
					}
					
					//write character
					//result += currentCharacter;
					result.append(currentCharacter);
				}
				//else if !, then a comment
				else if( nextCharacter.equals("!") )
				{
					//insert tabs based on indent count
					for(int y = 0; y < indentCount; y++)
					{
						//result += "\t";
						result.append("\t");
					}
					
					//write character
					//result += currentCharacter;
					result.append(currentCharacter);
				}
				else //starting tag
				{
					//insert tabs based on indent count
					for(int y = 0; y < indentCount; y++)
					{
						//result += "\t";
						result.append("\t");
					}
					
					//increase indent count
					indentCount++;
					
					//write character
					//result += currentCharacter;
					result.append(currentCharacter);
					
					//check for Namespaces
					if( !checkNamespaces(contentString, x+1) )
					{
						//if using mismo
						if(flagUseMismo)
						{
							//check for mismo
							if( !checkNamespace(contentString, x+1, "mismo:") )
							{
								//result += "mismo:";
								result.append("mismo:");
							}
						}
						//if not using mismo
						else
						{
							//check for mismo
							if( checkNamespace(contentString, x+1, "mismo:") )
							{
								//skip "mismo:"
								x += 6;
							}
						}
					}
				}
			}
			//if > is found
			else if( currentCharacter.equals(">") )
			{
				if( previousCharacter.equals("/") )
				{
					indentCount--;
				}
				
				//write character
				//result += currentCharacter;
				result.append(currentCharacter);
				
				//if next character is last character
				if( x+1 == contentString.length()-1 )
				{
					if( nextCharacter.equals("<") )
					{
						//add eol to result
						//result += "\n";
						result.append("\n");
					}
				}
				//if next character is '<' or '\t' or '\n' or 4 space tab
				else if( nextCharacter.equals("<") || nextCharacter.equals("\t") || nextCharacter.equals("\n") || checkNamespace(contentString, x+1, "    "))
				{
					//start ignoring whitespace
					ignoreWhitespace = true;
					
					//add eol to result
					//result += "\n";
					result.append("\n");
				}
			}
			else if( currentCharacter.equals("\n") )
			{
				//start ignoring whitespace
				ignoreWhitespace = true;
				
				//add eol to result
				//result += "\n";
				result.append("\n");
			}
			else
			{
				//if not whitespace
				if( !(currentCharacter.equals(" ") || currentCharacter.equals("\t")) )
				{
					//write character
					result.append(currentCharacter);
				}
			}
		}
		
		return result.toString();
	}
	
	//check for existing expected namespaces
	private boolean checkNamespaces(String contentString, int contentIndex)
	{
		boolean result = false;
		
		if( checkNamespace(contentString, contentIndex, "gse:") )
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	//check for Namespace (gse: or mismo:)
	private boolean checkNamespace(String contentString, int contentIndex, String namespace)
	{
		boolean result = false;
		
		//if namespace could occur
		if( contentIndex + namespace.length() < contentString.length() )
		{
			if( contentString.substring(contentIndex, contentIndex+namespace.length()).equals(namespace) )
			{
				result = true;
			}
		}
		
		return result;		
	}
	
	//globalize references
	String globalizeReferences(String contentString)
	{
		String result = contentString;
		
		//globalize xmlns:gse="http://www.datamodelextension.org"
		if(flagGSE)
		{
			result = globalizeReference(contentString, "xmlns:gse=\"http://www.datamodelextension.org\"");
		}
		
		//globalize MISMOReferenceModelIdentifier="3.3.0299"
		if(flagMISMOReferenceModelIdentifier)
		{
			result = globalizeReference(contentString, "MISMOReferenceModelIdentifier=\"3.3.0299\"");
		}
		
		return result;		
	}
	
	//globalize single reference	
	private String globalizeReference(String contentString, String reference)
	{
		String result = "";
		
		result = injectReference(contentString, reference);
		
		result = removeReference(contentString, reference);
		
		return result;		
	}
	
	//inject single reference in the header
	private String injectReference(String contentString, String reference)
	{
		StringBuilder result = new StringBuilder();
		
		String beforeString = "";
		String afterString = "";
		
		char character = ' ';
		boolean complete = false;
		
		String targetMessage = "";
		
		if( flagUseMismo )
		{
			targetMessage = "</mismo:MESSAGE>";
		}
		else
		{
			targetMessage = "</MESSAGE>";
		}
		
		//traverse Content string 
		for(int x = 0; x < contentString.length(); x++)
		{
			//find target message
				//if target message could occur
			if( x + targetMessage.length() < contentString.length() )
			{
				//check if target message occurs
				if( contentString.substring(x, x+targetMessage.length()).equals(targetMessage) )
				{
					//traverse Content string backwards from x
					for(int y = x; y > 0; y--)
					{
						//if > was found
						if( contentString.substring(y, y+1).equals(">") )
						{
							//collect characters before injection point
							beforeString = contentString.substring(0, y-1);
							
							//collect characters after injection point
							afterString = contentString.substring(y, contentString.length()-1);
							
							//set result to before characters
							//result = beforeString;
							result = new StringBuilder(beforeString);
							
							
							//add injection string to result
							//result += reference;
							result.append(reference);
							
							//add after string to result
							//result += afterString;
							result.append(afterString);
							
							complete = true;
						}
						
						if(complete)
						{
							break;
						}
					}
				}
			}
			
			
			if(complete)
			{
				break;
			}			
		}
		
		return result.toString();		
	}
	
	//remove single reference throughout file
	private String removeReference(String contentString, String reference)
	{
		StringBuilder result = new StringBuilder();
		
		String beforeString = "";
		String afterString = "";
		
		String targetMessage = "";
		
		if( flagUseMismo )
		{
			targetMessage = "</mismo:MESSAGE>";
		}
		else
		{
			targetMessage = "</MESSAGE>";
		}
		
		int contentIndex = 0;
		
		
		//traverse Content string 
		for(int x = 0; x < contentString.length(); x++)
		{
			//if target message could occur
			if( x + targetMessage.length() < contentString.length() )
			{
				//check if target message occurs
				if( contentString.substring(x, x+targetMessage.length()).equals(targetMessage) )
				{
					//set Index from which to start removing references
					contentIndex += targetMessage.length();
					break;
				}
			}
		}
		
		//traverse Content string 
		for(int x = contentIndex; x < contentString.length(); x++)
		{
			//if reference could occur
			if( x + reference.length() < contentString.length() )
			{
				//check if reference occurs
				if( contentString.substring(x, x+reference.length()).equals(reference) )
				{
					//collect characters before injection point
					beforeString = contentString.substring(0, x-1);
					
					//update x to skip reference
					x += reference.length();
					
					//collect characters after injection point
					afterString = contentString.substring(x, contentString.length()-1);
					
					//set result to before characters
					//result = beforeString;
					result.append(beforeString);
					
					//add after string to result
					//result += afterString;
					result.append(afterString);
				}
			}
		}
		
		return result.toString();		
	}
}