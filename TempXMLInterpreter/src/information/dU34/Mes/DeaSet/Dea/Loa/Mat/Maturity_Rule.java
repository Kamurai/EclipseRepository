package information.dU34.Mes.DeaSet.Dea.Loa.Mat;

public class Maturity_Rule {
	String loanMaturityPeriodType; //Enumeration
	Integer loanMaturityPeriodCount;
	
	public Maturity_Rule(){}

	public String getLoanMaturityPeriodType() {
		return loanMaturityPeriodType;
	}

	public void setLoanMaturityPeriodType(String loanMaturityPeriodType) {
		this.loanMaturityPeriodType = loanMaturityPeriodType;
	}

	public Integer getLoanMaturityPeriodCount() {
		return loanMaturityPeriodCount;
	}

	public void setLoanMaturityPeriodCount(Integer loanMaturityPeriodCount) {
		this.loanMaturityPeriodCount = loanMaturityPeriodCount;
	}
}
