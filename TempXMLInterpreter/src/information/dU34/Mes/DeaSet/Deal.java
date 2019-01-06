package information.dU34.Mes.DeaSet;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Asset;
import information.dU34.Mes.DeaSet.Dea.Collateral;
import information.dU34.Mes.DeaSet.Dea.Expense;
import information.dU34.Mes.DeaSet.Dea.Liability;
import information.dU34.Mes.DeaSet.Dea.Liability_Summary;
import information.dU34.Mes.DeaSet.Dea.Loan;
import information.dU34.Mes.DeaSet.Dea.Party;
import information.uCD33.Mes.DocSet.Doc.Relationship;

public class Deal implements ArrayListOwner {
	//Attributes
	String xsitype;
	//Elements
	List<Asset> assets;
	List<Collateral> collaterals;
	List<Expense> expenses;
	List<Liability> liabilities;
	Liability_Summary liability_Summary;
	List<Loan> loans;
	List<Party> parties;
	List<Relationship> relationships;
	
	public Deal(){
		assets = new ArrayList<Asset>();
		collaterals = new ArrayList<Collateral>();
		expenses = new ArrayList<Expense>();
		liabilities = new ArrayList<Liability>();
		liability_Summary = new Liability_Summary();
		loans = new ArrayList<Loan>();
		parties = new ArrayList<Party>();
		relationships = new ArrayList<Relationship>();
	}
	
	public Liability_Summary getLiability_Summary() {
		return liability_Summary;
	}

	public void setLiability_Summary(Liability_Summary liability_Summary) {
		this.liability_Summary = liability_Summary;
	}

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(ArrayList<Asset> assets) {
		this.assets = assets;
	}

	public List<Collateral> getCollaterals() {
		return collaterals;
	}

	public void setCollaterals(ArrayList<Collateral> collaterals) {
		this.collaterals = collaterals;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(ArrayList<Expense> expenses) {
		this.expenses = expenses;
	}

	public List<Liability> getLiabilities() {
		return liabilities;
	}

	public void setLiabilities(ArrayList<Liability> liabilities) {
		this.liabilities = liabilities;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(ArrayList<Party> parties) {
		this.parties = parties;
	}

	public String getXsitype() {
		return xsitype;
	}

	public void setXsitype(String xsitype) {
		this.xsitype = xsitype;
	}

	public List<Relationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<Relationship> relationships) {
		this.relationships = relationships;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	public void setCollaterals(List<Collateral> collaterals) {
		this.collaterals = collaterals;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public void setLiabilities(List<Liability> liabilities) {
		this.liabilities = liabilities;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Asset")){
			result = assets.get(assets.size()-1);
		}
		else if(objectType.equals("Collateral")){
			result = collaterals.get(collaterals.size()-1);
		}
		else if(objectType.equals("Expense")){
			result = expenses.get(expenses.size()-1);
		}
		else if(objectType.equals("Liability")){
			result = liabilities.get(liabilities.size()-1);
		}
		else if(objectType.equals("Loan")){
			result = loans.get(loans.size()-1);
		}
		else if(objectType.equals("Party")){
			result = parties.get(parties.size()-1);
		}
		else if(objectType.equals("Relationship"))
		{
			result = relationships.get(relationships.size()-1);
		}
		
		return result;
	}
}
