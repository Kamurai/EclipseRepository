package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor;

import java.math.BigDecimal;

public class Government_Borrower {
	String cAIVRSIdentifier;
	BigDecimal vACoBorrowerNontaxableIncomeAmount;
	BigDecimal vACoBorrowerTaxableIncomeAmount;
	BigDecimal vAFederalTaxAmount;
	BigDecimal vALocalTaxAmount;
	BigDecimal vAPrimaryBorrowerNontaxableIncomeAmount;
	BigDecimal vAPrimaryBorrowerTaxableIncomeAmount;
	BigDecimal vASocialSecurityTaxAmount;
	BigDecimal vAStateTaxAmount;

	public Government_Borrower(){}

	public String getCAIVRSIdentifier() {
		return cAIVRSIdentifier;
	}

	public void setCAIVRSIdentifier(String cAIVRSIdentifier) {
		this.cAIVRSIdentifier = cAIVRSIdentifier;
	}

	public BigDecimal getVACoBorrowerNontaxableIncomeAmount() {
		return vACoBorrowerNontaxableIncomeAmount;
	}

	public void setVACoBorrowerNontaxableIncomeAmount(String vACoBorrowerNontaxableIncomeAmount) {
		this.vACoBorrowerNontaxableIncomeAmount = new BigDecimal(vACoBorrowerNontaxableIncomeAmount);
	}

	public BigDecimal getVACoBorrowerTaxableIncomeAmount() {
		return vACoBorrowerTaxableIncomeAmount;
	}

	public void setVACoBorrowerTaxableIncomeAmount(String vACoBorrowerTaxableIncomeAmount) {
		this.vACoBorrowerTaxableIncomeAmount = new BigDecimal(vACoBorrowerTaxableIncomeAmount);
	}

	public BigDecimal getVAFederalTaxAmount() {
		return vAFederalTaxAmount;
	}

	public void setVAFederalTaxAmount(String vAFederalTaxAmount) {
		this.vAFederalTaxAmount = new BigDecimal(vAFederalTaxAmount);
	}

	public BigDecimal getVALocalTaxAmount() {
		return vALocalTaxAmount;
	}

	public void setVALocalTaxAmount(String vALocalTaxAmount) {
		this.vALocalTaxAmount = new BigDecimal(vALocalTaxAmount);
	}

	public BigDecimal getVAPrimaryBorrowerNontaxableIncomeAmount() {
		return vAPrimaryBorrowerNontaxableIncomeAmount;
	}

	public void setVAPrimaryBorrowerNontaxableIncomeAmount(String vAPrimaryBorrowerNontaxableIncomeAmount) {
		this.vAPrimaryBorrowerNontaxableIncomeAmount = new BigDecimal(vAPrimaryBorrowerNontaxableIncomeAmount);
	}

	public BigDecimal getVAPrimaryBorrowerTaxableIncomeAmount() {
		return vAPrimaryBorrowerTaxableIncomeAmount;
	}

	public void setVAPrimaryBorrowerTaxableIncomeAmount(String vAPrimaryBorrowerTaxableIncomeAmount) {
		this.vAPrimaryBorrowerTaxableIncomeAmount = new BigDecimal(vAPrimaryBorrowerTaxableIncomeAmount);
	}

	public BigDecimal getVASocialSecurityTaxAmount() {
		return vASocialSecurityTaxAmount;
	}

	public void setVASocialSecurityTaxAmount(String vASocialSecurityTaxAmount) {
		this.vASocialSecurityTaxAmount = new BigDecimal(vASocialSecurityTaxAmount);
	}

	public BigDecimal getVAStateTaxAmount() {
		return vAStateTaxAmount;
	}

	public void setVAStateTaxAmount(String vAStateTaxAmount) {
		this.vAStateTaxAmount = new BigDecimal(vAStateTaxAmount);
	}
}
