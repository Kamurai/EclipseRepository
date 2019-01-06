package information.dU34.Mes.DeaSet.Dea.Par;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DeaSet.Dea.Par.Ind.Alias;
import information.dU34.Mes.DeaSet.Dea.Par.Ind.Contact_Point;
import information.dU34.Mes.DeaSet.Dea.Par.Ind.Name;

public class Individual implements ArrayListOwner{
	List<Alias> aliases;
	List<Contact_Point> contact_Points;
	Name name;
	
	public Individual(){
		aliases = new ArrayList<Alias>();
		contact_Points = new ArrayList<Contact_Point>();
		name = new Name();
	}
	
	public List<Alias> getAliases() {
		return aliases;
	}

	public void setAliases(ArrayList<Alias> aliases) {
		this.aliases = aliases;
	}

	public List<Contact_Point> getContact_Points() {
		return contact_Points;
	}

	public void setContact_Points(ArrayList<Contact_Point> contact_Points) {
		this.contact_Points = contact_Points;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Alias")){
			result = aliases.get(aliases.size()-1);
		}
		else if(objectType.equals("Contact_Point")){
			result = contact_Points.get(contact_Points.size()-1);
		}
		
		return result;
	}
}
