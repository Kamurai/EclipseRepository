package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.GovMonDet.Ext;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.GovMonDet.Ext.Oth.Government_Monitoring_Detail_Extension;

public class Other {
	Government_Monitoring_Detail_Extension government_Monitoring_Detail_Extension;
	
	public Other(){
		government_Monitoring_Detail_Extension = new Government_Monitoring_Detail_Extension();
	}

	public Government_Monitoring_Detail_Extension getGovernment_Monitoring_Detail_Extension() {
		return government_Monitoring_Detail_Extension;
	}

	public void setGovernment_Monitoring_Detail_Extension(
			Government_Monitoring_Detail_Extension government_Monitoring_Detail_Extension) {
		this.government_Monitoring_Detail_Extension = government_Monitoring_Detail_Extension;
	}
}
