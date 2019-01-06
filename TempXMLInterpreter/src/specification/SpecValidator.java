package specification;

import java.util.ArrayList;
import java.util.List;

import common.SpecValidate;
import information.FileObject;

public class SpecValidator extends common.ErrorObject implements SpecValidate {
	List<String> errorList = new ArrayList<String>();
	
	public SpecValidator(){}

	public boolean validate(FileObject subject) {
		
		//specValidator logs responses as String(s)
		
		// TODO Auto-generated method stub
		
		return false;
	}
	
	public List<String> getErrorList()
	{
		return errorList;		
	}	
}
