package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Military_Service {
	LocalDate militaryServiceExpectedCompletionDate;
	String militaryStatusType; //Enumeration
	
	public Military_Service(){}

	public LocalDate getMilitaryServiceExpectedCompletionDate() {
		return militaryServiceExpectedCompletionDate;
	}

	public void setMilitaryServiceExpectedCompletionDate(LocalDate localDate) {
		this.militaryServiceExpectedCompletionDate = localDate;
	}

	public String getMilitaryStatusType() {
		return militaryStatusType;
	}

	public void setMilitaryStatusType(String militaryStatusType) {
		this.militaryStatusType = militaryStatusType;
	}
}
