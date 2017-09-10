//Kemerait, Christopher
//CSIS 2302
//CD Collection (Arraylist) Assignment

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.lang.String;



public class CollectionDriver
{

   public static void main (String[] args)
   {
      //Set Frame
      JFrame frame = new JFrame ("CollectionDriver");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add( new CollectionDriverPanel() );
		
		//End frame
      frame.pack();
      frame.setVisible(true);

		
	}
}
