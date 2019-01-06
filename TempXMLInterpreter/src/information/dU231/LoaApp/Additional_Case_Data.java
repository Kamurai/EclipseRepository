package information.dU231.LoaApp;

import java.util.ArrayList;
import java.util.List;

import information.dU231.LoaApp.AddCasDat.Mortgage_Score;
import information.dU231.LoaApp.AddCasDat.Transmittal_Data;
import information.dU231.LoaApp.AddCasDat.Verification;
import information.dU231.LoaApp.DatInf.Data_Version;

public class Additional_Case_Data 
{
	String fNMConstructionType; //Enumeration
	String fNMConstructionTypeOtherDescription;
	Boolean FNMForeignNationalIndicator;
	Boolean FNMUSCitizenEmployedAbroadIndicator;
	Integer FNMTwelveMonthMortgageRolling30DaysLateCount;
	Integer FNMPropertiesFinancedByLenderCount;
	String fNMFirstLienFinancingProviderType; //Enumeration
	String fNMFirstLienFinancingProviderTypeOtherDescription;
	String fNMSubordinateLienFinancingProviderType; //Enumeration
	String FNMSubordinateLienFinancingProviderTypeOtherDescription;
	String fNMSecondLienFinancingType; //Enumeration
	String fFNMSecondLienFinancingTypeOtherDescription;
	List<Mortgage_Score> mortgage_Score;
	Transmittal_Data transmittal_Data;
	Verification verification;

	public Additional_Case_Data()
	{}
}
