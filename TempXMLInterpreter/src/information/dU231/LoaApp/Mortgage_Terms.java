package information.dU231.LoaApp;

import java.math.BigDecimal;

public class Mortgage_Terms 
{
	String AgencyCaseIdentifier;
	String ARMTypeDescription;
	BigDecimal BaseLoanAmount;
	BigDecimal BorrowerRequestedLoanAmount;
	String LenderCaseIdentifier;
	Integer LoanAmortizationTermMonths;
	String loanAmortizationType; //Enumeration
	String mortgageType; //Enumeration
	String OtherMortgageTypeDescription;
	String OtherAmortizationTypeDescription;
	BigDecimal RequestedInterestRatePercent;
	
	public Mortgage_Terms()
	{}
}
