package information.dU34.Mes.DeaSet.Dea;

import java.math.BigDecimal;

public class Expense {
	//Attributes
	String sequenceNumber;
	String xlinklabel;
	//Elements
	BigDecimal ExpenseMonthlyPaymentAmount;
	Integer ExpenseRemainingTermMonthsCount;
	String expenseType;
	String expenseTypeOtherDescription;
	
	
	public Expense(){}

	public BigDecimal getExpenseMonthlyPaymentAmount() {
		return ExpenseMonthlyPaymentAmount;
	}

	public void setExpenseMonthlyPaymentAmount(String expenseMonthlyPaymentAmount) {
		ExpenseMonthlyPaymentAmount = new BigDecimal(expenseMonthlyPaymentAmount);
	}

	public Integer getExpenseRemainingTermMonthsCount() {
		return ExpenseRemainingTermMonthsCount;
	}

	public void setExpenseRemainingTermMonthsCount(Integer expenseRemainingTermMonthsCount) {
		ExpenseRemainingTermMonthsCount = expenseRemainingTermMonthsCount;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseTypeOtherDescription() {
		return expenseTypeOtherDescription;
	}

	public void setExpenseTypeOtherDescription(String expenseTypeOtherDescription) {
		this.expenseTypeOtherDescription = expenseTypeOtherDescription;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getXlinklabel() {
		return xlinklabel;
	}

	public void setXlinklabel(String xlinklabel) {
		this.xlinklabel = xlinklabel;
	}
}
