package information.dU231.LoaApp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import information.dU231.LoaApp.Bor.Alias;
import information.dU231.LoaApp.Bor.Contact_Point;
import information.dU231.LoaApp.Bor.Current_Income;
import information.dU231.LoaApp.Bor.Declaration;
import information.dU231.LoaApp.Bor.Dependent;
import information.dU231.LoaApp.Bor.Employer;
import information.dU231.LoaApp.Bor.FHA_VA_Borrower;
import information.dU231.LoaApp.Bor.Government_Monitoring;
import information.dU231.LoaApp.Bor.Mail_To;
import information.dU231.LoaApp.Bor.Present_Housing_Expense;
import information.dU231.LoaApp.Bor.Residence;
import information.dU231.LoaApp.Bor.Summary;
import information.dU231.LoaApp.Bor.VA_Borrower;
import information.dU231.LoaApp.Bor.GovMon.GovMonExt.HMDA_Race;


public class Borrower 
{
	String borrowerID;
	String jointAssetBorrowerID;
	String firstName;
	String lastName;
	String middleName;
	String nameSuffix;
	Integer ageAtAppicationYears;
	LocalDateTime birthDate;
	LocalDateTime applicationSignedDate;
	String homeTelephoneNumber;
	String printPositionType; //Enumeration
	String ssn;
	Integer dependentCount;
	String jointAssetLiabilityReportingType; //Enumeration
	String maritalStatusType; //Enumeration
	String schoolingYears;
	String creditReportIdentifier;
	List<Contact_Point> contact_point;
	List<Alias> alias;
	List<Residence> residence;
	Mail_To mail_to;
	List<Current_Income> current_income;
	List<Declaration> declaration;
	List<Dependent> dependent;
	List<Employer> employer;
	List<FHA_VA_Borrower> fha_va_borrower;
	List<Government_Monitoring> government_monitoring;
	List<HMDA_Race> hmda_race;
	List<Present_Housing_Expense> present_housing_expense;
	List<Summary> summary;
	List<VA_Borrower> va_borrower;
	
	public Borrower()
	{}	
}
