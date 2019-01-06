package output;

import java.util.ArrayList;
import java.util.List;

public abstract class Printer {
	
	public static void printList(List<String> subjectList)
	{
		for(int x = 0; x < subjectList.size(); x++)
		{
			System.out.println(subjectList.get(x));
		}
	}
	
	public static String printToTextArea(List<String> subjectList)
	{
		String result = "";
		
		for(int x = 0; x < subjectList.size(); x++)
		{
			result += subjectList.get(x) + "\n";
		}
		
		return result;
	}
}
