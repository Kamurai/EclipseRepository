/**
 * 
 */
package bitgraphcreation.copy;

/**
 * @author SGR
 *
 */
public class Combinatorics {
	
	public static long choose (int n, int k)
	{
		/*
		 * Formula:
		 * n choose k = n!/(k!*(n-k)!);
		 */
		
		long numerator = factorial(n);
		long denominator = (factorial(k) * factorial(n-k));
		
		return (numerator / denominator);
	}
	
	private static long factorial (long number)
	{
		if (number == 0)
			return 1;
		else	
			for (long x = (number-1); x > 1; x--)
				number *= x;
		
		return number;
	}

}
