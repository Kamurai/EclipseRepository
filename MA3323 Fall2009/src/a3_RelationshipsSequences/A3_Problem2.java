package a3_RelationshipsSequences;

import sequence.Matrix;
import sequence.Sequence;


public class A3_Problem2 
{
	public static void main(String[] args) 
	{
		Matrix m = Matrix.sequenceFill(3, 4, sequenceTwo); //got the row vs column numbers from the original matrix
		System.out.println(m);
		m.reduceMatrixViaRational();
		System.out.println(m);
		
		/*after printing out the reduced sequence:
		 * 
		 *************************************
		   c0        c1         c2         c3
		   --        --         --         --
           12         0          0          1 
           0         12          0         -7 
           0          0          3          4 
		 *************************************
		 * each row is equal to zero starting from left to right (co, c1, c2...etc)
    	 * 12*c0 + 1*c3 = 0 ----->row1
    	 * 12*c1 - 7*c3 = 0 ----->row2
    	 *  3*c2 + 4*c3 = 0 ----->row3
    	 * 
    	 * Now we are going to solve for the unknown variables:
    	 * c3 = -12 then
    	 * c0 = 1
    	 * c1 = -7
    	 * c2 = 16
    	 * our candidate relationship is (answer):
    	 * 
    	 * 1 * s[i] - 7 * s[i-1] + 16 * s[i-2] - 12 * s[i-3] = 0
    	 * 
    	 */
	}  

	public static Sequence sequenceTwo = new Sequence() 
	 //Determine a candidate relationship for the sequence "n * 2^n + 3^n". Here are the first few terms:
		// 1   5   17    51    145    403   1113   3083   8609   24291
     
	{
		public long get(long n) 
		{
			//fill in the logic here using the pow method below
			return n * pow(2,n) + pow(3,n); 
		}
	};
	
	private static long pow(long base, long exp) 
	{
		long prod = 1;
		for(int i = 0; i < exp; i++) 
			prod *= base;
		return prod;
	}
}


