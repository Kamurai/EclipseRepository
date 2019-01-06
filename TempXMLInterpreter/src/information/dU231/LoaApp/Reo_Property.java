package information.dU231.LoaApp;

import java.math.BigDecimal;

public class Reo_Property 
{
	String rEO_ID;
	String borrowerID;
	String liabilityID;
	String streetAddress;
	String city;
	String state;
	String postalCode;
	boolean currentResidenceIndicator;
	String dispositionStatusType; //Enumeration
	String gSEPropertyType; //Enumeration
	BigDecimal lienInstallmentAmount;
	BigDecimal lienUPBAmount;
	BigDecimal maintenanceExpenseAmount;
	BigDecimal marketValueAmount;
	BigDecimal rentalIncomeGrossAmount;
	BigDecimal rentalIncomeNetAmount;
	boolean subjectIndicator;

	public Reo_Property()
	{}
}
