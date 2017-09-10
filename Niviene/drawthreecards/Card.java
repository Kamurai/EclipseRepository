package drawthreecards;


public class Card 
{
	/*
	 * must have suit
	 * must have rank
	 */
	public String suit;
	public String rank;

	public Card(String suit, String rank)
	{
		this.suit = suit;
		this.rank = rank;
		
		
	}

	//these were added for testing purposes
	
	public String getSuit()
	{
		return this.suit;
	}
	
	public String getRank()
	{
		return this.rank;
	}
	
	public void setCard(String suit, String rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
}
