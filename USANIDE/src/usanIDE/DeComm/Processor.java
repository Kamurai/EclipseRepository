package usanIDE.DeComm;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import usanIDE.Colorizer3;
import usanIDE.DataManager;
import usanIDE.Seeker3;
import usanIDE.ThreadTest;

public class Processor 
{
	int enhance = 0;
	//attributes are: keyword, category, color
	ArrayList<ArrayList<String>> keyWords = new ArrayList<ArrayList<String>>();
	String commentColor;

	private Seeker3 Pikachu;
	private Colorizer3 Evee;
	private DataManager Psyduck;
	private ThreadTest Ghastly;
	
	// output result
	String output = "";

	Processor() 
	{
		Pikachu = new Seeker3();
		Evee = new Colorizer3();
		Psyduck = new DataManager();
		// output result
		output = "";
		commentColor = "1285661"; //pivot change to pull from keyWords somehow
		
		
		Ghastly = new ThreadTest("",keyWords,commentColor);
	}
	
	Processor(ArrayList<ArrayList<String>> input) 
	{
		Pikachu = new Seeker3();
		Evee = new Colorizer3();
		Psyduck = new DataManager();
		// output result
		output = "";
		commentColor = "1285661"; //pivot change to pull from keyWords somehowr
		keyWords = new ArrayList<ArrayList<String>>(input);
		
		Ghastly = new ThreadTest("",keyWords,commentColor);
	}
	
	Processor(JTextPane targetBox, ArrayList<ArrayList<String>> input) 
	{
		Pikachu = new Seeker3();
		Evee = new Colorizer3(targetBox, input);
		Psyduck = new DataManager();
		// output result
		output = "";
		commentColor = "1285661"; //pivot change to pull from keyWords somehowr
		keyWords = new ArrayList<ArrayList<String>>(input);
		
		Ghastly = new ThreadTest("",keyWords,commentColor);
	}
	
	Processor(JTextPane targetBox, ArrayList<ArrayList<String>> input, JScrollPane targetScroll) 
	{
		Pikachu = new Seeker3();
		Evee = new Colorizer3(targetBox, input, targetScroll);
		Psyduck = new DataManager();
		// output result
		output = "";
		commentColor = "1285661"; //pivot change to pull from keyWords somehowr
		keyWords = new ArrayList<ArrayList<String>>(input);
		
		Ghastly = new ThreadTest("",keyWords,commentColor);
	}
	
	
	public void setKeyWords(ArrayList<ArrayList<String>> input)
	
	{
		keyWords = input;
	}

	public void setThreadTarget(JTextPane textpane, JTextPane output)
	{
		Ghastly.setTarget(textpane);
	}
	
	public void startThreadTarget()
	{
		Ghastly.start();
	}
	
	public void colorByThread2(JTextPane textpane, JTextPane output, JScrollPane scrollpane)
	{
		ArrayList<ArrayList<String>> master = new ArrayList<ArrayList<String>>();
		
		//if( Evee.getHighlights().length > 0)
		if( textpane.getHighlighter().getHighlights().length > 0)
		{
			textpane.getHighlighter().removeAllHighlights();
			//Evee.removeAllHighlights();
		}
		
		//seek comments to color
		master = Ghastly.getMasterColorList();
		
		//color it all
		if(master.size() != 0)
		{
			Evee.ColorItAll4(textpane,master,scrollpane);
		}
	}
	
	public void colorByThread(JTextPane textpane, JTextPane output)
	{
		ArrayList<ArrayList<String>> master = new ArrayList<ArrayList<String>>();
		
		//if( Evee.getHighlights().length > 0)
		if( textpane.getHighlighter().getHighlights().length > 0)
		{
			textpane.getHighlighter().removeAllHighlights();
			//Evee.removeAllHighlights();
		}
		
		//seek comments to color
		master = Ghastly.getMasterColorList();
		
		//color it all
		if(master.size() != 0)
		{
			Evee.ColorItAll3(textpane,master);
		}
	}
	
	public void seekToColor2(JTextPane textpane, JTextPane output, JScrollPane scrollpane)
	{
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> master = new ArrayList<ArrayList<String>>();
		
		//if( Evee.getHighlights().length > 0)
		if( textpane.getHighlighter().getHighlights().length > 0)
		{
			textpane.getHighlighter().removeAllHighlights();
			//Evee.removeAllHighlights();
		}
		
		//seek comments to color
		master = Pikachu.seekInOrder(textpane.getText(), keyWords, commentColor);
		
		//at this point master has all positions to paint
		//remove overlapping highlights
		//master = Psyduck.RemoveMasterOverlaps(master);
		//color it all
		if(master.size() != 0)
		{
			Evee.ColorItAll4(textpane,master,scrollpane);
		}
	}
	
	public void seekToColor(JTextPane textpane, JTextPane output)
	{
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> master = new ArrayList<ArrayList<String>>();
		
		//if( Evee.getHighlights().length > 0)
		if( textpane.getHighlighter().getHighlights().length > 0)
		{
			textpane.getHighlighter().removeAllHighlights();
			//Evee.removeAllHighlights();
		}
		
		//seek comments to color
		master = Pikachu.seekInOrder(textpane.getText(), keyWords, commentColor);
		/*
		result = Pikachu.findComments(textpane.getText());
			//add to master
		for(int x = 0; x < result.size(); x++)
		{
			//add desired color to target list
			result.get(x).add(commentColor); //add comment color
			
			//add to Master List
			//master = Psyduck.addToMasterBinary(result.get(x), master);
			//master.add(new ArrayList<Integer>(result.get(x)));
		}
		master = Psyduck.addToMasterWhole(result, master);
		*/
		//pivot: this section takes to long to color
			//possibly due to number of keyWords
		//seek keWords to color
		/*
		for(int x = 0; x < keyWords.size(); x++)
		{
			//search for a key word
			result = Pikachu.regexIt(keyWords.get(x).get(0),textpane.getText());  //.toLowerCase(),textpane.getText().toLowerCase()); //
			//interpret locations of key word
			for(int y = 0; y < result.size(); y++)
			{
				if(result.get(y).get(0) == (-1))
				{
					break;
				}
				else
				{
					//add desired color to target list
					result.get(y).add(Integer.parseInt((keyWords.get(x).get(2))));
					
					//add to Master List
					//master = Psyduck.addToMasterBinary(result.get(y), master);
					//master.add(new ArrayList<Integer>(result.get(y)));
				}
			}
			master = Psyduck.addToMasterWhole(result, master);
		}	
		*/
		
				
		//at this point master has all positions to paint
		//remove overlapping highlights
		//master = Psyduck.RemoveMasterOverlaps(master);
		//color it all
		if(master.size() != 0)
		{
			Evee.ColorItAll3(textpane,master);
		}
	}
	

	public ArrayList<ArrayList<String>> processDoc(String input)
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		int limit = input.length();
		int start = 0;
		int end   = 0;
		int keyLimit = keyWords.size();
		String target = "";
		int tracker = 0;

		//check string character by character
		for(int x = 0; x < limit; x++)
		{
			if(Character.isSpaceChar(input.charAt(x)))
			{
				break;
			}
			else if(input.length() > 1)
			{
				 if((input.charAt(x) == '/' && (input.charAt(x+1) == 'n')) )
				 {
					break; 
				 }
				 else if( x > 0 )
				 {
					 if((input.charAt(x) == 'n') && (input.charAt(x-1) == '/'))
					 {
						 break;
					 }
				 }
			}
				 
			//for each character
			for(int y = x; y < limit; y++)
			{
				//determine end of word
				if(Character.isSpaceChar(input.charAt(y)))
				{
					//mark start and end of word
					start = x;
					end   = (y);
					target = input.substring(start, end);
					x = y;
					break;
				}
				else if( y == (limit - 1)) //end of document
				{
					y++; //compensate for end of document
					
					//mark start and end of word
					start = x;
					end   = (y);
					target = input.substring(start, end);
					x = y;
					break;
				}
				else if( y < (limit-1) )
				{
					
					if( (input.charAt(y) == '/' && (input.charAt(y+1) == 'n') ))
					{
						//mark start and end of word
						start = x;
						end   = (y);
						target = input.substring(start, end);
						x = y;
						break;
					}
				}
				
			}
			//check word against keywords based on start and end
			for(int y = 0; y < keyLimit; y++)
			{
				//if a keyword
				if(target.compareTo(keyWords.get(y).get(0)) == 0)
				{
					//add start, end and color
					output.add(new ArrayList<String>());
					output.get(tracker).add(Integer.toString(start));
					output.get(tracker).add(Integer.toString(end));
					output.get(tracker).add( String.valueOf(keyWords.get(y).get(2)));
					tracker++;
					target = "";
					start = 0;
					end   = 0;
					break;
				}
				
				//if word does not match any keyWords
				
				if( y == (keyLimit-1))
				{
					output.add(new ArrayList<String>());
					output.get(tracker).add(Integer.toString(start));
					output.get(tracker).add(Integer.toString(end));
					output.get(tracker).add( String.valueOf(Color.BLACK.getRGB()));
					tracker++;
					target = "";
					start = 0;
					end   = 0;
				}
				
			}
			
			
			
		}
		
		return output;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getOutput() 
	{
		return output;
	}
	
}
