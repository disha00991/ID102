package com.hibernate.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernate.jpa.entity.Customer;
import com.hibernate.jpa.entity.Order;

public class CustomerRepositoryImpl implements CustomerRepository {
	
	private EntityManager entityManager;
	

	@Override
	public void save(Customer customer) {
		
         EntityTransaction trxn = entityManager.getTransaction();
		
		try {
		trxn.begin();
		entityManager.persist(customer);
		trxn.commit();
		
		}catch(Exception e) {
			trxn.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void update(Customer customer) {

		
EntityTransaction trxn = entityManager.getTransaction();
		
		try {
		trxn.begin();
		entityManager.merge(customer);
		trxn.commit();
		
		}catch(Exception e) {
			trxn.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public Customer find(long id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public List<Customer> findALL() {
		return entityManager.createQuery("from Customer").getResultList();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

}
