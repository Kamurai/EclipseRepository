package information.dU34.Mes.DeaSet.Dea.Loa.Adj.IntRatAdj;

import java.math.BigDecimal;

public class Interest_Rate_Lifetime_Adjustment_Rule {
	BigDecimal ceilingRatePercent;
	BigDecimal marginRatePercent;

	public Interest_Rate_Lifetime_Adjustment_Rule(){}

	public BigDecimal getCeilingRatePercent() {
		return ceilingRatePercent;
	}

	public void setCeilingRatePercent(String ceilingRatePercent) {
		this.ceilingRatePercent = new BigDecimal(ceilingRatePercent);
	}

	public BigDecimal getMarginRatePercent() {
		return marginRatePercent;
	}

	public void setMarginRatePercent(String marginRatePercent) {
		this.marginRatePercent = new BigDecimal(marginRatePercent);
	}
}
