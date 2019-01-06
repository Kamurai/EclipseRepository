package information.dU34.Mes.DeaSet.Dea.Loa.MIDat;

import java.math.BigDecimal;

public class MI_Data_Detail {
	BigDecimal MICoveragePercent;
	
	public MI_Data_Detail(){}

	public BigDecimal getMICoveragePercent() {
		return MICoveragePercent;
	}

	public void setMICoveragePercent(String mICoveragePercent) {
		MICoveragePercent = new BigDecimal(mICoveragePercent);
	}
}
