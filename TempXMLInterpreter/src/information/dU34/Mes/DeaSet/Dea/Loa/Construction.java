package information.dU34.Mes.DeaSet.Dea.Loa;

import java.math.BigDecimal;

public class Construction {
	BigDecimal constructionImprovementCostsAmount;
	String constructionToPermanentClosingType; //Enumeration
	String constructionLoanType; //Enumeration
	BigDecimal landAppraisedValueAmount;
	BigDecimal landOriginalCostAmount;

	public Construction(){}

	public BigDecimal getConstructionImprovementCostsAmount() {
		return constructionImprovementCostsAmount;
	}

	public void setConstructionImprovementCostsAmount(String constructionImprovementCostsAmount) {
		this.constructionImprovementCostsAmount = new BigDecimal(constructionImprovementCostsAmount);
	}

	public String getConstructionToPermanentClosingType() {
		return constructionToPermanentClosingType;
	}

	public void setConstructionToPermanentClosingType(String constructionToPermanentClosingType) {
		this.constructionToPermanentClosingType = constructionToPermanentClosingType;
	}

	public BigDecimal getLandAppraisedValueAmount() {
		return landAppraisedValueAmount;
	}

	public void setLandAppraisedValueAmount(String landAppraisedValueAmount) {
		this.landAppraisedValueAmount = new BigDecimal(landAppraisedValueAmount);
	}

	public BigDecimal getLandOriginalCostAmount() {
		return landOriginalCostAmount;
	}

	public void setLandOriginalCostAmount(String landOriginalCostAmount) {
		this.landOriginalCostAmount = new BigDecimal(landOriginalCostAmount);
	}

	public String getConstructionLoanType() {
		return constructionLoanType;
	}

	public void setConstructionLoanType(String constructionLoanType) {
		this.constructionLoanType = constructionLoanType;
	}
}
