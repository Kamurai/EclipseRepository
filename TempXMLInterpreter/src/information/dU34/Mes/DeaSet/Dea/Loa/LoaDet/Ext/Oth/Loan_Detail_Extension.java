package information.dU34.Mes.DeaSet.Dea.Loa.LoaDet.Ext.Oth;

import java.math.BigDecimal;

public class Loan_Detail_Extension {
	BigDecimal energyImprovementAmount;
	BigDecimal pACELoanPayoffAmount;
	
	public Loan_Detail_Extension(){}

	public BigDecimal getEnergyImprovementAmount() {
		return energyImprovementAmount;
	}

	public void setEnergyImprovementAmount(String energyImprovementAmount) {
		this.energyImprovementAmount = new BigDecimal(energyImprovementAmount);
	}

	public BigDecimal getpACELoanPayoffAmount() {
		return pACELoanPayoffAmount;
	}

	public void setpACELoanPayoffAmount(String pACELoanPayoffAmount) {
		this.pACELoanPayoffAmount = new BigDecimal(pACELoanPayoffAmount);
	}
}
