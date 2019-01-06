package information.dU34.Mes.DeaSet.Dea.Par.Rol;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
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

public class Borrower implements ArrayListOwner {
	List<Bankruptcy> bankruptcies;
	Borrower_Detail borrower_Detail;
	Counseling counseling;
	Current_Income current_Income;
	Declaration declaration;
	List<Dependent> dependents;
	List<Employer> employers;
	Government_Borrower government_Borrower;
	Government_Monitoring government_Monitoring;
	List<Military_Service> military_Services;
	List<Residence> residences;
	
	public Borrower(){
		bankruptcies = new ArrayList<Bankruptcy>();
		borrower_Detail = new Borrower_Detail();
		counseling = new Counseling();
		current_Income = new Current_Income();
		declaration = new Declaration();
		dependents = new ArrayList<Dependent>();
		employers = new ArrayList<Employer>();
		government_Borrower = new Government_Borrower();
		government_Monitoring = new Government_Monitoring();
		military_Services = new ArrayList<Military_Service>();
		residences = new ArrayList<Residence>();
	}
	
	public List<Bankruptcy> getBankruptcies() {
		return bankruptcies;
	}

	public void setBankruptcies(ArrayList<Bankruptcy> bankruptcies) {
		this.bankruptcies = bankruptcies;
	}

	public Borrower_Detail getBorrower_Detail() {
		return borrower_Detail;
	}

	public void setBorrower_Detail(Borrower_Detail borrower_Detail) {
		this.borrower_Detail = borrower_Detail;
	}

	public Counseling getCounseling() {
		return counseling;
	}

	public void setCounseling(Counseling counseling) {
		this.counseling = counseling;
	}

	public Current_Income getCurrent_Income() {
		return current_Income;
	}

	public void setCurrent_Income(Current_Income current_Income) {
		this.current_Income = current_Income;
	}

	public Declaration getDeclaration() {
		return declaration;
	}

	public void setDeclaration(Declaration declaration) {
		this.declaration = declaration;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(ArrayList<Dependent> dependents) {
		this.dependents = dependents;
	}

	public List<Employer> getEmployers() {
		return employers;
	}

	public void setEmployers(ArrayList<Employer> employers) {
		this.employers = employers;
	}

	public Government_Borrower getGovernment_Borrower() {
		return government_Borrower;
	}

	public void setGovernment_Borrower(Government_Borrower government_Borrower) {
		this.government_Borrower = government_Borrower;
	}

	public Government_Monitoring getGovernment_Monitoring() {
		return government_Monitoring;
	}

	public void setGovernment_Monitoring(Government_Monitoring government_Monitoring) {
		this.government_Monitoring = government_Monitoring;
	}

	public List<Military_Service> getMilitary_Services() {
		return military_Services;
	}

	public void setMilitary_Services(ArrayList<Military_Service> military_Services) {
		this.military_Services = military_Services;
	}

	public List<Residence> getResidences() {
		return residences;
	}

	public void setResidences(ArrayList<Residence> residences) {
		this.residences = residences;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Bankruptcy")){
			result = bankruptcies.get(bankruptcies.size()-1);
		}
		else if(objectType.equals("Dependent")){
			result = dependents.get(dependents.size()-1);
		}
		else if(objectType.equals("Employer")){
			result = employers.get(employers.size()-1);
		}
		else if(objectType.equals("Military_Service")){
			result = military_Services.get(military_Services.size()-1);
		}
		else if(objectType.equals("Residence")){
			result = residences.get(residences.size()-1);
		}
		
		return result;
	}
}
