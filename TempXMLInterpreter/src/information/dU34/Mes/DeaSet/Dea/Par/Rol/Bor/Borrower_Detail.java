package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Borrower_Detail {
	LocalDate borrowerBirthDate;
	Integer borrowerTotalMortgagedPropertiesCount;
	Boolean communityPropertyStateResidentIndicator;
	Integer dependentCount;
	Boolean domesticRelationshipIndicator;
	String domesticRelationshipStateCode;
	String domesticRelationshipType; //Enumeration
	String domesticRelationshipTypeOtherDescription;
	String maritalStatusType; //Enumeration
	Boolean selfDeclaredMIlitaryServiceIndicator;
	Boolean spousalVABenefitsEligibilityIndicator;

	public Borrower_Detail(){
	}

	public LocalDate getBorrowerBirthDate() {
		return borrowerBirthDate;
	}

	public void setBorrowerBirthDate(LocalDate localDate) {
		this.borrowerBirthDate = localDate;
	}

	public Integer getBorrowerTotalMortgagedPropertiesCount() {
		return borrowerTotalMortgagedPropertiesCount;
	}

	public void setBorrowerTotalMortgagedPropertiesCount(Integer borrowerTotalMortgagedPropertiesCount) {
		this.borrowerTotalMortgagedPropertiesCount = borrowerTotalMortgagedPropertiesCount;
	}

	public Boolean getCommunityPropertyStateResidentIndicator() {
		return communityPropertyStateResidentIndicator;
	}

	public void setCommunityPropertyStateResidentIndicator(Boolean communityPropertyStateResidentIndicator) {
		this.communityPropertyStateResidentIndicator = communityPropertyStateResidentIndicator;
	}

	public Integer getDependentCount() {
		return dependentCount;
	}

	public void setDependentCount(Integer dependentCount) {
		this.dependentCount = dependentCount;
	}

	public Boolean getDomesticRelationshipIndicator() {
		return domesticRelationshipIndicator;
	}

	public void setDomesticRelationshipIndicator(Boolean domesticRelationshipIndicator) {
		this.domesticRelationshipIndicator = domesticRelationshipIndicator;
	}

	public String getDomesticRelationshipStateCode() {
		return domesticRelationshipStateCode;
	}

	public void setDomesticRelationshipStateCode(String domesticRelationshipStateCode) {
		this.domesticRelationshipStateCode = domesticRelationshipStateCode;
	}

	public String getDomesticRelationshipType() {
		return domesticRelationshipType;
	}

	public void setDomesticRelationshipType(String domesticRelationshipType) {
		this.domesticRelationshipType = domesticRelationshipType;
	}

	public String getDomesticRelationshipTypeOtherDescription() {
		return domesticRelationshipTypeOtherDescription;
	}

	public void setDomesticRelationshipTypeOtherDescription(String domesticRelationshipTypeOtherDescription) {
		this.domesticRelationshipTypeOtherDescription = domesticRelationshipTypeOtherDescription;
	}

	public String getMaritalStatusType() {
		return maritalStatusType;
	}

	public void setMaritalStatusType(String maritalStatusType) {
		this.maritalStatusType = maritalStatusType;
	}

	public Boolean getSelfDeclaredMIlitaryServiceIndicator() {
		return selfDeclaredMIlitaryServiceIndicator;
	}

	public void setSelfDeclaredMIlitaryServiceIndicator(Boolean selfDeclaredMIlitaryServiceIndicator) {
		this.selfDeclaredMIlitaryServiceIndicator = selfDeclaredMIlitaryServiceIndicator;
	}

	public Boolean getSpousalVABenefitsEligibilityIndicator() {
		return spousalVABenefitsEligibilityIndicator;
	}

	public void setSpousalVABenefitsEligibilityIndicator(Boolean spousalVABenefitsEligibilityIndicator) {
		this.spousalVABenefitsEligibilityIndicator = spousalVABenefitsEligibilityIndicator;
	}
}
