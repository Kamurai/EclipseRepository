package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.GovMon.Ext.Oth;

import java.util.ArrayList;
import java.util.List;

import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.GovMon.Ext.Oth.GovMonExt.HMDA_Ethnicity;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.GovMon.Ext.Oth.GovMonExt.HMDA_Ethnicity_Origin;

public class Government_Monitoring_Extension 
{
	List<HMDA_Ethnicity> hMDA_Ethnicities;
	
	public Government_Monitoring_Extension()
	{
		hMDA_Ethnicities = new ArrayList<HMDA_Ethnicity>();
	}

	public List<HMDA_Ethnicity> getHMDA_Ethnicities() {
		return hMDA_Ethnicities;
	}

	public void setHMDA_Ethnicities(List<HMDA_Ethnicity> hMDA_Ethnicities) {
		this.hMDA_Ethnicities = hMDA_Ethnicities;
	}
	
	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("HMDA_Ethnicity")){
			result = hMDA_Ethnicities.get(hMDA_Ethnicities.size()-1);
		}
		
		return result;
	}
}
