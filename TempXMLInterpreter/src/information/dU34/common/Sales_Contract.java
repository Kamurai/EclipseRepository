package information.dU34.common;

import information.dU34.common.SalCon.Sales_Contract_Detail;

public class Sales_Contract {
	Sales_Contract_Detail sales_Contract_Detail;
	
	public Sales_Contract(){
		sales_Contract_Detail = new Sales_Contract_Detail();
	}

	public Sales_Contract_Detail getSales_Contract_Detail() {
		return sales_Contract_Detail;
	}

	public void setSales_Contract_Detail(Sales_Contract_Detail sales_Contract_Detail) {
		this.sales_Contract_Detail = sales_Contract_Detail;
	}
}
