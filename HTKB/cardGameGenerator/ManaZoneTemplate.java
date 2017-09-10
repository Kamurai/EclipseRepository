package cardGameGenerator;
//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class ManaZoneTemplate extends CardDeckTemplate
{
  
  	//Establish variables

	int Mana[];		
	
		//"Deck" is built on a number of cards
		public ManaZoneTemplate(int DeckSize, int num)
		{
			super(DeckSize);
						
			Mana = new int[num];
							
					
		}
		
		//Account for Mana Pool
		
		//Add Mana
		public void AddMana(int color, int num)
		{
			Mana[color] += num;
		}
		
		//Remove Mana
		public void RemoveMana(int color, int num)
		{
			Mana[color] -= num;
		}
		//Show Mana
		public int ShowMana(int color)
		{
			
			return Mana[color];
		}
				
	
		
}
