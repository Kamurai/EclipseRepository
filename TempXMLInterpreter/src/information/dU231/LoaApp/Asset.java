package information.dU231.LoaApp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Asset 
{
	String borrowerID;
	String accountIdentifier;
	BigDecimal cashOrMarketValueAmount;
	String type; //Enumeration
	Boolean verifiedIndicator;
	String holderName;
	String holderStreetAddress;
	String holderCity;
	String holderState;
	String holderPostalCode;
	String automobileMakeDescription;
	LocalDateTime AutomobileModelYear;
	BigDecimal LifeInsuranceFaceValueAmount;
	String OtherAssetTypeDescription;
	Integer StockBondMutualFundShareCount;
	
	public Asset()
	{}
}
