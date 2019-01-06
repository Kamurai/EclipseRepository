package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Col.SubPro.ProVal;

import java.math.BigDecimal;

public class Property_Valuation_Detail {
	String IdentifierOwnerURI;
	String AppraisalIdentifier;
	BigDecimal PropertyValuationAmount;
	String PropertyValuationMethodType; //Enumeration
	String PropertyValuationMethodTypeOtherDescription; //Enumeration

	public Property_Valuation_Detail(){}
	
	public BigDecimal getPropertyValuationAmount() {
		return PropertyValuationAmount;
	}

	public void setPropertyValuationAmount(String propertyValuationAmount) {
		PropertyValuationAmount = new BigDecimal(propertyValuationAmount);
	}

	public String getIdentifierOwnerURI() {
		return IdentifierOwnerURI;
	}

	public void setIdentifierOwnerURI(String identifierOwnerURI) {
		IdentifierOwnerURI = identifierOwnerURI;
	}

	public String getAppraisalIdentifier() {
		return AppraisalIdentifier;
	}

	public void setAppraisalIdentifier(String appraisalIdentifier) {
		AppraisalIdentifier = appraisalIdentifier;
	}

	public String getPropertyValuationMethodType() {
		return PropertyValuationMethodType;
	}

	public void setPropertyValuationMethodType(String propertyValuationMethodType) {
		PropertyValuationMethodType = propertyValuationMethodType;
	}

	public String getPropertyValuationMethodTypeOtherDescription() {
		return PropertyValuationMethodTypeOtherDescription;
	}

	public void setPropertyValuationMethodTypeOtherDescription(String propertyValuationMethodTypeOtherDescription) {
		PropertyValuationMethodTypeOtherDescription = propertyValuationMethodTypeOtherDescription;
	}

	public void setPropertyValuationAmount(BigDecimal propertyValuationAmount) {
		PropertyValuationAmount = propertyValuationAmount;
	}
}
