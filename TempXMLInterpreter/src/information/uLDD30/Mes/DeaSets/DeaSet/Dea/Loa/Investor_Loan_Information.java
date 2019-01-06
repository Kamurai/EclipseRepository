package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa;

import java.math.BigDecimal;

public class Investor_Loan_Information {
	BigDecimal baseGuarantyFeePercent;
	boolean guaranteeFeeAddOnIndicator;
	BigDecimal guarantyFeeAfterAlternatePaymentMethodPercent;
	BigDecimal guarantyFeePercent;
	String investorCollateralProgramIdentifier;
	BigDecimal investorOwnershipPercent;
	String investorProductPlanIdentifier;
	String investorRemittanceDay;
	String investorRemittanceType; //Enumeration
	BigDecimal loanAcquisitionScheduledUPBAmount;
	String LoanBuyupBuydownBasisPointNumber;  //Specifications say "not used", no format available
	String loanBuyupBuydownType;  //Specifications say "not used", no format available
	String loanDefaultLossPartyType; //Enumeration
	String relatedInvestorLoanIdentifier;
	String relatedLoanInvestorType; //Enumeration
	String rEOMarketingPartyType; //Enumeration

	public Investor_Loan_Information()
	{}
}
