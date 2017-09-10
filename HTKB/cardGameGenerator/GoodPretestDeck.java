package cardGameGenerator;
//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;


public class GoodPretestDeck
{
  
  	//Establish variables
		CardDeckTemplate bob;
		String[] CardInfo;
		CardTemplate joe;
		int DeckSize;
	
	//"Deck" is built on a number of cards
		public GoodPretestDeck()
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
			CardInfo[0] = "Slayer King";
			//Cost
			CardInfo[1] = "7G";
			//ReCall
			CardInfo[2] = "6G";
			//Type
			CardInfo[3] = "Character - Dwarf";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "2B: +2/-1";
			//XFactor
			CardInfo[6] = "6G";
			//Attack
			CardInfo[7] = "8";
			//Defense
			CardInfo[8] = "4";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			
			//Card 2
			//Name
			CardInfo[0] = "Arch Seraphim: Lord Avatar";
			//Cost
			CardInfo[1] = "8G";
			//ReCall
			CardInfo[2] = "10G";
			//Type
			CardInfo[3] = "Character - Angel";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "Flying";
			//XFactor
			CardInfo[6] = "10G";
			//Attack
			CardInfo[7] = "8";
			//Defense
			CardInfo[8] = "10";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);

			//Card 3
			//Name
			CardInfo[0] = "Berzerker Chieftain";
			//Cost
			CardInfo[1] = "6G";
			//ReCall
			CardInfo[2] = "7G";
			//Type
			CardInfo[3] = "Character - Dwarf";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "2B: +2/-1";
			//XFactor
			CardInfo[6] = "5G";
			//Attack
			CardInfo[7] = "6";
			//Defense
			CardInfo[8] = "3";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			
			//Card 4
			//Name
			CardInfo[0] = "Elvish High Cleric";
			//Cost
			CardInfo[1] = "5G";
			//ReCall
			CardInfo[2] = "7G";
			//Type
			CardInfo[3] = "Character - Elf";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "@: Prvent all Damage to 1 Target for this turn";
			//XFactor
			CardInfo[6] = "8G";
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
			CardInfo[0] = "Grand Warlock";
			//Cost
			CardInfo[1] = "5G";
			//ReCall
			CardInfo[2] = "7G";
			//Type
			CardInfo[3] = "Character - Elf";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "@: Destroy Target with equal or less Alignment";
			//XFactor
			CardInfo[6] = "7G";
			//Attack
			CardInfo[7] = "4";
			//Defense
			CardInfo[8] = "3";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			
			
			//Card 6 and 7
			//Name
			CardInfo[0] = "Slayer's Bloodlust";
			//Cost
			CardInfo[1] = "2G";
			//ReCall
			CardInfo[2] = "4G";
			//Type
			CardInfo[3] = "Sigil";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "G(CAP 1): +1/+0 to each creature in the Slayer's Guild\n @: 2G";
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
			CardInfo[0] = "Wizard's Circle";
			//Cost
			CardInfo[1] = "2G";
			//ReCall
			CardInfo[2] = "4G";
			//Type
			CardInfo[3] = "Sigil";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "G(CAP 1): Return all creatures in the Wizard's Guild to ready mode\n @: 2G";
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
			CardInfo[0] = "Heaven's Blessing";
			//Cost
			CardInfo[1] = "2G";
			//ReCall
			CardInfo[2] = "4G";
			//Type
			CardInfo[3] = "Sigil";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "G(CAP 1):+1 AL for Good Creatures\n @: 2G";
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
			CardInfo[0] = "Holy Light";
			//Cost
			CardInfo[1] = "2G";
			//ReCall
			CardInfo[2] = "4G";
			//Type
			CardInfo[3] = "Sigil";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "-1 AL to all Evil Creatures\n @: 2G";
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
			CardInfo[0] = "Wizard's Shield";
			//Cost
			CardInfo[1] = "2G";
			//ReCall
			CardInfo[2] = "4G";
			//Type
			CardInfo[3] = "Sigil";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "G(CAP 1): +0/+1 to Creatures in the Wizard's Guild\n @: 2G";
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
			CardInfo[0] = "Pact Nation Great Keep";
			//Cost
			CardInfo[1] = "3G";
			//ReCall
			CardInfo[2] = "4G";
			//Type
			CardInfo[3] = "Land";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Summon: Angels, Dragons, Dwarves, Elves\n @: GGBB";
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
			CardInfo[0] = "Mystical Isle";
			//Cost
			CardInfo[1] = "2G";
			//ReCall
			CardInfo[2] = "3G";
			//Type
			CardInfo[3] = "Land";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Summon: Phoenix, Dragons, Angels\n @: G2B";
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
			CardInfo[0] = "Sky Palace";
			//Cost
			CardInfo[1] = "1G";
			//ReCall
			CardInfo[2] = "2G";
			//Type
			CardInfo[3] = "Land";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Summon: Angels, Phoenix\n @: 2G";
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
			CardInfo[0] = "Hidden Forest";
			//Cost
			CardInfo[1] = "0B";
			//ReCall
			CardInfo[2] = "1B";
			//Type
			CardInfo[3] = "Land";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Summon: Elves\n @: 1G";
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
			CardInfo[0] = "Great Mountains";
			//Cost
			CardInfo[1] = "0B";
			//ReCall
			CardInfo[2] = "1B";
			//Type
			CardInfo[3] = "Land";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Summon: Dwarves\n @: 1G";
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
			CardInfo[0] = "Needle Cannon";
			//Cost
			CardInfo[1] = "4B";
			//ReCall
			CardInfo[2] = "5B";
			//Type
			CardInfo[3] = "Function";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "2B(CAP 4B): Deal 1 Damage to Target";
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
			CardInfo[0] = "Purity";
			//Cost
			CardInfo[1] = "1GxB";
			//ReCall
			CardInfo[2] = "";
			//Type
			CardInfo[3] = "Channel";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Target Player gains X Life\n CAP 10";
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
			CardInfo[0] = "Safety";
			//Cost
			CardInfo[1] = "2G";
			//ReCall
			CardInfo[2] = "";
			//Type
			CardInfo[3] = "Spell";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Prevent 3 Damage to Target this Turn";
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
			CardInfo[0] = "Abrupt";
			//Cost
			CardInfo[1] = "4G";
			//ReCall
			CardInfo[2] = "";
			//Type
			CardInfo[3] = "Counter";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Counter Target Card";
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
			CardInfo[0] = "Aura Shield";
			//Cost
			CardInfo[1] = "2G1B";
			//ReCall
			CardInfo[2] = "";
			//Type
			CardInfo[3] = "Augment";
			//Affiliation
			CardInfo[4] = "Assault";
			//Text
			CardInfo[5] = "Target receives +0/+3";
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
			CardInfo[0] = "Great Strength";
			//Cost
			CardInfo[1] = "1B";
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
			CardInfo[0] = "Dwarf Slayer";
			//Cost
			CardInfo[1] = "1G2B";
			//ReCall
			CardInfo[2] = "4B";
			//Type
			CardInfo[3] = "Dwarf";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "";
			//XFactor
			CardInfo[6] = "4G";
			//Attack
			CardInfo[7] = "4";
			//Defense
			CardInfo[8] = "3";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			
			//Card 69 - 72
			//Name
			CardInfo[0] = "Great Berserker";
			//Cost
			CardInfo[1] = "2G2B";
			//ReCall
			CardInfo[2] = "G4B";
			//Type
			CardInfo[3] = "Dwarf";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "1G1B: +1 AL, +2/-1";
			//XFactor
			CardInfo[6] = "2G";
			//Attack
			CardInfo[7] = "4";
			//Defense
			CardInfo[8] = "3";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 73 - 76
			//Name
			CardInfo[0] = "Possessed Slayer";
			//Cost
			CardInfo[1] = "3G2B";
			//ReCall
			CardInfo[2] = "6B";
			//Type
			CardInfo[3] = "Dwarf";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "Must always Assault";
			//XFactor
			CardInfo[6] = "G";
			//Attack
			CardInfo[7] = "8";
			//Defense
			CardInfo[8] = "3";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);


			//Card 77 - 80
			//Name
			CardInfo[0] = "Angel Slayer";
			//Cost
			CardInfo[1] = "2G1B";
			//ReCall
			CardInfo[2] = "4G";
			//Type
			CardInfo[3] = "Angel";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "Flying";
			//XFactor
			CardInfo[6] = "4G";
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

			//Card 81 - 84
			//Name
			CardInfo[0] = "Archangel";
			//Cost
			CardInfo[1] = "3G3B";
			//ReCall
			CardInfo[2] = "6G";
			//Type
			CardInfo[3] = "Angel";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "Flying";
			//XFactor
			CardInfo[6] = "5G";
			//Attack
			CardInfo[7] = "5";
			//Defense
			CardInfo[8] = "3";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 85 - 88
			//Name
			CardInfo[0] = "Elven Cleric";
			//Cost
			CardInfo[1] = "2G";
			//ReCall
			CardInfo[2] = "3G";
			//Type
			CardInfo[3] = "Elf";
			//Affiliation
			CardInfo[4] = "Wizard's Guild";
			//Text
			CardInfo[5] = "@: Prevent 3 Damage to Target";
			//XFactor
			CardInfo[6] = "5G";
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

			//Card 89 - 92
			//Name
			CardInfo[0] = "Elven Warlock";
			//Cost
			CardInfo[1] = "2G";
			//ReCall
			CardInfo[2] = "3G";
			//Type
			CardInfo[3] = "Elf";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "@: Deal 3 Damage to Target";
			//XFactor
			CardInfo[6] = "2G";
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
			
			//Card 93 - 96
			//Name
			CardInfo[0] = "Cave Dragon";
			//Cost
			CardInfo[1] = "5B";
			//ReCall
			CardInfo[2] = "6B";
			//Type
			CardInfo[3] = "Dragon";
			//Affiliation
			CardInfo[4] = "Assault - Wildlife";
			//Text
			CardInfo[5] = "";
			//XFactor
			CardInfo[6] = "3N";
			//Attack
			CardInfo[7] = "7";
			//Defense
			CardInfo[8] = "5";
					
			//Create a Card
			joe.SetInfo(CardInfo);
			//Add Card to Deck
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);
			bob.AddCard(joe);

			//Card 97 - 100
			//Name
			CardInfo[0] = "Fire Phoenix";
			//Cost
			CardInfo[1] = "4B";
			//ReCall
			CardInfo[2] = "5B";
			//Type
			CardInfo[3] = "Phoenix";
			//Affiliation
			CardInfo[4] = "Assault - Slayer's Guild";
			//Text
			CardInfo[5] = "Flying\n8B: Play this Card from the Graveyard, as if in your hand";
			//XFactor
			CardInfo[6] = "2N";
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




			//When complete shuffle deck
			bob.Shuffle();
		}
		
		//pass deck from Loader to player
		public CardDeckTemplate Load()
		{
			return bob;
		}
				
	
		
}
