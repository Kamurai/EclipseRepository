// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution 
{
    public int solution(int[] A, int X, int D) 
    {
        // write your code in Java SE 8
        //a "frog" must travel from 0 to X
        //frog can "jump" 1 to D "spaces"
        //"leaves" fall into spaces in an array of seconds (0-N)
        
        //return the time it takes the frog to cross
            //exception: if it only requires the leaf in second[0] then return 0;
        
        int result = -1;
        int position = 0;
        
        
        if( D >= X )
        {
            result = 0;   
        }
        //frog can reach leaf and then jump from leaf to bank
        	//and if frog is able to jump from position to leaf
        else if( A[0] <= D && A[0] + D >= X)
        {
        	result = 0;    
        }
        else
        {
            for(int x = 0; x < A.length; x++)
            {
                //if frog is able to jump from position to leaf
            		//and leaf is forward
                if(position+D >= A[x] && A[x] > position)
                {
                    //move frog to leaf
                    position = A[x];
                }
                
                if(position >= X || position + D >= X)
                {
                    result = x;
                    break;   
                }
            }
        }
        return result;
    }
}