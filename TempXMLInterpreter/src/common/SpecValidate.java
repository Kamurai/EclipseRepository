package common;

import java.util.ArrayList;
import java.util.List;

import information.FileObject;

public interface SpecValidate {

	public boolean validate(FileObject subject);	
	public List<String> getErrorList();

}
