package information.dU231.LoaApp.LoaPur;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Construction_Refinance_Data 
{
	BigDecimal FNMCashOutIncludingNonMortgageAmount;
	BigDecimal ConstructionImprovementCostsAmount;
	String constructionPurposeType; //Enumeration
	BigDecimal FRECashOutAmount;
	String gSERefinancePurposeType; //Enumeration
	BigDecimal LandEstimatedValueAmount;
	BigDecimal LandOriginalCostAmount;
	LocalDateTime PropertyAcquiredYear;
	BigDecimal PropertyExistingLienAmount;
	BigDecimal PropertyOriginalCostAmount;
	BigDecimal RefinanceImprovementCostsAmount;
	String refinanceImprovementsType; //Enumeration
	String refinanceProposedImprovementsDescription;
	boolean secondaryFinancingRefinanceIndicator;
	boolean fNMSecondMortgageFinancingOriginalPropertyIndicator;
	BigDecimal structuralAlterationsConventionalAmount;
	BigDecimal nonStructuralAlterationsConventionalAmount;
	
	public Construction_Refinance_Data()
	{}
}
