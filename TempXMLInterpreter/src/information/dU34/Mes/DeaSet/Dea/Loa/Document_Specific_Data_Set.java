package information.dU34.Mes.DeaSet.Dea.Loa;

import information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URLA;

public class Document_Specific_Data_Set {
	URLA uRLA;
	
	public Document_Specific_Data_Set(){
		uRLA = new URLA();
	}

	public URLA getURLA() {
		return uRLA;
	}

	public void setURLA(URLA uRLA) {
		this.uRLA = uRLA;
	}
}
