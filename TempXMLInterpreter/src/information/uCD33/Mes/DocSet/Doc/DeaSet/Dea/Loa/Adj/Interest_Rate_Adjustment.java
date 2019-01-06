package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj;

import java.util.ArrayList;
import java.util.List;

import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj.IntRatAdj.Index_Rule;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj.IntRatAdj.Interest_Rate_Lifetime_Adjustment_Rule;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj.IntRatAdj.Interest_Rate_Per_Change_Adjustment_Rule;

public class Interest_Rate_Adjustment {
	List<Index_Rule> index_Rules;
	Interest_Rate_Lifetime_Adjustment_Rule interest_Rate_Lifetime_Adjustment_Rule;
	List<Interest_Rate_Per_Change_Adjustment_Rule> interest_Rate_Per_Change_Adjustments;
	
	public Interest_Rate_Adjustment(){}
}
