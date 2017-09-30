//Kemerait, Christopher
//CSIS 2302
//Phone Pad Button Assignment with Array List



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;



public class PhonePad
{

		public static void main (String[] args)
   {
		//Set Frame
      JFrame frame = new JFrame ("PhonePad");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Establish Panel
		JPanel BorderPanel = new PrimaryPanel();
		
		//Add Panel
		frame.getContentPane().add( BorderPanel );
				
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
	
}