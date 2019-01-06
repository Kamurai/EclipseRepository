package information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro;

import information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.ProVal.Property_Valuation_Detail;

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
