package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon;

import java.util.ArrayList;
import java.util.List;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDARac.HMDA_Race_Designation;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.GovMon.HMDRac.Ext.Oth.HMDRacExt.HMDA_Race_Detail;

public class HMDA_Race {
	HMDA_Race_Detail hMDA_Race_Detail;
	List<HMDA_Race_Designation> hMDA_Race_Designations;
	
	public HMDA_Race(){
		hMDA_Race_Detail = new HMDA_Race_Detail();
		hMDA_Race_Designations = new ArrayList<HMDA_Race_Designation>();
	}

	public HMDA_Race_Detail getHMDA_Race_Detail() {
		return hMDA_Race_Detail;
	}

	public void setHMDA_Race_Detail(HMDA_Race_Detail hMDA_Race_Detail) {
		this.hMDA_Race_Detail = hMDA_Race_Detail;
	}

	public List<HMDA_Race_Designation> getHMDA_Race_Designations() {
		return hMDA_Race_Designations;
	}

	public void setHMDA_Race_Designations(List<HMDA_Race_Designation> hMDA_Race_Designations) {
		this.hMDA_Race_Designations = hMDA_Race_Designations;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("HMDA_Race_Designation")){
			result = hMDA_Race_Designations.get(hMDA_Race_Designations.size()-1);
		}
		
		return result;
	}
}
