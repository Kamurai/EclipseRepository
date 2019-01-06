package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.Extension;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.Government_Monitoring_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDA_Race;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.GovMon.Ext.Oth.GovMonExt.HMDA_Ethnicity_Origin;

public class Government_Monitoring implements ArrayListOwner {
	Extension extension;
	Government_Monitoring_Detail government_Monitoring_Detail;
	List<HMDA_Ethnicity_Origin> hMDA_Ethnicity_Origins;
	List<HMDA_Race> hMDA_Races;
	
	public Government_Monitoring(){
		extension = new Extension();
		government_Monitoring_Detail = new Government_Monitoring_Detail();
		hMDA_Ethnicity_Origins = new ArrayList<HMDA_Ethnicity_Origin>();
		hMDA_Races = new ArrayList<HMDA_Race>();
	}
	
	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public Government_Monitoring_Detail getGovernment_Monitoring_Detail() {
		return government_Monitoring_Detail;
	}

	public void setGovernment_Monitoring_Detail(Government_Monitoring_Detail government_Monitoring_Detail) {
		this.government_Monitoring_Detail = government_Monitoring_Detail;
	}

	public List<HMDA_Ethnicity_Origin> getHMDA_Ethnicity_Origins() {
		return hMDA_Ethnicity_Origins;
	}

	public void setHMDA_Ethnicity_Origins(List<HMDA_Ethnicity_Origin> hMDA_Ethnicity_Origins) {
		this.hMDA_Ethnicity_Origins = hMDA_Ethnicity_Origins;
	}

	public List<HMDA_Race> getHMDA_Races() {
		return hMDA_Races;
	}

	public void setHMDA_Races(List<HMDA_Race> hMDA_Races) {
		this.hMDA_Races = hMDA_Races;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("HMDA_Ethnicity_Origin")){
			result = hMDA_Ethnicity_Origins.get(hMDA_Ethnicity_Origins.size()-1);
		}
		else if(objectType.equals("HMDA_Race")){
			result = hMDA_Races.get(hMDA_Races.size()-1);
		}
		
		return result;
	}
}
