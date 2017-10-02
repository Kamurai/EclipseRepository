package a3_RelationshipsSequences;

import sequence.Matrix;
import sequence.Sequence;


public class A3_ClassExample
{
	 
	public static void main(String[] args) 
	{
		Matrix m = Matrix.sequenceFill(2, 3, example);
		System.out.println(m);
		m.reduceMatrixViaRational();
		System.out.println(m);
		
		/*after printing out the reduced sequence:
		 * 
		------------------
        15          0         -1 
         0         15          8 
    	------------------
		 * each row is equal to zero starting from left to right (co, c1, c2...etc)
    	 * 15*c0 - c2 = 0
    	 * 15*c1 + 8*c2 = 0;
    	 * 
    	 * 15*c0 = c2
    	 * 15*c1 = -8*c2
    	 * 
    	 * c2 = 15 then
    	 * 	c0 = 1
    	 * c1 = -8
    	 * 
    	 * our candidate relationship is (answer)
    	 * 
    	 * 1 * s[i] - 8 * s[i-1] + 15 * s[1-2] = 0
    	 */
	}  

	private static Sequence example = new Sequence() 
	{
		public long get(long n) 
		{
			return pow(5,n) - 8 * pow(3,n);
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
