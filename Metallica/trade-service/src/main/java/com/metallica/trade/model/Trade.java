package com.metallica.trade.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Trade {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private Side side;

	@Enumerated(EnumType.STRING)
	private TradeStatus status;
	
	@Temporal(TemporalType.DATE)
	private Date tradeDate;
	
	private double quantity;
	private double price;
	private String commodity;
	private String location;
	private String counterparty;
	private long trader;

	public Trade() {
		// TODO Auto-generated constructor stub
	}

	public Trade(Side side, double quantity, double price, Date date, TradeStatus status, String commodity,
			String location, String counterparty, long trader) {
		super();
		this.side = side;
		this.quantity = quantity;
		this.price = price;
		this.tradeDate = date;
		this.status = status;
		this.commodity = commodity;
		this.location = location;
		this.counterparty = counterparty;
		this.trader = trader;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date date) {
		this.tradeDate = date;
	}

	public TradeStatus getStatus() {
		return status;
	}

	public void setStatus(TradeStatus status) {
		this.status = status;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCounterparty() {
		return counterparty;
	}

	public void setCounterparty(String counterparty) {
		this.counterparty = counterparty;
	}

	public long getTrader() {
		return trader;
	}

	public void setTrader(long trader) {
		this.trader = trader;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + (int) (trader ^ (trader >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (id != other.id)
			return false;
		if (side != other.side)
			return false;
		if (status != other.status)
			return false;
		if (trader != other.trader)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trade [id=");
		builder.append(id);
		builder.append(", side=");
		builder.append(side);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", price=");
		builder.append(price);
		builder.append(", date=");
		builder.append(tradeDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", commodity=");
		builder.append(commodity);
		builder.append(", location=");
		builder.append(location);
		builder.append(", counterparty=");
		builder.append(counterparty);
		builder.append(", trader=");
		builder.append(trader);
		builder.append("]");
		return builder.toString();
	}	
		
}
