package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Pay;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment_Rule {
	BigDecimal InitialPrincipalAndInterestPaymentAmount;
	Integer PaymentBillingStatementLeadDaysCount;
	String paymentFrequencyType; //Enumeration
	LocalDateTime ScheduledFirstPaymentDate;

	Payment_Rule(){}
}
