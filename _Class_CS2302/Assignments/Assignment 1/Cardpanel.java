//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;


public class Cardpanel extends JPanel
{
  
  	//Establish variables
	private String result;
	private StandardPlayingCardDeck Deck;
	private int x;
	
	//Establish Subsequent Panels
	private JPanel NorthPanel = new JPanel();
	private JPanel CenterPanel = new JPanel();
	private JPanel SouthPanel = new JPanel();	

	//Establish Ojbects 		   	
	private JButton Process = new JButton ("Draw a Card");
	private JTextArea Display = new JTextArea ("No Cards Drawn");
	
			
		
		public Cardpanel()
		{
		//Set Variables
			Deck = new StandardPlayingCardDeck();
			result = "";
			x = 1;
		
		//Set Borderlayout
			setLayout ( new BorderLayout() );
			
		//Set Subsequent Panels
			add (NorthPanel, BorderLayout.NORTH);
			add (CenterPanel, BorderLayout.CENTER);
			
			
		//Set ActionListeners
		Process.addActionListener ( new Worker() );
		
		//Add objects
		NorthPanel.add (Process);
		CenterPanel.add (Display);
		
		//Set Text Area
		Display.setBackground (Color.white);

					
			
			
			
			
			
		//Set Panel
		
      JPanel panel = new JPanel();
      setBackground (Color.white);
      setPreferredSize (new Dimension (200, 900));		
		}
		
	private class Worker implements ActionListener
	{
  		//Establish variables	  	
		private Random generator = new Random();
	
	public void actionPerformed (ActionEvent event)
	{
 		//Draw a Card "at random" from Deck
		result += x + ")" + Deck.Draw() + "\n";
		Display.setText(result);
		x++;
				
	}
	
	}

		
		
		
}
