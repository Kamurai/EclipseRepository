package information.dU231.LoaApp;

import java.math.BigDecimal;

public class Liability 
{
	String iD;
	String borrowerID;
	String rEO_ID;
	String holderStreetAddress;
	String holderCity;
	String holderState;
	String holderPostalCode;
	String alimonyOwedToName;
	String accountIdentifier;
	Boolean exclusionIndicator;
	String holderName;
	BigDecimal monthlyPaymentAmount;
	Boolean payoffStatusIndicator;
	Boolean payoffWithCurrentAssetsIndicator;
	Integer remainingTermMonths;
	String type; //Enumeration
	BigDecimal unpaidBalanceAmount;	
	Boolean subjectLoanResubordinationIndicator;
	Boolean fNMSubjectPropertyIndicator;
	Boolean fNMRentalPropertyIndicator;

	
	public Liability()
	{}
}
