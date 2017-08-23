package productconsumption;

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
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Highlighter;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import java.awt.GraphicsEnvironment;

import javax.swing.text.Highlighter;

public class MainWindow extends JFrame 
{
	//Panels
	JPanel panel;
	JPanel northPanel;
	JPanel northPanel1;
	JPanel northPanel2;
	JPanel northPanel3;
	
	JPanel midPanel;
	JPanel midPanel1;
	JPanel midPanel2;
	JPanel midPanel3;
	
	JPanel southPanel;
	JPanel southPanel1;
	JPanel southPanel2;
	JPanel southPanel3;
	JPanel southPanel4;
	
	//Static Labels
		//Program Status
		private JLabel ProgramStatusLabel;
		//Consumer 1 Status
		private JLabel Consumer1StatusLabel;
		//Consumer 2 Status
		private JLabel Consumer2StatusLabel;
		//Consumer 3 Status
		private JLabel Consumer3StatusLabel;
		
		private JLabel marInputLabel;
		private JLabel sdInputLabel;
		
	//Inputs
		//text box for moving average range
		private JTextField marInput;
		//text box for sleep duration
		private JTextField sdInput;
		
	//Buttons
		private JButton setMARButton; //Set Moving Average number
		private JButton setSDButton; //Set Sleep duration
	
		//run program
		private JButton runIt;
		
	//Outputs
		//program status
		private JLabel ProgramStatusOuput;
		//consumer 1 status
		private JLabel Consumer1StatusOuput;
		//consumer 2 status
		private JLabel Consumer2StatusOuput;
		//consumer 3 status
		private JLabel Consumer3StatusOuput;
	
		//Generated number log
		JTextPane generatedLogPane;
		JScrollPane generatedLogScroll;
		//Consumed number log
		JTextPane consumedLogPane;
		JScrollPane consumedLogScroll;
		//Moving average log
		JTextPane marLogPane;
		JScrollPane marLogScroll;
		//sleep / process log
		JTextPane processLogPane;
		JScrollPane processLogScroll;
		
	MainController controller;
	Producer Thomas = new Producer(generatedLogPane);
	Consumer Mary = new Consumer(Thomas,1,consumedLogPane);
	Consumer Susy = new Consumer(Thomas,2,marLogPane);
	Consumer Beth = new Consumer(Thomas,3,processLogPane);
	
	boolean falseStart = true;
	
	public MainWindow() 
	{
		controller = new MainController();
				
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1,3));
		
		northPanel1 = new JPanel();
		northPanel2 = new JPanel();
		northPanel3 = new JPanel();
		
		
		ProgramStatusLabel = new JLabel("Program Status: ");
		ProgramStatusOuput = new JLabel("Off");
		
		northPanel1.add(ProgramStatusLabel);
		northPanel1.add(ProgramStatusOuput);
		
		runIt = new JButton("On");
		northPanel1.add(runIt);
		
		
		marInputLabel = new JLabel("Moving Average Range");
		marInput = new JTextField("5");
		setMARButton = new JButton("Set");
		
		northPanel2.add(marInputLabel);
		northPanel2.add(marInput);
		northPanel2.add(setMARButton);
		
		
		sdInputLabel = new JLabel("Sleep Duration");
		sdInput = new JTextField("3");
		setSDButton = new JButton("Set");
		Susy.setSleepDuration(3);
		
		northPanel3.add(sdInputLabel);
		northPanel3.add(sdInput);
		northPanel3.add(setSDButton);
		
		northPanel.add(northPanel1);
		northPanel.add(northPanel2);
		northPanel.add(northPanel3);
		
		
		midPanel = new JPanel();
		midPanel.setLayout(new GridLayout(1,3));
		
		midPanel1 = new JPanel();
		midPanel2 = new JPanel();
		midPanel3 = new JPanel();
		
		midPanel.add(midPanel1);
		midPanel.add(midPanel2);
		midPanel.add(midPanel3);
		
		//Consumer 1 Status
		Consumer1StatusLabel = new JLabel("Consumer 1 status: ");
		Consumer1StatusOuput = new JLabel("Off");
		
		midPanel1.add(Consumer1StatusLabel);
		midPanel1.add(Consumer1StatusOuput);
		
		//Consumer 2 Status
		Consumer2StatusLabel = new JLabel("Consumer 2 status: ");
		Consumer2StatusOuput = new JLabel("Off");
		
		midPanel2.add(Consumer2StatusLabel);
		midPanel2.add(Consumer2StatusOuput);
		
		//Consumer 3 Status
		Consumer3StatusLabel = new JLabel("Consumer 3 status: ");
		Consumer3StatusOuput = new JLabel("Off");

		midPanel3.add(Consumer3StatusLabel);
		midPanel3.add(Consumer3StatusOuput);
		
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,4));
		
		southPanel1 = new JPanel();
		southPanel2 = new JPanel();
		southPanel3 = new JPanel();
		southPanel4 = new JPanel();

		
		//Generated number log
		JTextPane generatedLogPane = new JTextPane();
		generatedLogPane.setText("One");
		JScrollPane generatedLogScroll = new JScrollPane(generatedLogPane);
		southPanel1.add(generatedLogScroll);
		//Consumed number log
		JTextPane consumedLogPane = new JTextPane();
		consumedLogPane.setText("Two");
		JScrollPane consumedLogScroll= new JScrollPane(consumedLogPane);
		southPanel2.add(consumedLogScroll);
		//Moving average log
		JTextPane marLogPane = new JTextPane();
		marLogPane.setText("Three");
		JScrollPane marLogScroll= new JScrollPane(marLogPane);
		southPanel3.add(marLogScroll);
		//sleep / process log
		JTextPane processLogPane = new JTextPane();
		processLogPane.setText("Four");
		JScrollPane processLogScroll= new JScrollPane(processLogPane);
		southPanel4.add(processLogScroll);
		
		southPanel.add(southPanel1);
		southPanel.add(southPanel2);
		southPanel.add(southPanel3);
		southPanel.add(southPanel4);
		
		
		panel.add(northPanel);
		panel.add(midPanel);		
		panel.add(southPanel);
		
		int frameWidth = 1900;
		int frameHeight = 1000;
		
		
		
		
		/*	
		int westPanelWidth = 100;
		int centerPanelWidth = 1600;
		int eastPanelWidth = 100;
		
		int westPanelHeight = 1000;
		int centerPanelHeight = 1000;
		int eastPanelHeight = 1000;
		
		int northScrollHeight = 825;
		int midPanelHeight = 40;
		int southScrollHeight = 100;
						
		
		mainBox.setMinimumSize(new Dimension(centerPanelWidth, 10));
		mainBox.setPreferredSize(new Dimension(centerPanelWidth, northScrollHeight));
		mainBox.setMaximumSize(new Dimension(centerPanelWidth, northScrollHeight));
		
		mainScroll.setMinimumSize(new Dimension(centerPanelWidth, 10));
		mainScroll.setPreferredSize(new Dimension(centerPanelWidth, northScrollHeight));
		mainScroll.setMaximumSize(new Dimension(centerPanelWidth, northScrollHeight));
		
		midPanel.setMinimumSize(new Dimension(centerPanelWidth, midPanelHeight));
		midPanel.setPreferredSize(new Dimension(centerPanelWidth, midPanelHeight));
		midPanel.setMaximumSize(new Dimension(centerPanelWidth, midPanelHeight));
		
		southScroll.setMinimumSize(new Dimension(centerPanelWidth, 10));
		southScroll.setPreferredSize(new Dimension(centerPanelWidth, southScrollHeight));
		southScroll.setMaximumSize(new Dimension(centerPanelWidth, southScrollHeight));
		
		centerPanel.setMinimumSize(new Dimension(centerPanelWidth, centerPanelHeight));
		centerPanel.setPreferredSize(new Dimension(centerPanelWidth, centerPanelHeight));
		centerPanel.setMaximumSize(new Dimension(centerPanelWidth, centerPanelHeight));
			
		
		westPanel.setMinimumSize(new Dimension(westPanelWidth, westPanelHeight));
		westPanel.setPreferredSize(new Dimension(westPanelWidth, westPanelHeight));
		westPanel.setMaximumSize(new Dimension(westPanelWidth, westPanelHeight));
		
		eastPanel.setMinimumSize(new Dimension(eastPanelWidth, eastPanelHeight));
		eastPanel.setPreferredSize(new Dimension(eastPanelWidth, eastPanelHeight));
		eastPanel.setMaximumSize(new Dimension(eastPanelWidth, eastPanelHeight));
		
		panel.add(westPanel);
		panel.add(centerPanel);
		panel.add(eastPanel);
		*/
		
		add(panel);
		
		setSize(frameWidth, frameHeight);
		setVisible(true);
		
		runIt.addActionListener(new GammaListener());
		setMARButton.addActionListener(new AlphaListener());
		setSDButton.addActionListener(new BetaListener());
	}


	private class AlphaListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == setMARButton) 
		    {
		    	Mary.setSleepDuration(Integer.parseInt(marInput.getText()));
		    }
		}

	}
	
	
	private class BetaListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == setSDButton) 
		    {
		    	Susy.setSleepDuration(Integer.parseInt(sdInput.getText()));
		    }
		}

	}
	
	private class GammaListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == runIt) 
		    {
				if(falseStart)
				{
					Thomas.stopIt();
		    		Mary.stopIt();
		    		Susy.stopIt();
		    		Beth.stopIt();
		    		
					
					
					falseStart = false;
				}
				
				
		    	if(Thomas.getRun())
		    	{
		    		Thomas.stopIt();
		    		ProgramStatusOuput.setText("Off");
		    		Mary.stopIt();
		    		Consumer1StatusOuput.setText("Off");
		    		Susy.stopIt();
		    		Consumer2StatusOuput.setText("Off");
		    		Beth.stopIt();
		    		Consumer3StatusOuput.setText("Off");
		    		
		    		runIt.setText("On");
		    	}
		    	else
		    	{
		    		Thomas.startIt();
		    		ProgramStatusOuput.setText("On");
		    		Mary.startIt();
		    		Consumer1StatusOuput.setText("On");
		    		Susy.startIt();
		    		Consumer2StatusOuput.setText("On");
		    		Beth.startIt();
		    		Consumer3StatusOuput.setText("On");
		    		
		    		runIt.setText("Off");
		    	}
				
				
		    }
		}

	}
			
}