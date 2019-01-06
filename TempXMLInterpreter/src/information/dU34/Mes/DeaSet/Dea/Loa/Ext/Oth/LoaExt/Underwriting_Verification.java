package information.dU34.Mes.DeaSet.Dea.Loa.Ext.Oth.LoaExt;

public class Underwriting_Verification {
	//Attributes
	String sequenceNumber;
	String xlinklabel;
	//Elements
	String verificationReportIdentifier;
	String verificationReportSupplierType; //Enumeration
	String verificationReportType; //Enumeration
	
	public Underwriting_Verification(){}

	public String getVerificationReportIdentifier() {
		return verificationReportIdentifier;
	}

	public void setVerificationReportIdentifier(String verificationReportIdentifier) {
		this.verificationReportIdentifier = verificationReportIdentifier;
	}

	public String getVerificationReportSupplierType() {
		return verificationReportSupplierType;
	}

	public void setVerificationReportSupplierType(String verificationReportSupplierType) {
		this.verificationReportSupplierType = verificationReportSupplierType;
	}

	public String getVerificationReportType() {
		return verificationReportType;
	}

	public void setVerificationReportType(String verificationReportType) {
		this.verificationReportType = verificationReportType;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getXlinklabel() {
		return xlinklabel;
	}

	public void setXlinklabel(String xlinklabel) {
		this.xlinklabel = xlinklabel;
	}
}
