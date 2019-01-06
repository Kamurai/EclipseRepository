package information.dU34.Mes.DeaSet.Dea.Loa;

import information.dU34.Mes.DeaSet.Dea.Loa.Mat.Maturity_Rule;

public class Maturity {
	Maturity_Rule maturity_Rule;

	public Maturity(){
		maturity_Rule = new Maturity_Rule();
	}

	public Maturity_Rule getMaturity_Rule() {
		return maturity_Rule;
	}

	public void setMaturity_Rule(Maturity_Rule maturity_Rule) {
		this.maturity_Rule = maturity_Rule;
	}
}
