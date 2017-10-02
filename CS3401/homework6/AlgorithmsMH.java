//Masom Hamadeh
//CS 3401 - HW#6

package homework6;

public class AlgorithmsMH extends Object{
	
	public AlgorithmsMH(){
		//empty contructor
	}
	
	/*********************************************************************************************************************************************/
	//maxSortedSubString method: finds the longest sorted substring of a given string
	//Returns: the sorted substring
	public static String maxSortedSubString (String arg){
		
		//declaration of local variables that will be used to handle method logic
		String checkerString;
		int positionIndex = 0;
		int stringLength = 0;
		
		//we first should check if string is empty
		if (arg.length() == 0){
			return ""; //just an empty String - in design contract no need to throw any exception
		}
		else{ //check to see if there is anything larger than one character - if so, return that character
			checkerString = arg.substring(0,1);
		}
		
		//loop to find the the longest sorted substring of a given string
		for (int x=0; x < arg.length(); x++){
			
			//we need to now check current character against the next and see if the characters are ordered
			//also to check if current character is not the last character
			if (x != arg.length()-1 && arg.substring(x, x+1).compareTo(arg.substring(x+1, x+2)) <= 0){
				
				if (stringLength == 0){
					positionIndex = x; //if stringLength = 0 then just record the current index as the positionIndex
				}
				stringLength++; //just increment by one if not
			}
			
			//now, if the stringLength is NOT 0 or if the current character is the last one
			else if (stringLength != 0){
				
				stringLength++; //include the current character
				
				if (stringLength > checkerString.length()){
					checkerString = arg.substring (positionIndex, positionIndex + stringLength); //records the new substring
				}
				stringLength = 0; //or just reset the length to zero
			}
		}
			//keep looping to next and repeat
			return checkerString;
		}
	
		
		/******************************************************************************************************************************************/
		//indexOf method: find the position of one string in another
		//Returns: index of str2 in str1. If str2 does not exist in str1, returns -1
		//Throws: IllegalArgumentException if str2 is an empty string
		public static int indexOf (String str1, String str2) throws IllegalArgumentException{
			int positionIndex = -1;
			int stringLength = 0;
			
			//now based on the design contract, we need to throw an exception if str2 is empty
			if (str2.length() == 0){
				throw new IllegalArgumentException("The second string is empty!");
			}
			
			//now we'll use the contains method to see if str2 is even in str1, if not return the checker positionIndex
			else if (str1.contains(str2) == false){
				return -1;
			}
			
			//we'll now go through str1
			for (int x=0; x < str1.length()-str2.length()+1; x++){
				//compare against the first letters
				if (str1.substring(x, x+1).equals(str2.substring(0,1))){
					
					//if it matches then record the index and increment stringLength
					stringLength++;
					
					//now we need to walk through str2
					for (int z = 1; z < str2.length(); z++){
						
						//check the following chracters between str1 and str2
						if (str1.substring((x+z), x+z+1).equals(str2.substring(z, z+1))){
							stringLength++; //increment the length matching
						}
					}				
					//now if the stringLength matches str2.length() thnwe we can return the index
					if (stringLength == str2.length())
					{
						positionIndex = x; 
						return positionIndex;
					}
				}
				else{ //just reset everything
					stringLength = 0;
					positionIndex = -1;
				}
			}
			
			//finally we can now return the position of str2 in str1 IF it even exists
			return positionIndex;
		}
	}
	
	


