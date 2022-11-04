package com.fidelity.model;

import java.math.BigDecimal;

public class HoldingReturn {
	private String symbol;
	private BigDecimal shares;
	private BigDecimal holdings;
	private String type;
	private BigDecimal price;
	private BigDecimal value;
	private BigDecimal gain;
	
	public HoldingReturn() {
		// TODO Auto-generated constructor stub
	}

	public HoldingReturn(String symbol, BigDecimal shares, BigDecimal holdings, String type, BigDecimal price,
			BigDecimal value, BigDecimal gain) {
		super();
		this.symbol = symbol;
		this.shares = shares;
		this.holdings = holdings;
		this.type = type;
		this.price = price;
		this.value = value;
		this.gain = gain;
	}

	public String getSymbol() {
		return symbol;
	}

	public BigDecimal getShares() {
		return shares;
	}

	public BigDecimal getHoldings() {
		return holdings;
	}

	public String getType() {
		return type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getValue() {
		return value;
	}

	public BigDecimal getGain() {
		return gain;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setShares(BigDecimal shares) {
		this.shares = shares;
	}

	public void setHoldings(BigDecimal holdings) {
		this.holdings = holdings;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public void setGain(BigDecimal gain) {
		this.gain = gain;
	}
	
	
	
}
