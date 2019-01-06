package information.dU34.Mes;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Deal;

public class Deal_Set implements ArrayListOwner {
	List<Deal> deals;	
	
	public Deal_Set(){
		deals = new ArrayList<Deal>();
	}
	
	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(ArrayList<Deal> deals) {
		this.deals = deals;
	}
	
	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Deal")){
			result = deals.get(deals.size()-1);
		}
		
		return result;
	}

}
