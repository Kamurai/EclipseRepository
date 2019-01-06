package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.DocSpeDatSet;

import java.util.ArrayList;
import java.util.List;

import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.DocSpeDatSet.IntDis.Cash_To_Close_Item;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.DocSpeDatSet.IntDis.Estimated_Property_Cost;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.DocSpeDatSet.IntDis.Integrated_Disclosure_Detail;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.DocSpeDatSet.IntDis.Integrated_Disclosure_Section_Summary;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.DocSpeDatSet.IntDis.Projected_Payment;

public class Integrated_Disclosure {
	List<Cash_To_Close_Item> cash_To_Close_Items;
	Estimated_Property_Cost estimated_Property_Cost;
	Integrated_Disclosure_Detail integrated_Disclosure_Detail;
	List<Integrated_Disclosure_Section_Summary> integrated_Disclosure_Section_Summaries;
	List<Projected_Payment> projected_Payments;
	
	public Integrated_Disclosure(){}
}
