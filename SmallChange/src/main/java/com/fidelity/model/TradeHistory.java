package com.fidelity.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public class TradeHistory {
	private String instrumentId;
	private BigDecimal quantity;
	private BigDecimal executionPrice;
	private String direction ;
	private String clientId;
	private String tradeId;
	private BigDecimal cashValue ;
	private Timestamp tradeTimestamp;
	
	public TradeHistory() {
		
	}
	public TradeHistory(String instrumentId, BigDecimal quantity, BigDecimal executionPrice, String direction,
			String clientId, String tradeId, BigDecimal cashValue, Timestamp tradeTimestamp) {
		
		if(instrumentId == null || clientId == null || tradeId == null || instrumentId.isEmpty() || clientId.isEmpty() || tradeId.isEmpty())
			throw new IllegalArgumentException("instument id,client id , trade id cannot be null or empty");
		
		this.instrumentId = instrumentId;
		this.quantity = quantity;
		this.executionPrice = executionPrice;
		this.direction = direction;
		this.clientId = clientId;
		this.tradeId = tradeId;
		this.cashValue = cashValue;
		this.tradeTimestamp = tradeTimestamp;
	}
	public String getInstrumentId() {
		return instrumentId;
	}
	public void setInstrumentId(String instrumentId) {
		if(instrumentId == null || instrumentId.isEmpty())
			throw new IllegalArgumentException("instrument id cannot be null");
		this.instrumentId = instrumentId;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getExecutionPrice() {
		return executionPrice;
	}
	public void setExecutionPrice(BigDecimal executionPrice) {
		this.executionPrice = executionPrice;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		
		if(clientId == null)
			throw new IllegalArgumentException("client id cannot be null");
		this.clientId = clientId;
	}
	public String getTradeId() {
		if(tradeId == null)
			throw new IllegalArgumentException("trade id cannot be null");
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		if(tradeId == null)
			throw new IllegalArgumentException("trade id cannot be null");
		this.tradeId = tradeId;
	}
	public BigDecimal getCashValue() {
		return cashValue;
	}
	public void setCashValue(BigDecimal cashValue) {
		this.cashValue = cashValue;
	}
	public Timestamp getTradeTimestamp() {
		return tradeTimestamp;
	}
	public void setTradeTimestamo(Timestamp tradeTimestamp) {
		this.tradeTimestamp = tradeTimestamp;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cashValue, clientId, direction, executionPrice, instrumentId, quantity, tradeId,
				tradeTimestamp);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeHistory other = (TradeHistory) obj;
		return Objects.equals(cashValue, other.cashValue) && Objects.equals(clientId, other.clientId)
				&& Objects.equals(direction, other.direction) && Objects.equals(executionPrice, other.executionPrice)
				&& Objects.equals(instrumentId, other.instrumentId) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(tradeId, other.tradeId) && Objects.equals(tradeTimestamp, other.tradeTimestamp);
	}
	@Override
	public String toString() {
		return "TradeHistory [instrumentId=" + instrumentId + ", quantity=" + quantity + ", executionPrice="
				+ executionPrice + ", direction=" + direction + ", clientId=" + clientId + ", tradeId=" + tradeId
				+ ", cashValue=" + cashValue + ", tradeTimestamp=" + tradeTimestamp + "]";
	}
	
	
}
