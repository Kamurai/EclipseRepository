//Kemerait, Christopher
//CSIS 2305
//Slot Machine Assignment



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;



public class Slots
{
  public static void main (String[] args)
   {
		//Set Frame
      JFrame frame = new JFrame ("Slot Machine");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add(new Slotspanel());
		
		//End frame
      
      frame.pack();
      frame.setVisible(true);
   }
	
private class ButtonListener implements ActionListener
  {
  public void actionPerformed (ActionEvent event)
  {
 	//	pull.setText("Booger!"); 
  		Random generator = new Random();
			
  		int x = generator.nextInt(9);
		int y = generator.nextInt(9);
		int z = generator.nextInt(9);
		
		//Output Slots
		System.out.print (x);
		System.out.print ("  ");
		System.out.print (y);
		System.out.print ("  ");
		System.out.println (z);
		System.out.println ("  ");
  	}
	
	}
}
