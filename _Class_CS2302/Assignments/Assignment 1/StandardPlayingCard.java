//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class StandardPlayingCard
{
  
  	//Establish variables
		
	private String Rank;
	private String Suit;
		
		public StandardPlayingCard(String Rank, String Suit)
		{
			this.Rank = Rank;
			this.Suit = Suit;	
		}
		
		public String GetName()
		{
		String result;
		
		result = Rank + " of " + Suit;
		
		return result;
		}
		
}
