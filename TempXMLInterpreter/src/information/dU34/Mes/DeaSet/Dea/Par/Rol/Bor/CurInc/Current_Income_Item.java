package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.CurInc;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Cou.CouEve.Counseling_Event_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.CurInc.CurIncIte.Current_Income_Item_Detail;

public class Current_Income_Item {
	//Attributes
	String sequenceNumber;
	String xlinklabel;
	//Elements
	Current_Income_Item_Detail current_Income_Item_Detail;
	
	public Current_Income_Item(){
		current_Income_Item_Detail = new Current_Income_Item_Detail();
	}

	public Current_Income_Item_Detail getCurrent_Income_Item_Detail() {
		return current_Income_Item_Detail;
	}

	public void setCurrent_Income_Item_Detail(Current_Income_Item_Detail current_Income_Item_Detail) {
		this.current_Income_Item_Detail = current_Income_Item_Detail;
	}
	
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getXlinklabel() {
		return xlinklabel;
	}

	public void setXlinklabel(String xlinklabel) {
		this.xlinklabel = xlinklabel;
	}
}
