package specification.uLDD30;

import java.util.ArrayList;
import java.util.List;

import common.SpecValidate;
import information.FileObject;

public class SpecValidator extends specification.SpecValidator implements SpecValidate  {
	List<String> errorList = new ArrayList<String>();
	
	public SpecValidator(){}

	public boolean validate(FileObject subject) {
		
		// TODO Auto-generated method stub
		
		return false;
	}
	
	public List<String> getErrorList()
	{
		return errorList;		
	}
}
