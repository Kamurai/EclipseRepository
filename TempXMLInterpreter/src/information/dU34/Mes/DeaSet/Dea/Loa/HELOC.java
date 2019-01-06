package information.dU34.Mes.DeaSet.Dea.Loa;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Loa.HelOcc.HELOC_Occurence;
import information.dU34.Mes.DeaSet.Dea.Loa.HelRul.HELOC_Rule;

public class HELOC implements ArrayListOwner {
	List<HELOC_Occurence> hELOC_Occurrences;
	HELOC_Rule hELOC_Rule;
	
	public HELOC(){
		hELOC_Occurrences = new ArrayList<HELOC_Occurence>();
		hELOC_Rule = new HELOC_Rule();
	}
	
	public List<HELOC_Occurence> getHELOC_Occurrences() {
		return hELOC_Occurrences;
	}

	public void setHELOC_Occurrences(List<HELOC_Occurence> hELOC_Occurrences) {
		this.hELOC_Occurrences = hELOC_Occurrences;
	}

	public HELOC_Rule getHELOC_Rule() {
		return hELOC_Rule;
	}

	public void setHELOC_Rule(HELOC_Rule hELOC_Rule) {
		this.hELOC_Rule = hELOC_Rule;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("HELOC_Occurence")){
			result = hELOC_Occurrences.get(hELOC_Occurrences.size()-1);
		}
		
		return result;
	}
}
