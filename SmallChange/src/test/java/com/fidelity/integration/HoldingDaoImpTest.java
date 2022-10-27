package com.fidelity.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.fidelity.model.Holding;

@SpringBootTest
@Transactional
class HoldingDaoImpTest {

	@Autowired
	HoldingDaoImp dao;


	@Test
	void testObjectCreation() {
		assertNotNull(dao);
	}
	
	@Test
	void test() {
		List<Integer> holdings=dao.getAllHoldings();
		System.out.println(holdings.size());
	}

}
