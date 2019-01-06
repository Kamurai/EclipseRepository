package information.dU34.Mes.DeaSet.Dea.Loa;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Loa.CloInf.Closing_Adjustment_Item;
import information.dU34.Mes.DeaSet.Dea.Loa.CloInf.Closing_Information_Detail;

public class Closing_Information implements ArrayListOwner {
	List<Closing_Adjustment_Item> closing_Adjustment_Items;
	Closing_Information_Detail closing_Information_Detail;
	
	public Closing_Information(){
		closing_Adjustment_Items = new ArrayList<Closing_Adjustment_Item>();
		closing_Information_Detail = new Closing_Information_Detail();
	}
	
	public List<Closing_Adjustment_Item> getClosing_Adjustment_Items() {
		return closing_Adjustment_Items;
	}

	public void setClosing_Adjustment_Items(List<Closing_Adjustment_Item> closing_Adjustment_Items) {
		this.closing_Adjustment_Items = closing_Adjustment_Items;
	}

	public Closing_Information_Detail getClosing_Information_Detail() {
		return closing_Information_Detail;
	}

	public void setClosing_Information_Detail(Closing_Information_Detail closing_Information_Detail) {
		this.closing_Information_Detail = closing_Information_Detail;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Closing_Adjustment_Item")){
			result = closing_Adjustment_Items.get(closing_Adjustment_Items.size()-1);
		}
		
		return result;
	}
}
