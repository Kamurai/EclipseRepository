package information.dU34.Mes.DeaSet.Dea.Loa;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Buy.Buydown_Occurrence;

public class Buydown implements ArrayListOwner {
	List<Buydown_Occurrence> buydown_Occurrences;
	
	public Buydown(){
		buydown_Occurrences = new ArrayList<Buydown_Occurrence>();
	}
	
	public List<Buydown_Occurrence> getBuydown_Occurrences() {
		return buydown_Occurrences;
	}

	public void setBuydown_Occurrences(List<Buydown_Occurrence> buydown_Occurrences) {
		this.buydown_Occurrences = buydown_Occurrences;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Buydown_Occurrence")){
			result = buydown_Occurrences.get(buydown_Occurrences.size()-1);
		}
		
		return result;
	}
}
