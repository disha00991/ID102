package com.myapp.spring.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="all_flight_details")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "flightNo")
public class FlightDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FLIGHT_NO",nullable=false)
	private long flightNo;
	
	@Column(name="SOURCE_CITY",nullable=false)
	private String sourceCity;
	
	@Column(name="DESTINATION_CITY",nullable=false)
	private String destinationCity;
	
	@Column(name="DURATION",nullable=false)
	private double duration;
	
	@Column(name="FARE",nullable=false)
	private double fare;
	
	public FlightDetails() {
		
	}

	public FlightDetails(String sourceCity, String destinationCity, double duration, double fare) {
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.duration = duration;
		this.fare = fare;
	}

	public long getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(long flightNo) {
		this.flightNo = flightNo;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (flightNo ^ (flightNo >>> 32));
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
		FlightDetails other = (FlightDetails) obj;
		if (flightNo != other.flightNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FlightDetails [flightNo=");
		builder.append(flightNo);
		builder.append(", sourceCity=");
		builder.append(sourceCity);
		builder.append(", destinationCity=");
		builder.append(destinationCity);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", fare=");
		builder.append(fare);
		builder.append("]");
		return builder.toString();
	}
	
	

}
