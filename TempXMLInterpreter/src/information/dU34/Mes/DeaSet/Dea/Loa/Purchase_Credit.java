package information.dU34.Mes.DeaSet.Dea.Loa;

import java.math.BigDecimal;

public class Purchase_Credit {
	BigDecimal purchaseCreditAmount;
	String purchaseCreditType; //Enumeration
	String purchaseCreditTypeOtherDescription; //Enumeration

	public Purchase_Credit(){}

	public BigDecimal getPurchaseCreditAmount() {
		return purchaseCreditAmount;
	}

	public void setPurchaseCreditAmount(String purchaseCreditAmount) {
		this.purchaseCreditAmount = new BigDecimal(purchaseCreditAmount);
	}

	public String getPurchaseCreditType() {
		return purchaseCreditType;
	}

	public void setPurchaseCreditType(String purchaseCreditType) {
		this.purchaseCreditType = purchaseCreditType;
	}

	public String getPurchaseCreditTypeOtherDescription() {
		return purchaseCreditTypeOtherDescription;
	}

	public void setPurchaseCreditTypeOtherDescription(String purchaseCreditTypeOtherDescription) {
		this.purchaseCreditTypeOtherDescription = purchaseCreditTypeOtherDescription;
	}
}
