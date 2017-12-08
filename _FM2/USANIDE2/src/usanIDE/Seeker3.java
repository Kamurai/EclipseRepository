package usanIDE;

import java.awt.Component;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

public class Seeker3 
{
	RegexCreature Staryu = new RegexCreature();

	
	public Seeker3()
	{
		
	}
	
	//much faster, but problematic with larger files, possibly due to size of keyWords list
	public ArrayList<ArrayList<String>> seekInOrder(String content, ArrayList<ArrayList<String>> keyWords, String commentColor)
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		ArrayList<String> sub = new ArrayList<String>();
		
		boolean seeking = true;
		int mode = 0;
		char testChar = '0';
		
		int startIndex = 0;
		int endIndex = 0;
		
		if(content.length() == 0)
		{
			//sub.add(-1);
			//output.add(sub);
			return output;
		}
		
		//seek content from start to finish:
		for(int x = 0; x < content.length(); x++)
		{
			testChar = content.charAt(x);
			
			if(seeking)
			{
				if( content.charAt(x) == ' ' || content.charAt(x) == '\n')
				{
					//do nothing, let for loop advance
					
					//check to see if this is an endpoint for a keyword
					
					
				}
				//identify comment indicators
				else if(content.charAt(x) == ';')
				{
					//turn off seeking unless appropriate end comment is found
					seeking = false; //turn off seeking
					mode = 1; //single line comment mode
					sub.add(Integer.toString(x)); //add beginning of location to paint
				}
				//identify comment indicators
				else if(content.charAt(x) == '/' && (x != content.length()-1))
				{
					if(content.charAt(x+1) == '*')
					{
						//turn off seeking unless appropriate end comment is found
						seeking = false; //turn off seeking
						mode = 2; //multi-line comment mode
						sub.add(Integer.toString(x)); //add beginning of location to paint
						x++; //we know what x+1 is, and don't care 
					}
				}
				else //treat it as if we may have found a word
				{
					seeking = false; //turn off seeking
					mode = 3; //find a word mode
					startIndex = x; //add beginning of location to paint
					
				}

			//identify words (beginning of line or space to space or end of line)
				//building while loop to end of word
			//determine if keyword
				//for loop through key Words
			//record target indices
				//add( index )

			}
			else
			{
				if(mode == 1) //single line comment mode
				{
					if(content.charAt(x) == '\n')// && x != content.length())
					{
						//if(content.charAt(x+1) == 'n')
						//{
							//sub.add(Integer.toString(x-1)); //add ending of location to paint    //pivot: fixes error, but does not color to end of line
							//sub.add(Integer.toString(x)); //add ending of location to paint
							sub.add(Integer.toString(x+1)); //add ending of location to paint  //pivot: a single line comment followed directly by a multi-line comment causes and error
							mode = 0; //reset mode
							seeking = true; //turn seeking back on
							sub.add(commentColor);
							sub.add("Comment");
							//x++; //we know what x+1 is, and don't care
							output.add(new ArrayList<String>(sub));
							sub.clear();
						//}
					}
					else if(x == content.length()-1)
					{
						sub.add(Integer.toString(x+1)); //add ending of location to paint
						sub.add(commentColor);
						sub.add("Comment");
						output.add(new ArrayList<String>(sub));
					}
				}
				else if(mode == 2) //multi-line comment mode
				{
					if(content.charAt(x) == '*' && (x != content.length()-1))
					{
						if(content.charAt(x+1) == '/')
						{
							sub.add(Integer.toString(x+2)); //add ending of location to paint
							mode = 0; //reset mode
							seeking = true; //turn seeking back on
							sub.add(commentColor);
							sub.add("Comment");
							output.add(new ArrayList<String>(sub));
							sub.clear();
							x++; //we know what x+1 is, and don't care
							
						}
					}
					else if(x == content.length()-1)
					{
						sub.add(Integer.toString(x+1)); //add ending of location to paint
						sub.add(commentColor);
						sub.add("Comment");
						output.add(new ArrayList<String>(sub));
					}
				}
				else if(mode == 3) //find a word mode
				{
					if((content.charAt(x) == ' ') || (content.charAt(x) == '\n') ||(x == content.length()-1))// && x != content.length())
					{
						endIndex = x;
						
						for(int y = 0; y < keyWords.size(); y++)
						{
							if(content.substring(startIndex, endIndex).compareTo(keyWords.get(y).get(0)) == 0)
							{
								sub.add(Integer.toString(startIndex));
								sub.add(Integer.toString(endIndex));
								sub.add(keyWords.get(y).get(2));
								sub.add(keyWords.get(y).get(3));
								output.add(new ArrayList<String>(sub));
								sub.clear();
								break;
							}
						}
						
						mode = 0; //reset mode
						seeking = true; //turn seeking back on
						
					}
				}
				
				
			}
			
			
			
		}
		
		
		
		return output;
	}
	
	
	
	
	public ArrayList<ArrayList<Integer>> findComments(String content)
	{
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>(findSingleLineComments(content));

		ArrayList<ArrayList<Integer>> append = new ArrayList<ArrayList<Integer>>(findMultiLineComments(content));
		
		for(int x = 0; x < append.size(); x++)
		{
			output.add(new ArrayList<Integer>(append.get(x)));
		}

		return output;
	}
	
	private ArrayList<ArrayList<Integer>> findSingleLineComments(String content)
	{
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sub = new ArrayList<Integer>();

		String subject = ";";
		String regex = "";
		
		int startIndex = 0;
		int endIndex = 0;
		
		regex = subject; 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);

		String subject2 = "\n";
		String regex2   = "";
		
		regex2 = subject2; 
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(content);
				
		while (matcher.find() == true)
		{	
			startIndex = matcher.start();
			
			if(matcher2.find(startIndex) == true)
			{
				//find the first "end of line" past the start point
				if(matcher2.start() > startIndex)
				{
					endIndex = matcher2.start();
				}
			}
			
			sub.add(startIndex);
			sub.add(endIndex);
			output.add(new ArrayList<Integer>(sub));
			sub.clear();
		}
		
		return output;
	}
	
	private ArrayList<ArrayList<Integer>> findMultiLineComments(String content)
	{
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sub = new ArrayList<Integer>();

		String subject = "\\/\\*";
		String regex = "";
		
		int startIndex = 0;
		int endIndex = content.length();
		
		regex = subject; 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);

		String subject2 = "\\*\\/";
		String regex2   = "";
		
		regex2 = subject2; 
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(content);
				
		
		while (matcher.find() == true)
		{	
			startIndex = matcher.start();

			if(matcher2.find(startIndex) == true)
			{
				//find the first "end of line" past the start point
				if(matcher2.start() > startIndex)
				{
					endIndex = matcher2.start() + 2;
				}
			}
			
			sub.add(startIndex);
			sub.add(endIndex);
			output.add(new ArrayList<Integer>(sub));
			sub.clear();
		}
		
		return output;
	}
	
	
	public ArrayList<ArrayList<Integer>> regexIt(String word, String content)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sub = new ArrayList<Integer>();
		
		if (word == null || word.equals("") || (content == null || content.equals(""))) 
		{
			result.add(new ArrayList<Integer>());
			result.get(0).add(-1);
		}
		
		String subject = Staryu.TranslateToRegexWholeWord(word);
		
		String regex = "";
		
		regex = subject; 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		
		int startIndex = 0;
		int endIndex = 0;
		
		//pivot: long time for not found
		while (matcher.find() == true)
		{	
			startIndex = matcher.start();
			endIndex = matcher.end();
			
			sub.add(startIndex);
			sub.add(endIndex);
			result.add(new ArrayList<Integer>(sub));
			sub.clear();
		}
		
		return result;
		
	}
	
	public ArrayList<ArrayList<Integer>> searchIt(String word, String content)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sub = new ArrayList<Integer>();
		
		int firstOffset = -1;
		
		int lastIndex = 0;
		int wordSize = word.length();
		
		if (word == null || word.equals("") || (content == null || content.equals(""))) 
		{
			result.add(new ArrayList<Integer>());
			result.get(0).add(-1);
		}
		
		while ((lastIndex = content.indexOf(word, lastIndex)) != -1)
		{	
			int endIndex = lastIndex + wordSize;
			
			sub.add(lastIndex);
			sub.add(endIndex);
			result.add(new ArrayList<Integer>(sub));
			sub.clear();
			
			if (firstOffset == -1) 
			{
				firstOffset = lastIndex;
			}
			lastIndex = endIndex;
		}
				
		return result;
		
	}
	
	public ArrayList<Integer> findIt(JTextPane targetPane, String target)
	{
		ArrayList<Integer> targetList = new ArrayList<Integer>();
		Document d = targetPane.getDocument();
		
		int targetLength = target.length();
		int start = 0;
		int end = 0;
		int docLength = 0;
		int result = 0;
		
		String content = null;
		try {
			d = targetPane.getDocument();
			content = d.getText(0, d.getLength()).toLowerCase();
		} 
		catch (BadLocationException e) 
		{
			// Cannot happen
			//return -1;
		}

		docLength = content.length();
		
		target = target.toLowerCase();
		
		
		//loop until:
		while( result != (-1) )
		{
		//find a beginning of an instance of the target
		result = content.indexOf(target, result);
			if( result != (-1))
			{
					start = result;
					//set end of the instance
					end = start + targetLength;
					//set pair to list
					targetList.add(start);
					targetList.add(end);
					result += targetLength;
			}
			
		}
		
		return targetList;
	}
	
	
}
