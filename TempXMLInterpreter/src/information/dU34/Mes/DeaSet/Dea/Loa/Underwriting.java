package information.dU34.Mes.DeaSet.Dea.Loa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Loa.Und.Automated_Underwriting;

public class Underwriting implements ArrayListOwner {
	List<Automated_Underwriting> automated_Underwritings;
	
	public Underwriting(){
		automated_Underwritings = new ArrayList<Automated_Underwriting>();
	}
	
	public List<Automated_Underwriting> getAutomated_Underwritings() {
		return automated_Underwritings;
	}

	public void setAutomated_Underwritings(List<Automated_Underwriting> automated_Underwritings) {
		this.automated_Underwritings = automated_Underwritings;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Automated_Underwriting")){
			result = automated_Underwritings.get(automated_Underwritings.size()-1);
		}
		
		return result;
	}
}
