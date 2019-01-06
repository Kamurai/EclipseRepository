package information.dU34.Mes.DeaSet.Dea;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Par.Address;
import information.dU34.Mes.DeaSet.Dea.Par.Individual;
import information.dU34.Mes.DeaSet.Dea.Par.Language;
import information.dU34.Mes.DeaSet.Dea.Par.Role;
import information.uCD33.common.Legal_Entity;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Taxpayer_Identifier;

public class Party implements ArrayListOwner {
	List<Address> addresses;
	Individual individual;
	List<Language> languages;
	Legal_Entity legal_Entity;
	List<Role> roles;
	List<Taxpayer_Identifier> taxpayer_Identifiers;
	
	public Party(){
		addresses = new ArrayList<Address>();
		individual = new Individual();
		languages = new ArrayList<Language>();
		legal_Entity = new Legal_Entity();
		roles = new ArrayList<Role>();
		taxpayer_Identifiers = new ArrayList<Taxpayer_Identifier>();
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<Address> addresses) {
		this.addresses = addresses;
	}

	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<Language> languages) {
		this.languages = languages;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	public List<Taxpayer_Identifier> getTaxpayer_Identifiers() {
		return taxpayer_Identifiers;
	}

	public void setTaxpayer_Identifiers(ArrayList<Taxpayer_Identifier> taxpayer_Identifiers) {
		this.taxpayer_Identifiers = taxpayer_Identifiers;
	}

	public Legal_Entity getLegal_Entity() {
		return legal_Entity;
	}

	public void setLegal_Entity(Legal_Entity legal_Entity) {
		this.legal_Entity = legal_Entity;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Address")){
			result = addresses.get(addresses.size()-1);
		}
		else if(objectType.equals("Language")){
			result = languages.get(languages.size()-1);
		}
		else if(objectType.equals("Role")){
			result = roles.get(roles.size()-1);
		}
		else if(objectType.equals("Taxpayer_Identifier")){
			result = taxpayer_Identifiers.get(taxpayer_Identifiers.size()-1);
		}
		
		return result;
	}
}
