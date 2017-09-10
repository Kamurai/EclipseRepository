package math3323_assignment10_kemerait;


import java.util.List;

import degreeSequences.ReduceDegreeSequences;
import degreeSequences.SomeDegreeSequences;
import sequence.Fibonacci;
import sequence.Matrix;
import sequence.Sequence;




//Kemerait, Christopher
//MATH 3323 Spring 2010
//Assignment 3, Problem 1


public class TestDegreeSequences 
{
	
	public static void main(String[] args) 
	{
		//get sequences from SomeDegreeSequences
		List<Integer> f1 = SomeDegreeSequences.ds1;
		List<Integer> f2 = SomeDegreeSequences.ds2;
		List<Integer> f3 = SomeDegreeSequences.ds3;
		List<Integer> f4 = SomeDegreeSequences.ds4;
		List<Integer> f5 = SomeDegreeSequences.ds5;
	    
		//show sequences
			//print header for sequence 1
		System.out.println("Sequence 1");
		//print sequence
		slideshow(f1);
		//reduce sequence
		ReduceDegreeSequences.fullReduce(f1, false);
		//print sequence
		slideshow(f1);
		
		
		//print header for sequence 2
		System.out.println("Sequence 2");
		//print sequence
		slideshow(f2);
		//reduce sequence
		ReduceDegreeSequences.fullReduce(f2, false);
		//print sequence
		slideshow(f2);
		
		
		//print header for sequence 3
		System.out.println("Sequence 3");
		//print sequence
		slideshow(f3);
		//reduce sequence
		ReduceDegreeSequences.fullReduce(f3, false);
		//print sequence
		slideshow(f3);
		
		
		//print header for sequence 4
		System.out.println("Sequence 4");
		//print sequence
		slideshow(f4);
		//reduce sequence
		ReduceDegreeSequences.fullReduce(f4, false);
		//print sequence
		slideshow(f4);
		
		
		//print header for sequence 5
		System.out.println("Sequence 5");
		//print sequence
		slideshow(f5);
		//reduce sequence
		ReduceDegreeSequences.fullReduce(f5, false);
		//print sequence
		slideshow(f5);
		
		
		//display output results
		System.out.println("The given information is as follows");
		System.out.println("Sequence 1 is not valid.");
		System.out.println("Sequence 2 is valid.");
		System.out.println();
		System.out.println("After reducing the sequences and examining the results:\n");
		System.out.println("Sequence 3 shares the same reduced sequence as Sequence 2.");
		System.out.println("This indicates that they have the same validity, VALID.\n");
		System.out.println("As Sequences 4 and 5 do not share the same reduced sequence as Sequence 2.");
		System.out.println("This indicats that they have the same validity as Sequence 1, INVALID.");
	}
	
	public static void slideshow(List<Integer> input)
	{
		//tool variables
		int tool = 0;
		int limit = 0;
		
		/*
		//test sequence
		input.clear();
		for(int x = 0; x < 144; x++)
		{
			input.add(x);
		}
		*/
		
		//output sequence size
	    System.out.println( "Sequence size is:  " + input.size() );
	    
	    //declare limit
	    limit = (int) Math.floor( Math.sqrt(input.size()) );
	    
	    //output sequence into table
	    System.out.println( "The sqrt of the sequence size is:  " +  limit );
	    
	    //output sequence
	    for(int x = 0; x < limit; x++)
	    {
	    	for(int y = 0; y < limit; y++)
		    {
	    		//print the appropriate item of the sequence
	    		System.out.print( input.get((x*limit) + y) + " ");
		    }
	    	//go to the next line
	    	System.out.println();
	    }
	    //save square of sqrts
	    tool = limit*limit;
	    
	    //pick up where the square leaves off
	    for(int x = tool; x <  input.size();)
	    {
	    	for(int y = 0; y <  limit; y++)
		    {
	    		//ensure item is in bounds
	    		if( x < input.size() )
	    		{
	    			//print the appropriate item of the sequence
	    			System.out.print( input.get( x ) + " ");
	    		}
	    		
	    		//increment x
	    		x++;	
		    }
	    	
	    	
	    	//go to the next line
	    	System.out.println();
	    }
	    
	    //spacing
	    System.out.println("\n");
	}
	
}


