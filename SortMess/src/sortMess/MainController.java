package sortMess;

//import javax.faces.bean.SessionScoped;
import java.sql.*;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Chris Kemerait
 */
public class MainController {
	private Processor Snorlax;
	private List<String> targetfiles;

	public MainController() {
		Snorlax = new Processor();
	}

	public boolean SortIt(int[][] mess) 
	{
		Snorlax.SortIt(mess);
		return true;
	}

	public String getOutput() {
		return Snorlax.getOutput();
	}

}
