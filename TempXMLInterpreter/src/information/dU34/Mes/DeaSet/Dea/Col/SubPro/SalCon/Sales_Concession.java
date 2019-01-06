package information.dU34.Mes.DeaSet.Dea.Col.SubPro.SalCon;

import java.math.BigDecimal;

public class Sales_Concession {
	BigDecimal salesConcessionAmount;
	
	public Sales_Concession(){}

	public BigDecimal getSalesConcessionAmount() {
		return salesConcessionAmount;
	}

	public void setSalesConcessionAmount(String salesConcessionAmount) {
		this.salesConcessionAmount = new BigDecimal(salesConcessionAmount);
	}
}
