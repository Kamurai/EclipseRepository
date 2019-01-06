package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Lia;

import information.uCD33.common.Name;

public class Liability_Holder {
	Name name;
	
	public Liability_Holder(){
		name = new Name();
	}
	
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
