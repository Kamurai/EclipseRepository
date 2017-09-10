//Kemerait, Christopher
//CSIS 2302
//Search Assignment

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.Scanner;



public class SearchDriver
{
  public static void main (String[] args) 
   {
		//Set Frame
      JFrame frame = new JFrame ("SearchDriver");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add( new SearchPanel() );
		
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
	
}