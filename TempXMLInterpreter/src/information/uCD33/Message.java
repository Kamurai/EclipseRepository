package information.uCD33;

import java.util.ArrayList;
import java.util.List;

import information.FileObject;
import information.uCD33.Mes.About_Version;
import information.uCD33.Mes.Document_Set;

public class Message extends FileObject {
	String mISMOReferenceModelIdentifier;
	String xMLNSGSE = "http://www.datamodelextension.org";
	List<About_Version> about_Versions;
	List<Document_Set> document_Sets;
	
	public Message(){}
}
