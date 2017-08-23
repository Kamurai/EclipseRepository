package usanIDE.Managers;

public class Cell 
{
	String CellType;
	String CellName;
	
	public Cell()
	{
		CellType = "Empty";
		CellName = "Empty";
	}
	
	public Cell(String input)
	{
		CellType = input;
	}

	
	public void setName(String input)
	{
		CellName = input;
	}
	
	public String getName()
	{
		return CellName;
	}
	
}
