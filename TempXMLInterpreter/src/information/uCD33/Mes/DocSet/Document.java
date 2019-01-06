package information.uCD33.Mes.DocSet;

import java.util.ArrayList;
import java.util.List;

import information.uCD33.Mes.DocSet.Doc.About_Version;
import information.uCD33.Mes.DocSet.Doc.Audit_Trail;
import information.uCD33.Mes.DocSet.Doc.Deal_Set;
import information.uCD33.Mes.DocSet.Doc.Document_Classification;
import information.uCD33.Mes.DocSet.Doc.Relationship;
import information.uCD33.Mes.DocSet.Doc.Signatory;
import information.uCD33.Mes.DocSet.Doc.System_Signature;
import information.uCD33.Mes.DocSet.Doc.View;

public class Document {
	String mISMOReferenceModelIdentifier;
	List<About_Version> about_Versions;
	List<Audit_Trail> audit_Trail_Entries;
	List<Deal_Set> deal_Sets;
	Document_Classification document_Classification;
	List<Signatory> signatories;
	List<Relationship> relationships;
	List<System_Signature> system_Signatures;
	List<View> views;
	
	
		
	public Document(){}
}
