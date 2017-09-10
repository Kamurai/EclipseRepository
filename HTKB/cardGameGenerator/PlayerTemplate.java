package cardGameGenerator;
//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment


//Enironment Template will hold a number of players
//Each player will have their own set of decks

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class PlayerTemplate
{
  
  	//Establish variables
	
	
	//Area from which to draw Cards
	private CardDeckTemplate Drawpile;
	//Area in which to discard Cards
	private CardDeckTemplate Discardpile;
	//Area to hold available Cards
	private HandTemplate PlayerHand;
	//Area to hold available Cards for payment
	private ManaZoneTemplate PlayerManaZone;
	//Area to hold Cards that are in play
	private BattlefieldTemplate PlayerBattlefield;
	//Area to hold Cards that are removed from game
	private CardDeckTemplate RemovedCards;
	//Area to hold Shield Cards
	private CardDeckTemplate Shields;
	
	private int LifeCounter, ShieldCounter, x, y;

	
	public PlayerTemplate( int StartingLife, CardDeckTemplate bob, int StartingHand, int HandCap, int ManaCount, int ShieldCount)
	{
		LifeCounter = StartingLife;
		Drawpile = bob;
		//new CardDeckTemplate(DeckSize);
		PlayerHand = new HandTemplate(bob.DeckSize, HandCap);
		for(x = 0; x < StartingHand; x++)
		{
			Drawpile.DrawCard(PlayerHand);
		}
		
		Discardpile = new CardDeckTemplate(bob.DeckSize);
		PlayerManaZone = new ManaZoneTemplate(bob.DeckSize, ManaCount);
		RemovedCards = new CardDeckTemplate(bob.DeckSize);
		Shields = new CardDeckTemplate(ShieldCount);
		ShieldCounter = ShieldCount;
		
		PlayerBattlefield = new BattlefieldTemplate(bob.DeckSize);
		
	
	}
	
				
}
