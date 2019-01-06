package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloInf;

import java.util.ArrayList;
import java.util.List;

import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloInf.PreIte.Prepaid_Item_Detail;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloInf.PreIte.Prepaid_Item_Paid_To;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloInf.PreIte.Prepaid_Item_Payment;

public class Prepaid_Item {
	Prepaid_Item_Detail prepaid_Item_Detail;
	Prepaid_Item_Paid_To prepaid_Item_Paid_To;
	List<Prepaid_Item_Payment> prepaid_Item_Payments;

	public Prepaid_Item(){}
}
