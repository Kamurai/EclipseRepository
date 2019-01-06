package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa;

import java.util.ArrayList;
import java.util.List;

import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Und.Automated_Underwriting;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Und.Underwriting_Detail;

public class Underwriting 
{
	List<Automated_Underwriting> automated_Underwritings;
	Underwriting_Detail underwriting_Detail;
	
	public Underwriting()
	{
		automated_Underwritings = new ArrayList<Automated_Underwriting>();
		underwriting_Detail = new Underwriting_Detail();		
	}
}
