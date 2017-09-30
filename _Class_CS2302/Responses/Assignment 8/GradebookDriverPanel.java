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




public class GradebookDriverPanel extends JPanel
{


	//Establish Objects	
	private JTextArea Display = new JTextArea ("");
	private String result = "";

	public GradebookDriverPanel()
	{
	
	

	//Establish Collection
	Gradebook records = new Gradebook ("Kemerait", "ckemerai");
	
	result = "Item \t\t Result\n\n";
	result += "Name of student\t" + records.getName() + "\n" + "ID\t\t" + records.getId() + "\n";
	
	


      records.addAssignmentScore (100);
      records.addAssignmentScore (0);
      records.addAssignmentScore (57);
      records.addAssignmentScore (94);
      records.addAssignmentScore (86);
      
		records.addAssignmentScore (74);
      records.addAssignmentScore (92);
      records.addAssignmentScore (89);
      records.addAssignmentScore (79);
      records.addAssignmentScore (88);
      
		records.addTestScore (100);
		records.addTestScore (100);
		records.addTestScore (50);
		records.addTestScore (60);
		records.addTestScore (70);
		
		records.addTestScore (75);
      records.addTestScore (82);
      records.addTestScore (95);
      records.addTestScore (88);
      records.addTestScore (91);
      
  
	result += "Average Test Score\t" + records.getTestAverage() + "\n" + "Average Assignment Score\t" + records.getAssignmentAverage() +"\n";
 
	result += "Number of Test Scores\t" + records.getNumTests() + "\n" + "Number of Assignment Scores\t" + records.getNumAssignments() +"\n";
	
			
	//Add objects
	add (Display);
		
	//Set Text Area
	Display.setBackground (Color.white);


	//display output
	Display.setText( result );
		
	//Set Panel
	setBackground (Color.white);
   setPreferredSize (new Dimension (400, 270));
		
   }


}
