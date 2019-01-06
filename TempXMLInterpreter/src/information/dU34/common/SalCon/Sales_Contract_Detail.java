package information.dU34.common.SalCon;

import java.math.BigDecimal;

public class Sales_Contract_Detail {
	BigDecimal salesContractAmount;

	public Sales_Contract_Detail(){}

	public BigDecimal getSalesContractAmount() {
		return salesContractAmount;
	}

	public void setSalesContractAmount(String salesContractAmount) {
		this.salesContractAmount = new BigDecimal(salesContractAmount);
	}
}
