package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par;

import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Ind.Name;

public class Individual
{
	Name name;
	

	public Individual()
	{
		name = new Name();
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
}
