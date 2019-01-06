package information.dU34.Mes.DeaSet.Dea.Ass;

import information.dU34.Mes.DeaSet.Dea.Ass.AssHol.Name;

public class Asset_Holder {
	Name name;
	
	public Asset_Holder(){
		name = new Name();
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
}
