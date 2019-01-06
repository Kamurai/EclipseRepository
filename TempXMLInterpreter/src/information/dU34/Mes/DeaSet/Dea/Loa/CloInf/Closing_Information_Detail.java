package information.dU34.Mes.DeaSet.Dea.Loa.CloInf;

import java.math.BigDecimal;

public class Closing_Information_Detail {
	BigDecimal cashFromBorrowerAtClosingAmount;
	BigDecimal cashToBorrowerAtClosingAmount;

	public Closing_Information_Detail(){}

	public BigDecimal getCashFromBorrowerAtClosingAmount() {
		return cashFromBorrowerAtClosingAmount;
	}

	public void setCashFromBorrowerAtClosingAmount(String cashFromBorrowerAtClosingAmount) {
		this.cashFromBorrowerAtClosingAmount = new BigDecimal(cashFromBorrowerAtClosingAmount);
	}

	public BigDecimal getCashToBorrowerAtClosingAmount() {
		return cashToBorrowerAtClosingAmount;
	}

	public void setCashToBorrowerAtClosingAmount(String cashToBorrowerAtClosingAmount) {
		this.cashToBorrowerAtClosingAmount = new BigDecimal(cashToBorrowerAtClosingAmount);
	}
}
