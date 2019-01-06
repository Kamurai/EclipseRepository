package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.FeeInf.FeeP;

import java.math.BigDecimal;

public class Fee_Detail {
	String displayLabelText;
	BigDecimal FeeActualTotalAmount;
	String feePaidToType; //Enumeration
	String feePaidToTypeOtherDescription; //Enumeration
	String feePercentBasisType; //Enumeration
	BigDecimal FeeTotalPercent;
	String feeType; //Enumeration
	String feeTypeOtherDescription;
	String integratedDisclosureSectionType; //Enumeration
	boolean optionalCostIndicator;
	boolean  regulationZPointsAndFeesIndicator;

	public Fee_Detail(){}
}
