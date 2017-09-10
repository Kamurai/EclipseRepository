//Kemerait, Christopher
//CSIS 2302
//Phone Pad Button Assignment with Array List

package assignment7;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
//import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;


public class PrimaryPanel extends JPanel
{
	//Establish Subsquent Panel
	
		//JPanel PhonePadPanel = new JPanel();
		JPanel NorthPanel = new JPanel();
		JPanel SouthPanel = new JPanel();
		JPanel EastPanel = new JPanel();
		JPanel WestPanel = new JPanel();
		JPanel PhonePadPanel = new CenterPanel();

		//Establish Test Labels

		JLabel LabelList[] =
		{
			new JLabel(""),
			new JLabel(""),
			new JLabel("          "),
			new JLabel("          "),
			new JLabel("Center Space")		
		};

	public PrimaryPanel()
	{
		//Set Panel
		setBackground (Color.white);
      setPreferredSize (new Dimension (300, 300));
		//Set Layout
		setLayout ( new BorderLayout() );
		
		//Add Objects

		//Add Subsequent Panel
		add (PhonePadPanel, BorderLayout.CENTER);

		add (NorthPanel, BorderLayout.NORTH);
		NorthPanel.setBackground (Color.white);


		add (SouthPanel, BorderLayout.SOUTH);
		SouthPanel.setBackground (Color.white);


		add (EastPanel, BorderLayout.EAST);
		EastPanel.setBackground (Color.white);


		add (WestPanel, BorderLayout.WEST);
		WestPanel.setBackground (Color.white);
		
		//Add Test Labels
		NorthPanel.add (LabelList[0]);
		SouthPanel.add (LabelList[1]);		
		EastPanel.add (LabelList[2]);
		WestPanel.add (LabelList[3]);
		
							
   }
	
}
