package information.dU34.Mes.DeaSet.Dea.Loa.Amo;

public class Amortization_Rule extends information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Amo.Amortization_Rule {
	String amortizationType;
	String amortizationTypeOtherDescription;
	Integer loanAmortizationPeriodCount;
	String loanAmortizationPeriodType; //Enumeration

	public Amortization_Rule(){}

	public String getAmortizationType() {
		return amortizationType;
	}

	public void setAmortizationType(String amortizationType) {
		this.amortizationType = amortizationType;
	}

	public String getAmortizationTypeOtherDescription() {
		return amortizationTypeOtherDescription;
	}

	public void setAmortizationTypeOtherDescription(String amortizationTypeOtherDescription) {
		this.amortizationTypeOtherDescription = amortizationTypeOtherDescription;
	}

	public Integer getLoanAmortizationPeriodCount() {
		return loanAmortizationPeriodCount;
	}

	public void setLoanAmortizationPeriodCount(Integer loanAmortizationPeriodCount) {
		this.loanAmortizationPeriodCount = loanAmortizationPeriodCount;
	}

	public String getLoanAmortizationPeriodType() {
		return loanAmortizationPeriodType;
	}

	public void setLoanAmortizationPeriodType(String loanAmortizationPeriodType) {
		this.loanAmortizationPeriodType = loanAmortizationPeriodType;
	}
}
