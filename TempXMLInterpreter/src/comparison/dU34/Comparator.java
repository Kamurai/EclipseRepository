package comparison.dU34;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;

import information.FileObject;
import information.dU34.Message;
import information.dU34.Mes.Deal_Set;
import information.dU34.Mes.Document_Set;
import information.dU34.Mes.DeaSet.Deal;
import information.dU34.Mes.DeaSet.Dea.Asset;
import information.dU34.Mes.DeaSet.Dea.Collateral;
import information.dU34.Mes.DeaSet.Dea.Expense;
import information.dU34.Mes.DeaSet.Dea.Liability;
import information.dU34.Mes.DeaSet.Dea.Liability_Summary;
import information.dU34.Mes.DeaSet.Dea.Loan;
import information.dU34.Mes.DeaSet.Dea.Party;
import information.dU34.Mes.DeaSet.Dea.Ass.Asset_Detail;
import information.dU34.Mes.DeaSet.Dea.Ass.Asset_Holder;
import information.dU34.Mes.DeaSet.Dea.Ass.Owned_Property;
import information.dU34.Mes.DeaSet.Dea.Ass.AssDet.Extension;
import information.dU34.Mes.DeaSet.Dea.Ass.AssDet.Ext.Other;
import information.dU34.Mes.DeaSet.Dea.Ass.AssDet.Ext.Oth.Asset_Detail_Extension;
import information.dU34.Mes.DeaSet.Dea.Ass.AssHol.Name;
import information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Property;
import information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.Property_Detail;
import information.dU34.Mes.DeaSet.Dea.Col.Subject_Property;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.Location_Identifier;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.Project;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.LocIde.Census_Information;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.LocIde.FIPS_Information;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.LocIde.General_Identifier;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.Pro.Project_Detail;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.SalCon.Sales_Concession;
import information.dU34.Mes.DeaSet.Dea.Lia.Liability_Detail;
import information.dU34.Mes.DeaSet.Dea.Loa.Adjustment;
import information.dU34.Mes.DeaSet.Dea.Loa.Affordable_Lending;
import information.dU34.Mes.DeaSet.Dea.Loa.Amortization;
import information.dU34.Mes.DeaSet.Dea.Loa.Buydown;
import information.dU34.Mes.DeaSet.Dea.Loa.Closing_Information;
import information.dU34.Mes.DeaSet.Dea.Loa.Construction;
import information.dU34.Mes.DeaSet.Dea.Loa.Document_Specific_Data_Set;
import information.dU34.Mes.DeaSet.Dea.Loa.Government_Loan;
import information.dU34.Mes.DeaSet.Dea.Loa.HELOC;
import information.dU34.Mes.DeaSet.Dea.Loa.HMDA_Loan;
import information.dU34.Mes.DeaSet.Dea.Loa.Housing_Expense;
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
import information.dU34.Mes.DeaSet.Dea.Loa.Adj.Interest_Rate_Adjustment;
import information.dU34.Mes.DeaSet.Dea.Loa.Adj.IntRatAdj.Interest_Rate_Lifetime_Adjustment_Rule;
import information.dU34.Mes.DeaSet.Dea.Loa.Amo.Amortization_Rule;
import information.dU34.Mes.DeaSet.Dea.Loa.CloInf.Closing_Adjustment_Item;
import information.dU34.Mes.DeaSet.Dea.Loa.CloInf.Closing_Information_Detail;
import information.dU34.Mes.DeaSet.Dea.Loa.CloInf.CloAdjIte.Closing_Adjustment_Item_Detail;
import information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URLA;
import information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL.URLA_Detail;
import information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL.URLA_Total;
import information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL.URLTot.Ext.Oth.URLA_Total_Extension;
import information.dU34.Mes.DeaSet.Dea.Loa.Ext.Oth.Loan_Extension;
import information.dU34.Mes.DeaSet.Dea.Loa.Ext.Oth.LoaExt.Underwriting_Verification;
import information.dU34.Mes.DeaSet.Dea.Loa.HMDLoa.HMDA_Loan_Detail;
import information.dU34.Mes.DeaSet.Dea.Loa.HelOcc.HELOC_Occurence;
import information.dU34.Mes.DeaSet.Dea.Loa.HelRul.HELOC_Rule;
import information.dU34.Mes.DeaSet.Dea.Loa.LoaDet.Ext.Oth.Loan_Detail_Extension;
import information.dU34.Mes.DeaSet.Dea.Loa.LoaPro.Loan_Product_Detail;
import information.dU34.Mes.DeaSet.Dea.Loa.MIDat.MI_Data_Detail;
import information.dU34.Mes.DeaSet.Dea.Loa.Mat.Maturity_Rule;
import information.dU34.Mes.DeaSet.Dea.Loa.NegAmo.Negative_Amortization_Rule;
import information.dU34.Mes.DeaSet.Dea.Loa.Pay.Payment_Rule;
import information.dU34.Mes.DeaSet.Dea.Loa.PrePen.Prepayment_Penalty_Lifetime_Rule;
import information.dU34.Mes.DeaSet.Dea.Loa.Und.Automated_Underwriting;
import information.dU34.Mes.DeaSet.Dea.Par.Individual;
import information.dU34.Mes.DeaSet.Dea.Par.Language;
import information.dU34.Mes.DeaSet.Dea.Par.Role;
import information.dU34.Mes.DeaSet.Dea.Par.Ind.Alias;
import information.dU34.Mes.DeaSet.Dea.Par.Ind.Contact_Point;
import information.dU34.Mes.DeaSet.Dea.Par.Ind.ConPoi.Contact_Point_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Lan.Ext.Oth.Language_Extension;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Borrower;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.License;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Party_Role_Identifier;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Property_Owner;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Role_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Trust;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Bankruptcy;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Borrower_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Counseling;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Current_Income;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Declaration;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Dependent;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Employer;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Government_Borrower;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Government_Monitoring;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Military_Service;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Residence;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Ban.Bankruptcy_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Cou.Counseling_Event;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Cou.CouEve.Counseling_Event_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.CurInc.Current_Income_Item;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.CurInc.CurIncIte.Current_Income_Item_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Dec.Declaration_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Dec.Declaration_Explanation;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.Employment;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.Emp.Ext.Oth.Employment_Extension;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Contact;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.Government_Monitoring_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDA_Race;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.GovMonDet.Ext.Oth.Government_Monitoring_Detail_Extension;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDARac.HMDA_Race_Designation;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDARac.HMDARacDes.Ext.Oth.HMDA_Race_Designation_Extension;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res.Landlord;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res.Residence_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res.Lan.Landlord_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Lic.License_Detail;
import information.dU34.Mes.DocSet.Doc.Signatory;
import information.dU34.Mes.DocSet.Doc.Sig.Execution;
import information.dU34.Mes.DocSet.Doc.Sig.Exe.Execution_Detail;
import information.dU34.common.Address;
import information.dU34.common.Sales_Contract;
//import information.dU34.common.ProVal.Property_Valuation_Detail;
import information.dU34.common.SalCon.Sales_Contract_Detail;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Lia.Liability_Holder;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Interest_Only;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Loan_Identifier;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj.IntRatAdj.Index_Rule;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj.IntRatAdj.Interest_Rate_Per_Change_Adjustment_Rule;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Buy.Buydown_Occurrence;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Par.Ind.ConPoi.Contact_Point_Email;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Par.Ind.ConPoi.Contact_Point_Telephone;
import information.uCD33.common.Legal_Entity;
import information.uCD33.common.LegEnt.Legal_Entity_Detail;
import information.uLDD30.common.Property_Valuation;
import information.uLDD30.common.ProVal.Property_Valuation_Detail;
import information.uLDD30.Mes.About_Version;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Investor_Feature;
//import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Col.Pro.Property_Valuation;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Taxpayer_Identifier;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.GovMon.Ext.Oth.Government_Monitoring_Extension;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.GovMon.Ext.Oth.GovMonExt.HMDA_Ethnicity;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.GovMon.Ext.Oth.GovMonExt.HMDA_Ethnicity_Origin;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.GovMon.HMDRac.Ext.Oth.HMDRacExt.HMDA_Race_Detail;
import interpretation.dU34.Interpreter;
import output.PrintError;

public class Comparator extends comparison.Comparator {
	List<String> errorList = new ArrayList<String>();
	
	public Comparator(){}

	@Override
	public void compare(FileObject testObject, File controlFile) {   // TODO change fileobject to file, change testfile name to controlfile
		//interpret testFile (control file, golden test case)
		Interpreter interpreterDU34 = new Interpreter();
		FileObject controlObject = interpreterDU34.interpret(controlFile);
		
		//case test file and control file
		Message controlMessage = (Message) controlObject;
		Message testMessage = (Message) testObject;
		
		compareMessage(testMessage, controlMessage);

	}
	
	public List<String> getErrorList()
	{
		return errorList;		
	}
	
	private void diffObject(Object testObj, Object controlObj, String attr) {
		//exists in control
		if (controlObj != null) {
			// exists in given test case
			if (testObj != null) {
				// object is not same in test case and control
				if (!controlObj.equals(testObj)) {
					// Control and test both contain value but are different
					errorList.add(PrintError.unexpectedValue(attr,testObj.toString()));//"Expected: "+ controlAV.getCreatedDateTime().toString()+" Found value = "+testAV.getCreatedDateTime().toString());
				}
			}
			// exists in control, not in given test case
			else {
				errorList.add(PrintError.missing(attr));//"Expected: "+controlAV.getCreatedDateTime().toString()+" MESSAGE/ABOUT_VERSION/ABOUT_VERSION"+createdDateTime is missing);
			}
		}
	}
	/**
	 * 
	 * @param testList
	 * @param controlList
	 * @return
	 * returns positive 1 if control is larger than test
	 * returns 0 if control and test are same size
	 * return negative 1 if control is smaller than test
	 */
	private int cardinality(List<?> testList, List<?> controlList) {
		if (controlList.size() > testList.size())
			return 1;
		else if (controlList.size() < testList.size())
			return -1;
		else
			return 0;
		
	}
	
	private void compareMessage(Message test, Message control) {
		if (control != null) {
			compareAbout_Versions(test.getAbout_Versions(), control.getAbout_Versions());
			compareDocument_Sets(test.getDocument_Sets(), control.getDocument_Sets());
			compareDeal_Sets(test.getDeal_Sets(), control.getDeal_Sets());
		}
	}

	private void compareAbout_Versions(List<About_Version> test, List<About_Version> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareAbout_Version(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareAbout_Version(test.get(i), control.get(i));
			}
		}
			
		
	}
	private void compareAbout_Version(About_Version test, About_Version control) {
		diffCreatedDateTime(test.getCreatedDatetime(), control.getCreatedDatetime());
		
	}


	
	private void diffCreatedDateTime(LocalDateTime test, LocalDateTime control) {
		diffObject(test, control, "CreatedDatetime");
		
	}

	private void compareDocument_Sets(List<Document_Set> test, List<Document_Set> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDocument_Set(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDocument_Set(test.get(i), control.get(i));
			}
		}
	}
	private void compareDocument_Set(Document_Set test, Document_Set control) {
		if (control != null) {
			compareDocuments(test.getDocuments(), control.getDocuments());
		}
	}

	private void compareDocuments(List<information.dU34.Mes.DocSet.Document> test, List<information.dU34.Mes.DocSet.Document> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDocument(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDocument(test.get(i), control.get(i));
			}
		}
		
		
	}
	
	private void compareDocument(information.dU34.Mes.DocSet.Document test, information.dU34.Mes.DocSet.Document control) {
		if (control != null) {
			compareSignatories(test.getSignatories(), control.getSignatories());
		}
	}
	
	private void compareSignatories(List<Signatory> test, List<Signatory> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareSignatory(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareSignatory(test.get(i), control.get(i));
			}
		}
	}

	private void compareSignatory(Signatory test, Signatory control) {
		if (control != null) {
			compareExecution(test.getExecution(), control.getExecution());
		}
	}

	private void compareExecution(Execution test, Execution control) {
		if (control != null) {
			compareExecutionDetail(test.getExecution_Detail(), control.getExecution_Detail());
		}
		
	}

	private void compareExecutionDetail(Execution_Detail testExDet, Execution_Detail controlExDet) {
		diffExectionDate(testExDet.getExecutionDate(), controlExDet.getExecutionDate());
	}

	private void diffExectionDate(LocalDate testExDate, LocalDate controlExDate) {
		diffObject(testExDate, controlExDate, "ExecutionDate");
	}

	private void compareDeal_Sets(List<Deal_Set> test, List<Deal_Set> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDeal_Set(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDeal_Set(test.get(i), control.get(i));
			}
		}
		
	}
	
	
	private void compareDeal_Set(Deal_Set test, Deal_Set control) {
		if (control != null) {
			compareDeals(test.getDeals(), control.getDeals());
		}
		
	}

	private void compareDeals(List<Deal> test, List<Deal> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDeal(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDeal(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareDeal(Deal test, Deal control) {
		if (control != null) {
			compareAssets(test.getAssets(), control.getAssets());
			compareCollaterals(test.getCollaterals(), control.getCollaterals());
			compareExpenses(test.getExpenses(), control.getExpenses());
			compareLiabilities(test.getLiabilities(), control.getLiabilities());
			compareLiability_Summary(test.getLiability_Summary(), control.getLiability_Summary());
			compareLoans(test.getLoans(), control.getLoans());
			compareParties(test.getParties(), control.getParties());
		}
		
		
	}

	private void compareParties(List<Party> test, List<Party> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareParty(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareParty(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareParty(Party test, Party control) {
		if (control != null) {
			compareAddresses(test.getAddresses(), control.getAddresses());
			compareIndividual(test.getIndividual(), control.getIndividual());
			compareLanguages(test.getLanguages(), control.getLanguages());
			compareLegal_Entity(test.getLegal_Entity(), control.getLegal_Entity());
			compareRoles(test.getRoles(), control.getRoles());
			compareTaxpayer_Identifiers(test.getTaxpayer_Identifiers(), control.getTaxpayer_Identifiers());
		}
		
	}

	private void compareTaxpayer_Identifiers(List<Taxpayer_Identifier> test, List<Taxpayer_Identifier> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareTaxpayer_Identifier(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareTaxpayer_Identifier(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareTaxpayer_Identifier(Taxpayer_Identifier test, Taxpayer_Identifier control) {
		diffTaxpayerIdentifierType(test.getTaxpayerIdentifierType(), control.getTaxpayerIdentifierType());
		diffTaxpayerIdentifierValue(test.getTaxpayerIdentifierValue(), control.getTaxpayerIdentifierValue());
		
	}

	private void diffTaxpayerIdentifierType(String test, String control) {
		diffObject(test, control, "TaxpayerIdentifierType");
		
	}

	private void diffTaxpayerIdentifierValue(String test, String control) {
		diffObject(test, control, "TaxpayerIdentifierValue");
		
	}

	private void compareRoles(List<Role> test, List<Role> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareRole(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareRole(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareRole(Role test, Role control) {
		if (control != null) {
			compareBorrower(test.getBorrower(), control.getBorrower());
			compareLicenses(test.getLicenses(), control.getLicenses());
			compareParty_Role_Identifiers(test.getParty_Role_Identifiers(), control.getParty_Role_Identifiers());
			compareProperty_Owner(test.getProperty_Owner(), control.getProperty_Owner());
			compareRole_Detail(test.getRole_Detail(), control.getRole_Detail());
			compareTrust(test.getTrust(), control.getTrust());
		}
		
	}

	private void compareLicenses(List<License> test, List<License> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareLicense(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareLicense(test.get(i), control.get(i));
			}
		}}
		
	private void compareLicense(License test, License control) {
		if (control != null) {
			compareLicense_Detail(test.getLicense_Detail(), control.getLicense_Detail());
		}

	}

	private void compareLicense_Detail(License_Detail test, License_Detail control) {
		diffLicenseAuthorityLevelType(test.getLicenseAuthorityLevelType(), control.getLicenseAuthorityLevelType());
		diffLicenseIdentifier(test.getLicenseIdentifier(), control.getLicenseIdentifier());
		
	}

	private void diffLicenseAuthorityLevelType(String test, String control) {
		diffObject(test, control, "LicenseAuthorityLevelType");
		
	}

	private void diffLicenseIdentifier(String test, String control) {
		diffObject(test, control, "LicenseIdentifier");
		
	}

	private void compareParty_Role_Identifiers(List<Party_Role_Identifier> test,
			List<Party_Role_Identifier> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareParty_Role_Identifier(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareParty_Role_Identifier(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareParty_Role_Identifier(Party_Role_Identifier test,
			Party_Role_Identifier control) {
		diffPartyRoleIdentifier(test.getPartyRoleIdentifier(), control.getPartyRoleIdentifier());
		
	}

	private void diffPartyRoleIdentifier(String test, String control) {
		diffObject(test, control, "PartyRoleIdentifier");
		
	}

	private void compareProperty_Owner(Property_Owner test, Property_Owner control) {
		diffPropertyOwnerStatusType(test.getPropertyOwnerStatusType(), control.getPropertyOwnerStatusType());
		diffRelationshipVestingType(test.getRelationshipVestingType(), control.getRelationshipVestingType());
		diffRelationshipVestingTypeOtherDescription(test.getRelationshipVestingTypeOtherDescription(), control.getRelationshipVestingTypeOtherDescription());
		
	}

	private void diffPropertyOwnerStatusType(String test, String control) {
		diffObject(test, control, "PropertyOwnerStatusType");
		
	}

	private void diffRelationshipVestingType(String test, String control) {
		diffObject(test, control, "RelationshipVestingType");
		
	}

	private void diffRelationshipVestingTypeOtherDescription(String test, String control) {
		diffObject(test, control, "RelationshipVestingTypeOtherDescription");
		
	}

	private void compareRole_Detail(Role_Detail test, Role_Detail control) {
		diffPartyRoleType(test.getPartyRoleType(), control.getPartyRoleType());
		
	}

	private void diffPartyRoleType(String test, String control) {
		diffObject(test, control, "PartyRoleType");
		
	}

	private void compareTrust(Trust test, Trust control) {
		diffTrustClassificationType(test.getTrustClassificationType(), control.getTrustClassificationType());
		
	}

	private void diffTrustClassificationType(String test, String control) {
		diffObject(test, control, "TrustClassificationType");
		
	}

	private void compareBorrower(Borrower test, Borrower control) {
		if (control != null) {
			compareBankrupticies(test.getBankruptcies(), control.getBankruptcies());
			compareBorrower_Detail(test.getBorrower_Detail(), control.getBorrower_Detail());
			compareCounseling(test.getCounseling(), control.getCounseling());
			compareCurrent_Income(test.getCurrent_Income(), control.getCurrent_Income());
			compareDeclaration(test.getDeclaration(), control.getDeclaration());
			compareDependents(test.getDependents(), control.getDependents());
			compareEmployers(test.getEmployers(), control.getEmployers());
			compareGovernment_Borrower(test.getGovernment_Borrower(), control.getGovernment_Borrower());
			compareGovernment_Monitoring(test.getGovernment_Monitoring(), control.getGovernment_Monitoring());
			compareMilitary_Services(test.getMilitary_Services(), control.getMilitary_Services());
			compareResidences(test.getResidences(), control.getResidences());
		}
		
	}

	private void compareResidences(List<Residence> test, List<Residence> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareResidence(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareResidence(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareResidence(Residence test, Residence control) {
		if (control != null) {
			compareAddress3(test.getAddress(), control.getAddress());
			compareLandlord(test.getLandlord(), control.getLandlord());
			compareResidence_Detail(test.getResidence_Detail(), control.getResidence_Detail());
		}
		
	}

	private void compareAddress3(information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res.Address test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res.Address control) {
		diffAddressLineText(test.getAddressLineText(), control.getAddressLineText());
		diffAddressUnitIdentifier(test.getAddressUnitIdentifier(), control.getAddressUnitIdentifier());
		diffCityName(test.getCityName(), control.getCityName());
		diffCountryCode(test.getCountryCode(), control.getCountryCode());
		diffPostalCode(test.getPostalCode(), control.getPostalCode());
		diffStateCode(test.getStateCode(), control.getStateCode());
		
	}

	private void compareLandlord(Landlord test, Landlord control) {
		if (control != null) {
			compareLandlord_Detail(test.getLandlord_Detail(), control.getLandlord_Detail());
		}
		
	}

	private void compareLandlord_Detail(Landlord_Detail test, Landlord_Detail control) {
		diffMonthlyRentAmount(test.getMonthlyRentAmount(), control.getMonthlyRentAmount());
		
	}

	private void diffMonthlyRentAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "MonthlyRentAmount");
		
	}

	private void compareResidence_Detail(Residence_Detail test, Residence_Detail control) {
		diffBorrowerResidencyBasisType(test.getBorrowerResidencyBasisType(), control.getBorrowerResidencyBasisType());
		diffBorrowerResidencyDurationMonthsCount(test.getBorrowerResidencyDurationMonthsCount(), control.getBorrowerResidencyDurationMonthsCount());
		diffBorrowerResidencyType(test.getBorrowerResidencyType(), control.getBorrowerResidencyType());
		
	}

	private void diffBorrowerResidencyBasisType(String test, String control) {
		diffObject(test, control, "BorrowerResidencyBasisType");
		
	}

	private void diffBorrowerResidencyDurationMonthsCount(Integer test, Integer control) {
		diffObject(test, control, "BorrowerResidencyDurationMonthsCount");
		
	}

	private void diffBorrowerResidencyType(String test, String control) {
		diffObject(test, control, "BorrowerResidencyType");
		
	}

	private void compareMilitary_Services(List<Military_Service> test, List<Military_Service> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareMilitary_Service(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareMilitary_Service(test.get(i), control.get(i));
			}
		}
		
	}
	
	private void compareMilitary_Service(Military_Service test, Military_Service control) {
		diffMilitaryServiceExpectedCompletionDate(test.getMilitaryServiceExpectedCompletionDate(), control.getMilitaryServiceExpectedCompletionDate());
		diffMilitaryStatusType(test.getMilitaryStatusType(), control.getMilitaryStatusType());
		
	}

	

	private void diffMilitaryServiceExpectedCompletionDate(LocalDate test, LocalDate control) {
		diffObject(test, control, "MilitaryServiceExpectedCompletionDate");
		
	}

	private void diffMilitaryStatusType(String test, String control) {
		diffObject(test, control, "MilitaryStatusType");
		
	}

	private void compareGovernment_Monitoring(Government_Monitoring test, Government_Monitoring control) {
		if (control != null) {
			compareExtension(test.getExtension(), control.getExtension());
			compareHMDA_Ethnicity_Origins(test.getHMDA_Ethnicity_Origins(), control.getHMDA_Ethnicity_Origins());
			compareGovernment_Monitoring_Detail(test.getGovernment_Monitoring_Detail(), control.getGovernment_Monitoring_Detail());
			compareHMDA_Races(test.getHMDA_Races(), control.getHMDA_Races());
		}
		
	}

	private void compareHMDA_Races(List<HMDA_Race> test, List<HMDA_Race> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHMDA_Race(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHMDA_Race(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareHMDA_Race(HMDA_Race test, HMDA_Race control) {
		if (control != null) {
			compareHMDA_Race_Designations(test.getHMDA_Race_Designations(), control.getHMDA_Race_Designations());
			compareHMDA_Race_Detail(test.getHMDA_Race_Detail(), control.getHMDA_Race_Detail());
		}
		
	}

	private void compareHMDA_Race_Designations(List<HMDA_Race_Designation> test,
			List<HMDA_Race_Designation> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHMDA_Race_Designation(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHMDA_Race_Designation(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareHMDA_Race_Designation(HMDA_Race_Designation test,
			HMDA_Race_Designation control) {
		if (control != null) {
			compareExtension(test.getExtension(), control.getExtension());
		}
		
	}

	private void compareExtension(information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDARac.HMDARacDes.Extension test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDARac.HMDARacDes.Extension control) {
		if (control != null) {
			compareOther(test.getOther(), control.getOther());
		}
		
	}

	private void compareOther(information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDARac.HMDARacDes.Ext.Other test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDARac.HMDARacDes.Ext.Other control) {
		if (control != null) {
			compareHMDA_Race_Designation_Extension(test.getHMDA_Race_Designation_Extension(), control.getHMDA_Race_Designation_Extension());
		}
		
	}

	private void compareHMDA_Race_Designation_Extension(HMDA_Race_Designation_Extension test,
			HMDA_Race_Designation_Extension control) {
		diffHMDARaceDesignationOtherAsianDescription(test.getHMDARaceDesignationOtherAsianDescription(), control.getHMDARaceDesignationOtherAsianDescription());
		diffHMDARaceDesignationOtherPacificIslanderDescription(test.getHMDARaceDesignationOtherPacificIslanderDescription(), control.getHMDARaceDesignationOtherPacificIslanderDescription());
		diffHMDARaceDesignationType(test.getHMDARaceDesignationType(), control.getHMDARaceDesignationType());
		
	}

	private void diffHMDARaceDesignationOtherAsianDescription(String test, String control) {
		diffObject(test, control, "HMDARaceDesignationOtherAsianDescription");
		
	}
	
	private void diffHMDARaceDesignationOtherPacificIslanderDescription(String test, String control) {
		diffObject(test, control, "HMDARaceDesignationOtherPacificIslanderDescription");
		
	}

	private void diffHMDARaceDesignationType(String test, String control) {
		diffObject(test, control, "HMDARaceDesignationType");
		
	}

	private void compareHMDA_Race_Detail(HMDA_Race_Detail test, HMDA_Race_Detail control) {
		diffHMDARaceType(test.getHMDARaceType(), control.getHMDARaceType());
		diffHMDARaceTypeAdditionalDescription(test.getHMDARaceTypeAdditionalDescription(), control.getHMDARaceTypeAdditionalDescription());
		
	}

	private void diffHMDARaceType(String test, String control) {
		diffObject(test, control, "HMDARaceType");
		
	}

	private void diffHMDARaceTypeAdditionalDescription(String test, String control) {
		diffObject(test, control, "HMDARaceTypeAdditionalDescription");
		
	}

	private void compareGovernment_Monitoring_Detail(Government_Monitoring_Detail test,
			Government_Monitoring_Detail control) {
		if (control != null) {
			compareExtension(test.getExtension(), control.getExtension());
		}
		diffHMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator(test.getHMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator(), control.getHMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator());
		diffHMDAEthnicityRefusalIndicator(test.getHMDAEthnicityRefusalIndicator(), control.getHMDAEthnicityRefusalIndicator());
		diffHMDAGenderCollectedBasedOnVisualObservationOrNameIndicator(test.getHMDAGenderCollectedBasedOnVisualObservationOrNameIndicator(), control.getHMDAGenderCollectedBasedOnVisualObservationOrNameIndicator());
		diffHMDAGenderRefusalIndicator(test.getHMDAGenderRefusalIndicator(), control.getHMDAGenderRefusalIndicator());
		diffHMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator(test.getHMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator(), control.getHMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator());
		diffHMDARaceRefusalIndicator(test.getHMDARaceRefusalIndicator(), control.getHMDARaceRefusalIndicator());
		
	}

	private void diffHMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "HMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator");
		
	}

	private void diffHMDAEthnicityRefusalIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "HMDAEthnicityRefusalIndicator");
		
	}

	private void diffHMDAGenderCollectedBasedOnVisualObservationOrNameIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "HMDAGenderCollectedBasedOnVisualObservationOrNameIndicator");
		
	}

	private void diffHMDAGenderRefusalIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "HMDAGenderRefusalIndicator");
		
	}

	private void diffHMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "HMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator");
		
	}

	private void diffHMDARaceRefusalIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "HMDARaceRefusalIndicator");
		
	}

	private void compareExtension(information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.GovMonDet.Extension test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.GovMonDet.Extension control) {
		if (control != null) {
			compareOther(test.getOther(), control.getOther());
		}
		
	}

	private void compareOther(information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.GovMonDet.Ext.Other test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.GovMonDet.Ext.Other control) {
		if (control != null) {
			compareGovernment_Monitoring_Detail_Extension(test.getGovernment_Monitoring_Detail_Extension(), control.getGovernment_Monitoring_Detail_Extension());
		}
		
	}

	private void compareGovernment_Monitoring_Detail_Extension(
			Government_Monitoring_Detail_Extension test,
			Government_Monitoring_Detail_Extension control) {
		diffApplicationTakenMethodType(test.getApplicationTakenMethodType(), control.getApplicationTakenMethodType());
		diffHMDAGenderType(test.getHMDAGenderType(), control.getHMDAGenderType());
		
	}

	private void diffApplicationTakenMethodType(String test, String control) {
		diffObject(test, control, "ApplicationTakenMethodType");
		
	}

	private void diffHMDAGenderType(String test, String control) {
		diffObject(test, control, "HMDAGenderType");
		
	}

	private void compareHMDA_Ethnicity_Origins(List<HMDA_Ethnicity_Origin> test,
			List<HMDA_Ethnicity_Origin> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHMDA_Ethnicity_Origin(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHMDA_Ethnicity_Origin(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareHMDA_Ethnicity_Origin(HMDA_Ethnicity_Origin test,
			HMDA_Ethnicity_Origin control) {
		diffHMDAEthnicityOriginType(test.getHMDAEthnicityOriginType(), control.getHMDAEthnicityOriginType());
		diffHMDAEthnicityOriginTypeOtherDescription(test.getHMDAEthnicityOriginTypeOtherDescription(), control.getHMDAEthnicityOriginTypeOtherDescription());
		
	}

	private void diffHMDAEthnicityOriginType(String test, String control) {
		diffObject(test, control, "HMDAEthnicityOriginType");
		
	}

	private void diffHMDAEthnicityOriginTypeOtherDescription(String test,
			String control) {
		diffObject(test, control, "HMDAEthnicityOriginTypeOtherDescription");
		
	}

	private void compareExtension(information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.Extension test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.Extension control) {
		if (control != null) {
			compareOther(test.getOther(), control.getOther());
		}
		
	}

	private void compareOther(information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.Ext.Other test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.Ext.Other control) {
		if (control != null) {
			compareGovernment_Monitoring_Extension(test.getGovernment_Monitoring_Extension(), control.getGovernment_Monitoring_Extension());
		}
	}

	private void compareGovernment_Monitoring_Extension(Government_Monitoring_Extension test,
			Government_Monitoring_Extension control) {
		if (control != null) {
			compareHMDA_Ethnicities(test.getHMDA_Ethnicities(), control.getHMDA_Ethnicities());
		}
		
	}

	private void compareHMDA_Ethnicities(List<HMDA_Ethnicity> test,
			List<HMDA_Ethnicity> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHMDA_Ethnicity(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHMDA_Ethnicity(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareHMDA_Ethnicity(HMDA_Ethnicity test, HMDA_Ethnicity control) {
		diffHMDAEthnicityType(test.getHMDAEthnicityType(), control.getHMDAEthnicityType());
		
	}

	private void diffHMDAEthnicityType(String test, String control) {
		diffObject(test, control, "HMDAEthnicityType");
		
	}

	private void compareGovernment_Borrower(Government_Borrower test,
			Government_Borrower control) {
		diffCAIVRSIdentifier(test.getCAIVRSIdentifier(), control.getCAIVRSIdentifier());
		diffVACoBorrowerNontaxableIncomeAmount(test.getVACoBorrowerNontaxableIncomeAmount(), control.getVACoBorrowerNontaxableIncomeAmount());
		diffVACoBorrowerTaxableIncomeAmount(test.getVACoBorrowerTaxableIncomeAmount(), control.getVACoBorrowerTaxableIncomeAmount());
		diffVAFederalTaxAmount(test.getVAFederalTaxAmount(), control.getVAFederalTaxAmount());
		diffVALocalTaxAmount(test.getVALocalTaxAmount(), control.getVALocalTaxAmount());
		diffVAPrimaryBorrowerNontaxableIncomeAmount(test.getVAPrimaryBorrowerNontaxableIncomeAmount(), control.getVAPrimaryBorrowerNontaxableIncomeAmount());
		diffVAPrimaryBorrowerTaxableIncomeAmount(test.getVAPrimaryBorrowerTaxableIncomeAmount(), control.getVAPrimaryBorrowerTaxableIncomeAmount());
		diffVASocialSecurityTaxAmount(test.getVASocialSecurityTaxAmount(), control.getVASocialSecurityTaxAmount());
		diffVAStateTaxAmount(test.getVAStateTaxAmount(), control.getVAStateTaxAmount());
		
	}

	private void diffCAIVRSIdentifier(String test, String control) {
		diffObject(test, control, "CAIVRSIdentifier");
		
	}

	private void diffVACoBorrowerNontaxableIncomeAmount(BigDecimal test,
			BigDecimal control) {
		diffObject(test, control, "VACoBorrowerNontaxableIncomeAmount");
		
	}

	private void diffVACoBorrowerTaxableIncomeAmount(BigDecimal test,
			BigDecimal control) {
		diffObject(test, control, "VACoBorrowerTaxableIncomeAmount");
		
	}

	private void diffVAFederalTaxAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "VAFederalTaxAmount");
		
	}

	private void diffVALocalTaxAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "VALocalTaxAmount");
		
	}

	private void diffVAPrimaryBorrowerNontaxableIncomeAmount(BigDecimal test,
			BigDecimal control) {
		diffObject(test, control, "VAPrimaryBorrowerNontaxableIncomeAmount");
		
	}

	private void diffVAPrimaryBorrowerTaxableIncomeAmount(BigDecimal test,
			BigDecimal control) {
		diffObject(test, control, "VAPrimaryBorrowerTaxableIncomeAmount");
		
	}

	private void diffVASocialSecurityTaxAmount(BigDecimal test,
			BigDecimal control) {
		diffObject(test, control, "VASocialSecurityTaxAmount");
		
	}

	private void diffVAStateTaxAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "VAStateTaxAmount");
		
	}

	private void compareEmployers(List<Employer> test, List<Employer> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareEmployer(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareEmployer(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareEmployer(Employer test, Employer control) {
		if (control != null) {
			compareAddress(test.getAddress(), control.getAddress());
			compareEmployment(test.getEmployment(), control.getEmployment()); //change to Employer/Address
			compareIndividual(test.getIndividual(), control.getIndividual());
			compareLegal_Entity2(test.getLegal_Entity(), control.getLegal_Entity()); // change to Employer/Legal_Entity
		}
		
	}

	private void compareLegal_Entity2(information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.Legal_Entity test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.Legal_Entity control) {
		if (control != null) {
			compareContacts(test.getContacts(), control.getContacts());
			compareLegal_Entity_Detail(test.getLegal_Entity_Detail(), control.getLegal_Entity_Detail());
		}
		
	}

	private void compareContacts(List<Contact> test, List<Contact> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareContact(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareContact(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareContact(Contact test, Contact control) {
		if (control != null) {
			compareContact_Points2(test.getContact_Points(), control.getContact_Points());
		}
		
	}
	
	// change to Legal_Entity/Contact_Point
	private void compareContact_Points2(
			List<information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Cont.Contact_Point> test,
			List<information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Cont.Contact_Point> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareContact_Point2(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareContact_Point2(test.get(i), control.get(i));
			}
		}
		
	}
	
	// change to Legal_Entity/Contact_Point
	private void compareContact_Point2(
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Cont.Contact_Point test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Cont.Contact_Point control) {
		if (control != null) {
			compareContact_Point_Telephone(test.getContact_Point_Telephone(), control.getContact_Point_Telephone());
		}
		
	}



	private void compareContact_Point_Telephone(
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Cont.ConPoiTel.Contact_Point_Telephone test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Cont.ConPoiTel.Contact_Point_Telephone control) {
		diffContactPointTelephoneValue(test.getContactPointTelephoneValue(), control.getContactPointTelephoneValue()); // duplicate
		
	}

	private void compareIndividual(
			information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloIte.CloAdjIte.CloAdjItePaiBy.Individual test,
			information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloIte.CloAdjIte.CloAdjItePaiBy.Individual control) {
		compareName(test.getName(), control.getName());
		
	}

	private void compareName(
			information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloIte.CloAdjIte.CloAdjItePaiBy.Ind.Name test,
			information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloIte.CloAdjIte.CloAdjItePaiBy.Ind.Name control) {
		diffFullName(test.getFullName(), control.getFullName());
		
	}

	private void compareEmployment(Employment test, Employment control) {
		diffEmploymentBorrowerSelfEmployedIndicator(test.getSpecialBorrowerEmployerRelationshipIndicator(), control.getSpecialBorrowerEmployerRelationshipIndicator());
		diffEmploymentClassificationType(test.getEmploymentClassificationType(), control.getEmploymentClassificationType());
		diffEmploymentEndDate(test.getEmploymentEndDate(), control.getEmploymentEndDate());
		diffEmploymentMonthlyIncomeAmount(test.getEmploymentMonthlyIncomeAmount(), control.getEmploymentMonthlyIncomeAmount());
		diffEmploymentPositionDescription(test.getEmploymentPositionDescription(), control.getEmploymentPositionDescription());
		diffEmploymentStartDate(test.getEmploymentStartDate(), control.getEmploymentStartDate());
		diffEmploymentStatusType(test.getEmploymentStatusType(), control.getEmploymentStatusType());
		diffEmploymentTimeInLineOfWorkMonthsCount(test.getEmploymentTimeInLineOfWorkMonthsCount(), control.getEmploymentTimeInLineOfWorkMonthsCount());
		diffOwnershipInterestType(test.getOwnershipInterestType(), control.getOwnershipInterestType());
		diffSpecialBorrowerEmployerRelationshipIndicator(test.getSpecialBorrowerEmployerRelationshipIndicator(), control.getSpecialBorrowerEmployerRelationshipIndicator());
		if (control != null) {
			compareExtension(test.getExtension(), control.getExtension());
		}
		
	}

	private void compareExtension(information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.Emp.Extension test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.Emp.Extension control) {
		if (control != null) {
			compareOther(test.getOther(), control.getOther());
		}
		
	}

	private void compareOther(information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.Emp.Ext.Other test,
			information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.Emp.Ext.Other control) {
		if (control != null) {
			compareEmployment_Extension(test.getEmployment_Extension(), control.getEmployment_Extension());
		}
		
	}

	private void compareEmployment_Extension(Employment_Extension test,
			Employment_Extension control) {
		diffForeignIncomeIndicator(test.getForeignIncomeIndicator(), control.getForeignIncomeIndicator());
		diffSeasonalIncomeIndicator(test.getSeasonalIncomeIndicator(), control.getSeasonalIncomeIndicator());
		
	}

	private void diffForeignIncomeIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "ForeignIncomeIndicator");
		
	}

	private void diffSeasonalIncomeIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "SeasonalIncomeIndicator");
		
	}

	private void diffEmploymentBorrowerSelfEmployedIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "EmploymentBorrowerSelfEmployedIndicator");
		
	}

	private void diffEmploymentClassificationType(String test, String control) {
		diffObject(test, control, "EmploymentClassificationType");
		
	}

	private void diffEmploymentEndDate(LocalDate test, LocalDate control) {
		diffObject(test, control, "EmploymentEndDate");
		
	}

	private void diffEmploymentMonthlyIncomeAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "EmploymentMonthlyIncomeAmount");
		
	}

	private void diffEmploymentPositionDescription(String test, String control) {
		diffObject(test, control, "EmploymentPositionDescription");
		
	}

	private void diffEmploymentStartDate(LocalDate test, LocalDate control) {
		diffObject(test, control, "EmploymentStartDate");
		
	}

	private void diffEmploymentStatusType(String test, String control) {
		diffObject(test, control, "EmploymentStatusType");
		
	}

	private void diffEmploymentTimeInLineOfWorkMonthsCount(Integer test, Integer control) {
		diffObject(test, control, "EmploymentTimeInLineOfWorkMonthsCount");
		
	}

	private void diffOwnershipInterestType(String test, String control) {
		diffObject(test, control, "OwnershipInterestType");
		
	}

	private void diffSpecialBorrowerEmployerRelationshipIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "SpecialBorrowerEmployerRelationshipIndicator");
		
	}

	private void compareDependents(List<Dependent> test, List<Dependent> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDependent(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDependent(test.get(i), control.get(i));
			}
		}
	}

	private void compareDependent(Dependent test, Dependent control) {
		diffDependentAgeYearsCount(test.getDependentAgeYearsCount(), control.getDependentAgeYearsCount());
		
	}

	private void diffDependentAgeYearsCount(Integer test, Integer control) {
		diffObject(test, control, "DependentAgeYearsCount");
		
	}

	private void compareDeclaration(Declaration test, Declaration control) {
		if (control != null) {
			compareDeclaration_Detail(test.getDeclaration_Detail(), control.getDeclaration_Detail());
			compareDeclatation_Explanations(test.getDeclaration_Explanations(), control.getDeclaration_Explanations());
		}
		
	}

	

	private void compareDeclaration_Detail(Declaration_Detail test, Declaration_Detail control) {
		diffBankruptcyIndicator(test.getBankruptcyIndicator(), control.getBankruptcyIndicator());
		diffCitizenshipResidencyType(test.getCitizenshipResidencyType(), control.getCitizenshipResidencyType());
		diffFHASecondaryResidenceIndicator(test.getFHASecondaryResidenceIndicator(), control.getFHASecondaryResidenceIndicator()); //duplicate
		diffHomeownerPastThreeYearsType(test.getHomeownerPastThreeYearsType(), control.getHomeownerPastThreeYearsType());
		diffIntentToOccupyType(test.getIntentToOccupyType(), control.getIntentToOccupyType());
		diffOutstandingJudgmentsIndicator(test.getOutstandingJudgmentsIndicator(), control.getOutstandingJudgmentsIndicator());
		diffPartyToLawsuitIndicator(test.getPartyToLawsuitIndicator(), control.getPartyToLawsuitIndicator());
		diffPresentlyDelinquentIndicator(test.getPresentlyDelinquentIndicator(), control.getPresentlyDelinquentIndicator());
		diffPriorPropertyDeedInLieuConveyedIndicator(test.getPriorPropertyDeedInLieuConveyedIndicator(), control.getPriorPropertyDeedInLieuConveyedIndicator());
		diffPriorPropertyForeclosureCompletedIndicator(test.getPriorPropertyForeclosureCompletedIndicator(), control.getPriorPropertyForeclosureCompletedIndicator());
		diffPriorPropertyShortSaleCompletedIndicator(test.getPriorPropertyShortSaleCompletedIndicator(), control.getPriorPropertyShortSaleCompletedIndicator());
		diffPriorPropertyTitleType(test.getPriorPropertyTitleType(), control.getPriorPropertyTitleType());
		diffPriorPropertyUsageType(test.getPriorPropertyUsageType(), control.getPriorPropertyUsageType());
		diffPropertyProposedCleanEnergyLienIndicator(test.getPropertyProposedCleanEnergyLienIndicator(), control.getPropertyProposedCleanEnergyLienIndicator());
		diffUndisclosedBorrowedFundsAmount(test.getUndisclosedBorrowedFundsAmount(), control.getUndisclosedBorrowedFundsAmount());
		diffUndisclosedBorrowedFundsIndicator(test.getUndisclosedBorrowedFundsIndicator(), control.getUndisclosedBorrowedFundsIndicator());
		diffUndisclosedComakerOfNoteIndicator(test.getUndisclosedComakerOfNoteIndicator(), control.getUndisclosedComakerOfNoteIndicator());
		diffUndisclosedCreditApplicationIndicator(test.getUndisclosedCreditApplicationIndicator(), control.getUndisclosedCreditApplicationIndicator());
		diffUndisclosedMortgageApplicationIndicator(test.getUndisclosedMortgageApplicationIndicator(), control.getUndisclosedMortgageApplicationIndicator());
		
	}
	
	private void diffBankruptcyIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "BankruptcyIndicator");
		
	}

	private void diffCitizenshipResidencyType(String test, String control) {
		diffObject(test, control, "CitizenshipResidencyType");
		
	}

	private void diffHomeownerPastThreeYearsType(String test,
			String control) {
		diffObject(test, control, "HomeownerPastThreeYearsType");
		
	}

	private void diffIntentToOccupyType(String test, String control) {
		diffObject(test, control, "IntentToOccupyType");
		
	}

	private void diffOutstandingJudgmentsIndicator(Boolean test,
			Boolean control) {
		diffObject(test, control, "OutstandingJudgmentsIndicator");
		
	}

	private void diffPartyToLawsuitIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "PartyToLawsuitIndicator");
		
	}

	private void diffPresentlyDelinquentIndicator(Boolean test,
			Boolean control) {
		diffObject(test, control, "PresentlyDelinquentIndicator");
		
	}

	private void diffPriorPropertyDeedInLieuConveyedIndicator(Boolean test,
			Boolean control) {
		diffObject(test, control, "PriorPropertyDeedInLieuConveyedIndicator");
		
	}

	private void diffPriorPropertyForeclosureCompletedIndicator(Boolean test,
			Boolean control) {
		diffObject(test, control, "PriorPropertyForeclosureCompletedIndicator");
		
	}

	private void diffPriorPropertyShortSaleCompletedIndicator(Boolean test,
			Boolean control) {
		diffObject(test, control, "PriorPropertyShortSaleCompletedIndicator");
		
	}

	private void diffPriorPropertyTitleType(String test, String control) {
		diffObject(test, control, "PriorPropertyTitleType");
		
	}

	private void diffPriorPropertyUsageType(String test, String control) {
		diffObject(test, control, "PriorPropertyUsageType");
		
	}

	private void diffPropertyProposedCleanEnergyLienIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "PropertyProposedCleanEnergyLienIndicator");
		
	}

	private void diffUndisclosedBorrowedFundsAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "UndisclosedBorrowedFundsAmount");
		
	}

	private void diffUndisclosedBorrowedFundsIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "UndisclosedBorrowedFundsIndicator");
		
	}

	private void diffUndisclosedComakerOfNoteIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "UndisclosedComakerOfNoteIndicator");
		
	}

	private void diffUndisclosedCreditApplicationIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "UndisclosedCreditApplicationIndicator");
		
	}

	private void diffUndisclosedMortgageApplicationIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "UndisclosedMortgageApplicationIndicator");
		
	}

	private void compareDeclatation_Explanations(List<Declaration_Explanation> test, List<Declaration_Explanation> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDeclatation_Explanation(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDeclatation_Explanation(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareDeclatation_Explanation(Declaration_Explanation test, Declaration_Explanation control) {
		diffDeclarationExplanationDescription(test.getDeclarationExplanationDescription(), control.getDeclarationExplanationDescription());
		diffDeclarationExplanationType(test.getDeclarationExplanationType(), control.getDeclarationExplanationType());
		
	}

	private void diffDeclarationExplanationType(String test, String control) {
		diffObject(test, control, "DeclarationExplanationDescription");
		
	}

	private void diffDeclarationExplanationDescription(String test, String control) {
		diffObject(test, control, "DeclarationExplanationDescription");
		
	}

	private void compareCurrent_Income(Current_Income test, Current_Income control) {
		if (control != null) {
			compareCurrent_Income_Items(test.getCurrent_Income_Items(), control.getCurrent_Income_Items());
		}
	}

	private void compareCurrent_Income_Items(List<Current_Income_Item> test, List<Current_Income_Item> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareCurrent_Income_Item(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareCurrent_Income_Item(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareCurrent_Income_Item(Current_Income_Item test, Current_Income_Item control) {
		compareCurrent_Income_Item_Detail(test.getCurrent_Income_Item_Detail(), control.getCurrent_Income_Item_Detail());
		
	}

	private void compareCurrent_Income_Item_Detail(Current_Income_Item_Detail test, Current_Income_Item_Detail control) {
		diffCurrentIncomeMonthlyTotalAmount(test.getCurrentIncomeMonthlyTotalAmount(), control.getCurrentIncomeMonthlyTotalAmount());
		diffEmploymentIncomeIndicator(test.getEmploymentIncomeIndicator(), control.getEmploymentIncomeIndicator());
		diffIncomeType(test.getIncomeType(), control.getIncomeType());
		diffIncomeTypeOtherDescription(test.getIncomeTypeOtherDescription(), control.getIncomeTypeOtherDescription());
		
	}

	private void diffCurrentIncomeMonthlyTotalAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "CurrentIncomeMonthlyTotalAmount");
		
	}

	private void diffEmploymentIncomeIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "EmploymentIncomeIndicator");
		
	}

	private void diffIncomeType(String test, String control) {
		diffObject(test, control, "IncomeType");
		
	}

	private void diffIncomeTypeOtherDescription(String test, String control) {
		diffObject(test, control, "IncomeTypeOtherDescription");
		
	}

	private void compareCounseling(Counseling test, Counseling control) {
		if (control != null) {
			compareCounseling_Events(test.getCounseling_Events(), control.getCounseling_Events());
		}
		
	}

	private void compareCounseling_Events(List<Counseling_Event> test,
			List<Counseling_Event> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareCounseling_Event(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareCounseling_Event(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareCounseling_Event(Counseling_Event test, Counseling_Event control) {
		if (control != null) {
			compareCounseling_Event_Detail(test.getCounseling_Event_Detail(), control.getCounseling_Event_Detail());
		}
		
	}

	private void compareCounseling_Event_Detail(Counseling_Event_Detail test,
			Counseling_Event_Detail control) {
		diffCounselingCompletedDate(test.getCounselingCompletedDate(), control.getCounselingCompletedDate());
		diffCounselingConfirmationIndicator(test.getCounselingConfirmationIndicator(), control.getCounselingConfirmationIndicator());
		diffCounselingFormatType(test.getCounselingFormatType(), control.getCounselingFormatType());
		diffCounselingType(test.getCounselingType(), control.getCounselingType());
		
	}

	private void diffCounselingCompletedDate(LocalDate test, LocalDate control) {
		diffObject(test, control, "CounselingCompletedDate");
		
	}

	private void diffCounselingConfirmationIndicator(Boolean test,
			Boolean control) {
		diffObject(test, control, "CounselingConfirmationIndicator");
		
	}

	private void diffCounselingFormatType(String test, String control) {
		diffObject(test, control, "CounselingFormatType");
		
	}

	private void diffCounselingType(String test, String control) {
		diffObject(test, control, "CounselingType");
		
	}

	private void compareBorrower_Detail(Borrower_Detail test, Borrower_Detail control) {
		diffBorrowerBirthDate(test.getBorrowerBirthDate(), control.getBorrowerBirthDate());
		diffBorrowerTotalMortgagedPropertiesCount(test.getBorrowerTotalMortgagedPropertiesCount(), control.getBorrowerTotalMortgagedPropertiesCount());
		diffCommunityPropertyStateResidentIndicator(test.getCommunityPropertyStateResidentIndicator(), control.getCommunityPropertyStateResidentIndicator());
		diffDependentCount(test.getDependentCount(), control.getDependentCount());
		diffDomesticRelationshipIndicator(test.getDomesticRelationshipIndicator(), control.getDomesticRelationshipIndicator());
		diffDomesticRelationshipStateCode(test.getDomesticRelationshipStateCode(), control.getDomesticRelationshipStateCode());
		diffDomesticRelationshipType(test.getDomesticRelationshipType(), control.getDomesticRelationshipType());
		diffDomesticRelationshipTypeOtherDescription(test.getDomesticRelationshipTypeOtherDescription(), control.getDomesticRelationshipTypeOtherDescription());
		diffMaritalStatusType(test.getMaritalStatusType(), control.getMaritalStatusType());
		diffSelfDeclaredMIlitaryServiceIndicator(test.getSelfDeclaredMIlitaryServiceIndicator(), control.getSelfDeclaredMIlitaryServiceIndicator());
		diffSpousalVABenefitsEligibilityIndicator(test.getSpousalVABenefitsEligibilityIndicator(), control.getSpousalVABenefitsEligibilityIndicator());
		
	}

	private void diffBorrowerBirthDate(LocalDate test, LocalDate control) {
		diffObject(test, control, "BorrowerBirthDate");
		
	}

	private void diffBorrowerTotalMortgagedPropertiesCount(Integer test,
			Integer control) {
		diffObject(test, control, "BorrowerTotalMortgagedPropertiesCount");
		
	}

	private void diffCommunityPropertyStateResidentIndicator(Boolean test,
			Boolean control) {
		diffObject(test, control, "CommunityPropertyStateResidentIndicator");
		
	}

	private void diffDependentCount(Integer test, Integer control) {
		diffObject(test, control, "DependentCount");
		
	}

	private void diffDomesticRelationshipIndicator(Boolean test,
			Boolean control) {
		diffObject(test, control, "DomesticRelationshipIndicator");
		
	}

	private void diffDomesticRelationshipStateCode(String test,
			String control) {
		diffObject(test, control, "DomesticRelationshipStateCode");
		
	}

	private void diffDomesticRelationshipType(String test, String control) {
		diffObject(test, control, "DomesticRelationshipType");
		
	}

	private void diffDomesticRelationshipTypeOtherDescription(String test,
			String control) {
		diffObject(test, control, "DomesticRelationshipTypeOtherDescription");
		
	}

	private void diffMaritalStatusType(String test, String control) {
		diffObject(test, control, "MaritalStatusType");
		
	}

	private void diffSelfDeclaredMIlitaryServiceIndicator(Boolean test,
			Boolean control) {
		diffObject(test, control, "SelfDeclaredMIlitaryServiceIndicator");
		
	}

	private void diffSpousalVABenefitsEligibilityIndicator(Boolean test,
			Boolean control) {
		diffObject(test, control, "SpousalVABenefitsEligibilityIndicator");
		
	}

	private void compareBankrupticies(List<Bankruptcy> test, List<Bankruptcy> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareBankruptcy(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareBankruptcy(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareBankruptcy(Bankruptcy test, Bankruptcy control) {
		if (control != null) {
			compareBankruptcy_Detail(test.getBankruptcy_Detail(), control.getBankruptcy_Detail());
		}
		
	}

	private void compareBankruptcy_Detail(Bankruptcy_Detail test, Bankruptcy_Detail control) {
		diffBankruptcyChapterType(test.getBankruptcyChapterType(), control.getBankruptcyChapterType());
		
	}

	private void diffBankruptcyChapterType(String test, String control) {
		diffObject(test, control, "BankruptcyChapterType");
		
	}

	private void compareLegal_Entity(Legal_Entity test, Legal_Entity control) {
		if (control != null) {
			compareLegal_Entity_Detail(test.getLegal_Entity_Detail(), control.getLegal_Entity_Detail());
		}
		
	}

	private void compareLegal_Entity_Detail(Legal_Entity_Detail test,
			Legal_Entity_Detail control) {
		diffFullName(test.getFullName(), control.getFullName());
		
	}

	private void compareLanguages(List<Language> test, List<Language> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareLanguage(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareLanguage(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareLanguage(Language test, Language control) {
		diffLanguageCode(test.getLanguageCode(), control.getLanguageCode());
		if (control != null) {
			compareExtension(test.getExtension(), control.getExtension());
		}
		
	}
	
	// change method to Language/Extension?
	private void compareExtension(information.dU34.Mes.DeaSet.Dea.Par.Lan.Extension test,
			information.dU34.Mes.DeaSet.Dea.Par.Lan.Extension control) {
		if (control != null) {
			compareOther(test.getOther(), control.getOther());
		}
		
	}

	private void compareOther(information.dU34.Mes.DeaSet.Dea.Par.Lan.Ext.Other test,
			information.dU34.Mes.DeaSet.Dea.Par.Lan.Ext.Other control) {
		if (control != null) {
			controlLanguage_Extension(test.getLanguage_Extension(), control.getLanguage_Extension());
		}
		
	}

	private void controlLanguage_Extension(Language_Extension test, Language_Extension control) {
		diffLanguageCodeOtherDescription(test.getLanguageCodeOtherDescription(), control.getLanguageCodeOtherDescription());
		diffLanguageRefusalIndicator(test.getLanguageRefusalIndicator(), control.getLanguageRefusalIndicator());
		
	}
	
	private void diffLanguageCodeOtherDescription(String test, String control) {
		diffObject(test, control, "LanguageCodeOtherDescription");
		
	}

	private void diffLanguageRefusalIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "LanguageRefusalIndicator");
		
	}

	private void diffLanguageCode(String test, String control) {
		diffObject(test, control, "LanguageCode");
		
	}

	private void compareIndividual(Individual test, Individual control) {
		if (control != null) {
			compareAliases(test.getAliases(), control.getAliases());
			compareContact_Points(test.getContact_Points(), control.getContact_Points());
			compareName3(test.getName(), control.getName()); // Individual/Name
		}
		
	}
	
	
	private void compareName3(information.dU34.Mes.DeaSet.Dea.Par.Ind.Name test,
			information.dU34.Mes.DeaSet.Dea.Par.Ind.Name control) {
		
		// change name to Individual/Name for all 5
		diffFirstName(test.getFirstName(), control.getFirstName());
		diffFullName(test.getFullName(), control.getFullName());
		diffLastName(test.getLastName(), control.getLastName());
		diffMiddleName(test.getMiddleName(), control.getMiddleName());
		diffSuffixName(test.getSuffixName(), control.getSuffixName());
		
	}

	private void compareContact_Points(List<Contact_Point> test, List<Contact_Point> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareContact_Point(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareContact_Point(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareContact_Point(Contact_Point test, Contact_Point control) {
		if (control != null) {
			compareContact_Point_Detail(test.getContact_Point_Detail(), control.getContact_Point_Detail());
			compareContact_Point_Email(test.getContact_Point_Email(), control.getContact_Point_Email());
			compareContact_Point_Telephone(test.getContact_Point_Telephone(), control.getContact_Point_Telephone());
		}
		
	}
	
	private void compareContact_Point_Detail(Contact_Point_Detail test, Contact_Point_Detail control) {
		diffContactPointRoleType(test.getContactPointRoleType(), control.getContactPointRoleType());
		
	}

	private void diffContactPointRoleType(String test, String control) {
		diffObject(test, control, "ContactPointRoleType");
		
	}

	private void compareContact_Point_Email(Contact_Point_Email test, Contact_Point_Email control) {
		diffContactPointEmailValue(test.getContactPointEmailValue(), control.getContactPointEmailValue());
		
	}
	
	private void diffContactPointEmailValue(String test, String control) {
		diffObject(test, control, "ContactPointEmailValue");
		
	}

	private void compareContact_Point_Telephone(Contact_Point_Telephone test, Contact_Point_Telephone control) {
		diffContactPointTelephoneValue(test.getContactPointTelephoneValue(), control.getContactPointTelephoneValue());
		diffContactPointTelephoneExtensionValue(test.getContactPointTelephoneExtensionValue(), control.getContactPointTelephoneExtensionValue());
		
	}

	

	private void diffContactPointTelephoneValue(String test, String control) {
		diffObject(test, control, "ContactPointTelephoneValue");
		
	}

	private void diffContactPointTelephoneExtensionValue(String test, String control) {
		diffObject(test, control, "ContactPointTelephoneExtensionValue");
		
	}

	private void compareAliases(List<Alias> test, List<Alias> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareAlias(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareAlias(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareAlias(Alias test, Alias control) {
		if (control != null) {
			compareName2(test.getName(), control.getName()); // Alias/Name
		}
		
	}


	private void compareName2(information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Ind.Name test,
			information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Ind.Name control) {
		
		//change method to Alias/Name for all 4
		diffFirstName(test.getFirstName(), control.getFirstName()); 
		diffLastName(test.getLastName(), control.getLastName());
		diffMiddleName(test.getMiddleName(), control.getMiddleName());
		diffSuffixName(test.getSuffixName(), control.getSuffixName());
		
	}
	
	private void diffFirstName(String test, String control) {
		diffObject(test, control, "FirstName");
	}
	
	private void diffLastName(String test, String control) {
		diffObject(test, control, "LastName");
		
	}

	private void diffMiddleName(String test, String control) {
		diffObject(test, control, "MiddleName");
		
	}

	private void diffSuffixName(String test, String control) {
		diffObject(test, control, "SuffixName");
		
	}

	private void compareAddresses(List<information.dU34.Mes.DeaSet.Dea.Par.Address> test,
			List<information.dU34.Mes.DeaSet.Dea.Par.Address> control) { //todo 311 in pfc
		
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareAddress2(test.get(i), control.get(i)); // Party/Address = Address2
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareAddress2(test.get(i), control.get(i)); // Party/Address = Address2
			}
		}
		
	}
	
	// Party/Address
	private void compareAddress2(information.dU34.Mes.DeaSet.Dea.Par.Address test,
			information.dU34.Mes.DeaSet.Dea.Par.Address control) { 
		diffAddressLineText(test.getAddressLineText(), control.getAddressType());
		diffAddressType(test.getAddressType(), control.getAddressType());
		diffAddressUnitIdentifier(test.getAddressUnitIdentifier(), control.getAddressUnitIdentifier());
		diffCityName(test.getCityName(), control.getCityName());
		diffCountryCode(test.getCountryCode(), control.getCountryCode());
		diffPostalCode(test.getPostalCode(), control.getPostalCode());
		diffStateCode(test.getStateCode(), control.getStateCode());
		
	}

	private void diffAddressType(String test, String control) {
		diffObject(test, control, "AddressType");
		
	}

	private void diffCountryCode(String test, String control) {
		diffObject(test, control, "CountryCode");
		
	}

	private void compareLoans(List<Loan> test, List<Loan> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareLoan(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareLoan(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareLoan(Loan test, Loan control) {
		if (control != null) {
			compareAdjustment(test.getAdjustment(), control.getAdjustment());
			compareAffordable_Lending(test.getAffordable_Lending(), control.getAffordable_Lending());
			compareAmortization(test.getAmortization(), control.getAmortization());
			compareBuydown(test.getBuydown(), control.getBuydown());
			compareClosing_Information(test.getClosing_Information(), control.getClosing_Information());
			compareConstruction(test.getConstruction(), control.getConstruction());
			compareDocument_Specific_Data_Sets(test.getDocument_Specific_Data_Sets(), control.getDocument_Specific_Data_Sets());
			compareExtension(test.getExtension(), control.getExtension());
			compareGovernment_Loan(test.getGovernment_Loan(), control.getGovernment_Loan());
			compareHELOC(test.getHELOC(), control.getHELOC());
			compareHMDA_Loan(test.getHMDA_Loan(), control.getHMDA_Loan());
			compareHousing_Expenses(test.getHousing_Expenses(), control.getHousing_Expenses());
			compareInterest_Only(test.getInterest_Only(), control.getInterest_Only());
			compareInvestor_Features(test.getInvestor_Features(), control.getInvestor_Features());
			compareInvestor_Loan_Information(test.getInvestor_Loan_Information(), control.getInvestor_Loan_Information());
			compareLoan_Detail(test.getLoan_Detail(), control.getLoan_Detail());
			compareLoan_Identifiers(test.getLoan_Identifiers(), control.getLoan_Identifiers());
			compareLoan_Product(test.getLoan_Product(), control.getLoan_Product());
			compareMaturity(test.getMaturity(), control.getMaturity());
			compareMI_Data(test.getMI_Data(), control.getMI_Data());
			compareNegative_Amortization(test.getNegative_Amortization(), control.getNegative_Amortization());
			compareOrigination_Funds(test.getOrigination_Funds(), control.getOrigination_Funds());
			comparePayment(test.getPayment(), control.getPayment());
			comparePrepayment_Penalty(test.getPrepayment_Penalty(), control.getPrepayment_Penalty());
			comparePurchase_Credits(test.getPurchase_Credits(), control.getPurchase_Credits());
			compareQualification(test.getQualification(), control.getQualification());
			compareRefinance(test.getRefinance(), control.getRefinance());
			compareTerms_Of_Loan(test.getTerms_Of_Loan(), control.getTerms_Of_Loan());
			compareUnderwriting(test.getUnderwriting(), control.getUnderwriting());
		}
		
	}

	private void compareHMDA_Loan(HMDA_Loan test, HMDA_Loan control) {
		if (control != null) {
			compareHMDA_Loan_Detail(test.getHMDA_Loan_Detail(), control.getHMDA_Loan_Detail());
		}
		
	}

	private void compareUnderwriting(Underwriting test, Underwriting control) {
		if (control != null) {
			compareAutomated_Underwritings(test.getAutomated_Underwritings(), control.getAutomated_Underwritings());
		}
		
	}

	private void compareAutomated_Underwritings(List<Automated_Underwriting> test, List<Automated_Underwriting> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareAutomated_Underwriting(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareAutomated_Underwriting(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareAutomated_Underwriting(Automated_Underwriting test, Automated_Underwriting control) {
		diffAutomatedUnderwritingCaseIdentifier(test.getAutomatedUnderwritingCaseIdentifier(), control.getAutomatedUnderwritingCaseIdentifier());
		
	}

	private void diffAutomatedUnderwritingCaseIdentifier(String test, String control) {
		diffObject(test, control, "AutomatedUnderwritingCaseIdentifier");
		
	}

	private void compareTerms_Of_Loan(Terms_Of_Loan test, Terms_Of_Loan control) {
		diffBaseLoanAmount(test.getBaseLoanAmount(), control.getBaseLoanAmount());
		diffDisclosedIndexRatePercent(test.getDisclosedIndexRatePercent(), control.getDisclosedIndexRatePercent());
		diffLienPriorityType(test.getLienPriorityType(), control.getLienPriorityType());
		diffLoanPurposeType(test.getLoanPurposeType(), control.getLoanPurposeType());
		diffMortgageType(test.getMortgageType(), control.getMortgageType());
		diffNoteAmount(test.getNoteAmount(), control.getNoteAmount());
		diffNoteRatePercent(test.getNoteRatePercent(), control.getNoteRatePercent());
		
	}

	private void diffBaseLoanAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "BaseLoanAmount");
		
	}

	private void diffDisclosedIndexRatePercent(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "DisclosedIndexRatePercent");
		
	}

	private void diffLienPriorityType(String test, String control) {
		diffObject(test, control, "LienPriorityType");
		
	}

	private void diffLoanPurposeType(String test, String control) {
		diffObject(test, control, "LoanPurposeType");
		
	}

	private void diffMortgageType(String test, String control) {
		diffObject(test, control, "MortgageType");
		
	}

	private void diffNoteAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "NoteAmount");
		
	}

	private void diffNoteRatePercent(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "NoteRatePercent");
		
	}

	private void compareRefinance(Refinance test, Refinance control) {
		diffCurrentFirstMortgageHolderType(test.getCurrentFirstMortgageHolderType(), control.getCurrentFirstMortgageHolderType());
		diffRefinanceCashOutDeterminationType(test.getRefinanceCashOutDeterminationType(), control.getRefinanceCashOutDeterminationType());
		
	}

	private void diffCurrentFirstMortgageHolderType(String test, String control) {
		diffObject(test, control, "CurrentFirstMortgageHolderType");
		
	}

	private void diffRefinanceCashOutDeterminationType(String test, String control) {
		diffObject(test, control, "RefinanceCashOutDeterminationType");
		
	}

	private void compareQualification(Qualification test, Qualification control) {
		diffQualifyingRatePercent(test.getQualifyingRatePercent(), control.getQualifyingRatePercent());
		
	}

	private void diffQualifyingRatePercent(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "QualifyingRatePercent");
		
	}

	private void comparePurchase_Credits(List<Purchase_Credit> test, List<Purchase_Credit> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					comparePurchase_Credit(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					comparePurchase_Credit(test.get(i), control.get(i));
			}
		}
		
	}

	private void comparePurchase_Credit(Purchase_Credit test, Purchase_Credit control) {
		diffPurchaseCreditAmount(test.getPurchaseCreditAmount(), control.getPurchaseCreditAmount());
		diffPurchaseCreditType(test.getPurchaseCreditType(), control.getPurchaseCreditType());
		diffPurchaseCreditTypeOtherDescription(test.getPurchaseCreditTypeOtherDescription(), control.getPurchaseCreditTypeOtherDescription());
		
	}

	private void diffPurchaseCreditAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "PurchaseCreditAmount");
		
	}

	private void diffPurchaseCreditType(String test, String control) {
		diffObject(test, control, "PurchaseCreditType");
		
	}

	private void diffPurchaseCreditTypeOtherDescription(String test, String control) {
		diffObject(test, control, "PurchaseCreditTypeOtherDescription");
		
	}

	private void comparePrepayment_Penalty(Prepayment_Penalty test, Prepayment_Penalty control) {
		if (control != null) {
			comparePrepayment_Penalty_Lifetime_Rule(test.getPrepayment_Penalty_Lifetime_Rule(), control.getPrepayment_Penalty_Lifetime_Rule());
		}
		
	}

	private void comparePrepayment_Penalty_Lifetime_Rule(Prepayment_Penalty_Lifetime_Rule test, Prepayment_Penalty_Lifetime_Rule control) {
		diffPrepaymentPenaltyExpirationMonthsCount(test.getPrepaymentPenaltyExpirationMonthsCount(), control.getPrepaymentPenaltyExpirationMonthsCount());
		
	}

	private void diffPrepaymentPenaltyExpirationMonthsCount(Integer test, Integer control) {
		diffObject(test, control, "PrepaymentPenaltyExpirationMonthsCount");
		
	}

	private void comparePayment(Payment test, Payment control) {
		if (control != null) {
			comparePayment_Rule(test.getPayment_Rule(), control.getPayment_Rule());
		}
		
	}

	private void comparePayment_Rule(Payment_Rule test, Payment_Rule control) {
		diffInitialPrincipalAndInterestPaymentAmount(test.getInitialPrincipalAndInterestPaymentAmount(), control.getInitialPrincipalAndInterestPaymentAmount());
		
	}

	private void diffInitialPrincipalAndInterestPaymentAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "InitialPrincipalAndInterestPaymentAmount");
		
	}

	private void compareOrigination_Funds(List<Origination_Fund> test, List<Origination_Fund> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareOrigination_Fund(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareOrigination_Fund(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareOrigination_Fund(Origination_Fund test, Origination_Fund control) {
		diffFundsSourceType(test.getFundsSourceType(), control.getFundsSourceType()); //reused
		diffFundsSourceTypeOtherDescription(test.getFundsSourceTypeOtherDescription(), control.getFundsSourceTypeOtherDescription()); //resused
		
	}

	private void compareNegative_Amortization(Negative_Amortization test, Negative_Amortization control) {
		if (control != null) {
			compareNegative_Amortization_Rule(test.getNegative_Amortization_Rule(), control.getNegative_Amortization_Rule());
		}
		
	}

	private void compareNegative_Amortization_Rule(Negative_Amortization_Rule test, Negative_Amortization_Rule control) {
		diffNegativeAmortizationType(test.getNegativeAmortizationType(), control.getNegativeAmortizationType());
		
	}

	private void diffNegativeAmortizationType(String test, String control) {
		diffObject(test, control, "NegativeAmortizationType");
		
	}

	private void compareMI_Data(MI_Data test, MI_Data control) {
		if (control != null) {
			compareMI_Data_Detail(test.getMI_Data_Detail(), control.getMI_Data_Detail());
		}
		
	}

	private void compareMI_Data_Detail(MI_Data_Detail test, MI_Data_Detail control) {
		diffMICoveragePercent(test.getMICoveragePercent(), control.getMICoveragePercent());
		
	}

	private void diffMICoveragePercent(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "MICoveragePercent");
		
	}

	private void compareMaturity(Maturity test, Maturity control) {
		if (control != null) {
			compareMaturity_Rule(test.getMaturity_Rule(), control.getMaturity_Rule());
		}
		
	}

	private void compareMaturity_Rule(Maturity_Rule test, Maturity_Rule control) {
		diffLoanMaturityPeriodType(test.getLoanMaturityPeriodType(), control.getLoanMaturityPeriodType());
		diffLoanMaturityPeriodCount(test.getLoanMaturityPeriodCount(), control.getLoanMaturityPeriodCount());
		
	}

	private void diffLoanMaturityPeriodCount(Integer test, Integer control) {
		diffObject(test, control, "LoanMaturityPeriodCount");
		
	}

	private void diffLoanMaturityPeriodType(String test, String control) {
		diffObject(test, control, "LoanMaturityPeriodType");
		
	}

	private void compareLoan_Product(Loan_Product test, Loan_Product control) {
		if (control != null) {
			compareLoan_Product_Detail(test.getLoan_Product_Detail(), control.getLoan_Product_Detail());
		}
		
	}

	private void compareLoan_Product_Detail(Loan_Product_Detail test, Loan_Product_Detail control) {
		diffProductDescription(test.getProductDescription(), control.getProductDescription());
		
	}

	private void diffProductDescription(String test, String control) {
		diffObject(test, control, "ProductDescription");
		
	}

	private void compareLoan_Identifiers(List<Loan_Identifier> test, List<Loan_Identifier> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareLoan_Identifier(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareLoan_Identifier(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareLoan_Identifier(Loan_Identifier test, Loan_Identifier control) {
		diffLoanIdentifier(test.getLoanIdentifier(), control.getLoanIdentifier());
		diffLoanIdentifierType(test.getLoanIdentifierType(), control.getLoanIdentifierType());
		
	}

	private void diffLoanIdentifier(String test, String control) {
		diffObject(test, control, "LoanIdentifier");
		
	}

	private void diffLoanIdentifierType(String test, String control) {
		diffObject(test, control, "LoanIdentifierType");
		
	}

	private void compareLoan_Detail(Loan_Detail test, Loan_Detail control) {
		diffApplicationReceivedDate(test.getApplicationReceivedDate(), control.getApplicationReceivedDate());
		diffBalloonIndicator(test.getBalloonIndicator(), control.getBalloonIndicator());
		diffBelowMarketSubordinateFinancingIndicator(test.getBelowMarketSubordinateFinancingIndicator(), control.getBelowMarketSubordinateFinancingIndicator());
		diffBorrowerCount(test.getBorrowerCount(), control.getBorrowerCount());
		diffBuydownTemporarySubsidyFundingIndicator(test.getBuydownTemporarySubsidyFundingIndicator(), control.getBuydownTemporarySubsidyFundingIndicator());
		diffConstructionLoanIndicator(test.getConstructionLoanIndicator(), control.getConstructionLoanIndicator());
		diffConversionOfContractForDeedIndicator(test.getConversionOfContractForDeedIndicator(), control.getConversionOfContractForDeedIndicator());
		diffEnergyRelatedImprovementsIndicator(test.getEnergyRelatedImprovementsIndicator(), control.getEnergyRelatedImprovementsIndicator());
		diffHELOCIndicator(test.getHELOCIndicator(), control.getHELOCIndicator());
		diffInitialFixedPeriodEffectiveMonthsCount(test.getInitialFixedPeriodEffectiveMonthsCount(), control.getInitialFixedPeriodEffectiveMonthsCount());
		diffInterestOnlyIndicator(test.getInterestOnlyIndicator(), control.getInterestOnlyIndicator());
		diffNegativeAmortizationIndicator(test.getNegativeAmortizationIndicator(), control.getNegativeAmortizationIndicator());
		diffPrepaymentPenaltyIndicator(test.getPrepaymentPenaltyIndicator(), control.getPrepaymentPenaltyIndicator());
		diffRenovationLoanIndicator(test.getRenovationLoanIndicator(), control.getRenovationLoanIndicator());
		diffTotalSubordinateFinancingAmount(test.getTotalSubordinateFinancingAmount(), control.getTotalSubordinateFinancingAmount());
		if (control != null) {
			compareExtension(test.getExtension(), control.getExtension());
		}
		
	}

	private void diffApplicationReceivedDate(LocalDate test, LocalDate control) {
		diffObject(test, control, "ApplicationReceivedDate");
		
	}

	private void diffBalloonIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "BalloonIndicator");
		
	}

	private void diffBelowMarketSubordinateFinancingIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "BelowMarketSubordinateFinancingIndicator");
		
	}

	private void diffBorrowerCount(Integer test, Integer control) {
		diffObject(test, control, "BorrowerCount");
		
	}

	private void diffBuydownTemporarySubsidyFundingIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "BuydownTemporarySubsidyFundingIndicator");
		
	}

	private void diffConstructionLoanIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "ConstructionLoanIndicator");
		
	}

	private void diffConversionOfContractForDeedIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "ConversionOfContractForDeedIndicator");
		
	}

	private void diffEnergyRelatedImprovementsIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "EnergyRelatedImprovementsIndicator");
		
	}

	private void diffHELOCIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "HELOCIndicator");
		
	}

	private void diffInitialFixedPeriodEffectiveMonthsCount(Integer test, Integer control) {
		diffObject(test, control, "InitialFixedPeriodEffectiveMonthsCount");
		
	}

	private void diffInterestOnlyIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "InterestOnlyIndicator");
		
	}

	private void diffNegativeAmortizationIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "NegativeAmortizationIndicator");
		
	}

	private void diffPrepaymentPenaltyIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "PrepaymentPenaltyIndicator");
		
	}

	private void diffRenovationLoanIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "RenovationLoanIndicator");
		
	}

	private void diffTotalSubordinateFinancingAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "TotalSubordinateFinancingAmount");
		
	}

	private void compareExtension(information.dU34.Mes.DeaSet.Dea.Loa.LoaDet.Extension test,
			information.dU34.Mes.DeaSet.Dea.Loa.LoaDet.Extension control) {
		if (control != null) {
			compareOther(test.getOther(), control.getOther());
		}
		
	}

	private void compareOther(information.dU34.Mes.DeaSet.Dea.Loa.LoaDet.Ext.Other test,
			information.dU34.Mes.DeaSet.Dea.Loa.LoaDet.Ext.Other control) {
		if (control != null) {
			compareLoan_Detail_Extension(test.getLoan_Detail_Extension(), control.getLoan_Detail_Extension());
		}
		
	}

	private void compareLoan_Detail_Extension(Loan_Detail_Extension test,
			Loan_Detail_Extension control) {
		diffEnergyImprovementAmount(test.getEnergyImprovementAmount(), control.getEnergyImprovementAmount());
		diffPACELoanPayoffAmount(test.getpACELoanPayoffAmount(), control.getpACELoanPayoffAmount());
		
	}

	private void diffEnergyImprovementAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "EnergyImprovementAmount");
		
	}

	private void diffPACELoanPayoffAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "PACELoanPayoffAmount");
		
	}

	private void compareInvestor_Loan_Information(Investor_Loan_Information test,
			Investor_Loan_Information control) {
		diffInvestorProductPlanIdentifier(test.getInvestorProductPlanIdentifier(), control.getInvestorProductPlanIdentifier());
		
	}

	private void diffInvestorProductPlanIdentifier(String test, String control) {
		diffObject(test, control, "InvestorProductPlanIdentifier");
		
	}

	private void compareInvestor_Features(List<Investor_Feature> test, List<Investor_Feature> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareInvestor_Feature(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareInvestor_Feature(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareInvestor_Feature(Investor_Feature test, Investor_Feature control) {
		diffInvestorfeatureIdentifier(test.getInvestorFeatureIdentifier(), control.getInvestorFeatureIdentifier());
		
	}

	private void diffInvestorfeatureIdentifier(String test, String control) {
		diffObject(test, control, "InvestorFeatureIdentifier");
		
	}

	private void compareInterest_Only(Interest_Only test, Interest_Only control) {
		diffInterestOnlyTermMonthsCount(test.getInterestOnlyTermMonthsCount(), control.getInterestOnlyTermMonthsCount());
		
	}

	private void diffInterestOnlyTermMonthsCount(Integer test, Integer control) {
		diffObject(test, control, "InterestOnlyTermMonthsCount");
		
	}

	private void compareHousing_Expenses(List<Housing_Expense> test, List<Housing_Expense> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHousing_Expense(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHousing_Expense(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareHousing_Expense(Housing_Expense test, Housing_Expense control) {
		diffHousingExpensePaymentAmount(test.getHousingExpensePaymentAmount(), control.getHousingExpensePaymentAmount());
		diffHousingExpenseTimingType(test.getHousingExpenseTimingType(), control.getHousingExpenseTimingType());
		diffHousingExpenseType(test.getHousingExpenseType(), control.getHousingExpenseType());

		
	}

	private void diffHousingExpensePaymentAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "HousingExpensePaymentAmount");
		
	}

	private void diffHousingExpenseTimingType(String test, String control) {
		diffObject(test, control, "HousingExpenseTimingType");
		
	}

	private void diffHousingExpenseType(String test, String control) {
		diffObject(test, control, "HousingExpenseType");
		
	}

	private void compareHMDA_Loan_Detail(HMDA_Loan_Detail test, HMDA_Loan_Detail control) {
		diffHMDA_HOEPALoanStatusIndicator(test.getHMDA_HOEPALoanStatusIndicator(), control.getHMDA_HOEPALoanStatusIndicator());
		diffHMDARateSpreadPercent(test.getHMDARateSpreadPercent(), control.getHMDARateSpreadPercent());

		
	}

	private void diffHMDA_HOEPALoanStatusIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "HMDA_HOEPALoanStatusIndicator");
		
	}

	private void diffHMDARateSpreadPercent(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "HMDARateSpreadPercent");
		
	}

	private void compareHELOC(HELOC test, HELOC control) {
		if (control != null) {
			compareHELOC_Occurrences(test.getHELOC_Occurrences(), control.getHELOC_Occurrences());
			compareHELOC_Rule(test.getHELOC_Rule(), control.getHELOC_Rule());
		}
		
	}

	private void compareHELOC_Occurrences(List<HELOC_Occurence> test, List<HELOC_Occurence> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHELOC_Occurrence(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareHELOC_Occurrence(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareHELOC_Occurrence(HELOC_Occurence test, HELOC_Occurence control) {
		diffHELOCBalanceAmount(test.getHELOCBalanceAmount(), control.getHELOCBalanceAmount());
		
	}

	private void diffHELOCBalanceAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "HELOCBalanceAmount");
		
	}

	private void compareHELOC_Rule(HELOC_Rule test, HELOC_Rule control) {
		diffHELOCMaximumBalanceAmount(test.getHELOCMaximumBalanceAmount(), control.getHELOCMaximumBalanceAmount());
		
	}
	
	private void diffHELOCMaximumBalanceAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "HELOCMaximumBalanceAmount");
		
	}

	private void compareGovernment_Loan(Government_Loan test, Government_Loan control) {
		diffFHALoanLenderIdentifier(test.getFHALoanLenderIdentifier(), control.getFHALoanLenderIdentifier());
		diffFHALoanSponsorIdentifier(test.getFHALoanSponsorIdentifier(), control.getFHALoanSponsorIdentifier());
		diffFHA_MIPremiumRefundAmount(test.getFHA_MIPremiumRefundAmount(), control.getFHA_MIPremiumRefundAmount());
		diffGovernmentMortgageCreditCertificateAmount(test.getGovernmentMortgageCreditCertificateAmount(), control.getGovernmentMortgageCreditCertificateAmount());
		diffGovernmentRefinanceType(test.getGovernmentRefinanceType(), control.getGovernmentRefinanceType());
		diffGovernmentRefinanceTypeOtherDescription(test.getGovernmentRefinanceTypeOtherDescription(), control.getGovernmentRefinanceTypeOtherDescription());
		diffPropertyEnergyEfficientHomeIndicator(test.getPropertyEnergyEfficientHomeIndicator(), control.getPropertyEnergyEfficientHomeIndicator());
		diffSectionOfActType(test.getSectionOfActType(), control.getSectionOfActType());
		diffVABorrowerCoBorrowerMarriedIndicator(test.getVABorrowerCoBorrowerMarriedIndicator(), control.getVABorrowerCoBorrowerMarriedIndicator());
		diffVAEntitlementAmount(test.getVAEntitlementAmount(), control.getVAEntitlementAmount());
		diffVAMaintenanceExpenseMonthlyAmount(test.getVAMaintenanceExpenseMonthlyAmount(), control.getVAMaintenanceExpenseMonthlyAmount());
		diffVAUtilityExpenseMonthlyAmount(test.getVAUtilityExpenseMonthlyAmount(), control.getVAUtilityExpenseMonthlyAmount());

		
	}

	private void diffFHALoanLenderIdentifier(String test, String control) {
		diffObject(test, control, "FHALoanLenderIdentifier");
		
	}

	private void diffFHALoanSponsorIdentifier(String test, String control) {
		diffObject(test, control, "FHALoanSponsorIdentifier");
		
	}

	private void diffFHA_MIPremiumRefundAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "FHA_MIPremiumRefundAmount");
		
	}

	private void diffGovernmentMortgageCreditCertificateAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "GovernmentMortgageCreditCertificateAmount");
		
	}

	private void diffGovernmentRefinanceType(String test, String control) {
		diffObject(test, control, "GovernmentRefinanceType");
		
	}

	private void diffGovernmentRefinanceTypeOtherDescription(String test, String control) {
		diffObject(test, control, "GovernmentRefinanceTypeOtherDescription");
		
	}

	private void diffPropertyEnergyEfficientHomeIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "PropertyEnergyEfficientHomeIndicator");
		
	}

	private void diffSectionOfActType(String test, String control) {
		diffObject(test, control, "SectionOfActType");
		
	}

	private void diffVABorrowerCoBorrowerMarriedIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "VABorrowerCoBorrowerMarriedIndicator");
		
	}

	private void diffVAEntitlementAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "VAEntitlementAmount");
		
	}

	private void diffVAMaintenanceExpenseMonthlyAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "VAMaintenanceExpenseMonthlyAmount");
		
	}

	private void diffVAUtilityExpenseMonthlyAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "VAUtilityExpenseMonthlyAmount");
		
	}

	private void compareExtension(information.dU34.Mes.DeaSet.Dea.Loa.Extension test,
			information.dU34.Mes.DeaSet.Dea.Loa.Extension control) {
		if (control != null) {
			compareOther(test.getOther(), control.getOther());
		}
		
	}

	private void compareOther(information.dU34.Mes.DeaSet.Dea.Loa.Ext.Other test,
			information.dU34.Mes.DeaSet.Dea.Loa.Ext.Other control) {
		if (control != null) {
			compareLoan_Extension(test.getLoan_Extension(), control.getLoan_Extension());
		}
		
	}

	private void compareLoan_Extension(Loan_Extension test, Loan_Extension control) {
		if (control != null) {
			compareUnderwriting_Verifications(test.getUnderwriting_Verifications(), control.getUnderwriting_Verifications());
		}
		
	}

	private void compareUnderwriting_Verifications(List<Underwriting_Verification> test, List<Underwriting_Verification> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareUnderwriting_Verification(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareUnderwriting_Verification(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareUnderwriting_Verification(Underwriting_Verification test,
			Underwriting_Verification control) {
		diffVerificationReportIdentifier(test.getVerificationReportIdentifier(), control.getVerificationReportIdentifier());
		diffVerificationReportSupplierType(test.getVerificationReportSupplierType(), control.getVerificationReportSupplierType());
		diffVerificationReportType(test.getVerificationReportType(), control.getVerificationReportType());

		
	}

	private void diffVerificationReportIdentifier(String test, String control) {
		diffObject(test, control, "VerificationReportIdentifier");
		
	}

	private void diffVerificationReportSupplierType(String test, String control) {
		diffObject(test, control, "VerificationReportSupplierType");
		
	}

	private void diffVerificationReportType(String test, String control) {
		diffObject(test, control, "VerificationReportType");
		
	}

	private void compareDocument_Specific_Data_Sets(List<Document_Specific_Data_Set> test, List<Document_Specific_Data_Set> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDocument_Specific_Data_Set(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareDocument_Specific_Data_Set(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareDocument_Specific_Data_Set(Document_Specific_Data_Set test, Document_Specific_Data_Set control) {
		if (control != null) {
			compareURLA(test.getURLA(), control.getURLA());
		}
		
	}

	private void compareURLA(URLA test, URLA control) {
		if (control != null) {
			compareURLA_Detail(test.getURLA_Detail(), control.getURLA_Detail());
			compareURLA_Total(test.getURLA_Total(), control.getURLA_Total());
		}
		
	}

	private void compareURLA_Total(URLA_Total test, URLA_Total control) {
		if (control != null) {
			compareExtension(test.getExtension(), control.getExtension());
		}
		
	}

	private void compareExtension(information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL.URLTot.Extension test,
			information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL.URLTot.Extension control) {
		if (control != null) {
			compareOther(test.getOther(), control.getOther());
		}
		
	}

	private void compareOther(information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL.URLTot.Ext.Other test,
			information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL.URLTot.Ext.Other control) {
		if (control != null) {
			compareURLA_Total_Extension(test.getURLA_Total_Extension(), control.getURLA_Total_Extension());
		}
		
	}

	private void compareURLA_Total_Extension(URLA_Total_Extension test, URLA_Total_Extension control) {
		diffURLATotalSellerCreditsAmount(test.getURLATotalSellerCreditsAmount(), control.getURLATotalSellerCreditsAmount());
		
	}

	private void diffURLATotalSellerCreditsAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "URLATotalSellerCreditsAmount");
		
	}

	private void compareURLA_Detail(URLA_Detail test, URLA_Detail control) {
		diffAlterationsImprovementsAndRepairsAmount(test.getAlterationsImprovementsAndRepairsAmount(), control.getAlterationsImprovementsAndRepairsAmount());
		diffApplicationSignedByLoanOriginatorDate(test.getApplicationSignedByLoanOriginatorDate(), control.getApplicationSignedByLoanOriginatorDate());
		diffBorrowerPaidDiscountPointsTotalAmount(test.getBorrowerPaidDiscountPointsTotalAmount(), control.getBorrowerPaidDiscountPointsTotalAmount());
		diffEstimatedClosingCostsAmount(test.getEstimatedClosingCostsAmount(), control.getEstimatedClosingCostsAmount());
		diffMIAndFundingFeeFinancedAmount(test.getMIAndFundingFeeFinancedAmount(), control.getMIAndFundingFeeFinancedAmount());
		diffMIAndFundingFeeTotalAmount(test.getMIAndFundingFeeTotalAmount(), control.getMIAndFundingFeeTotalAmount());
		diffPrepaidItemsEstimatedAmount(test.getPrepaidItemsEstimatedAmount(), control.getPrepaidItemsEstimatedAmount());
		diffRefinanceImprovementCostsAmount(test.getRefinanceImprovementCostsAmount(), control.getRefinanceImprovementCostsAmount());
		diffRefinanceImprovementsType(test.getRefinanceImprovementsType(), control.getRefinanceImprovementsType());

		
	}

	private void diffAlterationsImprovementsAndRepairsAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "AlterationsImprovementsAndRepairsAmount");
		
	}

	private void diffApplicationSignedByLoanOriginatorDate(LocalDate test, LocalDate control) {
		diffObject(test, control, "ApplicationSignedByLoanOriginatorDate");
		
	}

	private void diffBorrowerPaidDiscountPointsTotalAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "BorrowerPaidDiscountPointsTotalAmount");
		
	}

	private void diffEstimatedClosingCostsAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "EstimatedClosingCostsAmount");
		
	}

	private void diffMIAndFundingFeeFinancedAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "MIAndFundingFeeFinancedAmount");
		
	}

	private void diffMIAndFundingFeeTotalAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "MIAndFundingFeeTotalAmount");
		
	}

	private void diffPrepaidItemsEstimatedAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "PrepaidItemsEstimatedAmount");
		
	}

	private void diffRefinanceImprovementCostsAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "RefinanceImprovementCostsAmount");
		
	}

	private void diffRefinanceImprovementsType(String test, String control) {
		diffObject(test, control, "RefinanceImprovementsType");
		
	}

	private void compareConstruction(Construction test, Construction control) {
		diffConstructionImprovementCostsAmount(test.getConstructionImprovementCostsAmount(), control.getConstructionImprovementCostsAmount());
		diffConstructionLoanType(test.getConstructionImprovementCostsAmount(), control.getConstructionImprovementCostsAmount());
		diffConstructionToPermanentClosingType(test.getConstructionToPermanentClosingType(), control.getConstructionToPermanentClosingType());
		diffLandAppraisedValueAmount(test.getLandAppraisedValueAmount(), control.getLandAppraisedValueAmount());
		diffLandOriginalCostAmount(test.getLandOriginalCostAmount(), control.getLandOriginalCostAmount());

		
	}

	private void diffConstructionLoanType(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "ConstructionLoanType");
		
	}

	private void diffConstructionToPermanentClosingType(String test, String control) {
		diffObject(test, control, "ConstructionToPermanentClosingType");
		
	}

	private void diffLandAppraisedValueAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "LandAppraisedValueAmount");
		
	}

	private void diffLandOriginalCostAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "LandOriginalCostAmount");
		
	}

	private void diffConstructionImprovementCostsAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "ConstructionImprovementCostsAmount");
		
	}

	private void compareClosing_Information(Closing_Information test, Closing_Information control) {
		if (control != null) {
			compareClosing_Adjustment_Items(test.getClosing_Adjustment_Items(), control.getClosing_Adjustment_Items());
			compareClosing_Information_Detail(test.getClosing_Information_Detail(), control.getClosing_Information_Detail());
		}
		
	}

	private void compareClosing_Information_Detail(Closing_Information_Detail test, Closing_Information_Detail control) {
		diffCashFromBorrowerAtClosingAmount(test.getCashFromBorrowerAtClosingAmount(), control.getCashFromBorrowerAtClosingAmount());
		diffCashToBorrowerAtClosingAmount(test.getCashToBorrowerAtClosingAmount(), control.getCashToBorrowerAtClosingAmount());

		
	}

	private void diffCashToBorrowerAtClosingAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "CashToBorrowerAtClosingAmount");
		
	}

	private void diffCashFromBorrowerAtClosingAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "CashFromBorrowerAtClosingAmount");
		
	}

	private void compareClosing_Adjustment_Items(List<Closing_Adjustment_Item> test, List<Closing_Adjustment_Item> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareClosing_Adjustment_Item(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareClosing_Adjustment_Item(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareClosing_Adjustment_Item(Closing_Adjustment_Item test, Closing_Adjustment_Item control) {
		if (control.getClosing_Adjustment_Item_Detail() != null)
			compareClosing_Adjustment_Item_Detail(test.getClosing_Adjustment_Item_Detail(), control.getClosing_Adjustment_Item_Detail());
		
	}

	private void compareClosing_Adjustment_Item_Detail(Closing_Adjustment_Item_Detail test, Closing_Adjustment_Item_Detail control) {
		diffClosingAdjustmentItemAmount(test.getClosingAdjustmentItemAmount(), control.getClosingAdjustmentItemAmount());
		diffClosingAdjustmentItemType(test.getClosingAdjustmentItemType(), control.getClosingAdjustmentItemType());

		
	}

	private void diffClosingAdjustmentItemType(String test, String control) {
		diffObject(test, control, "ClosingAdjustmentItemType");
		
	}

	private void diffClosingAdjustmentItemAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "ClosingAdjustmentItemAmount");
		
	}

	private void compareBuydown(Buydown test, Buydown control) {
		if (control != null) {
			compareBuydown_Occurrences(test.getBuydown_Occurrences(), control.getBuydown_Occurrences());
		}
	}

	private void compareBuydown_Occurrences(List<Buydown_Occurrence> test, List<Buydown_Occurrence> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareBuydown_Occurrence(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareBuydown_Occurrence(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareBuydown_Occurrence(Buydown_Occurrence test, Buydown_Occurrence control) {
		diffBuydownInitialEffectiveInterestRatePercent(test.getBuydownInitialEffectiveInterestRatePercent(), control.getBuydownInitialEffectiveInterestRatePercent());
		
	}

	private void diffBuydownInitialEffectiveInterestRatePercent(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "BuydownInitialEffectiveInterestRatePercent");
		
	}

	private void compareAmortization(Amortization test, Amortization control) {
		if (control != null) {
			compareAmortization_Rule(test.getAmortization_Rule(), control.getAmortization_Rule());
		}
	}

	private void compareAmortization_Rule(Amortization_Rule test, Amortization_Rule control) {
		diffAmortizationTypeOtherDescription(test.getAmortizationTypeOtherDescription(), control.getAmortizationTypeOtherDescription());
		diffLoanAmortizationPeriodCount(test.getLoanAmortizationPeriodCount(), control.getLoanAmortizationPeriodCount());
		diffLoanAmortizationPeriodType(test.getLoanAmortizationPeriodType(), control.getLoanAmortizationPeriodType());
		
	}

	private void diffLoanAmortizationPeriodType(String test, String control) {
		diffObject(test, control, "LoanAmortizationPeriodType");
		
	}

	private void diffLoanAmortizationPeriodCount(Integer test, Integer control) {
		diffObject(test, control, "LoanAmortizationPeriodCount");
		
	}

	private void diffAmortizationTypeOtherDescription(String test, String control) {
		diffObject(test, control, "AmortizationTypeOtherDescription");
		
	}

	private void compareAffordable_Lending(Affordable_Lending test, Affordable_Lending control) {
		diffCommunityLendingProductType(test.getCommunityLendingProductType(), control.getCommunityLendingProductType());
		diffCommunitySecondsRepaymentType(test.getCommunitySecondsRepaymentType(), control.getCommunitySecondsRepaymentType());
		diffHUDIncomeLimitAdjustmentPercent(test.getHUDIncomeLimitAdjustmentPercent(), control.getHUDIncomeLimitAdjustmentPercent());
		
	}

	private void diffHUDIncomeLimitAdjustmentPercent(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "HUDIncomeLimitAdjustmentPercent");
		
	}

	private void diffCommunitySecondsRepaymentType(String test, String control) {
		diffObject(test, control, "CommunitySecondsRepaymentType");
		
	}

	private void diffCommunityLendingProductType(String test, String control) {
		diffObject(test, control, "CommunityLendingProductType");
		
	}

	private void compareAdjustment(Adjustment test, Adjustment control) {
		if (control.getInterest_Rate_Adjustment() != null)
			compareInterest_Rate_Adjustment(test.getInterest_Rate_Adjustment(), control.getInterest_Rate_Adjustment());
		
	}

	private void compareInterest_Rate_Adjustment(Interest_Rate_Adjustment test, Interest_Rate_Adjustment control) {
		if (control != null) {
			compareIndex_Rules(test.getIndex_Rules(), control.getIndex_Rules());
			compareInterest_Rate_Lifetime_Adjustment_Rule(test.getInterest_Rate_Lifetime_Adjustment_Rule(), control.getInterest_Rate_Lifetime_Adjustment_Rule());
			compareInterest_Rate_Per_Change_Adjustment_Rules(test.getInterest_Rate_Per_Change_Adjustment_Rules(), control.getInterest_Rate_Per_Change_Adjustment_Rules());
		}
		
	}

	private void compareInterest_Rate_Per_Change_Adjustment_Rules(List<Interest_Rate_Per_Change_Adjustment_Rule> test, List<Interest_Rate_Per_Change_Adjustment_Rule> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareInterest_Rate_Per_Change_Adjustment_Rule(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareInterest_Rate_Per_Change_Adjustment_Rule(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareInterest_Rate_Per_Change_Adjustment_Rule(Interest_Rate_Per_Change_Adjustment_Rule test, Interest_Rate_Per_Change_Adjustment_Rule control) {
		diffAdjustmentRuleType(test.getAdjustmentRuleType(), control.getAdjustmentRuleType());
		diffPerChangeMaximumIncreasePercent(test.getPerChangeMaximumIncreaseRatePercent(), control.getPerChangeMaximumIncreaseRatePercent());
		diffPerChangeRateAdjustmentFrequencyMonthsCount(test.getPerChangeRateAdjustmentFrequencyMonthsCount(), control.getPerChangeRateAdjustmentFrequencyMonthsCount());
		
	}

	private void diffPerChangeRateAdjustmentFrequencyMonthsCount(Integer test, Integer control) {
		diffObject(test, control, "PerChangeRateAdjustmentFrequencyMonthsCount");
		
	}

	private void diffPerChangeMaximumIncreasePercent(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "PerChangeMaximumIncreasePercent");
		
	}

	private void diffAdjustmentRuleType(String test, String control) {
		diffObject(test, control, "AdjustmentRuleType");
		
	}

	private void compareInterest_Rate_Lifetime_Adjustment_Rule(Interest_Rate_Lifetime_Adjustment_Rule test, Interest_Rate_Lifetime_Adjustment_Rule control) {
		diffCeilingRatePercent(test.getCeilingRatePercent(), control.getCeilingRatePercent());
		diffMarginRatePercent(test.getMarginRatePercent(), control.getMarginRatePercent());
		
	}

	private void diffMarginRatePercent(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "MarginRatePercent");
		
	}

	private void diffCeilingRatePercent(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "CeilingRatePercent");
		
	}

	private void compareIndex_Rules(List<Index_Rule> test, List<Index_Rule> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareIndex_Rule(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareIndex_Rule(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareIndex_Rule(Index_Rule test, Index_Rule control) {
		diffIndexSourceType(test.getIndexSourceType(), control.getIndexSourceType());
		diffIndexSourceTypeOtherDescription(test.getIndexSourceTypeOtherDescription(), control.getIndexSourceTypeOtherDescription());
		
	}

	private void diffIndexSourceTypeOtherDescription(String test, String control) {
		diffObject(test, control, "IndexSourceTypeOtherDescription");
		
	}

	private void diffIndexSourceType(String test, String control) {
		diffObject(test, control, "IndexSourceType");
		
	}

	private void compareLiability_Summary(Liability_Summary test, Liability_Summary control) {
		diffTotalNonSubjectPropertyDebtsToBePaidOffAmount(test.getTotalNonSubjectPropertyDebtsToBePaidOffAmount(), control.getTotalNonSubjectPropertyDebtsToBePaidOffAmount());
		diffTotalSubjectPropertyPayoffsAndPaymentsAmount(test.getTotalSubjectPropertyPayoffsAndPaymentsAmount(), control.getTotalSubjectPropertyPayoffsAndPaymentsAmount());
		
	}

	private void diffTotalSubjectPropertyPayoffsAndPaymentsAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "TotalSubjectPropertyPayoffsAndPaymentsAmount");
		
	}

	private void diffTotalNonSubjectPropertyDebtsToBePaidOffAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "TotalNonSubjectPropertyDebtsToBePaidOffAmount");
		
	}
	
	private void compareLiabilities(List<Liability> test, List<Liability> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareLiability(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareLiability(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareLiability(Liability test, Liability control) {
		if (control != null) {
			compareLiability_Detail(test.getLiability_Detail(), control.getLiability_Detail());
			compareLiability_Holder(test.getLiability_Holder(), control.getLiability_Holder());
		}
		
	}

	private void compareLiability_Holder(Liability_Holder test, Liability_Holder control) {
		if (control != null) {
			compareName(test.getName(), control.getName());
		}
		
	}

	private void compareName(information.uCD33.common.Name test, information.uCD33.common.Name control) {
		diffFullName(test.getFullName(), control.getFullName());
		
	}

	private void compareLiability_Detail(Liability_Detail test, Liability_Detail control) {
		diffHELOCMaximumBalanceAmount(test.getHELOCMaximumBalanceAmount(), control.getHELOCMaximumBalanceAmount());
		diffLiabilityMonthlyPaymentAmount(test.getLiabilityMonthlyPaymentAmount(), control.getLiabilityMonthlyPaymentAmount());
		diffLiabilityPaymentIncludesTaxesInsuranceIndicator(test.getLiabilityPaymentIncludesTaxesInsuranceIndicator(), control.getLiabilityPaymentIncludesTaxesInsuranceIndicator());
		diffLiabilityPayoffStatusIndicator(test.getLiabilityPayoffStatusIndicator(), control.getLiabilityPayoffStatusIndicator());
		diffLiabilityRemainingTermMonthsCount(test.getLiabilityRemainingTermMonthsCount(), control.getLiabilityRemainingTermMonthsCount());
		diffLiabilityType(test.getLiabilityType(), control.getLiabilityType());
		diffLiabilityTypeOtherDescription(test.getLiabilityTypeOtherDescription(), control.getLiabilityTypeOtherDescription());
		diffLiabilityUnpaidBalanceAmount(test.getLiabilityUnpaidBalanceAmount(), control.getLiabilityUnpaidBalanceAmount());
		diffLiabilityAccountIdentifier(test.getLiabilityAccountIdentifier(), control.getLiabilityAccountIdentifier());
		diffLiabilityExclusionIndicator(test.getLiabilityExclusionIndicator(), control.getLiabilityExclusionIndicator());
		
	}

	private void diffLiabilityExclusionIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "LiabilityExlusionIndicator");
		
	}

	private void diffLiabilityAccountIdentifier(String test, String control) {
		diffObject(test, control, "LiabilityAccountIdentifier");
		
	}

	private void diffLiabilityUnpaidBalanceAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "LiabilityUnpaidBalanceAmount");
		
	}

	private void diffLiabilityTypeOtherDescription(String test, String control) {
		diffObject(test, control, "LiabilityTypeOtherDescription");
		
	}

	private void diffLiabilityType(String test, String control) {
		diffObject(test, control, "LiabilityType");
		
	}

	private void diffLiabilityRemainingTermMonthsCount(Integer test, Integer control) {
		diffObject(test, control, "LiabilityRemainingTermMonthsCount");
		
	}

	private void diffLiabilityPayoffStatusIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "LiabilityPayoffStatusIndicator");
		
	}

	private void diffLiabilityPaymentIncludesTaxesInsuranceIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "LiabilityPaymentIncludesTaxesInsuranceIndicator");
		
	}

	private void diffLiabilityMonthlyPaymentAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "LiabilityMonthlyPaymentAmount");
		
	}

	

	private void compareExpenses(List<Expense> test, List<Expense> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareExpense(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareExpense(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareExpense(Expense test, Expense control) {
		diffExpenseMonthlyPaymentAmount(test.getExpenseMonthlyPaymentAmount(), control.getExpenseMonthlyPaymentAmount());
		diffExpenseRemainingTermMonthsCount(test.getExpenseRemainingTermMonthsCount(), control.getExpenseRemainingTermMonthsCount());
		diffExpenseType(test.getExpenseType(), control.getExpenseType());
		diffExpenseTypeOtherDescription(test.getExpenseTypeOtherDescription(), control.getExpenseTypeOtherDescription());
		
	}

	private void diffExpenseTypeOtherDescription(String test, String control) {
		diffObject(test, control, "ExpenseTypeOtherDescription");
		
	}

	private void diffExpenseType(String test, String control) {
		diffObject(test, control, "ExpenseType");
		
	}

	private void diffExpenseRemainingTermMonthsCount(Integer test, Integer control) {
		diffObject(test, control, "ExpenseRemainingTermMonthsCount");
		
	}

	private void diffExpenseMonthlyPaymentAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "ExpenseMonthlyPaymentAmount");
		
	}

	private void compareCollaterals(List<Collateral> test, List<Collateral> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareCollateral(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareCollateral(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareCollateral(Collateral test, Collateral control) {
		if (control != null)
			compareSubject_Property(test.getSubject_Property(), control.getSubject_Property());
		
	}

	private void compareSubject_Property(Subject_Property test, Subject_Property control) {
		if (control.getAddress() != null) {
			compareAddress(test.getAddress(), control.getAddress()); //reused compare
			compareLocation_Identifier(test.getLocation_Identifier(), control.getLocation_Identifier());
			compareProperty_Detail(test.getProperty_Detail(), control.getProperty_Detail());
			compareProperty_Valuations(test.getProperty_Valuations(), control.getProperty_Valuations()); //reused compare
			compareProject(test.getProject(), control.getProject());
			compareSales_Contracts2(test.getSales_Contracts(), control.getSales_Contracts()); //todo 2
		}
		
	}

	private void compareProperty_Valuations(List<Property_Valuation> test, List<Property_Valuation> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareProperty_Valuation(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareProperty_Valuation(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareProperty_Valuation(Property_Valuation test, Property_Valuation control) {
		if (control != null) {
			compareProperty_Valuation_Detail(test.getProperty_Valuation_Detail(), control.getProperty_Valuation_Detail());
		}
		
	}

	private void compareProperty_Valuation_Detail(Property_Valuation_Detail test, Property_Valuation_Detail control) {
		diffPropertyValuationAmount(test.getPropertyValuationAmount(), control.getPropertyValuationAmount());
		diffAppraisalIdentifier(test.getAppraisalIdentifier(), control.getAppraisalIdentifier());
		
	}

	private void compareSales_Contracts2( //todo 2
			List<information.dU34.Mes.DeaSet.Dea.Col.SubPro.Sales_Contract> test,
			List<information.dU34.Mes.DeaSet.Dea.Col.SubPro.Sales_Contract> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareSales_Contract2(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareSales_Contract2(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareSales_Contract2(information.dU34.Mes.DeaSet.Dea.Col.SubPro.Sales_Contract test,
			information.dU34.Mes.DeaSet.Dea.Col.SubPro.Sales_Contract control) { //todo 2
		if (control != null) {
			compareSales_Concessions(test.getSales_Concessions(), control.getSales_Concessions());
			compareSales_Contract_Detail(test.getSales_Contract_Detail(), control.getSales_Contract_Detail()); 
		}
		
	}

	private void compareSales_Concessions(List<Sales_Concession> test, List<Sales_Concession> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareSales_Concession(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareSales_Concession(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareSales_Concession(Sales_Concession test, Sales_Concession control) {
		diffSalesConcessionAmount(test.getSalesConcessionAmount(), control.getSalesConcessionAmount());
		
	}

	private void diffSalesConcessionAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "SalesConcessionAmount");
		
	}

	private void compareProject(Project test, Project control) {
		if (control != null)
			compareProject_Detail(test.getProject_Detail(), control.getProject_Detail());
		
	}

	private void compareProject_Detail(Project_Detail test, Project_Detail control) {
		diffProjectDesignType(test.getProjectDesignType(), control.getProjectDesignType());
		diffProjectLegalStructureType(test.getProjectLegalStructureType(), control.getProjectLegalStructureType());
		
	}

	private void diffProjectLegalStructureType(String test, String control) {
		diffObject(test, control, "ProjectLegalStructureType");
		
	}

	private void diffProjectDesignType(String test, String control) {
		diffObject(test, control, "ProjectDesignType");
		
	}

	private void compareProperty_Detail(information.dU34.Mes.DeaSet.Dea.Col.SubPro.Property_Detail test,
			information.dU34.Mes.DeaSet.Dea.Col.SubPro.Property_Detail control) {
		diffConstructionMethodType(test.getConstructionMethodType(), control.getConstructionMethodType());
		diffConstructionMethodTypeOtherDescription(test.getConstructionMethodTypeOtherDescription(), control.getConstructionMethodTypeOtherDescription());
		diffFHASecondaryResidenceIndicator(test.getFHASecondaryResidenceIndicator(), control.getFHASecondaryResidenceIndicator());
		diffFinancedUnitCount(test.getFinancedUnitCount(), control.getFinancedUnitCount());
		diffNativeAmericanLandsType(test.getNativeAmericanLandsType(), control.getNativeAmericanLandsType());
		diffNativeAmericanLandsTypeOtherDescription(test.getNativeAmericanLandsTypeOtherDescription(), control.getNativeAmericanLandsTypeOtherDescription());
		diffPropertyAcquiredDate(test.getPropertyAcquiredDate(), control.getPropertyAcquiredDate());
		diffPropertyEstateType(test.getPropertyEstateType(), control.getPropertyEstateType());
		diffPropertyEstimatedValueAmount(test.getPropertyEstimatedValueAmount(), control.getPropertyEstimatedValueAmount());
		diffPropertyExistingCleanEnergyLienIndicator(test.getPropertyExistingCleanEnergyLienIndicator(), control.getPropertyExistingCleanEnergyLienIndicator());
		diffPropertyGroundLeaseExpirationDate(test.getPropertyGroundLeaseExpirationDate(), control.getPropertyGroundLeaseExpirationDate());
		diffPropertyInProjectIndicator(test.getPropertyInProjectIndicator(), control.getPropertyInProjectIndicator());
		diffPropertyMixedUsageIndicator(test.getPropertyMixedUsageIndicator(), control.getPropertyMixedUsageIndicator());
		diffPropertyStructureBuiltYear(test.getPropertyStructureBuiltYear(), control.getPropertyStructureBuiltYear());
		diffPropertyUsageType(test.getPropertyUsageType(), control.getPropertyUsageType());
		diffPUDIndicator(test.getPUDIndicator(), control.getPUDIndicator());
		diffRentalEstimatedGrossMonthlyRentAmount(test.getRentalEstimatedGrossMonthlyRentAmount(), control.getRentalEstimatedGrossMonthlyRentAmount());
		diffRentalEstimatedNetMonthlyRentAmount(test.getRentalEstimatedNetMonthlyRentAmount(), control.getRentalEstimatedNetMonthlyRentAmount());
		
	}

	private void diffRentalEstimatedNetMonthlyRentAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "RentalEstimatedNetMonthlyRentAmount");
		
	}

	private void diffRentalEstimatedGrossMonthlyRentAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "RentalEstimatedGrossMonthlyRentAmount");
		
	}

	private void diffPUDIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "PUDIndicator");
		
	}

	private void diffPropertyStructureBuiltYear(String test, String control) {
		diffObject(test, control, "PropertyStructureBuiltYear");
		
	}

	private void diffPropertyInProjectIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "PropertyInProjectIndicator");
		
	}

	private void diffPropertyGroundLeaseExpirationDate(LocalDate test, LocalDate control) {
		diffObject(test, control, "PropertyGroundLeaseExpirationDate");
		
	}

	private void diffPropertyExistingCleanEnergyLienIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "PropertyExistingCleanEnergyLienIndicator");
		
	}

	private void diffPropertyEstateType(String test, String control) {
		diffObject(test, control, "PropertyEstateType");
		
	}

	private void diffPropertyAcquiredDate(LocalDate test, LocalDate control) {
		diffObject(test, control, "PropertyAcquiredDate");
		
	}

	private void diffNativeAmericanLandsTypeOtherDescription(String test, String control) {
		diffObject(test, control, "NativeAmericanLandsTypeOtherDescription");
		
	}

	private void diffNativeAmericanLandsType(String test, String control) {
		diffObject(test, control, "NativeAmericanLandsType");
		
	}

	private void diffPropertyEstimatedValueAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "PropertyEstimatedValueAmount");
		
	}

	private void diffFinancedUnitCount(Integer test, Integer control) {
		diffObject(test, control, "FinancedUnitCount");
		
	}

	private void compareLocation_Identifier(Location_Identifier test, Location_Identifier control) {
		if (control != null) {
			compareCensus_Information(test.getCensus_Information(), control.getCensus_Information());
			compareFIPS_Information(test.getfIPS_Information(), control.getfIPS_Information());
			compareGeneral_Identifier(test.getGeneral_Identifier(), control.getGeneral_Identifier());
		}
		
	}

	private void compareGeneral_Identifier(General_Identifier test, General_Identifier control) {
		diffMSAIdentifier(test.getMSAIdentifier(), control.getMSAIdentifier());
		
	}

	private void diffMSAIdentifier(String test, String control) {
		diffObject(test, control, "MSAIdentifier");
		
	}

	private void compareCensus_Information(Census_Information test, Census_Information control) {
		diffCensusTractIdentifier(test.getCensusTractIdentifier(), control.getCensusTractIdentifier());
		
	}

	private void diffCensusTractIdentifier(String test, String control) {
		diffObject(test, control, "CensusTractIdentifier");
		
	}

	private void compareFIPS_Information(FIPS_Information testFIPS, FIPS_Information controlFIPS) {
		diffFIPSCountyCode(testFIPS.getfIPSCountyCode(), controlFIPS.getfIPSCountyCode());
		diffFIPSStateNumericCode(testFIPS.getfIPSStateNumericCode(), controlFIPS.getfIPSStateNumericCode());
		
	}

	private void diffFIPSStateNumericCode(String test, String control) {
		diffObject(test, control, "FIPSStateNumericCode");
		
	}

	private void diffFIPSCountyCode(String test, String control) {
		diffObject(test, control, "FIPSCountyCode");
		
	}

	private void compareAssets(List<Asset> test, List<Asset> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareAsset(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareAsset(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareAsset(Asset test, Asset control) {
		if (control != null) {
			compareAsset_Detail(test.getAsset_Detail(), control.getAsset_Detail());
			compareAsset_Holder(test.getAsset_Holder(), control.getAsset_Holder());
			compareOwned_Property(test.getOwned_Property(), control.getOwned_Property());
		}
	}

	private void compareOwned_Property(Owned_Property test, Owned_Property control) {
		if (control != null) {
			compareProperty(test.getProperty(), control.getProperty());
		}
		
	}

	private void compareProperty(Property test, Property control) {
		if (control != null) {
			compareAddress(test.getAddress(), control.getAddress());
			compareProperty_Detail(test.getProperty_Detail(), control.getProperty_Detail());
			compareProperty_Valuations2(test.getProperty_Valuations(), control.getProperty_Valuations()); //reused compare
			compareSales_Contracts1(test.getSales_Contracts(), control.getSales_Contracts());
		}
		
	}

	private void compareSales_Contracts1(List<Sales_Contract> test, List<Sales_Contract> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareSales_Contract(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareSales_Contract(test.get(i), control.get(i));
			}
		}
	}

	private void compareSales_Contract(Sales_Contract test, Sales_Contract control) {
		if (control != null) {
			compareSales_Contract_Detail(test.getSales_Contract_Detail(), control.getSales_Contract_Detail());
		}
	}

	private void compareSales_Contract_Detail(Sales_Contract_Detail test, Sales_Contract_Detail control) {
		diffSalesContractAmount(test.getSalesContractAmount(), control.getSalesContractAmount());
	}

	private void diffSalesContractAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "SalesContractAmount");
	}

	private void compareProperty_Valuations2(List<information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.Property_Valuation> test, List<information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.Property_Valuation> control) {
		int size = control.size();
		if (cardinality(test, control) <= 0) {
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareProperty_Valuation2(test.get(i), control.get(i));
			}
		}
		else {
			size = test.size();
			for (int i=0; i < size; i++) {
				if (control.get(i) != null)
					compareProperty_Valuation2(test.get(i), control.get(i));
			}
		}
		
	}

	private void compareProperty_Valuation2(information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.Property_Valuation test, information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.Property_Valuation control) {
		if (control != null) {
			compareProperty_Valuation_Detail2(test.getProperty_Valuation_Detail(), control.getProperty_Valuation_Detail());
		}
		
	}

	private void compareProperty_Valuation_Detail2(information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.ProVal.Property_Valuation_Detail test, 
			information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.ProVal.Property_Valuation_Detail control) {
		diffPropertyValuationAmount(test.getPropertyValuationAmount(), control.getPropertyValuationAmount());
		
		
	}

	private void diffAppraisalIdentifier(String test, String control) {
		diffObject(test, control, "AppraisalIdentifier");
		
	}

	private void diffPropertyValuationAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "PropertyValuationAmount");
		
	}

	private void compareProperty_Detail(information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.Property_Detail test, information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.Property_Detail control) {
		diffOwnedPropertyDispositionStatusType(test.getOwnedPropertyDispositionStatusType(), control.getOwnedPropertyDispositionStatusType());
		diffOwnedPropertyLienUPBAmount(test.getOwnedPropertyLienUPBAmount(), control.getOwnedPropertyLienUPBAmount());
		diffOwnedPropertyMaintenanceExpenseAmount(test.getOwnedPropertyMaintenanceExpenseAmount(), control.getOwnedPropertyMaintenanceExpenseAmount());
		diffOwnedPropertyRentalIncomeGrossAmount(test.getOwnedPropertyRentalIncomeGrossAmount(), control.getOwnedPropertyRentalIncomeGrossAmount());
		diffOwnedPropertyRentalIncomeNetAmount(test.getOwnedPropertyRentalIncomeNetAmount(), control.getOwnedPropertyRentalIncomeNetAmount());
		diffOwnedPropertySubjectIndicator(test.getOwnedPropertySubjectIndicator(), control.getOwnedPropertySubjectIndicator());
		diffPropertyEstimatedValueAmount(test.getPropertyEstimatedValueAmount(), control.getPropertyEstimatedValueAmount());
	}

	private void diffPropertyUsageType(String test, String control) {
		diffObject(test, control, "PropertyUsageType");
	}

	private void diffPropertyMixedUsageIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "PropertyMixedUsageIndicator");
	}

	private void diffFHASecondaryResidenceIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "FHASecondaryResidenceIndicator");
	}

	private void diffConstructionMethodTypeOtherDescription(String test, String control) {
		diffObject(test, control, "ConstructionMethodTypeOtherDescription");
	}

	private void diffConstructionMethodType(String test, String control) {
		diffObject(test, control, "ConstructionMethodType");
		
	}

	private void compareAddress(Address test, Address control) {
		diffAddressLineText(test.getAddressLineText(), control.getAddressLineText());
		diffCityName(test.getCityName(), control.getCityName());
		diffPostalCode(test.getPostalCode(), control.getPostalCode());
		diffStateCode(test.getStateCode(), control.getStateCode());
		diffAddressUnitIdentifier(test.getAddressUnitIdentifier(), control.getAddressUnitIdentifier());
		
	}

	private void diffAddressUnitIdentifier(String test, String control) {
		diffObject(test, control, "AddressUnitIdentifier");
	}

	private void diffStateCode(String test, String control) {
		diffObject(test, control, "StateCode");
	}

	private void diffPostalCode(String test, String control) {
		diffObject(test, control, "PostalCode");
	}

	private void diffCityName(String test, String control) {
		diffObject(test, control, "CityName");
	}

	private void diffAddressLineText(String test, String control) {
		diffObject(test, control, "AddressLineText");
	}

	private void diffOwnedPropertySubjectIndicator(Boolean test, Boolean control) {
		diffObject(test, control, "OwnedPropertySubjectIndicator");
		
	}

	private void diffOwnedPropertyRentalIncomeNetAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "OwnedPropertyRentalIncomeNetAmount");
		
	}

	private void diffOwnedPropertyRentalIncomeGrossAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "OwnedPropertyRentalIncomeGrossAmount");
		
	}

	private void diffOwnedPropertyMaintenanceExpenseAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "OwnedPropertyMaintenanceExpenseAmount");
		
	}

	private void diffOwnedPropertyLienUPBAmount(BigDecimal test, BigDecimal control) {
		diffObject(test, control, "OwnedPropertyLienUPBAmount");
	}

	private void diffOwnedPropertyDispositionStatusType(String testOPDST, String controlOPDST) {
		diffObject(testOPDST, controlOPDST, "OwnedPropertyDispositionStatusType");
	}

	private void compareAsset_Holder(Asset_Holder test, Asset_Holder control) {
		if (control.getName() != null) {
			compareName(test.getName(), control.getName());
		}
	}

	private void compareName(Name testName, Name controlName) {
		diffFullName(testName.getFullName(), controlName.getFullName());
	}

	private void diffFullName(String testFullName, String controlFullName) {
		diffObject(testFullName, controlFullName, "FullName");
	}

	private void compareAsset_Detail(Asset_Detail test, Asset_Detail control) {
		diffAssetAccountIdentifier(test.getAssetAccountIdentifier(), control.getAssetAccountIdentifier());
		diffAssetCashOrMarketValueAmount(test.getAssetCashOrMarketValueAmount(), control.getAssetCashOrMarketValueAmount());
		diffAssetType(test.getAssetType(), control.getAssetType());
		diffAssetTypeOtherDescription(test.getAssetTypeOtherDescription(), control.getAssetTypeOtherDescription());
		diffFundsSourceType(test.getFundsSourceType(), control.getFundsSourceType());
		diffFundsSourceTypeOtherDescription(test.getFundsSourceTypeOtherDescription(), control.getFundsSourceTypeOtherDescription());
		if (control != null) {
			compareExtension(test.getExtension(), control.getExtension());
		}
		
	}

	private void compareExtension(Extension test, Extension control) {
		if (control != null)
			compareOther(test.getOther(), control.getOther());	
	}

	private void compareOther(Other test, Other control) {
		if (control != null) {
			compareAsset_Detail_Extension(test.getAsset_Detail_Extension(), control.getAsset_Detail_Extension());
		}
	}


	private void compareAsset_Detail_Extension(Asset_Detail_Extension testADE, Asset_Detail_Extension controlADE) {
		diffIncludedInAssetAccountIndicator(testADE.getIncludedInAssetAccountIndicator(), controlADE.getIncludedInAssetAccountIndicator());
	}

	private void diffIncludedInAssetAccountIndicator(Boolean testIIAAI, Boolean controlIIAAI) {
		diffObject(testIIAAI, controlIIAAI, "IncludedInAssetAccountIndicator");
	}

	private void diffFundsSourceTypeOtherDescription(String testFSTOD, String controlFSTOD) {
		diffObject(testFSTOD, controlFSTOD, "FundsSourceTypeOtherDescription");
	}

	private void diffFundsSourceType(String testFST, String controlFST) {
		diffObject(testFST, controlFST, "FundsSourceType");	
	}

	private void diffAssetTypeOtherDescription(String testATOD, String controlATOD) {
		diffObject(testATOD, controlATOD, "AssetTypeOtherDescription");
	}

	private void diffAssetType(String testAT, String controlAT) {
		diffObject(testAT, controlAT, "AssetType");
	}

	private void diffAssetCashOrMarketValueAmount(BigDecimal testACOMVA, BigDecimal controlACOMVA) {
		diffObject(testACOMVA, controlACOMVA, "AssetCashOrMarketValueAmount");
	}

	private void diffAssetAccountIdentifier(String testAAI, String controlAAI) {
		diffObject(testAAI, controlAAI, "AssetAccountIdentifier");
	}

	public static void main(String[] args) {
		Integer i = new Integer(10);
		int j = 100;
		Integer testi = j;
		Object testo = j;
		System.out.println("integer cast: "+testi);
		System.out.println("object case: "+testo);
//		Message a = new Message();
//		Message b = new Message();
//		
//		About_Version aav = new About_Version();
//		About_Version bav = new About_Version();
//		
//		aav.setAboutVersionIdentifier("thisIsAboutVersionIdentifier");
//		aav.setCreatedDateTime(LocalDateTime.of(2018, 10, 23, 12, 12));
//		ArrayList<About_Version> laav = new ArrayList<About_Version>();
//		laav.add(aav);
//		a.setAbout_Versions(laav);
//		
//		bav.setAboutVersionIdentifier("thisIsAboutVersionIdentifier");
//		bav.setCreatedDateTime(LocalDateTime.of(2018, 10, 23, 12, 12));
//		ArrayList<About_Version> lbav = new ArrayList<About_Version>();
//		lbav.add(bav);
//		b.setAbout_Versions(lbav);
//		
//		System.out.println(DeepEquals.deepEquals(a, b));
		
	}
}
