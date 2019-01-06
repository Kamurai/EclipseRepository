package information.dU34.Mes.DeaSet.Dea.Loa;

import java.math.BigDecimal;

public class Qualification {
	BigDecimal QualifyingRatePercent;

	public Qualification(){}

	public BigDecimal getQualifyingRatePercent() {
		return QualifyingRatePercent;
	}

	public void setQualifyingRatePercent(String qualifyingRatePercent) {
		QualifyingRatePercent = new BigDecimal(qualifyingRatePercent);
	}
}
