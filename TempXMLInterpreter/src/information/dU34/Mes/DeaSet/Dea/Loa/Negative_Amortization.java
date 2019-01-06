package information.dU34.Mes.DeaSet.Dea.Loa;

import information.dU34.Mes.DeaSet.Dea.Loa.NegAmo.Negative_Amortization_Rule;

public class Negative_Amortization {
	Negative_Amortization_Rule negative_Amortization_Rule;
	
	public Negative_Amortization(){
		negative_Amortization_Rule = new Negative_Amortization_Rule();
	}

	public Negative_Amortization_Rule getNegative_Amortization_Rule() {
		return negative_Amortization_Rule;
	}

	public void setNegative_Amortization_Rule(Negative_Amortization_Rule negative_Amortization_Rule) {
		this.negative_Amortization_Rule = negative_Amortization_Rule;
	}
}
