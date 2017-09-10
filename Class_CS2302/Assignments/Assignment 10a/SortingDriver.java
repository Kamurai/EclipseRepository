//Kemerait, Christopher
//CSIS 2302
//Assignment 10
//Descending order Sorting


import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
import java.lang.Object;



public class SortingDriver
{

   public static void main (String[] args)
   {
      //Set Frame
      JFrame frame = new JFrame ("SortingDriver");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add( new SortingDriverPanel() );
		
		//End frame
      frame.pack();
      frame.setVisible(true);

		
	}
}
