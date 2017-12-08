package usanIDE;

//import javax.faces.bean.SessionScoped;
import java.awt.Color;
import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;


/**
 * 
 * @author Chris Kemerait
 */
public class MainController 
{
	private FileManager Snuffit;
	private Processor2 Snorlax;
	private List<String> targetfiles;
	private TextpaneEditor Chimchar;
	private Seeker3 Pikachu;
	
	private String filename;
	
	
	public MainController() 
	{
		Snuffit = new FileManager("USANIDE_reference.txt");
		Snorlax = new Processor2(Snuffit.pullKeyWords());
		targetfiles = new ArrayList<String>();
		Chimchar = new TextpaneEditor();
		

		for (int x = 0; x < 2; x++) 
		{
			targetfiles.add("");
		}		
		
		//populate keyWords
		//Snorlax.setKeyWords(Snuffit.pullKeyWords());
		
		
	}
	
	public MainController(JTextPane targetBox) 
	{
		Snuffit = new FileManager("USANIDE_reference.txt");
		Snorlax = new Processor2(targetBox, Snuffit.pullKeyWords());
		targetfiles = new ArrayList<String>();
		Chimchar = new TextpaneEditor();
		

		for (int x = 0; x < 2; x++) 
		{
			targetfiles.add("");
		}		
		
		//populate keyWords
		//Snorlax.setKeyWords(Snuffit.pullKeyWords());
		
		
	}
	
	public MainController(JTextPane targetBox,JTextPane outputBox) 
	{
		Snuffit = new FileManager("USANIDE_reference.txt");
		Snorlax = new Processor2(targetBox, Snuffit.pullKeyWords(), outputBox);
		targetfiles = new ArrayList<String>();
		Chimchar = new TextpaneEditor();
		

		for (int x = 0; x < 2; x++) 
		{
			targetfiles.add("");
		}		
		
		//populate keyWords
		//Snorlax.setKeyWords(Snuffit.pullKeyWords());
		this.filename = "default.htkb";
		
	}
	
	public String separateFilename(String input)
	{
		return Snuffit.separateFilename(input);
	}
	
	public void setFilename(String input)
	{
		this.filename = input;
		Snorlax.setFilename(filename);
	}
	
	public String getLocalupdates(int x) 
	{
		return targetfiles.get(x);
	}

	public List<String> getLocalupdates() 
	{
		return targetfiles;
	}
	
	public void setLocalupdates(List<String> localupdates) {
		this.targetfiles = localupdates;
	}

	public void SaveLineToFile(String input)
	{
		Snuffit.SaveLineToReference(input);
	}
	
	public void SaveToFile(String input)
	{
		Snuffit.SaveToFile(input);
	}
	
	public String GetLineFromFile(int index)
	{
		return Snuffit.GetLineFromFile(index);
	}
	
	public void ClearReferenceFile()
	{
		Snuffit.ClearReferenceFile();
	}
	
	public String LoadFile(String input)
	{
		//have Processor read through file
		//String output = Snuffit.PullFile(input);
		//try
		//{
			return Snuffit.PullFile2(input);
			//return Snuffit.SpeedPullFile(input);
		//}
		//catch(IOException e)
		//{
			//return "Failure";
		//}
		//return file contents to pass to the editing screen.
		//return output;
	}
	
	public ArrayList<ArrayList<String>> processDoc(String input)
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		
		output = Snorlax.processDoc(input);
		
		return output;
		
	}
	
	public boolean Colorize(String input)
	{
		boolean result = false;
		
		
		return result;
	}
	
	public BoldAction getBoldAction()
	{
		
		return Chimchar.getBoldAction();
	}
	
	public ItalicAction getItalicAction()
	{
		
		return Chimchar.getItalicAction();
	}
	
	public ColorAction getColorAction()
	{
		
		return Chimchar.getColorAction();
	}
	
	public void setColorAction(Color input)
	{
		Chimchar.setColor(input);
	}
	
	public String getColorNow()
	{
		return Chimchar.getColorNow();
	}
	
	public void setColorRange(int start, int end)
	{
		Chimchar.setRange(start,end);
	}
	
	public void setColorPane(JTextPane input)
	{
		Chimchar.setPane(input);
	}
	
	public ArrayList<Integer> findIt(JTextPane targetPane, String target)
	{
		return Pikachu.findIt(targetPane,target);
	}
	
	public void seekToColor(JTextPane textpane, JTextPane output)
	{
		Snorlax.seekToColor(textpane, output);
	}
	
	public void seekToColor2(JTextPane textpane, JTextPane output, JScrollPane scrollpane)
	{
		Snorlax.seekToColor2(textpane, output, scrollpane);
	}
	
	public void colorByThread(JTextPane textpane, JTextPane output)
	{
		Snorlax.colorByThread(textpane, output);
	}
	
	public void colorByThread(JTextPane textpane, JTextPane output, JScrollPane view)
	{
		Snorlax.colorByThread3(textpane, output, view);
	}
	
	public void setThreadTarget(JTextPane textpane, JTextPane output)
	{
		Snorlax.setThreadTarget(textpane, output);
	}
	
	public void beginThreadTarget()
	{
		Snorlax.beginThreadTarget();
	}
	
	public void startThreadTarget()
	{
		Snorlax.startThreadTarget();
	}
	
	public void stopThreadTarget()
	{
		Snorlax.stopThreadTarget();
	}
	
	public void setupThreads(JTextPane textpane, JScrollPane scrollpane)
	{
		Snorlax.setupThreads(textpane,scrollpane);
	}
	
	public void setupThreads(JTextPane textpane, JScrollPane scrollpane, JTextPane outpane)
	{
		Snorlax.setupThreads(textpane,scrollpane,outpane);
	}
	
	public void setRun(boolean input)
	{
		Snorlax.setRun(input);
	}
}
