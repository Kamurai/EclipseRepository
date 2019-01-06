package information.uLDD30.common.Par;

import java.util.ArrayList;
import java.util.List;

import information.uLDD30.common.Par.Rols.Party_Role_Identifier;
import information.uLDD30.common.Par.Rols.Role;

public abstract class Roles 
{
	List<Party_Role_Identifier> party_Role_Identifiers;
	List<Role> roles;
	
	public Roles()
	{
		party_Role_Identifiers = new ArrayList<Party_Role_Identifier>();
		roles = new ArrayList<Role>();
	}
	
}
