package com.fidelity.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreferencesTest {

	Preferences preferences3;
	@BeforeEach
	void setUp() throws Exception {
		preferences3 = new Preferences("Save Money","Below Average","40,001 - 60,000","5-7 years");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void checkObjectNotEqualNull() {
		Preferences preference = null;
		assertNotEquals(preference,preferences3);
	}
	@Test
	void checkObjectNotEqualInvestmentPurpose() {
		Preferences preference = new Preferences("Saving for retirement","Below Average","40,001 - 60,000","5-7 years");
		assertNotEquals(preference,preferences3);
	}
	
	@Test
	void checkObjectEqual() {
		Preferences preference3 = new Preferences("Save Money","Below Average","40,001 - 60,000","5-7 years");
		assertEquals(preference3,preferences3);
	}
	
	@Test
	void getInvesmentPurosePositive() {
		assertEquals("Save Money" ,preferences3.getInvestmentPurpose());
	}
	
	@Test
	void getInvesmentPuroseNegative() {
		assertNotEquals("Save" ,preferences3.getInvestmentPurpose());
	}
	
	@Test
	void getIncomeCategoryPositive() {
		assertEquals("40,001 - 60,000",preferences3.getIncomeCategory());
	}
	
	@Test
	void getIncomeCategoryNegative() {
		assertNotEquals("60,001 - 80,000",preferences3.getIncomeCategory());
	}
	
	@Test
	void getRiskTolerancePositive(){
		assertEquals("Below Average",preferences3.getRiskTolerance());
		}
	
	@Test
	void getRiskToleranceNegative(){
		assertNotEquals("Average",preferences3.getRiskTolerance());
		}
	
	@Test
	void getLengthOfInvestmentPositive() {
		assertEquals("5-7 years",preferences3.getLengthOfInvestment());
	}
	
	@Test
	void getLengthOfInvestmentNegative() {
		assertNotEquals("7-10 years",preferences3.getLengthOfInvestment());
	}

}
