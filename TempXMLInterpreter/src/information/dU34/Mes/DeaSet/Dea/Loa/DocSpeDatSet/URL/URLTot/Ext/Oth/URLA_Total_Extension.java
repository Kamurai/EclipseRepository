package information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL.URLTot.Ext.Oth;

import java.math.BigDecimal;

public class URLA_Total_Extension {
	BigDecimal uRLATotalSellerCreditsAmount;
	
	public URLA_Total_Extension(){}

	public BigDecimal getURLATotalSellerCreditsAmount() {
		return uRLATotalSellerCreditsAmount;
	}

	public void setURLATotalSellerCreditsAmount(String uRLATotalSellerCreditsAmount) {
		this.uRLATotalSellerCreditsAmount = new BigDecimal(uRLATotalSellerCreditsAmount);
	}
}
