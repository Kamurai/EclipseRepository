package information.dU34.Mes.DeaSet.Dea.Loa;

import java.math.BigDecimal;

public class Affordable_Lending {
	String communityLendingProductType; //Enumeration
	String communitySecondsRepaymentType; //Enumeration
	BigDecimal hUDIncomeLimitAdjustmentPercent;

	public Affordable_Lending(){}

	public String getCommunityLendingProductType() {
		return communityLendingProductType;
	}

	public void setCommunityLendingProductType(String communityLendingProductType) {
		this.communityLendingProductType = communityLendingProductType;
	}

	public String getCommunitySecondsRepaymentType() {
		return communitySecondsRepaymentType;
	}

	public void setCommunitySecondsRepaymentType(String communitySecondsRepaymentType) {
		this.communitySecondsRepaymentType = communitySecondsRepaymentType;
	}

	public BigDecimal getHUDIncomeLimitAdjustmentPercent() {
		return hUDIncomeLimitAdjustmentPercent;
	}

	public void setHUDIncomeLimitAdjustmentPercent(String hUDIncomeLimitAdjustmentPercent) {
		this.hUDIncomeLimitAdjustmentPercent = new BigDecimal(hUDIncomeLimitAdjustmentPercent);
	}
}
