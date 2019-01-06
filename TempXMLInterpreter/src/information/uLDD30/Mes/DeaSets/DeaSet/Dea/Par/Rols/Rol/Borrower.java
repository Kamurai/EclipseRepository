package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol;

import java.util.ArrayList;
import java.util.List;

import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.Borrower_Detail;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.Counseling_Confirmation;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.Credit_Score;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.Declaration;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.Employer;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.Government_Monitoring;

public class Borrower 
{
	Borrower_Detail borrower_detail;
	Counseling_Confirmation counseling_Confirmation;
	List<Credit_Score> credit_Scores;
	Declaration declaration;
	List<Employer> employers;
	Government_Monitoring government_Monitoring;
	
	public Borrower()
	{
		
	}
}
