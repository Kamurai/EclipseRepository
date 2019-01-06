package information.dU34.Mes.DeaSet.Dea.Loa.Ext.Oth;

import java.util.ArrayList;
import java.util.List;

import information.dU34.Mes.DeaSet.Dea.Loa.Ext.Oth.LoaExt.Underwriting_Verification;

public class Loan_Extension {
	List<Underwriting_Verification> underwriting_Verifications;
	
	public Loan_Extension(){
		underwriting_Verifications = new ArrayList<Underwriting_Verification>();
	}

	public List<Underwriting_Verification> getUnderwriting_Verifications() {
		return underwriting_Verifications;
	}

	public void setUnderwriting_Verifications(List<Underwriting_Verification> underwriting_Verifications) {
		this.underwriting_Verifications = underwriting_Verifications;
	}
	
	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Underwriting_Verification")){
			result = underwriting_Verifications.get(underwriting_Verifications.size()-1);
		}
		
		return result;
	}
}
