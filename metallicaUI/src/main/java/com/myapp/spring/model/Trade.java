package com.myapp.spring.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long tid;
	private String commodity;
	private Date date;
	private String side;
	private int qty;
	private int price;
	private String counterParty;
	private String location;
	private String status;
	
	public Trade() {
	
	}

	public Trade(String commodity, Date date, String side, int qty, int price, String counterParty, String location,
			String status) {
		
		this.commodity = commodity;
		this.date = date;
		this.side = side;
		this.qty = qty;
		this.price = price;
		this.counterParty = counterParty;
		this.location = location;
		this.status = status;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (tid ^ (tid >>> 32));
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
		if (tid != other.tid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trade [tid=");
		builder.append(tid);
		builder.append(", commodity=");
		builder.append(commodity);
		builder.append(", date=");
		builder.append(date);
		builder.append(", side=");
		builder.append(side);
		builder.append(", qty=");
		builder.append(qty);
		builder.append(", price=");
		builder.append(price);
		builder.append(", counterParty=");
		builder.append(counterParty);
		builder.append(", location=");
		builder.append(location);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
}
