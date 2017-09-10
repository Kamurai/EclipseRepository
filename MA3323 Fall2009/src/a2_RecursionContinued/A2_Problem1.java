package a2_RecursionContinued;

public class A2_Problem1
{
	/****
	 * The following example is a really bad use of recursion.  
	 * The method just finds the square of the parameter passed to the method
	 * We can EASILY do this by just using the math class and just squaring the argument!	 * 
	 */
	
	public static void main (String[] args)
	{
		//simple section of code to return a number in seconds of how long it takes to execute recursive logic of method
			//On my laptop I get a time of 9seconds to calculate the function for [35]
			//let's try vbrf(36) now to see if we can get 18seconds..
		long t0 = System.nanoTime();
		int test = vbrf(36);
		long t1 = System.nanoTime();
		double seconds = (t1-t0)*1.0e-9;
		System.out.println("The time it takes to calculate [vbrf(36)] is: " + seconds + " seconds!");
		System.out.println("\tAnd the answer is: "+ test+"\n"); 
		
		//Conclusion: (n+1) is not quite double on all systems, but it is definitely significantly more - 16.68957...seconds, wow!
		
		
		for (int x=0; x<11; x++)
		{
			int tester = vbrf(x);
			System.out.println("The answer to [vbrf(" + x +")] is: "+ tester);
		}
	}
	
	public static int vbrf(int x)
	{
		int answer = 0; //initialize local variable to zero
		
		//following if/else-if statements checks for the preconditions
		if (x == 0)
			answer = 0;
		else if (x == 1)
			answer = 1;
		else if (x == 2)
			answer = 4;
		else if (x > 2)
			//the recursive call within the problem - BAD USE to find the SQUARE
			answer = 3*vbrf(x-1)-3*vbrf(x-2) + vbrf(x-3);
	
		return answer; //end of method - return answer
	}

}
