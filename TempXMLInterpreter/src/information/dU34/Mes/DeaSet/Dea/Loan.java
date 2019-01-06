package information.dU34.Mes.DeaSet.Dea;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Loa.Adjustment;
import information.dU34.Mes.DeaSet.Dea.Loa.Affordable_Lending;
import information.dU34.Mes.DeaSet.Dea.Loa.Amortization;
import information.dU34.Mes.DeaSet.Dea.Loa.Buydown;
import information.dU34.Mes.DeaSet.Dea.Loa.Closing_Information;
import information.dU34.Mes.DeaSet.Dea.Loa.Construction;
import information.dU34.Mes.DeaSet.Dea.Loa.Document_Specific_Data_Set;
import information.dU34.Mes.DeaSet.Dea.Loa.Extension;
import information.dU34.Mes.DeaSet.Dea.Loa.Government_Loan;
import information.dU34.Mes.DeaSet.Dea.Loa.HELOC;
import information.dU34.Mes.DeaSet.Dea.Loa.HMDA_Loan;
import information.dU34.Mes.DeaSet.Dea.Loa.Housing_Expense;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Investor_Feature;
import information.dU34.Mes.DeaSet.Dea.Loa.Investor_Loan_Information;
import information.dU34.Mes.DeaSet.Dea.Loa.Loan_Detail;
import information.dU34.Mes.DeaSet.Dea.Loa.Loan_Product;
import information.dU34.Mes.DeaSet.Dea.Loa.MI_Data;
import information.dU34.Mes.DeaSet.Dea.Loa.Maturity;
import information.dU34.Mes.DeaSet.Dea.Loa.Negative_Amortization;
import information.dU34.Mes.DeaSet.Dea.Loa.Origination_Fund;
import information.dU34.Mes.DeaSet.Dea.Loa.Payment;
import information.dU34.Mes.DeaSet.Dea.Loa.Prepayment_Penalty;
import information.dU34.Mes.DeaSet.Dea.Loa.Purchase_Credit;
import information.dU34.Mes.DeaSet.Dea.Loa.Qualification;
import information.dU34.Mes.DeaSet.Dea.Loa.Refinance;
import information.dU34.Mes.DeaSet.Dea.Loa.Terms_Of_Loan;
import information.dU34.Mes.DeaSet.Dea.Loa.Underwriting;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Interest_Only;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Loan_Identifier;

public class Loan implements ArrayListOwner {
	//Attributes
	String LoanRoleType; //Enumeration
	String xlinklabel;
	//Elements
	Adjustment adjustment;
	Affordable_Lending affordable_Lending;
	Amortization amortization;
	Buydown buydown;
	Closing_Information closing_Information;
	Construction construction;
	List<Document_Specific_Data_Set> document_Specific_Data_Sets;
	Government_Loan government_Loan;
	HELOC hELOC;
	HMDA_Loan hMDA_Loan;
	List<Housing_Expense> housing_Expenses;
	Interest_Only interest_Only;
	List<Investor_Feature> investor_Features;
	Investor_Loan_Information investor_Loan_Information;
	Loan_Detail loan_Detail;
	List<Loan_Identifier> loan_Identifiers;
	Loan_Product loan_Product;
	Maturity maturity;
	MI_Data mI_Data;
	Negative_Amortization negative_Amortization;
	List<Origination_Fund> origination_Funds;
	Payment payment;
	Prepayment_Penalty prepayment_Penalty;
	List<Purchase_Credit> purchase_Credits;
	Qualification qualification;
	Refinance refinance;
	Terms_Of_Loan terms_Of_Loan;
	Underwriting underwriting;
	Extension extension;
	
	public Loan(){
		adjustment = new Adjustment();
		affordable_Lending = new Affordable_Lending();
		amortization = new Amortization();
		buydown = new Buydown();
		closing_Information = new Closing_Information();
		construction = new Construction();
		document_Specific_Data_Sets = new ArrayList<Document_Specific_Data_Set>();
		government_Loan = new Government_Loan();
		hELOC = new HELOC();
		hMDA_Loan = new HMDA_Loan();
		housing_Expenses = new ArrayList<Housing_Expense>();
		interest_Only = new Interest_Only();
		investor_Features = new ArrayList<Investor_Feature>();
		investor_Loan_Information = new Investor_Loan_Information();
		loan_Detail = new Loan_Detail();
		loan_Identifiers = new ArrayList<Loan_Identifier>();
		loan_Product = new Loan_Product();
		maturity = new Maturity();
		mI_Data = new MI_Data();
		negative_Amortization = new Negative_Amortization();
		origination_Funds = new ArrayList<Origination_Fund>();
		payment = new Payment();
		prepayment_Penalty = new Prepayment_Penalty();
		purchase_Credits = new ArrayList<Purchase_Credit>();
		qualification = new Qualification();
		refinance = new Refinance();
		terms_Of_Loan = new Terms_Of_Loan();
		underwriting = new Underwriting();
		extension = new Extension();
	}

	public Adjustment getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(Adjustment adjustment) {
		this.adjustment = adjustment;
	}

	public Affordable_Lending getAffordable_Lending() {
		return affordable_Lending;
	}

	public void setAffordable_Lending(Affordable_Lending affordable_Lending) {
		this.affordable_Lending = affordable_Lending;
	}

	public Amortization getAmortization() {
		return amortization;
	}

	public void setAmortization(Amortization amortization) {
		this.amortization = amortization;
	}

	public Buydown getBuydown() {
		return buydown;
	}

	public void setBuydown(Buydown buydown) {
		this.buydown = buydown;
	}

	public Closing_Information getClosing_Information() {
		return closing_Information;
	}

	public void setClosing_Information(Closing_Information closing_Information) {
		this.closing_Information = closing_Information;
	}


	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
	}

	public List<Document_Specific_Data_Set> getDocument_Specific_Data_Sets() {
		return document_Specific_Data_Sets;
	}

	public void setDocument_Specific_Data_Sets(ArrayList<Document_Specific_Data_Set> document_Specific_Data_Sets) {
		this.document_Specific_Data_Sets = document_Specific_Data_Sets;
	}

	public Government_Loan getGovernment_Loan() {
		return government_Loan;
	}

	public void setGovernment_Loan(Government_Loan government_Loan) {
		this.government_Loan = government_Loan;
	}

	public HELOC getHELOC() {
		return hELOC;
	}

	public void setHELOC(HELOC hELOC) {
		this.hELOC = hELOC;
	}

	public HMDA_Loan getHMDA_Loan() {
		return hMDA_Loan;
	}

	public void setHMDA_Loan(HMDA_Loan hMDA_Loan) {
		this.hMDA_Loan = hMDA_Loan;
	}

	public List<Housing_Expense> getHousing_Expenses() {
		return housing_Expenses;
	}

	public void setHousing_Expenses(ArrayList<Housing_Expense> housing_Expenses) {
		this.housing_Expenses = housing_Expenses;
	}

	public Interest_Only getInterest_Only() {
		return interest_Only;
	}

	public void setInterest_Only(Interest_Only interest_Only) {
		this.interest_Only = interest_Only;
	}

	public List<Investor_Feature> getInvestor_Features() {
		return investor_Features;
	}

	public void setInvestor_Features(ArrayList<Investor_Feature> investor_Features) {
		this.investor_Features = investor_Features;
	}

	public Investor_Loan_Information getInvestor_Loan_Information() {
		return investor_Loan_Information;
	}

	public void setInvestor_Loan_Information(Investor_Loan_Information investor_Loan_Information) {
		this.investor_Loan_Information = investor_Loan_Information;
	}

	public Loan_Detail getLoan_Detail() {
		return loan_Detail;
	}

	public void setLoan_Detail(Loan_Detail loan_Detail) {
		this.loan_Detail = loan_Detail;
	}

	public List<Loan_Identifier> getLoan_Identifiers() {
		return loan_Identifiers;
	}

	public void setLoan_Identifiers(ArrayList<Loan_Identifier> loan_Identifiers) {
		this.loan_Identifiers = loan_Identifiers;
	}

	public Loan_Product getLoan_Product() {
		return loan_Product;
	}

	public void setLoan_Product(Loan_Product loan_Product) {
		this.loan_Product = loan_Product;
	}

	public Maturity getMaturity() {
		return maturity;
	}

	public void setMaturity(Maturity maturity) {
		this.maturity = maturity;
	}

	public MI_Data getMI_Data() {
		return mI_Data;
	}

	public void setMI_Data(MI_Data mI_Data) {
		this.mI_Data = mI_Data;
	}

	public Negative_Amortization getNegative_Amortization() {
		return negative_Amortization;
	}

	public void setNegative_Amortization(Negative_Amortization negative_Amortization) {
		this.negative_Amortization = negative_Amortization;
	}

	public List<Origination_Fund> getOrigination_Funds() {
		return origination_Funds;
	}

	public void setOrigination_Funds(ArrayList<Origination_Fund> origination_Funds) {
		this.origination_Funds = origination_Funds;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Prepayment_Penalty getPrepayment_Penalty() {
		return prepayment_Penalty;
	}

	public void setPrepayment_Penalty(Prepayment_Penalty prepayment_Penalty) {
		this.prepayment_Penalty = prepayment_Penalty;
	}

	public List<Purchase_Credit> getPurchase_Credits() {
		return purchase_Credits;
	}

	public void setPurchase_Credits(ArrayList<Purchase_Credit> purchase_Credits) {
		this.purchase_Credits = purchase_Credits;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public Refinance getRefinance() {
		return refinance;
	}

	public void setRefinance(Refinance refinance) {
		this.refinance = refinance;
	}

	public Terms_Of_Loan getTerms_Of_Loan() {
		return terms_Of_Loan;
	}

	public void setTerms_Of_Loan(Terms_Of_Loan terms_Of_Loan) {
		this.terms_Of_Loan = terms_Of_Loan;
	}

	public Underwriting getUnderwriting() {
		return underwriting;
	}

	public void setUnderwriting(Underwriting underwriting) {
		this.underwriting = underwriting;
	}
	
	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public String getLoanRoleType() {
		return LoanRoleType;
	}

	public void setLoanRoleType(String loanRoleType) {
		LoanRoleType = loanRoleType;
	}

	public String getXlinklabel() {
		return xlinklabel;
	}

	public void setXlinklabel(String xlinklabel) {
		this.xlinklabel = xlinklabel;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Document_Specific_Data_Set")){
			result = document_Specific_Data_Sets.get(document_Specific_Data_Sets.size()-1);
		}
		else if(objectType.equals("Housing_Expense")){
			result = housing_Expenses.get(housing_Expenses.size()-1);
		}
		else if(objectType.equals("Investor_Feature")){
			result = investor_Features.get(investor_Features.size()-1);
		}
		else if(objectType.equals("Loan_Identifier")){
			result = loan_Identifiers.get(loan_Identifiers.size()-1);
		}
		else if(objectType.equals("Origination_Fund")){
			result = origination_Funds.get(origination_Funds.size()-1);
		}
		else if(objectType.equals("Purchase_Credit")){
			result = purchase_Credits.get(purchase_Credits.size()-1);
		}
		
		return result;
	}
}
