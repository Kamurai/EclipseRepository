//Masom Hamadeh
//MATH 3323 
//Assignment #1: Recursive Functions

package a1_RecursiveFunctions;

public class RecursiveMethods
{
	
	public static void main (String[] args)
	{
		RecursiveMethods test = new RecursiveMethods();
		
		System.out.println("The following displays the answers for the first 10 values!");
		for (int x = 0; x < 10; x++)
		{
			int printOut2 = test.problem1(x);
			System.out.println("The answer to this logic (for #" + x + ") is: " + printOut2);
		}
		
		RecursiveMethods myth = new RecursiveMethods();
		System.out.println("\nThe following displays the answers for the first 11 values!");
		for (int x = 0; x < 11; x++)
		{
			int printOut2 = myth.problem2(x);
			System.out.println("The answer to this complex logic (for #" + x + ") is: " + printOut2);
		}
		
		
		
	}
		/***************************************************************
		 * Problem #1:
		 * We will be studying one aspect of permutations in Assignment #5. 
		 * We will make use of a function that is defined recursively. Your 
		 * job for this part of the assignment is to implement this function 
		 * and print the first few values.

		 This is the logic/pseudocode behind this function:
		 We'll call the function h. It is defined by these conditions:
		 if - 
		 h(0) = 1
		 h(1) = 0
		 h(n) = (n-1)*(h(n-1) + h(n-2)) for n > 1
		 ***************************************************************/
		public int problem1(int n)
		{
			int answer = 0;
			
			//check the preconditions
			if (n == 0)
				answer = 1;
			else if (n == 1)
				answer = 0;
			else if (n > 1)
			{
				//the recursive call within the problem
				answer = (n-1)*(problem1(n-1) + problem1(n-2));
			}
			return answer;
		}
		
		/***************************************************************
		 * ANSWER: this sequence seems to be the easiest sequence to compute - you just add one to the previous
		 * number.  However, the complexity of doing this in this way is way too difficult!
		 
		Here is a function named 'myst' (for mystery):
			myst(0) = 0
			myst(1) = 1
			myst(n) = 2*myst(n-1) - myst(n-2)  if n > 1
			
			Again, implement the function as a Java method and print a table of values. 
			If your work is correct you will easily recognize the function.
			Once you have figured out what the function is, add a comment to your source file that states what you have discovered.
			We should, of course prove the conjecture, but that is beyond the scope of this course.
		*********************************************************/
		public int problem2(int n)
		{
			int answer = 0;
			
			//check the preconditions
			if (n == 0)
				answer = 0;
			else if (n == 1)
				answer = 1;
			else if (n > 1)
			{
				answer = (2*problem2(n-1) - problem2(n-2));
			}
			return answer;
		}
	}
	
	

