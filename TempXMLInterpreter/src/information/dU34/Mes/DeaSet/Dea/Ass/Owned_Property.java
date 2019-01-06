package information.dU34.Mes.DeaSet.Dea.Ass;

import information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Property;

public class Owned_Property {
	Property property;
	
	public Owned_Property(){
		 property = new Property();
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
}
