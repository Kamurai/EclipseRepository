package information.dU231;
import java.util.ArrayList;
import java.util.List;  
 
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;

import information.FileObject;
import information.dU231.LoaApp.Additional_Case_Data;
import information.dU231.LoaApp.Affordable_Lending;
import information.dU231.LoaApp.Asset;
import information.dU231.LoaApp.Borrower;
import information.dU231.LoaApp.Data_Information;
import information.dU231.LoaApp.Down_Payment;
import information.dU231.LoaApp.Government_Loan;
import information.dU231.LoaApp.Government_Reporting;
import information.dU231.LoaApp.Interviewer_Information;
import information.dU231.LoaApp.Liability;
import information.dU231.LoaApp.Loan_Detail;
import information.dU231.LoaApp.Loan_Product_Data;
import information.dU231.LoaApp.Loan_Purpose;
import information.dU231.LoaApp.Loan_Qualification;
import information.dU231.LoaApp.Mortgage_Terms;
import information.dU231.LoaApp.Property;
import information.dU231.LoaApp.Proposed_Housing_Expense;
import information.dU231.LoaApp.Reo_Property;
import information.dU231.LoaApp.Title_Holder;
import information.dU231.LoaApp.Transaction_Detail;  

@XmlRootElement
public class LoanApplication extends FileObject
{
	String MISMOReferenceModelIdentifier;
	String MISMOVersionID;
	Data_Information dataInformation;
	Additional_Case_Data addtionalCaseData;
	Affordable_Lending affordableLending;
	List<Asset> asset;
	List<Down_Payment> downPayment;
	Government_Loan governmentLoan;
	Government_Reporting governmentReporting;
	Interviewer_Information interviewerInformation;
	List<Liability> liability;
	Loan_Detail loanDetail;
	Loan_Product_Data loanProductData;
	Loan_Purpose loanPurpose;
	Loan_Qualification loanQualification;
	Mortgage_Terms mortgageTerms;
	Property property;
	List<Proposed_Housing_Expense> proposedHousingExpense;
	List<Reo_Property> reoProperty;
	List<Title_Holder> titleHolder;
	Transaction_Detail transactionDetail;
	List<Borrower> borrower;
	
	
	public LoanApplication()
	{}
		
}
