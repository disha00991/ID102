package com.myapp.spring.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.myapp.spring.hibernate.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, isolation =Isolation.READ_COMMITTED,
	rollbackFor=HibernateException.class)
	public List<Order> findAll() {
		return em.createNamedQuery("OrderFindAll").getResultList();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation =Isolation.READ_COMMITTED)
	public void save(Order order) {
		
		em.persist(order);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation =Isolation.READ_COMMITTED)
	public void update(Order order) {
		em.merge(order);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation =Isolation.READ_COMMITTED)
	public Order findById(long id) {
		return em.find(Order.class, id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation =Isolation.READ_COMMITTED)
	public List<Order> findByON(String orderNumber) {
		TypedQuery<Order> query = em.createNamedQuery("OrderFindByOrderNumber", Order.class);
		query.setParameter("ORDER_NUMBER", orderNumber);
		return query.getResultList();
	}
	
}
