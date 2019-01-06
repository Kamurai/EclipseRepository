package comparison;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import common.Compare;
import information.FileObject;

public class Comparator extends common.ErrorObject implements Compare{
	List<String> errorList = new ArrayList<String>();
	
	public Comparator(){}

	@Override
	public void compare(FileObject fileObject, File testFile) {
		
		//comparator reads Java Object
		//comparator compares Java Object with suggested Test Case
		//comparator logs responses as String(s)
		
		// TODO Auto-generated method stub
		
	}
	
	public List<String> getErrorList()
	{
		return errorList;		
	}
}
