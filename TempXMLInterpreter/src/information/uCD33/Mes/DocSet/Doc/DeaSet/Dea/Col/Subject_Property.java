package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Col;

import java.util.ArrayList;
import java.util.List;

import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Col.SubPro.Address;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Col.SubPro.Legal_Description;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Col.SubPro.Property_Detail;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Col.SubPro.Property_Valuation;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Col.SubPro.Sale_Contract;

public class Subject_Property {
	Address address;
	List<Legal_Description> legal_Descriptions;
	Property_Detail property_Detail;
	List<Property_Valuation> property_Valuations;
	List<Sale_Contract> sale_Contracts;
	
	
	
	public Subject_Property(){}
}
