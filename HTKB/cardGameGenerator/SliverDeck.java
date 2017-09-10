package cardGameGenerator;
//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;


public class SliverDeck extends LoaderTemplate 
{
  
  	//Establish variables
				
	
	//"Deck" is built on a number of cards
		public SliverDeck()
		{
			super();
			DeckSize = 60;
			//Make an Empty Deck
			bob = new CardDeckTemplate(DeckSize);
			
			
		}
		
	//Deck Creation
		public void DeckCreation()
		{
			
			//Initialize Card Information
			//Name
			CardInfo[0] = " ";
			//Cost
			CardInfo[1] = " ";
			//ReCall
			CardInfo[2] = " ";
			//Type
			CardInfo[3] = " ";
			//Affiliation
			CardInfo[4] = " ";
			//Text
			CardInfo[5] = " ";
			//XFactor
			CardInfo[6] = " ";
			//Attack
			CardInfo[7] = " ";
			//Defense
			CardInfo[8] = " ";
			
			
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			
			
			
			
			//When complete shuffle deck
			bob.Shuffle();
		}
		
		//pass deck from Loader to player
		public CardDeckTemplate Load()
		{
			return bob;
		}
				
	
		
}
