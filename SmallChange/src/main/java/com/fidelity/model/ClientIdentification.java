package com.fidelity.model;

import java.util.Objects;

public class ClientIdentification {

	private String id;
	private String type;
	private String value;
	
	public ClientIdentification() {
		
	}
	
	public ClientIdentification(String id, String type, String value) {
		super();
		if(type==null) {
			throw new NullPointerException("Type cannot be null");
		}
		if(!type.equals("SSN") && !type.equals("Passport")) {
			throw new IllegalArgumentException("Type should either be SSN or Passport");
		}
		if(value==null) {
			throw new NullPointerException("Value cannot be null");
		}
		this.id = id;
		this.type = type;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ClientIdentification)) {
			return false;
		}
		ClientIdentification other = (ClientIdentification) obj;
		return Objects.equals(id, other.id) && Objects.equals(type, other.type) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "ClientIdentification [id=" + id + ", type=" + type + ", value=" + value + "]";
	}
		
}
