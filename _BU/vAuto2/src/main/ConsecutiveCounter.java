package main;

public class ConsecutiveCounter 
{
	public ConsecutiveCounter()
	{
		
	}
	
	
	public static int ConsecutiveCount(int[] array, int windowSize)
	{
		int result = Integer.MIN_VALUE; //0
		int currentResult = 0;
		
		if(windowSize <= 0)
		{
			return result;
		}
		
		if(windowSize <= array.length)
		{
			for(int x = 0; x < windowSize; x++)
			{
				currentResult += array[x];
				
			}
			result = currentResult;
			
			for(int x = windowSize; x < array.length; x++)
			{
				currentResult -= array[x-windowSize];
				currentResult += array[x];
				if(currentResult > result)
				{
					result = currentResult;
				}
			}
		}		
		
		return result;
	}
}
