package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res.Landlord;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res.Residence_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res.Address;

public class Residence {
	Address address;
	Landlord landlord;
	Residence_Detail residence_Detail;
	
	public Residence(){
		address = new Address();
		landlord = new Landlord();
		residence_Detail = new Residence_Detail();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Landlord getLandlord() {
		return landlord;
	}

	public void setLandlord(Landlord landlord) {
		this.landlord = landlord;
	}

	public Residence_Detail getResidence_Detail() {
		return residence_Detail;
	}

	public void setResidence_Detail(Residence_Detail residence_Detail) {
		this.residence_Detail = residence_Detail;
	}
}
