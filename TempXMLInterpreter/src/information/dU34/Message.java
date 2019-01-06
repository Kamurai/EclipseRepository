package information.dU34;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.FileObject;
import information.dU34.Mes.Deal_Set;
import information.dU34.Mes.Document_Set;
import information.uLDD30.Mes.About_Version;

public class Message extends FileObject implements ArrayListOwner {
	//Attributes
	String mISMOReferenceModelIdentifier; //Enumeration
	String xmlns; //Enumeration
	String xmlnsxsi; //Enumeration
	String xmlnsULAD; //Enumeration
	String xmlnsDU; //Enumeration
	String xmlnsxlink; //Enumeration
	//Elements
	List<About_Version> about_Versions;
	List<Document_Set> document_Sets;
	List<Deal_Set> deal_Sets;
	
	public Message(){
		about_Versions = new ArrayList<About_Version>();
		document_Sets = new ArrayList<Document_Set>();
		deal_Sets = new ArrayList<Deal_Set>();
		}
	
	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	public String getXmlnsxsi() {
		return xmlnsxsi;
	}

	public void setXmlnsxsi(String xmlnsxsi) {
		this.xmlnsxsi = xmlnsxsi;
	}

	public String getXmlnsULAD() {
		return xmlnsULAD;
	}

	public void setXmlnsULAD(String xmlnsULAD) {
		this.xmlnsULAD = xmlnsULAD;
	}

	public String getXmlnsDU() {
		return xmlnsDU;
	}

	public void setXmlnsDU(String xmlnsDU) {
		this.xmlnsDU = xmlnsDU;
	}

	public String getXmlnsxlink() {
		return xmlnsxlink;
	}

	public void setXmlnsxlink(String xmlnsxlink) {
		this.xmlnsxlink = xmlnsxlink;
	}

	public String getMISMOReferenceModelIdentifier() {
		return mISMOReferenceModelIdentifier;
	}

	public void setMISMOReferenceModelIdentifier(String mISMOReferenceModelIdentifier) {
		this.mISMOReferenceModelIdentifier = mISMOReferenceModelIdentifier;
	}

	public List<Document_Set> getDocument_Sets() {
		return document_Sets;
	}

	public void setDocument_Sets(ArrayList<Document_Set> document_Sets) {
		this.document_Sets = document_Sets;
	}

	public List<Deal_Set> getDeal_Sets() {
		return deal_Sets;
	}

	public void setDeal_Sets(ArrayList<Deal_Set> deal_Sets) {
		this.deal_Sets = deal_Sets;
	}

	public void setAbout_Versions(ArrayList<About_Version> about_Versions) {
		this.about_Versions = about_Versions;
	}

	public List<About_Version> getAbout_Versions() {
		return about_Versions;
	}
	
	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("About_Version")){
			result = about_Versions.get(about_Versions.size()-1);
		}
		else if(objectType.equals("Deal_Set")){
			result = deal_Sets.get(deal_Sets.size()-1);
		}
		else if(objectType.equals("Document_Set")){
			result = document_Sets.get(document_Sets.size()-1);
		}
		
		return result;
	}
}
