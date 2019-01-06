package information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class URLA_Detail {
	BigDecimal alterationsImprovementsAndRepairsAmount;
	LocalDate applicationSignedByLoanOriginatorDate;
	BigDecimal borrowerPaidDiscountPointsTotalAmount;
	BigDecimal estimatedClosingCostsAmount;
	BigDecimal mIAndFundingFeeFinancedAmount;
	BigDecimal mIAndFundingFeeTotalAmount;
	BigDecimal prepaidItemsEstimatedAmount;
	BigDecimal refinanceImprovementCostsAmount;
	String refinanceImprovementsType; //Enumeration

	public URLA_Detail(){}

	public BigDecimal getAlterationsImprovementsAndRepairsAmount() {
		return alterationsImprovementsAndRepairsAmount;
	}

	public void setAlterationsImprovementsAndRepairsAmount(String alterationsImprovementsAndRepairsAmount) {
		this.alterationsImprovementsAndRepairsAmount = new BigDecimal(alterationsImprovementsAndRepairsAmount);
	}

	public LocalDate getApplicationSignedByLoanOriginatorDate() {
		return applicationSignedByLoanOriginatorDate;
	}

	public void setApplicationSignedByLoanOriginatorDate(LocalDate applicationSignedByLoanOriginatorDate) {
		this.applicationSignedByLoanOriginatorDate = applicationSignedByLoanOriginatorDate;
	}

	public BigDecimal getBorrowerPaidDiscountPointsTotalAmount() {
		return borrowerPaidDiscountPointsTotalAmount;
	}

	public void setBorrowerPaidDiscountPointsTotalAmount(String borrowerPaidDiscountPointsTotalAmount) {
		this.borrowerPaidDiscountPointsTotalAmount = new BigDecimal(borrowerPaidDiscountPointsTotalAmount);
	}

	public BigDecimal getEstimatedClosingCostsAmount() {
		return estimatedClosingCostsAmount;
	}

	public void setEstimatedClosingCostsAmount(String estimatedClosingCostsAmount) {
		this.estimatedClosingCostsAmount = new BigDecimal(estimatedClosingCostsAmount);
	}

	public BigDecimal getMIAndFundingFeeFinancedAmount() {
		return mIAndFundingFeeFinancedAmount;
	}

	public void setMIAndFundingFeeFinancedAmount(String mIAndFundingFeeFinancedAmount) {
		this.mIAndFundingFeeFinancedAmount = new BigDecimal(mIAndFundingFeeFinancedAmount);
	}

	public BigDecimal getMIAndFundingFeeTotalAmount() {
		return mIAndFundingFeeTotalAmount;
	}

	public void setMIAndFundingFeeTotalAmount(String mIAndFundingFeeTotalAmount) {
		this.mIAndFundingFeeTotalAmount = new BigDecimal(mIAndFundingFeeTotalAmount);
	}

	public BigDecimal getPrepaidItemsEstimatedAmount() {
		return prepaidItemsEstimatedAmount;
	}

	public void setPrepaidItemsEstimatedAmount(String prepaidItemsEstimatedAmount) {
		this.prepaidItemsEstimatedAmount = new BigDecimal(prepaidItemsEstimatedAmount);
	}

	public BigDecimal getRefinanceImprovementCostsAmount() {
		return refinanceImprovementCostsAmount;
	}

	public void setRefinanceImprovementCostsAmount(String refinanceImprovementCostsAmount) {
		this.refinanceImprovementCostsAmount = new BigDecimal(refinanceImprovementCostsAmount);
	}

	public String getRefinanceImprovementsType() {
		return refinanceImprovementsType;
	}

	public void setRefinanceImprovementsType(String refinanceImprovementsType) {
		this.refinanceImprovementsType = refinanceImprovementsType;
	}
}
