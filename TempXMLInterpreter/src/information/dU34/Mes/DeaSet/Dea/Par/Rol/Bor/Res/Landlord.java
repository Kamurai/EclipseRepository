package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res.Lan.Landlord_Detail;

public class Landlord {
	Landlord_Detail landlord_Detail;
	
	public Landlord(){
		landlord_Detail = new Landlord_Detail();
	}

	public Landlord_Detail getLandlord_Detail() {
		return landlord_Detail;
	}

	public void setLandlord_Detail(Landlord_Detail landlord_Detail) {
		this.landlord_Detail = landlord_Detail;
	}
}
