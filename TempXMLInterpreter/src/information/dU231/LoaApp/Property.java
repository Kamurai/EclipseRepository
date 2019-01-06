package information.dU231.LoaApp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import information.dU231.LoaApp.Pro.FNM;
import information.dU231.LoaApp.Pro.Legal_Description;
import information.dU231.LoaApp.Pro.ParsedStreetAddress;
import information.dU231.LoaApp.Pro.Valuation;

public class Property 
{
	String buildingStatusType; //Enumeration
	Integer fNMBuildingStoriesCount;
	String fNMPropertyLocationType; //Enumeration
	String fNMPropertyUseType; //Enumeration
	String fNMPropertyUseTypeOtherDescription;
	String fNMPropertyZoningType; //Enumeration
	String fNMPropertyZoningTypeOtherDescription;
	Integer fNMImprovedLivingAreaSquareFeetNumber;
	String streetAddress;
	String 	streetAddress2;
	String city;
	String state;
	String county;
	String postalCode;
	Integer financedNumberOfUnits;
	LocalDateTime structureBuiltYear;
	LocalDateTime acquiredDate;
	Boolean plannedUnitDevelopment;
	Integer acreageNumber;
	
	ParsedStreetAddress parsedStreetAddress;
	Legal_Description legal_Description;
	Valuation valuation;
	FNM fNM;

	
	public Property()
	{}
}
