package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res;

public class Residence_Detail {
	String borrowerResidencyBasisType; //Enumeration
	Integer borrowerResidencyDurationMonthsCount;
	String borrowerResidencyType; //Enumeration
	
	public Residence_Detail(){}

	public String getBorrowerResidencyBasisType() {
		return borrowerResidencyBasisType;
	}

	public void setBorrowerResidencyBasisType(String borrowerResidencyBasisType) {
		this.borrowerResidencyBasisType = borrowerResidencyBasisType;
	}

	public Integer getBorrowerResidencyDurationMonthsCount() {
		return borrowerResidencyDurationMonthsCount;
	}

	public void setBorrowerResidencyDurationMonthsCount(Integer borrowerResidencyDurationMonthsCount) {
		this.borrowerResidencyDurationMonthsCount = borrowerResidencyDurationMonthsCount;
	}

	public String getBorrowerResidencyType() {
		return borrowerResidencyType;
	}

	public void setBorrowerResidencyType(String borrowerResidencyType) {
		this.borrowerResidencyType = borrowerResidencyType;
	}
}
