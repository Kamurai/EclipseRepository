package information.dU34.Mes.DeaSet.Dea.Col.SubPro;

import information.dU34.Mes.DeaSet.Dea.Col.SubPro.LocIde.Census_Information;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.LocIde.FIPS_Information;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.LocIde.General_Identifier;

public class Location_Identifier {
	Census_Information census_Information;
	FIPS_Information fIPS_Information;
	General_Identifier general_Identifier;
	
	public Location_Identifier(){
		fIPS_Information = new FIPS_Information();
		census_Information = new Census_Information();
		general_Identifier = new General_Identifier();
	}
	
	public General_Identifier getGeneral_Identifier() {
		return general_Identifier;
	}

	public void setGeneral_Identifier(General_Identifier general_Identifier) {
		this.general_Identifier = general_Identifier;
	}

	

	public FIPS_Information getfIPS_Information() {
		return fIPS_Information;
	}

	public void setfIPS_Information(FIPS_Information fIPS_Information) {
		this.fIPS_Information = fIPS_Information;
	}

	public Census_Information getCensus_Information() {
		return census_Information;
	}

	public void setCensus_Information(Census_Information census_Information) {
		this.census_Information = census_Information;
	}
}
