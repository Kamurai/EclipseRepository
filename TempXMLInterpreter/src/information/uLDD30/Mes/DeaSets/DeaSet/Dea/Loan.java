package information.uLDD30.Mes.DeaSets.DeaSet.Dea;

import java.util.ArrayList;
import java.util.List;

import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Amortization;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Buydown;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Closing_Information;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.HMDA_Loan;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Interest_Calculation;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Interest_Only;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Investor_Feature;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Investor_Loan_Information;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.LTV;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Loan_Comment;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Loan_Detail;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Loan_Identifier;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Loan_Level_Credit;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Loan_Program;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Loan_State;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.MI_Data;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Maturity;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Modification;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Payment;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Qualification;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Refinance;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Selected_Loan_Product;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Servicing;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Terms_of_Mortgage;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Underwriting;

public class Loan 
{
	String loanRoleType; //Enumeration
	Amortization amortization;
	Buydown buydown;
	Closing_Information closing_Information;
	HMDA_Loan hMDA_Loan;
	Interest_Calculation interest_Calculation;
	Interest_Only interest_Only;
	List<Investor_Feature> investor_Features;
	Investor_Loan_Information investor_Loan_Information;
	List<Loan_Comment> loan_Comments;
	Loan_Detail loan_Detail;
	List<Loan_Identifier> loan_Identifiers;
	Loan_Level_Credit loan_Level_Credit;
	List<Loan_Program> loan_Programs;
	Loan_State loan_State;
	LTV lTV;
	Maturity maturity;
	MI_Data mI_Data;
	List<Modification> modifications;
	Payment payment;
	Qualification qualification;
	Refinance refinance;
	Selected_Loan_Product selected_Loan_Product;
	Servicing servicing;
	Terms_of_Mortgage terms_of_Mortgage;
	Underwriting underwriting;
	
	public Loan()
	{
		
	}
}
