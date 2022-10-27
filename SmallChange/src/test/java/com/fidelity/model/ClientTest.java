package com.fidelity.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientTest {
	
	private String id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String email;
	private String password;
	private String country;
	private String postalCode;
	private ClientIdentification identification;
	private Client client;

	@BeforeEach
	void setUp() {
		id = "1";
		firstName = "ABC";
		lastName = "DEF";
		dateOfBirth = LocalDate.of(2001, 3, 3);
		email = "abcdef@gmail.com";
		password = "Testing123_";
		country = "USA";
		postalCode = "600091";
		identification = new ClientIdentification("SSN", "123456");
		client = new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification);		
	}

	@AfterEach
	void tearDown() {
		client = null;
	}
	
	@Test 
	void test_ObjectCreation_NotNull_WithFirstAndLastName() {
		assertNotNull(client);
	}
	
	@Test 
	void test_ObjectCreation_NotNull_WithoutFirstAndLastName() {
		client = new Client(id, dateOfBirth, email, password, country, postalCode, identification);
		assertNotNull(client);
	}
	
	@Test
	void throws_NullPointerException_When_Id_IsNull() {
		id = null;
		assertThrows(NullPointerException.class, () -> {
			new Client(id, dateOfBirth, email, password, country, postalCode, identification); 
		});
	}
	
	@Test
	void throws_NullPointerException_When_firstName_IsNull() {
		firstName = null;
		assertThrows(NullPointerException.class, () -> {
			new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification);
		});
	}
	
	@Test
	void throws_NullPointerException_When_LastName_IsNull() {
		lastName = null;
		assertThrows(NullPointerException.class, () -> {
			new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification);
		});
	}
	
	@Test
	void throws_NullPointerException_When_DateOfBirth_IsNull() {
		dateOfBirth = null;
		assertThrows(NullPointerException.class, () -> {
			new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification);
		});
	}
	
	@Test
	void throws_NullPointerException_When_Email_IsNull() {
		email = null;
		assertThrows(NullPointerException.class, () -> {
			new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification);
		});
	}
	
	@Test
	void throws_NullPointerException_When_Password_IsNull() {
		password = null;
		assertThrows(NullPointerException.class, () -> {
			new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification);
		});
	}
	
	@Test
	void throws_NullPointerException_When_Country_IsNull() {
		country = null;
		assertThrows(NullPointerException.class, () -> {
			new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification);
		});
	}
	
	@Test
	void throws_NullPointerException_When_PostalCode_IsNull() {
		postalCode = null;
		assertThrows(NullPointerException.class, () -> {
			new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification);
		});
	}
	
	@Test
	void throws_NullPointerException_When_Identification_IsNull() {
		identification = null;
		assertThrows(NullPointerException.class, () -> {
			new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification);
		});
	}
	
	@Test
	void test_GetId() {
		assertEquals(client.getId(), id);
	}
	
	@Test
	void test_GetFirstName() {
		assertEquals(client.getFirstName(), firstName);
	}
	
	@Test
	void test_GetLastName() {
		assertEquals(client.getLastName(), lastName);
	}
	
	@Test
	void test_GetEmail() {
		assertEquals(client.getEmail(), email);
	}
	
	@Test
	void test_GetDateOfBirth() {
		assertEquals(client.getDateOfBirth(), dateOfBirth);
	}
	
	@Test
	void test_GetPassword() {
		assertEquals(client.getPassword(), password);
	}
	
	@Test
	void test_GetCountry() {
		assertEquals(client.getCountry(), country);
	}
	
	@Test
	void test_GetPostalCode() {
		assertEquals(client.getPostalCode(), postalCode);
	}
	
	@Test
	void test_GetIdentification() {
		assertEquals(client.getIdentification(), identification);
	}
	
	@Test
	void test_Client_HashCode() {
		Client client1 = new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification);
		Client client2 = new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification);
		assertEquals(client1.hashCode(), client2.hashCode());
	}
	
	@Test
	void test_Client_EqualityEquals() {
		assertEquals(new Client(id, firstName, lastName, dateOfBirth, email, password, country, postalCode, identification), client);
	}
	
	@Test
	void test_Client_InEquality() {
		assertNotEquals(new Client("2", firstName, lastName, dateOfBirth, email, password, country, postalCode, identification), client);
	}
	
	@Test
	void test_Client_InEquality_NullObject() {
		assertEquals(client.equals(null), false);
	}
	
	@Test
	void test_Client_InEquality_DifferentObjects() {
		assertEquals(client.equals(identification), false);
	}
	
	@Test
	void test_Client_EqualitySameObjectEquals() {
		assertEquals(client.equals(client), true);
	}

	@Test
	void test_toString() {
		assertEquals(client.toString(), "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", password=" + password + ", country=" + country + ", postalCode="
				+ postalCode + ", identification=" + identification.toString() + "]");
	}
	
}
