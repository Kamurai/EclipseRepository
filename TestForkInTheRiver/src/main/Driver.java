package main;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) 
	{
		//Scanner in = new Scanner(System.in);
        //int r1 = in.nextInt();
        String vResult = "";
        
        vResult = determineForkInRiver(42406);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(vResult);
	}
	
	private static String determineForkInRiver(int r1)
	{
		String vResult = "NO";
        int vCount = 0;
        int vLowerLimit = 1;
        int vHigherLimit = 100000;
        int vRiver = 0;
        String vRiverString = "";
        int vSum = 0;
        String vTestString = "";
        
        int vForCount = 0;
        int vWhileCount = 0;
        
        if(r1 < vLowerLimit)
            r1 = vLowerLimit;
            
        if(r1 > vHigherLimit )
            r1 = vHigherLimit;

        //go through available numbers
        for(int x = vLowerLimit; x < r1; x++)
        {
        	vForCount++;
        	
            vRiver = x;
            
            //for each available number, find the next river value
            while(vRiver <= r1)
            {
            	vWhileCount++;
            	
                vSum = 0;
                
                vRiverString = Integer.toString(vRiver);
                
                //get sum of digits in current river value
                for(int y = 0; y < vRiverString.length(); y++)
                {
                	vTestString = vRiverString.substring(y,y+1);
                	
                    vSum += Integer.parseInt(vTestString);
                }
                
                vRiver += vSum;
                
                //if new river value is givenNumber
                if( vRiver == r1 )
                {
                    //increase count
                    vCount++;
                    break;
                    //vRiver = givenNumber + 1;
                }
            }
            
            //if count > 1
            if(vCount > 0)
            {
                vResult = "YES";
                break;
                
                //x = vHigherLimit + 1;
            }
        }
        
        System.out.println("For Count: " + vForCount);
        System.out.println("While Count: " + vWhileCount);

		return vResult;
	}

}
