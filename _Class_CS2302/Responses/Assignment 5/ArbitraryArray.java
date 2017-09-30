//Kemerait, Christopher
//CSIS 2302
//Arbitrary Array Assignment



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.Scanner;



public class ArbitraryArray
{
  public static void main (String[] args)
   {
		//Set Frame
      JFrame frame = new JFrame ("ArbitraryArray");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add( new ArbitraryArrayPanel() );
		
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
	
}

/**********************************************************
96/100 Please see my comments in your code.
**********************************************************/