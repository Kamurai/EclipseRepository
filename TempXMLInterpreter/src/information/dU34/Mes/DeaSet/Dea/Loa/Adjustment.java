package information.dU34.Mes.DeaSet.Dea.Loa;

import information.dU34.Mes.DeaSet.Dea.Loa.Adj.Interest_Rate_Adjustment;

public class Adjustment {
	Interest_Rate_Adjustment interest_Rate_Adjustment;
	
	public Adjustment(){
		interest_Rate_Adjustment = new Interest_Rate_Adjustment();
	}

	public Interest_Rate_Adjustment getInterest_Rate_Adjustment() {
		return interest_Rate_Adjustment;
	}

	public void setInterest_Rate_Adjustment(Interest_Rate_Adjustment interest_Rate_Adjustment) {
		this.interest_Rate_Adjustment = interest_Rate_Adjustment;
	}
}
