package information.dU34.Mes.DeaSet.Dea.Loa.CloInf;

import information.dU34.Mes.DeaSet.Dea.Loa.CloInf.CloAdjIte.Closing_Adjustment_Item_Detail;

public class Closing_Adjustment_Item {
	Closing_Adjustment_Item_Detail closing_Adjustment_Item_Detail;
	
	public Closing_Adjustment_Item(){
		closing_Adjustment_Item_Detail = new Closing_Adjustment_Item_Detail();
	}

	public Closing_Adjustment_Item_Detail getClosing_Adjustment_Item_Detail() {
		return closing_Adjustment_Item_Detail;
	}

	public void setClosing_Adjustment_Item_Detail(Closing_Adjustment_Item_Detail closing_Adjustment_Item_Detail) {
		this.closing_Adjustment_Item_Detail = closing_Adjustment_Item_Detail;
	}
}
