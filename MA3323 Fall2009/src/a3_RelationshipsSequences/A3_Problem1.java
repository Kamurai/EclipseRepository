package a3_RelationshipsSequences;

import sequence.Fibonacci;
import sequence.Matrix;
import sequence.Sequence;

public class A3_Problem1
{
	public static void main(String[] args)
	{
		Matrix m = Matrix.sequenceFill(4, 5, fibSeq);
		System.out.println(m);
		m.reduceMatrixViaRational();
		System.out.println(m);
	
}  

	public static Sequence fibSeq = new Sequence() 
//Determine a candidate relationship for the sequence "n times the n'th Fibonacci number. Here are the first few terms:
//    0   1   2   6   12   25   48   91   168   306
	
	/**********************************************
	 *  c0         c1         c2         c3         c4
	 * ------------------
         1          0          0          0         -1 
         0          1          0          0          2 
         0          0          1          0          1 
         0          0          0          1         -2 
      ------------------
	 * 1*c0 - 1*c4 = 0 ---> row1
	 * 1*c1 + 2*c4 = 0 ---> row2
	 * 1*c2 + 1*c4 = 0 ---> row3
	 * 1*c3 - 2*c4 = 0 ---> row4
	 * ----------------
	 * c4 = 1 then
	 * c0 = 1
	 * c1 = -2
	 * c2 = -1
	 * c3 = 2
	 * ----------------
	 * our candidate relationship is (answer):
	 * 
	 * 1 * s[i] - 2 * s[i-1] - 1 * s[i-2] + 2 * s[i-3] + 1 * s[i-4] = 0
	 * 
	 */
	
	
	{
	
	public long get(long n) 
	{
		return n*Fibonacci.fibonacci(n); //need to fill in code here!
	}
};
}
