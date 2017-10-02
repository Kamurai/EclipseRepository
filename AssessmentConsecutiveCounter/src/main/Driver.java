package main;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int emptyArray[] = new int[] {
				
		};
		int shortArray[] = new int[] {
				2,3
		};
		int minArray[] = new int[] {
				1,2,3
		};
		int normArray[] = new int[] {
				1,2,3,4
		};
		int negArray[] = new int[] {
				-1,-2,-3,-4,-5
		};
		int firstNegArray[] = new int[] {
				-1,-2,-3,1,2,3,4,5
		};
		int lastNegArray[] = new int[] {
				1,2,3,4,5,-1,-2,-3
		};
		int testNegArray[] = new int[] {
				-2,-4,-8,-1,-7,-9,-3,-5,-6
		};
		int testArray[] = new int[] {
				2,4,8,1,7,9,3,5,6
		};
		
		
		
		String resultString = "";
		
		
		resultString = Integer.toString(ConsecutiveCounter.ConsecutiveCount( emptyArray, 3 ));
		System.out.println(	resultString );
		
		resultString = Integer.toString(ConsecutiveCounter.ConsecutiveCount( emptyArray, 0 ));
		System.out.println(	resultString );
		
		resultString = Integer.toString(ConsecutiveCounter.ConsecutiveCount( shortArray, 3 ));
		System.out.println(	resultString );
		
		resultString = Integer.toString(ConsecutiveCounter.ConsecutiveCount( minArray, 3 ));
		System.out.println(	resultString );
		
		resultString = Integer.toString(ConsecutiveCounter.ConsecutiveCount( normArray, 3 ));
		System.out.println(	resultString );
		
		resultString = Integer.toString(ConsecutiveCounter.ConsecutiveCount( negArray, 3 ));
		System.out.println(	resultString );
		
		resultString = Integer.toString(ConsecutiveCounter.ConsecutiveCount( firstNegArray, 3 ));
		System.out.println(	resultString );
		
		resultString = Integer.toString(ConsecutiveCounter.ConsecutiveCount( lastNegArray, 3 ));
		System.out.println(	resultString );
		
		resultString = Integer.toString(ConsecutiveCounter.ConsecutiveCount( testNegArray, 3 ));
		System.out.println(	resultString );
		
		resultString = Integer.toString(ConsecutiveCounter.ConsecutiveCount( testArray, 3 ));
		System.out.println(	resultString );
		
		
		
		
		
		
	}

}