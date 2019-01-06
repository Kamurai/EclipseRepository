package information.dU34.Mes.DeaSet.Dea.Loa;

import information.dU34.Mes.DeaSet.Dea.Loa.PrePen.Prepayment_Penalty_Lifetime_Rule;

public class Prepayment_Penalty {
	Prepayment_Penalty_Lifetime_Rule prepayment_Penalty_Lifetime_Rule;
	
	public Prepayment_Penalty(){
		prepayment_Penalty_Lifetime_Rule = new Prepayment_Penalty_Lifetime_Rule();
	}

	public Prepayment_Penalty_Lifetime_Rule getPrepayment_Penalty_Lifetime_Rule() {
		return prepayment_Penalty_Lifetime_Rule;
	}

	public void setPrepayment_Penalty_Lifetime_Rule(Prepayment_Penalty_Lifetime_Rule prepayment_Penalty_Lifetime_Rule) {
		this.prepayment_Penalty_Lifetime_Rule = prepayment_Penalty_Lifetime_Rule;
	}
}
