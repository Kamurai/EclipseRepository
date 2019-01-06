package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols;

import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Appraiser;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Appraiser_Supervisor;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Borrower;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Loan_Originator;

public class Role extends information.uLDD30.common.Par.Rols.Role
{
	Appraiser appraiser;
	Appraiser_Supervisor appraiser_Supervisor;
	Borrower borrower;
	Loan_Originator loan_Originator;
	
	public Role()
	{
		super();
	}
}
