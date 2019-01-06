package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa;

import java.util.ArrayList;
import java.util.List;

import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloInf.Closing_Adjustment_Item;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloInf.Closing_Cost_Fund;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloInf.Closing_Information_Detail;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloInf.Prepaid_Item;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloInf.Proration_Item;

public class Closing_Information {
	List<Closing_Adjustment_Item> closing_Adjustment_Items;
	List<Closing_Cost_Fund> closing_Cost_Funds;
	Closing_Information_Detail closing_Information_Detail;
	List<Prepaid_Item> prepaid_Items;
	List<Proration_Item> proration_Items;
	
	public Closing_Information(){}
}
