package common;

import java.util.ArrayList;
import java.util.List;

public abstract class ErrorObject {
	List<String> errorList = new ArrayList<String>();
	
	public ErrorObject(){}
	
	public List<String> getErrorList()
	{
		return errorList;
	}
}
