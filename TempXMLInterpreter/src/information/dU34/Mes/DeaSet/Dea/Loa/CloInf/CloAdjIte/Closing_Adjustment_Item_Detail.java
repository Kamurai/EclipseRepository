package information.dU34.Mes.DeaSet.Dea.Loa.CloInf.CloAdjIte;

import java.math.BigDecimal;

public class Closing_Adjustment_Item_Detail {
	BigDecimal closingAdjustmentItemAmount;
	String closingAdjustmentItemType; //Enumeration

	public Closing_Adjustment_Item_Detail(){}

	public BigDecimal getClosingAdjustmentItemAmount() {
		return closingAdjustmentItemAmount;
	}

	public void setClosingAdjustmentItemAmount(String closingAdjustmentItemAmount) {
		this.closingAdjustmentItemAmount = new BigDecimal(closingAdjustmentItemAmount);
	}

	public String getClosingAdjustmentItemType() {
		return closingAdjustmentItemType;
	}

	public void setClosingAdjustmentItemType(String closingAdjustmentItemType) {
		this.closingAdjustmentItemType = closingAdjustmentItemType;
	}
}
