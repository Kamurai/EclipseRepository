package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Col;

import java.util.List;

import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Col.Pro.Flood_Determination;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Col.Pro.Project;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Col.Pro.Property_Detail;
import information.uLDD30.common.Property_Valuation;
import information.uLDD30.common.Address;

public class Property {
	Address address;
	Property_Detail property_Detail;
	List<Property_Valuation> property_Valuations;
	Flood_Determination flood_Determination;
	Project project;
	
	public Property(){}
}
