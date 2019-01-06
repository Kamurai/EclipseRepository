package information.dU231.LoaApp.Bor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Employer 
{
	String name;
	String streetAddress;
	String city;
	String state;
	String postalCode;
	String telephoneNumber;
	Integer currentEmploymentMonthsOnJob;
	String currentEmploymentTimeInLineOfWorkYears;
	Integer currentEmploymentYearsOnJob;
	Boolean employmentBorrowerSelfEmployedIndicator;
	Boolean employmentCurrentIndicator;
	String employmentPositionDescription;
	Boolean employmentPrimaryIndicator;
	BigDecimal incomeEmploymentMonthlyAmount;
	LocalDateTime previousEmploymentEndDate;
	LocalDateTime previousEmploymentStartDate;
	
	public Employer()
	{
		//incomeEmploymentMonthlyAmount = new BigDecimal("-00.01");
		//previousEmploymentStartDate = LocalDateTime.of(LocalDate.of(2000,1,1), LocalTime.of(0,0,0,0));
	}
	
	
}
