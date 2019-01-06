package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa;

import java.math.BigDecimal;

public class HMDA_Loan {
	Boolean hMDA_HOEPALoanStatusIndicator;
	BigDecimal hMDARateSpreadPercent;

	public HMDA_Loan(){}

	public Boolean getHMDA_HOEPALoanStatusIndicator() {
		return hMDA_HOEPALoanStatusIndicator;
	}

	public void setHMDA_HOEPALoanStatusIndicator(Boolean hMDA_HOEPALoanStatusIndicator) {
		this.hMDA_HOEPALoanStatusIndicator = hMDA_HOEPALoanStatusIndicator;
	}

	public BigDecimal getHMDARateSpreadPercent() {
		return hMDARateSpreadPercent;
	}

	public void setHMDARateSpreadPercent(String hMDARateSpreadPercent) {
		this.hMDARateSpreadPercent = new BigDecimal(hMDARateSpreadPercent);
	}
}
