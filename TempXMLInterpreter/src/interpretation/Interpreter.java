package interpretation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import common.Interpret;
import information.FileObject;

public class Interpreter extends common.ErrorObject implements Interpret
{
	List<String> errorList = new ArrayList<String>();
	
	public Interpreter(){}

	public FileObject interpret(File file) {
		FileObject result = new FileObject();
		
		//interpreter reads data
			//determines appropriate data typing
				//to include enumerations
			//interpreter logs responses as String(s)
		//interpreter interprets data to Java Object

		// TODO Auto-generated method stub
		
		return result;
	}
	
	public List<String> getErrorList()
	{
		return errorList;		
	}
}
