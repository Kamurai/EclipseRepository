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




public class CollectionDriverPanel extends JPanel
{


	//Establish Objects	
	private JTextArea Display = new JTextArea ("");

	public CollectionDriverPanel()
	{
	
	

	//Establish Collection
	CDCollection music = new CDCollection ();

      music.addCD ("Storm Front", "Billy Joel", 14.95, 10);
      music.addCD ("Come On Over", "Shania Twain", 14.95, 16);
      music.addCD ("Soundtrack", "Les Miserables", 17.95, 33);
      music.addCD ("Graceland", "Paul Simon", 13.90, 11);
      music.addCD ("Double Live", "Garth Brooks", 19.99, 26);
      music.addCD ("Greatest Hits", "Jimmy Buffet", 15.95, 13);

 
		
	//Add objects
	add (Display);
		
	//Set Text Area
	Display.setBackground (Color.white);


	//display output
	Display.setText( music.toString() );
		
	//Set Panel
	setBackground (Color.white);
   setPreferredSize (new Dimension (400, 270));
		
   }


}
