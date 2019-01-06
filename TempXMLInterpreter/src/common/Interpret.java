package common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import information.FileObject;

public interface Interpret {

	public FileObject interpret(File subject);
	public List<String> getErrorList();
}
