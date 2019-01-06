package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Terms_of_Mortgage {
	BigDecimal disclosedIndexRatePercent;
	String lienPriorityType; //Enumeration
	String loanPurposeType; //Enumeration
	String mortgageType; //Enumeration
	String mortgageTypeOtherDescription;
	BigDecimal noteAmount;
	LocalDateTime noteDate;
	
	public Terms_of_Mortgage(){}
}
