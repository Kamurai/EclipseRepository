//Kemerait, Christopher
//CSIS 2302
//Pig Latin Translator GUI Assignment

package assignment3;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.Scanner;



public class PigLatin
{
  public static void main (String[] args)
   {
		//Set Frame
      JFrame frame = new JFrame ("PigLatin");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add(new PigLatinPanel());
		
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
	
}

/****************************************************
48/50 Please see my comments in your code.
*****************************************************/