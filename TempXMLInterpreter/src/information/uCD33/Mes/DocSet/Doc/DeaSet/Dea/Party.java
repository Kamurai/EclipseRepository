package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Par.Address;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Par.Individual;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Par.Role;
import information.uCD33.common.Legal_Entity;

public class Party extends information.uLDD30.Mes.DeaSets.DeaSet.Dea.Party implements ArrayListOwner{
	List<Address> addresses;
	Individual individual;
	Legal_Entity legal_Entity;
	List<Role> roles;	
	
	public Party(){
		super();
		addresses = new ArrayList<Address>();
		individual = new Individual();
		legal_Entity = new Legal_Entity();
		roles = new ArrayList<Role>();
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

	public Legal_Entity getLegal_Entity() {
		return legal_Entity;
	}

	public void setLegal_Entity(Legal_Entity legal_Entity) {
		this.legal_Entity = legal_Entity;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Address")){
			result = addresses.get(addresses.size()-1);
		}
		else if(objectType.equals("Role")){
			result = roles.get(roles.size()-1);
		}
		
		return result;
	}
}
