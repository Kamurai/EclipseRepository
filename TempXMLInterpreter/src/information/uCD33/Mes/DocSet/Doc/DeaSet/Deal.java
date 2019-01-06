package information.uCD33.Mes.DocSet.Doc.DeaSet;

import java.util.ArrayList;
import java.util.List;

import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Collateral;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Liability;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loan;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Party;

public class Deal {
	List<Collateral> collaterals;
	List<Liability> liabilities;
	List<Loan> loans;
	List<Party> parties;
	
	public Deal(){}
}
