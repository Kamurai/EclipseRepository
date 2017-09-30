//Kemerait, Christopher
//CSIS 2302
//Gradebook Assignment


import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
import java.lang.Object;



public class GradebookDriver
{

   public static void main (String[] args)
   {
      //Set Frame
      JFrame frame = new JFrame ("GradebookDriver");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add( new GradebookDriverPanel() );
		
		//End frame
      frame.pack();
      frame.setVisible(true);

		
	}
}
