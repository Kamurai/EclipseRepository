//Kemerait, Christopher
//CSIS 2302
//Increment / Decrement Button Assignment

package assignment2;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;



public class Increment
{
  public static void main (String[] args)
   {
		//Set Frame
      JFrame frame = new JFrame ("Increment");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add(new Incrementpanel());
		
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
	
}

/*******************************************
48/50 Please see my comments in your code.
********************************************/