package com.fidelity.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Holding {
	private String clientId;
	private BigDecimal price;
	private BigDecimal gain;
	private BigDecimal noOfShares;
	private String direction;
	private Instrument instrument;
	
	public Holding() {
		// TODO Auto-generated constructor stub
	}
	
	public Holding(String clientId, Instrument instrument ,String direction, BigDecimal noOfShares) {
		this.clientId= clientId;
		this.direction=direction;
		this.gain=new BigDecimal(0);
		this.noOfShares=noOfShares;
		if(instrument!=null) {
		this.price= instrument.getPrice().getBidPrice();
		this.instrument=instrument;
		}
		else {
			this.price=new BigDecimal(0);
			this.instrument=null;
		}
	}

	public String getClientId() {
		return clientId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getGain() {
		return gain;
	}

	public BigDecimal getNoOfShares() {
		return noOfShares;
	}

	public String getDirection() {
		return direction;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setGain(BigDecimal gain) {
		this.gain = gain;
	}

	public void setNoOfShares(BigDecimal noOfShares) {
		this.noOfShares = noOfShares;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, direction, gain, instrument, noOfShares, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Holding other = (Holding) obj;
		return Objects.equals(clientId, other.clientId) && Objects.equals(direction, other.direction)
				&& Objects.equals(gain, other.gain) && Objects.equals(instrument, other.instrument)
				&& Objects.equals(noOfShares, other.noOfShares) && Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "Holding [clientId=" + clientId + ", price=" + price + ", gain=" + gain + ", noOfShares=" + noOfShares
				+ ", direction=" + direction + ", instrument=" + instrument + "]";
	}
	
	
}
