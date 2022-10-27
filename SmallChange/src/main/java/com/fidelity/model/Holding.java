package com.fidelity.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Holding {
	private BigDecimal price;
	private BigDecimal gain;
	private BigDecimal noOfShares;
	private String direction;
	private Instrument instrument;
	
	public Holding(Instrument instrument ,String direction, BigDecimal noOfShares) {
		this.direction=direction;
		this.gain=new BigDecimal(0);
		this.noOfShares=noOfShares;
		this.price= instrument.getPrice().getBidPrice();
		this.instrument=instrument;
	}
	
	

	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public BigDecimal getGain() {
		return instrument.getPrice().getBidPrice().subtract(price);
	}



	public BigDecimal getNoOfShares() {
		return noOfShares;
	}



	public void setNoOfShares(BigDecimal noOfShares) {
		this.noOfShares = noOfShares;
	}



	public String getDirection() {
		return direction;
	}



	public void setDirection(String direction) {
		this.direction = direction;
	}



	@Override
	public int hashCode() {
		return Objects.hash(direction, gain, instrument, noOfShares, price);
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
		return Objects.equals(direction, other.direction) && Objects.equals(gain, other.gain)
				&& Objects.equals(instrument, other.instrument) && Objects.equals(noOfShares, other.noOfShares)
				&& Objects.equals(price, other.price);
	}



	@Override
	public String toString() {
		return "Holding [price=" + price + ", gain=" + gain + ", noOfShares=" + noOfShares + ", direction=" + direction
				+ ", instrument=" + instrument + "]";
	}




	
	
}
