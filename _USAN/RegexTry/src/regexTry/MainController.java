package regexTry;

//import javax.faces.bean.SessionScoped;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;




/**
 * 
 * @author Chris Kemerait
 */
public class MainController {
	private FileManager Snuffit;
	private Processor Snorlax;
	private List<String> targetfiles;

	public MainController() 
	{
		Snorlax = new Processor();
		Snuffit = new FileManager("regex_storage.txt"); //C:\\etmprocessor_support\\etmp_reference.txt
		targetfiles = new ArrayList<String>();

		for (int x = 0; x < 2; x++) {
			targetfiles.add("");
		}
	}

	public void attemptRegex()
	{
		Snorlax.attemptRegex();
	}

	public void setSource(String input)
	{
		Snorlax.setSource(input);
	}

	public void setRegex(String input)
	{
		Snorlax.setRegex(input);
	}

	public String printSource() {
		return Snorlax.printSource();
	}
	
	public String printRegex() {
		return Snorlax.printRegex();
	}
	
	public String printResult() {
		return Snorlax.printResult();
	}
	public void SaveLineToFile(String input)
	{
		Snuffit.SaveLineToFile(input);
	}
	
	public String GetLineFromFile(int index)
	{
		return Snuffit.GetLineFromFile(index);
	}
	
	public void ClearFile()
	{
		Snuffit.ClearFile();
	}
}
