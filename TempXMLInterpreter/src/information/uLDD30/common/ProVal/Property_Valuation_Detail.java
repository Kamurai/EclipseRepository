package information.uLDD30.common.ProVal;

import java.math.BigDecimal;

public class Property_Valuation_Detail {
	String appraisalIdentifier;
	BigDecimal propertyValuationAmount;
	
	public Property_Valuation_Detail(){}

	public String getAppraisalIdentifier() {
		return appraisalIdentifier;
	}

	public void setAppraisalIdentifier(String appraisalIdentifier) {
		this.appraisalIdentifier = appraisalIdentifier;
	}

	public BigDecimal getPropertyValuationAmount() {
		return propertyValuationAmount;
	}

	public void setPropertyValuationAmount(String propertyValuationAmount) {
		this.propertyValuationAmount = new BigDecimal(propertyValuationAmount);
	}
}
