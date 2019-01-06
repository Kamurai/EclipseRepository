package information.uLDD30.Mes.DeaSets.DeaSet.Poo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Pool_Detail 
{
	String poolAccrualRateStructureType; //Enumeration
	String poolAmortizationType; //Enumeration
	Boolean poolAssumabilityIndicator;
	Boolean poolBalloonIndicator;
	BigDecimal poolFixedServicingFeePercent;
	String poolIdentifier;
	Integer poolInterestAndPaymentAdjustmentIndexLeadDaysCount;
	Boolean poolInterestOnlyIndicator;
	BigDecimal poolInterestRateRoundingPercent;
	String poolInterestRateRoundingType; //Enumeration
	String poolInvestorProductPlanIdentifier;
	LocalDateTime poolIssueDate;
	BigDecimal poolMarginRatePercent;
	BigDecimal poolMaximumAccrualRatePercent;
	BigDecimal poolMinimumAccrualRatePercent;
	String poolMortgageType; //Enumeration
	BigDecimal poolOwnershipPercent;
	Integer poolScheduledRemittancePaymentDay;
	BigDecimal poolSecurityIssueDateInterestRatePercent;
	String poolStructureType; //Enumeration
	String poolSuffixIdentifier;
	LocalDateTime securityTradeBookEntryDate;

	public Pool_Detail()
	{
	}
}
