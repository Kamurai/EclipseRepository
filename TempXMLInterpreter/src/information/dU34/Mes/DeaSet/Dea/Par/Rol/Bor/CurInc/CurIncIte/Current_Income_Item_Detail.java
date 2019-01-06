package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.CurInc.CurIncIte;

import java.math.BigDecimal;

public class Current_Income_Item_Detail {
	BigDecimal currentIncomeMonthlyTotalAmount;
	Boolean employmentIncomeIndicator;
	String incomeType; //Enumeration
	String incomeTypeOtherDescription;
	
	public Current_Income_Item_Detail(){}

	public BigDecimal getCurrentIncomeMonthlyTotalAmount() {
		return currentIncomeMonthlyTotalAmount;
	}

	public void setCurrentIncomeMonthlyTotalAmount(String currentIncomeMonthlyTotalAmount) {
		this.currentIncomeMonthlyTotalAmount = new BigDecimal(currentIncomeMonthlyTotalAmount);
	}

	public Boolean getEmploymentIncomeIndicator() {
		return employmentIncomeIndicator;
	}

	public void setEmploymentIncomeIndicator(Boolean employmentIncomeIndicator) {
		this.employmentIncomeIndicator = employmentIncomeIndicator;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public String getIncomeTypeOtherDescription() {
		return incomeTypeOtherDescription;
	}

	public void setIncomeTypeOtherDescription(String incomeTypeOtherDescription) {
		this.incomeTypeOtherDescription = incomeTypeOtherDescription;
	}	
}
