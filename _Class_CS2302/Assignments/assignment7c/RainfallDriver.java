//Kemerait, Christopher
//CSIS 2302
//Yearly Rainfall Class Assignment

package assignment7;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;



public class RainfallDriver
{
  public static void main (String[] args)
   {
		//Set Frame
      JFrame frame = new JFrame ("RainfallDriver");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add( new RainfallDriverPanel() );
		
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
	
}

/**************************************************
45/50  Please see my comments in your code.
**************************************************/