//Kemerait, Christopher
//CSIS 2302
//Exception, Try and Catch Assignment

package assignment11;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.Scanner;



public class ExceptionDriver
{
  public static void main (String[] args) 
   {
		//Set Frame
      JFrame frame = new JFrame ("ExceptionDriver");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add( new ExceptionPanel() );
		
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
	
}

/************************************************
good style would be to have each class in a 
separate file

45/50 Please see my comments in your code.
*************************************************/
