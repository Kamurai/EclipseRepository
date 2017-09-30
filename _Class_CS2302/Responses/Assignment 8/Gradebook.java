//Kemerait, Christopher
//CSIS 2302
//Gradebook Assignment



public class Gradebook extends java.lang.Object
{
   private int[] assignments, tests;
	private java.lang.String id, name;
	private int numAssignments, numTests;

   public Gradebook (java.lang.String name, java.lang.String id)
   {
 		assignments = new int[5];
		tests = new int[5];
      this.name = name;
      this.id = id;
   
	}

	public void addAssignmentScore(int score)
	{
		numAssignments++;
		
		//add an assignment score, and make room in array if neccessary
		if (numAssignments >= assignments.length)
			increaseSizeAssignments();
			
		assignments[numAssignments] = score;
		
		
	}
	
	public void addTestScore(int score)
	{
		numTests++;
		
		/***********************************************
		You are not using the index 0 position in the array.
		There is nothing logical wrong with this since your
		code takes this into account.
		*************************************************/

		//add an test score, and make room in array if neccessary
		if (numTests >= tests.length)
			increaseSizeTests();
			
		tests[numTests] = score;
		
	}
	
	public double getAssignmentAverage()
	{
		int average = 0;
		//return average of assignment scores, or if no scores are recorded
		
		//average array
		for(int x = 1; x < assignments.length; x++)
		
		/********************************************************
		You are assuming that the array is full.  You should use
		numAssignments instead of length.  
		********************************************************/
		
			average += assignments[x];
			
		average = ( average / numAssignments );		
		
		return average;
		
	}
	
	public java.lang.String getId()
	{
		return id;
	}
	
	public java.lang.String getName()
	{
	
		return name;
	
	}
	
	public int getNumAssignments()
	{
	
		return numAssignments;
	
	}
	
	public int getNumTests()
	{
	
		return numTests;
	
	}
	
	public double getTestAverage()
	{
		int average = 0;
		// return average of test scores, or 0 if no tests are recorded
		
		//average array
		for(int x = 1; x < tests.length; x++)
		
		/***************************************
		same comments
		*************************************/
		
			average += tests[x];
			
		average = ( average / numTests );		
		
		return average;
	}
	
	private void increaseSizeAssignments()
	{
	
		//increase size of Assignment array
		int[] temp = new int[assignments.length * 2];

      for (int x = 0; x < assignments.length; x++)
         temp[x] = assignments[x];

      assignments = temp;
	}
	
	private void increaseSizeTests()
	{
	
		//increase size of Test array
		int[] temp = new int[tests.length * 2];

      for (int x = 0; x < tests.length; x++)
         temp[x] = tests[x];

      tests = temp;


	}
	
	
}

/*****************************************************
47/50 Please see my comments in your code.
******************************************************/