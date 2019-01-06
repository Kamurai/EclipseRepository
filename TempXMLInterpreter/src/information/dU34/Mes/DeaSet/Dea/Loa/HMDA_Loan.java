package information.dU34.Mes.DeaSet.Dea.Loa;

import information.dU34.Mes.DeaSet.Dea.Loa.HMDLoa.HMDA_Loan_Detail;

public class HMDA_Loan {
	HMDA_Loan_Detail hMDA_Loan_Detail;
	
	public HMDA_Loan(){
		hMDA_Loan_Detail = new HMDA_Loan_Detail();
	}

	public HMDA_Loan_Detail getHMDA_Loan_Detail() {
		return hMDA_Loan_Detail;
	}

	public void setHMDA_Loan_Detail(HMDA_Loan_Detail hMDA_Loan_Detail) {
		this.hMDA_Loan_Detail = hMDA_Loan_Detail;
	}
}
