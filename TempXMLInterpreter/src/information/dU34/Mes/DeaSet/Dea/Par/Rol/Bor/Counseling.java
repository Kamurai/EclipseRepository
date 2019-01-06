package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Cou.Counseling_Event;

public class Counseling implements ArrayListOwner {
	List<Counseling_Event> counseling_Events;
	
	public Counseling(){
		counseling_Events = new ArrayList<Counseling_Event>(); 
	}
	
	public List<Counseling_Event> getCounseling_Events() {
		return counseling_Events;
	}

	public void setCounseling_Events(List<Counseling_Event> counseling_Events) {
		this.counseling_Events = counseling_Events;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Counseling_Event")){
			result = counseling_Events.get(counseling_Events.size()-1);
		}
		
		return result;
	}
}
