package com.fidelity.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InstrumentTest {

	private String instrumentId;
	private String instrumentDescription;
	private String externalId;
	private String externalIdType;
	private int minQuantity;
	private int maxQuantity;
	private String categoryId;
	private Instrument instrument;
	private Price price;

	@BeforeEach
	void setUp() throws Exception {
		instrumentId = UUID.randomUUID().toString();
		instrumentDescription = "Sample Instrument";
		externalId = UUID.randomUUID().toString();
		externalIdType = "Sample external ID type";
		minQuantity = 5;
		maxQuantity = 10;
		categoryId = UUID.randomUUID().toString();
		price = new Price(new BigDecimal("50.00"),new BigDecimal("51.00"),LocalDate.of(2022, 9, 28),"abcd");
		instrument = new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity,
				maxQuantity, categoryId,price);
	}

	@AfterEach
	void tearDown() throws Exception {
		instrument = null;
	}

	@Test
	public void objectReferenceNotNull() {
		assertNotNull(instrument);
	}

	@Test
	public void throwsExceptionWhenInstrumentIdIsEmpty() {
		instrumentId = "";
		assertThrows(IllegalArgumentException.class, () -> {
			new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity, maxQuantity,
					categoryId,price);
		});
	}

	@Test
	public void throwsExceptionWhenInstrumentDescriptionIsEmpty() {
		instrumentDescription = "";
		assertThrows(IllegalArgumentException.class, () -> {
			new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity, maxQuantity,
					categoryId,price);
		});
	}

	@Test
	public void throwsExceptionWhenExternalIdIsEmpty() {
		externalId = "";
		assertThrows(IllegalArgumentException.class, () -> {
			new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity, maxQuantity,
					categoryId,price);
		});
	}

	@Test
	public void throwsExceptionWhenExternalIdTypeIsEmpty() {
		externalIdType = "";
		assertThrows(IllegalArgumentException.class, () -> {
			new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity, maxQuantity,
					categoryId,price);
		});
	}

	@Test
	public void throwsExceptionWhenMinQuantityIsNegative() {
		minQuantity = -1;
		assertThrows(IllegalArgumentException.class, () -> {
			new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity, maxQuantity,
					categoryId,price);
		});
	}

	@Test
	public void throwsExceptionWhenMaxQuantityIsNegative() {
		maxQuantity = -1;
		assertThrows(IllegalArgumentException.class, () -> {
			new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity, maxQuantity,
					categoryId,price);
		});
	}

	@Test
	public void throwsExceptionWhenCategoryIdIsEmpty() {
		categoryId = "";
		assertThrows(IllegalArgumentException.class, () -> {
			new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity, maxQuantity,
					categoryId,price);
		});
	}
	
	@Test
	public void calculateTotalValueReturnsExpectedValue() {
		Price expected = new Price(new BigDecimal("50.00"),new BigDecimal("51.00"),LocalDate.of(2022, 9, 28),"abcd");
		assertEquals(expected, instrument.getPrice());
	}
	
	@Test
	public void getInstrumentIdReturnsExpectedValue() {
		assertEquals(instrumentId, instrument.getInstrumentId());
	}
	
	@Test
	public void getInstrumentDescriptionReturnsExpectedValue() {
		assertEquals(instrumentDescription, instrument.getInstrumentDescription());
	}
	
	@Test
	public void getExternalIdReturnsExpectedValue() {
		assertEquals(externalId, instrument.getExternalId());
	}
	
	@Test
	public void getExternalIdTypeReturnsExpectedValue() {
		assertEquals(externalIdType, instrument.getExternalIdType());
	}
	
	@Test
	public void getMinQuantityReturnsExpectedValue() {
		assertEquals(minQuantity, instrument.getMinQuantity());
	}
	
	@Test
	public void getMaxQuantityReturnsExpectedValue() {
		assertEquals(maxQuantity, instrument.getMaxQuantity());
	}
	@Test
	public void getCategoryIdReturnsExpectedValue() {
		assertEquals(categoryId, instrument.getCategoryId());
	}
	
	@Test
    void instrumentEquality() {
    	assertEquals(new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity,
				maxQuantity, categoryId,price), instrument);
    }

	@Test
    void instrumentInequality() {
    	assertNotEquals(new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity,
				7, categoryId,price), instrument);
    }
	
	@Test
	void testHashCode() {
		Instrument instrument2 = new Instrument(instrumentId, instrumentDescription, externalId, externalIdType, minQuantity,
				maxQuantity, categoryId,price);
		assertEquals(instrument.hashCode(), instrument2.hashCode());
	}
}
