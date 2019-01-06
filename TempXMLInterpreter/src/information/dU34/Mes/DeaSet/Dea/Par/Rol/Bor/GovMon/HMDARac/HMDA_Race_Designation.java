package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDARac;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDARac.HMDARacDes.Extension;

public class HMDA_Race_Designation {
	Extension extension;
	
	public HMDA_Race_Designation(){
		extension = new Extension();
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
