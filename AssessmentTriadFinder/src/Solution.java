// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution 
{
    public int solution(int[] A) 
    {
        // write your code in Java SE 8
        
        //find P,Q,R: 0 <= P < Q < R < N
        //each pair must be larger than the third
        
        //return the smallest possible perimeter
        
        int result = -1;
        boolean valid = false;
        
        int perimeter = 0;
        
        for(int x = 0; x < A.length; x++)
        {
            for(int y = x+1; y < A.length; y++)
            {
                for(int z = y+1; z < A.length; z++)
                {
                    if( isTriangle(x,y,z,A) )
                    {
                        if( perimeter == 0 || perimeter > (A[x]+A[y]+A[z]) )
                        {
                            perimeter = A[x]+A[y]+A[z];
                        }
                    }
                }
            }
        }
        
        //failure condition: no "triangle" is found
        if(perimeter == 0)
            valid = false;
        else
        	valid = true;
        
        if(valid)
            result = perimeter;
        else
            result = -1;
            
        return result;
    }
    
    boolean isTriangle(int a, int b, int c, int[] array)
    {
        //order specific
        if( 0 <= a && a < b && b < c && c < array.length)
        {
            //side specifications
            if( array[a] + array[b] > array[c] )
            {
                if( array[b] + array[c] > array[a] )
                {
                    if( array[c] + array[a] > array[b] )
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}