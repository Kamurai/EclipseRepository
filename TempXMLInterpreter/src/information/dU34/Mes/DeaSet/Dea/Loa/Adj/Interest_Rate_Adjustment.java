package information.dU34.Mes.DeaSet.Dea.Loa.Adj;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Loa.Adj.IntRatAdj.Interest_Rate_Lifetime_Adjustment_Rule;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj.IntRatAdj.Index_Rule;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj.IntRatAdj.Interest_Rate_Per_Change_Adjustment_Rule;

public class Interest_Rate_Adjustment implements ArrayListOwner {
	List<Index_Rule> index_Rules;
	Interest_Rate_Lifetime_Adjustment_Rule interest_Rate_Lifetime_Adjustment_Rule;
	List<Interest_Rate_Per_Change_Adjustment_Rule> interest_Rate_Per_Change_Adjustment_Rules;
	
	public Interest_Rate_Adjustment(){
		index_Rules = new ArrayList<Index_Rule>();
		interest_Rate_Lifetime_Adjustment_Rule = new Interest_Rate_Lifetime_Adjustment_Rule();
		interest_Rate_Per_Change_Adjustment_Rules = new ArrayList<Interest_Rate_Per_Change_Adjustment_Rule>();		
	}
	
	public List<Index_Rule> getIndex_Rules() {
		return index_Rules;
	}

	public void setIndex_Rules(List<Index_Rule> index_Rules) {
		this.index_Rules = index_Rules;
	}

	public Interest_Rate_Lifetime_Adjustment_Rule getInterest_Rate_Lifetime_Adjustment_Rule() {
		return interest_Rate_Lifetime_Adjustment_Rule;
	}

	public void setInterest_Rate_Lifetime_Adjustment_Rule(
			Interest_Rate_Lifetime_Adjustment_Rule interest_Rate_Lifetime_Adjustment_Rule) {
		this.interest_Rate_Lifetime_Adjustment_Rule = interest_Rate_Lifetime_Adjustment_Rule;
	}

	public List<Interest_Rate_Per_Change_Adjustment_Rule> getInterest_Rate_Per_Change_Adjustment_Rules() {
		return interest_Rate_Per_Change_Adjustment_Rules;
	}

	public void setInterest_Rate_Per_Change_Adjustment_Rules(
			List<Interest_Rate_Per_Change_Adjustment_Rule> interest_Rate_Per_Change_Adjustments) {
		this.interest_Rate_Per_Change_Adjustment_Rules = interest_Rate_Per_Change_Adjustments;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Index_Rule")){
			result = index_Rules.get(index_Rules.size()-1);
		}
		else if(objectType.equals("Interest_Rate_Per_Change_Adjustment")){
			result = interest_Rate_Per_Change_Adjustment_Rules.get(interest_Rate_Per_Change_Adjustment_Rules.size()-1);
		}
		
		return result;
	}
}
