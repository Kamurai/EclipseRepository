package information.dU34.Mes.DeaSet.Dea.Loa;

import java.math.BigDecimal;
import java.time.LocalDate;

import information.dU34.Mes.DeaSet.Dea.Loa.LoaDet.Extension;

public class Loan_Detail {
	LocalDate ApplicationReceivedDate;
	Boolean balloonIndicator;
	Boolean belowMarketSubordinateFinancingIndicator;
	Integer borrowerCount;
	Boolean buydownTemporarySubsidyFundingIndicator;
	Boolean constructionLoanIndicator;
	Boolean conversionOfContractForDeedIndicator;
	Boolean energyRelatedImprovementsIndicator;
	Boolean hELOCIndicator;
	Integer initialFixedPeriodEffectiveMonthsCount;
	Boolean interestOnlyIndicator;
	Boolean negativeAmortizationIndicator;
	Boolean prepaymentPenaltyIndicator;
	Boolean renovationLoanIndicator;
	BigDecimal totalSubordinateFinancingAmount;
	Extension extension;
	
	public Loan_Detail(){}

	public LocalDate getApplicationReceivedDate() {
		return ApplicationReceivedDate;
	}

	public void setApplicationReceivedDate(LocalDate applicationReceivedDate) {
		ApplicationReceivedDate = applicationReceivedDate;
	}

	public Boolean getBalloonIndicator() {
		return balloonIndicator;
	}

	public void setBalloonIndicator(Boolean balloonIndicator) {
		this.balloonIndicator = balloonIndicator;
	}

	public Boolean getBelowMarketSubordinateFinancingIndicator() {
		return belowMarketSubordinateFinancingIndicator;
	}

	public void setBelowMarketSubordinateFinancingIndicator(Boolean belowMarketSubordinateFinancingIndicator) {
		this.belowMarketSubordinateFinancingIndicator = belowMarketSubordinateFinancingIndicator;
	}

	public Integer getBorrowerCount() {
		return borrowerCount;
	}

	public void setBorrowerCount(Integer borrowerCount) {
		this.borrowerCount = borrowerCount;
	}

	public Boolean getBuydownTemporarySubsidyFundingIndicator() {
		return buydownTemporarySubsidyFundingIndicator;
	}

	public void setBuydownTemporarySubsidyFundingIndicator(Boolean buydownTemporarySubsidyFundingIndicator) {
		this.buydownTemporarySubsidyFundingIndicator = buydownTemporarySubsidyFundingIndicator;
	}

	public Boolean getConstructionLoanIndicator() {
		return constructionLoanIndicator;
	}

	public void setConstructionLoanIndicator(Boolean constructionLoanIndicator) {
		this.constructionLoanIndicator = constructionLoanIndicator;
	}

	public Boolean getConversionOfContractForDeedIndicator() {
		return conversionOfContractForDeedIndicator;
	}

	public void setConversionOfContractForDeedIndicator(Boolean conversionOfContractForDeedIndicator) {
		this.conversionOfContractForDeedIndicator = conversionOfContractForDeedIndicator;
	}

	public Boolean getEnergyRelatedImprovementsIndicator() {
		return energyRelatedImprovementsIndicator;
	}

	public void setEnergyRelatedImprovementsIndicator(Boolean energyRelatedImprovementsIndicator) {
		this.energyRelatedImprovementsIndicator = energyRelatedImprovementsIndicator;
	}

	public Boolean getHELOCIndicator() {
		return hELOCIndicator;
	}

	public void setHELOCIndicator(Boolean hELOCIndicator) {
		this.hELOCIndicator = hELOCIndicator;
	}

	public Integer getInitialFixedPeriodEffectiveMonthsCount() {
		return initialFixedPeriodEffectiveMonthsCount;
	}

	public void setInitialFixedPeriodEffectiveMonthsCount(Integer initialFixedPeriodEffectiveMonthsCount) {
		this.initialFixedPeriodEffectiveMonthsCount = initialFixedPeriodEffectiveMonthsCount;
	}

	public Boolean getInterestOnlyIndicator() {
		return interestOnlyIndicator;
	}

	public void setInterestOnlyIndicator(Boolean interestOnlyIndicator) {
		this.interestOnlyIndicator = interestOnlyIndicator;
	}

	public Boolean getNegativeAmortizationIndicator() {
		return negativeAmortizationIndicator;
	}

	public void setNegativeAmortizationIndicator(Boolean negativeAmortizationIndicator) {
		this.negativeAmortizationIndicator = negativeAmortizationIndicator;
	}

	public Boolean getPrepaymentPenaltyIndicator() {
		return prepaymentPenaltyIndicator;
	}

	public void setPrepaymentPenaltyIndicator(Boolean prepaymentPenaltyIndicator) {
		this.prepaymentPenaltyIndicator = prepaymentPenaltyIndicator;
	}

	public Boolean getRenovationLoanIndicator() {
		return renovationLoanIndicator;
	}

	public void setRenovationLoanIndicator(Boolean renovationLoanIndicator) {
		this.renovationLoanIndicator = renovationLoanIndicator;
	}

	public BigDecimal getTotalSubordinateFinancingAmount() {
		return totalSubordinateFinancingAmount;
	}

	public void setTotalSubordinateFinancingAmount(String totalSubordinateFinancingAmount) {
		this.totalSubordinateFinancingAmount = new BigDecimal(totalSubordinateFinancingAmount);
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
