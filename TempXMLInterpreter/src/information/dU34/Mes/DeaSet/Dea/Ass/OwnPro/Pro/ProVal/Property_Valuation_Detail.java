package information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.ProVal;

import java.math.BigDecimal;

public class Property_Valuation_Detail {
	BigDecimal PropertyValuationAmount;
	
	public Property_Valuation_Detail(){}
	
	public BigDecimal getPropertyValuationAmount() {
		return PropertyValuationAmount;
	}

	public void setPropertyValuationAmount(String propertyValuationAmount) {
		PropertyValuationAmount = new BigDecimal(propertyValuationAmount);
	}
}
