package information.dU34.Mes.DeaSet.Dea;

import information.dU34.Mes.DeaSet.Dea.Lia.Liability_Detail;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Lia.Liability_Holder;

public class Liability {
	//Attributes
	String sequenceNumber;
	String xlinklabel;
	//Elements
	Liability_Detail liability_Detail;
	Liability_Holder liability_Holder;
	
	public Liability(){
		liability_Detail = new Liability_Detail();
		liability_Holder = new Liability_Holder();
	}
	
	public Liability_Holder getLiability_Holder() {
		return liability_Holder;
	}

	public void setLiability_Holder(Liability_Holder liability_Holder) {
		this.liability_Holder = liability_Holder;
	}

	public Liability_Detail getLiability_Detail() {
		return liability_Detail;
	}

	public void setLiability_Detail(Liability_Detail liability_Detail) {
		this.liability_Detail = liability_Detail;
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
