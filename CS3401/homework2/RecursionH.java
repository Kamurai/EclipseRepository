//Masom Hamadeh
//CS3401 HW#2

package homework2;

public class RecursionH extends Object {

	public RecursionH(){
//why does construtctor throw this exception automatically?		
		throw new IllegalArgumentException();
	}
	
	public static double fractionalSeries (int n){
		double sum;
		if (n<1){
			throw new IllegalArgumentException();
		}
		else if(n==1){
			return sum=1;
		}
		else{ 
			sum= (1.00/n) + fractionalSeries(n-1); //recursive call - just realized how great eclipse is it makes the recursive method in italics
			return sum; //we make sure that we return a double here where the sum=(1.00/n) instead of 1/n
		}
	}
	
	public static int gcd (int m, int n){
		int d=0; //create a local variable to use within this method
		if (n==0){
			throw new ArithmeticException();
		}
		else if (m%n==0){
			d=n;
		}
		else{
			d=gcd(n,m%n); //recursive call
		}
			return d;
	}

	public static double largest(double[] numbers) throws IllegalArgumentException{
		double largestSize=0;
		if(numbers.length==0){ //this states if we have an array but it's empty
			throw new IllegalArgumentException();
		}
		else{ 
			//we need to use the helper method we create to make this work a bit more efficiently
			largestSize= helperLargest(numbers, numbers.length-1, 0.00);
		}
			return largestSize;
		}
	
	public static double helperLargest(double[] numbers, int n, double max){
//it may have been because your code was a little muddled,
	//but this says that if n is 0, then if max is less than numbers[n]
	//is should be else if instead of then if
		if (n==0)
		{ //this is the base case
//this method does not compare the first element of the array
			if( max<numbers[n])
			{
				max=numbers[n];
			}
			
//add } else
		}else
		{
		 	if(max<numbers[n])
		 	{
//technically its the current element in the array.
			//we will compare the max value to the first element in the array set
				max=numbers[n];
//there is an misplaced end brace here }
		 	}	
			max=helperLargest(numbers, (n-1), max); //recursive method where we will incremently reduce n by 1

		}
		return max;
	}
}
