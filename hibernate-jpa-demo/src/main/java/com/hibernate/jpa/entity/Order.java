package com.hibernate.jpa.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="new_my_orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID")
	private long id;
	
	@Column(name="ORDER_NUMBER",nullable=false)
	private String orderNumber;
	
	@Column(name="ORDER_TIME_PLACED",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeOrderPlaced;

	@Column(name="ORDER_LAST_UPDATE",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	@Column(name="ORDER_STATUS",nullable=false)
	private String status;
	
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ID",nullable=false,insertable=true,updatable=false)
	private Customer customer;
	
	public Order() {
		
	}

	public Order(String orderNumber, Date timeOrderPlaced, Date lastUpdate, String status) {
		super();
		this.orderNumber = orderNumber;
		this.timeOrderPlaced = timeOrderPlaced;
		this.lastUpdate = lastUpdate;
		this.status = status;
	
	}
 
	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getTimeOrderPlaced() {
		return timeOrderPlaced;
	}

	public void setTimeOrderPlaced(Date timeOrderPlaced) {
		this.timeOrderPlaced = timeOrderPlaced;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
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
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", orderNumber=");
		builder.append(orderNumber);
		builder.append(", timeOrderPlaced=");
		builder.append(timeOrderPlaced);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
	public void addCustomerToOrder(Customer customer) {
		if(customer == null) {
			return;
		}
		this.customer=customer;
		customer.getOrders().add(this);
	}
	
	
	
}
