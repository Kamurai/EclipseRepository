package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.CurInc.Current_Income_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.CurInc.Current_Income_Item;

public class Current_Income implements ArrayListOwner {
	Current_Income_Detail current_Income_Detail;
	List<Current_Income_Item> current_Income_Items;
	
	public Current_Income(){
		current_Income_Detail = new Current_Income_Detail();
		current_Income_Items = new ArrayList<Current_Income_Item>();
	}
	
	public Current_Income_Detail getCurrent_Income_Detail() {
		return current_Income_Detail;
	}

	public void setCurrent_Income_Detail(Current_Income_Detail current_Income_Detail) {
		this.current_Income_Detail = current_Income_Detail;
	}

	public List<Current_Income_Item> getCurrent_Income_Items() {
		return current_Income_Items;
	}

	public void setCurrent_Income_Items(List<Current_Income_Item> current_Income_Items) {
		this.current_Income_Items = current_Income_Items;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Current_Income_Item")){
			result = current_Income_Items.get(current_Income_Items.size()-1);
		}
		
		return result;
	}
}
