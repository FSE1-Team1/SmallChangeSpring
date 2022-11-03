package com.fidelity.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.model.Preferences;

@SpringBootTest
@Transactional
class PreferenceDaoImplTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
;
	@Autowired
	PreferenceDaoImpl dao;
	
	@Test
	void checkObjectNotNull(){
		assertNotNull(dao);
	}
	
	@Test 
	void testGetPreference() {
		String clientId = "ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515";
		Preferences pref1 = dao.getPreference(clientId);
		System.out.println(dao.getPreference(clientId)+"printed object");
		assertNotNull(pref1);
		
	}
	
	@Test 
	void testInsertPreference() {
		Preferences preference = new Preferences("ea0dd5f8-51b8-40b4-ab1e-a386a1c2c511","Save Money","Below Average","40,001 - 60,000","5-7 years");

		int count = dao.insertPreference(preference);
				assertEquals(count,1);
	}

//	@Test
//	void testUpdatePreferences() {
//		String clientId = "ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515";
//		Preferences preference = new Preferences(clientId,"Savings","Average","40,000 - 70,000","5-10 years");
//		
//		int count = dao.updatePreference(preference);
//				assertEquals(count,1);
//	}
	
	@Test
	void testDeletePreferences() {
		String clientId = "ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515";
		
		int count = dao.deletePreference(clientId);
		assertEquals(count,1);
	}
	
}
