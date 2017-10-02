package math3323_assignment3_kemerait;

import sequence.Fibonacci;
import sequence.Matrix;
import sequence.Sequence;




//Kemerait, Christopher
//MATH 3323 Spring 2010
//Assignment 3, Problem 1


public class Example1 
{
	/**
	* Discover possible relationships in the sequence of squares
	* of Fibonacci numbers.
	* 
	* After examining the output, a candidate relationship is
	*  q[i] - 2q[i-1] - 2q[i-2] + q[i-3] = 0
	* 
	*/
	public static void main(String[] args) {
	    // the squared fibonacci sequence is predefined 
	    // in the class Fibonacci
	    Sequence f2 = Fibonacci.FIBONACCI_SQUARED;
	    // fill a matrix, 12 rows 8 columns, with values from 
	    // the squared Fibonacci sequence
	    Matrix m = Matrix.sequenceFill(12, 8, f2);
	    // display
	    System.out.println("The initial matrix: ");
	    System.out.println(m);
	    // reduce
	    m.reduceMatrix();
	    // display
	    System.out.println("The matrix reduced: ");
	    System.out.println(m);
	}
}


