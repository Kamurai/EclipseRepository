package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Lia;

import java.math.BigDecimal;

public class Liability_Detail {
	String LiabilityAccountIdentifier;
	Boolean LiabilityExclusionIndicator;
	BigDecimal LiabilityMonthlyPaymentAmount;
	Boolean LiabilityPaymentIncludesTaxesInsuranceIndicator;
	Boolean LiabilityPayoffStatusIndicator;
	Integer LiabilityRemainingTermMonthsCount;
	String liabilityType; //Enumeration
	String LiabilityTypeOtherDescription;
	BigDecimal LiabilityUnpaidBalanceAmount;
	
	public Liability_Detail(){}
}
