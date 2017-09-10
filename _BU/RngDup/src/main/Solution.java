package main;
import java.io.*;
import java.util.*;
import java.util.Random;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


class Solution 
{
	public static void main(String[] args) 
	{
	    ArrayList<String> strings = new ArrayList<String>();
	    
	    int[] numGenArray;
	    int[] numDupArray;
	    int[] duplicates = {3,3,2,1,1,3};
	    
	    /*
	    strings.add("Hello, World!");
	    strings.add("Welcome to CoderPad.");
	    strings.add("This pad is running Java 8.");
	
	    for (String string : strings) {
	      System.out.println(string);
	    }
	    */
	    numGenArray = generateArray(5,3);
	    
	    numDupArray = getDuplicates(duplicates);
	    
	    //System.out.println("break");
	    for(int x = 0; x < numGenArray.length; x++)
	    {
	      //System.out.println(numGenArray[x]);
	    }
	    
	    for(int x = 0; x < numDupArray.length; x++)
	    {
	      System.out.println(numDupArray[x]);
	    }
    
	}


/*1. Create a function that generates an array of random integers, where the length of the array and the maximum random value are defined as parameters.  e.g., generateArray(5, 3) may generate [3, 2, 0, 1, 1].*/

	public static int[] generateArray(int numbers, int maxValue)
	{
		int[] numArray = new int[numbers];
		Random rdm = new Random();

	    for(int x = 0; x < numbers; x++)
	    {
	      numArray[x] = rdm.nextInt(maxValue+1);
	    }

	    return numArray;
	}
 
/*2. Create a function that takes an array of integers and returns an array of the duplicates.  e.g., findDuplicates([3,3,2,1,1,3]) would return [1, 3] (order doesn't matter).*/
  
	  public static int[] getDuplicates(int[] input)
	  {
		  int[] numArray;// = new int[5];
		  int z = 0;
		  int w = 0;
		  boolean trip = false;
	
	
	
		  for(int x = 0; x < input.length; x++)
		  {
		      for(int y = x+1; y < input.length; y++)
		      {
		
		        if(input[x] == input[y])
		        {
		          z++;
		          x = y;
		          break;
		        }
		      }
		  }
		  numArray = new int[z];
		  for(int x = 0; x < input.length; x++)
		  {
		      for(int y = x+1; y < input.length; y++)
		      {
				if(input[x] == input[y])
		        {
					trip = true;
	            	break;
		        }
		      }
		      if(trip)
		      {
		    	  trip = false;
		    	  for(int y = 0; y < numArray.length; y++)
		    	  {
		    		  if(input[x] == numArray[y])
		    		  {
			    		  trip = true;
			    		  break;
		    		  }
		    	  }
		    	  if(!trip)
		    	  {
		    		  numArray[w] = input[x];
		    		  w++;
	    		  }
		    	  else
		    	  {
		    		  trip =false;
		    	  }  
		      }
		      
		  }
		  
	/*
		  for(int x = 0; x < input.length; x++)
		  {
			  	for(int y = 0; y < numArray.length; y++)
	    		{
	    			if(input[x] == numArray[y])
	    			{
		            	trip = true;
		            	break;
	    			}
	        	}
	        	if(!trip)
	        	{
	        		if()
	        		{
	        			numArray[w] = input[x];
	        			w++;
	        		}
	        	}
	        	else
	        	{
	        		trip =false;
	        	}
		  }
	*/
		  //System.out.println("Z");
		  //System.out.println(z);
	
	
	    return numArray;
	  }
}


