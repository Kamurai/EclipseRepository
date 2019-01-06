package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj.IntRatAdj;

import java.math.BigDecimal;

public class Interest_Rate_Per_Change_Adjustment_Rule {
	String adjustmentRuleType; //Enumeration
	BigDecimal perChangeMaximumIncreaseRatePercent;
	Integer perChangeRateAdjustmentFrequencyMonthsCount;
	
	public Interest_Rate_Per_Change_Adjustment_Rule(){}

	public String getAdjustmentRuleType() {
		return adjustmentRuleType;
	}

	public void setAdjustmentRuleType(String adjustmentRuleType) {
		this.adjustmentRuleType = adjustmentRuleType;
	}

	public BigDecimal getPerChangeMaximumIncreaseRatePercent() {
		return perChangeMaximumIncreaseRatePercent;
	}

	public void setPerChangeMaximumIncreaseRatePercent(String perChangeMaximumIncreaseRatePercent) {
		this.perChangeMaximumIncreaseRatePercent = new BigDecimal(perChangeMaximumIncreaseRatePercent);
	}

	public Integer getPerChangeRateAdjustmentFrequencyMonthsCount() {
		return perChangeRateAdjustmentFrequencyMonthsCount;
	}

	public void setPerChangeRateAdjustmentFrequencyMonthsCount(String perChangeRateAdjustmentFrequencyMonthsCount) {
		this.perChangeRateAdjustmentFrequencyMonthsCount = new Integer(perChangeRateAdjustmentFrequencyMonthsCount);
	}

}
