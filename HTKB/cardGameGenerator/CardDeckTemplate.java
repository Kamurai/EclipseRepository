package cardGameGenerator;
//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class CardDeckTemplate
{
  
  	//Establish variables

	public CardTemplate Cards[];
	public int DeckSize, x, y;
	Random generator = new Random();
		
	
		//"Deck" is built on a number of cards
		public CardDeckTemplate(int num)
		{
			//initialize Deck Size
			Cards = new CardTemplate[num];
			DeckSize = 0;
			
		}
		

		//draw a card from the top of the deck
		public CardTemplate DrawCard(CardDeckTemplate bob)
		{
			CardTemplate result;
			//If all cards are NOT removed proceed with draw
			if( DeckSize != 0 )
			{
			//return name of card drawn
			result = Cards[DeckSize];
			bob.AddCard(Cards[DeckSize]);
			//remove Card from Deck
			Cards[DeckSize] = null;
			

			//Decrement DeckSize
			DeckSize--;
			}
			//else do nothing
			else
			{
			result = null;
			};
			//return result
			return result;
		}
		
		
		
		//remove a card from anywhere in the deck
		public CardTemplate RemoveCard(CardDeckTemplate bob, int num)
		{
			CardTemplate result;
			//If all cards are NOT removed proceed with draw
			if( DeckSize != 0 )
			{
			//return name of card drawn
			result = Cards[num];
			bob.AddCard(Cards[num]);
			
			
			//collapse deck for removed card
			for(x = num; x <= DeckSize; x++)
			{
				Cards[x] = Cards[x+1];
			}

			//Decrement DeckSize
			DeckSize--;
			
			}
			//else do nothing
			else
			{
			result = null;
			};
			//return result
			return result;
		}


		
		//add a card to top of deck
		public void AddCard(CardTemplate bob)
		{
			//Increase DeckSize
			DeckSize++;
			//Insert Card into Deck
			Cards[DeckSize] = bob;
		}


		
		//Add a card anywhere
		public void InsertCard(CardTemplate bob, int num)
		{
			CardTemplate temp;
			
			//expand deck for inserted card
			for(x = DeckSize; x <= num+1; x--)
			{
				Cards[x+1] = Cards[x];
			}
			//Increase DeckSize
			DeckSize++;
			
			//Insert Card into Deck
			Cards[num] = bob;
			
			
		}
		
		
		
		public void Shuffle()
		{
			//Reassign Existing cards to temporary array in a new,
			// random order
			
			//Copy name of original array to temporary array
			//Ensure that cards fill array from 0 to DeckSize
			
			CardTemplate[] temp = new CardTemplate[DeckSize];
			
			//stepping through temp[0] to temp[DeckSize]
			for (x = 0; x <= DeckSize; x++)
			{
				while(Cards[y] != null)
				{
					y = generator.nextInt(DeckSize);
					if(Cards[y] != null)
					//assign a random element from Cards to temp
	  					temp[x] = Cards[y];
				}
				Cards[y] = null;
			}
   	   Cards = temp;
	
		
		}

		
		
		//Search for a specific card in the deck
		public CardTemplate SearchForCard(CardDeckTemplate bob, CardTemplate joe)
		{
			CardTemplate result = null;
			
			while(Cards[x] != joe && x <= DeckSize)
			{
				if( Cards[x] == joe)
				{
					result = RemoveCard(bob, x);
				}
				x++;
			}
			
			
			return result;
		}


		
		//Look at a card anywhere in the deck
		public CardTemplate LookAtCard(int num)
		{
			CardTemplate result;
			//If all cards are NOT removed proceed with draw
			if( DeckSize != 0 )
			{
			//return name of card drawn
			result = Cards[num];
			
			
			
			}
			//else do nothing
			else
			{
			result = null;
			};
			//return result
			return result;
		}

		
}
