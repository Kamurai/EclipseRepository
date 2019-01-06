package information.dU34.Mes.DeaSet.Dea.Loa;

import information.dU34.Mes.DeaSet.Dea.Loa.LoaPro.Loan_Product_Detail;

public class Loan_Product {
	Loan_Product_Detail loan_Product_Detail;
	
	public Loan_Product(){
		loan_Product_Detail = new Loan_Product_Detail();
	}

	public Loan_Product_Detail getLoan_Product_Detail() {
		return loan_Product_Detail;
	}

	public void setLoan_Product_Detail(Loan_Product_Detail loan_Product_Detail) {
		this.loan_Product_Detail = loan_Product_Detail;
	}
}
