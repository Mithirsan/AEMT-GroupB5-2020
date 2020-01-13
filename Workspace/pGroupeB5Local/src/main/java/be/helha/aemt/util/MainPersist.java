package be.helha.aemt.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.aemt.entities.User;

public class MainPersist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pGroupeB5Local");
		EntityManager em = emf.createEntityManager();		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.persist(new User());
		
		tx.commit();
		
		em.close();
		emf.close();
	}

}
