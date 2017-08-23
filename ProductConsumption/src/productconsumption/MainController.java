package productconsumption;

//import javax.faces.bean.SessionScoped;
import java.awt.Color;
import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;


/**
 * 
 * @author Chris Kemerait
 */
public class MainController 
{
	private FileManager Snuffit;
	private String filename;
	
	
	public MainController() 
	{
		filename = "ProductConsumptionRequirements.cfg";
		Snuffit = new FileManager(filename);
	}
	
	public String separateFilename(String input)
	{
		return Snuffit.separateFilename(input);
	}

	public void SaveLineToFile(String input)
	{
		Snuffit.SaveLineToReference(input);
	}
	
	public void SaveToFile(String input)
	{
		Snuffit.SaveToFile(input);
	}
	
	public String GetLineFromFile(int index)
	{
		return Snuffit.GetLineFromFile(index);
	}
	
	public void ClearReferenceFile()
	{
		Snuffit.ClearReferenceFile();
	}
	
	public String LoadFile(String input)
	{
		return Snuffit.PullFile2(input);
	}
	
}
