package output;

public abstract class PrintUtility 
{
	public static String newFileSpacer()
	{
		String result = "-1";
		
		//add whitespace line
		result = "\n";
		//add new file line
		result += "Start of new file results:";
		//add whiespace line
		result += "\n";
		
		return result;
	}
	
	public static String newFileSpacer(int pageNumber)
	{
		String result = "-1";
		
		//add whitespace line
		result = "\n";
		//add new file line
		result += "Start of file " + pageNumber + " results:";
		//add whiespace line
		result += "\n";
		
		return result;
	}
	
	public static String newFileSpacer(String fileName)
	{
		String result = "-1";
		
		//add whitespace line
		result = "\n";
		//add new file line
		result += "Start of file " + fileName + "  results:";
		//add whiespace line
		result += "\n";
		
		return result;
	}
	
}
