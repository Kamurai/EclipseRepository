//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment

package assignment1;


import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Cardpanel extends JPanel
{
  
  	//Establish variables
		
	Random generator = new Random();
	
	/****************************************
	All instance fields should be private.
	****************************************/
				
	private int x = generator.nextInt(13);
	private int y = generator.nextInt(4);  		   	
		
			
	private String[] number =
	{
		new String("Ace"), new String("One"), new String("Two"),
		new String("Three"), new String("Four"), new String("Five"),
		new String("Six"), new String("Seven"), new String("Eight"), 
		new String("Nine"), new String("Ten"), new String("Jack"),
		new String("Queen"), new String("King")
	};

	private String[] suit =
	{
		new String("Spades"), new String("Hearts"),
		new String("Clubs"), new String("Diamonds")
	};
		
		public Cardpanel()
		{
		
		//Generate Cards to draw
		
		x = generator.nextInt(13);
		y = generator.nextInt(4); 
		String play1 = new String (number[x] + " of " + suit[y]);
		x = generator.nextInt(13);
		y = generator.nextInt(4); 
		String play2 = new String (number[x] + " of " + suit[y]);
		x = generator.nextInt(13);
		y = generator.nextInt(4); 
		String play3 = new String (number[x] + " of " + suit[y]);		

		//Print output
		System.out.println (play1);
		System.out.println (play2);
		System.out.println (play3);
		
		
		//label output option
				
		JLabel label1 = new JLabel (play1);
		JLabel label2 = new JLabel (play2);
		JLabel label3 = new JLabel (play3);		
		
	
			
		//Set Panel
		
      JPanel panel = new JPanel();
      setBackground (Color.white);
      setPreferredSize (new Dimension (100, 250));
		add (label1);
		add (label2);  				
		add (label3);
		
		}
}

/******************************************
You are not modeling a Card.  You have embedded
the logic involving a card in the "gui code".
*******************************************/