//Kemerait, Christopher
//CSIS 2302
//Rational Number / Comaparable interface Assignment



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;



public class RationalNumberDriver 
{
  public static void main (String[] args)
   {
		//Set Frame
      JFrame frame = new JFrame ("RationalNumberDriver");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add( new RationalNumberPanel() );
		
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
	
}