package comparison.dU231;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import information.FileObject;

public class Comparator extends comparison.Comparator {
	List<String> errorList = new ArrayList<String>();
	
	public Comparator(){}

	@Override
	public void compare(FileObject fileObject, File testFile) {
		
		
		// TODO Auto-generated method stub

	}
	
	public List<String> getErrorList()
	{
		return errorList;		
	}
}
