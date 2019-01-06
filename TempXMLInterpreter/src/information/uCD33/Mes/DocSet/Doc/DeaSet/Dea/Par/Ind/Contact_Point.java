package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Par.Ind;

import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Par.Ind.ConPoi.Contact_Point_Email;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Par.Ind.ConPoi.Contact_Point_Telephone;

public class Contact_Point {
	Contact_Point_Email contact_Point_Email;
	Contact_Point_Telephone contact_Point_Telephone;
	
	public Contact_Point(){
		contact_Point_Email = new Contact_Point_Email();
		contact_Point_Telephone = new Contact_Point_Telephone();
	}

	public Contact_Point_Email getContact_Point_Email() {
		return contact_Point_Email;
	}

	public void setContact_Point_Email(Contact_Point_Email contact_Point_Email) {
		this.contact_Point_Email = contact_Point_Email;
	}

	public Contact_Point_Telephone getContact_Point_Telephone() {
		return contact_Point_Telephone;
	}

	public void setContact_Point_Telephone(Contact_Point_Telephone contact_Point_Telephone) {
		this.contact_Point_Telephone = contact_Point_Telephone;
	}
}
