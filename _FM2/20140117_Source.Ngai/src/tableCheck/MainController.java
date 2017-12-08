package tableCheck;

//import javax.faces.bean.SessionScoped;
//import java.sql.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Chris Kemerait
 */
public class MainController 
{
	private FileManager Snuffit;
	private Processor Snorlax;
	private List<String> targetfiles;

	public MainController() 
	{
		Snuffit = new FileManager("etmp_reference.txt"); //C:\\etmprocessor_support\\etmp_reference.txt
		Snorlax = new Processor();
		targetfiles = new ArrayList<String>();

		for (int x = 0; x < 2; x++) 
		{
			targetfiles.add("");
		}
	}

	public String ProcessTable(String alpha, String beta) 
	{
		String output = "";
				
		// validate files
		if (!validateFile(alpha)) 
		{
			output = "There is a problem with the .etm file pathway.\n"+alpha+" doesn't exist";
			return output;
		}
		else if (!validateFile(beta)) 
		{
			output = "There is a problem with the .csv file pathway.\n"+beta+"doesn't exist";
			return output;
		}

		return Snorlax.ProcessTable(alpha, beta);
	}
	
	private boolean validateFile(String input) 
	{
		boolean result = false;
		File etmfile = new File(input);

		if (etmfile.exists()) {
			result = true;
		}
		return result;
	}

	public String getLocalupdates(int x) {
		return targetfiles.get(x);
	}

	public List<String> getLocalupdates() {
		return targetfiles;
	}

	public void setLocalupdates(List<String> localupdates) {
		this.targetfiles = localupdates;
	}

	public String getOutput() {
		return Snorlax.getOutput();
	}
	
	public String printETM() {
		return Snorlax.printETM();
	}
	
	public String printCSV() {
		return Snorlax.printCSV();
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
	
	public String printETMRows() {
		return Snorlax.printETMRows();
	}
	
	public String printCSVRows() {
		return Snorlax.printCSVRows();
	}
	
	public String printETMCols() {
		return Snorlax.printETMCols();
	}
	
	public String printCSVCols() {
		return Snorlax.printCSVCols();
	}
	
	public ArrayList<ArrayList<String>> getETM()
	{
		return Snorlax.getETM();
	}
	
	public ArrayList<ArrayList<String>> getCSV()
	{
		return Snorlax.getCSV();
	}
	
	public void setMatchETMRowsToCSVColumns(boolean input)
	{
		Snorlax.setMatchETMRowsToCSVColumns(input);		
	}
	
	public boolean getMatchETMRowsToCSVColumns()
	{
		return Snorlax.getMatchETMRowsToCSVColumns();
	}
	
	public String[] getETMHeader(){
		return this.Snorlax.getETMHeader();
	}
	
	public ArrayList<ArrayList<String>> getRawETMData(){
		return this.Snorlax.getRawETMData();
	}
	
	public ArrayList<ArrayList<String>> getRawCSVData(){
		return this.Snorlax.getRawCSVData();
	}
	
	public String[] getCSVHeader(){
		return this.Snorlax.getCSVHeader();
	}
	
	public ArrayList<ArrayList<String>> getCSVComments()
	{
		return Snorlax.getCSVComments();
	}
}
