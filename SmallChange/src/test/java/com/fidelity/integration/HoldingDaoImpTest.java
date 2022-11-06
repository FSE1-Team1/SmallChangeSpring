package com.fidelity.integration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.intThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
import com.fidelity.model.HoldingReturn;
import com.fidelity.model.Instrument;
import com.fidelity.model.Price;

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
		String id="ea0dd5f8-51b8-40b4-ab1e-a386a1c2c515" ;
		List<HoldingReturn> holdings=dao.getAllHoldings(id);
		assert holdings.size()>0;
	}
	
	@Test
	void testInsert() {
		String instrumentId = "T67897";
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
		Holding holding =new Holding(id,instrument,direction,noOfShares);
		
		int total = dao.insertHolding(holding);
		assertEquals(total, 1);
	}
	
	@Test
	void testDelete() {
		String instrumentId = "T67897";
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
		Holding holding =new Holding(id,instrument,direction,noOfShares);
		dao.insertHolding(holding);
		
		int one = dao.getAllHoldings(id).size();
		dao.deleteHolding(id, instrumentId);
		int two = dao.getAllHoldings(id).size();
		assertEquals(one-1, two);
	}
	
	@Test
	void testUpdate() {
		String instrumentId = "T67897";
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
		Holding holding =new Holding(id,instrument,direction,noOfShares);
		dao.insertHolding(holding);
		
		holding.setNoOfShares(new BigDecimal(100));
		int total= dao.updateHolding(holding);
		assertEquals(total,1);
	}

}
