//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class CardDriver
{
  
  public static void main (String[] args)
   {
	
		//Set Frame
      JFrame frame = new JFrame ("CardDriver");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add(new Cardpanel());
      
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
}
