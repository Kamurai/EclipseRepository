package information.dU34.Mes.DeaSet.Dea.Col;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.Location_Identifier;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.Project;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.Property_Detail;
import information.uLDD30.common.Property_Valuation;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.Sales_Contract;
import information.dU34.common.Address;

public class Subject_Property implements ArrayListOwner {
	Address address;
	Location_Identifier location_Identifier;
	Property_Detail property_Detail;
	List<Property_Valuation> property_Valuations;
	Project project;
	List<Sales_Contract> sales_Contracts;
	
	public Subject_Property(){
		address = new Address();
		location_Identifier = new Location_Identifier();
		property_Detail = new Property_Detail();
		property_Valuations = new ArrayList<Property_Valuation>();
		project = new Project();
		sales_Contracts = new ArrayList<Sales_Contract>();
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Location_Identifier getLocation_Identifier() {
		return location_Identifier;
	}

	public void setLocation_Identifier(Location_Identifier location_Identifier) {
		this.location_Identifier = location_Identifier;
	}

	public Property_Detail getProperty_Detail() {
		return property_Detail;
	}

	public void setProperty_Detail(Property_Detail property_Detail) {
		this.property_Detail = property_Detail;
	}

	public List<Property_Valuation> getProperty_Valuations() {
		return property_Valuations;
	}

	public void setProperty_Valuations(ArrayList<Property_Valuation> property_Valuations) {
		this.property_Valuations = property_Valuations;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Sales_Contract> getSales_Contracts() {
		return sales_Contracts;
	}

	public void setSales_Contracts(List<Sales_Contract> sales_Contracts) {
		this.sales_Contracts = sales_Contracts;
	}

	public void setProperty_Valuations(List<Property_Valuation> property_Valuations) {
		this.property_Valuations = property_Valuations;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Property_Valuation")){
			result = property_Valuations.get(property_Valuations.size()-1);
		}
		else if(objectType.equals("Sales_Contract")){
			result = sales_Contracts.get(property_Valuations.size()-1);
		}
		
		return result;
	}
}
