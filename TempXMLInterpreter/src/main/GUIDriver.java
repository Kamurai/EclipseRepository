package main;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import comparison.Comparator;
import debug.DebugSettings;
import gui.ApplicationPanel;
import gui.DisplaySettings;
import information.FileObject;
import interpretation.Interpreter;
import output.PrintUtility;
import output.Printer;
import selection.Selector;
import selection.Selector.*;
import specification.SpecValidator;
import validation.SchemaValidator;
import validation.Validator;
import validation.DTDValidator;

public class GUIDriver {

	public static void main (String[] args)
	{
		//Set Frame
		JFrame applicationFrame = new JFrame ("applicationFrame");
		applicationFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		applicationFrame.setPreferredSize(new Dimension(DisplaySettings.getApplicationFrameWidth(), DisplaySettings.getApplicationFrameHeight()));
		applicationFrame.setVisible(true);
		applicationFrame.setTitle("Test Case Validator (Version 0.03)");
		 
		//Establish Panel
		JPanel applicationPanel = new ApplicationPanel();
		
		applicationPanel.setPreferredSize(new Dimension(DisplaySettings.getApplicationPanelWidth(),DisplaySettings.getApplicationPanelHeight()));
		applicationPanel.setVisible(true);
		if(DebugSettings.getBorderMode()){
			applicationPanel.setBorder(BorderFactory.createLineBorder(new Color(255,0,0))); 
		}
		
		//Add Panel
		applicationFrame.add(applicationPanel);
					
		//End frame
		applicationFrame.pack();
	    applicationFrame.setVisible(true);
	}
}
