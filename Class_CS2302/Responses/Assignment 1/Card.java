//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Card
{
  
  public static void main (String[] args)
   {
	
		//Set Frame
      JFrame frame = new JFrame ("Playing Cards");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add(new Cardpanel());
      
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
}

/********************************
35/50 You are not modeling a Card.
Instead, you have "gui code" that
contains the logic.
*********************************/