package cardGameGenerator;
//Kemerait, Christopher
//Card Game Engine
//Card Game Frame


import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;



public class CardGameFrame
{

		public static void main (String[] args)
   {
		//Set Frame
      JFrame frame = new JFrame ("CardGameFrame");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Establish Main Panel
		JPanel Environment = new EnvironmentPanel();
		
		//Add Panel
		frame.getContentPane().add( Environment );
				
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
	
}