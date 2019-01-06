package information.dU34.Mes.DeaSet.Dea.Par.Ind;

import information.dU34.Mes.DeaSet.Dea.Par.Ind.ConPoi.Contact_Point_Detail;

public class Contact_Point extends information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Par.Ind.Contact_Point {
	Contact_Point_Detail contact_Point_Detail;
	//Contact_Point_Email
	//Contact_Point_Telephone
	
	public Contact_Point(){
		super();
		contact_Point_Detail = new Contact_Point_Detail();
	}

	public Contact_Point_Detail getContact_Point_Detail() {
		return contact_Point_Detail;
	}

	public void setContact_Point_Detail(Contact_Point_Detail contact_Point_Detail) {
		this.contact_Point_Detail = contact_Point_Detail;
	}
}
