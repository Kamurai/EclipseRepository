package common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface Validate {

	public boolean validate(File subject, String xsdPath);	
	public List<String> getErrorList();
}
