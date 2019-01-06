package information.dU34.Mes.DeaSet.Dea.Par;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Borrower;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.License;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Party_Role_Identifier;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Property_Owner;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Role_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Trust;

public class Role implements ArrayListOwner {
	//Attributes
	String sequenceNumber;
	String xlinklabel;
	//Elements
	Borrower borrower;
	List<License> licenses;
	List<Party_Role_Identifier> party_Role_Identifiers;
	Property_Owner property_Owner;
	Role_Detail role_Detail;
	Trust trust;
	
	public Role(){
		borrower = new Borrower();
		licenses = new ArrayList<License>();
		party_Role_Identifiers = new ArrayList<Party_Role_Identifier>();
		property_Owner = new Property_Owner();
		role_Detail = new Role_Detail();
		trust = new Trust();
		}
	
	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public List<License> getLicenses() {
		return licenses;
	}

	public void setLicenses(ArrayList<License> licenses) {
		this.licenses = licenses;
	}

	public List<Party_Role_Identifier> getParty_Role_Identifiers() {
		return party_Role_Identifiers;
	}

	public void setParty_Role_Identifiers(ArrayList<Party_Role_Identifier> party_Role_Identifiers) {
		this.party_Role_Identifiers = party_Role_Identifiers;
	}

	public Property_Owner getProperty_Owner() {
		return property_Owner;
	}

	public void setProperty_Owner(Property_Owner property_Owner) {
		this.property_Owner = property_Owner;
	}

	public Role_Detail getRole_Detail() {
		return role_Detail;
	}

	public void setRole_Detail(Role_Detail role_Detail) {
		this.role_Detail = role_Detail;
	}

	public Trust getTrust() {
		return trust;
	}

	public void setTrust(Trust trust) {
		this.trust = trust;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getXlinklabel() {
		return xlinklabel;
	}

	public void setXlinklabel(String xlinklabel) {
		this.xlinklabel = xlinklabel;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("License")){
			result = licenses.get(licenses.size()-1);
		}
		else if(objectType.equals("Party_Role_Identifier")){
			result = party_Role_Identifiers.get(party_Role_Identifiers.size()-1);
		}
		
		return result;
	}
}
