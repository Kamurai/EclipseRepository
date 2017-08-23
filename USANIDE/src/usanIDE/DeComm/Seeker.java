package usanIDE.DeComm;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class Seeker 
{

	
	public Seeker()
	{
		
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
