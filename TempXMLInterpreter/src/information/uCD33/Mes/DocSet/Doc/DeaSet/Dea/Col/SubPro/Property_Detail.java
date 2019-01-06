package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Col.SubPro;

import java.math.BigDecimal;

public class Property_Detail {
	BigDecimal propertyEstimatedValueAmount;

	public Property_Detail(){}

	public BigDecimal getPropertyEstimatedValueAmount() {
		return propertyEstimatedValueAmount;
	}

	public void setPropertyEstimatedValueAmount(String propertyEstimatedValueAmount) {
		this.propertyEstimatedValueAmount = new BigDecimal(propertyEstimatedValueAmount);
	}
}
