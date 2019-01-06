package information.dU231.LoaApp.LoaProDat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Loan_Features 
{
	String fNMProjectWarrantyType; //Enumeration
	String fNMProjectWarrantyTypeOtherDescription;
	String nameDocumentsDrawnInType; //Enumeration
	String fNMCondominiumCharacteristicsType; //Enumeration
	String fNMCondominiumCharacteristicsTypeOtherDescription;
	Boolean assumabilityIndicator;
	Boolean balloonIndicator;
	Integer balloonLoanMaturityTermMonths;
	Boolean buyDownTemporarySubsidyIndicator;
	String counselingConfirmationIndicator; //Enumeration
	Boolean escrowWaiverIndicator;
	String fREOfferingIdentifier;
	String fNMProductPlanIdentifier;
	String fNMProductIdentifier;		//???
	String gSEProjectClassificationType; //Enumeration
	String gSEPropertyType; //Enumeration
	BigDecimal hELOCMaximumBalanceAmount;
	BigDecimal hELOCInitialAdvanceAmount;
	Integer interestOnlyTerm;
	Boolean lenderSelfInsuredIndicator;
	String lienPriorityType; //Enumeration
	String loanDocumentationType;
	String loanRepaymentType; //Enumeration
	LocalDateTime LoanScheduledClosingDate;
	String mICertificationStatusType; //Enumeration
	BigDecimal mICoveragePercent;
	String mICompanyNameType; //Enumeration
	BigDecimal negativeAmortizationLimitPercent;
	String paymentFrequencyType; //Enumeration
	Boolean prepaymentPenaltyIndicator;
	String prepaymentPenaltyTermMonths; //Enumeration
	Boolean prepaymentRestrictionIndicator;
	String productDescription;
	String productName;
	LocalDateTime scheduledFirstPaymentDate;
	String loanClosingStatusType; //Enumeration
	String servicingTransferStatusType; //Enumeration

	public Loan_Features()
	{}
}
