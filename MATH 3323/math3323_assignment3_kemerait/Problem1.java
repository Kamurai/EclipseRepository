package math3323_assignment3_kemerait;

import sequence.Fibonacci;
import sequence.Matrix;
import sequence.Sequence;




//Kemerait, Christopher
//MATH 3323 Spring 2010
//Assignment 3, Problem 1


public class Problem1 
{
	public static void main(String[] args) 
	{
	    // create a sequence of integers that are n * the nth fibonacci number
	    Sequence f2 = sequence.Product.product(Fibonacci.FIBONACCI_SEQUENCE, sequence.SequenceExamples.n());
	    
	    // fill a matrix, 12 rows 8 columns, with values from 
	    // the n * nth Fibonacci number
	    Matrix m = Matrix.sequenceFill(4, 8, f2);
	    
	    // display
	    System.out.println("The initial matrix: ");
	    System.out.println(m);
	    
	    // reduce
	    m.reduceMatrix();
	    
	    
	    
	    // display
	    System.out.println("The matrix reduced: ");
	    System.out.println(m);
	    
	    
	    //display "c"s
	    for(int x = 0; x < m.getNumRows(); x++)
	    {
	    	for(int y = 0; y < m.getNumCols(); y++)
	    	{
	    		//+ m.get(x, y) + " * c" + y
	    		
	    		
	    		//if matrix value is positive
	    		if( m.get(x,y) > 0 )
	    		{
	    			//display each column per row
	    			System.out.print( "  " );
	    		
	    		
	    			//if matrix value is less than ten
	    			if( m.get(x, y) < 10 )
	    			{
	    				//display each column per row
	    				System.out.print( " " );
	    			}
	    		
	    			//if matrix value is less than one hundred
	    			if( m.get(x, y) < 100 )
	    			{
	    				//display each column per row
	    				System.out.print( " " );
	    			}
	    		
	    			//if matrix value is less than one thousand
	    			if( m.get(x, y) < 1000 )
	    			{
	    				//display each column per row
	    				System.out.print( " " );
	    			}
	    		
	    			//if matrix value is less than ten thousand
	    			if( m.get(x, y) < 10000 )
	    			{
	    				//display each column per row
	    				System.out.print( " " );
	    			}
	    		
	    		}
	    		else if( m.get(x, y) < 0)
	    		{
	    			//display each column per row
    				System.out.print( " " );
    				
	    			//if matrix value is less than ten
	    			if( m.get(x, y) > -10 )
	    			{
	    				//display each column per row
	    				System.out.print( " " );
	    			}
	    		
	    			//if matrix value is less than one hundred
	    			if( m.get(x, y) > -100 )
	    			{
	    				//display each column per row
	    				System.out.print( " " );
	    			}
	    		
	    			//if matrix value is less than one thousand
	    			if( m.get(x, y) > -1000 )
	    			{
	    				//display each column per row
	    				System.out.print( " " );
	    			}
	    		
	    			//if matrix value is less than ten thousand
	    			if( m.get(x, y) > -10000 )
	    			{
	    				//display each column per row
	    				System.out.print( " " );
	    			}
	    		}
	    		
	    		//if value is 0, continue to ignore
	    		if( m.get(x, y) == 0)
	    		{
	    				
	    		}
	    		//else print matrix value
	    		else
	    		{
	    			//display each column per row
	    			System.out.print( " " + m.get(x, y) + " * c" + y );
	    		}
	    			
	    		
	    		//if it isn't the end of the row and the value wasn't ignored because it is equal to 0
		    	if( y+1 != m.getNumCols() && m.get(x, y) != 0 )
		    	{
		    		System.out.print( " + " );
	    		}
	    	}
	    	//go to next row
	    	System.out.println();
	    }
	    
	    //comment on apparent values derived from reduced matrix
	    System.out.println("\n\nIt is apparent from here that any value (1) may be chosen for c4 whilst c5 and higher are set to 0.");
	    System.out.println("This leads c0 being equal to 1.");
	    System.out.println("This leads c1 being equal to -2.");
	    System.out.println("This leads c2 being equal to -1.");
	    System.out.println("This leads c3 being equal to 2.");
	    System.out.println("This would lead to a candidate relationship like this:");
	    System.out.println("q[i] - 2q[i-1] - 1q[i-2] + 2q[i-3] + q[i-4] = 0");
	    
	    
	}
}


