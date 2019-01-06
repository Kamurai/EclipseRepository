package information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet;

import information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL.URLA_Detail;
import information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL.URLA_Total;

public class URLA {
	URLA_Detail uRLA_Detail;
	URLA_Total uRLA_Total;
	
	public URLA(){
		uRLA_Detail = new URLA_Detail();
		uRLA_Total = new URLA_Total();
	}

	public URLA_Detail getURLA_Detail() {
		return uRLA_Detail;
	}

	public void setURLA_Detail(URLA_Detail uRLA_Detail) {
		this.uRLA_Detail = uRLA_Detail;
	}

	public URLA_Total getURLA_Total() {
		return uRLA_Total;
	}

	public void setURLA_Total(URLA_Total uRLA_Total) {
		this.uRLA_Total = uRLA_Total;
	}
}
