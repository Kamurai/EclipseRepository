package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloInf;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Closing_Information_Detail {
	BigDecimal CashFromBorrowerAtClosingAmount;
	BigDecimal CashFromSellerAtClosingAmount;
	BigDecimal CashToBorrowerAtClosingAmount;
	BigDecimal CashToSellerAtClosingAmount;
	String ClosingAgentOrderNumberIdentifier;
	LocalDateTime closingDate;
	LocalDateTime currentRateSetDate;
	LocalDateTime disbursementDate;

	public Closing_Information_Detail(){}
}
