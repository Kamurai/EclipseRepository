package information.uLDD30.Mes.DeaSets.DeaSet.Dea;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Address;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Individual;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Legal_Entity;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Roles;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Taxpayer_Identifier;

public class Party extends information.uLDD30.common.Party implements ArrayListOwner
{
	List<Address> addresses;
	Individual individual;
	Legal_Entity legal_Entity;
	Roles roles;
	List<Taxpayer_Identifier> taxpayer_Identifiers;
		
	public Party()
	{
		super();
		addresses = new ArrayList<Address>();
		taxpayer_Identifiers = new ArrayList<Taxpayer_Identifier>();
	}
	
	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Address")){
			result = addresses.get(addresses.size()-1);
		}
		else if(objectType.equals("Taxpayer_Identifier")){
			result = taxpayer_Identifiers.get(taxpayer_Identifiers.size()-1);
		}
		
		return result;
	}
}
