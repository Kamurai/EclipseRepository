package information.dU231.LoaApp.GovLoa;

import java.math.BigDecimal;

public class FHA_Loan 
{
	BigDecimal borrowerFinancedFHADiscountPointsAmount;
	String fHAAlimonyLiabilityTreatmentType; //Enumeration
	BigDecimal fHACoverageRenewalRatePercent;
	BigDecimal fHA_MIPremiumRefundAmount;
	BigDecimal fHAUpfrontMIPremiumPercent;
	String lenderIdentifier;
	String sponsorIdentifier;
	String sponsoredOriginatorEIN;
	String sectionOfActType; //Enumeration
	
	public FHA_Loan()
	{}
}
