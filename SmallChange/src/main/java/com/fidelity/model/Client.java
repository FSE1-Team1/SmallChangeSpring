package com.fidelity.model;

import java.time.LocalDate;
import java.util.Objects;

public class Client {
	
	private String id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String email;
	private String password;
	private String country;
	private String postalCode;
	private ClientIdentification identification;
	
	public Client(String id, String firstName, String lastName, LocalDate dateOfBirth, String email, String password,
			String country, String postalCode, ClientIdentification identification) {
		super();
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setDateOfBirth(dateOfBirth);
		setEmail(email);
		setPassword(password);
		setCountry(country);
		setPostalCode(postalCode);
		setIdentification(identification);
	}
	
	public Client(String id, LocalDate dateOfBirth, String email, String password,
			String country, String postalCode, ClientIdentification identification) {
		super();
		setId(id);
		setDateOfBirth(dateOfBirth);
		setEmail(email);
		setPassword(password);
		setCountry(country);
		setPostalCode(postalCode);
		setIdentification(identification);
	}

	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public ClientIdentification getIdentification() {
		return identification;
	}

	public void setId(String id) {
		if(id==null) {
			throw new NullPointerException("Id cannot be null");
		}
		this.id = id;
	}

	public void setFirstName(String firstName) {
		if(firstName==null) {
			throw new NullPointerException("FirstName cannot be null");
		}
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		if(lastName==null) {
			throw new NullPointerException("LastName cannot be null");
		}
		this.lastName = lastName;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		if(dateOfBirth==null) {
			throw new NullPointerException("DateOfBirth cannot be null");
		}
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(String email) {
		if(email==null) {
			throw new NullPointerException("Email cannot be null");
		}
		this.email = email;
	}

	public void setPassword(String password) {
		if(password==null) {
			throw new NullPointerException("Password cannot be null");
		}
		this.password = password;
	}

	public void setCountry(String country) {
		if(country==null) {
			throw new NullPointerException("Country cannot be null");
		}
		this.country = country;
	}

	public void setPostalCode(String postalCode) {
		if(postalCode==null) {
			throw new NullPointerException("PostalCode cannot be null");
		}
		this.postalCode = postalCode;
	}

	public void setIdentification(ClientIdentification identification) {
		if(identification==null) {
			throw new NullPointerException("Client Identification cannot be null");
		}
		this.identification = identification;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, dateOfBirth, email, firstName, id, identification, lastName, password, postalCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(country, other.country) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(identification, other.identification)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(postalCode, other.postalCode);
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", password=" + password + ", country=" + country + ", postalCode="
				+ postalCode + ", identification=" + identification.toString() + "]";
	}
	
}
