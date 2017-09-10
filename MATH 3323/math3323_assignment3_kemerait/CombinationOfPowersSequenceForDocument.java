package math3323_assignment3_kemerait;

//Kemerait, Christopher
//MATH 3323 Spring 2010
//Assignment 3, Problem 1


import sequence.Matrix;
import sequence.Sequence;



/**
 * 
 * A linear combination of exponentials and polynomials will give 
 * a sequence with linear relationships.
 * 
 * This example has a candidate relationship:
 * 
 * -q[i] + 12*q[i-1] - 57*q[i-2] + 134*q[i-3] - 156*q[i-4] + 72*q[i-5] = 0
 * 
 * 
 * @author Ben Setzer
 *
 */
public class CombinationOfPowersSequenceForDocument 
{

	public static void main(String[] args) 
	{
		test1B();
		test2B();
		test3B();
	}
	
		
	/**
	 * This prints out a few valuees of the sequence B just
	 * to see what it looks like.
	 */
	private static void test1B() {
		for(int i = 0; i < 10; i++ ) 
			System.out.println(seqB.get(i));
		
	}

	/**
	 * This is the main worker: create the matrix and reduce it.
	 */
	private static void test2B() {
		Matrix m = Matrix.sequenceFill(7,6, seqB);
		System.out.println(m);
		// The simpler reduceMatrix is not sufficient for this example
		m.reduceMatrixViaRational();
		System.out.println();
		System.out.println(m);
	}
	
	/**
	 * Test the candidate relationship directly.
	 */
	private static void test3B() {
		for(int n = 5; n <= 20; n++ ) {
			long x = 
				-1*seqB.get(n)
				+12*seqB.get(n-1)
				-57*seqB.get(n-2)
				+134*seqB.get(n-3)
				-156*seqB.get(n-4)
				+72*seqB.get(n-5);
			System.out.println("Relation result is: " + x);
		}
	}
	
	
	/**
	 * This is the sequence.
	 */
	private static Sequence seqB = new Sequence() {
		public long get(long n) {
			return n*n*pow(2,n) + n*pow(3,n);
		}
	};
	
	
	private static long pow(long base, long exp) {
		long prod = 1;
		for(int i = 0; i < exp; i++) 
			prod *= base;
		return prod;
	}
	
	
	
}

