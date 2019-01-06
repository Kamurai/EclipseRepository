package information.dU34.Mes.DeaSet.Dea.Loa;

import information.dU34.Mes.DeaSet.Dea.Loa.Amo.Amortization_Rule;

public class Amortization {
	Amortization_Rule amortization_Rule;
	
	public Amortization(){
		amortization_Rule = new Amortization_Rule();
	}

	public Amortization_Rule getAmortization_Rule() {
		return amortization_Rule;
	}

	public void setAmortization_Rule(Amortization_Rule amortization_Rule) {
		this.amortization_Rule = amortization_Rule;
	}
}
