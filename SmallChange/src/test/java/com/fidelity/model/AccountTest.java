package com.fidelity.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AccountTest {
	
	Account account;
	Price price;

	@BeforeEach
	void setUp() throws Exception {
		String accountNumber = "123";
		int max=3;
		account=new Account(accountNumber,max);
		price = new Price(new BigDecimal("50.00"),new BigDecimal("51.00"),LocalDate.of(2022, 9, 28),"abcd");
	}

	@AfterEach
	void tearDown() throws Exception {
		account=null;
	}

	@Test
	void test() {
		assertNotNull(account);
	}
	
	@Test
	void testGetAccountDetails() {
		List<Object> accountDetails= account.getAccountDetails();
		assertEquals(accountDetails.get(0), "123");
	}
	
	@Test
	void testAddProduct() {
		String instrumentId = UUID.randomUUID().toString();
		String instrumentDescription = "Sample Instrument";
		String externalId = UUID.randomUUID().toString();
		String externalIdType = "Sample external ID type";
		int minQuantity = 5;
		int maxQuantity = 10;
		String categoryId = UUID.randomUUID().toString();
		Instrument instrument = new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity,
				maxQuantity, categoryId,price);
		String direction="buy";
		BigDecimal noOfShares= new BigDecimal(10);
		Holding holding =new Holding(instrument,direction,noOfShares);
		int total= account.addHolding(holding);
		assertEquals(total, 1);
	}
	
	@Test
	void testRemoveProduct() {
		String instrumentId = UUID.randomUUID().toString();
		String instrumentDescription = "Sample Instrument";
		String externalId = UUID.randomUUID().toString();
		String externalIdType = "Sample external ID type";
		int minQuantity = 5;
		int maxQuantity = 10;
		String categoryId = UUID.randomUUID().toString();
		Instrument instrument = new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity,
				maxQuantity, categoryId,price);
		String direction="buy";
		BigDecimal noOfShares= new BigDecimal(10);
		Holding holding =new Holding(instrument,direction,noOfShares);
		account.addHolding(holding);
		int total= account.removeHolding(holding);
		assertEquals(total, 0);
	}
	
	@Test
	void testGetAccountNumber() {
		String accountNuString= account.getAccountNumber();
		assertEquals(accountNuString, "123");
	}
	
	@Test
	void testWrongHoldingAddition() {
		assertThrows(NullPointerException.class, ()-> {
			account.addHolding(null);
		});
	}
	
	@Test
	void testMaxHoldingLimit() {
		String instrumentId = UUID.randomUUID().toString();
		String instrumentDescription = "Sample Instrument";
		String externalId = UUID.randomUUID().toString();
		String externalIdType = "Sample external ID type";
		int minQuantity = 5;
		int maxQuantity = 10;
		String categoryId = UUID.randomUUID().toString();
		Instrument instrument = new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity,
				maxQuantity, categoryId,price);
		String direction="buy";
		BigDecimal noOfShares= new BigDecimal(10);
		Holding holding =new Holding(instrument,direction,noOfShares);
		account.addHolding(holding);
		account.addHolding(holding);
		account.addHolding(holding);
		assertThrows(IllegalArgumentException.class, ()-> {
			account.addHolding(holding);
		});
	}
	
	@Test
	void testNullHoldingRemoval() {
		assertThrows(NullPointerException.class, ()-> {
			account.removeHolding(null);
		});
	}
	
	@Test
	void testWrongHoldingRemoval() {
		String instrumentId = UUID.randomUUID().toString();
		String instrumentDescription = "Sample Instrument";
		String externalId = UUID.randomUUID().toString();
		String externalIdType = "Sample external ID type";
		int minQuantity = 5;
		int maxQuantity = 10;
		String categoryId = UUID.randomUUID().toString();
		Instrument instrument = new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity,
				maxQuantity, categoryId,price);
		String direction="buy";
		BigDecimal noOfShares= new BigDecimal(10);
		Holding holding =new Holding(instrument,direction,noOfShares);
		account.addHolding(holding);
		Holding holding1 =new Holding(instrument,direction,noOfShares);
		holding1.setPrice(new BigDecimal(200));
		assertThrows(IllegalArgumentException.class, ()-> {
			account.removeHolding(holding1);
		});
	}

}
