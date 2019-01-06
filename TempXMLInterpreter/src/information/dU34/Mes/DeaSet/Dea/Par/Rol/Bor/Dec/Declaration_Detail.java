package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Dec;

import java.math.BigDecimal;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Dec.DecDet.Extension;

public class Declaration_Detail {
	Boolean bankruptcyIndicator;
	String citizenshipResidencyType; //Enumeration
	Boolean fHASecondaryResidenceIndicator;
	String homeownerPastThreeYearsType; //Enumeration
	String intentToOccupyType; //Enumeration
	Boolean outstandingJudgmentsIndicator;
	Boolean partyToLawsuitIndicator;
	Boolean presentlyDelinquentIndicator;
	Boolean priorPropertyDeedInLieuConveyedIndicator;
	Boolean priorPropertyForeclosureCompletedIndicator;
	Boolean priorPropertyShortSaleCompletedIndicator;
	String priorPropertyTitleType; //Enumeration
	String priorPropertyUsageType; //Enumeration
	Boolean propertyProposedCleanEnergyLienIndicator;
	BigDecimal undisclosedBorrowedFundsAmount;
	Boolean undisclosedBorrowedFundsIndicator;
	Boolean undisclosedComakerOfNoteIndicator;
	Boolean undisclosedCreditApplicationIndicator;
	Boolean undisclosedMortgageApplicationIndicator;
	Extension extension; 
	
	public Declaration_Detail(){
		extension = new Extension();
	}

	public Boolean getBankruptcyIndicator() {
		return bankruptcyIndicator;
	}

	public void setBankruptcyIndicator(Boolean bankruptcyIndicator) {
		this.bankruptcyIndicator = bankruptcyIndicator;
	}

	public String getCitizenshipResidencyType() {
		return citizenshipResidencyType;
	}

	public void setCitizenshipResidencyType(String citizenshipResidencyType) {
		this.citizenshipResidencyType = citizenshipResidencyType;
	}

	public Boolean getFHASecondaryResidenceIndicator() {
		return fHASecondaryResidenceIndicator;
	}

	public void setFHASecondaryResidenceIndicator(Boolean fHASecondaryResidenceIndicator) {
		this.fHASecondaryResidenceIndicator = fHASecondaryResidenceIndicator;
	}

	public String getHomeownerPastThreeYearsType() {
		return homeownerPastThreeYearsType;
	}

	public void setHomeownerPastThreeYearsType(String homeownerPastThreeYearsType) {
		this.homeownerPastThreeYearsType = homeownerPastThreeYearsType;
	}

	public String getIntentToOccupyType() {
		return intentToOccupyType;
	}

	public void setIntentToOccupyType(String intentToOccupyType) {
		this.intentToOccupyType = intentToOccupyType;
	}

	public Boolean getOutstandingJudgmentsIndicator() {
		return outstandingJudgmentsIndicator;
	}

	public void setOutstandingJudgmentsIndicator(Boolean outstandingJudgmentsIndicator) {
		this.outstandingJudgmentsIndicator = outstandingJudgmentsIndicator;
	}

	public Boolean getPartyToLawsuitIndicator() {
		return partyToLawsuitIndicator;
	}

	public void setPartyToLawsuitIndicator(Boolean partyToLawsuitIndicator) {
		this.partyToLawsuitIndicator = partyToLawsuitIndicator;
	}

	public Boolean getPresentlyDelinquentIndicator() {
		return presentlyDelinquentIndicator;
	}

	public void setPresentlyDelinquentIndicator(Boolean presentlyDelinquentIndicator) {
		this.presentlyDelinquentIndicator = presentlyDelinquentIndicator;
	}

	public Boolean getPriorPropertyDeedInLieuConveyedIndicator() {
		return priorPropertyDeedInLieuConveyedIndicator;
	}

	public void setPriorPropertyDeedInLieuConveyedIndicator(Boolean priorPropertyDeedInLieuConveyedIndicator) {
		this.priorPropertyDeedInLieuConveyedIndicator = priorPropertyDeedInLieuConveyedIndicator;
	}

	public Boolean getPriorPropertyForeclosureCompletedIndicator() {
		return priorPropertyForeclosureCompletedIndicator;
	}

	public void setPriorPropertyForeclosureCompletedIndicator(Boolean priorPropertyForeclosureCompletedIndicator) {
		this.priorPropertyForeclosureCompletedIndicator = priorPropertyForeclosureCompletedIndicator;
	}

	public Boolean getPriorPropertyShortSaleCompletedIndicator() {
		return priorPropertyShortSaleCompletedIndicator;
	}

	public void setPriorPropertyShortSaleCompletedIndicator(Boolean priorPropertyShortSaleCompletedIndicator) {
		this.priorPropertyShortSaleCompletedIndicator = priorPropertyShortSaleCompletedIndicator;
	}

	public String getPriorPropertyTitleType() {
		return priorPropertyTitleType;
	}

	public void setPriorPropertyTitleType(String priorPropertyTitleType) {
		this.priorPropertyTitleType = priorPropertyTitleType;
	}

	public String getPriorPropertyUsageType() {
		return priorPropertyUsageType;
	}

	public void setPriorPropertyUsageType(String priorPropertyUsageType) {
		this.priorPropertyUsageType = priorPropertyUsageType;
	}

	public Boolean getPropertyProposedCleanEnergyLienIndicator() {
		return propertyProposedCleanEnergyLienIndicator;
	}

	public void setPropertyProposedCleanEnergyLienIndicator(Boolean propertyProposedCleanEnergyLienIndicator) {
		this.propertyProposedCleanEnergyLienIndicator = propertyProposedCleanEnergyLienIndicator;
	}

	public BigDecimal getUndisclosedBorrowedFundsAmount() {
		return undisclosedBorrowedFundsAmount;
	}

	public void setUndisclosedBorrowedFundsAmount(String undisclosedBorrowedFundsAmount) {
		this.undisclosedBorrowedFundsAmount = new BigDecimal(undisclosedBorrowedFundsAmount);
	}

	public Boolean getUndisclosedBorrowedFundsIndicator() {
		return undisclosedBorrowedFundsIndicator;
	}

	public void setUndisclosedBorrowedFundsIndicator(Boolean undisclosedBorrowedFundsIndicator) {
		this.undisclosedBorrowedFundsIndicator = undisclosedBorrowedFundsIndicator;
	}

	public Boolean getUndisclosedComakerOfNoteIndicator() {
		return undisclosedComakerOfNoteIndicator;
	}

	public void setUndisclosedComakerOfNoteIndicator(Boolean undisclosedComakerOfNoteIndicator) {
		this.undisclosedComakerOfNoteIndicator = undisclosedComakerOfNoteIndicator;
	}

	public Boolean getUndisclosedCreditApplicationIndicator() {
		return undisclosedCreditApplicationIndicator;
	}

	public void setUndisclosedCreditApplicationIndicator(Boolean undisclosedCreditApplicationIndicator) {
		this.undisclosedCreditApplicationIndicator = undisclosedCreditApplicationIndicator;
	}

	public Boolean getUndisclosedMortgageApplicationIndicator() {
		return undisclosedMortgageApplicationIndicator;
	}

	public void setUndisclosedMortgageApplicationIndicator(Boolean undisclosedMortgageApplicationIndicator) {
		this.undisclosedMortgageApplicationIndicator = undisclosedMortgageApplicationIndicator;
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
