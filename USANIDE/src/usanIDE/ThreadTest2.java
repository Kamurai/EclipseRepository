package usanIDE;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ThreadTest2 extends Thread
{
	private Seeker3 Pikachu;
	private USANCompiler Rhydon;
	
	private Colorizer3 Evee;
	
	private String content;
	ArrayList<ArrayList<String>> masterColorList;
	ArrayList<ArrayList<String>> masterHighlightList;
	ArrayList<ArrayList<String>> keyWords;
	String commentColor;
	
	String filename;
	
	JTextPane target;
	JTextPane output;
	JScrollPane view;
	
	private boolean colorIt = true;
	private boolean highlightIt = true;
	private boolean outputIt = true;
	
	int contentSize = 1;
	int timeLimit = 3000;
	int timeCurrent = 0;
	
	private boolean runIt = true;

	
	public ThreadTest2(String content, ArrayList<ArrayList<String>> keyWords, String commentColor)
	{
		Pikachu = new Seeker3();
		Rhydon = new USANCompiler();
		
		this.content =content;
		this.masterColorList = new ArrayList<ArrayList<String>>();
		this.keyWords = keyWords;
		this.commentColor = commentColor;
	}
	
	public ThreadTest2(String content, ArrayList<ArrayList<String>> keyWords, String commentColor, JTextPane textpane, JScrollPane scrollpane)
	{
		Pikachu = new Seeker3();
		Rhydon = new USANCompiler();
				
		this.content =content;
		this.masterColorList = new ArrayList<ArrayList<String>>();
		this.keyWords = keyWords;
		this.commentColor = commentColor;
		this.target = textpane;
		this.view = scrollpane;
		
		Evee = new Colorizer3(textpane, scrollpane);
		
	}
	
	public ThreadTest2(String content, ArrayList<ArrayList<String>> keyWords, String commentColor, JTextPane textpane, JScrollPane scrollpane, JTextPane outpane)
	{
		this.filename = "default.htkb";		

		Pikachu = new Seeker3();
		Rhydon = new USANCompiler();
				
		this.content =content;
		this.masterColorList = new ArrayList<ArrayList<String>>();
		this.keyWords = keyWords;
		this.commentColor = commentColor;
		this.target = textpane;
		this.view = scrollpane;
		this.output = outpane;
		
		Evee = new Colorizer3(textpane, scrollpane);
		
	}
	
	
	public void run()
	{
		contentSize = 1;
		while(true)
		{
			while((runIt) && (contentSize != 0))
			{
				try
				{
				//target.getText().length();
				//while((contentSize != 0))
				//{
					
						//if( (contentSize != target.getText().length()) )//|| (timeCurrent == timeLimit) ) //pivot: this does not allow equal length replacement to update 
						//{
							
								masterColorList = Pikachu.seekInOrder(target.getText(), keyWords, commentColor);
								masterHighlightList = Rhydon.compileInOrder(target.getText());
								
								//if colorIt is true, then color
								if(colorIt)
								{
									//if(masterColorList.size() > 0)
									{
										Evee.ColorItAll5(target,masterColorList);//,view);
										//colorIt = false; //pivot: always on works as desired, but this is useful for debugging
									}
								}
								if(outputIt)
								{
									printOutput(masterHighlightList);
									//outputIt = false;
								}
								//if highlightIt is true, then highlight
								if(highlightIt)
								{
									//if(masterHighlightList.size() > 0)
									{
										Evee.HighlightItAll(target,masterHighlightList);
										//highlightIt = false;
										
										
									}
									
								}
								
							
							contentSize = target.getText().length();
							//pivot: if lists can be combined with an additional parameter of whether the target is to be colored or highlighted, then 
								//the entire document can be completely colored in "one" pass
							
							
							//timeCurrent = 0;
						//}
					
					//timeCurrent++;
							runIt = false;
				//}
				}
				catch(NullPointerException ex)
				{
					
				}
			}
		}
	}
	
	public void setFilename(String input)
	{
		
		this.filename = input;
		
		Rhydon.setFilename(filename);
	}
	
	public void startIt()
	{
		runIt = true;
	}
	
	public void stopIt()
	{
		runIt = false;
	}
	
	private void printOutput(ArrayList<ArrayList<String>> input)
	{
		String setup = "";
		
		
		output.setText("");
		
		for(int x = 0; x < input.size(); x++)
		{
			if(input.get(x).get(4).compareTo("3") == 0)
			{
				setup += "Warning";
			}
			else if(input.get(x).get(4).compareTo("2") == 0)
			{
				setup += "Error";
			}
			else if(input.get(x).get(4).compareTo("1") == 0)
			{
				setup += "Fatal Error";
			}
			
			setup += ": @ Line: ";
			setup += input.get(x).get(2);
			setup += "\t\t";
			setup += "@ Position: ";
			setup += Integer.toString(Integer.parseInt(input.get(x).get(0))-Integer.parseInt(input.get(x).get(5))+1);
			setup += "\t\t";
			setup += " to : ";
			setup += Integer.toString(Integer.parseInt(input.get(x).get(1))-Integer.parseInt(input.get(x).get(5))+1); //(Integer.parseInt(input.get(x).get(1))-1);
			setup += "\t\t";
			setup += input.get(x).get(3);
			setup += "\t\t";
			
			setup += "\n";
			
			
		}
		output.setText(setup);
	}
	
	public String getContent()
	{
		
		return content;
	}
	
	public ArrayList<ArrayList<String>> getMasterColorList()
	{
		
		return masterColorList;
	}
	
	public ArrayList<ArrayList<String>> getMasterCompileList()
	{
		
		return masterHighlightList;
	}
	
	public void setContent(String input)
	{
		content = input;
	}
	
	public void setTarget(JTextPane textpane)
	{
		target = textpane;
		content = target.getText();
	}
	
	public void startColor()
	{
		colorIt = true;
	}
	
	public void startHighlight()
	{
		highlightIt = true;
	}
	
	public void setTools()
	{
		Evee = new Colorizer3();
		Rhydon = new USANCompiler();
	}
	
	public void setColorizer()
	{
		Evee = new Colorizer3();
	}
	
	public void setCompiler()
	{
		Rhydon = new USANCompiler();
	}
	
	public void setTargets(JTextPane textpane, JScrollPane scrollpane)
	{
		target = textpane;
		view = scrollpane;
	}
	
	public void setTargets(JTextPane textpane, JScrollPane scrollpane, JTextPane outpane)
	{
		target = textpane;
		view = scrollpane;
		output = outpane;
		contentSize = 1;
	}
	
	public void startOutput()
	{
		outputIt = true;
	}
	
	public void startAll()
	{
		startColor();
		startHighlight();
		startOutput();
		contentSize = 1;
	}
	
	public void setRun(boolean input)
	{
		runIt = input;
	}
}
