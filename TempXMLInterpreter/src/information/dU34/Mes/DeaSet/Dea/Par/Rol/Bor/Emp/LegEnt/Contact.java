package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt;

import java.util.ArrayList;
import java.util.List;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Cont.Contact_Point;

public class Contact {
	List<Contact_Point> contact_Points;

	public Contact(){
		contact_Points = new ArrayList<Contact_Point>();
	}

	public List<Contact_Point> getContact_Points() {
		return contact_Points;
	}

	public void setContact_Points(List<Contact_Point> contact_Points) {
		this.contact_Points = contact_Points;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Contact_Point")){
			result = contact_Points.get(contact_Points.size()-1);
		}
		
		return result;
	}
}
