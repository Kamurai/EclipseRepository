// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution 
{
    public int solution(String S) 
    {
        // write your code in Java SE 8
        
        //pull prefixes
            String prefix = "";
        //pull suffixes
            String suffix = "";
        //compare prefixes to suffixes
        //retain longest match length
            //lowest match length will always be 0
            
        int result = 0;
        
        for( int x = 0; x < S.length()/2+2; x++ )
        {
            prefix = S.substring(0,x);
            suffix = S.substring(S.length()-x,S.length());
            if( prefix.compareTo(suffix) == 0)
            {
                if( prefix.length() > result )
                {
                    result = prefix.length();   
                }
            }
        }
        
        
        return result;         
    }
}