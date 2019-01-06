package information.dU34.Mes.DeaSet.Dea.Loa.Pay;

import java.math.BigDecimal;

public class Payment_Rule {
	BigDecimal initialPrincipalAndInterestPaymentAmount;
	
	public Payment_Rule(){}

	public BigDecimal getInitialPrincipalAndInterestPaymentAmount() {
		return initialPrincipalAndInterestPaymentAmount;
	}

	public void setInitialPrincipalAndInterestPaymentAmount(String initialPrincipalAndInterestPaymentAmount) {
		this.initialPrincipalAndInterestPaymentAmount = new BigDecimal(initialPrincipalAndInterestPaymentAmount);
	}
}
