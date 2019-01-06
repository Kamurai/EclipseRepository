package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Buy;

import java.math.BigDecimal;

public class Buydown_Occurrence {
	BigDecimal BuydownInitialEffectiveInterestRatePercent;
 
	public Buydown_Occurrence(){}

	public BigDecimal getBuydownInitialEffectiveInterestRatePercent() {
		return BuydownInitialEffectiveInterestRatePercent;
	}
	
	public void setBuydownInitialEffectiveInterestRatePercent(String buydownInitialEffectiveInterestRatePercent) {
		BuydownInitialEffectiveInterestRatePercent = new BigDecimal(buydownInitialEffectiveInterestRatePercent);
	}
}
