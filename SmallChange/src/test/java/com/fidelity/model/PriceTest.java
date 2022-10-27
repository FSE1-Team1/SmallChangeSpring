package com.fidelity.model;



import static org.junit.jupiter.api.Assertions.assertNotNull;



import java.math.BigDecimal;
import java.time.LocalDate;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class PriceTest {





  Price price;
    Instrument instrument;



  @BeforeEach
    void setUp() throws Exception {
        price = new Price(new BigDecimal("23456.00"), new BigDecimal("23457.00"), LocalDate.now(), "abcd");
    }




   @Test
    void testObjCreation() {
        assertNotNull(price);
    }



}