package validation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import common.Validate;

public class Validator extends common.ErrorObject implements Validate {
	List<String> errorList = new ArrayList<String>();
	
	public Validator(){}

	public boolean validate(File subject, String xsdPath) {
		boolean result = false;
		
		//validator reads file
		//validator logs response as String(s)
		
		// TODO Auto-generated method stub
		
		return result;
	}
	
	public List<String> getErrorList()
	{
		return errorList;		
	}

}
