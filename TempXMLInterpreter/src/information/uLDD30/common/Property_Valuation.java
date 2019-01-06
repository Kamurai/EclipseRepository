package information.uLDD30.common;

import information.uLDD30.common.ProVal.Property_Valuation_Detail;

public class Property_Valuation {
	Property_Valuation_Detail property_Valuation_Detail;
	
	public Property_Valuation(){
		property_Valuation_Detail = new Property_Valuation_Detail();
	}

	public Property_Valuation_Detail getProperty_Valuation_Detail() {
		return property_Valuation_Detail;
	}

	public void setProperty_Valuation_Detail(Property_Valuation_Detail property_Valuation_Detail) {
		this.property_Valuation_Detail = property_Valuation_Detail;
	}
}
