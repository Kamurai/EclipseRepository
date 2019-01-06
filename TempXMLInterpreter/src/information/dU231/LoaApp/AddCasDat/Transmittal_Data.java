package information.dU231.LoaApp.AddCasDat;

import java.math.BigDecimal;

public class Transmittal_Data 
{
	String fNMFirstLienFinancingType;
	String fNMFirstLienFinancingTypeOtherDescription;
	Boolean armsLengthIndicator;
	Boolean belowMarketSubordinateFinancingIndicator;
	BigDecimal buydownRatePercent;
	String caseStateType; //Enumeration
	Boolean creditReportAuthorizationIndicator;
	String currentFirstMortgageHolderType; //Enumeration
	String lenderBranchIdentifier;
	String lenderRegistrationIdentifier;
	BigDecimal propertyAppraisedValueAmount;
	BigDecimal propertyEstimatedValueAmount;
	String investorLoanIdentifier;
	String investorInstitutionIdentifier;
	String fIPSCodeIdentifier;
	String commitmentReferenceIdentifier;
	Boolean concurrentOriginationIndicator;
	Boolean concurrentOriginationLenderIndicator;
	Integer rateLockPeriodDays;
	String rateLockType; //Enumeration
	Integer rateLockRequestedExtensionDays;
	String loanOriginatorID;
	String loanOriginationCompanyID;
	
	public Transmittal_Data()
	{}

}
