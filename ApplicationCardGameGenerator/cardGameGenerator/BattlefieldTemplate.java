package cardGameGenerator;
//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class BattlefieldTemplate extends CardDeckTemplate
{
  
  	//Establish variables

	CardDeckTemplate FrontRank;
	CardDeckTemplate RearRank;
	CardDeckTemplate Spells;
	CardDeckTemplate Objects;
	
	
		//"Deck" is built on a number of cards
		public BattlefieldTemplate(int DeckSize)
		{
			super(DeckSize);
			CardDeckTemplate FrontRank = new CardDeckTemplate(0);
			CardDeckTemplate RearRank = new CardDeckTemplate(0);
			CardDeckTemplate Spells = new CardDeckTemplate(0);
			CardDeckTemplate Objects = new CardDeckTemplate(0);				
		}
		
		//Add to Front Rank
		public void AddtoFrontRank(CardTemplate bob)
		{
			FrontRank.AddCard(bob);
		}
		//Add to Rear Rank
		public void AddtoRearRank(CardTemplate bob)
		{
			RearRank.AddCard(bob);
		}
		//Add to Spells
		public void AddtoSpells(CardTemplate bob)
		{
			Spells.AddCard(bob);
		}
		//Add to Objects
		public void AddtoObjects(CardTemplate bob)
		{
			Objects.AddCard(bob);
		}

		//Draw from Front Rank
		public CardTemplate DrawFromFrontRank(CardDeckTemplate bob)
		{
			CardTemplate result = FrontRank.DrawCard(bob);
			return result;
		}
		//Draw from Rear Rank
		public CardTemplate DrawFromRearRank(CardDeckTemplate bob)
		{
			CardTemplate result = RearRank.DrawCard(bob);
			return result;
		
		}
		//Draw from Spells
		public CardTemplate DrawFromSpells(CardDeckTemplate bob)
		{
			CardTemplate result = Spells.DrawCard(bob);
			return result;
		
		}
		//Draw from Objects
		public CardTemplate DrawFromObjects(CardDeckTemplate bob)
		{
			CardTemplate result = Objects.DrawCard(bob);
			return result;
		
		}

		//Insert into Front Rank
		public void InsertIntoFrontRank(CardTemplate bob, int num)
		{
			FrontRank.InsertCard(bob, num);
		}
		//Insert into Rear Rank
		public void InsertIntoRearRank(CardTemplate bob, int num)
		{
			RearRank.InsertCard(bob, num);
		}
		//Insert into Spells
		public void InsertIntoSpells(CardTemplate bob, int num)
		{
			Spells.InsertCard(bob, num);
		}
		//Insert into Objects
		public void InsertIntoObjects(CardTemplate bob, int num)
		{
			Objects.InsertCard(bob, num);
		}

		//Remove from Front Rank
		public CardTemplate RemoveFromFrontRank(CardDeckTemplate bob, int num)
		{
			CardTemplate result = FrontRank.RemoveCard(bob, num);
			return result;
		}
		//Remove from Rear Rank
		public CardTemplate RemoveFromRearRank(CardDeckTemplate bob, int num)
		{
			CardTemplate result = RearRank.RemoveCard(bob, num);
			return result;
		
		}
		//Remove from Spells
		public CardTemplate RemoveFromSpells(CardDeckTemplate bob, int num)
		{
			CardTemplate result = Spells.RemoveCard(bob, num);
			return result;
		
		}
		//Remove from Objects
		public CardTemplate RemoveFromObjects(CardDeckTemplate bob, int num)
		{
			CardTemplate result = Objects.RemoveCard(bob, num);
			return result;
		
		}
		
		//Search for a specific card in the Front Rank
		public CardTemplate SearchInFrontRank(CardDeckTemplate bob, CardTemplate joe)
		{
			CardTemplate result = FrontRank.SearchForCard(bob, joe);
			return result;
		
		}
				
		//Search for a specific card in the Rear Rank
		public CardTemplate SearchInRearRank(CardDeckTemplate bob, CardTemplate joe)
		{
			CardTemplate result = RearRank.SearchForCard(bob, joe);
			return result;
		
		}
		
		//Search for a specific card in the Spells
		public CardTemplate SearchInSpells(CardDeckTemplate bob, CardTemplate joe)
		{
			CardTemplate result = Spells.SearchForCard(bob, joe);
			return result;
		
		}
		
		//Search for a specific card in the Objects
		public CardTemplate SearchInObjects(CardDeckTemplate bob, CardTemplate joe)
		{
			CardTemplate result = Objects.SearchForCard(bob, joe);
			return result;
		
		}
		
		
		
		//Look at any card in the Front Rank
		public CardTemplate LookAtInFrontRank(int num)
		{
			CardTemplate result = FrontRank.LookAtCard(num);
			return result;
		
		}
		
		//Look at any card in the Rear Rank
		public CardTemplate LookAtInRearRank(int num)
		{
			CardTemplate result = RearRank.LookAtCard(num);
			return result;
		
		}

		//Look at any card in the Spells
		public CardTemplate LookAtInSpells(int num)
		{
			CardTemplate result = Spells.LookAtCard(num);
			return result;
		
		}

		//Look at any card in the Objects
		public CardTemplate LookAtInObjects(int num)
		{
			CardTemplate result = Objects.LookAtCard(num);
			return result;
		
		}

		
		
}
