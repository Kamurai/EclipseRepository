//Kemerait, Christopher
//Database Project: Bloodbowl Option
//Database Driver

package bblm;

import javax.swing.JFrame;
import java.sql.*;
import java.io.*;


public class DatabaseDriver
{
  public static void main (String[] args)throws SQLException, IOException {
  		//Set Frame
      JFrame frame = new JFrame ("DatabaseDriver");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		//Add Panel
		frame.getContentPane().add( new DatabasePanel() );
		
		//End frame
      frame.pack();
      frame.setVisible(true);
   }
	
}


