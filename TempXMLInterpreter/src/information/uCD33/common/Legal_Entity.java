package information.uCD33.common;

import information.uCD33.common.LegEnt.Legal_Entity_Detail;

public class Legal_Entity {
	Legal_Entity_Detail legal_Entity_Detail;
	
	public Legal_Entity(){
		legal_Entity_Detail = new Legal_Entity_Detail();
	}

	public Legal_Entity_Detail getLegal_Entity_Detail() {
		return legal_Entity_Detail;
	}

	public void setLegal_Entity_Detail(Legal_Entity_Detail legal_Entity_Detail) {
		this.legal_Entity_Detail = legal_Entity_Detail;
	}
}
