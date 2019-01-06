package information.dU34.Mes.DeaSet.Dea.Loa;

import java.math.BigDecimal;

public class Terms_Of_Loan {
	BigDecimal baseLoanAmount;
	BigDecimal disclosedIndexRatePercent;
	String lienPriorityType; //Enumeration
	String loanPurposeType; //Enumeration
	String mortgageType; //Enumeration
	BigDecimal noteAmount;
	BigDecimal noteRatePercent;
	
	public Terms_Of_Loan(){}

	public BigDecimal getBaseLoanAmount() {
		return baseLoanAmount;
	}

	public void setBaseLoanAmount(String baseLoanAmount) {
		this.baseLoanAmount = new BigDecimal(baseLoanAmount);
	}

	public BigDecimal getDisclosedIndexRatePercent() {
		return disclosedIndexRatePercent;
	}

	public void setDisclosedIndexRatePercent(String disclosedIndexRatePercent) {
		this.disclosedIndexRatePercent = new BigDecimal(disclosedIndexRatePercent);
	}

	public String getLienPriorityType() {
		return lienPriorityType;
	}

	public void setLienPriorityType(String lienPriorityType) {
		this.lienPriorityType = lienPriorityType;
	}

	public String getLoanPurposeType() {
		return loanPurposeType;
	}

	public void setLoanPurposeType(String loanPurposeType) {
		this.loanPurposeType = loanPurposeType;
	}

	public String getMortgageType() {
		return mortgageType;
	}

	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}

	public BigDecimal getNoteAmount() {
		return noteAmount;
	}

	public void setNoteAmount(String noteAmount) {
		this.noteAmount = new BigDecimal(noteAmount);
	}

	public BigDecimal getNoteRatePercent() {
		return noteRatePercent;
	}

	public void setNoteRatePercent(String noteRatePercent) {
		this.noteRatePercent = new BigDecimal(noteRatePercent);
	}
}
