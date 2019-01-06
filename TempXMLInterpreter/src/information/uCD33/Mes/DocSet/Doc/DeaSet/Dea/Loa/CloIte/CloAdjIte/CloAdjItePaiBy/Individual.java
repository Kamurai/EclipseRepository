package information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloIte.CloAdjIte.CloAdjItePaiBy;

import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.CloIte.CloAdjIte.CloAdjItePaiBy.Ind.Name;

public class Individual {
	Name name;
	
	public Individual(){
		name = new Name();
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
}
