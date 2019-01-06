package information.dU34.Mes.DeaSet.Dea.Lia;

import java.math.BigDecimal;

public class Liability_Detail {
	BigDecimal hELOCMaximumBalanceAmount;
	BigDecimal liabilityMonthlyPaymentAmount;
	Boolean liabilityPaymentIncludesTaxesInsuranceIndicator;
	Boolean liabilityPayoffStatusIndicator;
	Integer liabilityRemainingTermMonthsCount;
	String liabilityType;
	String liabilityTypeOtherDescription;
	BigDecimal liabilityUnpaidBalanceAmount;
	String liabilityAccountIdentifier;
	Boolean liabilityExclusionIndicator;
	
	public Liability_Detail(){
		
	}
	public String getLiabilityAccountIdentifier() {
		return liabilityAccountIdentifier;
	}

	public void setLiabilityAccountIdentifier(String liabilityAccountIdentifier) {
		this.liabilityAccountIdentifier = liabilityAccountIdentifier;
	}

	public Boolean getLiabilityExclusionIndicator() {
		return liabilityExclusionIndicator;
	}

	public void setLiabilityExclusionIndicator(Boolean liabilityExclusionIndicator) {
		this.liabilityExclusionIndicator = liabilityExclusionIndicator;
	}

	public BigDecimal getLiabilityMonthlyPaymentAmount() {
		return liabilityMonthlyPaymentAmount;
	}

	public void setLiabilityMonthlyPaymentAmount(String liabilityMonthlyPaymentAmount) {
		this.liabilityMonthlyPaymentAmount = new BigDecimal(liabilityMonthlyPaymentAmount);
	}

	public Boolean getLiabilityPaymentIncludesTaxesInsuranceIndicator() {
		return liabilityPaymentIncludesTaxesInsuranceIndicator;
	}

	public void setLiabilityPaymentIncludesTaxesInsuranceIndicator(
			Boolean liabilityPaymentIncludesTaxesInsuranceIndicator) {
		this.liabilityPaymentIncludesTaxesInsuranceIndicator = liabilityPaymentIncludesTaxesInsuranceIndicator;
	}

	public Boolean getLiabilityPayoffStatusIndicator() {
		return liabilityPayoffStatusIndicator;
	}

	public void setLiabilityPayoffStatusIndicator(Boolean liabilityPayoffStatusIndicator) {
		this.liabilityPayoffStatusIndicator = liabilityPayoffStatusIndicator;
	}

	public Integer getLiabilityRemainingTermMonthsCount() {
		return liabilityRemainingTermMonthsCount;
	}

	public void setLiabilityRemainingTermMonthsCount(Integer liabilityRemainingTermMonthsCount) {
		this.liabilityRemainingTermMonthsCount = liabilityRemainingTermMonthsCount;
	}

	public String getLiabilityType() {
		return liabilityType;
	}

	public void setLiabilityType(String liabilityType) {
		this.liabilityType = liabilityType;
	}

	public String getLiabilityTypeOtherDescription() {
		return liabilityTypeOtherDescription;
	}

	public void setLiabilityTypeOtherDescription(String liabilityTypeOtherDescription) {
		this.liabilityTypeOtherDescription = liabilityTypeOtherDescription;
	}

	public BigDecimal getLiabilityUnpaidBalanceAmount() {
		return liabilityUnpaidBalanceAmount;
	}

	public void setLiabilityUnpaidBalanceAmount(String liabilityUnpaidBalanceAmount) {
		this.liabilityUnpaidBalanceAmount = new BigDecimal(liabilityUnpaidBalanceAmount);
	}
	public BigDecimal getHELOCMaximumBalanceAmount() {
		return hELOCMaximumBalanceAmount;
	}
	public void setHELOCMaximumBalanceAmount(String hELOCMaximumBalanceAmount) {
		this.hELOCMaximumBalanceAmount = new BigDecimal(hELOCMaximumBalanceAmount);
	}
	public void setLiabilityMonthlyPaymentAmount(BigDecimal liabilityMonthlyPaymentAmount) {
		this.liabilityMonthlyPaymentAmount = liabilityMonthlyPaymentAmount;
	}
	public void setLiabilityUnpaidBalanceAmount(BigDecimal liabilityUnpaidBalanceAmount) {
		this.liabilityUnpaidBalanceAmount = liabilityUnpaidBalanceAmount;
	}
	
}
