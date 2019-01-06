package information.dU34.Mes.DeaSet.Dea;

import java.math.BigDecimal;

public class Liability_Summary {
	BigDecimal TotalNonSubjectPropertyDebtsToBePaidOffAmount;
	BigDecimal TotalSubjectPropertyPayoffsAndPaymentsAmount;
	
	public BigDecimal getTotalNonSubjectPropertyDebtsToBePaidOffAmount() {
		return TotalNonSubjectPropertyDebtsToBePaidOffAmount;
	}

	public void setTotalNonSubjectPropertyDebtsToBePaidOffAmount(String totalNonSubjectPropertyDebtsToBePaidOffAmount) {
		TotalNonSubjectPropertyDebtsToBePaidOffAmount = new BigDecimal(totalNonSubjectPropertyDebtsToBePaidOffAmount);
	}

	public BigDecimal getTotalSubjectPropertyPayoffsAndPaymentsAmount() {
		return TotalSubjectPropertyPayoffsAndPaymentsAmount;
	}

	public void setTotalSubjectPropertyPayoffsAndPaymentsAmount(String totalSubjectPropertyPayoffsAndPaymentsAmount) {
		TotalSubjectPropertyPayoffsAndPaymentsAmount = new BigDecimal(totalSubjectPropertyPayoffsAndPaymentsAmount);
	}

	public Liability_Summary(){}
}
