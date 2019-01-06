package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Cou.CouEve;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Counseling_Event_Detail {
	LocalDate counselingCompletedDate;
	Boolean counselingConfirmationIndicator;
	String counselingFormatType; //Enumeration
	String counselingType; //Enumeration

	public Counseling_Event_Detail(){}

	public LocalDate getCounselingCompletedDate() {
		return counselingCompletedDate;
	}

	public void setCounselingCompletedDate(LocalDate counselingCompletedDate) {
		this.counselingCompletedDate = counselingCompletedDate;
	}

	public Boolean getCounselingConfirmationIndicator() {
		return counselingConfirmationIndicator;
	}

	public void setCounselingConfirmationIndicator(Boolean counselingConfirmationIndicator) {
		this.counselingConfirmationIndicator = counselingConfirmationIndicator;
	}

	public String getCounselingFormatType() {
		return counselingFormatType;
	}

	public void setCounselingFormatType(String counselingFormatType) {
		this.counselingFormatType = counselingFormatType;
	}

	public String getCounselingType() {
		return counselingType;
	}

	public void setCounselingType(String counselingType) {
		this.counselingType = counselingType;
	}
}
