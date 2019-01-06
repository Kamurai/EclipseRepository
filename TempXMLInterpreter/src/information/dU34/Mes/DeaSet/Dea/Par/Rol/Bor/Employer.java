package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor;

import information.dU34.common.Address;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.Employment;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.Legal_Entity;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloIte.CloAdjIte.CloAdjItePaiBy.Individual;

public class Employer {
	//Attributes
	String sequenceNumber;
	String xlinklabel;
	//Elements
	Address address;
	Employment employment;
	Individual individual;
	Legal_Entity legal_Entity;
	
	public Employer(){
		address = new Address();
		employment = new Employment();
		individual = new Individual();
		legal_Entity = new Legal_Entity();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employment getEmployment() {
		return employment;
	}

	public void setEmployment(Employment employment) {
		this.employment = employment;
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
}
