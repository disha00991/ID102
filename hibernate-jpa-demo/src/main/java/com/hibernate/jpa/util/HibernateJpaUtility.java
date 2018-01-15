package com.hibernate.jpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateJpaUtility {
	
	public static final String PERSISTENCE_NAME = "HIBERNATEJPA";
		
	public static EntityManagerFactory emf = null;
	
	public static EntityManagerFactory getFactory() {
		
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);//Lazy instantiation
		}
		
		return emf;
	}
	
	public static void closeEntryManagerFactory() {
		if(emf!=null)
			emf.close();//goes into detached state
	}
	
			

}
