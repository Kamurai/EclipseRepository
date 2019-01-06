package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa;

import java.math.BigDecimal;

import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.LoaDet.Extension;

public class Loan_Detail {
	boolean AssumabilityIndicator;
	boolean BalloonIndicator;
	BigDecimal balloonPaymentAmount;
	boolean BuydownTemporarySubsidyFundingIndicator;
	boolean ConstructionLoanIndicator;
	boolean DemandFeatureIndicator;
	String escrowAbsenceReasonType; //Enumeration
	boolean EscrowIndicator;
	boolean MIRequiredIndicator;
	boolean NegativeAmortizationIndicator;
	boolean PaymentIncreaseIndicator;
	boolean PrepaymentPenaltyIndicator;
	boolean SeasonalPaymentFeatureIndicator;
	BigDecimal totalSubordinateFinancingAmount;
	Extension extension;
	
	public Loan_Detail(){}
}
