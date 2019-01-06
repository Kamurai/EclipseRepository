package information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro;

import java.math.BigDecimal;

public class Property_Detail extends information.dU34.common.Property_Detail{
	String ownedPropertyDispositionStatusType; //Enumeration
	BigDecimal ownedPropertyLienUPBAmount;
	BigDecimal ownedPropertyMaintenanceExpenseAmount;
	BigDecimal ownedPropertyRentalIncomeGrossAmount;
	BigDecimal ownedPropertyRentalIncomeNetAmount;
	Boolean ownedPropertySubjectIndicator;
	String propertyCurrentUsageType; //Enumeration
	
	public Property_Detail(){}

	public Boolean getOwnedPropertySubjectIndicator() {
		return ownedPropertySubjectIndicator;
	}

	public void setOwnedPropertySubjectIndicator(Boolean ownedPropertySubjectIndicator) {
		this.ownedPropertySubjectIndicator = ownedPropertySubjectIndicator;
	}

	public String getOwnedPropertyDispositionStatusType() {
		return ownedPropertyDispositionStatusType;
	}

	public void setOwnedPropertyDispositionStatusType(String ownedPropertyDispositionStatusType) {
		this.ownedPropertyDispositionStatusType = ownedPropertyDispositionStatusType;
	}

	public BigDecimal getOwnedPropertyLienUPBAmount() {
		return ownedPropertyLienUPBAmount;
	}

	public void setOwnedPropertyLienUPBAmount(String ownedPropertyLienUPBAmount) {
		this.ownedPropertyLienUPBAmount = new BigDecimal(ownedPropertyLienUPBAmount);
	}

	public BigDecimal getOwnedPropertyMaintenanceExpenseAmount() {
		return ownedPropertyMaintenanceExpenseAmount;
	}

	public void setOwnedPropertyMaintenanceExpenseAmount(String ownedPropertyMaintenanceExpenseAmount) {
		this.ownedPropertyMaintenanceExpenseAmount = new BigDecimal(ownedPropertyMaintenanceExpenseAmount);
	}

	public BigDecimal getOwnedPropertyRentalIncomeGrossAmount() {
		return ownedPropertyRentalIncomeGrossAmount;
	}

	public void setOwnedPropertyRentalIncomeGrossAmount(String ownedPropertyRentalIncomeGrossAmount) {
		this.ownedPropertyRentalIncomeGrossAmount = new BigDecimal(ownedPropertyRentalIncomeGrossAmount);
	}

	public BigDecimal getOwnedPropertyRentalIncomeNetAmount() {
		return ownedPropertyRentalIncomeNetAmount;
	}

	public void setOwnedPropertyRentalIncomeNetAmount(String ownedPropertyRentalIncomeNetAmount) {
		this.ownedPropertyRentalIncomeNetAmount = new BigDecimal(ownedPropertyRentalIncomeNetAmount);
	}

	public String getPropertyCurrentUsageType() {
		return propertyCurrentUsageType;
	}

	public void setPropertyCurrentUsageType(String propertyCurrentUsageType) {
		this.propertyCurrentUsageType = propertyCurrentUsageType;
	}
	
}
