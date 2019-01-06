package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.FeeInf;

import java.util.ArrayList;
import java.util.List;

import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.FeeInf.FeeP.Fee_Detail;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.FeeInf.FeeP.Fee_Paid_To;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.FeeInf.FeeP.Fee_Payment;

public class Fee {
	Fee_Detail fee_Detail;
	Fee_Paid_To fee_Paid_To;
	List<Fee_Payment> fee_Payments;
	
	public Fee(){}
}
