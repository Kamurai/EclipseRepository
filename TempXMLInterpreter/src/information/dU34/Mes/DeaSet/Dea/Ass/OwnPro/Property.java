package information.dU34.Mes.DeaSet.Dea.Ass.OwnPro;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.Property_Detail;
import information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.Property_Valuation;
import information.dU34.common.Sales_Contract;
import information.dU34.common.Address;

public class Property implements ArrayListOwner {
	Address address;
	Property_Detail property_Detail;
	List<Property_Valuation> property_Valuations;
	List<Sales_Contract> sales_Contracts;
	
	public Property(){
		address = new Address();
		property_Detail = new Property_Detail();
		property_Valuations = new ArrayList<Property_Valuation>();
		sales_Contracts = new ArrayList<Sales_Contract>();
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public List<Sales_Contract> getSales_Contracts() {
		return sales_Contracts;
	}

	public void setSales_Contracts(ArrayList<Sales_Contract> sales_Contracts) {
		this.sales_Contracts = sales_Contracts;
	}
	
	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Property_Valuation")){
			result = property_Valuations.get(property_Valuations.size()-1);
		}
		else if(objectType.equals("Sales_Contract")){
			result = sales_Contracts.get(sales_Contracts.size()-1);
		}
		
		return result;
	}

}
