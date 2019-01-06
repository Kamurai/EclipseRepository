package information.dU34.Mes.DeaSet.Dea.Loa;

import java.math.BigDecimal;

public class Housing_Expense {
	BigDecimal housingExpensePaymentAmount;
	String housingExpenseTimingType; //Enumeration
	String housingExpenseType; //Enumeration

	public Housing_Expense(){}

	public BigDecimal getHousingExpensePaymentAmount() {
		return housingExpensePaymentAmount;
	}

	public void setHousingExpensePaymentAmount(String housingExpensePaymentAmount) {
		this.housingExpensePaymentAmount = new BigDecimal(housingExpensePaymentAmount);
	}

	public String getHousingExpenseTimingType() {
		return housingExpenseTimingType;
	}

	public void setHousingExpenseTimingType(String housingExpenseTimingType) {
		this.housingExpenseTimingType = housingExpenseTimingType;
	}

	public String getHousingExpenseType() {
		return housingExpenseType;
	}

	public void setHousingExpenseType(String housingExpenseType) {
		this.housingExpenseType = housingExpenseType;
	}
}
