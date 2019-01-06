package information.dU34.Mes.DeaSet.Dea.Loa.HelOcc;

import java.math.BigDecimal;

public class HELOC_Occurence {
	BigDecimal hELOCBalanceAmount;
	
	public HELOC_Occurence(){}

	public BigDecimal getHELOCBalanceAmount() {
		return hELOCBalanceAmount;
	}

	public void setHELOCBalanceAmount(String hELOCBalanceAmount) {
		this.hELOCBalanceAmount = new BigDecimal(hELOCBalanceAmount);
	}
}
