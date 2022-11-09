package com.fidelity.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HoldingTest {
	
 	private Holding holding;

	@BeforeEach
	void setUp() throws Exception {
		String instrumentId = UUID.randomUUID().toString();
		String instrumentDescription = "Sample Instrument";
		String externalId = UUID.randomUUID().toString();
		String externalIdType = "Sample external ID type";
		int minQuantity = 5;
		int maxQuantity = 10;
		String categoryId = UUID.randomUUID().toString();
		Price price = new Price(new BigDecimal("50.00"),new BigDecimal("51.00"),LocalDate.of(2022, 9, 28),"abcd");
		Instrument instrument = new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity,
				maxQuantity, categoryId,price);
		String direction="buy";
		BigDecimal noOfShares= new BigDecimal(10);
		String id="1";
		holding =new Holding(id,instrument,direction,noOfShares);
	}

	@AfterEach
	void tearDown() throws Exception {
		holding=null;
	}

	@Test
	void test() {
		assertNotNull(holding);
	}
	
	@Test
	void testGetPrice() {
		assertEquals(holding.getPrice(), new BigDecimal(50).setScale(2));
	}
	
	@Test
	void testGetGain() {
		assertEquals(holding.getGain(), new BigDecimal(0));
	}
	
	@Test
	void testGetShare() {
		assertEquals(holding.getNoOfShares(), new BigDecimal(10));
	}
	
	@Test
	void testGetDirection() {
		assertEquals(holding.getDirection(), "buy");
	}
	
	@Test
	void testEquals() {
		Holding holding1 = holding;
		assertEquals(holding, holding1);
	}

}
