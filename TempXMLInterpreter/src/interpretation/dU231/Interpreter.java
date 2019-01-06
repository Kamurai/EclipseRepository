package interpretation.dU231;

import java.io.File;
import java.util.ArrayList;

import information.FileObject;

public class Interpreter extends interpretation.Interpreter{
	
	public Interpreter(){}

	@Override
	public FileObject interpret(File subject) {
		FileObject result = new information.dU231.LoanApplication();
		
		// TODO Auto-generated method stub
		
		return result;
	}
}
