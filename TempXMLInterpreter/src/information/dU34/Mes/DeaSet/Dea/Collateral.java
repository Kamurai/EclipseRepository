package information.dU34.Mes.DeaSet.Dea;

import information.dU34.Mes.DeaSet.Dea.Col.Subject_Property;

public class Collateral {
	Subject_Property subject_Property;
	
	public Collateral(){
		subject_Property = new Subject_Property();
	}

	public Subject_Property getSubject_Property() {
		return subject_Property;
	}

	public void setSubject_Property(Subject_Property subject_Property) {
		this.subject_Property = subject_Property;
	}
}
