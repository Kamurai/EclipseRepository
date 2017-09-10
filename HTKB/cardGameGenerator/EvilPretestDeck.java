package cardGameGenerator;
//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;


public class EvilPretestDeck
{
  
  	//Establish variables
		CardDeckTemplate bob;
		String[] CardInfo;
		CardTemplate joe;
		int DeckSize;
	
	//"Deck" is built on a number of cards
		public EvilPretestDeck()
		{
			//Make a Information String Array
			CardInfo = new String[9];
			//Make a temporary Empty Card
			joe = new CardTemplate(CardInfo);
			//Arbitrate Deck Size
			DeckSize = 100;
			//Make an Empty Deck
			bob = new CardDeckTemplate(DeckSize);
			
			
		}
		
	//Deck Creation
		public void DeckCreation()
		{
			//Initialize Card Information
			
			//Card 1
			//Name
			CardInfo[0] = "Goblin Battle Commander";
			//Cost
			CardInfo[1] = "4E";
			//ReCall
			CardInfo[2] = "6E";
			//Type
			CardInfo[3] = "Character - Goblin";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "@: Sacrifice a goblin to deal 5 damage to target";
			//XFactor
			CardInfo[6] = "5E";
			//Attack
			CardInfo[7] = "4";
			//Defense
			CardInfo[8] = "4";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			
			//Card 2
			//Name
			CardInfo[0] = "Grand Exalted Warchief";
			//Cost
			CardInfo[1] = "6E";
			//ReCall
			CardInfo[2] = "8E";
			//Type
			CardInfo[3] = "Character - Ork";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "";
			//XFactor
			CardInfo[6] = "6E";
			//Attack
			CardInfo[7] = "7";
			//Defense
			CardInfo[8] = "8";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);

			//Card 3
			//Name
			CardInfo[0] = "Mystical Shaman Chieftain";
			//Cost
			CardInfo[1] = "5E";
			//ReCall
			CardInfo[2] = "7E";
			//Type
			CardInfo[3] = "Character - Ork";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "";
			//XFactor
			CardInfo[6] = "6E";
			//Attack
			CardInfo[7] = "5";
			//Defense
			CardInfo[8] = "5";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			
			//Card 4
			//Name
			CardInfo[0] = "Crazed Goblin Genius";
			//Cost
			CardInfo[1] = "4E";
			//ReCall
			CardInfo[2] = "6E";
			//Type
			CardInfo[3] = "Character - Goblin";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "@: Deal 3 Damage to Target";
			//XFactor
			CardInfo[6] = "5E";
			//Attack
			CardInfo[7] = "3";
			//Defense
			CardInfo[8] = "3";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);

			//Card 5
			//Name
			CardInfo[0] = "Dark Daemon";
			//Cost
			CardInfo[1] = "7E";
			//ReCall
			CardInfo[2] = "9E";
			//Type
			CardInfo[3] = "Character - Daemon";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "Flying";
			//XFactor
			CardInfo[6] = "7E";
			//Attack
			CardInfo[7] = "9";
			//Defense
			CardInfo[8] = "7";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			
			
			//Card 6 and 7
			//Name
			CardInfo[0] = "Goblin Favor";
			//Cost
			CardInfo[1] = "2E";
			//ReCall
			CardInfo[2] = "4E";
			//Type
			CardInfo[3] = "Sigil";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "+0/+1 to Goblins\n @: 2E";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 8 and 9
			//Name
			CardInfo[0] = "Ork Bloodlust";
			//Cost
			CardInfo[1] = "2E";
			//ReCall
			CardInfo[2] = "4E";
			//Type
			CardInfo[3] = "Sigil";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "+1/-1 to Orks\n @: 2E";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			
			
			//Card 10 and 11
			//Name
			CardInfo[0] = "Power to Evil";
			//Cost
			CardInfo[1] = "2E";
			//ReCall
			CardInfo[2] = "4E";
			//Type
			CardInfo[3] = "Sigil";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "+1/+0 to Evil Creatures\n @: 2E";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			
			//Card 12 and 13
			//Name
			CardInfo[0] = "Pestilence of Ages";
			//Cost
			CardInfo[1] = "2E";
			//ReCall
			CardInfo[2] = "4E";
			//Type
			CardInfo[3] = "Sigil";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "-0/-1 to Good Creatures\n @: 2E";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 14 and 15
			//Name
			CardInfo[0] = "Daemon Portal";
			//Cost
			CardInfo[1] = "2E";
			//ReCall
			CardInfo[2] = "4E";
			//Type
			CardInfo[3] = "Sigil";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Daemons are Phased when assaulting\n @: 2E";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 16 and 17
			//Name
			CardInfo[0] = "Horde Village";
			//Cost
			CardInfo[1] = "3E";
			//ReCall
			CardInfo[2] = "4E";
			//Type
			CardInfo[3] = "Land";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Summon: Orks, Goblins, Daemons, Beasts\n @: E or 3E";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 18 - 20
			//Name
			CardInfo[0] = "Catacombs";
			//Cost
			CardInfo[1] = "2E";
			//ReCall
			CardInfo[2] = "3E";
			//Type
			CardInfo[3] = "Land";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Summon: Dragons, Demons, Ghosts\n @: E or 2E";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 21 - 24
			//Name
			CardInfo[0] = "Beast Grounds";
			//Cost
			CardInfo[1] = "1E";
			//ReCall
			CardInfo[2] = "2E";
			//Type
			CardInfo[3] = "Land";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Summon: Behemoths, Dragons\n @: 1E1B";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);


			//Card 25 - 32
			//Name
			CardInfo[0] = "Tainted Swamp";
			//Cost
			CardInfo[1] = "0B";
			//ReCall
			CardInfo[2] = "1B";
			//Type
			CardInfo[3] = "Land";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Summon: Orks\n @: 1E";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 33 - 40
			//Name
			CardInfo[0] = "Murky Bog";
			//Cost
			CardInfo[1] = "0B";
			//ReCall
			CardInfo[2] = "1B";
			//Type
			CardInfo[3] = "Land";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Summon: Goblins\n @: 1E";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 41 - 44
			//Name
			CardInfo[0] = "Goblin Catapult";
			//Cost
			CardInfo[1] = "2B1E";
			//ReCall
			CardInfo[2] = "4B";
			//Type
			CardInfo[3] = "Function";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "1B: Goblin gains Flying & +*2/+0 until End of Turn, then Sacrifice it";
			//XFactor
			CardInfo[6] = "1N";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			
			//Card 45 - 48
			//Name
			CardInfo[0] = "Lightning Flash";
			//Cost
			CardInfo[1] = "1ExB";
			//ReCall
			CardInfo[2] = "";
			//Type
			CardInfo[3] = "Channel";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Deal X Damage to Target\n CAP 5";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);


			//Card 49 - 52
			//Name
			CardInfo[0] = "Insane Charge";
			//Cost
			CardInfo[1] = "1E1B";
			//ReCall
			CardInfo[2] = "";
			//Type
			CardInfo[3] = "Spell";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Target receives +5/-5";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 53 - 56
			//Name
			CardInfo[0] = "Suicidal Sabotage";
			//Cost
			CardInfo[1] = "1E1B";
			//ReCall
			CardInfo[2] = "";
			//Type
			CardInfo[3] = "Counter";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Sacrifice a Goblin, Counter Target Card";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			
			//Card 57 - 60
			//Name
			CardInfo[0] = "Unholy Sacrifice";
			//Cost
			CardInfo[1] = "2E";
			//ReCall
			CardInfo[2] = "";
			//Type
			CardInfo[3] = "Augment";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Target receives +4/-2";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 61 - 64
			//Name
			CardInfo[0] = "Boosta Joos";
			//Cost
			CardInfo[1] = "1E";
			//ReCall
			CardInfo[2] = "";
			//Type
			CardInfo[3] = "Augment";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Target receives +1/+1";
			//XFactor
			CardInfo[6] = "";
			//Attack
			CardInfo[7] = "";
			//Defense
			CardInfo[8] = "";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 65 - 68
			//Name
			CardInfo[0] = "Peashooter";
			//Cost
			CardInfo[1] = "1E";
			//ReCall
			CardInfo[2] = "2B";
			//Type
			CardInfo[3] = "Goblin";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "";
			//XFactor
			CardInfo[6] = "2E";
			//Attack
			CardInfo[7] = "1";
			//Defense
			CardInfo[8] = "1";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			
			//Card 69 - 72
			//Name
			CardInfo[0] = "Arrow Boy";
			//Cost
			CardInfo[1] = "1E1B";
			//ReCall
			CardInfo[2] = "2E1B";
			//Type
			CardInfo[3] = "Ork";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "";
			//XFactor
			CardInfo[6] = "2E";
			//Attack
			CardInfo[7] = "2";
			//Defense
			CardInfo[8] = "1";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 73 - 76
			//Name
			CardInfo[0] = "Goblin Bomma";
			//Cost
			CardInfo[1] = "2E";
			//ReCall
			CardInfo[2] = "3E";
			//Type
			CardInfo[3] = "Goblin";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "";
			//XFactor
			CardInfo[6] = "3E";
			//Attack
			CardInfo[7] = "1";
			//Defense
			CardInfo[8] = "1";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);


			//Card 77 - 80
			//Name
			CardInfo[0] = "Black Dragonling";
			//Cost
			CardInfo[1] = "2E2B";
			//ReCall
			CardInfo[2] = "2E3B";
			//Type
			CardInfo[3] = "Dragon";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "Flying";
			//XFactor
			CardInfo[6] = "1E";
			//Attack
			CardInfo[7] = "5";
			//Defense
			CardInfo[8] = "5";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 81 - 84
			//Name
			CardInfo[0] = "Furie";
			//Cost
			CardInfo[1] = "3E";
			//ReCall
			CardInfo[2] = "4E";
			//Type
			CardInfo[3] = "Daemon";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "Flying";
			//XFactor
			CardInfo[6] = "4E";
			//Attack
			CardInfo[7] = "4";
			//Defense
			CardInfo[8] = "4";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 85 - 88
			//Name
			CardInfo[0] = "Great Behemoth";
			//Cost
			CardInfo[1] = "5B";
			//ReCall
			CardInfo[2] = "6B";
			//Type
			CardInfo[3] = "Behemoth";
			//Affiliation
			CardInfo[4] = "Assault - Wildlife";
			//Text
			CardInfo[5] = "";
			//XFactor
			CardInfo[6] = "3N";
			//Attack
			CardInfo[7] = "6";
			//Defense
			CardInfo[8] = "6";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 89 - 92
			//Name
			CardInfo[0] = "Badland Bezerker";
			//Cost
			CardInfo[1] = "2E2B";
			//ReCall
			CardInfo[2] = "3E2B";
			//Type
			CardInfo[3] = "Ork";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "E: +2/-1, +1 AL";
			//XFactor
			CardInfo[6] = "3E";
			//Attack
			CardInfo[7] = "3";
			//Defense
			CardInfo[8] = "2";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			
			//Card 93 - 96
			//Name
			CardInfo[0] = "Badland Hunter";
			//Cost
			CardInfo[1] = "2E2B";
			//ReCall
			CardInfo[2] = "2E3B";
			//Type
			CardInfo[3] = "Ork";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "";
			//XFactor
			CardInfo[6] = "3E";
			//Attack
			CardInfo[7] = "4";
			//Defense
			CardInfo[8] = "2";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 97 - 100
			//Name
			CardInfo[0] = "Badland Warrior";
			//Cost
			CardInfo[1] = "1E2B";
			//ReCall
			CardInfo[2] = "2E2B";
			//Type
			CardInfo[3] = "Ork";
			//Affiliation
			CardInfo[4] = "Assault - Badland Horde";
			//Text
			CardInfo[5] = "";
			//XFactor
			CardInfo[6] = "3E";
			//Attack
			CardInfo[7] = "3";
			//Defense
			CardInfo[8] = "2";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
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
