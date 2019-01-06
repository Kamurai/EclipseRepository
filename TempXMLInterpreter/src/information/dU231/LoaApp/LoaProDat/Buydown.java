package information.dU231.LoaApp.LoaProDat;

import java.math.BigDecimal;

public class Buydown 
{
	String baseDateType;
	Integer changeFrequencyMonths;
	String contributorType; //Enumeration
	Integer durationMonths;
	BigDecimal increaseRatePercent;
	Boolean lenderFundingIndicator;
	Boolean permanentIndicator;

	public Buydown()
	{}
}
