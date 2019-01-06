package information.dU231.LoaApp.Bor.GovMon;

import java.util.ArrayList;
import java.util.List;

import information.dU231.LoaApp.Bor.GovMon.GovMonExt.Government_Monitoring_Detail;
import information.dU231.LoaApp.Bor.GovMon.GovMonExt.HMDA_Ethnicities;
import information.dU231.LoaApp.Bor.GovMon.GovMonExt.HMDA_Ethnicity_Origins;
import information.dU231.LoaApp.Bor.GovMon.GovMonExt.HMDA_Race;

public class Government_Monitoring_Extension 
{
	List<Government_Monitoring_Detail> government_monitoring_detail;
	HMDA_Ethnicities hMDA_Ethnicities;
	HMDA_Ethnicity_Origins hMDA_Ethnicity_Origins;
	List<HMDA_Race> hMDA_Races;

	public Government_Monitoring_Extension()
	{}
}
