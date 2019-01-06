package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Cou;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Cou.CouEve.Counseling_Event_Detail;

public class Counseling_Event {
	//Attributes
	String sequenceNumber;
	String xlinklabel;
	//Elements
	Counseling_Event_Detail counseling_Event_Detail;
	
	public Counseling_Event(){
		counseling_Event_Detail = new Counseling_Event_Detail();
	}

	public Counseling_Event_Detail getCounseling_Event_Detail() {
		return counseling_Event_Detail;
	}
	
	public void setCounseling_Event_Detail(Counseling_Event_Detail counseling_Event_Detail) {
		this.counseling_Event_Detail = counseling_Event_Detail;
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
