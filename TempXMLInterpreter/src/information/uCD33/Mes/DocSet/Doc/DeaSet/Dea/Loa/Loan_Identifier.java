package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa;

public class Loan_Identifier {
	String loanIdentifier;
	String loanIdentifierType; //Enumeration
	
	public Loan_Identifier(){}

	public String getLoanIdentifier() {
		return loanIdentifier;
	}

	public void setLoanIdentifier(String loanIdentifier) {
		this.loanIdentifier = loanIdentifier;
	}

	public String getLoanIdentifierType() {
		return loanIdentifierType;
	}

	public void setLoanIdentifierType(String loanIdentifierType) {
		this.loanIdentifierType = loanIdentifierType;
	}
}
