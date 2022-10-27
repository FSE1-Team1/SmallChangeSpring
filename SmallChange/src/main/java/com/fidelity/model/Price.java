package com.fidelity.model;





import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;





public class Price {
    
    private BigDecimal bidPrice;
    private BigDecimal askPrice;
    private LocalDate timeStamp;
    private String instrumentId;






  public Price() {
    }









public Price(BigDecimal bidPrice, BigDecimal askPrice, LocalDate timeStamp, String instrumentId) {
        super();
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.timeStamp = timeStamp;
        this.instrumentId = instrumentId;
    }





public BigDecimal getBidPrice() {
        return bidPrice;
    }





public BigDecimal getAskPrice() {
        return askPrice;
    }





public LocalDate getTimeStamp() {
        return timeStamp;
    }





public String getInstrumentId() {
        return instrumentId;
    }





@Override
public int hashCode() {
    return Objects.hash(askPrice, bidPrice, instrumentId, timeStamp);
}





@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Price other = (Price) obj;
    return Objects.equals(askPrice, other.askPrice) && Objects.equals(bidPrice, other.bidPrice)
            && Objects.equals(instrumentId, other.instrumentId) && Objects.equals(timeStamp, other.timeStamp);
}





@Override
public String toString() {
    return "Price [bidPrice=" + bidPrice + ", askPrice=" + askPrice + ", timeStamp=" + timeStamp + ", instrumentId="
            + instrumentId + "]";
}
}