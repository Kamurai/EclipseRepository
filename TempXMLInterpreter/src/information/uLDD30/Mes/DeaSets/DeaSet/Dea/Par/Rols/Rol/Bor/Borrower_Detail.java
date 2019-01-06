package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Borrower_Detail 
{
	Integer borrowerAgeAtApplicationYearsCount;
	LocalDateTime borrowerBirthDate;
	String borrowerClassificationType; //Enumeration
	Boolean borrowerMailToAddressSameAsPropertyIndicator;
	BigDecimal borrowerQualifyingIncomeAmount;
	
	public Borrower_Detail()
	{
	}
}
