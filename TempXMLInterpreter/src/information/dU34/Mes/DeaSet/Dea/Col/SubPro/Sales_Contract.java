package information.dU34.Mes.DeaSet.Dea.Col.SubPro;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.SalCon.Sales_Concession;

public class Sales_Contract extends information.dU34.common.Sales_Contract implements ArrayListOwner{
	List<Sales_Concession> sales_Concessions;
	//Sales_Contract_Detail sales_Contract_Detail;
	
	public Sales_Contract(){
		super();
		sales_Concessions = new ArrayList<Sales_Concession>();
	}

	public List<Sales_Concession> getSales_Concessions() {
		return sales_Concessions;
	}

	public void setSales_Concessions(List<Sales_Concession> sales_Concessions) {
		this.sales_Concessions = sales_Concessions;
	}
	
	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Sales_Concession")){
			result = sales_Concessions.get(sales_Concessions.size()-1);
		}
		
		return result;
	}
}
