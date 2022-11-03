package com.fidelity.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientIdentificationTest {

	private String id;
	private String type;
	private String value;
	private ClientIdentification clientIdentification;

	@BeforeEach
	void setup() {
		id = "1";
		type = "SSN";
		value = "123456";
		clientIdentification = new ClientIdentification(id, type, value);
	}

	@AfterEach
	void tearDown() {
		clientIdentification = null;
	}

	@Test
	void test_ObjectCreation_NotNull() {
		assertNotNull(clientIdentification);
	}

	@Test
	void throw_NullPointerException_When_Type_IsNull() {
		type = null;
		assertThrows(NullPointerException.class, () -> {
			new ClientIdentification(id, type, value);
		});
	}

	@Test
	void throw_IllegalArgumentException_When_Type_IsNull() {
		type = "NotSSN";
		assertThrows(IllegalArgumentException.class, () -> {
			new ClientIdentification(id, type, value);
		});
	}

	@Test
	void throw_NullPointerException_When_Value_IsNull() {
		value = null;
		assertThrows(NullPointerException.class, () -> {
			new ClientIdentification(id, type, value);
		});
	}

	@Test
	void test_GetType() {
		assertEquals(clientIdentification.getType(), "SSN");
	}

	@Test
	void test_GetValue() {
		assertEquals(clientIdentification.getValue(), "123456");
	}

	@Test
	void test_ClientIdentification_HashCode() {
		ClientIdentification clientIdentification1 = new ClientIdentification(id, type, value);
		ClientIdentification clientIdentification2 = new ClientIdentification(id, type, value);
		assertEquals(clientIdentification1.hashCode(), clientIdentification2.hashCode());
	}

	@Test
	void test_ClientIdentification_EqualityEquals() {
		assertEquals(new ClientIdentification(id, type, value), clientIdentification);
	}

	@Test
	void test_ClientIdentification_InEquality() {
		assertNotEquals(new ClientIdentification("1", "Passport", value), clientIdentification);
	}

	@Test
	void test_ClientIdentification_InEquality_NullObject() {
		assertEquals(clientIdentification.equals(null), false);
	}

	@Test
	void test_ClientIdentification_InEquality_DifferentObjects() {
		Client client = new Client("1", LocalDate.of(2022, 1, 1), "a", "a", "a", "a", clientIdentification);
		assertEquals(clientIdentification.equals(client), false);
	}

	@Test
	void test_ClientIdentification_EqualitySameObjectEquals() {
		assertEquals(clientIdentification.equals(clientIdentification), true);
	}

	@Test
	void test_toString() {
		assertEquals(clientIdentification.toString(), "ClientIdentification [id=" + id + ", type=" + type + ", value=" + value + "]");
	}

}
