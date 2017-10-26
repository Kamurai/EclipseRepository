package main;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) 
	{
		//Scanner in = new Scanner(System.in);
        //int r1 = in.nextInt();
        String vResult = "";
        
        vResult = mDetermineForkInRiver(20);
        System.out.print("20 NO: ");
        System.out.println(vResult);
        
        vResult = mDetermineForkInRiver(13);
        System.out.print("13 YES: ");
        System.out.println(vResult);
        
        vResult = mDetermineForkInRiver(984);
        System.out.print("984 NO: ");
        System.out.println(vResult);
        
        vResult = mDetermineForkInRiver(1006);
        System.out.print("1006 NO: ");
        System.out.println(vResult);
        
        vResult = mDetermineForkInRiver(9915);
        System.out.print("9915 YES: ");
        System.out.println(vResult);
        
        vResult = mDetermineForkInRiver(42406);
        System.out.print("42406 NO: ");
        System.out.println(vResult);
        
        vResult = mDetermineForkInRiver(91004);
        System.out.print("91004 NO: ");
        System.out.println(vResult);
        
        vResult = mDetermineForkInRiver(90000);
        System.out.print("90000 YES: ");
        System.out.println(vResult);
        
        vResult = mDetermineForkInRiver(15623);
        System.out.print("15623 YES: ");
        System.out.println(vResult);
        
        vResult = mDetermineForkInRiver(11145);
        System.out.print("11145 NO: ");
        System.out.println(vResult);
        
	}
	
	private static String mDetermineForkInRiver(int vTarget)
	{
		String vResult = "NO";
        int vLowerLimit = 1;
        int vHigherLimit = 100000;
        int vMaxJump = 0;
        
        if(vTarget < vLowerLimit)
            vTarget = vLowerLimit;
            
        if(vTarget > vHigherLimit )
            vTarget = vHigherLimit;

        //This code assumes that a given number exists in a river it starts
       	//Based on this we just have to find a previous river in which the given number also exists
        
        //get Max Jump
        vMaxJump = mDetermineMaxJump(vTarget);
        
        for(int x = vTarget-1; x >= vTarget-vMaxJump; x--)
        {
        	if( x + mSumDigits(x) == vTarget )
        	{
        		vResult = "YES";
        		break;
        	}
        }
        
        return vResult;
	}
	
	private static int mDetermineMaxJump(int vTarget)
	{
		int vResult = 45; //arbitrated for 100,000
		int vLength = 0;
		int vMaxValue = 0;
		String vTempString;
		
		
		//count digits of target
		vLength = Integer.toString(vTarget).length();
		
		//get the first digit of the target number
		vTempString = Integer.toString(vTarget).substring(0, 1);
		
		//add Length-1 0s
		for(int x = 0; x < vLength-1; x++)
		{
			vTempString += "0";
		}
		
		//subtract 1
		vMaxValue = Integer.parseInt(vTempString) - 1;
		
		//sum digits
		vResult = mSumDigits(vMaxValue);
		
		if(vResult > vTarget)
        {
			vResult = vTarget-1;
        }
        
		return vResult;
	}
	
	private static int mSumDigits(int vTarget)
	{
		int vResult = 0;
		String vTargetString;
		
		vTargetString = Integer.toString(vTarget);
		
		//sum digits
		for(int y = 0; y < vTargetString.length(); y++)
        {
			vResult += Integer.parseInt(vTargetString.substring(y,y+1));
        }
		
		return vResult;
	}
	

}
