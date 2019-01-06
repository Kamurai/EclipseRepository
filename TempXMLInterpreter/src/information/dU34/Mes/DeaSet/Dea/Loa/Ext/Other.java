package information.dU34.Mes.DeaSet.Dea.Loa.Ext;

import information.dU34.Mes.DeaSet.Dea.Loa.Ext.Oth.Loan_Extension;

public class Other {
	Loan_Extension loan_Extension;
	
	public Other(){
		loan_Extension = new Loan_Extension();
	}

	public Loan_Extension getLoan_Extension() {
		return loan_Extension;
	}

	public void setLoan_Extension(Loan_Extension loan_Extension) {
		this.loan_Extension = loan_Extension;
	}
}
