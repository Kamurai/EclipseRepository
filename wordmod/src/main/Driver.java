package main;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String emptyString = "";
		String numberString = "123456789";
		String alphaDistinctString = "abcdedfghijklmnopqrstuvwxyz";
		String alphaNonDistinctString = "aaaaaaaaaaaa";
		String testString = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
		String resultString = "";
		
		
		resultString = DistinctLetterCounter.DistinctInnerCount(emptyString);
		System.out.println(	resultString );
		
		resultString = DistinctLetterCounter.DistinctInnerCount(numberString);
		System.out.println(	resultString );
		
		resultString = DistinctLetterCounter.DistinctInnerCount(alphaDistinctString);
		System.out.println(	resultString );
		
		resultString = DistinctLetterCounter.DistinctInnerCount(alphaNonDistinctString);
		System.out.println(	resultString );
		
		resultString = DistinctLetterCounter.DistinctInnerCount(testString);
		System.out.println(	resultString );
		
		
		
		
		
		
	}

}
