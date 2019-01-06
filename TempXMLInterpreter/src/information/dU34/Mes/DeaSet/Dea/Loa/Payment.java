package information.dU34.Mes.DeaSet.Dea.Loa;

import information.dU34.Mes.DeaSet.Dea.Loa.Pay.Payment_Rule;

public class Payment {
	Payment_Rule payment_Rule;
	
	public Payment(){
		payment_Rule = new Payment_Rule();
	}

	public Payment_Rule getPayment_Rule() {
		return payment_Rule;
	}

	public void setPayment_Rule(Payment_Rule payment_Rule) {
		this.payment_Rule = payment_Rule;
	}
}
