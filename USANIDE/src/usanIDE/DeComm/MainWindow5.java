package usanIDE.DeComm;

/**
 *
 * @author Chris Kemerait
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.AttributedString;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.Highlighter;

import usanIDE.DeComm.HighLighter;
import usanIDE.MainController;
import usanIDE.Underliner;




public class MainWindow5 extends JFrame 
{
	private JButton goButton;
	private JButton wButton;
	private JButton eButton;
	
	JTextArea mainBox;
	JTextArea outLabel;

	JFileChooser fChooser = new JFileChooser();

	MainController controller;
	
	public Highlighter highlighter = new Hmarker(null);
	public Underliner painter = new Underliner(Color.red);
	AttributedString Squirtle;
	
	/**
	 * 
	 */
	public MainWindow5() 
	{
		controller = new MainController();
				
		JPanel panel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel westPanel = new JPanel();
		JPanel eastPanel = new JPanel();
						
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		mainBox = new JTextArea("This is where the input goes.", 50, 30);
		
		mainBox.setHighlighter(highlighter);
		
		mainBox.setEditable(true);
		mainBox.setWrapStyleWord(true);
		
		//mainBox.setSize(100,800);
		
		JScrollPane northScroll = new JScrollPane(mainBox);
				
		//northScroll.revalidate();
		
		centerPanel.add(northScroll);
		
		goButton = new JButton("Check text.");
		goButton.addActionListener(new ButtonListener());
		
		JPanel midPanel = new JPanel();
		midPanel.add(goButton);
		
		wButton = new JButton("Load File.");
		eButton = new JButton("East Panel.");
				
		wButton.addActionListener(new TauListener());
		//int returnVal = fChooser.showOpenDialog(zerPanel);
		
		westPanel.add(wButton);
				
		//eastPanel.add(eButton);

		outLabel = new JTextArea("This is where the output goes.", 5, 30);
		outLabel.setEditable(false);
		mainBox.setWrapStyleWord(true);
		
		JScrollPane southScroll = new JScrollPane(outLabel);
				
		//midPanel.setSize(1000, 100);
		centerPanel.add(midPanel);
		
		//southScroll.setSize(1000, 100);
		centerPanel.add(southScroll);
		
		//centerPanel.setSize(1600, 2000);
				
		panel.add(westPanel);
		
		westPanel.setMinimumSize(new Dimension(100, 100));
		westPanel.setPreferredSize(new Dimension(100, 100));
		westPanel.setMaximumSize(new Dimension(100, 1000));
		/*westPanel.setAlignmentY(TOP_ALIGNMENT);
		*/
		panel.add(centerPanel);
		centerPanel.setMinimumSize(new Dimension(1600, 1000));
		centerPanel.setPreferredSize(new Dimension(1600, 1000));
		centerPanel.setMaximumSize(new Dimension(1600, 1000));
		
		panel.add(eastPanel);
		eastPanel.setMinimumSize(new Dimension(100, 50));
		eastPanel.setPreferredSize(new Dimension(100, 50));
		eastPanel.setMaximumSize(new Dimension(100, 50));
				
		add(panel);
		setSize(1900, 1000);
		setVisible(true);		
	}

	
	
	private class TauListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			String alpha = "";
			
			//Handle open button action.
		    if (e.getSource() == wButton) 
		    {
		    	File Bulbasaur = new File(controller.GetLineFromFile(0));
				
				fChooser.setSelectedFile(Bulbasaur);
				
				
		        int returnVal = fChooser.showOpenDialog(fChooser);

		        if (returnVal == JFileChooser.APPROVE_OPTION) 
		        {
		        	alpha = fChooser.getSelectedFile().getPath();
		        	
		        	//Save file path to reference file
		        	controller.ClearReferenceFile();
					controller.SaveLineToFile(alpha);
					
		        	
		        	//This is where a real application would open the file.
					//Load file into mainBox
					mainBox.setText(controller.LoadFile(alpha));
					
					//set mainBox to use uniform character spacing
					mainBox.setColumns(100);
					
					Font font = new Font("Monaco", Font.PLAIN ,12);
					mainBox.setFont(font);
					mainBox.revalidate();
					mainBox.grabFocus();
		            //position cursor at the beginning the mainBox JTextArea
		            mainBox.setCaretPosition(0);
		            
		            Squirtle = new AttributedString(mainBox.getText());
		    				            
		            //controller.Colorize(Squirtle);
		            
		            //mainBox.setText(Squirtle);
		        } 
		   }
		}

	}

	private class ButtonListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			mainBox.setText("<html> <font color=green>Green Poo</font>");
			
			//mainBox.getText().substring(11, 20) + "<font color=green>" + mainBox.getText().substring(21, mainBox.getText().length()));
			
			
			
			
			try
			{
				highlighter.addHighlight(mainBox.getCaretPosition(), (mainBox.getCaretPosition()+10), painter);
			}
			catch(Exception bad)
			{
				mainBox.setText("What a fail!");
			}
		}

	}
	
	
	
	
	
	
	
}