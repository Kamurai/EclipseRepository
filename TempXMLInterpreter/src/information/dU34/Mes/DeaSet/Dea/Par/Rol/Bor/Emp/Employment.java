package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.Emp.Extension;

public class Employment extends information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.Emp.Employment {
	//Boolean employmentBorrowerSelfEmployedIndicator;
	String employmentClassificationType;
	LocalDate employmentEndDate;
	BigDecimal employmentMonthlyIncomeAmount;
	String employmentPositionDescription;
	LocalDate employmentStartDate;
	String employmentStatusType; //Enumeration
	Integer employmentTimeInLineOfWorkMonthsCount;
	String ownershipInterestType; //Enumeration
	Boolean specialBorrowerEmployerRelationshipIndicator;
	Extension extension;
	
	public Employment(){
		super();
		extension = new Extension();
	}

	public String getEmploymentClassificationType() {
		return employmentClassificationType;
	}

	public void setEmploymentClassificationType(String employmentClassificationType) {
		this.employmentClassificationType = employmentClassificationType;
	}

	public LocalDate getEmploymentEndDate() {
		return employmentEndDate;
	}

	public void setEmploymentEndDate(LocalDate employmentEndDate) {
		this.employmentEndDate = employmentEndDate;
	}

	public BigDecimal getEmploymentMonthlyIncomeAmount() {
		return employmentMonthlyIncomeAmount;
	}

	public void setEmploymentMonthlyIncomeAmount(String employmentMonthlyIncomeAmount) {
		this.employmentMonthlyIncomeAmount = new BigDecimal(employmentMonthlyIncomeAmount);
	}

	public String getEmploymentPositionDescription() {
		return employmentPositionDescription;
	}

	public void setEmploymentPositionDescription(String employmentPositionDescription) {
		this.employmentPositionDescription = employmentPositionDescription;
	}

	public LocalDate getEmploymentStartDate() {
		return employmentStartDate;
	}

	public void setEmploymentStartDate(LocalDate employmentStartDate) {
		this.employmentStartDate = employmentStartDate;
	}

	public String getEmploymentStatusType() {
		return employmentStatusType;
	}

	public void setEmploymentStatusType(String employmentStatusType) {
		this.employmentStatusType = employmentStatusType;
	}

	public Integer getEmploymentTimeInLineOfWorkMonthsCount() {
		return employmentTimeInLineOfWorkMonthsCount;
	}

	public void setEmploymentTimeInLineOfWorkMonthsCount(Integer employmentTimeInLineOfWorkMonthsCount) {
		this.employmentTimeInLineOfWorkMonthsCount = employmentTimeInLineOfWorkMonthsCount;
	}

	public String getOwnershipInterestType() {
		return ownershipInterestType;
	}

	public void setOwnershipInterestType(String ownershipInterestType) {
		this.ownershipInterestType = ownershipInterestType;
	}

	public Boolean getSpecialBorrowerEmployerRelationshipIndicator() {
		return specialBorrowerEmployerRelationshipIndicator;
	}

	public void setSpecialBorrowerEmployerRelationshipIndicator(Boolean specialBorrowerEmployerRelationshipIndicator) {
		this.specialBorrowerEmployerRelationshipIndicator = specialBorrowerEmployerRelationshipIndicator;
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
