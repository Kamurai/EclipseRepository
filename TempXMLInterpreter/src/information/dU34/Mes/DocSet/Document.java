package information.dU34.Mes.DocSet;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DocSet.Doc.Signatory;

public class Document implements ArrayListOwner {
	List<Signatory> signatories;
	
	public Document(){
		signatories = new ArrayList<Signatory>();
	}

	public List<Signatory> getSignatories() {
		return signatories;
	}

	public void setSignatories(ArrayList<Signatory> signatories) {
		this.signatories = signatories;
	}
	
	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Signatory")){
			result = signatories.get(signatories.size()-1);
		}
		
		return result;
	}
}
