package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea;

import java.util.ArrayList;
import java.util.List;

import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adjustment;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Amortization;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Buydown;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Closing_Information;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Construction;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Document_Specific_Data_Set;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Escrow;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Fee_Information;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Foreclosure;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.High_Cost_Mortgage;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Interest_Only;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Late_Charge;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Loan_Detail;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Loan_Identifier;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Loan_Product;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.MI_Data;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Maturity;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Negative_Amortization;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Payment;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Prepayment_Penalty;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Qualified_Mortgage;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Qualified_Mortgage_Detail;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Refinance;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Terms_of_Loan;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Underwriting;

public class Loan {
	Adjustment adjustment;
	Amortization amortization;
	Buydown buydown;
	Closing_Information closing_Information;
	Construction construction;
	List<Document_Specific_Data_Set> document_Specific_Data_Sets;
	Escrow escrow;
	Fee_Information fee_Information;
	List<Foreclosure> foreclosures;
	List<High_Cost_Mortgage> high_Cost_Mortgages;
	Interest_Only interest_Only;
	Late_Charge late_Charge;
	Loan_Detail loan_Detail;
	List<Loan_Identifier> loan_Identifiers;
	Loan_Product loan_Product;
	Maturity maturity;
	MI_Data mI_Data;
	Negative_Amortization negative_Amortization;
	Payment payment;
	Prepayment_Penalty prepayment_Penalty;
	Qualified_Mortgage qualified_Mortgage;
	Qualified_Mortgage_Detail qualified_Mortgage_Detail;
	Refinance refinance;
	Terms_of_Loan terms_of_Loan;
	Underwriting underwriting;
		
	public Loan(){}
}
