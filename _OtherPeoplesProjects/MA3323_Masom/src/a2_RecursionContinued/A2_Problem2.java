package a2_RecursionContinued;

public class A2_Problem2
{
	/***PSEUDOCODE: Logic from assignment
	 h(0) = 1

	h(n) = n*h(n-1) + (-1)n  if n > 0
	x = 1    // holds the final value of h
    e = -1  // used for the (-1)^n
    	for i from 1 to n
       		x = i*x + e
       		e = -e
     ******************************/

	public static void main(String[] args) 
	{
		//here we are going to test out 
		for (int i=0; i < 11; i++)
		{
			int test = functionH(i);
			System.out.println("The answer to functionH(" + i + ") is: " + test);
			//NOW the answers DO match the sequence on the web as well as last week's problem #2 answers
				//HOWEVER, it seems that this is a more efficient way?			
		}
	}
	
	//create the h function method using the online encyclopedia
	public static int functionH (int x)
	{
		int answer = 0;
		//precondition tests
		if (x == 1)
			answer = 1;
		else
		{
			int hold = 1;
			int e = -1;
			
			for(int i = 1; i < x; i++)
			{
				//method logic based on an iterative method
				hold = i*hold + e;
				e = -e;
				answer = hold;
			}
		}
		
		return answer;
			
	}

}
