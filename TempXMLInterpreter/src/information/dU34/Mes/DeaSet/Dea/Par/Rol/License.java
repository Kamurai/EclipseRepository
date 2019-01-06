package information.dU34.Mes.DeaSet.Dea.Par.Rol;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Lic.License_Detail;

public class License {
	License_Detail license_Detail;
	
	public License(){
		license_Detail = new License_Detail();
	}

	public License_Detail getLicense_Detail() {
		return license_Detail;
	}

	public void setLicense_Detail(License_Detail license_Detail) {
		this.license_Detail = license_Detail;
	}
}
