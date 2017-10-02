//Kemerait, Christopher
//CSIS 2305
//Slot Machine Assignment

package assignment1;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;



public class Slotspanel extends JPanel
{
	//Establish variables
		
	JButton pull;
	
	Random generator = new Random();
				
	int x = generator.nextInt(9);
	int y = generator.nextInt(9);
	int z = generator.nextInt(9);  		   	
		
			
	public Slotspanel()
	{
		pull = new JButton ("Try your luck!");
		
		//Set ActionListener
		pull.addActionListener (new ButtonListener());
		

		//Generate Slots
		x = generator.nextInt(9);
		y = generator.nextInt(9);
		z = generator.nextInt(9);
		
		//Output Slots
		System.out.print (x);
		System.out.print ("  ");
		System.out.print (y);
		System.out.print ("  ");
		System.out.println (z);
		System.out.println ("  ");
		
		//Output Results
		if(x == y || y == z || z == x)
			System.out.println ("You've scored two out of three!");
		
		if(x == y && y == z && z == x)
			System.out.println ("You've scored three out of three!  Jackpot!");
		
		if(x!=y && x!=z && y!=z)
			System.out.println ("You've scored zero out of three, try again!");
				
		
		//label output option
		/*					
		JLabel label1 = new JLabel (x);
		JLabel label2 = new JLabel (y);
		JLabel label3 = new JLabel (z);		
		*/
     
		//Add button
		add (pull);
		
		//add Labels
		/*
		panel.add (label1);
		panel.add (label2);  				
		panel.add (label3);
		*/

		//Set Panel
		setBackground (Color.white);
      setPreferredSize (new Dimension (150, 50));
		
   }
	
private class ButtonListener implements ActionListener
  {
  public void actionPerformed (ActionEvent event)
  {
 	//	pull.setText("Booger!"); 
  		Random generator = new Random();
			
  		int x = generator.nextInt(9);
		int y = generator.nextInt(9);
		int z = generator.nextInt(9);
		
		//Output Slots
		System.out.print (x);
		System.out.print ("  ");
		System.out.print (y);
		System.out.print ("  ");
		System.out.println (z);
		System.out.println ("  ");
		
		//Output Results
		if(x == y || y == z || z == x)
			System.out.println ("You've scored two out of three!");
		
		if(x == y && y == z && z == x)
			System.out.println ("You've scored three out of three!  Jackpot!");
		
		if(x!=y && x!=z && y!=z)
			System.out.println ("You've scored zero out of three, try again!");
				
  	}
	
	}
}
