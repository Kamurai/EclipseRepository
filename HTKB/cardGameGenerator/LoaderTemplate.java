package cardGameGenerator;
//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;


public abstract class LoaderTemplate 
{
  
  	//Establish variables
		CardDeckTemplate bob;
		String[] CardInfo;
		CardTemplate joe;
		int DeckSize;
		
	
	//"Deck" is built on a number of cards
		public LoaderTemplate()
		{
			//Make a Information String Array
			CardInfo = new String[9];
			//Make a temporary Empty Card
			joe = new CardTemplate(CardInfo);
			
		}
						
	
		
}
