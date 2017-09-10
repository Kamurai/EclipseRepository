//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class StandardPlayingCardDeck
{
  
  	//Establish variables
	private boolean[] Drawn;
	private boolean Trip;
	private StandardPlayingCard[] Cards;
	private int MaxDrawn, x, y, z;
	Random generator = new Random();
		
	
	private String[] Ranks =
	{
		new String("Ace"), new String("One"), new String("Two"),
		new String("Three"), new String("Four"), new String("Five"),
		new String("Six"), new String("Seven"), new String("Eight"), 
		new String("Nine"), new String("Ten"), new String("Jack"),
		new String("Queen"), new String("King")
	};

	private String[] Suits =
	{
		new String("Spades"), new String("Hearts"),
		new String("Clubs"), new String("Diamonds")
	};


		public StandardPlayingCardDeck()
		{
			Trip = false;
			Drawn = new boolean[52];
			for(x = 0; x < Drawn.length; x++)
				Drawn[x] = false;
			Cards = new StandardPlayingCard[52];
			for(x = 0; x < 4; x++)
			{
				for (y = 0; y < 13; y++)
				{
					Cards[z] = new StandardPlayingCard(Ranks[y], Suits[x]);
					z++;
				}
			}
		}
		
		public String Draw()
		{
			String result;
			//If all cards are NOT drawn proceed with draw
			if( MaxDrawn != 52)
			{
			//loop until an undrawn card is selected
			while(Drawn[x])
			{
			x = generator.nextInt(52);
			}
			//return name of card drawn
			result = Cards[x].GetName();
			//flag card as drawn
			Drawn[x] = true;
			//increment number of drawn cards
			MaxDrawn++;
			
			}
			//else do nothing
			else
			{
			result = "";
			};
			//return result
			return result;
		}
		
		
}
