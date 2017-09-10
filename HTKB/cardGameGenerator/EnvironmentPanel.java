package cardGameGenerator;
//Kemerait, Christopher
//Card Game Engine
//Environmental Panel

//Must allow for one of the following for both player and enemy:
/*

(cards)Deck[]
(cards)Battlezone[]
(cards)ManaZone[]
int[] ManaPool
(cards)Library[]
(cards)Graveyard[]

Need "Card" object
Need Object that is an array of Card Objects "Deck"


*/



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
//import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;


public class EnvironmentPanel extends JPanel
{

	int StartingLife = 50;
	EvilPretestDeck MikeDeck = new EvilPretestDeck();
	GoodPretestDeck AdamDeck = new GoodPretestDeck();
	int StartingHand = 5;
	int HandCap = 5;
	int ManaCount = 4;
	//Shield Count is not to currently excede 6
	int ShieldCount = 6;
	String Result = "";
	
	//Establish Subsquent Panel
	
		//JPanel PhonePadPanel = new JPanel();
		JPanel NorthPanel = new JPanel();
		JPanel SouthPanel = new JPanel();
		JPanel EastPanel = new JPanel();
		JPanel WestPanel = new JPanel();
		JPanel CenterPanel = new JPanel();

		//Establish Test Labels

		JLabel EastLabelList[] =
		{
			new JLabel("Player Information:"),
			new JLabel("Life Points:\n"),
			new JLabel( "00" ),
			new JLabel("Turn Count:\n"),
			new JLabel( "00" )

		};
		
		//JButton[] EastButtonList = new JButton[ShieldCount];

		JButton EastButtonList[] =
		{
			new JButton("Shield 1"),
			new JButton("Shield 2"),
			new JButton("Shield 3"),
			new JButton("Shield 4"),
			new JButton("Shield 5"),
			new JButton("Shield 6")	
		
		};

		
				
		JLabel WestLabelList[] =
		{
			new JLabel("Opponent Information:"),
			new JLabel("Life Points:\n"),
			new JLabel( "00" ),
			new JLabel("Turn Count:\n"),
			new JLabel( "00" )
		};
		
		JButton WestButtonList[] =
		{
			new JButton("Shield 1"),
			new JButton("Shield 2"),
			new JButton("Shield 3"),
			new JButton("Shield 4"),
			new JButton("Shield 5"),
			new JButton("Shield 6")	
		
		};
		
		JButton SouthButtonList[] =
		{
			new JButton("Removed"),
			new JButton("Graveyard"),
			new JButton("Library"),
			new JButton("Hand 1"),
			new JButton("Hand 2"),
			new JButton("Hand 3"),
			new JButton("Hand 4"),
			new JButton("Hand 5"),
			new JButton("Hand 6"),
			new JButton("Hand 7")	
		
		};
		
		JButton CenterButtonList[] =
		{
			//Opponent Mana
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			//Opponent Functions
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			//Opponent Enchantments
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			//Opponent Rear Rank
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			//Opponent Front Rank
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			//Null Rank 
			new JButton("---"),
			new JButton("---"),
			new JButton("---"),
			new JButton("---"),
			new JButton("---"),
			new JButton("---"),
			new JButton("---"),
			new JButton("---"),
			new JButton("---"),
			new JButton("---"),
			//Player Front Rank
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			//Player Rear Rank
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			//Player Enchantments
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			//Player Functions
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			//Player Mana
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
			new JButton(),
		
		};

		JTextArea CenterDisplay = new JTextArea();
		JTextArea NorthDisplay = new JTextArea();
		JTextArea SouthDisplay = new JTextArea();
		
		
		
		
	public EnvironmentPanel()
	{
		//Format for loading a deck will be as such:
		PlayerTemplate Mike = new PlayerTemplate(StartingLife, MikeDeck.Load(), StartingHand, HandCap, ManaCount, ShieldCount);	
		PlayerTemplate Adam = new PlayerTemplate(StartingLife, AdamDeck.Load(), StartingHand, HandCap, ManaCount, ShieldCount);	
		
		//Initialize Player Shields
		//for(int x = 0; x < ShieldCount; x++)
		//{
		//	EastButtonList[x].setText( "Shield" );
		//};
		
		//Set Panel
		setBackground (Color.white);
      setPreferredSize (new Dimension (900, 600));
		
		//Set Layout
		setLayout ( new BorderLayout() );
		
		//Add Objects

		//Add Subsequent Panel
			add (CenterPanel, BorderLayout.CENTER);
			add (NorthPanel, BorderLayout.NORTH);
			add (SouthPanel, BorderLayout.SOUTH);
			add (EastPanel, BorderLayout.EAST);
			add (WestPanel, BorderLayout.WEST);

			CenterPanel.setBackground (Color.white);
			NorthPanel.setBackground (Color.white);
			SouthPanel.setBackground (Color.white);
			EastPanel.setBackground (Color.white);
			WestPanel.setBackground (Color.white);
		
		//Add Text Areas
			NorthPanel.add (NorthDisplay);
			
			
			
			EastPanel.setLayout( new GridLayout(12, 1));
			WestPanel.setLayout( new GridLayout(12, 1));
			
			CenterPanel.setLayout( new GridLayout(11, 10) );
			
			NorthDisplay.setText("Instructional Space");
			
			
			//Load Player Information			
			EastPanel.add(EastLabelList[0]);
			EastPanel.add(EastLabelList[1]);
			EastPanel.add(EastLabelList[2]);
			EastPanel.add(EastLabelList[3]);
			EastPanel.add(EastLabelList[4]);
			//Load Player Starting Life
			EastLabelList[2].setText( Integer.toString(StartingLife) );
			//Load Player Shields
			for(int x = 0; x < ShieldCount; x++)
			{
				EastPanel.add(EastButtonList[x]);			
			};
			
			//Load Opponent Information
			WestPanel.add(WestLabelList[0]);
			WestPanel.add(WestLabelList[1]);
			WestPanel.add(WestLabelList[2]);
			WestPanel.add(WestLabelList[3]);
			WestPanel.add(WestLabelList[4]);
			//Load Opponent Starting Life
			WestLabelList[2].setText( Integer.toString(StartingLife) );
			//Load Opponent Shields
			for(int x = 0; x < ShieldCount; x++)
			{
				WestPanel.add(WestButtonList[x]);
			};
			
			//Load Current Player Removed, Graveyard, and Library
			SouthPanel.add(SouthButtonList[0]);			
			SouthPanel.add(SouthButtonList[1]);
			SouthPanel.add(SouthButtonList[2]);
			
			//Load Current Player Hand
			for(int x = 3; x < (StartingHand+3); x++)
			{
				SouthPanel.add(SouthButtonList[x]);
			};
			
			//Load Buttons for Battlefield
			for(int x = 0; x < 110; x++)
			{
				CenterPanel.add(CenterButtonList[x]);
			};

   }
	
	
}
