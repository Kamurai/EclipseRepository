package drawthreecards;


public class DeckDriver 
{

	
	/*
	 *build deck;
	 *draw card x3
	 */
	
	
	
	
	
	public static void main(String[] args) 
	{
//these were moved here from above the main statement
		Card tempcard;
		Deck tempdeck = new Deck();
		
	
		// draw 3 cards from deck
		for(int x = 0; x < 53; x++)
		{
			tempcard = tempdeck.DrawUnique();
		// display each card
			System.out.println(tempcard.rank + " of " + tempcard.suit);
		}
	}
	
	
}
