package information.dU34.Mes.DeaSet.Dea.Col.SubPro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Property_Detail extends information.dU34.common.Property_Detail{
	String attachmentType; //Enumeration
	Boolean communityPropertyStateIndicator;
	String constructionMethodType; //Enumeration
	String constructionMethodTypeOtherDescription; //Enumeration
	Boolean fHASecondaryResidenceIndicator;
	Integer financedUnitCount;
	String nativeAmericanLandsType; //Enumeration
	String nativeAmericanLandsTypeOtherDescription; //Enumeration
	LocalDate propertyAcquiredDate;
	String propertyEstateType; //Enumeration
	//BigDecimal propertyEstimatedValueAmount;
	Boolean propertyExistingCleanEnergyLienIndicator;
	LocalDate propertyGroundLeaseExpirationDate;
	Boolean propertyInProjectIndicator;
	Boolean propertyMixedUsageIndicator;
	String propertyStructureBuiltYear; //CCYY
	String propertyUsageType; //Enumeration
	Boolean pUDIndicator;
	BigDecimal rentalEstimatedGrossMonthlyRentAmount;
	BigDecimal rentalEstimatedNetMonthlyRentAmount;

	
	public Property_Detail(){}

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public Boolean getCommunityPropertyStateIndicator() {
		return communityPropertyStateIndicator;
	}

	public void setCommunityPropertyStateIndicator(Boolean communityPropertyStateIndicator) {
		this.communityPropertyStateIndicator = communityPropertyStateIndicator;
	}

	public String getConstructionMethodType() {
		return constructionMethodType;
	}

	public void setConstructionMethodType(String constructionMethodType) {
		this.constructionMethodType = constructionMethodType;
	}

	public String getConstructionMethodTypeOtherDescription() {
		return constructionMethodTypeOtherDescription;
	}

	public void setConstructionMethodTypeOtherDescription(String constructionMethodTypeOtherDescription) {
		this.constructionMethodTypeOtherDescription = constructionMethodTypeOtherDescription;
	}

	public Boolean getFHASecondaryResidenceIndicator() {
		return fHASecondaryResidenceIndicator;
	}

	public void setFHASecondaryResidenceIndicator(Boolean fHASecondaryResidenceIndicator) {
		this.fHASecondaryResidenceIndicator = fHASecondaryResidenceIndicator;
	}

	public Integer getFinancedUnitCount() {
		return financedUnitCount;
	}

	public void setFinancedUnitCount(Integer financedUnitCount) {
		this.financedUnitCount = financedUnitCount;
	}
	
	public Boolean getPropertyMixedUsageIndicator() {
		return propertyMixedUsageIndicator;
	}

	public void setPropertyMixedUsageIndicator(Boolean propertyMixedUsageIndicator) {
		this.propertyMixedUsageIndicator = propertyMixedUsageIndicator;
	}

	public String getPropertyUsageType() {
		return propertyUsageType;
	}

	public void setPropertyUsageType(String propertyUsageType) {
		this.propertyUsageType = propertyUsageType;
	}

	public String getNativeAmericanLandsType() {
		return nativeAmericanLandsType;
	}

	public void setNativeAmericanLandsType(String nativeAmericanLandsType) {
		this.nativeAmericanLandsType = nativeAmericanLandsType;
	}

	public String getNativeAmericanLandsTypeOtherDescription() {
		return nativeAmericanLandsTypeOtherDescription;
	}

	public void setNativeAmericanLandsTypeOtherDescription(String nativeAmericanLandsTypeOtherDescription) {
		this.nativeAmericanLandsTypeOtherDescription = nativeAmericanLandsTypeOtherDescription;
	}

	public LocalDate getPropertyAcquiredDate() {
		return propertyAcquiredDate;
	}

	public void setPropertyAcquiredDate(LocalDate propertyAcquiredDate) {
		this.propertyAcquiredDate = propertyAcquiredDate;
	}

	public String getPropertyEstateType() {
		return propertyEstateType;
	}

	public void setPropertyEstateType(String propertyEstateType) {
		this.propertyEstateType = propertyEstateType;
	}

	public Boolean getPropertyExistingCleanEnergyLienIndicator() {
		return propertyExistingCleanEnergyLienIndicator;
	}

	public void setPropertyExistingCleanEnergyLienIndicator(Boolean propertyExistingCleanEnergyLienIndicator) {
		this.propertyExistingCleanEnergyLienIndicator = propertyExistingCleanEnergyLienIndicator;
	}

	public LocalDate getPropertyGroundLeaseExpirationDate() {
		return propertyGroundLeaseExpirationDate;
	}

	public void setPropertyGroundLeaseExpirationDate(LocalDate propertyGroundLeaseExpirationDate) {
		this.propertyGroundLeaseExpirationDate = propertyGroundLeaseExpirationDate;
	}

	public Boolean getPropertyInProjectIndicator() {
		return propertyInProjectIndicator;
	}

	public void setPropertyInProjectIndicator(Boolean propertyInProjectIndicator) {
		this.propertyInProjectIndicator = propertyInProjectIndicator;
	}

	public String getPropertyStructureBuiltYear() {
		return propertyStructureBuiltYear;
	}

	public void setPropertyStructureBuiltYear(String propertyStructureBuiltYear) {
		this.propertyStructureBuiltYear = propertyStructureBuiltYear;
	}

	public Boolean getPUDIndicator() {
		return pUDIndicator;
	}

	public void setPUDIndicator(Boolean pUDIndicator) {
		this.pUDIndicator = pUDIndicator;
	}

	public BigDecimal getRentalEstimatedGrossMonthlyRentAmount() {
		return rentalEstimatedGrossMonthlyRentAmount;
	}

	public void setRentalEstimatedGrossMonthlyRentAmount(String rentalEstimatedGrossMonthlyRentAmount) {
		this.rentalEstimatedGrossMonthlyRentAmount = new BigDecimal(rentalEstimatedGrossMonthlyRentAmount);
	}

	public BigDecimal getRentalEstimatedNetMonthlyRentAmount() {
		return rentalEstimatedNetMonthlyRentAmount;
	}

	public void setRentalEstimatedNetMonthlyRentAmount(String rentalEstimatedNetMonthlyRentAmount) {
		this.rentalEstimatedNetMonthlyRentAmount = new BigDecimal(rentalEstimatedNetMonthlyRentAmount);
	}
}
