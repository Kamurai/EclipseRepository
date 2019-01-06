package information.uCD33.Mes.DocSet.Doc;

public class Relationship {
	String SequenceNumber; //Enumeration
	String xlinkfrom; //Enumeration
	String xlinkto; //Enumeration
	String xlinkarcrole; //Enumeration
	
	public Relationship(){}

	public String getSequenceNumber() {
		return SequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.SequenceNumber = sequenceNumber;
	}

	public String getXlinkfrom() {
		return xlinkfrom;
	}

	public void setXlinkfrom(String xlinkfrom) {
		this.xlinkfrom = xlinkfrom;
	}

	public String getXlinkto() {
		return xlinkto;
	}

	public void setXlinkto(String xlinkto) {
		this.xlinkto = xlinkto;
	}

	public String getXlinkarcrole() {
		return xlinkarcrole;
	}

	public void setXlinkarcrole(String xlinkarcrole) {
		this.xlinkarcrole = xlinkarcrole;
	}
}
