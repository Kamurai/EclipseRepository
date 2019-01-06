package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res.Lan;

import java.math.BigDecimal;

public class Landlord_Detail {
	BigDecimal monthlyRentAmount;
	
	public Landlord_Detail(){}

	public BigDecimal getMonthlyRentAmount() {
		return monthlyRentAmount;
	}

	public void setMonthlyRentAmount(String monthlyRentAmount) {
		this.monthlyRentAmount = new BigDecimal(monthlyRentAmount);
	}
}
