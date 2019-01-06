package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.DocSpeDatSet.IntDis;

import java.math.BigDecimal;

public class Projected_Payment {
	String sequenceNumber;
	String paymentFrequencyType; //Enumeration
	String ProjectedPaymentCalculationPeriodEndNumber;
	String ProjectedPaymentCalculationPeriodStartNumber;
	String projectedPaymentCalculationPeriodTermType; //Enumeration
	String projectedPaymentCalculationPeriodTermTypeOtherDescription; //Enumeration
	BigDecimal ProjectedPaymentEstimatedEscrowPaymentAmount;
	BigDecimal ProjectedPaymentEstimatedTotalMaximumPaymentAmount;
	BigDecimal ProjectedPaymentEstimatedTotalMinimumPaymentAmount;
	BigDecimal ProjectedPaymentMIPaymentAmount;
	BigDecimal ProjectedPaymentPrincipalAndInterestMaximumPaymentAmount;
	BigDecimal ProjectedPaymentPrincipalAndInterestMinimumPaymentAmount;

	public Projected_Payment(){}
}
