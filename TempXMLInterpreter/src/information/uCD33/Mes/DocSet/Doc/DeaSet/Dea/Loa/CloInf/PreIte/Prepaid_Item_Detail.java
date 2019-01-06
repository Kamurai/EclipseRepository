package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloInf.PreIte;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Prepaid_Item_Detail {
	String displayLabelText;
	String feePaidToType; //Enumeration
	String feePaidToTypeOtherDescription; //Enumeration
	String integratedDisclosureSectionType; //Enumeration
	Integer PrepaidItemMonthsPaidCount;
	LocalDateTime prepaidItemPaidFromDate;
	LocalDateTime prepaidItemPaidThroughDate;
	BigDecimal PrepaidItemPerDiemAmount;
	String prepaidItemPerDiemCalculationMethodType; //Enumeration
	String prepaidItemType; //Enumeration
	String PrepaidItemTypeOtherDescription;
	Boolean regulationZPointsAndFeesIndicator;

	public Prepaid_Item_Detail(){}
}
