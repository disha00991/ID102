package com.metallica.refdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	
	@Id
	private String name;
	private String symbol;
	
	public Location() {
	
	}
	public Location(String name, String symbol) {
		super();
		this.name = name;
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Location [name=");
		builder.append(name);
		builder.append(", symbol=");
		builder.append(symbol);
		builder.append("]");
		return builder.toString();
	}
}
