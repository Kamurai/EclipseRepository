package hello_world;

public class World 
{
	public static void main (String[] args)
	{
	//this is a single line of comment
	/*
	 * this
	 * is 
	 * a
	 * block 
	 * of
	 * comment
	 */
	
	//Your assignment is to write a solution to print out
		//"Hello World!" on the console
	
	//print "Hello World!"
		System.out.println(Message(1));
		System.out.print(Message(2));
		System.out.println(Message(3));
	}
	
	public static String Message(int i)
	{
		String result = "Hello World!";
		return result;
	}
	
	
	
}
