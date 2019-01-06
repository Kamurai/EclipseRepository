package information.dU34.Mes.DeaSet.Dea.Loa.HelRul;

import java.math.BigDecimal;

public class HELOC_Rule {
	BigDecimal hELOCMaximumBalanceAmount;
	
	public HELOC_Rule(){}

	public BigDecimal getHELOCMaximumBalanceAmount() {
		return hELOCMaximumBalanceAmount;
	}

	public void setHELOCMaximumBalanceAmount(String hELOCMaximumBalanceAmount) {
		this.hELOCMaximumBalanceAmount = new BigDecimal(hELOCMaximumBalanceAmount);
	}
}
