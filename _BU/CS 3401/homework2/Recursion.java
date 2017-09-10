//Kemerait, Christopher
//CS 3401
//Homework 2

package homework2;

public class Recursion 
{
	
	
	
	public Recursion()
	{
	//Empty Constructor (Abstract Class)
	}
	
	
	public static double fractionalSeries(int n) throws IllegalArgumentException
	{
		double sum = 0;
		
		//if the largest denominator is less than 1
		 if(n < 1)
		 {
			 //throw Illegal Argument Exception
			 throw new IllegalArgumentException();
		 }
		 //base case
		 else if(n == 1)
		 {
			 sum += 1.00/n;
		 }
		 //recursion
		 else
		 {
			 sum += (1.00/n);
			 sum += fractionalSeries(n-1);			 
		 }
		 		 
		 return sum;
	}
	
	public static int gcd(int m, int n) throws ArithmeticException
	{
		int gcd = 0;
		
		//if the second integer is 0
		 if(n == 0)
		 {
			 //throw Arithmetic Exception
			 throw new ArithmeticException();
		 }
		 //base case
		 else if(m % n == 0)
		 {
			gcd = n; 
		 }
		 //recursion
		 else
		 {
			 gcd = gcd(n, m%n);
		 }

		 return gcd;
	}
	
	public static double largest(double[] numbers) throws IllegalArgumentException
	{
		double maximum = 0;
		
		//if the array exists and is empty
		 if( numbers.length == 0)
		 {
			 //throw Illegal Argument Exception
			 throw new IllegalArgumentException();
		 }
		 else 
		 {
			//use helper method
			 maximum = recursivelargest(numbers, numbers.length-1, 0.00);
		 }
		 
		 return maximum;
	}
	
	public static double recursivelargest(double[] numbers, int n, double maximum)
	{
		
		
		//base case
		//if n reaches the first 1st element
		 if(n == 0)
		 {
			//compare maximum to 1st element in array
		 	if( maximum < numbers[n])
		 	{
		 		maximum = numbers[n];
		 	}
		 }
		 //recursion
		 else
		 {
			 //compare maximum to nth element
			 if( maximum < numbers[n])
			 {
				 maximum = numbers[n];
			 }
			 //decrement n and use recursion
			 	 maximum = recursivelargest(numbers, (n-1), maximum);
			 
		 }
		 
		
		return maximum;
	}
	
	
}
