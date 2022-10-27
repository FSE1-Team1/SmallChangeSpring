package com.fidelity.model;

public class Preferences {

	public String investmentPurpose;
	public String riskTolerance;
	public String incomeCategory;
	public String lengthOfInvestment;
	public Preferences(String investmentPurpose, String riskTolerance, String incomeCategory,
			String lengthOfInvestment) {
		super();
	
		this.investmentPurpose = investmentPurpose;
		this.riskTolerance = riskTolerance;
		this.incomeCategory = incomeCategory;
		this.lengthOfInvestment = lengthOfInvestment;
		
		setIncomeCategory(incomeCategory);
		setInvestmentPurpose(investmentPurpose);
		setLengthOfInvestment(lengthOfInvestment);
		setRiskTolerance(riskTolerance);
	}
	public String getInvestmentPurpose() {
		return investmentPurpose;
	}
	public void setInvestmentPurpose(String investmentPurpose) {
		this.investmentPurpose = investmentPurpose;
	}
	public String getRiskTolerance() {
		return riskTolerance;
	}
	public void setRiskTolerance(String riskTolerance) {
		this.riskTolerance = riskTolerance;
	}
	public String getIncomeCategory() {
		return incomeCategory;
	}
	public void setIncomeCategory(String incomeCategory) {
		this.incomeCategory = incomeCategory;
	}
	public String getLengthOfInvestment() {
		return lengthOfInvestment;
	}
	public void setLengthOfInvestment(String lengthOfInvestment) {
		this.lengthOfInvestment = lengthOfInvestment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((incomeCategory == null) ? 0 : incomeCategory.hashCode());
		result = prime * result + ((investmentPurpose == null) ? 0 : investmentPurpose.hashCode());
		result = prime * result + ((lengthOfInvestment == null) ? 0 : lengthOfInvestment.hashCode());
		result = prime * result + ((riskTolerance == null) ? 0 : riskTolerance.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preferences other = (Preferences) obj;
		if (incomeCategory == null) {
			if (other.incomeCategory != null)
				return false;
		} else if (!incomeCategory.equals(other.incomeCategory))
			return false;
		if (investmentPurpose == null) {
			if (other.investmentPurpose != null)
				return false;
		} else if (!investmentPurpose.equals(other.investmentPurpose))
			return false;
		if (lengthOfInvestment == null) {
			if (other.lengthOfInvestment != null)
				return false;
		} else if (!lengthOfInvestment.equals(other.lengthOfInvestment))
			return false;
		if (riskTolerance == null) {
			if (other.riskTolerance != null)
				return false;
		} else if (!riskTolerance.equals(other.riskTolerance))
			return false;
		return true;
	}
	
	
	
}
