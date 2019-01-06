package information.uLDD30;

import java.util.ArrayList;
import java.util.List;

import information.FileObject;
import information.uLDD30.Mes.About_Version;
import information.uLDD30.Mes.Deal_Sets;

public class Message extends FileObject
{
	String mISMOReferenceModelIdentifier;
	List<About_Version> about_Versions;
	Deal_Sets deal_Sets;
	
	public Message()
	{
		
	}
}
