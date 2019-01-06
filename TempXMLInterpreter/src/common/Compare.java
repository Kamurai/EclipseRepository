package common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import information.FileObject;

public interface Compare {

	public void compare(FileObject subject, File testFile);	
	public List<String> getErrorList();


}
