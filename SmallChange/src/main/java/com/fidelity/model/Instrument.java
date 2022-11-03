package com.fidelity.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Instrument {
	
	private String instrumentId;
	private String instrumentDescription;
	private String externalId;
	private String externalIdType;
	private int minQuantity;
	private int maxQuantity;
	private String categoryId;
	private Price price;

	public Instrument() {
	}


	public Instrument(String instrumentId, String instrumentDescription, 
			String externalId, String externalIdType, int minQuantity, 
			int maxQuantity, String categoryId, Price price) {
		setInstrumentId(instrumentId);
		setInstrumentDescription(instrumentDescription);
		setExternalId(externalId);
		setExternalIdType(externalIdType);
		setMinQuantity(minQuantity);
		setMaxQuantity(maxQuantity);
		setCategoryId(categoryId);
		setPrice(price);
	}

	public void setInstrumentId(String instrumentId) {
		if(instrumentId.isEmpty()) {
			throw new IllegalArgumentException("Instrument ID cannot be empty");
		}
		this.instrumentId = instrumentId;
	}

	public void setInstrumentDescription(String instrumentDescription) {
		if(instrumentDescription.isEmpty()) {
			throw new IllegalArgumentException("Instrument description cannot be empty");
		}
		this.instrumentDescription = instrumentDescription;
	}

	public void setExternalId(String externalId) {
		if(externalId.isEmpty()) {
			throw new IllegalArgumentException("External ID cannot be empty");
		}
		this.externalId = externalId;
	}

	public void setExternalIdType(String externalIdType) {
		if(externalIdType.isEmpty()) {
			throw new IllegalArgumentException("External ID type cannot be empty");
		}
		this.externalIdType = externalIdType;
	}

	public void setMinQuantity(int minQuantity) {
		if(minQuantity<=0) {
			throw new IllegalArgumentException("Minimum quantity cannot be negative");
		}
		this.minQuantity = minQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		if(maxQuantity<=0) {
			throw new IllegalArgumentException("Maximum quantity cannot be negative");
		}
		this.maxQuantity = maxQuantity;
	}

	public void setCategoryId(String categoryId) {
		if(categoryId.isEmpty()) {
			throw new IllegalArgumentException("Category ID cannot be empty");
		}
		this.categoryId = categoryId;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public String getInstrumentDescription() {
		return instrumentDescription;
	}

	public String getExternalId() {
		return externalId;
	}

	public String getExternalIdType() {
		return externalIdType;
	}

	public int getMinQuantity() {
		return minQuantity;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryId, externalId, externalIdType, instrumentDescription, instrumentId, maxQuantity,
				minQuantity, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrument other = (Instrument) obj;
		return Objects.equals(categoryId, other.categoryId) && Objects.equals(externalId, other.externalId)
				&& Objects.equals(externalIdType, other.externalIdType)
				&& Objects.equals(instrumentDescription, other.instrumentDescription)
				&& Objects.equals(instrumentId, other.instrumentId) && maxQuantity == other.maxQuantity
				&& minQuantity == other.minQuantity && Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "Instrument [instrumentId=" + instrumentId + ", instrumentDescription=" + instrumentDescription
				+ ", externalId=" + externalId + ", externalIdType=" + externalIdType + ", minQuantity=" + minQuantity
				+ ", maxQuantity=" + maxQuantity + ", categoryId=" + categoryId + ", price=" + price + "]";
	}
	
}
