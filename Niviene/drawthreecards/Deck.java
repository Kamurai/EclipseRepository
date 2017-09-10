package drawthreecards;

import java.util.Random;

public class Deck 
{

	/*
	 * 52 cards
	 * 52 trackers
	 * 	able to draw unique cards
	 * 		shuffle
	 */
	//Card card1 = new Card("Hearts","Five");
	//boolean tracker1 = true;
	Card[] cards = new Card[52];
	boolean[] trackers = new boolean[52];
	String[] suits = 
	{ "Spades", "Hearts", "Clubs", "Diamonds"};
	
	String[] ranks = 
	{ "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
	                         
	
	public Deck()
	{
		//declare all 52 trackers as true
		for(int x = 0; x < trackers.length; x++)
		{
			trackers[x] = true;
		}
		//suit rank 4 suits 13 ranks
		for(int x = 0; x < suits.length; x++)
		{
			//declare 13 cards as suit
			for(int y = 0; y < ranks.length; y++)
			{
				//assign a value to a  card
				cards[x*13+y] = new Card(suits[x], ranks[y]);
			}
		}
			
		
	}
	
	//method to randomly draw unique cards 
	public Card DrawUnique()
	{
		/*
		 * cards suck. 
		 * randomly pick # from 0-51
		 * check to see if tracker false
		 * if false
		 * 	loop again to find another true
		 * if true
		 * 	return card if true
		 */
		Random generator = new Random();
		int num = 0;
		
		for (int x = 0; x < cards.length; x++)
		{
			// randomly pick # from 0-51
			num = generator.nextInt(52);
		
			//check to see if tracker false
			if(trackers[num] == true)
			{
				//then return card
//we forgot to toggle the tracker here
				trackers[num] = false;
				return cards[num];
			}
			else
			{		
			}
		}
		
		return new Card("empty","empty");
	}
}
