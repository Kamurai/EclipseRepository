package information.dU34.Mes.DeaSet.Dea.Loa;

import java.math.BigDecimal;

public class Government_Loan {
	String fHALoanLenderIdentifier;
	String fHALoanSponsorIdentifier;
	BigDecimal fHA_MIPremiumRefundAmount;
	BigDecimal governmentMortgageCreditCertificateAmount;
	String governmentRefinanceType; //Enumeration
	String governmentRefinanceTypeOtherDescription; //Enumeration
	Boolean propertyEnergyEfficientHomeIndicator;
	String sectionOfActType; //Enumeration
	Boolean vABorrowerCoBorrowerMarriedIndicator;
	BigDecimal vAEntitlementAmount;
	BigDecimal vAMaintenanceExpenseMonthlyAmount;
	BigDecimal vAUtilityExpenseMonthlyAmount;
	
	public Government_Loan(){}

	public String getFHALoanLenderIdentifier() {
		return fHALoanLenderIdentifier;
	}

	public void setFHALoanLenderIdentifier(String fHALoanLenderIdentifier) {
		this.fHALoanLenderIdentifier = fHALoanLenderIdentifier;
	}

	public String getFHALoanSponsorIdentifier() {
		return fHALoanSponsorIdentifier;
	}

	public void setFHALoanSponsorIdentifier(String fHALoanSponsorIdentifier) {
		this.fHALoanSponsorIdentifier = fHALoanSponsorIdentifier;
	}

	public BigDecimal getGovernmentMortgageCreditCertificateAmount() {
		return governmentMortgageCreditCertificateAmount;
	}

	public void setGovernmentMortgageCreditCertificateAmount(String governmentMortgageCreditCertificateAmount) {
		this.governmentMortgageCreditCertificateAmount = new BigDecimal(governmentMortgageCreditCertificateAmount);
	}

	public String getGovernmentRefinanceType() {
		return governmentRefinanceType;
	}

	public void setGovernmentRefinanceType(String governmentRefinanceType) {
		this.governmentRefinanceType = governmentRefinanceType;
	}

	public Boolean getPropertyEnergyEfficientHomeIndicator() {
		return propertyEnergyEfficientHomeIndicator;
	}

	public void setPropertyEnergyEfficientHomeIndicator(Boolean propertyEnergyEfficientHomeIndicator) {
		this.propertyEnergyEfficientHomeIndicator = propertyEnergyEfficientHomeIndicator;
	}

	public String getSectionOfActType() {
		return sectionOfActType;
	}

	public void setSectionOfActType(String sectionOfActType) {
		this.sectionOfActType = sectionOfActType;
	}

	public Boolean getVABorrowerCoBorrowerMarriedIndicator() {
		return vABorrowerCoBorrowerMarriedIndicator;
	}

	public void setVABorrowerCoBorrowerMarriedIndicator(Boolean vABorrowerCoBorrowerMarriedIndicator) {
		this.vABorrowerCoBorrowerMarriedIndicator = vABorrowerCoBorrowerMarriedIndicator;
	}

	public BigDecimal getVAEntitlementAmount() {
		return vAEntitlementAmount;
	}

	public void setVAEntitlementAmount(String vAEntitlementAmount) {
		this.vAEntitlementAmount = new BigDecimal(vAEntitlementAmount);
	}

	public BigDecimal getVAMaintenanceExpenseMonthlyAmount() {
		return vAMaintenanceExpenseMonthlyAmount;
	}

	public void setVAMaintenanceExpenseMonthlyAmount(String vAMaintenanceExpenseMonthlyAmount) {
		this.vAMaintenanceExpenseMonthlyAmount = new BigDecimal(vAMaintenanceExpenseMonthlyAmount);
	}

	public BigDecimal getVAUtilityExpenseMonthlyAmount() {
		return vAUtilityExpenseMonthlyAmount;
	}

	public void setVAUtilityExpenseMonthlyAmount(String vAUtilityExpenseMonthlyAmount) {
		this.vAUtilityExpenseMonthlyAmount = new BigDecimal(vAUtilityExpenseMonthlyAmount);
	}

	public BigDecimal getFHA_MIPremiumRefundAmount() {
		return fHA_MIPremiumRefundAmount;
	}

	public void setFHA_MIPremiumRefundAmount(String fHA_MIPremiumRefundAmount) {
		this.fHA_MIPremiumRefundAmount = new BigDecimal(fHA_MIPremiumRefundAmount);
	}

	public String getGovernmentRefinanceTypeOtherDescription() {
		return governmentRefinanceTypeOtherDescription;
	}

	public void setGovernmentRefinanceTypeOtherDescription(String governmentRefinanceTypeOtherDescription) {
		this.governmentRefinanceTypeOtherDescription = governmentRefinanceTypeOtherDescription;
	}
}
