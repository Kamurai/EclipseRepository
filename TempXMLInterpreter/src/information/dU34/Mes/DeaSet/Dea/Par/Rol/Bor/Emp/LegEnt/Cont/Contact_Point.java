package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Cont;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Cont.ConPoiTel.Contact_Point_Telephone;

public class Contact_Point {
	Contact_Point_Telephone contact_Point_Telephone;
	
	public Contact_Point(){
		contact_Point_Telephone = new Contact_Point_Telephone();
	}

	public Contact_Point_Telephone getContact_Point_Telephone() {
		return contact_Point_Telephone;
	}

	public void setContact_Point_Telephone(Contact_Point_Telephone contact_Point_Telephone) {
		this.contact_Point_Telephone = contact_Point_Telephone;
	}
}
