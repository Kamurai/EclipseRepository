package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp;

import java.util.ArrayList;
import java.util.List;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Contact;

public class Legal_Entity extends information.uCD33.common.Legal_Entity{
	//Legal_Entity_Detail legal_Entity_Detail;
	List<Contact> contacts;
	
	public Legal_Entity(){
		super();
		contacts = new ArrayList<Contact>();
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Contact")){
			result = contacts.get(contacts.size()-1);
		}
		
		return result;
	}
}
